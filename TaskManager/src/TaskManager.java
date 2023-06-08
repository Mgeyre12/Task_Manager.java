import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private ArrayList<Task> tasks;

    // Constructor
    public TaskManager() {
        tasks = new ArrayList<>();
    }

    // Other methods go here
    public void addTask(Task task) {
        // Is Task Null?
        if (task != null) {
            // Does Task Exist?
            if (!tasks.contains(task)) {
                tasks.add(task);
                System.out.println("Task added successfully.");
            } else {
                System.out.println("Task already exists!");
            }
        } else {
            System.out.println("Invalid task! Task cannot be null.");
        }
    }

    // Start Delete task
    public void deleteTask(String identifier) {
        if (identifier != null) {
            // Iterate over the tasks list
            for (Task task : tasks) {
                // Check if the task matches the identifier
                if (task.getIdentifier().equals(identifier)) {
                    // Remove the task from the tasks list
                    tasks.remove(task);
                    System.out.println("Task deleted successfully.");
                    return; // Exit the method after deleting the task
                }
            }
            // Handle case when no matching task is found
            System.out.println("Task not found.");
        } else {
            System.out.println("Task cannot be null");
        }
    }

    public Task getTask(String identifier) {
        if (identifier != null) {
            for (Task task : tasks) {
                if (task.getIdentifier().equals(identifier)) {
                    return task;
                }
            }
            // Handles case when no matching task is found
            System.out.println("Task not found.");
        } else {
            // Handles case when identifier is null
            System.out.println("Task identifier cannot be null.");
        }
        return null; // Return null if no task is found
    }

    public void updateTask(String identifier, Task updatedTask) {
        if (identifier != null) {
            for (Task task : tasks) {
                if (task.getIdentifier().equals(identifier)) {
                    task.setTitle(updatedTask.getTitle());
                }
            }
        } else {
            System.out.println("Task identifier cannot be null.");
        }
    }

    public List<Task> getAllTasks() {
        List<Task> allTasks = new ArrayList<>();
        for (Task task : tasks) {
            allTasks.add(task);
        }
        return allTasks;
    }

    public int getTaskCount() {
        return tasks.size();
    }

    public void printAllTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void clearTasks() {
        tasks.clear();
    }

    public void markTaskAsComplete(String identifier) {
        // Iterate over the tasks list
        for (Task task : tasks) {
            // Check if the task matches the identifier
            if (task.getIdentifier().equals(identifier)) {
                // Update the status of the task to indicate completion
                // You need to implement the necessary setter method in the Task class
                task.setCompleted(true);
                // Print a message to indicate successful completion
                System.out.println("Task marked as complete.");
                return;
            }
        }
        // Handle case when no matching task is found
        System.out.println("Task not found.");
    }

    public List<Task> getCompletedTasks() {
        List<Task> completedTasks = new ArrayList<>();

        for (Task task : tasks) {
            if (task.isCompleted()) {
                completedTasks.add(task);
            }
        }
        return completedTasks;
    }

    public List<Task> getIncompleteTasks() {
        List<Task> incompleteTasks = new ArrayList<>();

        for (Task task : tasks) {
            if (!task.isCompleted()) {
                incompleteTasks.add(task);
            }
        }
        return incompleteTasks;
    }

    public void printCompletedTasks() {
        for (Task task : tasks) {
            if (task.isCompleted()) {
                System.out.println("Title: " + task.getTitle());
                System.out.println("Description: " + task.getDescription());
                // Print any other details you want to display for each completed task
                System.out.println("---------------------------");
            }
        }
    }

    public void printIncompleteTasks() {
        for (Task task : tasks) {
            if (!task.isCompleted()) {
                System.out.println("Title: " + task.getTitle());
                System.out.println("Description: " + task.getDescription());
                System.out.println("---------------------------");
            }
        }
    }
}


