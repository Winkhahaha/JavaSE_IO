package File类;

import java.io.File;

public class De03_判断方法 {
    public static void main(String args[]){
        File dir1 = new File("ccc");
        // 判断是否是文件夹
        System.out.println(dir1.isDirectory());
        // 判断是否是文件
        System.out.println(dir1.isFile());

        File file = new File("xxx.txt");
        file.setReadable(false);    // 设置不可读
        System.out.println(file.canRead());

        file.setWritable(false);    // 设置不可写
        System.out.println(file.canWrite());

        System.out.println(file.isHidden());    // 判断是否是隐藏文件
    }
}
