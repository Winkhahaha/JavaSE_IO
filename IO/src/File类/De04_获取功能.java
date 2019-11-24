package File类;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class De04_获取功能 {
    public static void main(String args[]) throws IOException {
        File file = new File("xxx.txt");
        System.out.println(file.getAbsolutePath()); //获取绝对路径
        System.out.println(file.getCanonicalPath());    //获取标准的绝对路径
        System.out.println(file.getPath()); //获取构造方法传入的路径

        System.out.println(file.getName()); //获取文件或文件夹名称
        System.out.println(file.length());  //获取文件字节

        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(format.format(new Date(file.lastModified())));    //获取文件最后修改时间

        File dir = new File("E:\\EE Test\\IO");
        String[] arr = dir.list();  //获取路径下文件夹中所有文件(仅为了获取文件名)
        for (String s : arr) {
            System.out.println(s);
        }
        System.out.println("-----------------------------");
        File[] subFiles = dir.listFiles();  // 获取文件对象
        for (File subFile : subFiles) {
            System.out.println(subFile);
        }
    }
}
