package storege;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
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
    for (String line : lines) {
      if (line == null || line.trim().isEmpty()) {
        continue; // Skip empty lines
      }

      try {
        String[] parts = line.split(" ");
        String idAsString = parts[0];
        int idAsInt = Integer.parseInt(idAsString);
        if (idAsInt == id) {
          // int id, String title, BookType type, String author, boolean state
          lines.remove(line);
          // i let it keep going to clean up the repated ids
        }
      } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
        // Handle lines that don't contain valid IDs
        System.err.println("Skipping invalid line: " + line);
      }
    }
  }
}
