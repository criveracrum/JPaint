package model;

import model.interfaces.IApplicationState;
import view.DrawEllipse;
import view.DrawRectangle;
import view.DrawTriangle;
import view.IShapeStrategy;
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
    public ShapeColor getPrimaryColor() {
        return primaryColor;
    }

    @Override
    public ShapeColor getSecondaryColor() {
        return secondaryColor;
    }

    @Override
    public ShapeType getShapeType() {
        return shapeType;
    }

    @Override
    public ShapeShadingType getShadeType() {
        return shadeType;
    }

    @Override
    public void draw() {


        if (shapeType == ShapeType.ELLIPSE) {
            IShapeStrategy ellipse = new DrawEllipse(paintCanvas, width, height, xPoint, yPoint, appState);
            ellipse.draw();


        }
        else if (shapeType == ShapeType.RECTANGLE){
            IShapeStrategy rectangle = new DrawRectangle(paintCanvas, width, height, xPoint, yPoint, appState);
            rectangle.draw();


        }
        else if (shapeType == ShapeType.TRIANGLE){
            IShapeStrategy triangle = new DrawTriangle(paintCanvas, width, height, xPoint, yPoint, appState);
            triangle.draw();

        }
    }
}
