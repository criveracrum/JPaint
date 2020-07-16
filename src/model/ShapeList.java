package model;

import java.awt.*;
import java.util.ArrayList;

public class ShapeList {
    private ArrayList<IShape>  shapeList = new ArrayList<IShape>();

    public ArrayList<IShape> getList() {
        return shapeList;
    }

    public void listAdd(IShape shape){
        shapeList.add(shape);
        shape.draw();
    }

    public void listRemove(IShape shape){
        shapeList.remove(shape);
        Graphics2D graphics2D= shape.getGraphics2D();
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(shape.getxPoint(), shape.getyPoint(), shape.getWidth(), shape.getHeight());
    }



}
