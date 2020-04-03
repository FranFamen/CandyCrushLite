package Presenter;
import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

import Model.BlockModel;
import Service.NetService;


public class StagePresenter {

    int wallLength;
    private int[] xAndYCoordinates;


    public StagePresenter() {

        wallLength = NetService.getWallLength();
    }
    public int[] GetXLocation()
    {
        int[] blockXCoordinates = new int[NetService.getBlockList().size()];
        for(int i = 0; i < blockXCoordinates.length; i++){
            if(!NetService.getBlockList().get(i).isBlockInMove()){
                blockXCoordinates[i] = NetService.getBlockList().get(i).getColumnID() * wallLength;
            }
        }
        return blockXCoordinates;
    }
    public int[] GetYLocation()
    {
        int[] blockYCoordinates = new int[NetService.getBlockList().size()];
        for(int i = 0; i < blockYCoordinates.length; i++){
            blockYCoordinates[i] = NetService.getBlockList().get(i).getRowID() * wallLength;
        }
        return blockYCoordinates;
    }
    public int GetClickedBlockID(){
        xAndYCoordinates = new int[2];
        int xClickCoordinate = xAndYCoordinates[0];
        int yClickCoordinate = xAndYCoordinates[1];
        ArrayList<BlockModel> blockModels= NetService.getBlockList();
        int clickedBlockRowID = 0;
        int clickedBlockColumnID = 0;
        for(int i = 0; i < NetService.getBlockList().size(); i++){
            if(blockModels.get(i).getColumnID() != 0){
                if(xClickCoordinate > blockModels.get(i -1).getColumnID() * wallLength && xClickCoordinate < blockModels.get(i).getColumnID() * wallLength){
                    clickedBlockColumnID = blockModels.get(i -1).getColumnID();
                }
            }
            if(blockModels.get(i).getRowID() != 0){
                if(yClickCoordinate > blockModels.get(i -1).getRowID() * wallLength && yClickCoordinate < blockModels.get(i).getRowID() * wallLength){
                    clickedBlockColumnID = blockModels.get(i -1).getColumnID();
                }
            }
        }
        return NetService.getBlockByRowAndColumnID(clickedBlockRowID, clickedBlockColumnID).getID();
        //return 4;
    }
    public void ChangeColorOfClickedBlock(){
        int blockID = GetClickedBlockID();
        BlockModel block = NetService.getBlockByID(blockID);
        int newColorID = BlockModel.ColorLottery();
        if(block.getColorID() != newColorID){
            block.setColorID(newColorID);
        }
    }

    public void setxAndYCoordinates(int[] xAndYCoordinates) {
        this.xAndYCoordinates = xAndYCoordinates;
    }


}
