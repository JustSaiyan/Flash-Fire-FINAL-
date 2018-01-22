//package gdx.menu.Screens;
//
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input;
//import com.badlogic.gdx.InputProcessor;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.graphics.g2d.Sprite;
//import com.badlogic.gdx.graphics.Texture;
//import gdx.menu.GamMenu;
//
//public class ScrGameover implements Screen, InputProcessor {
//
//    Button btnMenu, btnPlay;
//    OrthographicCamera oc;
//    Texture txNamQ;
//    GamMenu gamMenu;
//    SpriteBatch batch;
//    Sprite sprNamQuit;
//
//    public ScrGameover(GamMenu _gamMenu) {  //Referencing the main class.
//        gamMenu = _gamMenu;
//    }
//
//    @Override
//    public void show() {
//        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        oc.update();
//        batch = new SpriteBatch();
//        btnPlay = new Button(100, 50, 0, Gdx.graphics.getHeight() - 50, "Play.jpg");
//        btnMenu = new Button(100, 50, Gdx.graphics.getWidth() - 100, Gdx.graphics.getHeight() - 50, "Menu.jpg");
//        txNamQ = new Texture("Q.jpg");
//        sprNamQuit = new Sprite(txNamQ);
//        sprNamQuit.setFlip(false, true);
//        sprNamQuit.setSize(60, 80);
//        sprNamQuit.setPosition(Gdx.graphics.getWidth() / 2 - 30, Gdx.graphics.getHeight() / 2 - 40);
//        Gdx.input.setInputProcessor(this);
//    }
//
//    @Override
//    public void render(float Delta) {
//        Gdx.gl.glClearColor(0, 1, 1, 1); //Cyan background.
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        batch.begin();
//        batch.setProjectionMatrix(oc.combined);
//        btnPlay.draw(batch);
//        btnMenu.draw(batch);
//        sprNamQuit.draw(batch);
//        batch.end();
//    }
//
//    /*
//     * UpdateState(0) for Menu
//     * UpdateState(1) for Play
//     */
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
//        txNamQ.dispose();
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
//            if (isHit(screenX, screenY, btnPlay)) {
//                gamMenu.updateState(1);
//                System.out.println("Hit Play");
//            } else if (isHit(screenX, screenY, btnMenu)) {
//                gamMenu.updateState(0);
//                System.out.println("Hit Menu");
//            } 
////            else if (gamMenu.equals(2) && isHit(screenX, screenY, btnPlay)) {
////                gamMenu.updateState(1);
////                System.out.println("Hit Play");
////            }
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
//    public boolean isHit(int nX, int nY, Sprite sprBtn) {
//        if (nX > sprBtn.getX() && nX < sprBtn.getX() + sprBtn.getWidth() && nY > sprBtn.getY() && nY < sprBtn.getY() + sprBtn.getHeight()) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//}

package gdx.menu.Screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.Texture;
import gdx.menu.GamMenu;

public class ScrGameover implements Screen, InputProcessor {

    Button btnMenu, btnPlay;
    OrthographicCamera oc; 
    Texture txGameover;
    GamMenu gamMenu;
    SpriteBatch batch;
    Sprite sprGameover;

    public ScrGameover(GamMenu _gamMenu) {  //Referencing the main class.
        gamMenu = _gamMenu;
    }

    @Override
    public void show() {
        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.update();
        batch = new SpriteBatch();
        btnPlay = new Button(100, 50, 0, Gdx.graphics.getHeight() - 50, "Play.jpg");
        btnMenu = new Button(100, 50, Gdx.graphics.getWidth() - 100, Gdx.graphics.getHeight() - 50, "Menu.jpg");
        txGameover = new Texture("Gameover.jpg");
        sprGameover = new Sprite(txGameover);
        sprGameover.setFlip(false, true);
        sprGameover.setSize(400, 400);
        sprGameover.setPosition(120, 40);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float Delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0); //Cyan background.
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.setProjectionMatrix(oc.combined);
        btnPlay.draw(batch);
        btnMenu.draw(batch);
        sprGameover.draw(batch);
        batch.end();
    }

    /*
     * UpdateState(0) for Menu
     * UpdateState(1) for Play
     */
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
    public void hide() {
    }

    @Override
    public void dispose() {
        batch.dispose();
        txGameover.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (button == Input.Buttons.LEFT) {
            if (isHit(screenX, screenY, btnPlay)) {
                gamMenu.updateState(1);
                System.out.println("Hit Play");
            } else if (isHit(screenX, screenY, btnMenu)) {
                gamMenu.updateState(0);
                System.out.println("Hit Menu");
            }
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public boolean isHit(int nX, int nY, Sprite sprBtn) {
        if (nX > sprBtn.getX() && nX < sprBtn.getX() + sprBtn.getWidth() && nY > sprBtn.getY() && nY < sprBtn.getY() + sprBtn.getHeight()) {
            return true;
        } else {
            return false;
        }
    }
}
