package com.mycompany.assignment1pt2;
import com.mycompany.assignment1.CourseProgramme;
import com.mycompany.assignment1.Student;
import com.mycompany.assignment1.Module;
import java.util.*;
import org.joda.time.*;


/**
 * @author isaac.scanlan
 */

public class Main {
    static CourseProgramme ece;
    
    public static void main(String[] args) {
        
        /** Creating the subject of Electronic engineering for a test 
         *  The CourseProgramme class contains information consisting of the course name, 
         *  start & end dates, list of its module and one students */
        ece = new CourseProgramme("Electronic and Computer Engineering",(new LocalDate( 2020 , 9 , 28 )), (new LocalDate( 2021 , 1 , 15 )));
        /** The Module class contains values for its name, module code, students and the curses that it features in */
        ece.addModule(( new com.mycompany.assignment1.Module("Machine Learning                ","CT4101") ));
        ece.addModule(( new com.mycompany.assignment1.Module("Software Engineering III        ","CT417") ));
        ece.addModule(( new com.mycompany.assignment1.Module("Digital Signal Processing       ","EE445") ));
        ece.addModule(( new com.mycompany.assignment1.Module("System on Chip Design I         ","EE451") ));
        ece.addModule(( new com.mycompany.assignment1.Module("Telecommunications Software Apps","EE453") ));
        
        // Adding ece as a course that these modules feature in to each module
        for(String s: ece.getModuleList().keySet())
            ece.getModuleList().get(s).addCourse(ece.getProgrammeName());
        
        // Here are some test students to be added to the system
        Student s1a = createStudent("Pat", 22, "23-01-1998", 1, 1, 1, 1, 1);
        Student s2a = createStudent("Sarah", 21, "09-04-1999", 0, 1, 1, 1, 1);
        Student s3a = createStudent("Seamus", 22, "17-09-1998", 1, 0, 1, 0, 1);
        Student s4a = createStudent("James", 20, "03-07-2000", 0, 0, 1, 1, 1);
        Student s5a = createStudent("Mary", 23, "29-02-1997", 1, 0, 1, 0, 0);
        Student s6a = createStudent("Tom", 22, "19-10-1998", 1, 0, 0, 0, 0);
        Student s7a = createStudent("Síle", 22, "26-06-1998", 1, 1, 1, 1, 0);
        Student s8a = createStudent("Pádraig", 22, "22-03-1998", 1, 0, 1, 1, 1);
        Student s9a = createStudent("Jonny", 21, "19-10-1999", 1, 1, 1, 0, 1);
        Student s10a = createStudent("Rúaidhrí", 22, "30-04-1998", 1, 0, 1, 0, 1);
        Student s11a = createStudent("Nuala", 20, "03-12-1999", 1, 1, 1, 1, 1);
        Student s12a = createStudent("Jim", 21, "28-11-1998", 1, 0, 1, 1, 0);
        Student s13a = createStudent("Stephen", 22, "11-03-1998", 1, 1, 1, 1, 0);
        Student s14a = createStudent("Donagh", 21, "09-01-1999", 1, 1, 1, 0, 1);
        Student s15a = createStudent("Shane", 22, "14-08-1998", 1, 1, 1, 1, 1);
        
        // Prints basic info about the course
        printCourseContent();
        
        // Title for the secion displaying information about the students
        System.out.println("\n\nStudents in the Subject of " + ece.getProgrammeName() 
                + "\n----------------------------------------------------------------------------------------"
                + "----------------------------------------------------------------------------------------");
        
        // Prints a few of the sutents values. Their name, age, date of birth and their modules
        System.out.println("\nName: " + s1a.getName() + "\tage:" + s1a.getAge() + "\t\tDate of Birth: " + s1a.getDoB()
        + "\nModules: " + s1a.getModules().keySet());
        System.out.println("\nName: " + s2a.getName() + "\tage:" + s2a.getAge() + "\t\tDate of Birth: " + s2a.getDoB()
        + "\nModules: " + s2a.getModules().keySet());
        System.out.println("\nName: " + s5a.getName() + "\tage:" + s5a.getAge() + "\t\tDate of Birth: " + s5a.getDoB()
        + "\nModules: " + s5a.getModules().keySet());
        System.out.println("\nName: " + s9a.getName() + "\tage:" + s9a.getAge() + "\t\tDate of Birth: " + s9a.getDoB()
        + "\nModules: " + s9a.getModules().keySet());
        System.out.println("\nName: " + s13a.getName() + "\tage:" + s13a.getAge() + "\t\tDate of Birth: " + s13a.getDoB()
        + "\nModules: " + s13a.getModules().keySet());
        
        System.out.println("\n----------------------------------------------------------------------------------------"
                + "----------------------------------------------------------------------------------------");
    }
    
    /** Creates a student with "name", "age" and "dob". Subsequent ints represent if they take a particular 
     *  module or not*/
    private static Student createStudent(String name, int age, String dob, int a, int b, int c, int d, int e){
        // Used for when iterating the list of modules to tell  if student takes the module in question
        int[] arry = {a,b,c,d,e};
        // Pointer for arry
        int counter = 0;
        
        // New student to be added
        Student s1 = new Student(name, age, dob);
        // Adding ece as one of the students subjects
        s1.addCourse(ece);
        
        // Adding the specified modules to the Students list of modules
        for(String s: ece.getModuleList().keySet()){
            if(arry[counter] == 1)
                s1.addModule(ece.getModuleList().get(s));
            counter++;
        }
        
        // Finally adding the student as a member of the ece programme
        ece.addStudent(s1);
        return s1;
    }
    
    private static void printCourseContent(){
        // Title displaying information about course (name and start & end dates)
        System.out.println("\nModules in the Subject of " + ece.getProgrammeName() + " lasting from " + ece.getStart() + " to " + ece.getEnd()
                + "\n----------------------------------------------------------------------------------------");
        HashMap<String, Module> ml = ece.getModuleList();
       
        // Iterates though list of modules while printing the name and module code
        for(String s: ml.keySet()){
            System.out.println(ml.get(s).getName() + "\t" + ml.get(s).getID());
        }
        
        System.out.println("\n----------------------------------------------------------------------------------------");
    }
    
}
