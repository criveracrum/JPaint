package view;

import model.Shape;
import model.ShapeShadingType;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class DrawTriangle implements IShapeStrategy{

    private PaintCanvasBase paintCanvas;
    private int width;
    private int height;
    private int xPoint;
    private int yPoint;
    private IApplicationState appState;
    private Graphics2D graphics2d;
    private final ShapeShadingType type;
    private final Shape shape;

    public DrawTriangle(PaintCanvasBase paintCanvas, int width, int height, int xPoint, int yPoint, IApplicationState appState,
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


        graphics2d.fillPolygon(new int[]{xPoint, xPoint + width, xPoint+ width/2 }, new int[]{yPoint+height, yPoint +height , yPoint}, 3);
        if (type.equals(ShapeShadingType.FILLED_IN))
            drawFilledIn();
        else if(type.equals(ShapeShadingType.OUTLINE))
            drawOutline();
        else if (type.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN))
            drawAll();

    }
    private void drawOutline(){

    }
    private void drawFilledIn(){

    }
    private void drawAll(){
        graphics2d.fillPolygon(new int[]{xPoint, xPoint + width, xPoint+ width/2 }, new int[]{yPoint+height, yPoint +height , yPoint}, 3);

    }
}
