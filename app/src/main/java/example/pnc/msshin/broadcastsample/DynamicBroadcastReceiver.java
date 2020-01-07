package example.pnc.msshin.broadcastsample;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class DynamicBroadcastReceiver extends BroadcastReceiver {
    private String TAG = "DynamicBroadcastReceiver";
    public static final String ACTION_TEST = "ipl.action.test";
    private final String EXTRA_TEST = "ipl.extra.test";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            Log.d(TAG, "onReceive() - action: " + intent.getAction());
            if (action != null) {
                switch (action) {
                    case ACTION_TEST:
                        String extra = intent.getStringExtra(EXTRA_TEST);
                        Log.d(TAG, "onReceive() - extra: "+extra);
                        break;
                }
            }
        }
    }
}
