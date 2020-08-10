package controller;

import model.CompositeGroupShape;
import model.IShape;
import model.ShapeList;

import java.util.ArrayList;
import java.util.Objects;

public class UngroupCommand implements ICommand{
    private final ShapeList shapeList;

    public UngroupCommand(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

    @Override
    public void run() {
        ArrayList<IShape> children = new ArrayList<>();
        ArrayList<IShape> remove = new ArrayList<>();
        for (IShape each : shapeList.getList())
            if (each instanceof CompositeGroupShape){
                CompositeGroupShape each2 = (CompositeGroupShape) each;
                children=  each2.getChildren();
                each2.setSelected();
                each2.draw();
                remove.add(each);
                }
        shapeList.listRemoveAllOriginal(remove);
        shapeList.listAddAllNew(children);

    }
}
