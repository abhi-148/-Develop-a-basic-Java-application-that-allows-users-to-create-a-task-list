import java.util.ArrayList;
import java.util.Scanner;

class TaskListApplication{
    private ArrayList<String> taskList;
    private Scanner scanner;

    public TaskListApplication() {
        taskList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Task List Application");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. List Tasks");
        System.out.println("4. Exit");
    }

    public void addTask() {
        System.out.println("Enter task description:");
        String taskDescription = scanner.nextLine();
        taskList.add(taskDescription);
        System.out.println("Task added successfully!");
    }

    public void removeTask() {
        if (taskList.isEmpty()) {
            System.out.println("Task list is empty. No tasks to remove.");
        } else {
            System.out.println("Enter task number to remove:");
            int taskNumber = Integer.parseInt(scanner.nextLine());

            if (taskNumber >= 1 && taskNumber <= taskList.size()) {
                String removedTask = taskList.remove(taskNumber - 1);
                System.out.println("Task removed: " + removedTask);
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }

    public void listTasks() {
        if (taskList.isEmpty()) {
            System.out.println("Task list is empty.");
        } else {
            System.out.println("Task List:");
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println((i + 1) + ". " + taskList.get(i));
            }
        }
    }

    public static void main(String[] args) {
        TaskListApplication taskApp = new TaskListApplication();
        int choice;

        do {
            taskApp.displayMenu();
            System.out.println("Enter your choice (1-4):");
            choice = Integer.parseInt(taskApp.scanner.nextLine());

            switch (choice) {
                case 1:
                    taskApp.addTask();
                    break;
                case 2:
                    taskApp.removeTask();
                    break;
                case 3:
                    taskApp.listTasks();
                    break;
                case 4:
                    System.out.println("Exiting Task List Application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    break;
            }
        } while (choice != 4);

        taskApp.scanner.close();
    }
}
