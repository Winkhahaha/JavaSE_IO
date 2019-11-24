package 字符流;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class De03_Copy {
    public static void main(String args[]) throws IOException {
        //Demo1();
        // 字符流不能拷贝纯字节文件
        FileReader fr = new FileReader("1.jpg");
        FileWriter fw = new FileWriter("字符流文件/copy.jpg");
        int c;
        while((c=fr.read())!=-1){
            fw.write(c);
        }

        fr.close();
        fw.close();
    }

    public static void Demo1() throws IOException {
        FileReader fr = new FileReader("字符流文件/3.txt");
        FileWriter fw = new FileWriter("字符流文件/4.txt");

        int c;
        while((c=fr.read())!=-1){
            fw.write(c);
        }

        fr.close();
        fw.close();     // Writer类中有一个2k的缓冲区,不关流就会将内容写到缓冲区里,关流会将缓冲区内刷新到文件
    }
}
