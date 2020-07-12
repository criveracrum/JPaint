package model;

import model.interfaces.IApplicationState;

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

    void draw();
}
