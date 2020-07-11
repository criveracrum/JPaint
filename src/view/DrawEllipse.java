package view;

import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class DrawEllipse implements IShapeStrategy{

    private PaintCanvasBase paintCanvas;
    private int width;
    private int height;
    private int xPoint;
    private int yPoint;
    private IApplicationState appState;

    public DrawEllipse(PaintCanvasBase paintCanvas,  int width, int height, int xPoint, int yPoint, IApplicationState appState){
        this.paintCanvas = paintCanvas;
        this.width = width;
        this.height = height;
        this.xPoint = xPoint;
        this.yPoint = yPoint;
        this.appState = appState;

    }
    @Override
    public void draw() {
        Graphics2D graphics2d = paintCanvas.getGraphics2D();

        graphics2d.fillOval(xPoint, yPoint, width, height);

    }
}
