package client;


import okhttp3.*;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by krystiansola on 14.07.2017.
 */
public class OkClient extends Thread {

    OkHttpClient client = new OkHttpClient();

    public OkClient(String name) {
        super(name);
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {

            RequestBody formBody = new FormBody.Builder()
                    .add("name", UUID.randomUUID().toString().substring(0,19))
                    .add("password", "123")
                    .build();

            Request request = new Request.Builder()
                    .url("http://localhost:8080/register")
                    .post(formBody)
                    .build();

            try {
                Response response = client.newCall(request).execute();
                Thread.sleep(100);
                System.out.println("Get Response " + i  + " in thread " + getName());
            } catch (Exception e) {
                System.out.print("failed");
                e.printStackTrace();
                break;
            }
            finally {
            }
            i++;
        }
    }
}
