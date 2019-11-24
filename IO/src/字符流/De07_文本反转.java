package 字符流;

import java.io.*;
import java.util.ArrayList;

public class De07_文本反转 {
    public static void main(String args[]) throws IOException {
            /*
            将文本上的内容反转:第一行-->倒数第一行
                            第二行-->倒数第二行
             */
        BufferedReader br = new BufferedReader(new FileReader("字符流文件/3.txt"));

        ArrayList<String> list = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        br.close();

        /*
        注意:
        流对象晚开早关
         */
        BufferedWriter bw = new BufferedWriter(new FileWriter("字符流文件/4.txt"));
        for (int i = list.size() - 1; i >= 0; i--) {
            bw.write(list.get(i));
            bw.newLine();   //换行
        }

        bw.close();
    }
}
