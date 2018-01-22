package gdx.menu.Screens;

import java.util.Iterator;

//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.InputProcessor;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.g2d.Sprite;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.Input;
//import gdx.menu.GamMenu;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import gdx.menu.GamMenu;

//public class ScrPlay implements Screen, InputProcessor {
//    Dude dud1;
//    Button btnQuit, btnAni;
////    Wall[] arWall = new Wall[4];
//    GamMenu gamMenu;
//    OrthographicCamera oc;
//    SpriteBatch batch;
//    Texture txNamP, txWall;
//    Sprite sprNamP;
//
//    public ScrPlay(GamMenu _gamMenu) {  //Referencing the main class.
//        gamMenu = _gamMenu;
//    }
//
//    @Override
//    public void show() {
//        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        oc.update();
////        txWall = new Texture("Wall.jpg");
//        //Setting up Walls
////        arWall[0] = new Wall(Gdx.graphics.getWidth(), 50, 0, 0);    //Top Wall
////        arWall[1] = new Wall(50, Gdx.graphics.getHeight() - 50, Gdx.graphics.getWidth() - 50, 0);   //Right Wall
////        arWall[2] = new Wall(50, Gdx.graphics.getHeight() - 50, 0, 0);     //Left Wall
////        arWall[3] = new Wall(Gdx.graphics.getWidth(), 50, 0, Gdx.graphics.getHeight() - 100);       //Bottom Wall
//        batch = new SpriteBatch();
//        txNamP = new Texture("P.jpg");
//        sprNamP = new Sprite(txNamP);
//        sprNamP.setSize(60, 80);
//        sprNamP.setFlip(false, true);
//        sprNamP.setPosition(Gdx.graphics.getWidth() / 2 - 30, Gdx.graphics.getHeight() / 2 - 40);
//        dud1 = new Dude(50, 100, 200, 250);
//        btnAni = new Button(100, 50, Gdx.graphics.getWidth() - 100, Gdx.graphics.getHeight() - 50, "Animation.jpg");
//        btnQuit = new Button(100, 50, 0, Gdx.graphics.getHeight() - 50, "Quit.jpg");
//        Gdx.input.setInputProcessor(this);
//    }
//
//    @Override
//    public void render(float delta) {
//        Gdx.gl.glClearColor(.135f, .206f, .235f, 1); //blue background.
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        float fSx = dud1.getX();
//        float fSy = dud1.getY();
//        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
//            dud1.setX(dud1.getX() - 5);
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
//            dud1.setX(dud1.getX() + 5);
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
//            dud1.setY(dud1.getY() + 5);
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
//            dud1.setY(dud1.getY() - 5);
//        }
//        if (isHitS(dud1, sprNamP)) {
//            dud1.setPosition(fSx, fSy);
//        }
////        for (int i = 0; i < arWall.length; i++) {
////            if (isHitS(dud1, arWall[i])) {
////                dud1.setPosition(fSx, fSy);
////            }
////        }
//        batch.begin();
//        batch.setProjectionMatrix(oc.combined);
//        btnAni.draw(batch);
//        btnQuit.draw(batch);
//        sprNamP.draw(batch);
//        dud1.draw(batch);
////        for (int i = 0; i < arWall.length; i++) {
////            arWall[i].draw(batch);
////        }
//        batch.end();
//
//    }
//
//    @Override
//    public void resize(int width, int height) {
//    }
//
//    @Override
//    public void pause() {
//    }
//
//    @Override
//    public void resume() {
//    }
//
//    @Override
//    public void hide() {
//    }
//
//    @Override
//    public void dispose() {
//        batch.dispose();
//        txNamP.dispose();
//    }
//
//    @Override
//    public boolean keyDown(int keycode) {
//        return false;
//    }
//
//    @Override
//    public boolean keyUp(int keycode) {
//        return false;
//    }
//
//    @Override
//    public boolean keyTyped(char character) {
//        return false;
//    }
//
//    @Override
//    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//        if (button == Input.Buttons.LEFT) {
//            //System.out.println(screenX +" " + screenY);
//            if (isHitB(screenX, screenY, btnAni)) {
//                gamMenu.updateState(3);
//                System.out.println("Hit Tools");
//            } else if (isHitB(screenX, screenY, btnQuit)) {
//                gamMenu.updateState(2);
//                System.out.println("Hit Quit");
//            } else {
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
//        return false;
//    }
//
//    @Override
//    public boolean touchDragged(int screenX, int screenY, int pointer) {
//        return false;
//    }
//
//    @Override
//    public boolean mouseMoved(int screenX, int screenY) {
//        return false;
//    }
//
//    @Override
//    public boolean scrolled(int amount) {
//        return false;
//    }
//
//    public boolean isHitB(int nX, int nY, Sprite sprBtn) {
//        if (nX > sprBtn.getX() && nX < sprBtn.getX() + sprBtn.getWidth() && nY > sprBtn.getY() && nY < sprBtn.getY() + sprBtn.getHeight()) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public boolean isHitS(Sprite spr1, Sprite spr2) {
//        return spr1.getBoundingRectangle().overlaps(spr2.getBoundingRectangle());
//    }
//}

