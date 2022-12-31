package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
/* compiled from: ThumbnailSizeChecker.java */
/* loaded from: classes.dex */
public final class d1 {
    public static int a(int i2) {
        return (int) (i2 * 1.3333334f);
    }

    public static boolean b(int i2, int i3, @Nullable com.facebook.imagepipeline.common.d dVar) {
        return dVar == null ? ((float) a(i2)) >= 2048.0f && a(i3) >= 2048 : a(i2) >= dVar.a && a(i3) >= dVar.b;
    }

    public static boolean c(@Nullable com.facebook.imagepipeline.image.e eVar, @Nullable com.facebook.imagepipeline.common.d dVar) {
        if (eVar == null) {
            return false;
        }
        int Q = eVar.Q();
        if (Q != 90 && Q != 270) {
            return b(eVar.T(), eVar.z(), dVar);
        }
        return b(eVar.z(), eVar.T(), dVar);
    }
}
