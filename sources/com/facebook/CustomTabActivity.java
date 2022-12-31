package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes.dex */
public class CustomTabActivity extends Activity {
    public static final String b = CustomTabActivity.class.getSimpleName() + ".action_customTabRedirect";
    public static final String c = CustomTabActivity.class.getSimpleName() + ".action_destroy";
    private BroadcastReceiver a;

    /* loaded from: classes.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VdsAgent.onBroadcastReceiver(this, context, intent);
            CustomTabActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == 0) {
            Intent intent2 = new Intent(b);
            intent2.putExtra(CustomTabMainActivity.f2240f, getIntent().getDataString());
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent2);
            this.a = new a();
            LocalBroadcastManager.getInstance(this).registerReceiver(this.a, new IntentFilter(c));
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = new Intent(this, CustomTabMainActivity.class);
        intent.setAction(b);
        intent.putExtra(CustomTabMainActivity.f2240f, getIntent().getDataString());
        intent.addFlags(603979776);
        startActivityForResult(intent, 2);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.a);
        super.onDestroy();
    }
}
