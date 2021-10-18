package com.company;

import java.util.*;

class Student {
    private String studentName;
    private int studentID;

}
class Instructor{
    private String instructorName;
    private int instructorID;
}
class Slides implements View{
    private String topicOfSlides;
    private ArrayList<String> contentOfSlides;
    private String timeOfAddSlide;

    public Slides(String topicOfSlides, ArrayList<String> contentOfSlides, String timeOfAddSlide) {
        this.topicOfSlides = topicOfSlides;
        this.contentOfSlides = contentOfSlides;
        this.timeOfAddSlide = timeOfAddSlide;
    }

    public String getTopicOfSlides() {
        return topicOfSlides;
    }

    public ArrayList<String> getContentOfSlides() {
        return contentOfSlides;
    }

    public String getTimeOfAddSlide() {
        return timeOfAddSlide;
    }
    @Override
    public void view(){
        this.getTopicOfSlides();
        this.getContentOfSlides();
        this.getTimeOfAddSlide();
    }


}

class Video implements View {
    private String topicOfVideo;
    private String fileName;
    private String timeOfAddVideo;

    public Video(String topicOfVideo, String fileName, String timeOfAddVideo) {
        this.topicOfVideo = topicOfVideo;
        this.fileName = fileName;
        this.timeOfAddVideo = timeOfAddVideo;
    }

    public String getTopicOfVideo() {
        return topicOfVideo;
    }

    public String getFileName() {
        return fileName;
    }

    public String getTimeOfAddVideo() {
        return timeOfAddVideo;
    }

    @Override
    public void view(){
        this.getTopicOfVideo();
        this.getFileName();
        this.getTimeOfAddVideo();
    }
}

class LectureMaterial {


}

class assessmentMaterial{

}

class Comments{ //it would contain instructor or student ID, the comment, and time stamp

}

interface View{
    public void view(); //will help us view the required functions
}

public class Main {
    private static ArrayList<Student> studentList = new ArrayList<Student>();
    private static ArrayList<Instructor> instructorList = new ArrayList<Instructor>();
    private static ArrayList<Slides> slideList = new ArrayList<Slides>();
   private static ArrayList<Video> videoList = new ArrayList<Video>();

    static void printMenu(int printOption){
        switch(printOption){
            case 1 :
                System.out.println("Welcome to Backpack\n" +
                        "1. Enter as instructor\n" +
                        "2. Enter as student\n" +
                        "3. Exit");
                break;
            case 2 :
                System.out.println("INSTRUCTOR MENU\n" +
                        "1. Add class material\n" +
                        "2. Add assessments\n" +
                        "3. View lecture materials\n" +
                        "4. View assessments\n" +
                        "5. Grade assessments\n" +
                        "6. Close assessment\n" +
                        "7. View comments\n" +
                        "8. Add comments\n" +
                        "9. Logout");
                break;
            case 3:
                System.out.println("STUDENT MENU\n" +
                        "1. View lecture materials\n" +
                        "2. View assessments\n" +
                        "3. Submit assessment\n" +
                        "4. View grades\n" +
                        "5. View comments\n" +
                        "6. Add comments\n" +
                        "7. Logout");
                break;
        }
    }


    static void instructorMenu (){
        boolean instructorCondition = true;
        while(instructorCondition){
            Scanner scan = new Scanner(System.in);
            int instructorID = scan.nextInt();
            //print option for instructor ID to choose from
            int instructorOption = scan.nextInt();
            printMenu(2);
            switch (instructorOption){
                case 1 : //Add class material
                    ArrayList<String> tempContentArrayList = new ArrayList<String>();
                    System.out.println("1. Add Lecture Slide\n" +
                            "2. Add Lecture Video");
                    int lectureMaterial = scan.nextInt();
                    switch (lectureMaterial){
                        case 1: //add lecture slides
                            System.out.println("Enter topic of slides: ");
                            String topicLecture = scan.next();
                            System.out.println("Enter number of slides: ");
                            int numOfSlides = scan.nextInt();
                            if (numOfSlides <= 0){
                                System.out.println("INVALID entry! Number of slides should be greater than zero. Try again!");
                                break;
                            }
                            for (int i = 0; i < numOfSlides; i++ ){
                                System.out.println("Content of slide " + (i+1) + " : ");
                                String content = scan.next();
                                tempContentArrayList.add(content);
                            }

                            Date date=new Date(); //Stores the time component in form of a string. This will be used later to be presented
                            String timeOfSlideUpload = date.toString();
                            slideList.add(new Slides(topicLecture,tempContentArrayList,timeOfSlideUpload));
                            break;
                        case 2: //add lecture video
                            System.out.println("Enter topic of video: ");
                            String topicVideo;
                            break;
                    }
                    break;
                case 2: // Add assessments
                    break;
                case 3: //View lecture materials

                    break;
                case 4: //View assessments
                    break;
                case 5: //Grade assessments
                    break;
                case 6: //Close assessment
                    break;
                case 7: //View comments
                    break;
                case 8 : //Add comments
                    break;
                case 9: //Logout
                    instructorCondition = false;
                    break;
                default:
                    System.out.println("Invalid Entry! Please enter the correct option from the instructor menu table");
            }
        }
    }
    static void studentMenu (){
        boolean studentCondition = true;
        while(studentCondition){
            printMenu(3);
            Scanner scan = new Scanner(System.in);
            int studentOption = scan.nextInt();
            switch (studentOption){
                case 1 : //View lecture materials
                    break;
                case 2: //View assessments
                    break;
                case 3: //Submit assessment
                    break;
                case 4: //View grades
                    break;
                case 5: //View comments
                    break;
                case 6: //Add comments
                    break;
                case 7: //Logout
                    studentCondition = false;
                    break;
                default:
                    System.out.println("Invalid Entry! Please enter the correct option from the student menu table");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean backPackOption = true;
        while (backPackOption){
            printMenu(1);
	        int menuOption = scan.nextInt();
            switch(menuOption) {
                case 1: //choose instructor menu
                    instructorMenu();
                    break;
                case 2: //choose student menu
                    studentMenu();
                    break;
                case 3:
                    backPackOption = false;
                    break;
                default:
                    System.out.println("Invalid Entry! Please enter the correct option from the BackPack login menu table");
                }
            }
    }
}
