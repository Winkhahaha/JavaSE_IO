package 字节流;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class De11_键盘录入数据到文本文件 {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请随便输入(输入quit退出):");


        FileOutputStream fos = new FileOutputStream("De11.txt");
        while(true){
            String input = sc.nextLine();
            if("quit".equals(input)){
                break;
            }
            fos.write(input.getBytes());
            fos.write("\r\n".getBytes());
        }
        fos.close();
    }
}
