package com.company;

import java.util.*;

class Student {
    private String studentName;

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }
}
class Instructor{
    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    private String instructorName;

    public String getInstructorName() {
        return instructorName;
    }
}

class Slides implements View{
    private String topicOfSlides;
    private ArrayList<String> contentOfSlides;
    private String timeOfAddSlide;
    private Instructor instructorNameS;
    private int noOfSlides;


    public Slides(String topicOfSlides, ArrayList<String> contentOfSlides, String timeOfAddSlide, Instructor instructorNameS, int noOfSlides) {
        this.topicOfSlides = topicOfSlides;
        this.contentOfSlides = contentOfSlides;
        this.timeOfAddSlide = timeOfAddSlide;
        this.instructorNameS = instructorNameS;
        this.noOfSlides = noOfSlides;
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
    public Instructor getInstructorNameS() {
        return instructorNameS;
    }

    public int getNoOfSlides() {
        return noOfSlides;
    }

    @Override
    public void view(){
        System.out.println("Title: "+ this.getTopicOfSlides());
        for (int i = 0; i < this.getNoOfSlides(); i++){
            System.out.println("Slide " + (i+1) + ": " + this.getContentOfSlides().get(i));
        }
        System.out.println("Number of Slides " + this.getNoOfSlides());
        System.out.println("Date of upload: " + this.getTimeOfAddSlide());
        System.out.println("Uploaded by: " + this.getInstructorNameS());
    }
}

class Video implements View {
    private String topicOfVideo;
    private String fileName;
    private String timeOfAddVideo;
    private Instructor instructorNameV;

    public Video(String topicOfVideo, String fileName, String timeOfAddVideo, Instructor instructorNameV) {
        this.topicOfVideo = topicOfVideo;
        this.fileName = fileName;
        this.timeOfAddVideo = timeOfAddVideo;
        this.instructorNameV = instructorNameV;
    }

    public Instructor getInstructorNameV() {
        return instructorNameV;
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
        System.out.println("Title of Video : " + this.getTopicOfVideo());
        System.out.println("Video file: " + this.getFileName());
        System.out.println("Date of upload: " + this.getTimeOfAddVideo());
        System.out.println("Uploaded by : " + this.getInstructorNameV());
    }
}
class AssessmentInfo {
    private Student studentInfo;
    private double grade;
    private String submission;

    public AssessmentInfo(Student studentInfo, double grade, String submission) {
        this.studentInfo = studentInfo;
        this.grade = grade;
        this.submission = submission;
    }

    public void setStudentInfo(Student studentInfo) {
        this.studentInfo = studentInfo;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setSubmission(String submission) {
        this.submission = submission;
    }
}

class Quiz implements Add{
    private String quizQuestion;
    private final int quizMaxMarks = 1;
    private boolean quizStatus;
    private ArrayList<AssessmentInfo> quizSubmission;

    public int getQuizMaxMarks() {
        return quizMaxMarks;
    }

    public void setQuizStatus(boolean quizStatus) {
        this.quizStatus = quizStatus;
    }

    public boolean isQuizStatus() {
        return quizStatus;
    }

    public Quiz(String quizQuestion, boolean quizStatus, ArrayList<AssessmentInfo> quizSubmission) {
        this.quizQuestion = quizQuestion;
        this.quizStatus = quizStatus;
        this.quizSubmission = quizSubmission;
    }

    public void setQuizQuestion(String quizQuestion) {
        this.quizQuestion = quizQuestion;
    }

    public String getQuizQuestion() {
        return quizQuestion;
    }

    @Override
    public void addAssessment() {
        if (this.isQuizStatus()) {
            System.out.println("Question: " + this.getQuizQuestion());
        }
        this.isQuizStatus();
    }
}

class Assignment implements Add{
    private String assignQuestion;
    private int assignMaxMarks;
    private boolean assignStatus;
    private ArrayList<AssessmentInfo> assignSubmission;


    public Assignment(String assignQuestion, int assignMaxMarks, boolean assignStatus, ArrayList<AssessmentInfo> assignSubmission) {
        this.assignQuestion = assignQuestion;
        this.assignMaxMarks = assignMaxMarks;
        this.assignStatus = assignStatus;
        this.assignSubmission = assignSubmission;
    }

    public int getAssignMaxMarks() {
        return assignMaxMarks;
    }

    public boolean isAssignStatus() {
        return assignStatus;
    }

    public String getAssignQuestion() {
        return assignQuestion;
    }
    @Override
    public void AssignStatus() {

    }

    @Override
    public void addAssessment() {
        if (this.isAssignStatus()){
            System.out.println("Assignment: " + this.getAssignQuestion() + " , " + this.getAssignMaxMarks());
        }
    }
}


class Comments{ //it would contain instructor or student ID, the comment, and time stamp

}

interface Add{
    public void addAssessment();
}
interface View{
    public void view(); //will help us view the required arrays
}

public class Main {
    private static ArrayList<Student> studentList = new ArrayList<Student>();
    private static ArrayList<Instructor> instructorList = new ArrayList<Instructor>();
    private static ArrayList<View> materialList = new ArrayList<View>();
    private static ArrayList<Add> assessmentList = new ArrayList<Add>();

