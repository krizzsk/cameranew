package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.IListenerManager;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* compiled from: CommonDialogHelper.java */
/* loaded from: classes.dex */
public class e {
    private static final Map<String, a> a = Collections.synchronizedMap(new HashMap());
    private static IListenerManager b;

    /* compiled from: CommonDialogHelper.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    public static void b(String str) {
        a(str, 2);
    }

    public static void c(String str) {
        a(str, 3);
    }

    public static a d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return a.remove(str);
    }

    public static void a(String str) {
        a(str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IListenerManager b() {
        if (b == null) {
            b = IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(com.bytedance.sdk.openadsdk.core.o.a()).a(2));
        }
        return b;
    }

    private static void a(final String str, final int i2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            new Thread(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.e.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.b().broadcastDialogListener(str, i2);
                    } catch (Throwable unused) {
                    }
                }
            }).start();
            return;
        }
        a d2 = d(str);
        if (d2 == null) {
            return;
        }
        if (i2 == 1) {
            d2.a();
        } else if (i2 == 2) {
            d2.b();
        } else if (i2 != 3) {
            d2.c();
        } else {
            d2.c();
        }
    }
}
