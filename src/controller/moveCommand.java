package controller;

import controller.ICommand;
import model.IShape;
import model.ShapeList;

import java.util.ArrayList;

public class moveCommand implements ICommand {
    private final int x;
    private final int y;
    private final ShapeList shapeList;

    public moveCommand(int x, int y, ShapeList shapeList) {
        this.x = x;
        this.y = y;
        this.shapeList = shapeList;
    }

    @Override
    public void run() {
        ArrayList<IShape> list = shapeList.getList();

        for (IShape each : list){
            if (each.getSelected())
                System.out.println("MOVING");
        }
    }
}
