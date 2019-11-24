package 字符流;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class De06_LineNumberReader {
    public static void main(String args[]) throws IOException {
            /*
             自带行号
             */
        LineNumberReader lnr = new LineNumberReader(new FileReader("字符流文件/3.txt"));

        String line;
        lnr.setLineNumber(100);     // 初始起点数
        while((line = lnr.readLine())!=null){
            System.out.println(lnr.getLineNumber()+":"+line);
        }
        lnr.close();
    }
}
