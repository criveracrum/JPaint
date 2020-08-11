package model;

import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.ArrayList;

public class PaintAdapter implements IPaintAdapter{
    private final PaintCanvasBase canvas;
    private final ShapeList shapeList;

    public PaintAdapter(PaintCanvasBase paintCanvas, ShapeList shapeList) {
        this.canvas = paintCanvas;
        this.shapeList = shapeList;
    }

    @Override
    public void clear()  {
        Graphics2D graphics = canvas.getGraphics2D();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0, canvas.getWidth(), canvas.getHeight() );




    }

    @Override
    public void repaint() {
        Graphics2D graphics = canvas.getGraphics2D();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0, canvas.getWidth(), canvas.getHeight() );
        for (IShape each: shapeList.getList()){
            each.draw();

        }

    }


}
