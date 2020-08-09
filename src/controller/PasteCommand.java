package controller;

import model.IShape;
import model.Shape;
import model.ShapeList;

import java.util.List;

public class PasteCommand implements ICommand{
    private ShapeList list;
    public PasteCommand(ShapeList shapeList) {

        this.list=  shapeList;

    }

    @Override
    public void run() {

        for (IShape shape : list.getCopyList()) {
            IShape copyShape = shape.getDuplicateShape();
            list.listAdd(copyShape);
            copyShape.draw();
        }
    }
}
