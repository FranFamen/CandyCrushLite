package Main_Class;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

import Service.NetService;
import Views.MenuView;
import Views.StageView;

public class MyGdxGame extends ApplicationAdapter implements GestureDetector.GestureListener {
    NetService netService;
	StageView stageView;

	@Override
	public void create () {
        netService = new NetService();
		stageView = new StageView();
		Gdx.input.setInputProcessor(new GestureDetector(new MyGdxGame()));
	}

	@Override
	public void render () {
		stageView.Draw();
	}
	
	@Override
	public void dispose () {
		stageView.dispose();
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		//stageView.SetXAndYClickCoordinates(x,y);
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {

		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
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
