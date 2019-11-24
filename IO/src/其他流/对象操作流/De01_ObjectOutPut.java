package 其他流.对象操作流;

import java.io.*;
import java.util.ArrayList;

public class De01_ObjectOutPut {
    public static void main(String args[]) throws IOException {
    /*
     序列化:将对象写到文件上
     */
        //demo1();

        Person p1 = new Person("张三", 21);
        Person p2 = new Person("李四", 25);
        Person p3 = new Person("王麻子", 27);

        ArrayList<Person> list = new ArrayList<>(); // 将对象存入集合
        list.add(p1);
        list.add(p2);
        list.add(p3);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("其他流文件/f.txt"));

        oos.writeObject(list);
        oos.close();
    }

    public static void demo1() throws IOException {
        Person p1 = new Person("张三", 21);
        Person p2 = new Person("李四", 25);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("其他流文件/e.txt"));
        // 要写对象,对象必须已经实现序列化
        oos.writeObject(p1);
        oos.writeObject(p2);

        oos.close();
    }
}

