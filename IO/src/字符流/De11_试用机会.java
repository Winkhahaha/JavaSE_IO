package 字符流;

import java.io.*;

public class De11_试用机会 {
    public static void main(String args[]) throws IOException {

        /*
         文件里提示可使用次数:10
         执行一次,文件里使用次数-1,为0提示不可用
         将操作后的剩余试用次数写回文件
         */
        BufferedReader br = new BufferedReader(new FileReader("字符流文件/De12.txt"));
        String line = br.readLine();
        int times=Integer.parseInt(line);
        if(times>0){
            System.out.println("剩余次数:"+times--);
            FileWriter fw = new FileWriter("字符流文件/De12.txt");
            fw.write(times+"");     // 回显到txt中显示剩余次数
            fw.close();
        }else{
            System.out.println("试用次数上限!");
        }

    }
}
