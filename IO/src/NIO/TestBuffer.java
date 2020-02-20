package NIO;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Arrays;

public class TestBuffer {

    /*
    测试缓存分配
     */

    @Test
    public void test1() {
        // 分配缓存大小
        int capacity = 1024;
        ByteBuffer buffer = ByteBuffer.allocate(capacity);
        System.out.println("capacity:" + buffer.capacity());
        System.out.println("limit:" + buffer.limit());
        System.out.println("position:" + buffer.position());

        // 向缓存中存数据
        buffer.put("hello".getBytes());
        // 切换到读状态
        buffer.flip();

        // 从缓存中取数据
        //byte b = buffer.get();
        byte[] dst = new byte[buffer.limit()];
        buffer.get(dst);
        System.out.println(new String(dst));

        // 重读
        buffer.rewind();
        // 清空缓存
        buffer.clear();
    }

    // 测试标记
    @Test
    public void test2() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("hello".getBytes());
        System.out.println("capacity:" + buffer.capacity());
        System.out.println("limit:" + buffer.limit());
        System.out.println("position:" + buffer.position());
        System.out.println("----------------------------");

        buffer.flip();
        byte[] b = new byte[2];
        buffer.get(b);
        System.out.println(new String(b));
        System.out.println("capacity:" + buffer.capacity());
        System.out.println("limit:" + buffer.limit());
        System.out.println("position:" + buffer.position());
        // 标记
        buffer.mark();
        System.out.println("position被标记");
        System.out.println("----------------------------");

        buffer.get(b);
        System.out.println(new String(b));
        System.out.println("capacity:" + buffer.capacity());
        System.out.println("limit:" + buffer.limit());
        System.out.println("position:" + buffer.position());
        System.out.println("----------------------------");

        // reset回到mark标记位置
        buffer.reset();
        System.out.println("capacity:" + buffer.capacity());
        System.out.println("limit:" + buffer.limit());
        System.out.println("position:" + buffer.position());
        System.out.println("----------------------------");
    }

    // 利用通道进行文件复制
    @Test
    public void test3() throws IOException {
        FileInputStream fin = null;
        FileOutputStream fout = null;
        fin = new FileInputStream("NIO文件/6.jpg");
        fout = new FileOutputStream("NIO文件/7.jpg");

        FileChannel finChannel = fin.getChannel();
        FileChannel foutChannel = fout.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (finChannel.read(buffer) != -1) {
            // 读的时候position已经到最后,所以buffer要切换到读模式(position指向头)
            buffer.flip();
            foutChannel.write(buffer);
            // 若读满要清空limit
            buffer.clear();
        }
        finChannel.close();
        foutChannel.close();
    }

    @Test
    public void test4() throws IOException {
        FileChannel fileChannel = new RandomAccessFile("NIO.TestBuffer", "rw").getChannel();

        // 创建缓存
        ByteBuffer buffer1 = ByteBuffer.allocate(1024);
        ByteBuffer buffer2 = ByteBuffer.allocate(1024);
        ByteBuffer buffer3 = ByteBuffer.allocate(1024);
        ByteBuffer buffer4 = ByteBuffer.allocate(1024);
        ByteBuffer buffer5 = ByteBuffer.allocate(1024);
        ByteBuffer buffer6 = ByteBuffer.allocate(1024);
        ByteBuffer buffer7 = ByteBuffer.allocate(1024);
        ByteBuffer buffer8 = ByteBuffer.allocate(1024);

        // 分散读取
        ByteBuffer[] buffers = {buffer1, buffer2, buffer3, buffer4, buffer5, buffer6, buffer7, buffer8};
        fileChannel.read(buffers);
        for (ByteBuffer buffer : buffers) {
            System.out.println(new String(buffer.array(), 0, buffer.limit()));
            System.out.println("------------------------");
        }

        // 聚集写入
        FileChannel channel = new RandomAccessFile("NIO文件/1.txt", "rw").getChannel();
        for (ByteBuffer buffer : buffers) {
            // 将每个buffer的position恢复到起始位置
            buffer.flip();
        }
        channel.write(buffers);
        channel.close();
        fileChannel.close();
    }

    /*
    字符缓存
     */
    @Test
    public void test5() {
        CharBuffer buffer = CharBuffer.allocate(1024);
        buffer.put("你好呀!");
        buffer.flip();

//        for (int i = 0; i < buffer.limit(); i++) {
//            System.out.println(buffer.get());
//        }

        // System.out.println(buffer);  直接toString

//        char[] dst = new char[buffer.limit()];
//        buffer.get(dst);
//        System.out.println(new String(dst));

        System.out.println(new String(buffer.array(), 0, buffer.limit()));
    }

    /*
    编解码
     */
    @Test
    public void test6() {
        CharBuffer charBuffer = CharBuffer.allocate(1024);
        charBuffer.put("你好呀~");
        charBuffer.flip();

        // 编码
        Charset charset = Charset.forName("utf-8");
        ByteBuffer byteBuffer = charset.encode(charBuffer);
      // 解码
        Charset charset1 = Charset.forName("utf-8");
        CharBuffer charBuffer1 = charset1.decode(byteBuffer);
        System.out.println(new String(charBuffer1.array(), 0, charBuffer1.limit()));

    }
}
