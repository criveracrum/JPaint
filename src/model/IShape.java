package model;

import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public interface IShape {
    void setWidth(int width);

    void setHeight(int height);

    void setxPoint(int xPoint);

    void setyPoint(int yPoint);

    void setAppState(IApplicationState appState);

    void setPrimaryColor(ShapeColor primaryColor);

    void setSecondaryColor(ShapeColor secondaryColor);

    void setShapeType(ShapeType shapeType);

    void setShadeType(ShapeShadingType shadeType);

    int getWidth();

    int getHeight();

    int getxPoint();

    int getyPoint();

    IApplicationState getAppState();

    Color getPrimaryColor();

    Color getSecondaryColor();

    ShapeType getShapeType();

    ShapeShadingType getShadeType();

    Graphics2D getGraphics2D();

    void setGraphics2D();

    void setSelected();

    boolean getSelected();

    void draw();

    IShape getDuplicateShape();

    PaintCanvasBase getPaintCanvas();

    void move(int diffX, int diffY);
}
