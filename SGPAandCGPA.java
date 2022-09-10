package Q11.ResultPackage;
import java.util.Scanner;
import Q11.StudentPackage.CGPA;


class InvalidSGPA extends Exception{
    InvalidSGPA(String s){
        super(s);
    }
}
public class Result extends CGPA{


    public char grade[][] = new char[4][6];
    public int credit[] = new int[6];
    public String name ="";
    public String branch = "";
    public int semester;
    public String subjects[] = new String[6];
    public int totalCredits =0;
    Scanner sc = new Scanner(System.in);
    public void result(){
        for(int i=0;i<6;i++){
            System.out.println("Enter the marks in Subject["+(i+1)+"]");
            marks[semester-1][i] = sc.nextInt();
        }


        for(int i=0;i<6;i++){
            if(marks[semester-1][i]>90){
                grade[semester-1][i] = 'O';
                sgpa[semester-1] += credit[i]*10;
            }

            else if(marks[semester-1][i]>80){
                grade[semester-1][i] = 'S';
                sgpa[semester-1] += credit[i]*9;
            }

            else if(marks[semester-1][i]>70){
                grade[semester-1][i] = 'A';
                sgpa[semester-1] += credit[i]*8;
            }

            else if(marks[semester-1][i]>60){
                grade[semester-1][i] = 'B';
                sgpa[semester-1] += credit[i]*7;
            }

            else if(marks[semester-1][i]>50){
                grade[semester-1][i] = 'C';
                sgpa[semester-1] += credit[i]*6;
            }

            else if(marks[semester-1][i]>40){
                grade[semester-1][i] = 'D';
                sgpa[semester-1] += credit[i]*5;
            }
            else{
                grade[semester-1][i] = 'F';
                sgpa[semester-1] += credit[i]*5;
            }
        }
        sgpa[semester-1] /= totalCredits;

        try{
            if(sgpa[semester-1]>10){
                throw new InvalidSGPA("Invalid SGPA Exception");
            }
            else{
                System.out.println("SGPA in semester"+semester+" = "+sgpa[semester-1]);
            }
        }
        catch(InvalidSGPA ex){
            System.out.println(ex.getMessage());
        } 
    }
}
public class CGPA{
    public int marks[][] = new int[4][6];
    public float sgpa[] = new float[4];
    float cgpa =0;
    public void calculateGpa(){
        for(int i=0;i<4;i++){
            cgpa += sgpa[i];
        }
        cgpa /=4;
        System.out.println("CGPA is:"+cgpa);
    }
}
package Q11.StudentPackage;
import java.util.Scanner;
import Q11.ResultPackage.Result;


interface Student{
    public void getName();
    public void getBranch();
}
class CreditLimit extends Exception{
    CreditLimit(String s){
        super(s);
    }
}
public class RegisterStudent extends Result implements Student{
    Scanner sc = new Scanner(System.in);
    public void getName(){
        System.out.println("Enter name:\t");
        name = sc.nextLine();
    }
    public void getBranch(){
        System.out.println("Enter branch:\t");
        branch = sc.nextLine();
    }
    public void register(int sem){
        semester = sem;
        if(semester == 1){
                getName();
                getBranch();
        }
        System.out.println("Enter the 6 subjectss registered");
        for(int i=0;i<6;i++){
            System.out.println("Enter subjects "+(i+1));
            subjects[i] = sc.next();
        }
        System.out.println("Enter the respective credits");
        totalCredits =0;
        for(int i=0;i<6;i++){
            System.out.println("Enter the credits of subjects "+(i+1));
            credit[i] = sc.nextInt();
            totalCredits += credit[i];
        }
        try{
            if(totalCredits >30){
                throw new CreditLimit("Credit Limit Exception");
            }
        }
        catch(CreditLimit cl){
            System.out.println(cl.getMessage());
        }
    }
}

package Q11;
import Q11.StudentPackage.RegisterStudent;
import Q11.StudentPackage.CGPA;
class MainClass{
    public static void main(String[] args){
        RegisterStudent s = new RegisterStudent();
        System.out.println("For Semester 1");
        s.register(1);
        s.result();
        System.out.println("For Semester 2");
        s.register(2);
        s.result();
        System.out.println("For Semester 3");
        s.register(3);
        s.result();
        System.out.println("For Semester 4");
        s.register(4);
        s.result();
        s.calculateGpa();


    }
}
