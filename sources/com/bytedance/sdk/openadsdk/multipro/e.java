package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.core.o;
/* compiled from: TTPathConst.java */
/* loaded from: classes.dex */
public class e {
    public static String a = "com.bytedance.openadsdk";
    public static String b = "content://" + a + ".TTMultiProvider";

    static {
        a();
    }

    public static void a() {
        if (o.a() != null) {
            a = o.a().getPackageName();
            b = "content://" + a + ".TTMultiProvider";
        }
    }
}
