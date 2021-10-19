package com.company;

import java.util.*;

class Student {
    private String studentName;

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }
}
class Instructor{
    private String instructorName;

    public Instructor(String instructorName) {
        this.instructorName = instructorName;
    }

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
    private boolean gradedAssess;
    private boolean submittedAssess;

    public void setGradedAssess(boolean gradedAssess) {
        this.gradedAssess = gradedAssess;
    }

    public void setSubmittedAssess(boolean submittedAssess) {
        this.submittedAssess = submittedAssess;
    }

    public Student getStudentInfo() {
        return studentInfo;
    }

    public double getGrade() {
        return grade;
    }

    public String getSubmission() {
        return submission;
    }

    public boolean isGradedAssess() {
        return gradedAssess;
    }

    public boolean isSubmittedAssess() {
        return submittedAssess;
    }

    public AssessmentInfo(Student studentInfo, double grade, String submission, boolean gradedAssess, boolean submittedAssess) {
        this.studentInfo = studentInfo;
        this.grade = grade;
        this.submission = submission;
        this.gradedAssess = gradedAssess;
        this.submittedAssess = submittedAssess;
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

class AssessmentMaterial {
    private String assignType;
    private String assignQuestion;
    private int assignMaxMarks;
    private boolean assignStatus;
    private ArrayList<AssessmentInfo> assignSubmission;

    public AssessmentMaterial(String assignType, String assignQuestion, int assignMaxMarks, boolean assignStatus, ArrayList<AssessmentInfo> assignSubmission) {
        this.assignType = assignType;
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

    public void setAssignStatus(boolean assignStatus) {
        this.assignStatus = assignStatus;
    }

    public String getAssignType() {
        return assignType;
    }

    public String getAssignQuestion() {
        return assignQuestion;
    }

    public ArrayList<AssessmentInfo> getAssignSubmission() {
        return assignSubmission;
    }
}


class Comments implements View{ //it would contain instructor or student ID, the comment, and time stamp
    private String commentStatement;
    private String personName;
    private String timeOfCommenting;

    public Comments(String commentStatement, String personName, String timeOfCommenting) {
        this.commentStatement = commentStatement;
        this.personName = personName;
        this.timeOfCommenting = timeOfCommenting;
    }
    @Override
    public void view() {
        System.out.println(this.commentStatement + " - " + this.personName);
        System.out.println(timeOfCommenting + "\n");
    }
}

interface View{
    public void view(); //will help us view the required arrays
}

public class Main {
    private static ArrayList<Student> studentList = new ArrayList<Student>();
    private static ArrayList<Instructor> instructorList = new ArrayList<Instructor>();
    private static ArrayList<View> materialList = new ArrayList<View>();
    private static ArrayList<AssessmentMaterial> assessmentList = new ArrayList<AssessmentMaterial>();
    private static ArrayList<View> commentList = new ArrayList<View>();

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
        System.out.println("Instructors:\n");
        for (int inst = 0; inst < instructorList.size(); inst++){
            System.out.println(inst + "-" + instructorList.get(inst).getInstructorName());
        }
        int instructorID = scan.nextInt();
        if ((instructorID > instructorList.size())|| (instructorID < 0)) {
            System.out.println("INVALID TYPE! Choosen option out of Menu option! Please Try again!");
        }
        Instructor loginedInstructor = instructorList.get(instructorID);
        while(instructorCondition){
            System.out.println("Welcome " + instructorList.get(instructorID).getInstructorName());
            printMenu(2);
            int instructorOption = scan.nextInt();
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
                        tempAssignInfo.add(new AssessmentInfo(i,0,null,false,false));
                    }
                    switch (assessType){
                        case 1: //add assignment
                            System.out.println("Enter problem statement: ");
                            String problemStatement = scan.next();
                            System.out.println("Enter max marks: ");
                            int assignMaxMarks = scan.nextInt();
                            assessmentList.add(new AssessmentMaterial("Assignment", problemStatement,assignMaxMarks,true,tempAssignInfo));
                        case 2:
                            System.out.println("Enter quiz question: ");
                            String quizQuestion = scan.next();
                            assessmentList.add(new AssessmentMaterial("Quiz",quizQuestion,1,true,tempAssignInfo));
                    }
                    break;
                case 3: //View lecture materials
                    for (int lm = 0; lm < materialList.size(); lm++){
                        materialList.get(lm).view();
                    }
                    break;
                case 4: //View assessments
                    System.out.println("List of Assignments to View: ");
                    int count = 0;
                    for (int av = 0; av < assessmentList.size(); av++) {
                        if (assessmentList.get(av).isAssignStatus()) {
                            System.out.print("ID: " + count + " " + assessmentList.get(av).getAssignType() + assessmentList.get(av).getAssignQuestion());
                            if (assessmentList.get(av).getAssignType().equalsIgnoreCase("Assignment")){
                                System.out.print(assessmentList.get(av).getAssignMaxMarks());
                            }
                            System.out.println("----------------------------");
                            count++;
                        }
                    }
                case 5: //Grade assignments

                    break;
                case 6://Close assessment
                    int cnt = 0;
                    ArrayList<Integer> openAssignmentID = new ArrayList<Integer>();
                    System.out.println("List of Open Assignments (Available to Close: ");
                    for (int av = 0; av < assessmentList.size(); av++) {
                        if (assessmentList.get(av).isAssignStatus()) {
                            System.out.print("ID: " + cnt + " " + assessmentList.get(av).getAssignType() + assessmentList.get(av).getAssignQuestion());
                            if (assessmentList.get(av).getAssignType().equalsIgnoreCase("Assignment")){
                                System.out.print(assessmentList.get(av).getAssignMaxMarks());
                            }
                            System.out.println("----------------------------");
                            cnt++;
                            openAssignmentID.add(av);
                        }
                    }
                    System.out.println("Enter id of assignment to close: ");
                    int idToClose = scan.nextInt();
                    if (idToClose < 0 || idToClose > openAssignmentID.size()) {
                        assessmentList.get(openAssignmentID.get(idToClose)).setAssignStatus(false);
                    }
                            break;
                        case 7: //View comments
                            for (int ico = 0; ico < commentList.size(); ico++){
                                commentList.get(ico).view();
                            }
                            break;
                        case 8 : //Add comments
                            System.out.println("Enter comment: ");
                            String comm = scan.next();
                            commentList.add(new Comments(comm,loginedInstructor.getInstructorName(),currentTime()));
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
                Student loginedStudent = studentList.get(studentID);
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
                        System.out.println("List of Assignments to View: ");
                        int count = 0;
                        for (int vav = 0; vav < assessmentList.size(); vav++) {
                            if (assessmentList.get(vav).isAssignStatus()) {
                                System.out.print("ID: " + count + " " + assessmentList.get(vav).getAssignType() + assessmentList.get(vav).getAssignQuestion());
                                if (assessmentList.get(vav).getAssignType().equalsIgnoreCase("Assignment")){
                                    System.out.print(assessmentList.get(vav).getAssignMaxMarks());
                                }
                                System.out.println("----------------------------");
                                count++;
                            }
                        }
                        break;
                    case 3: //Submit assessment
                        int cnt = 0;
                        ArrayList<Integer> openAssignmentID2 = new ArrayList<Integer>();
                        System.out.println("List of Open Assignments (Pending assignment) : ");
                        for (int av = 0; av < assessmentList.size(); av++) {
                            if (assessmentList.get(av).isAssignStatus()) {
                                if (assessmentList.get(av).getAssignSubmission().get(studentID).isSubmittedAssess()) {
                                    System.out.print("ID: " + cnt + " " + assessmentList.get(av).getAssignType() + assessmentList.get(av).getAssignQuestion());
                                    if (assessmentList.get(av).getAssignType().equalsIgnoreCase("Assignment")) {
                                        System.out.print(assessmentList.get(av).getAssignMaxMarks());
                                    }
                                    System.out.println("----------------------------");
                                    cnt++;
                                    openAssignmentID2.add(av);
                                }
                            }
                        }
                        System.out.println("Enter id of assignment to add: ");
                        int idToUse = scan.nextInt();
                        if (idToUse < 0 || idToUse > openAssignmentID2.size()) {
                            if (assessmentList.get(openAssignmentID2.get(idToUse)).getAssignType().equalsIgnoreCase("Assignment"))
                            {
                                System.out.println("Enter filename of assignment: ");
                                String assignmentSubmission = scan.next();
                                if (!assignmentSubmission.endsWith(".zip")) {
                                    System.out.println("INVALID FILE TYPE! Please upload in .zip format!");
                                    break;
                                }
                                assessmentList.get(openAssignmentID2.get(idToUse)).getAssignSubmission().get(studentID).setSubmission(assignmentSubmission);
                                assessmentList.get(openAssignmentID2.get(idToUse)).getAssignSubmission().get(studentID).setSubmittedAssess(true);
                                break;
                            }


                            if (assessmentList.get(openAssignmentID2.get(idToUse)).getAssignType().equalsIgnoreCase("Quiz")) {

                            }
                        }
                        break;
                    case 4: //View grades

                        break;
                    case 5: //View comments
                        for (int co = 0; co < commentList.size(); co++){
                            commentList.get(co).view();
                        }
                        break;
                    case 6: //Add comments
                        System.out.println("Enter comment: ");
                        String commenting = scan.next();
                        commentList.add(new Comments(commenting,loginedStudent.getStudentName(),currentTime()));
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
            studentList.add(new Student("S0"));
            studentList.add(new Student("S1"));
            studentList.add(new Student("S2"));
            instructorList.add(new Instructor("I0"));
            instructorList.add(new Instructor("I1"));

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


