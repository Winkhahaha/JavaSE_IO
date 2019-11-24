package 字节流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class De07_读写中文 {
    public static void main(String args[]) throws IOException {

        // Demo1(); 读
        FileOutputStream fos = new FileOutputStream("zzz.txt");
        fos.write("挺好的".getBytes());
        fos.write("\r\n".getBytes());

    }

    private static void Demo1() throws IOException {
        FileInputStream fis = new FileInputStream("yyy.txt"); // 创建输入流,读

        byte[] arr = new byte[3];
        int len;
        while ((len = fis.read(arr)) != -1) {
            System.out.println(new String(arr, 0, len));
        }

        fis.close();
    }
}
