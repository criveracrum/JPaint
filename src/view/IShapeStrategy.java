package view;

import model.Shape;

import java.awt.*;

public interface IShapeStrategy {

    void draw(Graphics2D graphics2d, Shape shape);

    void drawOutline();

    void drawFilledIn();

    void drawAll();
}
