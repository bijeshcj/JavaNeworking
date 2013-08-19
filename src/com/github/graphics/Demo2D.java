package com.github.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created with IntelliJ IDEA.
 * User: Bijesh C J
 * Date: 27/7/13
 * Time: 5:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class Demo2D extends JFrame {

    public Demo2D(){
        super("Demo2D");
        this.add(new Panel2D());
    }

    public static void main(String... str){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new Demo2D();
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(new Dimension(800,500));
                frame.setVisible(true);
            }
        });
    }
    class Panel2D extends JPanel{
        private Panel2D(){
            setPreferredSize(new Dimension(600,500));
            setBackground(Color.WHITE);
        }

        public void paintComponent(Graphics g){
            Graphics2D g2 = (Graphics2D)g;

            Shape ellipse = new Ellipse2D.Double(150,50,200,200);
            GradientPaint paint = new GradientPaint(100,100,Color.WHITE,400,400,Color.GRAY);
            g2.setPaint(paint);
            g2.fill(ellipse);

            AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.4f);
            g2.setComposite(ac);
            g2.setColor(Color.blue);

        }
    }
}