public class ScrPlay implements Screen {

    GamMenu game;
    private int movePath;
//    private Texture txDot;
    private Texture txHero;
    private Texture txHeroProjectile;
    private Texture txEnemy;
//    private Sound dropSound;
    private Sound shotSound;
    private Music gamemusic;
    private Music gameovermusic;
    private Music endscreenmusic;
    private SpriteBatch batch;
    private Sprite /*sprDot*/ sprHero, sprEnemy, sprHeroProjectile; // a Sprite allows you to get the bounding rectangle
    private OrthographicCamera camera;
    private Array<Sprite> arsprDrop; // use an array of Sprites rather than rectangles
    private Array<Sprite> arsprHeroprojectile;
    private Array<Sprite> arsprEnemy;
    private long lastDropTime;
    private long lastShotTime;
    private long lastEnemyTime;
    private int nScore;
    private int nLives;
    private BitmapFont font;
    private int spawnMillis;

    public ScrPlay(GamMenu _game) {
        game = _game;
        // load the images for the droplet and the bucket, 64x64 pixels each
//        txDot = new Texture(Gdx.files.internal("dot.png"));
        txHero = new Texture(Gdx.files.internal("Hero.png"));
        txHeroProjectile = new Texture(Gdx.files.internal("Hero Projectile.png"));
        txEnemy = new Texture(Gdx.files.internal("Enemy.png"));
        font = new BitmapFont();
        nLives = 3;
        spawnMillis = 1000;
        sprHero = new Sprite(txHero);
        sprHeroProjectile = new Sprite(txHeroProjectile);
//        sprDot = new Sprite(txDot);
        sprEnemy = new Sprite(txEnemy);

        // load the drop sound effect and the rain background "music"
//        dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
//        if (game.equals(1)) {
        gamemusic = Gdx.audio.newMusic(Gdx.files.internal("Game Music.mp3"));
        gameovermusic = Gdx.audio.newMusic(Gdx.files.internal("Gameover.wav"));
        endscreenmusic = Gdx.audio.newMusic(Gdx.files.internal("endscreen.mp3"));
//        }
        shotSound = Gdx.audio.newSound(Gdx.files.internal("shot.mp3"));
        // start the playback of the background music immediately
        //rainMusic.setLooping(true);
//        rainMusic.play();

        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();
        arsprDrop = new Array<Sprite>();// array of Sprites rather than Rectangles
        arsprHeroprojectile = new Array<Sprite>();
        batch = new SpriteBatch();
        arsprEnemy = new Array<Sprite>();
//        spawnRaindrop();
        spawnHeroprojectile();
        spawnEnemy();
    }

//    private void spawnRaindrop() {
//        Sprite sprDrop = new Sprite(txDot);
//        sprDrop.setX(MathUtils.random(0, 800 - 64));
//        sprDrop.setY(480);
//        arsprDrop.add(sprDrop);
//        lastDropTime = TimeUtils.nanoTime();
//    }
    
