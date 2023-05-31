import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Students {

    public static void main(String args[]) {
        /** See Student.java class */
        Student stud = new Student();

        /** Declare the scanner to get user input */
        Scanner scanner = new Scanner(System.in);

        /** Prompt user for the input */
        System.out.print("Enter Student No: ");

        /** Retrieve user input */
        String snInput = scanner.nextLine();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("StudentData.csv"));
            // BufferedReader reader = new BufferedReader(new Filereader("Employee.csv"));
            String row = "";
            String headerLine = reader.readLine();
            while (((row = reader.readLine())) !=null) {
                /** Split the row first by comma before trying to check studentData */
                String[] studentData = row.split(",");

                /** Compare user input with first column per row */
                if (snInput.equals(studentData[0])) {
                    stud.studentNo = studentData[0];
                    stud.studentName = studentData[1];
                    stud.section = studentData[2].charAt(0);
                    stud.quiz1 = Float.parseFloat(studentData[3]);
                    stud.quiz2 = Float.parseFloat(studentData[4]);
                    stud.quiz3 = Float.parseFloat(studentData[5]);
                    stud.quiz4 = Float.parseFloat(studentData[6]);
                    stud.quiz5 = Float.parseFloat(studentData[7]);

                    System.out.println("===STUDENT RECORD===");
                    System.out.println("Student No:" + stud.studentNo);
                    System.out.println("Student Name:" + stud.studentName);
                    System.out.println("Student Section:" + stud.section);
                    System.out.println("Student Ave:" + stud.ComputeAverage());
                }
                else {
                    continue;
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
