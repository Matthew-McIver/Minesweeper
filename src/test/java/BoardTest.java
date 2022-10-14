import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {
    int gridSize = 13;
    Board testBoard = new Board(gridSize);

    @Test
    public void testBoard(){
        for(int i = 0; i < gridSize; i++){
            for (int j = 0; j < gridSize; j++){
                Assertions.assertEquals(false, testBoard.checkVisibility(i, j), "Board is not set up.");
            }
        }
    }


}
