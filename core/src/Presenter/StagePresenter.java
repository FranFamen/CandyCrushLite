package Presenter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;

import java.util.ArrayList;

import Model.BlockModel;
import Service.NetService;


public class StagePresenter {

    int wallLength;
    public StagePresenter() {

        wallLength = NetService.getWallLength();
    }
    public int[] GetXLocation()
    {
        int[] blockXCoordinates = new int[NetService.getBlockList().size()];
        for(int i = 0; i < blockXCoordinates.length; i++){
            blockXCoordinates[i] = NetService.getBlockList().get(i).getColumnID() * wallLength;
            /*if(!NetService.getBlockList().get(i).isBlockInMove()){
                blockXCoordinates[i] = NetService.getBlockList().get(i).getColumnID() * wallLength;
            }*/
           /* else{
                blockXCoordinates[i] = NetService.getBlockList().get(i).getColumnID() * wallLength + NetService.getBlockList().get(i).getDeltaX();
            }*/
        }
        return blockXCoordinates;
    }
    public int[] GetYLocation()
    {
        int[] blockYCoordinates = new int[NetService.getBlockList().size()];
        for(int i = 0; i < blockYCoordinates.length; i++){
            blockYCoordinates[i] = NetService.getBlockList().get(i).getRowID() * wallLength;

            /*if(!NetService.getBlockList().get(i).isBlockInMove()){
                blockYCoordinates[i] = NetService.getBlockList().get(i).getRowID() * wallLength;
            }*/

        }
        return blockYCoordinates;
    }
    public int GetClickedBlockID(int x, int y){
        int xClickCoordinate = x;
        int yClickCoordinate = y;
        ArrayList<BlockModel> blockModels= NetService.getBlockList();
        int clickedBlockRowID = 0;
        int clickedBlockColumnID = 0;
        int numberOfColumns = NetService.getNumberOfColumns();
        int numberOfRows = NetService.getNumberOfRows();
        for(int i = 0; i <= numberOfColumns; i++){
            if(i != 0){
                if(x < i * wallLength){
                    clickedBlockColumnID = i - 1;
                    break;
                }
            }
        }
        for(int i = 0; i <= numberOfRows; i++){
            if(i != 0) {
                if (y < i * wallLength) {
                    clickedBlockRowID = i - 1;
                    break;
                }
            }
        }
        NetService.getBlockByRowAndColumnID(clickedBlockRowID, clickedBlockColumnID).setBlockInMove(true);
        return NetService.getBlockByRowAndColumnID(clickedBlockRowID, clickedBlockColumnID).getID();
    }
    public void ChangeColorOfClickedBlock(int x, int y){
        int blockID = GetClickedBlockID(x,y);
        BlockModel block = NetService.getBlockByID(blockID);
        int newColorID = BlockModel.ColorLottery();
        if(block.getColorID() != newColorID){
            block.setColorID(newColorID);
        }
    }



}
