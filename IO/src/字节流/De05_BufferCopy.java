package 字节流;

import java.io.*;

public class De05_BufferCopy {
    public static void main(String args[]) throws IOException {
        FileInputStream fis = new FileInputStream("2.mp3"); // 创建输入流,读
        FileOutputStream fos = new FileOutputStream("bufferCopy.mp3");

        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);   // 缓冲区,对输入流进行包装

        int b;
        while((b = bis.read())!=-1){
            bos.write(b);
        }

        bis.close();
        bos.close();


    }
}
