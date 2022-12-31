package com.facebook.imagepipeline.h;

import android.graphics.Bitmap;
import android.os.Build;
import javax.annotation.Nullable;
/* compiled from: TransformationUtils.java */
/* loaded from: classes.dex */
public final class b {
    public static boolean a(@Nullable a aVar, @Nullable com.facebook.common.references.a<Bitmap> aVar2) {
        if (aVar == null || aVar2 == null) {
            return false;
        }
        Bitmap A = aVar2.A();
        if (Build.VERSION.SDK_INT >= 12 && aVar.a()) {
            A.setHasAlpha(true);
        }
        aVar.b(A);
        return true;
    }
}
