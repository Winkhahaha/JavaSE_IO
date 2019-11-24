package 字节流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class De03_Copy {
    public static void main(String args[]) throws IOException {
        // copyImg();

        FileInputStream fis = new FileInputStream("2.mp3"); // 创建输入流,读
        FileOutputStream fos = new FileOutputStream("copy.mp3");    // 创建输出流,写

        int b;
        while ((b = fis.read()) != -1) {
            fos.write(b);           //  将读取的字节写入到输出流指定的输出对象
        }

        fis.close();
        fos.close();
    }

    private static void copyImg() throws IOException {
        FileInputStream fis = new FileInputStream("1.jpg"); // 创建输入流,读
        FileOutputStream fos = new FileOutputStream("copy.jpg");    // 创建输出流,写

        int b;
        while ((b = fis.read()) != -1) {
            fos.write(b);           //  将读取的字节写入到输出流指定的输出对象
        }

        fis.close();
        fos.close();
    }
}
