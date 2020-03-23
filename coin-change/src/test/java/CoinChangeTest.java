import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoinChangeTest {
    @Test
    public void testCoinChange(){
        int[] money = {1,2,3};
        CoinChange coinChange = new CoinChange(money);
        int[][] expected = new int[4][];
        expected[0] = new int[4];
        expected[0][0] = 1;
        expected[0][1] = 1;
        expected[0][2] = 1;
        expected[0][3] = 1;
        //assertEquals();
    }
}