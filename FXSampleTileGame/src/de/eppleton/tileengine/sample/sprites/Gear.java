/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.eppleton.tileengine.sample.sprites;

import de.eppleton.fx2d.GameCanvas;
import de.eppleton.fx2d.Sprite;
import de.eppleton.fx2d.action.Action;
import de.eppleton.fx2d.tileengine.TileSet;
import java.util.Properties;
import java.util.logging.Logger;

/**
 *
 * @author antonepple
 */
public class Gear extends Sprite {

    private TileSet tileset;
    private Properties properties;
    private int layer;

    public Gear(TileSet tileset, Properties properties, GameCanvas parent, String name, double x, double y, int width, int height, int layer) {
        super(parent, name, x, y, width, height);
        this.tileset = tileset;
        this.properties = properties;
        this.layer = layer;
        addBehaviour(new Action() {
            @Override
            public boolean perform(Sprite sprite, GameCanvas playingField) {
                if (sprite.getCollisionBox().intersects(playingField.getHero().getCollisionBox())) {
                    boolean taken = ((Hero) playingField.getHero()).offer(Gear.this);
                    if (taken) {
                        playingField.removeSprite(sprite);
                    }
                }
                return true;
            }
        });
    }

    public TileSet getTileset() {
        return tileset;
    }

    public String getProperty(String property) {
        return properties.getProperty(property);
    }

    public int getLayer() {
        return layer;
    }
    private static final Logger LOG = Logger.getLogger(Gear.class.getName());
}