package com.allsopg.game;

import com.allsopg.game.actor.AnimatedSprite;
import com.allsopg.game.actor.BonusSprite;
import com.allsopg.game.utility.Constants;
import com.allsopg.game.utility.UniversalResource;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MyGdxGame extends ApplicationAdapter {
	private BitmapFont font;
	private String text;
	private static GlyphLayout glyphLayout = new GlyphLayout();

    private OrthographicCamera camera;
    private Viewport view;
    private SpriteBatch batch;
    private AnimatedSprite jacket_1;
    private BonusSprite jacket;
    private float animationTime;

	@Override
	public void create () {
		font = new BitmapFont(Gdx.files.internal("font/nirmala.fnt"));
		text = "20+ Armor";

		camera = new OrthographicCamera();
		view = new FitViewport(800,600,camera);
		batch = new SpriteBatch();
		//Texture small = new Texture(Gdx.files.internal("gfx/smallSize.png"));
		Texture medium = new Texture(Gdx.files.internal("gfx/jacket/mediumSize.png"));
        jacket = new BonusSprite("gfx/jacket/jacket_assets.atlas",medium,new Vector2(Constants.SCENE_WIDTH/2,Constants.SCENE_HEIGHT/2), Animation.PlayMode.LOOP);
        jacket.idleRoutine();
	}
	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        animationTime +=Gdx.graphics.getDeltaTime();
        UniversalResource.getInstance().tweenManager.update(animationTime);

        batch.begin();
		glyphLayout.setText(font, text);
		font.draw(batch, glyphLayout, Gdx.graphics.getWidth()/2 - (glyphLayout.width/2),
									  Gdx.graphics.getHeight()/1.3f - (glyphLayout.height/1.3f));

        jacket.update(animationTime);
        jacket.draw(batch);
		batch.end();
	}
	@Override
	public void dispose () {
		batch.dispose();
	}
}
