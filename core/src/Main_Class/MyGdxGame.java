package Main_Class;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;


import Service.NetService;
import Views.MenuView;
import Views.StageView;

public class MyGdxGame extends ApplicationAdapter{
    NetService netService;
	StageView stageView;

	@Override
	public void create () {
        netService = new NetService();
		stageView = new StageView();


	}

	@Override
	public void render () {
		stageView.Draw();
	}
	
	@Override
	public void dispose () {
		stageView.dispose();
	}



}
