package fr.android.androidexercises;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

/**
 * Created by maeln on 21/02/17.
 */

public class BigJobService extends IntentService {

    public BigJobService() {
        super(BigJobService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        long endTime = System.currentTimeMillis() + 5 * 1000;
        try {
            wait(endTime - System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Toast.makeText(BigJobService.this, "It's done", Toast.LENGTH_LONG).show();
    }
}
