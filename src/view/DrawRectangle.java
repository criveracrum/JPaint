package view;

import model.Shape;
import model.ShapeShadingType;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class DrawRectangle implements IShapeStrategy{

    private PaintCanvasBase paintCanvas;
    private int width;
    private int height;
    private int xPoint;
    private int yPoint;
    private IApplicationState appState;
    private Graphics2D graphics2d;
    private final ShapeShadingType type;
    private final Shape shape;


    public DrawRectangle(PaintCanvasBase paintCanvas, int width, int height, int xPoint, int yPoint, IApplicationState appState,
                         Graphics2D graphics2d, ShapeShadingType type, Shape shape){
        this.paintCanvas = paintCanvas;
        this.width = width;
        this.height = height;
        this.xPoint = xPoint;
        this.yPoint = yPoint;
        this.appState = appState;
        this.graphics2d = graphics2d;
        this.type = type;
        this.shape = shape;
    }
    @Override
    public void draw() {



        if (type.equals(ShapeShadingType.FILLED_IN))
            drawFilledIn();
        else if(type.equals(ShapeShadingType.OUTLINE))
            drawOutline();
        else if (type.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN))
            drawAll();


    }
    private void drawOutline(){
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(shape.getSecondaryColor());
        graphics2d.drawRect(shape.getxPoint(), shape.getyPoint(), shape.getWidth(), shape.getHeight());
    }
    private void drawFilledIn(){
        graphics2d.setColor(shape.getPrimaryColor());
        graphics2d.fillRect(shape.getxPoint(), shape.getyPoint(), shape.getWidth(), shape.getHeight());
    }
    private void drawAll(){
        graphics2d.setColor(shape.getPrimaryColor());
        graphics2d.fillRect(shape.getxPoint(), shape.getyPoint(), shape.getWidth(), shape.getHeight());
        drawOutline();
    }
}
