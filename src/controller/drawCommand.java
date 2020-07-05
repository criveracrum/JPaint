package controller;


import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class drawCommand implements ICommand {

    private PaintCanvasBase paintCanvas;
    private int width;
    private int height;
    private int xPoint;
    private int yPoint;



    public drawCommand(PaintCanvasBase paintCanvas, int width, int height, int xPoint, int yPoint){
        this.paintCanvas = paintCanvas;
        this.width = width;
        this.height = height;
        this.xPoint = xPoint;
        this.yPoint = yPoint;

    }

    @Override
    public void run() {


        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(Color.GREEN);

        graphics2d.fillRect(xPoint, yPoint, width, height);

    }
}
