package com.romreviewer.flappylearn.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;


public class Animation {
    private Array<TextureRegion> frames;
    private float maxFrameTime;
    private float currnetFrametime;
    private int framecount;
    private int frame;

    public Animation(TextureRegion region,int frameCount,float cycleTime) {
        frames=new Array<TextureRegion>();
        int framwidth=region.getRegionWidth()/frameCount;
        for(int i=0;i<frameCount;i++)
        {
            frames.add(new TextureRegion(region,i*framwidth,0,framwidth,region.getRegionHeight()));
        }
        this.framecount=frameCount;
        maxFrameTime=cycleTime/frameCount;
        frame=0;

    }
    public void update(float dr)
    {
        currnetFrametime+=dr;
        if(currnetFrametime>maxFrameTime)
        {
            frame++;
            currnetFrametime=0;
        }
        if(frame>=framecount)
            frame=0;
    }
    public TextureRegion getFrame()
    {
        return frames.get(frame);
    }
}
