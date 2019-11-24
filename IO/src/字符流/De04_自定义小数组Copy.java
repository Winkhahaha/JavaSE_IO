package 字符流;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class De04_自定义小数组Copy {
    public static void main(String args[]) throws IOException {
        FileReader fr = new FileReader("字符流文件/3.txt");
        FileWriter fw = new FileWriter("字符流文件/4.txt");

        char[] arr = new char[1024];
        int len;
        while ((len = fr.read(arr)) != -1) {    //将文件上的数据读取到字符数组中
            fw.write(arr, 0, len);        //拷贝到文件
        }
    }
}
