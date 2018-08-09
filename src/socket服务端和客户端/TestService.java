package socket服务端和客户端;

import java.io.IOException;

public class TestService {
    public static void main(String[] args) throws IOException {
        for (int i =0;i<3;i++) {
            SocketService socketService = new SocketService(8090+i);
            Thread t = new Thread(socketService);
                t.start();
            }
    }

}
