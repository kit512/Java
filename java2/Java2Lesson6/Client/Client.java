package geekbrains.Java2Lesson6.Client;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        C client = new C();
        if(client.createConnection()) {
            System.out.println("Подключение к серверу прошло успешно");
            new Thread(() -> client.msgClient()).start();
            new Thread(() -> client.msgServer()).start();
        }
    }

static class C {
    BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    String msgClient;
    String msgServer;

    private boolean createConnection() {
        try {
            socket = new Socket("localhost", 3365);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            return true;
        }catch (Exception e) {
            System.out.println("Сервер не запущен");
            return false;
        }
    }

    private void msgServer() {
        while (true) {
            try {
                msgServer = in.readUTF();
                if (msgServer.equalsIgnoreCase("exit")) {
                    System.out.println("Сервер откоючился \nЗакрытие клиента");
                    close();
                    break;
                }
                System.out.println("Server: " + msgServer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void msgClient() {
        try {
            out.writeUTF("Я подключился");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                msgClient = buff.readLine();
                out.writeUTF(msgClient);
                out.flush();
                if(msgClient.equalsIgnoreCase("exit")) {
                    close();
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private void close() {
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
}