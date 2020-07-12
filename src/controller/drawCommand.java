package controller;


import model.IShape;
import model.Shape;
import model.ShapeType;
import model.interfaces.IApplicationState;
import view.DrawEllipse;
import view.DrawRectangle;
import view.DrawTriangle;
import view.IShapeStrategy;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class drawCommand implements ICommand {

    private PaintCanvasBase paintCanvas;
    private int width;
    private int height;
    private int xPoint;
    private int yPoint;
    private IApplicationState appState;



    public drawCommand(PaintCanvasBase paintCanvas, int width, int height, int xPoint, int yPoint, IApplicationState appState){
        this.paintCanvas = paintCanvas;
        this.width = width;
        this.height = height;
        this.xPoint = xPoint;
        this.yPoint = yPoint;
        this.appState = appState;

    }

    @Override
    public void run() {

        Shape shape = new model.Shape(width, height, xPoint, yPoint, appState, paintCanvas);

        shape.draw();

    }
}
