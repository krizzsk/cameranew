package com.bumptech.glide.load.resource.transcode;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.i;
/* loaded from: classes.dex */
public class BitmapToGlideDrawableTranscoder implements b<Bitmap, com.bumptech.glide.load.h.e.b> {
    private final GlideBitmapDrawableTranscoder a;

    public BitmapToGlideDrawableTranscoder(Context context) {
        this(new GlideBitmapDrawableTranscoder(context));
    }

    @Override // com.bumptech.glide.load.resource.transcode.b
    public i<com.bumptech.glide.load.h.e.b> a(i<Bitmap> iVar) {
        return this.a.a(iVar);
    }

    @Override // com.bumptech.glide.load.resource.transcode.b
    public String getId() {
        return this.a.getId();
    }

    public BitmapToGlideDrawableTranscoder(GlideBitmapDrawableTranscoder glideBitmapDrawableTranscoder) {
        this.a = glideBitmapDrawableTranscoder;
    }
}
