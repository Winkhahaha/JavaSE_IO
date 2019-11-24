package 字节流;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 输出流
 */
public class De02_FileOutputStream {
    public static void main(String args[]) throws IOException {
        // 创建字节输出流对象,没有自动创建,如果有就会先清空文件,加true则不清空,续写
        FileOutputStream fos = new FileOutputStream("yyy.txt",true);
        fos.write(97);      // 虽然写出的是int数,但是文件上的是一个字节,会自动去除前三个八位
        fos.write(98);
        fos.write(99);
    }
}
