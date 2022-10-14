import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//___Test
public class TileTest {
    Tile testTile = new Tile();

    @Test
    public void getNearbyBombCntTest(){
        Assertions.assertEquals(0, testTile.getNearbyBombCnt(), "Nearby bomb count is incorrect.");
    }

    @Test
    public void setBombsTest(){
        Assertions.assertEquals(false, testTile.getBomb(), "Bomb status is incorrect.");
        testTile.setBomb();
        Assertions.assertEquals(true, testTile.getBomb(), "Bomb status is incorrect");
    }

    @Test
    public void changeVisibilityTest(){
        Assertions.assertEquals(false, testTile.getVisibility(), "Visibility is incorrect.");
        testTile.changeVisibility();
        Assertions.assertEquals(true, testTile.getVisibility(), "Visibility is incorrect.");
    }

    @Test
    public void showSymbolTest(){
        Assertions.assertEquals(" - ", testTile.showSymbol(), "The current symbol is incorrect.");
    }
}
