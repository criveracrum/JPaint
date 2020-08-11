package controller;

import model.IShape;
import model.Shape;
import model.ShapeList;

import java.util.ArrayList;
import java.util.List;

public class PasteCommand implements ICommand, IUndoRedo{
    private ShapeList list;
    private ArrayList<IShape> pasted = new ArrayList<IShape>();
    public PasteCommand(ShapeList shapeList) {

        this.list=  shapeList;

    }

    @Override
    public void run() {

        for (IShape shape : list.getCopyList()) {
            IShape copyShape = shape.getDuplicateShape();
            list.listAdd(copyShape);
            copyShape.draw();
            pasted.add(copyShape);

        }
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        list.listRemoveAllOriginal(pasted);
    }

    @Override
    public void redo() {
        list.listAddAllNew(pasted);
    }
}
