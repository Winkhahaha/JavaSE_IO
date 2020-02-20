package NIO;

import org.junit.Test;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class TestNet2 {
    /**
     * 客户端
     */
    @Test
    public void test1() throws Exception {
        // 创建通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream obj = new ObjectOutputStream(bout);
        obj.writeObject(new Date());
        byte[] array = bout.toByteArray();
        // 写入缓存
        buffer.put(array);
        buffer.flip();
        socketChannel.write(buffer);
        socketChannel.close();


    }

    /*
    服务端
     */
    @Test
    public void test2() throws IOException, ClassNotFoundException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 切换到非阻塞模式(否则注册选择器没用)
        serverSocketChannel.configureBlocking(false);
        // 绑定端口
        serverSocketChannel.bind(new InetSocketAddress(8888));
        // 创建选择器
        Selector selector = Selector.open();
        // 注册通道到选择器
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 判断选择器中注册的事件有多少就绪
        while (selector.select() > 0) {
            // 如果有就绪事件,则取出选择选择键的集合
            Set<SelectionKey> keys = selector.selectedKeys();
            // 迭代集合中的就绪事件类型
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()){
                // 取出就绪事件类型
                SelectionKey next = iterator.next();
                // 判断就绪事件是什么类型
                if (next.isAcceptable()){
                    // 创建客户连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    // 将socketChannel通道注册到选择器,注册成为read事件
                    socketChannel.register(selector,SelectionKey.OP_READ);
                }else if (next.isReadable()){
                    // 创建通道
                    SocketChannel socketChannel = (SocketChannel) next.channel();
                    socketChannel.configureBlocking(false);
                    // 创建buffer
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    socketChannel.read(buffer);
                    buffer.flip();
                    byte[] array = new byte[buffer.limit()];
                    buffer.get(array);
                    // 从数组读出对象
                    ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(array));
                    Object object = objectInputStream.readObject();
                    System.out.println(object);
                    objectInputStream.close();
                    socketChannel.close();

                }else if (next.isWritable()){

                }else if (next.isConnectable()){

                }
                iterator.remove();  //把当前迭代到处理的删掉
            }
        }
    }
}