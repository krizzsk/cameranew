package com.bumptech.glide.load.resource.transcode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.bumptech.glide.e;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.resource.bitmap.f;
import com.bumptech.glide.load.resource.bitmap.g;
/* loaded from: classes.dex */
public class GlideBitmapDrawableTranscoder implements b<Bitmap, f> {
    private final Resources a;
    private final com.bumptech.glide.load.engine.bitmap_recycle.c b;

    public GlideBitmapDrawableTranscoder(Context context) {
        this(context.getResources(), e.i(context).j());
    }

    @Override // com.bumptech.glide.load.resource.transcode.b
    public i<f> a(i<Bitmap> iVar) {
        return new g(new f(this.a, iVar.get()), this.b);
    }

    @Override // com.bumptech.glide.load.resource.transcode.b
    public String getId() {
        return "GlideBitmapDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }

    public GlideBitmapDrawableTranscoder(Resources resources, com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        this.a = resources;
        this.b = cVar;
    }
}
