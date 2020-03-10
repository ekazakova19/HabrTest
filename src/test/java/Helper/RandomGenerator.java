package Helper;

import java.util.Random;

public class RandomGenerator {

    public static int getRandomNumberInts(int min, int max){
        Random random = new Random();
        return random.ints(min,(max+1)).findAny().getAsInt();
    }
}
