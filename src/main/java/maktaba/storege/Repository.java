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
}