    private void spawnHeroprojectile() {
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
        Sprite sprHeroProjectile = new Sprite(txHeroProjectile);
        sprHeroProjectile.setX(115);        
        sprHeroProjectile.setY(15);
        arsprHeroprojectile.add(sprHeroProjectile);
        lastShotTime = TimeUtils.nanoTime();
      }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
        Sprite sprHeroProjectile = new Sprite(txHeroProjectile);
        sprHeroProjectile.setX(115);        
        sprHeroProjectile.setY(15);
        arsprHeroprojectile.add(sprHeroProjectile);
        lastShotTime = TimeUtils.nanoTime();
      }
   }

    private void spawnEnemy() {
        Sprite sprEnemy = new Sprite(txEnemy);
        sprEnemy.setX(MathUtils.random(0, 800 - 64));
        sprEnemy.setY(480);
        arsprEnemy.add(sprEnemy);
        lastEnemyTime = TimeUtils.millis();
    }

    @Override
    public void dispose() {
        // dispose of all the native resources
//        txDot.dispose();
        txHeroProjectile.dispose();
        txHero.dispose();
//        dropSound.dispose();
        shotSound.dispose();
//        rainMusic.dispose();
        batch.dispose();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        // notice that when you implement a Screen, "render" requires  the float delta to be passed.
        // clear the screen with a dark blue color. The
        // arguments to glClearColor are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell the camera to update its matrices.
        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        batch.setProjectionMatrix(camera.combined);

        // begin a new batch and draw the bucket and
        // all drops
        batch.begin();
        if (nLives > 0) {
            batch.draw(sprHero, sprHero.getX(), sprHero.getY());
            batch.draw(sprEnemy, sprEnemy.getX(), sprEnemy.getY());

//            for (Sprite sprDrop : arsprDrop) {
//                batch.draw(sprDrop, sprDrop.getX(), sprDrop.getY());
//            }
            for (Sprite sprHeroProjectile: arsprHeroprojectile) {
                batch.draw(sprHeroProjectile, sprHeroProjectile.getX(), sprHeroProjectile.getY());
            }
        }
        font.draw(batch, Integer.toString(nScore), 10, 10);
        font.draw(batch, Integer.toString(nLives), 200, 10);
        font.draw(batch, Integer.toString(spawnMillis), 400, 10);
        batch.end();

        // process user input
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            sprHero.setX(touchPos.x - 64 / 2);
        }
        /*if(Gdx.input.isKeyPressed(Keys.LEFT)) bucket.x -= 200 * Gdx.graphics.getDeltaTime();
         if(Gdx.input.isKeyPressed(Keys.RIGHT)) bucket.x += 200 * Gdx.graphics.getDeltaTime();*/
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            spawnHeroprojectile();
        }
        if (Gdx.input.isKeyPressed(Keys.A)) {
            sprHero.setX(sprHero.getX() - 200 * Gdx.graphics.getDeltaTime());
        }
        if (Gdx.input.isKeyPressed(Keys.SPACE)) {
            sprEnemy.setY(sprEnemy.getY() + 200 * Gdx.graphics.getDeltaTime());
        }
//        if (Gdx.input.isKeyPressed(Keys.UP)) {
//            sprHero.setY(sprHero.getY() + 500 * Gdx.graphics.getDeltaTime());
//        }
        if (Gdx.input.isKeyPressed(Keys.W)) {
            sprHero.setY(sprHero.getY() + 200 * Gdx.graphics.getDeltaTime());
        }
//        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
//            sprHero.setY(sprHero.getY() - 500 * Gdx.graphics.getDeltaTime());
//        }
        if (Gdx.input.isKeyPressed(Keys.S)) {
            sprHero.setY(sprHero.getY() - 200 * Gdx.graphics.getDeltaTime());
        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
          spawnHeroprojectile();
        }
        if (Gdx.input.isKeyPressed(Keys.D)) {
            sprHero.setX(sprHero.getX() + 200 * Gdx.graphics.getDeltaTime());
        }
        
