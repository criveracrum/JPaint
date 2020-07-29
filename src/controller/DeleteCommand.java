package controller;

import model.IShape;
import model.ShapeList;

import java.util.ArrayList;
import java.util.List;

public class DeleteCommand implements ICommand{

    private final ShapeList shapeList;

    public DeleteCommand(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

    @Override
    public void run() {
        ArrayList<IShape> removed = new ArrayList<IShape>();
        for (IShape each : shapeList.getList()){
            if (each.getSelected()) {
                shapeList.listRemove(each);
                removed.add(each);
            }
        }
        shapeList.listRemoveAllOriginal(removed);
        }
    }

