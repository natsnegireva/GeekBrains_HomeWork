package homeworkeight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

// Визуальное понимание послойности в JPanel которая по умолчанию
// наследуем от JPanel и реализуем интерфейсы ActionListener, MouseMotionListener

public class LayeredPaneDemo extends JPanel implements ActionListener, MouseMotionListener {
    // в поле класса
    // задаем массивы выпадающего списка и цветных слоев
    private String[] layerStrings = { "Yellow (0)", "Magenta (1)", "Cyan (2)", "Red (3)", "Green (4)" };
    private Color[] layerColors = { Color.yellow, Color.magenta, Color.cyan, Color.red, Color.green };
    // задаем переменную основного окна, окна курсора, чекбокса, выпадающего списка
    private JLayeredPane layeredPane;
    private JLabel dukeLabel;
    private JCheckBox onTop;
    private JComboBox layerList;

    //задаем команды действий
    private static String ON_TOP_COMMAND = "ontop";
    private static String LAYER_COMMAND = "layer";

    //задаем константы расположение центра dukeWaveRed.gif от курсора
    private static final int XFUDGE = 40;
    private static final int YFUDGE = 40;

    public LayeredPaneDemo()    {
        // утанавливаем расположение боксов ввертикально (по умолчанию справа-налево)
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        //Создаем загрузку картинки dukeWaveRed.gif
        final ImageIcon icon = createImageIcon("images/dukeWaveRed.gif");

        //Создаем и настраиваем основное окно для цветных блоков
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(300, 310));
        layeredPane.setBorder(BorderFactory.createTitledBorder("Move the Mouse to Move Duke"));
        layeredPane.addMouseMotionListener(this);

        //Устанавливаем метку на расстоянии 10.20 в крайний левый угод для прорисовки цветных блоков
        Point origin = new Point(10, 20);

        // Это смещение для следующей метки (цветного блока)
        int offset = 35;

        // Для каждого элемента массива layerStrings создаем новую панель
        // с цветом из массива layerColors и смещением origin
        for (int i = 0; i < layerStrings.length; i++) {
            // настройки в функции createColoredLabel
            JLabel label = createColoredLabel(layerStrings[i], layerColors[i], origin);
            layeredPane.add(label, new Integer(i));
            origin.x += offset;
            origin.y += offset;
        }

        // Создаем и добавляем dukeWaveRed.gif (или используем черный квадратик 30х30) на многослойную панель
        // которая будет двигаться за курсором
        dukeLabel = new JLabel(icon);
        if (icon != null) {
            dukeLabel.setBounds(150, 225,
                    icon.getIconWidth(),
                    icon.getIconHeight());
        } else {
            System.err.println("Duke icon not found; using black square instead.");
            dukeLabel.setBounds(15, 225, 30, 30);
            dukeLabel.setOpaque(true);
            dukeLabel.setBackground(Color.BLACK);
        }
        // добавляем dukeLabel в панель бокса с цветными блоками
        layeredPane.add(dukeLabel, new Integer(2), 0);

        // Добавьте область бокса управления в многослойную панель, отступ сверху 10
        // Добавляем контрольную панель
        add(createControlPanel());
        // устанавливаем ее расположение
        add(Box.createRigidArea(new Dimension(0, 10)));
        // все добавляем в основное окно
        add(layeredPane);
    }

    // Создаем и настраиваем цветные слои (расположение друг под другом)
    private JLabel createColoredLabel(String text, Color color, Point origin) {
        JLabel label = new JLabel(text);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setOpaque(true); // не прозрачный обязательно
        label.setBackground(color);
        label.setForeground(Color.black);
        label.setBorder(BorderFactory.createLineBorder(Color.black));
        label.setBounds(origin.x, origin.y, 140, 140);
        return label;
    }

    // Создаем блок панели управления в верхней части окна
    private JPanel createControlPanel() {
        // создаем чекбокс с текстом при помощи JCheckBox
        // по умочанию будет активен
        // добавляем лисенера из addActionListener
        onTop = new JCheckBox("Top Position in Layer");
        onTop.setSelected(true);
        onTop.setActionCommand(ON_TOP_COMMAND);
        onTop.addActionListener(this);

        // создаем выпадающий список JComboBox
        // по умолчанию пусть синий слой
        layerList = new JComboBox(layerStrings);
        layerList.setSelectedIndex(2);
        layerList.setActionCommand(LAYER_COMMAND);
        layerList.addActionListener(this);

        // создаем слой для элементов управления
        // добавляем в него layerList (выпадающий список)
        // добавляем в него onTop (чекбокс)
        // пишем заголовок слоя
        // и вовращаем упаковку
        JPanel controls = new JPanel();
        controls.add(layerList);
        controls.add(onTop);
        controls.setBorder(BorderFactory.createTitledBorder(
                "Choose Duke's Layer and Position"));
        return controls;
    }

    // Обрабатывать взаимодействие пользователя с помощью флажка и поля со списком.
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        // если пользователь делает действие с ON_TOP_COMMAND (он активный)
        if (ON_TOP_COMMAND.equals(cmd)) {
            if (onTop.isSelected()) {
                layeredPane.moveToFront(dukeLabel); // переместить на передний план dukeLabel
            } else {
                layeredPane.moveToBack(dukeLabel);
            }
            // если пользователь выбирает что-то из списка, если выбран (isSelected()
            // устанавливаем в layeredPane слой dukeLabel индекс 0 или 1
        } else if (LAYER_COMMAND.equals(cmd)) {
            int position = onTop.isSelected() ? 0 : 1;
            layeredPane.setLayer(dukeLabel, layerList.getSelectedIndex(), position);
        }
    }

    // Загрузка картинки в качетсве метки
    // Возвращает ImageIcon или null, если путь был неверный
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = LayeredPaneDemo.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    // Привязываем иконку метки к курсору
    public void mouseMoved(MouseEvent e) {
        // берем созданные переменные класса
        dukeLabel.setLocation(e.getX()-XFUDGE, e.getY()-YFUDGE);
    }
    public void mouseDragged(MouseEvent e) {} //ничего не делает, но без него не работает


    /**
     * Создайте графический интерфейс и покажите его. Для безопасности потока, этот метод должен быть
     * вызван из поток диспетчеризации событий.
     */
    private static void createAndShowGUI() {
        // Создаем и настраиваем само окно программы
        JFrame frame = new JFrame("LayeredPaneDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Размещаем содержимое с помощью JComponent
        JComponent newContentPane = new LayeredPaneDemo();
        newContentPane.setOpaque(true); //не должен быть прозрачным
        frame.setContentPane(newContentPane);

        // Отображение окна
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
    createAndShowGUI();
    }
}