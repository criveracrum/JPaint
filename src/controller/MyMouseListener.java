package controller;

import model.Point;
import model.ShapeList;
import model.StartAndEndPointMode;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import static java.lang.System.out;

public class MyMouseListener extends MouseAdapter {

    private final ShapeList shapeList;
    private Point startPoint;

    private PaintCanvasBase paintCanvas;

    private IApplicationState appState;


    public MyMouseListener(PaintCanvasBase paintCanvas, IApplicationState appState, ShapeList shapeList){
        this.paintCanvas = paintCanvas;
        this.appState = appState;
        this.shapeList = shapeList;
    }

    @Override
    public void mousePressed(MouseEvent e) {

        startPoint = new Point(e.getX(), e.getY());

    }


    @Override
    public void mouseReleased(MouseEvent e) {

        StartAndEndPointMode modeSelect = appState.getActiveStartAndEndPointMode();

        int width = Math.abs(e.getX() - startPoint.getX());
        int height = Math.abs(e.getY() - startPoint.getY());
        if (modeSelect.equals(StartAndEndPointMode.DRAW)) {
            ICommand draw = new drawCommand(paintCanvas, width, height, Math.min(startPoint.getX(), e.getX()),
                    Math.min(startPoint.getY(), e.getY()), appState, shapeList);
            draw.run();
        }
        else if (modeSelect.equals(StartAndEndPointMode.SELECT)){
            ICommand select = new selectCommand(width, height, Math.min(startPoint.getX(), e.getX()),
                    Math.min(startPoint.getY(), e.getY()), shapeList);
            select.run();

        }
        else if (modeSelect.equals(StartAndEndPointMode.MOVE)){
            ICommand move = new moveCommand(Math.min(startPoint.getX(), e.getX()),
                    Math.min(startPoint.getY(), e.getY()), shapeList);
            move.run();
        }

    }
}
