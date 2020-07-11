package controller;

import model.Point;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import static java.lang.System.out;

public class MyMouseListener extends MouseAdapter {

    private Point startPoint;

    private PaintCanvasBase paintCanvas;

    private IApplicationState appState;


    public MyMouseListener(PaintCanvasBase paintCanvas, IApplicationState appState){
        this.paintCanvas = paintCanvas;
        this.appState = appState;
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
                Math.min(startPoint.getY(), e.getY()), appState);
        draw.run();


    }
}
