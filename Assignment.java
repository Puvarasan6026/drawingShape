/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Assignment extends JFrame implements ChangeListener {
    private static int pen = 4;
    private int type = 1;
    private Area canvas;
    private Menu toolbar;
    
    public Assignment() {
        super("AssignmentOOAD - Painter");
        init();
    }
    
    private void init() {
        canvas = new Area();
        canvas.addMouseListener(canvas);
        canvas.addMouseMotionListener(canvas);
        toolbar = new Menu();
        
        JSlider penSize = toolbar.getPenSize();
        JButton buttonRect = toolbar.getRect();
        JButton buttonOval = toolbar.getOval();
        JButton buttonPen = toolbar.getPen();
        JButton buttonTriangle = toolbar.getTriangle();
        JButton buttonPentagon = toolbar.getPentagon();
        JButton buttonClear = toolbar.getClear();
        
        penSize.addChangeListener(this);
        buttonRect.addActionListener(new ButtonAction());
        buttonOval.addActionListener(new ButtonAction());
        buttonPen.addActionListener(new ButtonAction());
        buttonTriangle.addActionListener(new ButtonAction());
        buttonPentagon.addActionListener(new ButtonAction());
        buttonClear.addActionListener(new ButtonAction());
        
        this.add(toolbar, BorderLayout.NORTH);
        this.add(canvas, BorderLayout.CENTER);
        this.setSize(1300,1000);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    class ButtonAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case Menu.buttonPen: type = 1; break;
                case Menu.buttonRec: type = 2; break;
                case Menu.buttonOva: type = 3; break;
                case Menu.buttonTri: type = 4; break;
                case Menu.buttonPnt: type = 5; break;
                case Menu.buttonClr: canvas.clearScreen(); break;
            }
            canvas.setType(type);
        }
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        // value of the pen size will change after we scroll the bar
        JSlider source = (JSlider)e.getSource();
        if (!source.getValueIsAdjusting())
            pen = (int)source.getValue();
        Area.setPen(pen);
    }
    
    public static void main(String[] a){
        new Assignment();
    }
}

