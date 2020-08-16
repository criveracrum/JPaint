package controller;

import model.CompositeGroupShape;
import model.IShape;
import model.ShapeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UngroupCommand implements ICommand, IUndoRedo{
    private final ShapeList shapeList;
    private List<CompositeGroupShape> group= new ArrayList<CompositeGroupShape>();
    ArrayList<IShape> children = new ArrayList<>();
    ArrayList<IShape> remove = new ArrayList<>();


    public UngroupCommand(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

    @Override
    public void run() {

        for (IShape each : shapeList.getList())
            if (each instanceof CompositeGroupShape){
                if (each.getSelected())
                {
                group.add( (CompositeGroupShape) each);
                CompositeGroupShape each2 = (CompositeGroupShape) each;
                children.addAll(  each2.getChildren());
                //each2.setSelected();
                //each2.draw();
                remove.add(each);
                }
            }
        shapeList.listRemoveAllOriginal(remove);
        shapeList.listAddAllNew(children);
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        //group.setSelected();
        try {
            for (CompositeGroupShape each : group){
            shapeList.listRemoveAllOriginal(each.getChildren());
            shapeList.listAdd(each);
            each.draw();
            }
        } catch (Exception e) {
            System.out.println("This is an empty event");
        }
    }

    @Override
    public void redo() {
        //group.setSelected();
        for (CompositeGroupShape each : group){
        shapeList.listRemoveAllOriginal(remove);
        shapeList.listAddAllNew(each.getChildren());}
    }
}
