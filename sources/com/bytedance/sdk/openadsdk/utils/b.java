package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import us.pinguo.androidsdk.PGImageSDK;
/* compiled from: ActivityUtil.java */
/* loaded from: classes.dex */
public class b {

    /* compiled from: ActivityUtil.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();

        void a(Throwable th);
    }

    public static void a(Context context, Intent intent, a aVar) {
        if (context == null || intent == null) {
            return;
        }
        try {
            if (!(context instanceof Activity)) {
                intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
            }
            context.startActivity(intent);
            if (aVar != null) {
                aVar.a();
            }
        } catch (Throwable th) {
            if (aVar != null) {
                aVar.a(th);
            }
        }
    }
}
