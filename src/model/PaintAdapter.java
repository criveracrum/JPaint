package model;

import controller.DrawCommand;
import controller.ICommand;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

import javax.swing.*;
import java.awt.*;

public class PaintAdapter implements IPaintAdapter{
    private final PaintCanvasBase canvas;
    private final ShapeList shapeList;
    private boolean object;


    public PaintAdapter(PaintCanvasBase paintCanvas, ShapeList shapeList) {
        this.canvas = paintCanvas;
        this.shapeList = shapeList;

    }

    @Override
    public void clear() {


        canvas.revalidate();
        canvas.repaint();
        canvas.revalidate();






    }

    @Override
    public void repaint() {
//        Graphics2D graphics = canvas.getGraphics2D();
//        graphics.setColor(Color.WHITE);
//        graphics.fillRect(0,0, canvas.getWidth(), canvas.getHeight() );
//        for (IShape each: shapeList.getList()){
//            each.draw();
//
//        }
        clear();
        SwingUtilities.invokeLater(() -> paintIt());



    }
    private void paintIt()  {
        canvas.revalidate();
        for (IShape each: shapeList.getList()){

            each.draw();

        }

    }



}
