
import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<String> tasks = new ArrayList<>();
    
    public TaskManager() {
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public void deleteTask(String task) {
        tasks.remove(task);
    }

    public void editTask(String oldTask, String newTask) {
        int index = tasks.indexOf(oldTask);
        if (index != -1) {
            tasks.set(index, newTask);
        }
    }


    public List<String> getTasks() {
        return tasks;
    }

}


    
