package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tapjoy.internal.gz;
import com.tapjoy.internal.j;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes3.dex */
public class InstallReferrerReceiver extends j {
    @Override // com.tapjoy.internal.j, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        VdsAgent.onBroadcastReceiver(this, context, intent);
        String a = gz.a(context, intent);
        int a2 = a(context, intent);
        if (intent.getBooleanExtra("fiverocks:verify", false) && isOrderedBroadcast()) {
            setResultCode(a2 + 1);
            if (a != null) {
                try {
                    setResultData("http://play.google.com/store/apps/details?id=" + context.getPackageName() + "&referrer=" + URLEncoder.encode(a, "UTF-8"));
                } catch (UnsupportedEncodingException unused) {
                }
            }
        }
    }
}
