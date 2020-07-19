package controller;

import model.IShape;
import model.Shape;
import model.ShapeList;


import java.awt.*;
import java.util.ArrayList;

public class SelectCommand implements ICommand {

    private int width;
    private int height;
    private final int x;
    private final int y;
    private final ShapeList shapeList;

    public SelectCommand(int width, int height, int x, int y, ShapeList shapeList) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.shapeList = shapeList;
    }

    @Override
    public void run() {
        detectCollision();
    }

    private void detectCollision() {
        if (width == 0 ||  height ==0 ){
            this.width = 1;
            this.height = 1;

        }
        ArrayList<IShape> list = shapeList.getList();
        Rectangle selection = new Rectangle(x, y, width, height);
        for (IShape each : list)
        {
            Rectangle shape = new Rectangle(each.getxPoint(), each.getyPoint(), each.getWidth(), each.getHeight());

            if (selection.intersects(shape)) {
                each.setSelected();
            }

        }

    }
}
