package cli;

/**
 * cli the interface for the command line commands
 */
public class Cli {
  private String APP_NAME = "maktaba";

  public String name;
  public String description;
  public String[] subCommands;

  public String name() { return this.name; }

  public String description() { return this.description; }

  public void usage() {
    System.out.println(this.description);
    System.out.println("usage: " + APP_NAME + this.name + " [options]");

    System.out.println("options:");
    for (String subCommand : this.subCommands) {
      System.out.println("  " + subCommand);
    }
  }

  public interface Command {
    void run();
  }
}
