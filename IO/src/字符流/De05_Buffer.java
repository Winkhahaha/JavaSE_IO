package 字符流;

import java.io.*;

public class De05_Buffer {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("字符流文件/3.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("字符流文件/4.txt"));

        int c;
        while((c=br.read())!=-1){
            bw.write(c);
        }

        br.close();
        bw.close();
    }
}
