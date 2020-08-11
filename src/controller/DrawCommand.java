package controller;


import model.IShape;
import model.Shape;
import model.ShapeList;
import model.ShapeType;
import model.interfaces.IApplicationState;
import view.DrawEllipse;
import view.DrawRectangle;
import view.DrawTriangle;
import view.IShapeStrategy;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class DrawCommand implements ICommand, IUndoRedo{

    private final ShapeList list;
    private PaintCanvasBase paintCanvas;
    private int width;
    private int height;
    private int xPoint;
    private int yPoint;
    private IApplicationState appState;
    private IShape shape;




    public DrawCommand(PaintCanvasBase paintCanvas, int width, int height, int xPoint, int yPoint, IApplicationState appState, ShapeList list){
        this.paintCanvas = paintCanvas;
        this.width = width;
        this.height = height;
        this.xPoint = xPoint;
        this.yPoint = yPoint;
        this.appState = appState;
        this.list = list;

    }

    @Override
    public void run() {

        shape = new model.Shape(width, height, xPoint, yPoint, appState, paintCanvas);
        list.listAdd(shape);
        CommandHistory.add(this);


    }


    @Override
    public void undo() {
        list.listRemove(shape);
    }

    @Override
    public void redo() {
        list.listAdd(shape);
    }
}
