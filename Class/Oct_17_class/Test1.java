//InputStream...OutputStream
import java.io.*;
class Test1{
        public static void main(String args[])throws IOException{
            BufferedInputStream bin= new BufferedInputStream(System.in);
            byte [] data = new byte[100];
            bin.read(data);
            System.out.println(new String(data));
        }
}