//        if (Gdx.input.isKeyPressed(Keys.SPACE)) {
//          //sprHeroProjectile.setX(sprHeroProjectile.getX() + 500 * Gdx.graphics.getDeltaTime());
//          spawnHeroprojectile();
//        }

        // make sure the bucket stays within the screen bounds
        /*if(bucket.x < 0) bucket.x = 0;
         if(bucket.x > 800 - 64) bucket.x = 800 - 64;*/
        if (sprHero.getX() < 0) {
            sprHero.setX(0);
        }
        if (sprHero.getX() > 800 - 64) {
            sprHero.setX(800 - 64);
        }
        if (sprHero.getY() < 0) {
            sprHero.setY(0);
        }
        if (sprHero.getY() > 400) {
            sprHero.setY(400);
        }
        if (sprEnemy.getX() < 0) {
            sprEnemy.setX(0);
        }
        if (sprEnemy.getX() > 800 - 64) {
            sprEnemy.setX(800 - 64);
        }

        // check if we need to create a new raindrop
        spawnMillis = 1000 - (nScore * 5 / 2);
//        if (TimeUtils.nanoTime() - lastDropTime > 1000000 * spawnMillis) {
//            spawnRaindrop();
//        }
        //if (TimeUtils.nanoTime() - lastShotTime > 1000000 * spawnMillis) {
        //    spawnHeroprojectile();
        //}
        if (TimeUtils.nanoTime() - lastEnemyTime > 1000000 * spawnMillis) {
            spawnEnemy();
        }

        // move the raindrops, remove any that are beneath the bottom edge of
        // the screen or that hit the bucket. In the later case we play back
        // a sound effect as well.
        //Iterator<Rectangle> iter = raindrops.iterator();
//        Iterator<Sprite> iter = arsprDrop.iterator();
        Iterator<Sprite> shot = arsprHeroprojectile.iterator();
        while (/*iter.hasNext() && */ shot.hasNext()) {
//            Sprite sprDot = iter.next();
            Sprite sprHeroProjectile = shot.next();
            // lower the drop
            //raindrop.y -= (150 + 2*nScore) * Gdx.graphics.getDeltaTime();
//            sprDot.setY(sprDot.getY() - (150 + 2 * nScore) * Gdx.graphics.getDeltaTime());
            sprHeroProjectile.setX(sprHeroProjectile.getX() + 15);
//            if (sprDot.getY() + 64 < 0) {
//                nLives--;
//                iter.remove();
//            }
            if (sprHeroProjectile.getX() > 800 - 64) {
                shot.remove();
            }
            if (sprHeroProjectile.getBoundingRectangle().overlaps(sprEnemy.getBoundingRectangle())) {
                shotSound.play();
                nScore++;
                shot.remove();
            }
            
//            if (sprHero.getBoundingRectangle().overlaps(sprEnemy.getBoundingRectangle())) {
//                nLives--;
//            }
//            if (sprDot.getBoundingRectangle().overlaps(sprHero.getBoundingRectangle())) {
//                dropSound.play();
//                nScore++;
//                iter.remove();
//            }
//            if (sprDot.getBoundingRectangle().overlaps(sprEnemy.getBoundingRectangle())) {
//                dropSound.play();
//                nScore--;
//                iter.remove();
//            }
            if (Gdx.input.isKeyPressed(Keys.LEFT)) {
                shotSound.play();
            }
            if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
                shotSound.play();
            }
            if (nLives == 0){
                //setScreen(scrGameover());
                game.updateState(2);
                gameovermusic.play();
                endscreenmusic.setLooping(true);
                endscreenmusic.play(); 
            }
            
            if (nLives > 0){
                gamemusic.play();
            }
        }
    }

    @Override
    public void hide() {
    }
}