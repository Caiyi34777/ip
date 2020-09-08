import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents methods to manipulate with formats, e.g. dates
 */

public class Converter {
    /**
     * Returns a formatted string transforming from "/at" to ":(at)"
     * The input string must contain "/at"
     *
     * @param s input string
     * @return a formatted string
     */
    static String at(String s) {
        String first = s.split("/at ")[0];
        String second = s.split("/at ")[1];
        LocalDate date = LocalDate.parse(second);
        return first + "(at: " + date.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }

    /**
     * Returns a formatted string transforming from "/by" to ":(by)"
     * The input string must contain "/by"
     *
     * @param s input string
     * @return a formatted string
     */
    static String by(String s) {
        String first = s.split("/by ")[0];
        String second = s.split("/by ")[1];
        LocalDate date = LocalDate.parse(second);
        return first + "(by: " + date.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }

    /**
     * Returns a Task object specified by the input string
     *
     * @param s input message string
     * @return a Task object
     * @throws IllegalArgumentException  If taskType can not be detected correctly
     */
    static Task add(String s) throws IllegalTaskTypeException {
        String taskType = s.split(" ; ")[0];
        String isDone = s.split(" ; ")[1];
        String message = s.split(" ; ")[2];
        // use for test purposes
        /*System.out.println(taskType);
        System.out.println(isDone);
        System.out.println(message);*/

        if (taskType.equals("T")) {
            return new Todo(message, getStatus(Integer.parseInt(isDone)));
        } else if (taskType.equals("E")) {
            return new Event(message, getStatus(Integer.parseInt(isDone)));
        } else if (taskType.equals("D")) {
            return new Deadline(message, getStatus(Integer.parseInt(isDone)));
        } else {
            throw new IllegalTaskTypeException();
        }
    }

    /**
     * Returns a boolean status from an integer representation
     *
     * @param i  a number to denote false or true (0 for false, 1 for true)
     *           here, we assume the input number is correct
     * @return boolean status
     */
    static boolean getStatus(int i) {
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }
}
