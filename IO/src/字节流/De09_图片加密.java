package 字节流;

import java.io.*;

public class De09_图片加密 {
    /*
    将写出的字节异或上一个数
    解密时再次异或即可
     */
    public static void main(String args[]) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("copy加密.jpg"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy解密.jpg"));   // 缓冲区,对输入流进行包装

        int b;
        while((b = bis.read())!=-1){
            bos.write(b ^ 123); // 一个数连续异或两次等于原数
        }

        bis.close();
        bos.close();

    }
}
