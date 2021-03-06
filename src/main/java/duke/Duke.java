package duke;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Represents an interactive bot to handle tasks.
 */
public class Duke {
    /** Storage handles load to/from saved file. */
    private Storage storage;
    /** Ui handles user interaction. */
    private Ui ui;
    /** A list that contains tasks. */
    @SuppressWarnings("CanBeFinal")
    private TaskList lst = new TaskList();

    /** Empty constructor. */
    public Duke() { }

    /** Constructor with a valid file path.
     * @param filePath the file path
     */
    public Duke(Path filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
    }

    /**
     *  Returns the task list used in duke.
     *  @return TaskList lst
     */
    public TaskList getLst() {
        return lst;
    }

    /**
     *  Executes set up environment (load from file),
     *  run, and clean up (load to file).
     *  Duke's main working function
     */
    public void run() throws IOException {
        start();
        uiRun();
        end();
    }

    /**
     *  Initialises task list from saved file.
     */
    public void start() throws IOException {
        storage.writeToList(lst);
    }

    /**
     *  Saves task list to saved file.
     */
    public void end() throws IOException {
        storage.writeToFile(lst);
    }

    /**
     *  Handles user & duke interaction.
     */
    public void uiRun() {
        ui.run(lst);
    }
}
