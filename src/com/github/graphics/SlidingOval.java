package com.github.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

/**
 * Created with IntelliJ IDEA.
 * User: npcompete
 * Date: 7/9/13
 * Time: 3:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class SlidingOval extends JFrame{
    public SlidingOval(){
        super("Sliding Oval");
        this.add(new SlidingPanel());
    }

    /**
     *
     * inner class which is type JPanel
     */
    private class SlidingPanel extends JPanel{
        private SlidingPanel(){

        }
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;

            g2.setColor(Color.BLUE);
            Ellipse2D e = new Ellipse2D.Double(-100,-50,200,40);
            AffineTransform tr = new AffineTransform();
            tr.rotate(Math.PI/6.0);
            Shape sh = tr.createTransformedShape(e);
            g2.translate(300,250);
            g2.scale(2,2);
            g2.draw(sh);

        }
    }

    public static void main(String[] str){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new SlidingOval();
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(new Dimension(600,500));
                frame.setVisible(true);
            }
        });
    }
}
