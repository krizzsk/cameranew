package com.camera360.dynamic_feature_splice;

import android.content.Context;
import android.content.Intent;
/* compiled from: PuzzleLauncher.kt */
/* loaded from: classes8.dex */
public final class i1 {
    public static final void a(Context context) {
        kotlin.jvm.internal.s.h(context, "context");
        Intent intent = new Intent();
        intent.setClassName(context, "com.camera360.dynamic_feature_splice.PhotoPickActivityNew");
        intent.setFlags(603979776);
        us.pinguo.common.log.a.k("launch CameraActivity", new Object[0]);
        context.startActivity(intent);
    }
}
