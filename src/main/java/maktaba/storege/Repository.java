package storege;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Repository {
  private final Path filePath;

  public Repository(String filename) {
    this.filePath = Path.of(filename);
  }

  public void push(List<String> lines) {
    try {
      Files.write(filePath, lines, StandardOpenOption.CREATE,
          StandardOpenOption.TRUNCATE_EXISTING);
    } catch (IOException e) {
      System.err.println("Failed to write to file: " + e.getMessage());
    }
  }

  public String pull() {
    try {
      if (!Files.exists(filePath)) {
        return null;
      }
      return String.join("\n", Files.readAllLines(filePath));
    } catch (IOException e) {
      System.err.println("Failed to read file: " + e.getMessage());
      return null;
    }
  }
}
