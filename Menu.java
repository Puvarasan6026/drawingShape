/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author MINH
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Menu extends JPanel {
    public static final String buttonRec = "Rect";
    public static final String buttonOva = "Oval";
    public static final String buttonPen = "Pen";
    public static final String buttonTri = "Triangle";
    public static final String buttonPnt = "Pentagon";
    public static final String buttonClr = "Clear";
    private JButton rect = new JButton(buttonRec);
    private JButton oval = new JButton(buttonOva);
    private JButton pen = new JButton(buttonPen);
    private JButton triangle = new JButton(buttonTri);
    private JButton pentagon = new JButton(buttonPnt);
    private JButton clear = new JButton(buttonClr);
    private JSlider penSize = new JSlider(JSlider.HORIZONTAL, 1, 30, 4); // (orientation, min, max, initial)

    public JButton getRect() {
        return rect;
    }

    public JButton getOval() {
        return oval;
    }

    public JButton getPen() {
        return pen;
    }

    public JButton getTriangle() {
        return triangle;
    }

    public JButton getPentagon() {
        return pentagon;
    }

    public JButton getClear() {
        return clear;
    }

    public JSlider getPenSize() {
        return penSize;
    }
    
    private void initButton() {
        rect.setIcon(new ImageIcon(this.getClass().getResource("rectangle.png")));
        oval.setIcon(new ImageIcon(this.getClass().getResource("oval.png")));
        triangle.setIcon(new ImageIcon(this.getClass().getResource("triangle.png")));
        pentagon.setIcon(new ImageIcon(this.getClass().getResource("pentagon.png")));
        rect.setPreferredSize(new Dimension(130,35));
        oval.setPreferredSize(new Dimension(130,35));
        triangle.setPreferredSize(new Dimension(130,35));
        pentagon.setPreferredSize(new Dimension(130,35));
        pen.setForeground(Color.red);
        clear.setForeground(Color.blue);
    }
    
    public Menu() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 50));
        
        this.add(new Label("Drag mouse to draw"));
        this.add(pen);
        this.add(penSize);
        this.add(rect);
        this.add(oval);
        this.add(triangle);
        this.add(pentagon);
        this.add(clear);
        initButton();
    }
}

