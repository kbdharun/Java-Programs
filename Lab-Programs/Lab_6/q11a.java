import java.util.Scanner;
abstract class University{
    String Universityname;
    String[] departments={"CSE","IT","ICT","EEE","EIE"};
    static int[] maxStudent; //It should be able to make changes to all 
    abstract void display(); 
}
class SoC extends University{
    SoC(String universityName, int d0, int d1, int d2){
        this.Universityname = Universityname;
        maxStudent[0] = d0;
        maxStudent[1] = d1;
        maxStudent[2] = d2;
    }
    void display{
        
    }
}

class SEEE extends University{
    SEEE(String universityName, int d3, int d4, int d5){
        this.Universityname = Universityname;
        maxStudent[3] = d3;
        maxStudent[4] = d4;
        maxStudent[5] = d5;
    }
    void display{

    }
}

class Student{
    int stuid;
    String sname;
    double percent;
    University admittedSchool;
}

class UniversityDemo{
    Scanner in = new Scanner(System.in);
    int size = in.nextInt();
    Student obj[] = new Student [size];
    for (int i=0;i<size;i++){
        
    }
}