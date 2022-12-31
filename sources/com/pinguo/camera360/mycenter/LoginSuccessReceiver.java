package com.pinguo.camera360.mycenter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.user.s0;
/* loaded from: classes3.dex */
public class LoginSuccessReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        VdsAgent.onBroadcastReceiver(this, context, intent);
        s0.getInstance().onLogin();
    }
}
