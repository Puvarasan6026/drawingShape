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
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import static java.lang.Math.abs;
import javax.swing.*;
 
public class Area extends JPanel implements MouseListener, MouseMotionListener {
    private Image image; // draw on this image
    private Graphics graphics;
    private static Color bgColor = Color.GRAY, penColor = Color.YELLOW;
    private static int pen = 4;
    private int type = 1,x1,x2,y1,y2;;
    private Point releasePoint = new Point(), pressPoint = new Point(), mousePnt = new Point();
    private boolean isDrawing = false, finishDrawing = false;
    
    public static void setPenColor(Color penColor) {
        Area.penColor = penColor;
    }

    public static void setPen(int pen) {
        Area.pen = pen;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void setReleasePoint(Point releasePoint) {
        this.releasePoint = releasePoint;
    }

    public void setPressPoint(Point pressPoint) {
        this.pressPoint = pressPoint;
    }

    public void setMousePnt(Point mousePnt) {
        this.mousePnt = mousePnt;
    }

    public void setIsDrawing(boolean isDrawing) {
        this.isDrawing = isDrawing;
    }

    public void setFinishDrawing(boolean finishDrawing) {
        this.finishDrawing = finishDrawing;
    }
    
    public Area () {}
    
    private void draw() {
        
        if (graphics != null) {
            int width = Math.abs(x1 - x2);
            int height = Math.abs(y1 - y2);
            
            // for type 4 and 5
            int xAdjust = 0, yAdjust = 0, xValue, yValue, xPartition, yPartition;
          

            // array of coordinates
            int[] xCoordinates, yCoordinates;

    
            Point targetXPoint, targetYPoint;

            graphics.setColor(penColor);
            
            switch(type) {
                case 1:
                    graphics.fillOval(mousePnt.x, mousePnt.y, pen, pen);
                    break;
                case 2: 
                    graphics.fillRect(x1, y1, width, height);
                    isDrawing = false;
                    break;
                case 3:
                    graphics.fillOval(x1, y1, width, height);
                    isDrawing = false;
                    break;
                case 4:
                    xCoordinates = new int[3];
                    yCoordinates = new int[3];
                    xValue = abs(releasePoint.x - pressPoint.x);
                    yValue = abs(releasePoint.y - pressPoint.y);
                    xPartition = xValue/4;
                    yPartition = yValue/3;

                    int[] xRatio3 = {2,3,1};
                    int[] yRatio3 = {0,3,3};

                    if (releasePoint.x > pressPoint.x) targetXPoint = pressPoint;
                    else targetXPoint = releasePoint;

                    if (releasePoint.y > pressPoint.y) targetYPoint = pressPoint;
                    else targetYPoint = releasePoint;

                    for (int i=0; i<3; i++) {
                        xCoordinates[i] = targetXPoint.x + (xRatio3[i]*xPartition) + xAdjust;
                        yCoordinates[i] = targetYPoint.y + (yRatio3[i]*yPartition) + yAdjust;
                    };

                    graphics.fillPolygon(xCoordinates,yCoordinates,3);
                    break;
                case 5: 
 
                    graphics.setColor(penColor);

                 
                    xCoordinates = new int[5];
                    yCoordinates = new int[5];
                    xValue = abs(releasePoint.x - pressPoint.x);
                    yValue = abs(releasePoint.y - pressPoint.y);
                    xPartition = xValue/4;
                    yPartition = yValue/3;

   
                    int[] xRatio5 = {0,2,4,3,1};
                    int[] yRatio5 = {1,0,1,3,3};

                    if (releasePoint.x > pressPoint.x) targetXPoint = pressPoint;
                    else targetXPoint = releasePoint;

                    if (releasePoint.y > pressPoint.y) targetYPoint = pressPoint;
                    else targetYPoint = releasePoint;

                    for (int i=0; i<5; i++) {
                        xCoordinates[i] = targetXPoint.x + (xRatio5[i]*xPartition) + xAdjust;
                        yCoordinates[i] = targetYPoint.y + (yRatio5[i]*yPartition) + yAdjust;
                    };

                    graphics.fillPolygon(xCoordinates,yCoordinates,5);
                    break;
            }
        }
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        if (type == 1) {
            mousePnt = e.getPoint();
            draw();
            repaint();
        }
        else if (type == 4){
            mousePnt = e.getPoint();
            
        }
        else if (type == 5) {
            mousePnt = e.getPoint();
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(type);

        if (e.getModifiers() == MouseEvent.BUTTON3_MASK) //button3 = right click
            penColor = JColorChooser.showDialog(null, "Change Pen Color", penColor);
    }

    @Override
    public void mouseMoved(MouseEvent e) {}
    
    @Override
    public void mousePressed(MouseEvent e) {
        if (type == 1){
            x1 = e.getX();
            y1 = e.getY();
        }
        else if (type == 2 && isDrawing == false) {
            x1 = e.getX();
            y1 = e.getY();
            isDrawing = true;

        }
        else if (type == 3 && isDrawing == false) {
            x1 = e.getX();
            y1 = e.getY();
            isDrawing = true;
        }

        else if (type == 4 && isDrawing == false) {
            pressPoint = e.getPoint();
            finishDrawing = true;
        }

        else if (type == 5 && isDrawing == false) {
            pressPoint = e.getPoint();
            finishDrawing = true;
        }

        else if (isDrawing == true && finishDrawing == false && type == 2) {
            x2 = e.getX();
            y2 = e.getY();
            System.out.println("X2 HERE");
            finishDrawing = true;
        }
        else if (isDrawing == true && finishDrawing == false && type == 3) {
            x2 = e.getX();
            y2 = e.getY();
            finishDrawing = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (finishDrawing == true && type == 2) {
            draw();
            isDrawing = false;
            finishDrawing = false;
        }
        
        else if (finishDrawing == true && type == 3) {
            draw();
            isDrawing = false;
            finishDrawing = false;
        }

        else if (finishDrawing == true && type == 4) {
            releasePoint = e.getPoint();
            draw();
            isDrawing = false;
            finishDrawing = false;
        }
            
        else if (finishDrawing == true && type == 5) {
            releasePoint = e.getPoint();
            draw();
            isDrawing = false;
            finishDrawing = false;
        }
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
    @Override
    protected void paintComponent(Graphics g) {
        if (image == null) { // initially image will be null
          image = createImage(getSize().width, getSize().height);
          graphics = image.getGraphics();
          clearScreen();
        }
        g.drawImage(image, 0, 0, null);
    }

    public void clearScreen() {
        // instead of clearing the entire screen, we create a huge rectangle to cover the canvas 
        graphics.setColor(bgColor);
        graphics.fillRect(0, 0, getSize().width, getSize().height);
        graphics.setColor(penColor);
        System.out.println("Entered clear screen");
        repaint();
    }
}