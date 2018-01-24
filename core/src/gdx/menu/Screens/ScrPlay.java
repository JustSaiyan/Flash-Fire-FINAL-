package gdx.menu.Screens;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import gdx.menu.GamMenu;


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
//    private Array<Sprite> arsprDrop; // use an array of Sprites rather than rectangles
    private Array<Sprite> arsprHeroprojectile;
    private Array<Sprite> arsprEnemy;
    private long lastDropTime;
    private long lastShotTime;
    private long lastEnemyTime;
    private int xEnemy;
    private int yEnemy;
    private int nScore;
    private int nLives;
    private BitmapFont font;
    private int spawnMillis;
    ShapeRenderer renderer;

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
        sprHero = new Sprite(txHero, 290, 175);
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
//        arsprDrop = new Array<Sprite>();// array of Sprites rather than Rectangles
        arsprHeroprojectile = new Array<Sprite>();
        batch = new SpriteBatch();
        arsprEnemy = new Array<Sprite>();
//        spawnRaindrop();
        renderer = new ShapeRenderer();
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
        sprHeroProjectile.setX(sprHero.getX());        
        sprHeroProjectile.setY(sprHero.getY());
        arsprHeroprojectile.add(sprHeroProjectile);
        lastShotTime = TimeUtils.nanoTime();
      }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
        Sprite sprHeroProjectile = new Sprite(txHeroProjectile);
        sprHeroProjectile.setX(sprHero.getX());        
        sprHeroProjectile.setY(sprHero.getY());
        arsprHeroprojectile.add(sprHeroProjectile);
        lastShotTime = TimeUtils.nanoTime();
      }
   }

    private void spawnEnemy() {
        Sprite sprEnemy = new Sprite(txEnemy, 0, 0);
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
            sprHero.draw(batch);
            sprEnemy.draw(batch);

//            for (Sprite sprDrop : arsprDrop) {
//                batch.draw(sprDrop, sprDrop.getX(), sprDrop.getY());
//            }
            for (Sprite sprHeroProjectile: arsprHeroprojectile) {
                batch.draw(sprHeroProjectile, sprHeroProjectile.getX(), sprHeroProjectile.getY());
            }
        }
        if (sprEnemy.getY() == 0) {
        sprEnemy.setPosition(sprEnemy.getX()+5, sprEnemy.getY());
        }
        if (sprEnemy.getX() > 780 - 64) {
        sprEnemy.setPosition(sprEnemy.getX(), sprEnemy.getY()+5);
        }
        if (sprEnemy.getY() > 380) {
        sprEnemy.setPosition(sprEnemy.getX()-5, sprEnemy.getY());
        }
        if (sprEnemy.getX() == 0) {
        sprEnemy.setPosition(sprEnemy.getX(), sprEnemy.getY()-5);
        }
        font.draw(batch, Integer.toString(nScore), 10, 10);
        font.draw(batch, Integer.toString(nLives), 200, 10);
        font.draw(batch, Integer.toString(spawnMillis), 400, 10);
        batch.end();

        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            spawnHeroprojectile();
        }
        if (Gdx.input.isKeyPressed(Keys.A)) {
            sprHero.setX(sprHero.getX() - 200 * Gdx.graphics.getDeltaTime());
        }
        if (Gdx.input.isKeyPressed(Keys.W)) {
            sprHero.setY(sprHero.getY() + 200 * Gdx.graphics.getDeltaTime());
        }
        if (Gdx.input.isKeyPressed(Keys.S)) {
            sprHero.setY(sprHero.getY() - 200 * Gdx.graphics.getDeltaTime());
        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
          spawnHeroprojectile();
        }
        if (Gdx.input.isKeyPressed(Keys.D)) {
            sprHero.setX(sprHero.getX() + 200 * Gdx.graphics.getDeltaTime());
        }


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
        if (sprEnemy.getY() < 0) {
            sprEnemy.setY(0);
        }
        if (sprEnemy.getY() > 400) {
            sprEnemy.setY(400);
        }

        // check if we need to create a new raindrop
        spawnMillis = 1000 - (nScore * 5 / 2);
//        if (TimeUtils.nanoTime() - lastDropTime > 1000000 * spawnMillis) {
//            spawnRaindrop();
//        }
        if (TimeUtils.nanoTime() - lastShotTime > 1000000 * spawnMillis) {
            spawnHeroprojectile();
        }
        if (TimeUtils.nanoTime() - lastEnemyTime > 1000000 * spawnMillis) {
            spawnEnemy();
        }

        // move the raindrops, remove any that are beneath the bottom edge of
        // the screen or that hit the bucket. In the later case we play back
        // a sound effect as well.
        //Iterator<Rectangle> iter = raindrops.iterator();
//        Iterator<Sprite> iter = arsprDrop.iterator();
        Iterator<Sprite> shot = arsprHeroprojectile.iterator();
        while (shot.hasNext()) {
//            Sprite sprDot = iter.next();
            Sprite sprHeroProjectile = shot.next();
            //Sprite sprEnemy = move.next();
            // lower the drop
            //raindrop.y -= (150 + 2*nScore) * Gdx.graphics.getDeltaTime();
//            sprDot.setY(sprDot.getY() - (150 + 2 * nScore) * Gdx.graphics.getDeltaTime());
            sprHeroProjectile.setX(sprHeroProjectile.getX() + 15);
            //sprEnemy.setX(sprEnemy.getX() + 20);
//            if (sprDot.getY() + 64 < 0) {
//                nLives--;
//                iter.remove();
//            }
//            renderer.begin(ShapeType.Line);
//            renderer.setColor(Color.BLACK);
//            renderer.setProjectionMatrix(camera.combined);
//            renderer.rect(sprEnemy.getX(), sprEnemy.getY(), sprEnemy.getWidth(),sprEnemy.getHeight());
//            renderer.rect(sprHeroProjectile.getX(), sprHeroProjectile.getY(), sprHeroProjectile.getWidth(), sprHeroProjectile.getHeight());
//            renderer.end();
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