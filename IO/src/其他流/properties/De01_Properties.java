package 其他流.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class De01_Properties {
    public static void main(String args[]) throws IOException {
        /*
         hashtable的子类
         作为map集合的使用
         */
        //demo1();
        //demo2();

        Properties prop = new Properties();
        prop.load(new FileInputStream("其他流文件/config.properties"));  //将文件上的键值对读取到集合中
        System.out.println(prop);
        prop.setProperty("tel","110");
        prop.store(new FileOutputStream("其他流文件/config.properties"),null);   //第二个参数是对列表参数的描述
        System.out.println(prop);
    }

    public static void demo2() {
        Properties prop = new Properties();
        prop.put("name","张三");
        prop.put("tel","10086");

        Enumeration<String> en = (Enumeration<String>) prop.propertyNames();    // 获取键的枚举
        while(en.hasMoreElements()){
           // System.out.println(en.nextElement());   // 打印每个键
            String key = en.nextElement();
            String value = prop.getProperty(key);
            System.out.println(key+":"+value);
        }
    }

    public static void demo1() {
        Properties prop = new Properties();
        prop.put("abc",123);
        System.out.println(prop);
    }
}
