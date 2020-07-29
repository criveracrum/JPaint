package view;

import java.awt.*;

public interface IShapeStrategy {

    void draw();

    void drawOutline();

    void drawFilledIn();

    void drawAll();
}
