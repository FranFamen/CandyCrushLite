package Views;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

import java.io.Console;

import Main_Class.MyGdxGame;
import Model.BlockModel;
import Presenter.StagePresenter;
import Service.NetService;

public class StageView implements GestureDetector.GestureListener {

    StagePresenter presenter;
    private SpriteBatch batch;
    Texture img;
    private GestureDetector mGestureDetector;

    public StageView() {
        presenter = new StagePresenter();
        batch = new SpriteBatch();

        mGestureDetector = new GestureDetector(this);
        Gdx.input.setInputProcessor(mGestureDetector);

    }

    public void Draw(){
        DrawBackground();
        for (int i = 0; i < NetService.getBlockList().size(); i++) {
           // presenter.ChangeColorOfClickedBlock(800, 600);
/*            if(Gdx.input.isTouched()) {
                int x = Gdx.input.getX();
                int y = Gdx.graphics.getHeight() - Gdx.input.getY();
                presenter.ChangeColorOfClickedBlock(x, y);

            }*/
            img = new Texture("Blocks\\Blocks_01_256x256_Alt_00_00" + NetService.getBlockList().get(i).getColorID() + ".png");
            DrawBlock(presenter.GetXLocation()[i], presenter.GetYLocation()[i]);
            img.dispose();
        }
    }
    public void DrawBackground(){
        Gdx.gl.glClearColor(1, 1, 1, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    public void DrawBlock(int XCoordinate, int YCoordinate){
        batch.begin();
        batch.draw(img, XCoordinate, YCoordinate, NetService.getWallLength() , NetService.getWallLength());
        batch.end();
    }
    public void dispose(){
        img.dispose();
        batch.dispose();
    }
    public boolean isScreenTouched(){
        if(Gdx.input.isTouched()){
            int x = Gdx.input.getX();
            int y = Gdx.graphics.getHeight() - Gdx.input.getY();
            presenter.ChangeColorOfClickedBlock(x,y);
            return true;
        }
        return false;
    }

    //GestureDetector
    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        System.out.println("touchdown");
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        presenter.ChangeColorOfClickedBlock((int)x,(int)y);
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        System.out.println("longpress");

        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        System.out.println("fling");

        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {

        //presenter.ChangeColorOfClickedBlock((int)x,(int)y);
        //BlockModel block = NetService.getBlockByID(presenter.GetClickedBlockID((int)x,(int)y));
        //block.setDeltaX((int)deltaX);
        //block.setDeltaY((int)deltaY);
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    @Override
    public void pinchStop() {

    }
}
