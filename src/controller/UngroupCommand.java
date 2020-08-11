package controller;

import model.CompositeGroupShape;
import model.IShape;
import model.ShapeList;

import java.util.ArrayList;
import java.util.Objects;

public class UngroupCommand implements ICommand, IUndoRedo{
    private final ShapeList shapeList;
    private IShape group;
    ArrayList<IShape> children = new ArrayList<>();
    ArrayList<IShape> remove = new ArrayList<>();

    public UngroupCommand(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

    @Override
    public void run() {

        for (IShape each : shapeList.getList())
            if (each instanceof CompositeGroupShape){
                group=each;
                CompositeGroupShape each2 = (CompositeGroupShape) each;
                children=  each2.getChildren();
                each2.setSelected();
                each2.draw();
                remove.add(each);
                }
        shapeList.listRemoveAllOriginal(remove);
        shapeList.listAddAllNew(children);
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        group.setSelected();
        shapeList.listRemoveAllOriginal(children);
        shapeList.listAdd(group);
        group.draw();

    }

    @Override
    public void redo() {
        group.setSelected();
        shapeList.listRemoveAllOriginal(remove);
        shapeList.listAddAllNew(children);
    }
}
