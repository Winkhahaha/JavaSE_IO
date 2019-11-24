package 字节流;

import java.io.*;
import java.util.Scanner;

public class De10_CopyDir {
    /*
    控制台录入文件路径,将文件拷贝到当前项目
     */
    public static void main(String args[]) throws IOException {

        File file = getFile();      // 获取文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file.getName()));

        int b;
        while((b = bis.read())!=-1){
            bos.write(b);
        }

        bis.close();
        bos.close();
    }

    public static File getFile() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个文件路径:");
        while (true) {
            String input = sc.nextLine();
            File file = new File(input);        // 封装成File对象并对其判断
            if (!file.exists()) {
                System.out.println("文件路径不存在!请重新录入:");
            } else if (file.isDirectory()) {
                System.out.println("禁止文件夹路径!请重新录入:");
            } else {
                System.out.println("获取文件成功!");
                return file;
            }
        }

    }


}
