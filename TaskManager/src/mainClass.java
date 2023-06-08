import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class mainClass {
    public static void main(String[] args) throws ParseException {
        TaskManager taskManager = new TaskManager();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                // Display the menu
                System.out.println("Task Manager Menu");
                System.out.println("1. Add Task");
                System.out.println("2. Delete Task");
                System.out.println("3. Get Task");
                System.out.println("4. Update Task");
                System.out.println("5. Get All Tasks");
                System.out.println("6. Get Task Count");
                System.out.println("7. Print All Tasks");
                System.out.println("8. Clear Tasks");
                System.out.println("9. Mark Task as Complete");
                System.out.println("10. Get Completed Tasks");
                System.out.println("11. Get Incomplete Tasks");
                System.out.println("12. Print Completed Tasks");
                System.out.println("13. Print Incomplete Tasks");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");

                String choice = scanner.nextLine();

                switch (choice) {
                    case "0":
                        // Exit the program
                        System.out.println("Exiting...");
                        return;
                    case "1":
                        // Add Task
                        System.out.print("Enter task title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter task dueDate (dd MM yyyy):");
                        String dueDate = scanner.nextLine();
                        Task task = new Task();
                        task.setTitle(title);
                        task.setDescription(description);
                        DateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
                        task.setDueDate(formatter.parse(dueDate));
                        taskManager.addTask(task);
                        break;
                    case "2":
                        // Delete Task
                        System.out.print("Enter the identifier of the task to delete: ");
                        String deleteIdentifier = scanner.nextLine();
                        taskManager.deleteTask(deleteIdentifier);
                        break;
                    case "3":
                        // Get Task
                        System.out.print("Enter the identifier of the task to get: ");
                        String getIdentifier = scanner.nextLine();
                        Task retrievedTask = taskManager.getTask(getIdentifier);
                        if (retrievedTask != null) {
                            System.out.println("Task found: " + retrievedTask);
                        }
                        break;
                    case "4":
                        // Update Task
                        System.out.print("Enter the identifier of the task to update: ");
                        String updateIdentifier = scanner.nextLine();
                        Task existingTask = taskManager.getTask(updateIdentifier);
                        if (existingTask != null) {
                            System.out.print("Enter new task title: ");
                            String newTitle = scanner.nextLine();
                            System.out.print("Enter new task description: ");
                            String newDescription = scanner.nextLine();
                            Task updatedTask = new Task();
                            updatedTask.setTitle(newTitle);
                            updatedTask.setDescription(newDescription);
                            taskManager.updateTask(updateIdentifier, updatedTask);
                            System.out.println("Task updated successfully.");
                        }
                        break;
                    case "5":
                        // Get All Tasks
                        System.out.println("All tasks:");
                        for (Task t : taskManager.getAllTasks()) {
                            System.out.println(t);
                        }
                        break;
                    case "6":
                        // Get Task Count
                        int taskCount = taskManager.getTaskCount();
                        System.out.println("Task count: " + taskCount);
                        break;
                    case "7":
                        // Print All Tasks
                        taskManager.printAllTasks();
                        break;
                    case "8":
                        // Clear Tasks
                        taskManager.clearTasks();
                        System.out.println("All tasks cleared.");
                        break;
                    case "9":
                        // Mark Task as Complete
                        System.out.print("Enter the identifier of the task to mark as complete: ");
                        String completeIdentifier = scanner.nextLine();
                        taskManager.markTaskAsComplete(completeIdentifier);
                        break;
                    case "10":
                        // Get Completed Tasks
                        System.out.println("Completed tasks:");
                        for (Task t : taskManager.getCompletedTasks()) {
                            System.out.println(t);
                        }
                        break;
                    case "11":
                        // Get Incomplete Tasks
                        System.out.println("Incomplete tasks:");
                        for (Task t : taskManager.getIncompleteTasks()) {
                            System.out.println(t);
                        }
                        break;
                    case "12":
                        // Print Completed Tasks
                        System.out.println("Completed tasks:");
                        taskManager.printCompletedTasks();
                        break;
                    case "13":
                        // Print Incomplete Tasks
                        System.out.println("Incomplete tasks:");
                        taskManager.printIncompleteTasks();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
                System.out.println(); // Add a new line for clarity
            }
        }
    }
}
