package 其他流.对象操作流;

import java.io.*;
import java.util.ArrayList;

public class De02_ObjectInput {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        // demo1();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("其他流文件/f.txt"));

        ArrayList<Person> list = (ArrayList<Person>) ois.readObject();  // 将对象集合一次取出

        for (Person person : list) {
            System.out.println(person);
        }

    }

    public static void demo1() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("其他流文件/e.txt"));

        Person p1 = (Person) ois.readObject();
        Person p2 = (Person) ois.readObject();  // 当文件读取到末尾时出现EOFException

        System.out.println(p1);
        System.out.println(p2);

        ois.close();
    }
}
