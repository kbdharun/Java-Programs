import java.io.*;
class Student implements Serializable{
        int rno;
        String name;
        Student(int rno){
            this.rno=rno;
        }
        public String toString(){
            return "rno:"+rno+" name:"+name;
        }
}

class Test1{
    public static void main(String args[])throws IOException{
        File f=new File("student.txt");
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(f));
        Student s=new Student(100,"ravi");
        out.writeObject(s);
        s=new Student(101,"raja");
        out.writeObject(s);
        out.close();
    }
}