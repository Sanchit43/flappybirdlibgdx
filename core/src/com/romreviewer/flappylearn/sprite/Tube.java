package com.romreviewer.flappylearn.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Tube {
    private Texture topTube,bottomTube;
    Vector2 posTopT,posBotT;
    private Random random;
    private Rectangle boundsTop,boundsBot;
    private static final int FLUC=130;
    private static final int TUBGAP=100;
    private static final int LOW_OPEN=120;
    public static final int TUBE_WIDTH=52;
    public Tube(float x)
    {
        topTube=new Texture("toptube.png");
        bottomTube=new Texture("bottomtube.png");
        random=new Random();
        posTopT=new Vector2(x,random.nextInt(FLUC)+TUBGAP+LOW_OPEN);
        posBotT=new Vector2(x,posTopT.y-TUBGAP-bottomTube.getHeight());
        boundsTop=new Rectangle(posBotT.x,posTopT.y,topTube.getWidth(),topTube.getHeight());
        boundsBot=new Rectangle(posBotT.x,posBotT.y,bottomTube.getWidth(),bottomTube.getHeight());

        //System.out.print("Random:"+random.nextInt(FLUC));
    }

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Vector2 getPosTopT() {
        return posTopT;
    }

    public Vector2 getPosBotT() {
        return posBotT;
    }
    public void reposition(float x)
    {
        posTopT.set(x,random.nextInt(FLUC)+TUBGAP+LOW_OPEN);
        posBotT.set(x,posTopT.y-TUBGAP-bottomTube.getHeight());
        boundsBot.setPosition(posBotT.x,posBotT.y);
        boundsTop.setPosition(posTopT.x,posTopT.y);
    }
    public boolean colides(Rectangle rectangle)
    {
        return rectangle.overlaps(boundsTop)||rectangle.overlaps(boundsBot);
    }
    public void dispose()
    {
        topTube.dispose();
        bottomTube.dispose();
    }
}
