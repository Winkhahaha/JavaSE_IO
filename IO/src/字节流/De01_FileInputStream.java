package 字节流;

import java.io.FileInputStream;
import java.io.IOException;

public class De01_FileInputStream {

    public static void main(String args[]) throws IOException {

        FileInputStream fis = new FileInputStream("xxx.txt");   // 创建流对象
//        int x = fis.read();         // 从硬盘上读取一个字节
//        System.out.println((char) x);
//
//        int y = fis.read();
//        System.out.println((char) y);

        int b;
        while ((b = fis.read()) != -1) {         // read停止的标记是-1,借此可以循环读取
            System.out.println((char) b);
        }

        fis.close();            // 关流释放资源

    }
}
