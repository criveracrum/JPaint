package controller;

import model.CompositeGroupShape;
import model.IShape;
import model.ShapeList;

import java.util.ArrayList;

public class GroupCommand implements ICommand{
    private final ShapeList shapeList;
    private CompositeGroupShape group;

    public GroupCommand(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

    @Override
    public void run() {
        ArrayList<IShape> toRemove = new ArrayList<IShape>();
        group = new CompositeGroupShape(shapeList.getPaintCanvas());
        for (IShape each : shapeList.getList()) {
            if (each.getSelected()) {
                group.addChild(each);
                toRemove.add(each);
            }
        }
        shapeList.listRemoveAllOriginal(toRemove);
        shapeList.listAdd(group);

    }
}
