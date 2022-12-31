package com.pinguo.camera360.homepage.beautylab;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.s;
/* compiled from: PuzzleLauncher.kt */
/* loaded from: classes3.dex */
public final class b {
    public static final void a(Context context) {
        s.h(context, "context");
        Intent intent = new Intent();
        intent.setClassName(context, "com.camera360.dynamic_feature_splice.PhotoPickActivityNew");
        intent.setFlags(603979776);
        us.pinguo.common.log.a.k("launch CameraActivity", new Object[0]);
        context.startActivity(intent);
    }
}
