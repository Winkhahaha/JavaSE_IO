package 字符流;

import java.io.*;
import java.util.TreeMap;

public class De10_获取文本上每个字符出现的次数 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("字符流文件/3.txt"));

        TreeMap<Character, Integer> tm = new TreeMap<>();

        int ch;
        while ((ch = br.read()) != -1) {
            char c = (char) ch;

            // 如果没有这个字符,存进去,次数初始1
//            if(!tm.containsKey(c)){
//                tm.put(c,1);
//            }else{
//                // 如果有这个字符,得到它以前的个数再加1
//                tm.put(c,tm.get(c)+1);
//            }
            tm.put(c, !tm.containsKey(c) ? 1 : tm.get(c) + 1);
        }

        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter("字符流文件/De11.txt"));
        for (Character key : tm.keySet()) {
            switch (key) {
                case '\t':
                    bw.write("\\t" + ":" + tm.get(key));      // 写出键和值
                    break;
                case '\n':
                    bw.write("\\n" + ":" + tm.get(key));      // 写出键和值
                    break;
                case '\r':
                    bw.write("\\r" + ":" + tm.get(key));      // 写出键和值
                    break;
                default:
                    bw.write(key + ":" + tm.get(key));      // 写出键和值
                    break;
            }
            // switch每结束一次都会到此处执行换行语句
            bw.newLine();
        }
        bw.close();
    }
}
