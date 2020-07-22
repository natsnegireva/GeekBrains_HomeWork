package homeworkeight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainWindow extends JPanel {
    private Color[] layerColors = { Color.yellow, Color.magenta, Color.cyan, Color.green };
    private JLayeredPane layeredPane;
    private JLabel label;
    private JButton button;
    private ActionListener actionListener;

    public MainWindow() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(300, 310));
        layeredPane.setBorder(BorderFactory.createTitledBorder("Нажми на красную кнопку"));
        Point origin = new Point(20, 20);
        int offset = 110;
        for (int i = 0; i < layerColors.length; i++) {
            // настройки в функции createColoredLabel
            JLabel label = createColoredLabel(layerColors[i], origin);
            layeredPane.add(label, new Integer(i));
            origin.x += offset;
        }
        JButton button = createControlPanel();
        layeredPane.add(button);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(layeredPane);
    }

    private JButton createControlPanel() {
        JButton button = new JButton();
        button.setBounds(150, 200, 200, 60);
        button.setText("Н А Ж М И");
        button.setBackground(Color.red);
        button.setActionCommand("disable");
        button.addActionListener(this.actionListener);
        return button;
    }

    private JLabel createColoredLabel(Color color, Point origin) {
        JLabel label = new JLabel();
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setOpaque(true); // не прозрачный обязательно
        label.setBackground(color);
        label.setForeground(Color.black);
        label.setBorder(BorderFactory.createLineBorder(Color.black));
        label.setBounds(origin.x, origin.y, 100, 100);
        return label;
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Main Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MainWindow());
        frame.setSize(490, 330);
        frame.setLocation(450,100);
        frame.setVisible(true);
    }

}



