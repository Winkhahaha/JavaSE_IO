package 其他流.标准输入流;

import java.io.*;

public class De02_Copy {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("其他流文件/1.jpg"));
        System.setOut(new PrintStream("其他流文件/copy.jpg"));

        InputStream is = System.in; // 获取标准的输入流,默认指向键盘,改变后指向文件
        PrintStream ps =System.out; // 获取标准输出流,默认指向控制台

        byte[] arr = new byte[1024];
        int b;
        while((b=is.read())!=-1){
            ps.write(arr,0,b);
        }

        is.close();     // 不用关,没有和硬盘文件产生关联的通道
        ps.close();

    }
}
