package File类;

import java.io.File;
import java.io.FilenameFilter;

public class De06_文件名称过滤器 {
    public static void main(String args[]) {
        File dir = new File("E:\\EE Test\\IO");
        String[] arr = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File file = new File(dir, name);
                return file.isFile() && file.getName().endsWith(".jpg");
            }
        });
        for (String s : arr) {
            System.out.println(s);
        }
    }
}
