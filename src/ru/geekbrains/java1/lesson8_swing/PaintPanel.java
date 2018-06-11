package ru.geekbrains.java1.lesson8_swing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PaintPanel extends JPanel{
    private BufferedImage bim = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);//создаём изображение - поле для рисования размером 200х200
    private BufferedImage bimFromFile; //переменная под загрузку изображения

    //Конструктор:
    public PaintPanel() {
        setBackground(Color.WHITE);//задаём начальный цвет фона
        try {
            bimFromFile = ImageIO.read(new File("forJava.jpg"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        //Прослушиватели для мыши:
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {//метод отслеживания движения нажатой мышкой
                Graphics g = bimFromFile.getGraphics(); //созаём объект, которым будем рисовать на картинке "bimFromFile"
                //Graphics g = bim.getGraphics(); //созаём объект, которым будем рисовать на картинке "bim"
                g.fillRect(e.getX(), e.getY(), 5, 5); //здесь выполняется запрос местоположения мыши и задаётся размер 5х5 пикс. - толлщина нашего пера
                repaint();//метод для того, чтобы постоянно происходило обновление рисунка - чтобы отображалось рисуемое

            }

            @Override
            public void mouseMoved(MouseEvent e) { //метод отслеживания движения мышкой
//                Graphics g = bim.getGraphics(); //созаём объект, которым будем рисовать
//                g.fillRect(e.getX(), e.getY(), 5, 5); //здесь выполняется запрос местоположения мыши и задаётся размер 5х5 пикс. - толлщина нашего пера
//                repaint();//чтобы постоянно происходило обновление рисунка - чтобы отображалось рисуемое
            }
        });
    }

    //Метод, с помощью которого сможем рисовать на PaintPanel:
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bimFromFile, 0, 0, this);
        //g.drawImage(bim, 0, 0, this); //нарисовали изображение "bim" в начальной точке 0, 0. Объект здесь ссылается сам на себя (this)
        //g.setColor(Color.ORANGE);//задаём цвет "ручки" "g"
        //g.fillRect(20, 20, 100, 100);//рисуем прямоугольник
    }
}
