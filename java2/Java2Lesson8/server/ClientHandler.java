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
  private String myName = "Anonymous";


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
      server.notificationAllClientWithNewMessage("/c " + clientCount);
      sendMessage("Измените ник командой /n \"ваш_ник\", иначе будете исключены с чата через 120 сек");

      while (true) {
        if (inMsg.hasNext()) {
          String clientMsg = inMsg.nextLine();
          if (clientMsg.equalsIgnoreCase("QUIT")) {
            break;
          }
          System.out.println(clientMsg);
          String [] msg = clientMsg.split(":");
          String onlyMsg = msg[1];
          if (onlyMsg.startsWith("/")) {
            if (onlyMsg.startsWith("/w")) {
              String[] n = onlyMsg.split(" ");
              String name = n[1];
              server.sendPrivateMessage(clientMsg, name);
              server.sendPrivateMessage(clientMsg, getMyName());
            } else if (onlyMsg.startsWith("/n")) {
              String[] setName = onlyMsg.split(" ");
              String name = setName[1];
              if (myName.isEmpty() || myName.equals("Anonymous")) {
                setMyName(name);
                server.sendPrivateMessage("/n " + getMyName(), getMyName());
              }
            }
          } else {
            server.notificationAllClientWithNewMessage(clientMsg);
          }
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
    server.notificationAllClientWithNewMessage(getMyName() + " exit from chat");
    server.notificationAllClientWithNewMessage("/c " + clientCount);
    server.removeClient(this);
  }

  private void setMyName(String myName) {
    this.myName = myName;
  }

  public String getMyName() {
    return myName;
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
