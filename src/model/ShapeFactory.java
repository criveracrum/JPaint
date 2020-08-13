package model;

import model.interfaces.IApplicationState;
import view.*;
import view.interfaces.PaintCanvasBase;

public class ShapeFactory {

    private static int width;
    private static int height;
    private static int xPoint;
    private static int yPoint;
    private static  IApplicationState appState;
    private static PaintCanvasBase paintCanvas;
    private static IShape shape;

    public static IShape create() {
        if (appState.getActiveShapeType() == ShapeType.ELLIPSE) {

            IShapeStrategy ellipse = new DrawEllipse();
            shape = new model.Shape(width, height, xPoint, yPoint, appState, paintCanvas, ellipse);




        } else if (appState.getActiveShapeType() == ShapeType.RECTANGLE) {
            IShapeStrategy rectangle = new DrawRectangle();
            shape = new model.Shape(width, height, xPoint, yPoint, appState, paintCanvas, rectangle);



        } else if (appState.getActiveShapeType() == ShapeType.TRIANGLE) {
            IShapeStrategy triangle = new DrawTriangle();
            shape = new model.Shape(width, height, xPoint, yPoint, appState, paintCanvas, triangle);
        }

        return shape;
    }
    public ShapeFactory(int width, int height, int xPoint, int yPoint, IApplicationState appState, PaintCanvasBase paintCanvas) {

        this.width = width;
        this.height = height;
        this.xPoint = xPoint;
        this.yPoint = yPoint;
        this.appState = appState;
        this.paintCanvas = paintCanvas;
    }
}
