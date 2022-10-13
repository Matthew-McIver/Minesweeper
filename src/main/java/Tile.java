public class Tile {
    //Attributes
    private int nearbyBombCnt;
    private boolean tileVisible;
    private boolean isBomb;
    private boolean isFlag;
    private String mySymbol;
    private String currentSymbol;

    //Constructor
    public Tile(){
        this.nearbyBombCnt = 0;
        this.tileVisible = false;
        this.isBomb = false;
        this.isFlag = false;
        this.mySymbol = " O ";
        this.currentSymbol = " - ";
    }

    //Methods
    public void setNearbyBombCnt(int nearBombCnt){
        this.nearbyBombCnt = nearBombCnt;
    }
    public int getNearbyBombCnt(){
        return nearbyBombCnt;
    }

    public void setBomb(){
        this.isBomb = true;
        this.mySymbol = " X ";
    }
    public boolean getBomb(){
        return isBomb;
    }

    public void setFlag(){
        this.isFlag = !this.isFlag;
    }
    public boolean getFlag(){
        return this.isFlag;
    }

    public void changeVisibility(){
        this.tileVisible = true;
        this.currentSymbol = this.mySymbol;
    }

    public String showSymbol(){
        return currentSymbol;
    }

    public void addCnt(){
        nearbyBombCnt++;
        showBombCnt();
    }

    public void showBombCnt(){
        String combinedValues = " " + nearbyBombCnt + " ";
        this.mySymbol = combinedValues;
    }

    public boolean getVisibility(){
        return tileVisible;
    }
}
