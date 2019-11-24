package 字节流;

import java.io.*;

public class De06_FlushClose {

    /*
     close:
     具备刷新的功能,在关闭流之前,会先刷新一次缓冲区,将缓冲区字节全部刷新到文件,然后关闭流
     flush:
     具备刷新的功能,刷完之后还能继续写

     */
    public static void main(String args[]) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("2.mp3"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy2.mp3"));   // 缓冲区,对输入流进行包装

        int b;
        while((b = bis.read())!=-1){
            bos.write(b);
            // bos.flush();
        }

        // bos.flush();
        bis.close();
        bos.close();
    }
}
