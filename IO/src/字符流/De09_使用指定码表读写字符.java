package 字符流;

import java.io.*;

public class De09_使用指定码表读写字符 {
    public static void main(String args[]) throws IOException {

        // 默认编码表读写,出现乱码
        //demo1();

        //demo2();

        BufferedReader br =
                new BufferedReader(new InputStreamReader(new FileInputStream("utf-8.txt"),"utf8"));
        BufferedWriter bw =
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream("gbk.txt"),"gbk"));

        int c;
        while((c=br.read())!=-1){
            bw.write(c);
        }

        br.close();
        bw.close();
    }

    public static void demo2() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("utf-8.txt"),"utf8");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("gbk.txt"),"gbk");

        int c;
        while((c=isr.read())!=-1){
            osw.write(c);
        }

        isr.close();
        osw.close();
    }

    public static void demo1() throws IOException {
        FileReader fr = new FileReader("字符流文件/utf-8.txt");
        FileWriter fw = new FileWriter("字符流文件/gbk.txt");

        int c;
        while((c=fr.read())!=-1){
            fw.write(c);
        }
        fr.close();
        fw.close();
    }
}
