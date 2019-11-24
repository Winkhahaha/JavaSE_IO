package 其他流.序列流;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

public class De01_SequenceInputStream {
    public static void main(String args[]) throws IOException {

        /*
        二合一输出
         */
        //demo1();
        //demo02();

        /*
         多合一输出
         */
        FileInputStream fileInputStream1 = new FileInputStream("其他流文件/a.txt");
        FileInputStream fileInputStream2 = new FileInputStream("其他流文件/b.txt");
        FileInputStream fileInputStream3 = new FileInputStream("其他流文件/c.txt");

        Vector<FileInputStream> v = new Vector<>();
        v.add(fileInputStream1);
        v.add(fileInputStream2);
        v.add(fileInputStream3);

        Enumeration<FileInputStream> en = v.elements();
        SequenceInputStream sequenceInputStream = new SequenceInputStream(en);  // 接收一个枚举类
        FileOutputStream fileOutputStream = new FileOutputStream("其他流文件/多合一.txt");


        int b1;
        while((b1=sequenceInputStream.read())!=-1){
            fileOutputStream.write(b1);
        }
        sequenceInputStream.close();    // 关闭时会将构造传入的流关掉
        fileInputStream1.close();
    }

    public static void demo02() throws IOException {
        FileInputStream fileInputStream1 = new FileInputStream("其他流文件/a.txt");
        FileInputStream fileInputStream2 = new FileInputStream("其他流文件/b.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("其他流文件/c.txt");
        SequenceInputStream sequenceInputStream = new SequenceInputStream(fileInputStream1,fileInputStream2);

        int b1;
        while((b1=sequenceInputStream.read())!=-1){
            fileOutputStream.write(b1);
        }
        sequenceInputStream.close();    // 关闭时会将构造传入的流关掉
        fileInputStream1.close();
    }

    public static void demo1() throws IOException {
        FileInputStream fileInputStream1 = new FileInputStream("其他流文件/a.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("其他流文件/c.txt");

        int b1;
        while((b1=fileInputStream1.read())!=-1){
            fileOutputStream.write(b1);
        }
        fileInputStream1.close();

        FileInputStream fileInputStream2 = new FileInputStream("b.txt");
        int b2;
        while((b2=fileInputStream2.read())!=-1){
            fileOutputStream.write(b2);
        }
        fileInputStream2.close();

        fileOutputStream.close();
    }
}
