package File类;

import java.io.File;
import java.util.Scanner;

public class De07_录入文件夹路径递归获取所有java文件 {

    public static void main(String args[]) {
        File dir = getDir();
        getJavaFile(dir);
    }

    /*
     获取键盘录入的文件夹路径
     */
    public static File getDir() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个文件夹路径:");
        while (true) {
            String line = sc.nextLine();
            File dir = new File(line);
            if (!dir.exists()) {
                System.out.println("文件夹路径不存在,请重新录入:");
            } else if (dir.isFile()) {
                System.out.println("禁止文件路径,请重新录入:");
            } else {
                return dir;
            }
        }
    }

    /*
    获取文件夹路径下的所有.java路径
     */
    public static void getJavaFile(File dir) {
        File[] subFiles = dir.listFiles();      // 存储文件夹下的文件和文件夹

        for (File subFile : subFiles) {
            if (subFile.isFile() && subFile.getName().endsWith(".java")) {
                System.out.println(subFile);
            } else if (subFile.isDirectory()) { // 如果遍历到目录下的某个文件夹,递归继续搜寻.java
                getJavaFile(subFile);
            }
        }
    }
}
