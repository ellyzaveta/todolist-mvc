package view;

import model.data.Task;
import model.data.TaskStatus;

import javax.swing.*;
import java.util.Scanner;

public class TodoViewConsole {

    private final Scanner scanner;

    public TodoViewConsole() {
        this.scanner = new Scanner(System.in);
        System.out.println("\nTo-Do List");
    }

    public int getMainMenuChoice() {
        System.out.println("1 - add task  2 - delete task  3 - update task status  4 - exit");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public String getTaskDescription() {
        System.out.println();
        System.out.print("Enter task description: ");
        return scanner.nextLine();
    }

    public int getTaskIndex() {
        System.out.println();
        System.out.print("Enter task index: ");
        return scanner.nextInt();
    }

    public void displayTasks(DefaultListModel<Task> tasks) {
        System.out.println();

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(getStatus(tasks.get(i)) + " " + (i + 1) + " | " + tasks.get(i));
        }

        System.out.println();
    }

    public String getStatus(Task task) {
        if (task.getStatus() == TaskStatus.DONE) {
            return "\uD83D\uDFE2";
        } else if (task.getStatus() == TaskStatus.IN_PROGRESS) {
            return "\uD83D\uDFE1";
        } else {
            return "\uD83D\uDD34";
        }
    }

    public void showInvalidChoiceMessage() {
        System.out.println("Invalid choice. Please try again.");
    }

    public void showInvalidTaskIndexMessage() {
        System.out.println("Invalid task index.");
    }

    public void showInvalidTaskDescriptionMessage() {
        System.out.println("Invalid task description.");
    }
}

