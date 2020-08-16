package model;

import controller.ICommand;
import model.interfaces.IApplicationState;
import view.IShapeStrategy;
import view.SelectedDecorator;
import view.gui.PaintCanvas;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.ArrayList;

public class CompositeGroupShape implements IShape {
    private int width;
    private int height;
    private ArrayList<IShape> children = new ArrayList<IShape>();
    private PaintCanvasBase canvas;
    private int endX;
    private int endY;
    private int xPoint;
    private int yPoint;
    private boolean selected ;


    public CompositeGroupShape(PaintCanvasBase canvas) {
        this.canvas = canvas;
        this.width = 0;
        this.height = 0;
        this.setxPoint(0);
        this.setyPoint(0);
        this.setEndX(0);
        this.setEndY(0);
        this.selected = true;
    }



    public void addChild(IShape each) {
        each.setSelected();
        if (children.isEmpty()){
            this.yPoint =each.getyPoint();
            this.xPoint =each.getxPoint();
            this.endX = each.getxPoint() + each.getWidth();
            this.endY = each.getyPoint() + each.getHeight();
            setWidth(endX- xPoint);
            setHeight(endY - yPoint);
        }
        else{
            setEndY(each.getyPoint()+each.getHeight());
            setEndX(each.getxPoint() + each.getWidth());
            setxPoint(each.getxPoint());
            setyPoint(each.getyPoint());

            setWidth(endX- xPoint);
            setHeight(endY - yPoint);
        }


        children.add(each);

    }

    public void Init(){
        this.width = 0;
        this.height = 0;

    }





    public void moveChildren(int diffX, int diffY) {
        for (IShape each : children){
            IShapeStrategy cover = new SelectedDecorator(each);
            cover.drawFilledIn();
            each.move(diffX, diffY);
            each.draw();
        }

    }
    @Override
    public void move(int diffX, int diffY){
        this.xPoint= xPoint + diffX;
        this.yPoint= yPoint + diffY;
        this.endX = endX + diffX;
        this.endY = endY + diffY;

        moveChildren(diffX, diffY);
    }

    @Override
    public IShapeStrategy getStrategy() {
        return null;
    }


    public ArrayList<IShape> getChildren() {
        return children;
    }


    public void setChildren(ArrayList<IShape> children) {
        this.children = children;
    }
    private void setEndY(int y) {
        if (y > endY)
            endY = y;
    }


    public void setEndX(int x){
        if (x > endX)
            endX = x;
    }


    @Override
    public void draw() {


        SelectedDecorator group = new SelectedDecorator(this);
        //group.drawOutline();
        group.drawGroup();
        for (IShape each : children){
            each.draw();
        }
        if (getSelected()){
            IShapeStrategy selected = new SelectedDecorator(this);
            selected.drawOutline();
        }


    }



    @Override
    public void setWidth(int width) {
         this.width = width;

    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void setxPoint(int x) {
        if (x < xPoint)
            xPoint = x;
    }

    @Override
    public void setyPoint(int y) {
        if (y < yPoint)
            yPoint = y;
    }

    @Override
    public void setAppState(IApplicationState appState) {

    }

    @Override
    public void setPrimaryColor(ShapeColor primaryColor) {

    }

    @Override
    public void setSecondaryColor(ShapeColor secondaryColor) {

    }

    @Override
    public void setShapeType(ShapeType shapeType) {

    }

    @Override
    public void setShadeType(ShapeShadingType shadeType) {

    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getxPoint() {
        return xPoint;
    }

    @Override
    public int getyPoint() {
        return yPoint;
    }

    @Override
    public IApplicationState getAppState() {
        return null;
    }

    @Override
    public Color getPrimaryColor() {
        return null;
    }

    @Override
    public Color getSecondaryColor() {
        return null;
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.RECTANGLE;
    }

    @Override
    public ShapeShadingType getShadeType() {
        return null;
    }

    @Override
    public Graphics2D getGraphics2D() {
        return  canvas.getGraphics2D();
    }

    @Override
    public void setGraphics2D() {

    }

    @Override
    public void setSelected() {
        selected = !selected;
        this.draw();
    }

    @Override
    public boolean getSelected() {

        return selected;
    }



    @Override
    public IShape getDuplicateShape() {
        CompositeGroupShape newComposite = new CompositeGroupShape(canvas);
        for (IShape each : children){
            IShape copy = each.getDuplicateShape();
            copy.setSelected();
            copy.draw();
            newComposite.addChild(copy);

        }
        return newComposite;
    }

    @Override
    public PaintCanvasBase getPaintCanvas() {
        return null;
    }




}
