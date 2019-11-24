package File类;

import java.io.File;

public class De05_判断是否有指定后缀 {
    public static void main(String args[]) {
        File dir = new File("E:\\EE Test\\IO");

//        String[] arr = dir.list();    //获取所有文件或文件夹
//        for (String s : arr) {
//            if(s.endsWith(".jpg")){
//                System.out.println(s);
//            }
//        }
        // 也可用过滤器
        File subFiles[] = dir.listFiles();  //获取所有文件或文件夹对象
        for (File subFile : subFiles) {
            if (subFile.isFile() && subFile.getName().endsWith(".jpg")) {
                System.out.println(subFile);
            }
        }
    }
}
