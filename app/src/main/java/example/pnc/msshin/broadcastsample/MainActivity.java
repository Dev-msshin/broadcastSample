package example.pnc.msshin.broadcastsample;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    private final String TAG = getClass().getSimpleName();

    private BroadcastReceiver mBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        mBroadcastReceiver = new DynamicBroadcastReceiver();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerBroadcast();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterBroadcast();
    }

    private void registerBroadcast() {
        Log.d(TAG, "registerBroadcast()");
        if (mBroadcastReceiver != null) {
            IntentFilter filter = new IntentFilter();
            filter.addAction(DynamicBroadcastReceiver.ACTION_TEST);
            registerReceiver(mBroadcastReceiver, filter);
        }
    }
    private void unregisterBroadcast() {
        Log.d(TAG, "unregisterBroadcast()");
        if (mBroadcastReceiver != null) {
            unregisterReceiver(mBroadcastReceiver);
        }
    }
}
