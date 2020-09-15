package duke;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * Represents a user interface and deals with interactions
 * with the user
 */
public class Ui {
    public void run(TaskList lst) {
        // set up greetings and old list from file
        LocalDate today = LocalDate.now();
        String messageHello = Parser.format("Hello! I'm Duke - your personal " +
                "task manager\n" + "      " + "Today is " + today
                .format(DateTimeFormatter.ofPattern("MMM d yyyy")) + "\n      " +
                "Last login was " + TaskList.lastLoginDate.format(DateTimeFormatter
                .ofPattern("MMM d yyyy")) + "\n      " + "You have done " +
                TaskList.numberOfDoneTasks + " task(s) in the past week." +
                "\n      Keep up the good work!!!");

        // reset done-task-counter if today is SUNDAY or
        // there was a SUNDAY between last login date and today (exclusive)
        LocalDate dateIterator = TaskList.lastLoginDate.plus(1, ChronoUnit.DAYS);
        System.out.println(dateIterator);
        while (dateIterator.isBefore(today)) {
            if (today.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                TaskList.numberOfDoneTasks = 0;
                break;
            }
            if (dateIterator.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                TaskList.numberOfDoneTasks = 0;
                break;
            }
            dateIterator = dateIterator.plus(1, ChronoUnit.DAYS);
        }



        System.out.println(messageHello);
        System.out.println(new Parser("list").getRespond(lst));

        // set up scanner for interaction
        Scanner scanner = new Scanner(System.in);
        // hand over to Parser class to handle all commands
        while (scanner.hasNextLine()) {
            String currentCommand = scanner.nextLine();
            System.out.println(new Parser(currentCommand).getRespond(lst));
            if (currentCommand.equals("bye")) {
                scanner.close();
                return;
            }
        }
    }

}
