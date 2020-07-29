package controller;

import model.IShape;
import model.ShapeList;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.ArrayList;

public class RepaintCommand implements ICommand{

    private IShape shape;
    private ArrayList<IShape> shapeList;

    private PaintCanvasBase paintCanvas;

    public RepaintCommand(ArrayList<IShape> shapeList, PaintCanvasBase paintCanvas, IShape shape) {
        this.paintCanvas=paintCanvas;
        this.shapeList = shapeList;
        this.shape = shape;
    }

    @Override
    public void run() {


        for (IShape each : shapeList){
            System.out.println("Repaint");
            each.draw();
        }



    }
}
