package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.content.Context;
import com.bytedance.sdk.openadsdk.core.f;
/* compiled from: DBAdapter.java */
/* loaded from: classes.dex */
public class e extends f {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile e a;

    private e(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.openadsdk.core.f
    public /* bridge */ /* synthetic */ f.c a() {
        return super.a();
    }

    public static e a(Context context) {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e(context);
                }
            }
        }
        return a;
    }
}
