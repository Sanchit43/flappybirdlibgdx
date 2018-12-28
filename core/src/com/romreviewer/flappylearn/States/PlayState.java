package com.romreviewer.flappylearn.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.romreviewer.flappylearn.flappybird;
import com.romreviewer.flappylearn.sprite.Bird;
import com.romreviewer.flappylearn.sprite.Tube;

public class PlayState extends State {
    private static final int TUBE_COUNT=4;
    private static final int TUBE_SPACING=125;
    private static final int GROUND_Y_OFFSET=-100;
    private Bird bird;
    private Texture bg;
    private Tube tube;
    private Array<Tube> tubes;
    private Texture ground;
    private Vector2 groundPos1,groundPos2;


    public PlayState(GameStateManager gsm) {
        super(gsm);
        bird=new Bird(50,100);
        ogc.setToOrtho(false, flappybird.W/2,flappybird.H/2);
        bg=new Texture("bg.png");
        tubes=new Array<Tube>();
        ground=new Texture("ground.png");
        groundPos1=new Vector2(ogc.position.x-ogc.viewportWidth/2,GROUND_Y_OFFSET);
        groundPos2=new Vector2((ogc.position.x-ogc.viewportWidth/2)+ground.getWidth(),GROUND_Y_OFFSET);
        for (int i=1;i<=TUBE_COUNT;i++)
        {
            tubes.add(new Tube(i*(TUBE_SPACING+Tube.TUBE_WIDTH)));
        }

    }

    @Override
    protected void handlerinput() {
        if(Gdx.input.justTouched())
        {
            bird.jump();
        }

    }

    @Override
    public void update(float dt) {
        updateGround();
        handlerinput();
        bird.update(dt);
        ogc.position.x=bird.getPos().x+80;
        for(int i=0;i<tubes.size;i++)
        {
            Tube tube=tubes.get(i);
            if(ogc.position.x-(ogc.viewportWidth/2)>tube.getPosTopT().x+tube.getTopTube().getWidth())
            {
                tube.reposition(tube.getPosBotT().x+((Tube.TUBE_WIDTH+TUBE_SPACING)*TUBE_COUNT));
            }
            if(tube.colides(bird.getBounds()))
                gsm.setStates(new EndState(gsm));
        }
        if(bird.getPos().y<=ground.getHeight()+GROUND_Y_OFFSET)
            gsm.setStates(new EndState(gsm));
        ogc.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(ogc.combined);
        sb.begin();
        sb.draw(bg,ogc.position.x-(ogc.viewportWidth/2),0);
        sb.draw(bird.getBird(),bird.getPos().x,bird.getPos().y);
        for(Tube tube:tubes) {
            sb.draw(tube.getTopTube(), tube.getPosTopT().x, tube.getPosTopT().y);
            sb.draw(tube.getBottomTube(), tube.getPosBotT().x, tube.getPosBotT().y);
        }
        sb.draw(ground,groundPos1.x,groundPos1.y);
        sb.draw(ground,groundPos2.x,groundPos2.y);
        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        bird.dispose();
        ground.dispose();
        for(Tube tube:tubes)
            tube.dispose();
        System.out.println("Play State Disposed");
    }
    private void updateGround()
    {
        if(ogc.position.x-(ogc.viewportWidth/2)>groundPos1.x+ground.getWidth())
            groundPos1.add(ground.getWidth()*2,0);
        if(ogc.position.x-(ogc.viewportWidth/2)>groundPos2.x+ground.getWidth())
            groundPos2.add(ground.getWidth()*2,0);
    }
}
