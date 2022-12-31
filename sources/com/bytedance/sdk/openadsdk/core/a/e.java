package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.h;
/* compiled from: RewardBarClickListener.java */
/* loaded from: classes.dex */
public abstract class e extends a {
    public e(@NonNull Context context, @NonNull h hVar, @NonNull String str, int i2) {
        super(context, hVar, str, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.a, com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
    public void a(View view, int i2, int i3, int i4, int i5) {
        a_(view, i2, i3, i4, i5);
        super.a(view, i2, i3, i4, i5);
    }

    protected abstract void a_(View view, int i2, int i3, int i4, int i5);
}
