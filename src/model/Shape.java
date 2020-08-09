package model;

import model.interfaces.IApplicationState;
import view.*;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class Shape implements IShape {

    private int width;
    private int height;
    private int xPoint;
    private int yPoint;
    private IApplicationState appState;
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private ShapeType shapeType;
    private ShapeShadingType shadeType;
    private PaintCanvasBase paintCanvas;
    private Graphics2D graphics2d;
    public boolean selected;




    public Shape(int width, int height, int xPoint, int yPoint, IApplicationState appState, PaintCanvasBase paintCanvas) {
        this.width = width;
        this.height = height;
        this.xPoint = xPoint;
        this.yPoint = yPoint;
        this.appState = appState;
        this.paintCanvas = paintCanvas;
        setShadeType(appState.getActiveShapeShadingType());
        setShapeType(appState.getActiveShapeType());
        setPrimaryColor(appState.getActivePrimaryColor());
        setSecondaryColor(appState.getActiveSecondaryColor());
        this.selected = false;
        setGraphics2D();


    }

    public PaintCanvasBase getPaintCanvas() {
        return paintCanvas;
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
    public void setxPoint(int xPoint) {
        this.xPoint = xPoint;
    }

    @Override
    public void setyPoint(int yPoint) {
        this.yPoint = yPoint;
    }

    @Override
    public void setAppState(IApplicationState appState) {
        this.appState = appState;
    }

    @Override
    public void setPrimaryColor(ShapeColor primaryColor){
        this.primaryColor = primaryColor;
    }

    @Override
    public void setSecondaryColor(ShapeColor secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    @Override
    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    @Override
    public void setShadeType(ShapeShadingType shadeType) {
        this.shadeType = shadeType;
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
        return appState;
    }

    @Override
    public Color getPrimaryColor() {
        return ShapeColor.getMap().get(primaryColor);
    }

    @Override
    public Color getSecondaryColor() {
        return ShapeColor.getMap().get(secondaryColor);
    }

    @Override
    public ShapeType getShapeType() {
        return shapeType;
    }

    @Override
    public ShapeShadingType getShadeType() {
        return shadeType;
    }

    public Graphics2D getGraphics2D() {
        return graphics2d;
    }

    public void setGraphics2D() {
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        this.graphics2d = graphics2d;
    }

    @Override
    public void setSelected(){

        selected = !selected;

        if (!selected){
            IShapeStrategy selected = new SelectedDecorator(this);
            selected.drawOutline();
        }

    }

    @Override
    public boolean getSelected() {
        return selected;
    }

    @Override
    public void draw() {


        if (shapeType == ShapeType.ELLIPSE) {
            IShapeStrategy ellipse = new DrawEllipse(graphics2d, this);
            ellipse.draw();
            if (getSelected()){
                IShapeStrategy selected = new SelectedDecorator(this);
                selected.drawOutline();
            }


        }
        else if (shapeType == ShapeType.RECTANGLE){
            IShapeStrategy rectangle = new DrawRectangle(graphics2d, this);
            rectangle.draw();
            if (getSelected()){
                IShapeStrategy selected = new SelectedDecorator(this);
                selected.drawOutline();
            }

        }
        else if (shapeType == ShapeType.TRIANGLE){
            IShapeStrategy triangle = new DrawTriangle(graphics2d, this);
            triangle.draw();
            if (getSelected()){
                IShapeStrategy selected = new SelectedDecorator(this);
                selected.drawOutline();
            }
        }
    }

    @Override
    public IShape getDuplicateShape() {

        Shape newShape = new Shape(width, height, xPoint + 30, yPoint + 30, appState, paintCanvas);
        newShape.setShapeType(getShapeType());
        newShape.setShadeType(getShadeType());
        newShape.setPrimaryColor(this.primaryColor);
        newShape.setSecondaryColor(this.secondaryColor);
        return newShape;
    }


}
