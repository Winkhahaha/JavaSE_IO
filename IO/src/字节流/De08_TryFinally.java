package 字节流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class De08_TryFinally {
    public static void main(String args[]) throws Exception {

        // Demo1();

        //1.7版本处理异常:会自动调用close
        try (
                // 必须实现自动关闭功能:implements AutoCloseable
                FileInputStream fis = new FileInputStream("yyy.txt"); // 创建输入流,读
                FileOutputStream fos = new FileOutputStream("zzz.txt");
                Myclose myclose = new Myclose();
        ) {

            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);           //  将读取的字节写入到输出流指定的输出对象
            }
        }

    }

    private static void Demo1() throws IOException {
        FileInputStream fis = null; // 创建输入流,读
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("yyy.txt");
            fos = new FileOutputStream("zzz.txt");

            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);           //  将读取的字节写入到输出流指定的输出对象
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } finally {                 //try finally的嵌套目的是能关一个关一个
                if (fos != null)
                    fos.close();
            }
        }
    }
}
class Myclose implements AutoCloseable{

    @Override
    public void close() throws Exception {
        System.out.println("我关闭了");
    }
}