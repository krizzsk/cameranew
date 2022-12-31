package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import androidx.core.util.Pools;
import javax.annotation.concurrent.ThreadSafe;
/* compiled from: OreoDecoder.java */
@ThreadSafe
@TargetApi(26)
/* loaded from: classes.dex */
public class c extends b {
    public c(com.facebook.imagepipeline.memory.d dVar, int i2, Pools.SynchronizedPool synchronizedPool) {
        super(dVar, i2, synchronizedPool);
    }

    private static boolean g(BitmapFactory.Options options) {
        ColorSpace colorSpace = options.outColorSpace;
        return (colorSpace == null || !colorSpace.isWideGamut() || options.inPreferredConfig == Bitmap.Config.RGBA_F16) ? false : true;
    }

    @Override // com.facebook.imagepipeline.platform.b
    public int e(int i2, int i3, BitmapFactory.Options options) {
        if (g(options)) {
            return i2 * i3 * 8;
        }
        Bitmap.Config config = options.inPreferredConfig;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        return com.facebook.imageutils.a.d(i2, i3, config);
    }
}
