package storege;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Repository {
  private final Path filePath;

  public Repository(String filename) { this.filePath = Path.of(filename); }

  public void push(List<String> lines) {
    try {
      // Create a new modifiable list
      List<String> allLines = new ArrayList<>();

      // Add existing content if available
      List<String> existingLines = pull();
      if (existingLines != null) {
        allLines.addAll(existingLines);
      }

      // Add new lines
      allLines.addAll(lines);

      // Write to file
      Files.write(filePath, allLines, StandardOpenOption.CREATE,
                  StandardOpenOption.TRUNCATE_EXISTING);
    } catch (IOException e) {
      System.err.println("Failed to write to file: " + e.getMessage());
    }
  }

  public List<String> pull() {
    try {
      if (!Files.exists(filePath)) {
        return null;
      }
      return Files.readAllLines(filePath);
    } catch (IOException e) {
      System.err.println("Failed to read file: " + e.getMessage());
      return null;
    }
  }

  public List<Integer> getIds() {
    List<String> lines = pull();
    List<Integer> ids = new ArrayList<>();

    for (String line : lines) {
      if (line == null || line.trim().isEmpty()) {
        continue; // Skip empty lines
      }

      try {
        String idAsString = line.split(" ")[0];
        int id = Integer.parseInt(idAsString);
        ids.add(id);
      } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
        // Handle lines that don't contain valid IDs
        System.err.println("Skipping invalid line: " + line);
      }
    }

    return ids;
  }

  public void delete(int id) {
    List<String> lines = pull();
    if (lines == null) {
      return; // Nothing to delete if file doesn't exist
    }

    boolean modified = false;
    Iterator<String> iterator = lines.iterator();

    while (iterator.hasNext()) {
      String line = iterator.next();
      if (line == null || line.trim().isEmpty()) {
        continue;
      }

      try {
        String[] parts = line.split(" ");
        int idAsInt = Integer.parseInt(parts[0]);
        if (idAsInt == id) {
          iterator.remove();
          modified = true;
        }
      } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
        System.err.println("Skipping invalid line: " + line);
      }
    }

    if (modified) {
      try {
        Files.write(filePath, lines, StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
      } catch (IOException e) {
        System.err.println("Failed to update file after deletion: " +
                           e.getMessage());
      }
    }
  }
}