    static String currentTime(){
        Date date=new Date(); //Stores the time component in form of a string. This will be used later to be presented
        return date.toString();
    }
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
        Scanner scan = new Scanner(System.in);
        boolean instructorCondition = true;
        while(instructorCondition){
            System.out.println("Instructors:\n");
            for (int inst = 0; inst < instructorList.size(); inst++){
                System.out.println(inst + "-" + instructorList.get(inst).getInstructorName());
            }
            int instructorID = scan.nextInt();
            if ((instructorID > instructorList.size())|| (instructorID < 0)) {
                System.out.println("INVALID TYPE! Choosen option out of Menu option! Please Try again!");
            }
            Instructor loginedInstructor = instructorList.get(instructorID);
            int instructorOption = scan.nextInt();
            System.out.println("Welcome" + instructorList.get(instructorID).getInstructorName());
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
                            String timeOfSlideUpload = currentTime();
                            materialList.add(new Slides(topicLecture,tempContentArrayList,timeOfSlideUpload,loginedInstructor,numOfSlides));
                            break;
                        case 2: //add lecture video
                            System.out.println("Enter topic of video: ");
                            String topicVideo = scan.next();
                            System.out.println("Enter filename of video: ");
                            String fileNameVideo = scan.next();

                            String timeVideoUpload = currentTime();
                            if (!fileNameVideo.endsWith(".mp4")){ //error gen statment, don't remove exclamation point
                                System.out.println("INVALID FILE TYPE! Video should be of .mp4 format");
                                break;
                            };
                            materialList.add(new Video(topicVideo,fileNameVideo,timeVideoUpload,loginedInstructor));
                            break;
                    }
                    break;
                case 2: // Add assessments
                    System.out.println("1. Add Assignment\n" +
                            "2. Add Quiz");
                    int assessType = scan.nextInt();
                    ArrayList<AssessmentInfo> tempAssignInfo = new ArrayList<AssessmentInfo>();
                    for (Student i: studentList){
                        tempAssignInfo.add(new AssessmentInfo(i,0,null));
                    }
                    switch (assessType){
                        case 1: //add assignment
                            System.out.println("Enter problem statement: ");
                            String problemStatement = scan.next();
                            System.out.println("Enter max marks: ");
                            int assignMaxMarks = scan.nextInt();
                            assessmentList.add(new Assignment(problemStatement,assignMaxMarks,true,tempAssignInfo));
                        case 2:
                            System.out.println("Enter quiz question: ");
                            String quizQuestion = scan.next();
                            assessmentList.add(new Quiz(quizQuestion,true,tempAssignInfo));
                    }
                    break;
                case 3: //View lecture materials
                    for (int lm = 0; lm < materialList.size(); lm++){
                        materialList.get(lm).view();
                    }
                    break;
                case 4: //View assessments
                    System.out.println("List of Assignments to View: ");
                    for (int av = 0; av < assessmentList.size(); av++){
                        if assessmentList.get(av)
                        System.out.print("ID: " + av + " ");
                        assessmentList.get(av).addAssessment();
                        System.out.println("----------------");
                    }
                    break;
                case 5: //Grade assessments
                    break;
                case 6: //Close assessment
                    System.out.println("List of Open Assignments: ");
                    for (int oa = 0; oa < assessmentList.size(); oa++){
                        System.out.print("ID: " + oa + " ");
                        assessmentList.get(oa).addAssessment();
                        System.out.println("----------------");
                    }
                    System.out.println("Enter id of assignment to close: ");
                    int idToClose = scan.nextInt();
                    if (idToClose < 0 || idToClose > assessmentList.size()) {
                        assessmentList.get(idToClose);
                    }
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
    static void studentMenu(){
        Scanner scan = new Scanner(System.in);
        boolean studentCondition = true;
        while(studentCondition){
            System.out.println("Students:\n");
            for (int inst = 0; inst < studentList.size(); inst++){
                System.out.println(inst + "-" + studentList.get(inst));
            }
            int studentID = scan.nextInt();
            if ((studentID > studentList.size()) || (studentID < 0)){
                System.out.println("INVALID TYPE! Choosen option out of Student Menu option! Please Try again!");
            }
            Student loginedInstructor = studentList.get(studentID);
            int instructorOption = scan.nextInt();
            System.out.println("Welcome" + studentList.get(studentID).getStudentName());
            printMenu(3);
            int studentOption = scan.nextInt();
            switch (studentOption){
                case 1 : //View lecture materials
                    for (int lm = 0; lm < materialList.size(); lm++){
                        materialList.get(lm).view();
                    }
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
