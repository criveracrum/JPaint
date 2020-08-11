package controller;

import model.IShape;
import model.ShapeList;

import java.util.ArrayList;
import java.util.List;

public class DeleteCommand implements ICommand, IUndoRedo{

    private final ShapeList shapeList;
    private ArrayList<IShape> removed = new ArrayList<IShape>();

    public DeleteCommand(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

    @Override
    public void run() {

        for (IShape each : shapeList.getList()){
            if (each.getSelected()) {
                //shapeList.listRemove(each);
                removed.add(each);
            }
        }
        shapeList.listRemoveAllOriginal(removed);
        CommandHistory.add(this);
        }

    @Override
    public void undo() {
        shapeList.listAddAllNew(removed);
    }

    @Override
    public void redo() {
        shapeList.listRemoveAllOriginal(removed);
    }
}

