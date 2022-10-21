//try() {}
import java.io.*;
class Test{
    public static void main(String args[]){
            File f =new File("sample.txt");
            try(var fr=new FileReader(f)){
                int d;
                while((d=fr.read())!=-1)
                            System.out.print((char)d);
            }catch(Exception e){
                    System.out.println(e);
            }
            
    }
}