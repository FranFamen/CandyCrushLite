package Model;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockModel {

    //Tu bedzie cala logika zachowania blokow:
    //Logika sprawdzenia przyznania punktow
    //instrukcje dzialania dla prezentera w przypadku przyznania punktow lub nie
    private int ID;
    private int rowID;
    private int columnID;
    private int colorID;
    private int wallLength;
    private boolean isBlockInMove;
    static ArrayList blockList;
    public BlockModel() {
    }

    public BlockModel(
            int ID,
            int rowID,
            int columnID,
            int wallLength
            )
            {
                this.ID = ID;
                this.rowID = rowID;
                this.columnID = columnID;
                this.colorID = ColorLottery();
                this.wallLength = wallLength;
            }

    public static int ColorLottery()
    {
        Random random = new Random();

        return random.nextInt(6) + 1;
    }
    public boolean isBlockInMove() {
        return isBlockInMove;
    }

    public void setBlockInMove(boolean blockInMove) {
        isBlockInMove = blockInMove;
    }
    public int getID() {
        return ID;
    }

    public void setRowID(int rowID) {
        this.rowID = rowID;
    }

    public void setColumnID(int columnID) {
        this.columnID = columnID;
    }

    public void setColorID(int colorID) {
        this.colorID = colorID;
    }

    public void setWallLength(int wallLength) {
        this.wallLength = wallLength;
    }
    public int getRowID() {
        return rowID;
    }

    public int getColumnID() {
        return columnID;
    }

    public int getColorID() {
        return colorID;
    }

    public int getWallLength() {
        return wallLength;
    }
    public static void CreateBlockList(){
        blockList = new ArrayList();
    }
    public static void AddBlockToBlockList(BlockModel block){
        blockList.add(block);
    }

    public static ArrayList getBlockList() {
        return blockList;
    }

}
