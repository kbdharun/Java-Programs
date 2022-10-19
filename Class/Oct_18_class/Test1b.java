import java.io.*;
class Student implements Serializable{
        transient int rno;
        String name;
        Student(int rno, String name){
            this.rno=rno;
            this.name=name;
        }
        public String toString(){
            return "rno:"+rno+" name:"+name;
        }
}

class Test1b{
    public static void main(String args[])throws Exception{
        File f=new File("student1.txt");
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(f));
        Student s=new Student(0,"Ravi");
        out.writeObject(s);
        s=new Student(1, "Raj");
        out.writeObject(s);
        out.close();

        ObjectInputStream in=new ObjectInputStream(new FileInputStream(f));
        s=(Student) in.readObject();
        System.out.println(s);
        s=(Student) in.readObject();
        System.out.println(s);
        in.close();
    }
}
