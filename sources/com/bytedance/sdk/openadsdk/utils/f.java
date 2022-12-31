package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.IListenerManager;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* compiled from: CommonPermissionUtils.java */
/* loaded from: classes.dex */
public class f {
    private static final Map<String, a> a = Collections.synchronizedMap(new HashMap());
    private static IListenerManager b;

    /* compiled from: CommonPermissionUtils.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();

        void a(String str);
    }

    private static a b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return a.remove(str);
    }

    public static void a(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            new Thread(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.f.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        o.b("MultiProcess", "handleYes-1，key=" + str);
                        f.b().broadcastPermissionListener(str, null);
                    } catch (Throwable unused) {
                    }
                }
            }).start();
            return;
        }
        a b2 = b(str);
        if (b2 == null) {
            return;
        }
        b2.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IListenerManager b() {
        if (b == null) {
            b = IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(com.bytedance.sdk.openadsdk.core.o.a()).a(4));
        }
        return b;
    }

    public static void a(final String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            new Thread(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.f.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        o.b("MultiProcess", "handleNo-1，key=" + str + "，permission=" + str2);
                        f.b().broadcastPermissionListener(str, str2);
                    } catch (Throwable unused) {
                    }
                }
            }).start();
            return;
        }
        a b2 = b(str);
        if (b2 == null) {
            return;
        }
        b2.a(str2);
    }
}
