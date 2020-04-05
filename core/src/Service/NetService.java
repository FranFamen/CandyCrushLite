package Service;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;
import Model.BlockModel;

public class NetService {
    BlockModel block;

    static int NUMBER_OF_COLUMNS = 6;
    static int NUMBER_OF_ROWS = 10;
    static ArrayList blockList;
    static int wallLength;
    int blockNumber = 0;

    public NetService() {
        CreateBlockNet();
    }

    public void CreateBlockNet() {
        wallLength = Gdx.graphics.getWidth() / NUMBER_OF_COLUMNS;
        BlockModel.CreateBlockList();
        for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
            for (int j = 0; j < NUMBER_OF_ROWS; j++) {
                block = new BlockModel(blockNumber,j, i, wallLength);
                BlockModel.AddBlockToBlockList(block);
                blockNumber++;
            }
        }
    }
    public static BlockModel getBlockByID(int blockID) {
        BlockModel blockModel = null;
        for (int i = 0; i < BlockModel.getBlockList().size(); i++) {
            if(getBlockList().get(i).getID()== blockID){
                blockModel = (BlockModel) BlockModel.getBlockList().get(i);
            }
        }
        return blockModel;
    }



    public static ArrayList getBlocksByRowID(int rowID) {
        ArrayList blockListWithRowID = new ArrayList();
        for (int i = 0; i < BlockModel.getBlockList().size(); i++) {
            if(getBlockList().get(i).getRowID()== rowID){
                blockListWithRowID.add(BlockModel.getBlockList().get(i));
            }
        }
        return blockListWithRowID;
    }

    public static ArrayList getBlocksByColumnID(int columnID) {
        ArrayList blocksListWithColumnID = new ArrayList();
        for (int i = 0; i < BlockModel.getBlockList().size(); i++) {
            if(getBlockList().get(i).getColumnID() == columnID){
                blocksListWithColumnID.add(BlockModel.getBlockList().get(i));
            }
        }
        return blocksListWithColumnID;
    }

    public static BlockModel getBlockByRowAndColumnID(int rowID, int columnID) {
        for (int i = 0; i < BlockModel.getBlockList().size(); i++) {
            if (getBlockList().get(i).getRowID() == rowID && getBlockList().get(i).getColumnID() == columnID) {
                BlockModel block = new BlockModel();
                return block = getBlockList().get(i);
            }
        }
        return null;
    }

    public static ArrayList<BlockModel> getBlockList() {
        return BlockModel.getBlockList();
    }
    public static int getWallLength() {
        return wallLength;
    }

    public static int getNumberOfColumns() {
        return NUMBER_OF_COLUMNS;
    }

    public static int getNumberOfRows() {
        return NUMBER_OF_ROWS;
    }



}
