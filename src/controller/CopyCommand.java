package controller;

import model.IShape;
import model.ShapeList;

import java.util.ArrayList;
import java.util.List;

public class CopyCommand implements ICommand{


    private ShapeList shapeList;

    public CopyCommand(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

    @Override
    public void run() {

        shapeList.removeCopy();
        for (IShape each : shapeList.getList()) {
            if (each.getSelected()) {
                shapeList.addCopy(each);
            }
        }


    }
}
