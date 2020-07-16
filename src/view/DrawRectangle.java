package view;

import model.Shape;
import model.ShapeShadingType;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class DrawRectangle implements IShapeStrategy{


    private Graphics2D graphics2d;
    private final Shape shape;


    public DrawRectangle(Graphics2D graphics2d, Shape shape){
        this.graphics2d = graphics2d;
        this.shape = shape;
    }
    @Override
    public void draw() {

        if (shape.getShadeType().equals(ShapeShadingType.FILLED_IN))
            drawFilledIn();
        else if(shape.getShadeType().equals(ShapeShadingType.OUTLINE))
            drawOutline();
        else if (shape.getShadeType().equals(ShapeShadingType.OUTLINE_AND_FILLED_IN))
            drawAll();


    }
    private void drawOutline(){
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(shape.getPrimaryColor());
        graphics2d.drawRect(shape.getxPoint(), shape.getyPoint(), shape.getWidth(), shape.getHeight());
    }
    private void drawFilledIn(){
        graphics2d.setColor(shape.getPrimaryColor());
        graphics2d.fillRect(shape.getxPoint(), shape.getyPoint(), shape.getWidth(), shape.getHeight());
    }
    private void drawAll(){
        graphics2d.setColor(shape.getPrimaryColor());
        graphics2d.fillRect(shape.getxPoint(), shape.getyPoint(), shape.getWidth(), shape.getHeight());
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(shape.getSecondaryColor());
        graphics2d.drawRect(shape.getxPoint(), shape.getyPoint(), shape.getWidth(), shape.getHeight());
    }
}
