package ru.geekbrains.java1.lesson8_swing;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Создали класс MyWindow и унаследовали его от стандартного класса графического окна JFrame
public class MyWindow extends JFrame{
    //Конструктор окна:
    public MyWindow(){
        setTitle("Java");
        setBounds(400, 200, 800, 400);//начальные координаты окна и его размер
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setResizable(false);//чтобы фиксировать размер окна (чтобы его нельзя было растягивать)

        //Пример BorderLayout (без объявления компонощика):
//        JButton jb1 = new JButton("ЦЕНТР");//Создали кнопку jb1 (объект) с надписью "ЦЕНТР"
//        add(jb1, BorderLayout.CENTER);//добавляем кнопку на форму (наше окно)
//        JButton jb2 = new JButton("СЕВЕР");
//        jb2.setPreferredSize(new Dimension(100, 200));//установка предпочтительного размера кнопки ШхВ, для СЕВЕРа значение Ш проигнорится
//        add(jb2, BorderLayout.NORTH);
//        JButton jb3 = new JButton("ЮГ");
//        add(jb3, BorderLayout.SOUTH);
//        JButton jb4 = new JButton("ЗАПАД");
//        add(jb4, BorderLayout.WEST);
//        JButton jb5 = new JButton("ВОСТОК");
//        add(jb5, BorderLayout.EAST);

        //Сетка: 4 строки, 3 столбца
//        setLayout(new GridLayout(4,3)); //сетка 4 строки на 3 столбца
//        JButton[] jbs = new JButton[10];
//        for (int i = 0; i < jbs.length ; i++) {
//            jbs[i] = new JButton("Кнопака " + i);
//            add(jbs[i]);
//        }

        //Создадим мини-чат:
//        setLayout(new FlowLayout());//Компоновщик, в котором элементы располагаются др. за др., как бы в потоке:
//        JTextField jtf = new JTextField(20);//текстовая строка из 20 символов
//        add(jtf);
//        JButton jbSend = new JButton("SEND");//Кнопка "отправить"
//        add(jbSend);
//
//        JTextArea jta = new JTextArea(20, 10);//создали текст. область 20 строк по 10 элементов
//        jta.setLineWrap(true);//устанавливаем автомат.перенос на след.строку
//        //add(jta); //это было бы нужно, если бы не поместили внутрь полос прокрутки (см. ниже)
//        JScrollPane jsp = new JScrollPane(jta);//помещаем текст.обл. внутрь полос прокрутки
//        add(jsp);
//
//        //обработка нажатия кнопки SEND (вешаем прослушиватель на кнопку jbSend):
//        jbSend.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                jta.append(jtf.getText() + "\n");//добавляем в область jta текст из строки
//                //System.out.println(jtf.getText());//отправка текста из строки в консоль
//                jtf.setText("");//очищаем строку после отправки
//                jtf.grabFocus();//фокусировка курсора на текстовом поле (строке) после нажатия кнопки
//            }
//        });
//        //Обработка нажатия [Enter]: Вешаем прослушиватель на текстовое поле
//        jtf.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println(jtf.getText());//отправка текста из поля(строки) в консоль
//                jtf.setText("");//очищаем строку после отправки
//            }
//        });

        //Создадим на Окне сетку из 2-х элементов
        setLayout(new GridLayout(1,2));//Установим компоновщик GridLayout для 2-х элементов

        JPanel jpLeft = new JPanel();//Создаём левую панель
        add(jpLeft);//Добавим в окно. jpLeft займёт место 1-го элемента в сетке
        jpLeft.setBackground(Color.LIGHT_GRAY);//зададим фон левой панели
        jpLeft.setBorder(new LineBorder(Color.DARK_GRAY, 2)); //делаем рамку вокруг лев. панели тощиной 2 пикселя
        jpLeft.setLayout(new BoxLayout(jpLeft, BoxLayout.Y_AXIS)); //задаём компоновщик BoxLayout для левой панели по оси Y

        //Создаём кнопки и добавляем их на левую панель:
        JButton jbl1 = new JButton("Кнопка 1");
        jpLeft.add(jbl1);
        JButton jbl2 = new JButton("Кнопка 2");
        jpLeft.add(jbl2);
        JButton jbl3 = new JButton("Кнопка 3");
        jpLeft.add(jbl3);

        JPanel jpRight = new JPanel();//Создаём правую панель
        add(jpRight);//Добавим в окно. jpRight займёт место 2-го элемента в сетке
        jpRight.setLayout(new CardLayout()); //задаём компоновщик CardLayout() для правой панели - в одном таком "окошке" могут появляться разные "окошки"
        //Создаём панельки для будущего отображения на правой панели:
        //JPanel jpRed = new JPanel();// было до использования созданного класса PaintPanel - "Панель для рисования"
        PaintPanel jpRed = new PaintPanel();//jpRed ссылается на панель PaintPanel, которую сами создали
        jpRed.setBackground(Color.RED);
        JPanel jpGreen = new JPanel();//
        jpGreen.setBackground(Color.GREEN);
        JPanel jpBlue = new JPanel();
        jpBlue.setBackground(Color.BLUE);
        //Теперь добавляем в правую панель разноцветные панели. Здесь "RED" и т.д. имена панелек, выбраны в соответствии цвету
        jpRight.add(jpRed, "RED");
        jpRight.add(jpGreen, "GREEN");
        jpRight.add(jpBlue, "BLUE");
        ((CardLayout)jpRight.getLayout()).show(jpRight, "RED"); //по умолчанию показываем(show) красную панельку

        jbl1.addActionListener(new ActionListener() { //устанавливаем Прослушиватель события для Кнопки 1
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Кнопка 1 нажата"); //для примера действия
                ((CardLayout)jpRight.getLayout()).show(jpRight, "RED");//показываем красную панельку
            }
        });

        jbl2.addActionListener(new ActionListener() { //для 2-й кнопки
            @Override
            public void actionPerformed(ActionEvent e) {
                ((CardLayout)jpRight.getLayout()).show(jpRight, "GREEN");
            }
        });

        jbl3.addActionListener(new ActionListener() { //для 3-й кнопки
            @Override
            public void actionPerformed(ActionEvent e) {
                ((CardLayout)jpRight.getLayout()).show(jpRight, "BLUE");
            }
        });

        JLabel j1 = new JLabel("ТЕКСТ");//создали объект-надпись
        jpLeft.add(j1);//добавили на лев.панель
        JTextField jtf = new JTextField(10);//создали объект однострочное текстовое поле (из 10 символов)
        jpLeft.add(jtf); //добавили на лев. панель

        setVisible(true);//всегда пишется в самом конце
    }
}
