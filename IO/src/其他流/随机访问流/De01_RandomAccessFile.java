package 其他流.随机访问流;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class De01_RandomAccessFile {
    public static void main(String args[]) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("h.txt","rw");

//        raf.write(97);
//        int x = raf.read();
//        System.out.println(x);
        raf.seek(10);   // 设置写入时位置指针
        raf.write(98);
        raf.close();
    }
}
