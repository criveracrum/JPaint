package view;

import model.Shape;
import model.ShapeShadingType;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class DrawTriangle implements IShapeStrategy{


    private Graphics2D graphics2d;
    private Shape shape;


    @Override
    public void draw(Graphics2D graphics2d, Shape shape) {
        this.graphics2d = graphics2d;
        this.shape = shape;


        if (shape.getShadeType().equals(ShapeShadingType.FILLED_IN))
            drawFilledIn();
        else if(shape.getShadeType().equals(ShapeShadingType.OUTLINE))
            drawOutline();
        else if (shape.getShadeType().equals(ShapeShadingType.OUTLINE_AND_FILLED_IN))
            drawAll();

    }
    public void drawOutline(){
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(shape.getPrimaryColor());
        graphics2d.drawPolygon(new int[]{shape.getxPoint(), shape.getxPoint() + shape.getWidth(), shape.getxPoint()+ shape.getWidth()/2 },
                new int[]{shape.getyPoint()+ shape.getHeight(), shape.getyPoint() +shape.getHeight() , shape.getyPoint()}, 3);
    }
    public void drawFilledIn(){
        graphics2d.setColor(shape.getPrimaryColor());
        graphics2d.fillPolygon(new int[]{shape.getxPoint(), shape.getxPoint() + shape.getWidth(), shape.getxPoint()+ shape.getWidth()/2 },
                new int[]{shape.getyPoint()+ shape.getHeight(), shape.getyPoint() +shape.getHeight() , shape.getyPoint()}, 3);

    }
    public void drawAll(){
        graphics2d.setColor(shape.getPrimaryColor());
        graphics2d.fillPolygon(new int[]{shape.getxPoint(), shape.getxPoint() + shape.getWidth(), shape.getxPoint()+ shape.getWidth()/2 },
                new int[]{shape.getyPoint()+ shape.getHeight(), shape.getyPoint() +shape.getHeight() , shape.getyPoint()}, 3);
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(shape.getSecondaryColor());
        graphics2d.drawPolygon(new int[]{shape.getxPoint(), shape.getxPoint() + shape.getWidth(), shape.getxPoint()+ shape.getWidth()/2 },
                new int[]{shape.getyPoint()+ shape.getHeight(), shape.getyPoint() +shape.getHeight() , shape.getyPoint()}, 3);

    }
}
