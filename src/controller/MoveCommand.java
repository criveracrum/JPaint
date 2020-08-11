package controller;

import model.IShape;
import model.ShapeList;

import java.util.ArrayList;

public class MoveCommand implements ICommand ,IUndoRedo{
    private final int x;
    private final int y;
    private final ShapeList shapeList;
    private final int diffY;
    private final int diffX;
    ArrayList<IShape> removed = new ArrayList<IShape>();
    ArrayList<IShape> changed = new ArrayList<IShape>();

    public MoveCommand(int x, int y, ShapeList shapeList, int diffY, int diffX) {
        this.x = x;
        this.y = y;
        this.shapeList = shapeList;
        this.diffY = diffY;
        this.diffX = diffX;
    }

    @Override
    public void run() {
        ArrayList<IShape> list = shapeList.getList();

        for (IShape shape : list ){
            if (shape.getSelected()) {
                //shapeList.listRemove(shape);
                removed.add(shape);
//                shape.setxPoint(shape.getxPoint() + diffX);
//                shape.setyPoint(shape.getyPoint() + diffY);
                shape.move(diffX, diffY);
                changed.add(shape);
            }
        }
        shapeList.listRemoveAllOriginal(removed);
        shapeList.listAddAllNew(changed);
        CommandHistory.add(this);


    }

    @Override
    public void undo() {
        shapeList.listAddAllNew(removed);
        shapeList.listRemoveAllOriginal(changed);
    }

    @Override
    public void redo() {
        shapeList.listRemoveAllOriginal(removed);
        shapeList.listAddAllNew(changed);
    }
}
