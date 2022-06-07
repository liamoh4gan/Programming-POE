package za.edu.vcconnect.st10093235.poe;

import java.util.StringTokenizer;

public class Task {
    String taskName;
    int taskNumber;
    String taskDescription;
    String developerDetails;
    TaskStatus taskStatus;
    float taskDuration;
    String taskId;

    public Task(){

    }

    public Task(String taskName, int taskNumber, String taskDescription, String developerDetails, float taskDuration, String taskId, TaskStatus taskStatus){

        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskId = taskId;
        this.taskStatus = taskStatus;

    }


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



}
