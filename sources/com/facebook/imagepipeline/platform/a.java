package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.util.Pools;
import androidx.core.util.Preconditions;
import javax.annotation.concurrent.ThreadSafe;
/* compiled from: ArtDecoder.java */
@ThreadSafe
@TargetApi(21)
/* loaded from: classes.dex */
public class a extends b {
    public a(com.facebook.imagepipeline.memory.d dVar, int i2, Pools.SynchronizedPool synchronizedPool) {
        super(dVar, i2, synchronizedPool);
    }

    @Override // com.facebook.imagepipeline.platform.b
    public int e(int i2, int i3, BitmapFactory.Options options) {
        return com.facebook.imageutils.a.d(i2, i3, (Bitmap.Config) Preconditions.checkNotNull(options.inPreferredConfig));
    }
}
