package geekbrains.Java2Lesson6.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        S server = new S();
        server.createServer();
        new Thread(() -> server.msgClient()).start();
        new Thread(() -> server.msgServer()).start();
    }


}

class S {
    ServerSocket serverSocket;
    BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
    Socket client;
    DataInputStream in;
    DataOutputStream out;
    String msgServer;

    void msgServer() {
        while (true) {
            try {
                msgServer = buff.readLine();
                out.writeUTF(msgServer);
                out.flush();
                if (msgServer.equalsIgnoreCase("exit")) {
                    System.out.println("Завершение работы сервера");
                    closeServer();
                    break;
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void msgClient() {
        while (true) {
            if (true) {
                try {
                    String msgClient = in.readUTF();
                    if (msgClient.equalsIgnoreCase("exit")) {
                        System.out.println("Клиент отключился");
                        break;
                    }
                    System.out.println("Client: " + msgClient);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    void createServer() {
        try {
            serverSocket = new ServerSocket(3365);
            buff = new BufferedReader(new InputStreamReader(System.in));
            client = serverSocket.accept();
            System.out.println("Client connected");
            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void closeServer() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
