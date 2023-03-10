package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.t;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes.dex */
public class FacebookBroadcastReceiver extends BroadcastReceiver {
    protected void a(String str, String str2, Bundle bundle) {
    }

    protected void b(String str, String str2, Bundle bundle) {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        VdsAgent.onBroadcastReceiver(this, context, intent);
        String stringExtra = intent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
        String stringExtra2 = intent.getStringExtra("com.facebook.platform.protocol.PROTOCOL_ACTION");
        if (stringExtra == null || stringExtra2 == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        if (t.B(intent)) {
            a(stringExtra, stringExtra2, extras);
        } else {
            b(stringExtra, stringExtra2, extras);
        }
    }
}
