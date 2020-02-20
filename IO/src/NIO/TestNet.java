package NIO;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestNet {
    /**
     * 客户端
     */
    @Test
    public void test1() throws Exception {
//        Socket s = new Socket("127.0.0.1",8888);
//        SocketChannel socketChannel = s.getChannel();
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));
        FileChannel fileChannel = FileChannel.open(Paths.get("NIO文件/6.jpg"), StandardOpenOption.READ);
        //分配缓存
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //从文件读字节到缓存
        while (fileChannel.read(buf) != -1) {
            buf.flip();
            socketChannel.write(buf);
            buf.clear();
        }

        //关闭通道
        fileChannel.close();
        socketChannel.close();

    }

    /*
    服务端
     */
    SocketChannel socketChannel = null;

    @Test
    public void test2() throws IOException {
//        ServerSocket  serverSocket = new ServerSocket(8888);
//        ServerSocketChannel channel = serverSocket.getChannel();
        // 创建通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 绑定端口
        serverSocketChannel.bind(new InetSocketAddress(8888));
        // 监听并获得通道
        //FileChannel fileChannel = null;

        while (true) {
            // 阻塞
            socketChannel = serverSocketChannel.accept();
            new Thread(() -> {
                try {
                    // 创建缓存
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    // 创建文件通道
                    FileChannel fileChannel = FileChannel.open(Paths.get("NIO文件/8.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW);
                    // 读网络数据缓存包
                    while (socketChannel.read(buffer) != -1) {
                        buffer.flip();
                        fileChannel.write(buffer);
                        buffer.clear();
                    }
                    fileChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        }
        // socketChannel.close();

    }
}
