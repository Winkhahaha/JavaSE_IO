package File类;

import java.io.File;
import java.io.FileNotFoundException;

public class De01_File {
    public static void main(String args[]) throws FileNotFoundException {
        //demo1();
        String parent = "字符流文件/";
        String child = "3.txt";
        File file = new File(parent,child);

    }

    public static void demo1() {
        File file = new File("xxx.txt");
        System.out.println( file.exists());     // 文件是否存在

        String parent = "字符流文件/";
        String child = "3.txt";
        file=new File(parent,child);
        System.out.println(file.exists());
    }
}
