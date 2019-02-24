package geekbrains.Java2Lesson4.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientWindow extends JFrame {

    public ClientWindow() {
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100,100,800,600);
        setVisible(true);

        setLayout(new BorderLayout());
        JTextArea chat = new JTextArea();
        chat.setLineWrap(true);
        chat.setEnabled(false);
        JScrollPane jScrollPane = new JScrollPane(chat);
        JPanel jPanel = new JPanel();
        add(jScrollPane, BorderLayout.CENTER);
        add(jPanel, BorderLayout.SOUTH);
        //создаем нижнюю панель
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));
        JTextField message = new JTextField(256);
        JButton send = new JButton("Send");
        jPanel.add(message);
        jPanel.add(send);
        setVisible(true);

        //обработка нажатий enter
        message.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (message.getText().length() > 1) {
                    chat.append(message.getText() + "\n");
                    message.setText("");
                }
            }
        });
        //обработка нажатий кнопки
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (message.getText().length() > 1) {
                    chat.append(message.getText() + "\n");
                    message.setText("");
                }
            }
        });
    }
}
