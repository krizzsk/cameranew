package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.m;
import com.google.firebase.messaging.Constants;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes2.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        VdsAgent.onBroadcastReceiver(this, context, intent);
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int intValue = Integer.valueOf(intent.getData().getQueryParameter(Constants.FirelogAnalytics.PARAM_PRIORITY)).intValue();
        int i2 = intent.getExtras().getInt("attemptNumber");
        TransportRuntime.e(context);
        m.a a = com.google.android.datatransport.runtime.m.a();
        a.b(queryParameter);
        a.d(com.google.android.datatransport.runtime.y.a.b(intValue));
        if (queryParameter2 != null) {
            a.c(Base64.decode(queryParameter2, 0));
        }
        TransportRuntime.getInstance().d().g(a.a(), i2, b.a());
    }
}
