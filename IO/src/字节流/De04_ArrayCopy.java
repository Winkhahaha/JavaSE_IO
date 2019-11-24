package 字节流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class De04_ArrayCopy {
    public static void main(String args[]) throws IOException {
            /*
            定义小数组
             */
        //Demo1();
        //Demo2();
        FileInputStream fis = new FileInputStream("xxx.txt"); // 创建输入流,读
        FileOutputStream fos = new FileOutputStream("yyy.txt");

        byte[] arr = new byte[1024];
        int len;        // 读取的有效数字
        while ((len = fis.read(arr)) != -1) {
            fos.write(arr, 0, len);     // 从0索引开始每次读有效数字个数
        }
        fis.close();
        fos.close();

    }

    private static void Demo2() throws IOException {
        FileInputStream fis = new FileInputStream("xxx.txt"); // 创建输入流,读
        FileOutputStream fos = new FileOutputStream("yyy.txt");

        byte[] arr = new byte[2];
        int len;        //读取的有效数字
        while ((len = fis.read(arr)) != -1) {
            fos.write(arr, 0, len);
        }
        fis.close();
        fos.close();
    }

    private static void Demo1() throws IOException {
        FileInputStream fis = new FileInputStream("xxx.txt"); // 创建输入流,读
        byte[] arr = new byte[1024];

        int a = fis.read(arr);  // 读到的有效字节个数
        System.out.println(a);

        for (byte b : arr) {
            System.out.println(b);
        }
        fis.close();
    }
}
