package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.references.h;
/* loaded from: classes.dex */
public class SimpleBitmapReleaser implements h<Bitmap> {
    private static SimpleBitmapReleaser a;

    private SimpleBitmapReleaser() {
    }

    public static SimpleBitmapReleaser getInstance() {
        if (a == null) {
            a = new SimpleBitmapReleaser();
        }
        return a;
    }

    @Override // com.facebook.common.references.h
    /* renamed from: a */
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}
