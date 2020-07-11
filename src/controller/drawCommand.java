package controller;


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

        Graphics2D graphics2d = paintCanvas.getGraphics2D();

        ShapeType shapeType = appState.getActiveShapeType();



        if (shapeType == ShapeType.ELLIPSE) {
            IShapeStrategy ellipse = new DrawEllipse(paintCanvas, width, height, xPoint, yPoint, appState);
            ellipse.draw();


        }
        else if (shapeType == ShapeType.RECTANGLE){
            IShapeStrategy rectangle = new DrawRectangle(paintCanvas, width, height, xPoint, yPoint, appState);
            rectangle.draw();


        }
        else if (shapeType == ShapeType.TRIANGLE){
            IShapeStrategy triangle = new DrawTriangle(paintCanvas, width, height, xPoint, yPoint, appState);
            triangle.draw();

        }

    }
}
