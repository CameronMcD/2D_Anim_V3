package com.allsopg.game.actor;

import com.allsopg.game.utility.TweenData;
import com.allsopg.game.utility.TweenDataAccessor;
import com.allsopg.game.utility.UniversalResource;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenAccessor;
import aurelienribon.tweenengine.TweenManager;

/**
 * Created by gja on 13/11/2017.
 * Updated by gja on 19/10/2017
 */

public class BonusSprite extends AnimatedSprite {
    private TweenData tweenData;
    private TweenManager tweenManager;

    public BonusSprite(String atlasString, Texture t, Vector2 pos, Animation.PlayMode loopType){
        super(atlasString, t, loopType);
        this.setPosition(pos.x,pos.y);
        initTweenData();
    }

    private void initTweenData(){
        tweenData = new TweenData();
        tweenData.setXY(this.getX(),this.getY());
        tweenData.setColour(this.getColor());
        tweenData.setScale(this.getScaleX());
        tweenManager = UniversalResource.getInstance().tweenManager; //tweenManager;
    }

    private TweenData getTweenData(){return tweenData;}


    @Override
    public void update(float stateTime){
        super.update(stateTime);
        this.setX(tweenData.getXY().x);
        this.setY(tweenData.getXY().y);
        this.setColor(tweenData.getColour());
        this.setScale(tweenData.getScale());
        this.setRotation(tweenData.getRotation());
    }

    public void idleRoutine(){

        Tween.to(tweenData, TweenDataAccessor.TYPE_POS,0f)
                .target(190,90).start(tweenManager).to(tweenData, TweenDataAccessor.TYPE_ROTATION,250f)
                //.target(0f).start().start(tweenManager).to(tweenData,TweenDataAccessor.TYPE_SCALE,150f)
               // .target(.15f).start(tweenManager).to(tweenData,TweenDataAccessor.TYPE_COLOUR,500f);
                .target(.15f,.15f,.15f,.0f).start(tweenManager);
        }


}
