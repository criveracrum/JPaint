package model;

import view.interfaces.PaintCanvasBase;

import java.util.ArrayList;

public class ShapeList {
    private static ArrayList<IShape>  shapeList = new ArrayList<IShape>();
    private static ArrayList<IShape>  copiedShapes = new ArrayList<IShape>();
    private PaintCanvasBase paintCanvas;
    private static ArrayList<IShape>  deletedShapeList = new ArrayList<IShape>();
    private IPaintAdapter adapter;


    public ShapeList(PaintCanvasBase paintCanvas) {
        this.paintCanvas = paintCanvas;
        //this.adapter = new PaintAdapter(paintCanvas, this);
    }


    public ArrayList<IShape> getList() {
        return shapeList;
    }
    public PaintCanvasBase getPaintCanvas(){
        return paintCanvas;
    }

    public void listAdd(IShape shape){
        shapeList.add(shape);
        shape.draw();
    }
    public void addCopy(IShape shape){
        copiedShapes.add(shape);
    }
    public void removeCopy(){
        //copiedShapes.removeAll(copiedShapes);
        copiedShapes.clear();
    }

    public void listRemove(IShape shape){
        shapeList.remove(shape);
//        Graphics2D graphics2D= shape.getGraphics2D();
//        graphics2D.setColor(Color.WHITE);
//        graphics2D.setStroke(new BasicStroke(10));
//        graphics2D.fillRect(shape.getxPoint(), shape.getyPoint(), shape.getWidth()+3, shape.getHeight()+3);
//        IShapeStrategy removal= new SelectedDecorator(shape);
//        removal.drawFilledIn();

       // adapter.clear();

        adapter.repaint();

    }
    public void listRemoveAllOriginal(ArrayList<IShape> shapes){
        shapeList.removeAll(shapes);

        adapter.repaint();
        //adapter.clear();

    }
    public void listAddAllNew(ArrayList<IShape> shapes){
        //System.out.println("ADDING");
        for (IShape each : shapes){
            listAdd(each);
        }
        adapter.repaint();
        //adapter.clear();
    }


    public ArrayList<IShape> getCopyList() {
        return copiedShapes;
    }
    public void getAdapter(IPaintAdapter adapter){
        this.adapter=adapter;
    }

}
