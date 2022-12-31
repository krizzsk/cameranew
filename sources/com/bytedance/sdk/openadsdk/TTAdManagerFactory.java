package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.t;
import com.bytedance.sdk.openadsdk.multipro.b;
@Deprecated
/* loaded from: classes.dex */
public class TTAdManagerFactory {
    private static final TTAdManager a = new t();

    private TTAdManagerFactory() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TTAdManager a() {
        return a;
    }

    public static TTAdManager getInstance(Context context) {
        return getInstance(context, false);
    }

    public static TTAdManager getInstance(Context context, boolean z) {
        if (z) {
            b.a();
        }
        l.a(context);
        return a;
    }
}
