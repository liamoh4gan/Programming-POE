package za.edu.vcconnect.st10093235.poe;

import java.util.HashSet;
import java.util.Set;


public class Task {
    //Declare variables
    String taskName;
    int taskNumber;
    String taskDescription;
    String developerDetails;
    TaskStatus taskStatus;
    float taskDuration;
    String taskId;
    public static Set<Task> savedTasks = new HashSet<>();

    public Task(){

    }
//init constructor
    public Task(String taskName, int taskNumber, String taskDescription, String developerDetails, float taskDuration, String taskId, TaskStatus taskStatus){

        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskId = taskId;
        this.taskStatus = taskStatus;

    }

//setters and getters
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }



    public int getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }



    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }



    public String getDeveloperDetails() {
        return developerDetails;
    }

    public void setDeveloperDetails(String developerDetails) {
        this.developerDetails = developerDetails;
    }



    public float getTaskDuration() {
        return taskDuration;
    }

    public void setTaskDuration(float taskDuration) {
        this.taskDuration = taskDuration;
    }



    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }



    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }


    public static boolean checkTaskDescription(String description){

        if (description.length() > 50) {
            return false;
        }else {
            return true;
        }

    }
    public String printTaskDetails(){

        return "Task name: " + this.getTaskName() + "\ntaskNumber: " + this.getTaskNumber() + "\ntaskDescription: " + this.getTaskDescription() + "\ndeveloperDetails: " + this.getDeveloperDetails() + "\ntaskDuration: " + this.getTaskDuration() + "\ntaskID: " + this.getTaskId() + "\ntaskStatus: " + this.getTaskStatus().toString();

    }
    public float returnTotalHours(){
        float totalHours = 0;

        for (Task task : savedTasks){
            totalHours = totalHours + task.getTaskDuration();

        }
        return totalHours;
    }
}
