package server;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {
  private Socket clientSocket;
  private Server server;
  private PrintWriter outMsg;
  private Scanner inMsg;
  private static int clientCount = 0;
  private String name;


  public ClientHandler(Socket clientSocket, Server server) {
    try {
      clientCount++;
      this.clientSocket = clientSocket;
      this.server = server;
      this.outMsg = new PrintWriter(clientSocket.getOutputStream());
      this.inMsg = new Scanner(clientSocket.getInputStream());
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void run() {
    try {
      server.notificationAllClientWithNewMessage("New client in our chat");
      server.notificationAllClientWithNewMessage("In our chat = " + clientCount + "clients!");


      while (true) {
        if (inMsg.hasNext()) {
          String clientMsg = inMsg.nextLine();
          if (clientMsg.startsWith("/w")) {
            String [] n = clientMsg.split(clientMsg);
            String name = n[1];
            server.sendPrivateMessage(clientMsg, name);
          } else {
            server.notificationAllClientWithNewMessage(clientMsg);
          }
          if (clientMsg.equalsIgnoreCase("QUIT")) {
            break;
          }
          System.out.println(clientMsg);

        }
      }

      Thread.sleep(1000);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      exitFromChat();
    }
  }

  private void exitFromChat() {
    clientCount--;
    server.notificationAllClientWithNewMessage("Client exited. In out chat = " + clientCount + " clients!");
    server.removeClient(this);
  }

  // реализовать в клиенте данный метод
  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }


  public void sendMessage(String msg) {
    try {
      outMsg.println(msg);
      outMsg.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
