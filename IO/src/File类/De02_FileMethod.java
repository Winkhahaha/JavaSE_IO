package File类;

import java.io.File;
import java.io.IOException;

public class De02_FileMethod {
    public static void main(String args[]) throws IOException {
        //createAndMkdir();

        //改名
//        File file = new File("def.txt");
//        File file2 = new File("ooo改变.txt");
//        System.out.println(file.renameTo(file2));

        // 删除文件(要删除文件夹,文件夹下必须没有任何东西)
        //file2.delete();
        File file = new File("xxx.txt");

    }

    public static void createAndMkdir() throws IOException {
        File file = new File("ooo.txt");    // 没有就创建,有则返回false
        System.out.println(file.createNewFile());

        File dir1 = new File("aaa");
        System.out.println(dir1.mkdir());

        File dir2 = new File("bbb/ccc");
        System.out.println(dir2.mkdirs());      // 创建多级文件夹
    }
}
