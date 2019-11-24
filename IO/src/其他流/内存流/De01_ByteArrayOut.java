package 其他流.内存流;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class De01_ByteArrayOut {
    /*
     内存输出流
     */
    public static void main(String args[]) throws IOException {
         FileInputStream fis = new FileInputStream("其他流文件/e.txt");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();   // 在内存中创建可增长的内存数组

        int b;
        while((b=fis.read())!=-1){
            baos.write(b);
        }
        byte [] arr = baos.toByteArray();   // 将缓冲区的数组全获取出来
       // System.out.println(new String(arr));
        System.out.println(baos.toString());    // 将缓冲区的内容转换为字符串,输出语句中可省略调用toStirng
        System.out.println(baos);

        fis.close();
        // baos.close();   // 无意义的关闭,因为数组是在内存中
    }
}
