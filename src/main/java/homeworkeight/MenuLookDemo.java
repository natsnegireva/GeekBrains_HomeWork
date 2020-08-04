package homeworkeight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/* MenuLookDemo.java требует файла images/middle.gif
 * Этот класс не имеет обработки событий, связанных с меню.
 */
public class MenuLookDemo {
    JTextArea output;
    JScrollPane scrollPane;

    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;

        //Создаем меню-бар
        menuBar = new JMenuBar();

        //Создаем первое меню
        menu = new JMenu("A Menu");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
        menuBar.add(menu);

        //Создаем группу пунктов меню JMenuItems
        menuItem = new JMenuItem("A text-only menu item", KeyEvent.VK_T);
        // пункт меню.setMnemonic(KeyEvent.VK_T);
        // вместо этого используется конструктор
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
        menu.add(menuItem);

        ImageIcon icon = createImageIcon("images/middle.gif");
        menuItem = new JMenuItem("Both text and icon", icon);
        menuItem.setMnemonic(KeyEvent.VK_B);
        menu.add(menuItem);

        menuItem = new JMenuItem(icon);
        menuItem.setMnemonic(KeyEvent.VK_D);
        menu.add(menuItem);

        //Создаем группу элементов меню типа Радио
        menu.addSeparator();
        ButtonGroup group = new ButtonGroup();

        rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_R);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

        rbMenuItem = new JRadioButtonMenuItem("Another one");
        rbMenuItem.setMnemonic(KeyEvent.VK_O);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

        //Создаем группу пунктов меню Чекбоксов
        menu.addSeparator();
        cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
        cbMenuItem.setMnemonic(KeyEvent.VK_C);
        menu.add(cbMenuItem);

        cbMenuItem = new JCheckBoxMenuItem("Another one");
        cbMenuItem.setMnemonic(KeyEvent.VK_H);
        menu.add(cbMenuItem);

        //Создаем суб-меню
        menu.addSeparator();
        submenu = new JMenu("A submenu");
        submenu.setMnemonic(KeyEvent.VK_S);

        menuItem = new JMenuItem("An item in the submenu");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_2, ActionEvent.ALT_MASK));
        submenu.add(menuItem);

        menuItem = new JMenuItem("Another item");
        submenu.add(menuItem);
        menu.add(submenu);

        //Строим второе меню
        menu = new JMenu("Another Menu");
        menu.setMnemonic(KeyEvent.VK_N);
        menu.getAccessibleContext().setAccessibleDescription(
                "This menu does nothing");
        menuBar.add(menu);

        return menuBar;
    }

    public Container createContentPane() {
        //Создаем контент-панель и реализуем.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);

        //Создаем область прокрутки текста
        output = new JTextArea(5, 30);
        output.setEditable(false);
        scrollPane = new JScrollPane(output);

        //Добавляем текстовую область на панель
        contentPane.add(scrollPane, BorderLayout.CENTER);

        return contentPane;
    }

    // Возвращает ImageIcon или null, если путь был неверным
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = MenuLookDemo.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * Создание графический интерфейс и отображение его.
     * Для безопасности потока, этот метод должен быть вызван из поток диспетчеризации событий.
     */
    private static void createAndShowGUI() {
        //Создание и настройка окна
        JFrame frame = new JFrame("MenuLookDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Создание панели с содержимым
        MenuLookDemo demo = new MenuLookDemo();
        frame.setJMenuBar(demo.createMenuBar());
        frame.setContentPane(demo.createContentPane());

        //Показываем окно
        frame.setSize(450, 260);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}