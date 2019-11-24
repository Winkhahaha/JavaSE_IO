package 其他流.标准输入流;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class De01_SystemInOut {
    public static void main(String args[]) throws IOException {
        //demo1();

        System.setIn(new FileInputStream("其他流文件/a.txt"));
        System.setOut(new PrintStream("其他流文件/b.txt"));

        InputStream is = System.in; // 获取标准的输入流,默认指向键盘,改变后指向文件
        PrintStream ps =System.out; // 获取标准输出流,默认指向控制台

        int b;
        while((b=is.read())!=-1){
            ps.write(b);
        }

        is.close();     // 不用关,没有和硬盘文件产生关联的通道
        ps.close();

    }

    public static void demo1() throws IOException {
        InputStream is = System.in;
        int x = is.read();
        System.out.println(x);
    }
}
