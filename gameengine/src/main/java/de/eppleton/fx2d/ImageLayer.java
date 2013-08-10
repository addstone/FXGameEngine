/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.eppleton.fx2d;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 *
 * @author antonepple
 */
public class ImageLayer extends Layer {

    private Image image;

    public ImageLayer(Image image) {
        this.image = image;
    }

    @Override
    public void draw(GraphicsContext graphicsContext, double x, double y, double width, double height) {
        graphicsContext.drawImage(image, 0, 0);
    }
}
