package 其他流.数据输入输出流;

import java.io.*;

public class De01_Data {
    public static void main(String args[]) throws IOException {
//        FileOutputStream fos = new FileOutputStream("其他流文件/i.txt");
//        fos.write(997);
//        fos.write(998);
//        fos.write(999);
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("其他流文件/i.txt"));
        dataOutputStream.write(999);
        dataOutputStream.close();

        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("其他流文件/i.txt"));
        int x = dataInputStream.readInt();
        System.out.println(x);
    }
}
