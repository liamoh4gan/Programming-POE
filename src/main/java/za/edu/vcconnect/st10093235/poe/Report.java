package za.edu.vcconnect.st10093235.poe;

import java.util.Arrays;
import java.util.Scanner;

public class Report {
     String[]  developers,taskNames, taskIDs;
     Float[] taskDurations;
     TaskStatus[] taskStatuses;

    Report(String[] developers,String[] taskNames,String[] taskIDs,Float[] taskDurations,TaskStatus[] taskStatuses){
            this.developers=developers;
            this.taskNames=taskNames;
            this.taskIDs=taskIDs;
            this.taskDurations=taskDurations;
            this.taskStatuses=taskStatuses;

    }
    //Menu
    public void menu(){

        while(true) {
            System.out.println();
            System.out.println("a.Status Done");
            System.out.println("b.Longest Duration");
            System.out.println("c.Search for a task");
            System.out.println("d.Search for all tasks assigned to developer");
            System.out.println("e.Delete a task");
            System.out.println("f.Display Report");
            System.out.println("g.Exit");
            System.out.println("Enter your choice : ");

            Scanner input = new Scanner(System.in);
            String op=input.next();
            input.nextLine();
            switch (op) {
                case "a":
                    displayStatusDoneTasks();
                    break;
                case "b":
                    displayLongestDuration();
                    break;
                case "c":
                    System.out.println("Enter task name");
                    String taskname=input.nextLine();
                    searchTask(taskname);
                    break;

                case "d":
                    System.out.println("Enter developer name");
                    searchTaskAssignedtoDeveloper(input.nextLine());
                    break;

                case "e":
                    System.out.println("Enter task name");
                    deleteTask(input.nextLine());
                    break;
                case "f":
                    displayFullDetails();
                    break;
                case "g":
                    return;
                default:
                    System.out.println("Invalid choice try again");
            }
        }

    }


    //Status Done task
    public void displayStatusDoneTasks(){
        System.out.println("Developer\t\tTask Name\t\tTask Duration");
        for (int i=0;i<taskStatuses.length;i++){
            if(taskStatuses[i].toString()=="DONE")
                System.out.println(developers[i]+"\t\t"+taskNames[i]+"\t\t"+taskDurations[i]);
        }
     }
     //Display max duration
    public void displayLongestDuration(){
        float max = taskDurations[0];
        int index=0;
        for (int i = 1; i < taskDurations.length; i++)
            if (taskDurations[i] > max) {
                max = taskDurations[i];
                index=i;
            }

        System.out.println("Developer Name\t\tDuration");
        System.out.println(developers[index]+"\t\t"+max);

    }

    //Search specific task
    public void searchTask(String taskname){
        System.out.println("Task Name\t\tDeveloper\t\tTask Status");
        boolean check=true;
        for (int i=0;i<taskNames.length;i++) {
            if (taskNames[i].equals(taskname)) {
                System.out.println(taskname + "\t\t" + developers[i] + "\t\t" + taskStatuses[i]);
                check=false;
            }
        }
        if(check)
            System.out.println("No given taskname exist");
    }


    //Search assigned task
    public void searchTaskAssignedtoDeveloper(String developer){
        System.out.println("Task Name\t\tTask Status");
        boolean check=true;
        for (int i=0;i<developers.length;i++) {
            if (developers[i].equals(developer)) {
                System.out.println(taskNames[i] + "\t\t" + taskStatuses[i]);
                check=false;
            }
        }
        if(check)
            System.out.println("No given developer exist");
    }

    //shift data into new arrays for deletion
    public void shiftData(int index){
        String[]  new_developers,new_taskNames, new_taskIDs;
        Float[] new_taskDurations;
        TaskStatus[] new_taskStatuses;
        //task is deleted so length will be decreased for all arrays
        int size=developers.length-1;
            //initilize variables
        new_developers=new String[size];
        new_taskNames=new String[size];
        new_taskIDs=new String[size];
        new_taskDurations=new Float[size];
        new_taskStatuses=new TaskStatus[size];


        for (int i=0;i<developers.length;i++){
            if(i!=index) {
                new_developers[i] = developers[i];
                new_taskNames[i]=taskNames[i];
                new_taskIDs[i]=taskIDs[i];
                new_taskDurations[i]=taskDurations[i];
                new_taskStatuses[i]=taskStatuses[i];
            }
        }

        developers=new_developers;
        taskNames=new_taskNames;
        taskIDs=new_taskIDs;
        taskDurations=new_taskDurations;
        taskStatuses=new_taskStatuses;

    }



    //Delete the task
    public void deleteTask(String taskname){
        boolean check=true;
        for (int i=0;i<taskNames.length;i++) {
            if (taskNames[i].equals(taskname)) {
                shiftData(i);  //Shifting elements to delete item
                System.out.println(taskname+" has been deleted");
                check=false;
            }
        }
        if(check)
            System.out.println("No given taskname exist");
    }

    //Display all details of each task
    public void displayFullDetails(){
        System.out.println("Developer\t\tTask Name\t\tTask ID\t\tTask Duration\t\tTask Status");
        for (int i=0;i<developers.length;i++)
            System.out.println(developers[i]+"\t\t"+taskNames[i]+"\t\t"+taskIDs[i]+"\t\t"+taskDurations[i]+"\t\t"+taskStatuses[i]);


    }


}
