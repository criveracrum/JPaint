package view;

import model.IShape;
import model.ShapeType;
import view.IShapeStrategy;

import java.awt.*;

public class SelectedDecorator implements IShapeStrategy {
    private final IShape shape;

    public SelectedDecorator(IShape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {

    }

    @Override
    public void drawOutline() {
        Graphics2D graphics2D = shape.getGraphics2D();
        Stroke dashed = new BasicStroke
                (3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0 );
        graphics2D.setStroke(dashed);
        graphics2D.setColor(Color.BLACK);
        int xPoint = shape.getxPoint()-5;
        int yPoint = shape.getyPoint()-5;
        int width = shape.getWidth()+10;
        int height = shape.getHeight()+10;
        if (shape.getShapeType().equals(ShapeType.TRIANGLE) )
            graphics2D.drawPolygon(new int[]{xPoint, xPoint + width, xPoint+ width/2 },
                    new int[]{yPoint+ height, yPoint +height , yPoint}, 3);
        else if(shape.getShapeType().equals(ShapeType.RECTANGLE) )
            graphics2D.drawRect(xPoint, yPoint, width, height);
        else if(shape.getShapeType().equals(ShapeType.ELLIPSE) )
            graphics2D.drawOval(xPoint, yPoint, width, height);

    }

    @Override
    public void drawFilledIn() {
        Graphics2D graphics2D = shape.getGraphics2D();
        graphics2D.setColor(Color.WHITE);
        graphics2D.setStroke(new BasicStroke(10));
        int xPoint = shape.getxPoint()-10;
        int yPoint = shape.getyPoint()-10;
        int width = shape.getWidth()+20;
        int height = shape.getHeight()+20;
        if (shape.getShapeType().equals(ShapeType.TRIANGLE) )
            graphics2D.fillPolygon(new int[]{xPoint, xPoint + width, xPoint+ width/2 },
                    new int[]{yPoint+ height, yPoint +height , yPoint}, 3);
        else if(shape.getShapeType().equals(ShapeType.RECTANGLE) )
            graphics2D.fillRect(xPoint, yPoint, width, height);
        else if(shape.getShapeType().equals(ShapeType.ELLIPSE) )
            graphics2D.fillOval(xPoint, yPoint, width, height);
    }

    @Override
    public void drawAll() {

    }
}
