package 字符流;

import java.io.FileWriter;
import java.io.IOException;

public class De02_FileWriter {
    public static void main(String args[]) throws IOException {
        FileWriter fw = new FileWriter("字符流文件/4.txt",true); // 加true则不清空旧内容
        fw.write("疑是银河落九天");
        fw.write("\r\n");
        fw.write(97);

        fw.close();
    }
}
