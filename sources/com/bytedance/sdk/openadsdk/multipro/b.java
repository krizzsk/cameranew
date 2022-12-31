package com.bytedance.sdk.openadsdk.multipro;
/* compiled from: MultiGlobalInfo.java */
/* loaded from: classes.dex */
public class b {
    public static boolean a;
    public static boolean b;

    public static void a() {
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", Boolean.TRUE);
        a = true;
        b = true;
    }

    public static boolean b() {
        if (!b) {
            a = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", false);
            b = true;
        }
        return a;
    }
}
