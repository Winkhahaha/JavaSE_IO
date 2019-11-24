package 字符流;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class De01_FileReader {
    public static void main(String args[]) throws IOException {
        FileReader fr = new FileReader("字符流文件/3.txt");
        int x;

        while((x=fr.read())!=-1){       // 通过默认码表一次读取一个字符
            System.out.print((char)x);
        }
        fr.close();
    }
}
