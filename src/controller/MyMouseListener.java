package controller;

import model.Point;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import static java.lang.System.out;

public class MyMouseListener extends MouseAdapter {

    private Point startPoint;

    private PaintCanvasBase paintCanvas;

    public MyMouseListener(PaintCanvasBase paintCanvas){
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void mousePressed(MouseEvent e) {

        startPoint = new Point(e.getX(), e.getY());

    }


    @Override
    public void mouseReleased(MouseEvent e) {


        int width = Math.abs(e.getX() - startPoint.getX());
        int height = Math.abs(e.getY() - startPoint.getY());

        ICommand draw = new drawCommand(paintCanvas, width, height, Math.min(startPoint.getX(),e.getX()),
                Math.min(startPoint.getY(), e.getY()));
        draw.run();


    }
}
