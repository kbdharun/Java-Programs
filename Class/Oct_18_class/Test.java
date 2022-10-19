import java.io.*;
class Test{
        public static void main(String args[])throws IOException{
                File f=new File("sample.txt");
                FileInputStream fin = new FileInputStream(f);
                    byte data[]=new byte[(int)f.length()];

                    fin.read(data);

                System.out.println("read..."+new String(data));

                File f1=new File("sample1.txt");
                FileOutputStream fout = new FileOutputStream(f1);
                    fout.write(data);
                System.out.println("written...");
                    fin.close();
                    fout.close();
        }
}