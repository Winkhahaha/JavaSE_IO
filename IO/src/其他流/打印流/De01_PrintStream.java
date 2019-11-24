package 其他流.打印流;

import 其他流.对象操作流.Person;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class De01_PrintStream {
    public static void main(String args[]) throws FileNotFoundException {
        /*
         PrintStream和PrintWriter分别是打印的字节流和字符流
         :只操作数据目的
         */
        //demo1();
        PrintWriter printWriter = new PrintWriter(new FileOutputStream("其他流文件/g.txt"),true);
        printWriter.println(97);    // 自动刷出功能只针对println方法
        printWriter.write(97);
        printWriter.close();
    }

    public static void demo1() {
        PrintStream ps = System.out;     // 获取标准输出流
        ps.println(97);         // 底层:Integer.toString,打印97字符串
        ps.write(97);       // 查找码表:a

        ps.println();

        Person p1 = new Person("张三",45);
        ps.println(p1);
        ps.close();
    }
}
