package model;

import java.awt.*;
import java.util.ArrayList;

public class ShapeList {
    private static ArrayList<IShape>  shapeList = new ArrayList<IShape>();
    private static ArrayList<IShape>  copiedShapes = new ArrayList<IShape>();


    public ArrayList<IShape> getList() {
        return shapeList;
    }

    public void listAdd(IShape shape){
        shapeList.add(shape);
        shape.draw();
    }
    public void addCopy(IShape shape){
        copiedShapes.add(shape);
        System.out.println(copiedShapes.size());
    }
    public void removeCopy(){
        copiedShapes.removeAll(copiedShapes);
    }

    public void listRemove(IShape shape){
        //shapeList.remove(shape);
        Graphics2D graphics2D= shape.getGraphics2D();
        graphics2D.setColor(Color.WHITE);
        graphics2D.setStroke(new BasicStroke(10));
        graphics2D.fillRect(shape.getxPoint(), shape.getyPoint(), shape.getWidth()+3, shape.getHeight()+3);
    }
    public void listRemoveAllOriginal(ArrayList<IShape> shapes){
        shapeList.removeAll(shapes);
    }
    public void listAddAllNew(ArrayList<IShape> shapes){
        //System.out.println("ADDING");
        for (IShape each : shapes){
            listAdd(each);
        }
    }


    public ArrayList<IShape> getCopyList() {
        return copiedShapes;
    }
}
