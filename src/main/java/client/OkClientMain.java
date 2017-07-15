package client;

/**
 * Created by krystiansola on 14.07.2017.
 */
public class OkClientMain {

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 9; i++) {
            new OkClient("Wątek " + i).start();
        }

    }
}
