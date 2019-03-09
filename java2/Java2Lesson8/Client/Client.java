package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Client extends JFrame {

    private final String SERVER_HOST = "localhost";
    private final int SERVER_PORT = 8888;
    private Socket clientSocket;
    private Scanner inMSG;
    private PrintWriter outMSG;
    private JTextField jMsg;
    private JTextField jName;
    private JTextArea jTextArea;

    public Client() throws HeadlessException {
        try {
            clientSocket = new Socket(SERVER_HOST,SERVER_PORT);
            inMSG = new Scanner(clientSocket.getInputStream());
            outMSG = new PrintWriter(clientSocket.getOutputStream());
        }catch (Exception e) {
            e.printStackTrace();
        }

        setBounds(500,300,500,400);
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jTextArea = new JTextArea();
        jTextArea.setEnabled(false);
        jTextArea.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(jTextArea);
        add(scrollPane, BorderLayout.CENTER);


        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);

        JLabel countsOfClientLabel = new JLabel("Count of client in chat: ");
        add(countsOfClientLabel, BorderLayout.NORTH);
        jName = new JTextField("Anonymous");
        jName.setEnabled(false);
        bottomPanel.add(jName, BorderLayout.WEST);
        JButton send = new JButton("Send");
        bottomPanel.add(send, BorderLayout.EAST);
        jMsg = new JTextField("Message");
        bottomPanel.add(jMsg, BorderLayout.CENTER);


        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = jMsg.getText().trim();
                String name = jName.getText().trim();
                if (!msg.isEmpty() && !name.isEmpty()) {
                    sendMSG();
                    jMsg.grabFocus();
                }
            }
        });

        jMsg.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                jMsg.setText("");
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (inMSG.hasNext()) {
                        String msg = inMSG.nextLine();
                        if (msg.startsWith("/c")) {
                            String [] m = msg.split(" ");
                            String count = m[1];
                            countsOfClientLabel.setText("Count of client in chat: " + count);
                        } else {
                            jTextArea.append(msg);
                            jTextArea.append("\n");
                        }
                    }
                }
            }
        }).start();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                exit();
            }
        });

        setVisible(true);

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                String clientName = jName.getText();
                if (clientName.equals("Anonymous")) {
                    exit();
                }
            }
        };
        timer.schedule(timerTask, 120000);
    }

    private void sendMSG() {
        String msg =  jMsg.getText();
        String name = jName.getText();
        outMSG.println(name + ":" + msg);
        outMSG.flush();
        if (msg.startsWith("/n") && jName.getText().equals("Anonymous")) {
            checkMyName(msg);
        }
        jMsg.setText("");
    }

    private void checkMyName(String msg) {
        String[] n = msg.split(" ");
        String name = n[1];
        jName.setText(name);
    }

    private void exit() {
        outMSG.println("QUIT");
        outMSG.flush();
        outMSG.close();
        inMSG.close();
        try {
            clientSocket.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        System.exit(0);
    }
}
