package socket服务端和客户端;

public class TestClient {
    public static void main(String[] args){
        SocketClient socketClient = new SocketClient();
        for(int i=0;i<3;i++){
            Thread t = new Thread(socketClient);
            t.start();
        }
    }
}
