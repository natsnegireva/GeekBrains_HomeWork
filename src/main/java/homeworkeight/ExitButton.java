package homeworkeight;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ExitButton extends JPanel implements ActionListener {
    protected JButton b1, b2, b3;

    public ExitButton() {
        b1 = new JButton("Выключить центральную кнопку");
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING); // слева-направо
        b1.setMnemonic(KeyEvent.VK_D);
        b1.setActionCommand("disable");

        b2 = new JButton("ЦЕНТРАЛЬНАЯ КНОПКА");
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setBackground(Color.yellow);
        b2.setMnemonic(KeyEvent.VK_M);

        b3 = new JButton("Включить центральную кнопку");
        // Использовать текст по умолчанию-центр, продольный (справа).
        b3.setMnemonic(KeyEvent.VK_E);
        b3.setActionCommand("enable");
        b3.setEnabled(false);

        //Слушаем действия на кнопках 1 и 3 (кнопки по событию)
        b1.addActionListener(this);
        b3.addActionListener(this);
        add(b1);
        add(b2);
        add(b3);
    }

    public void actionPerformed(ActionEvent e) {
        if ("disable".equals(e.getActionCommand())) {
            b2.setEnabled(false);
            b1.setEnabled(false);
            b3.setEnabled(true);
        } else {
            b2.setEnabled(true);
            b1.setEnabled(true);
            b3.setEnabled(false);
        }
    }

    public static void createAndShowGUI() {
        //Создание и настройка окна
        JFrame frame = new JFrame("Buttons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Создание и настройка панели содержимого.
        ExitButton newContentPane = new ExitButton();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
        frame.setSize(490, 90);
        frame.setLocation(450,500);
        frame.pack();
        frame.setVisible(true);
    }
}
