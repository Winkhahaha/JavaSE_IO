package 其他流.内存流;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class De02_Test {
    public static void main(String args[]) throws IOException {
            /*
             定义文件输入流,调用read将txt文件内容打印出来
             */
        FileInputStream fis = new FileInputStream("其他流文件/a.txt");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] arr = new byte[3];
        int len;
        while ((len = fis.read()) != -1) {
            baos.write(arr, 0, len);
        }
        System.out.println(baos);

        fis.close();
    }
}
