package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.DecodeFormat;
import java.io.IOException;
/* compiled from: VideoBitmapDecoder.java */
/* loaded from: classes.dex */
public class l implements com.bumptech.glide.load.resource.bitmap.a<ParcelFileDescriptor> {
    private static final a c = new a();
    private a a;
    private int b;

    /* compiled from: VideoBitmapDecoder.java */
    /* loaded from: classes.dex */
    static class a {
        a() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    public l() {
        this(c, -1);
    }

    public Bitmap a(ParcelFileDescriptor parcelFileDescriptor, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, int i2, int i3, DecodeFormat decodeFormat) throws IOException {
        Bitmap frameAtTime;
        MediaMetadataRetriever a2 = this.a.a();
        a2.setDataSource(parcelFileDescriptor.getFileDescriptor());
        int i4 = this.b;
        if (i4 >= 0) {
            frameAtTime = a2.getFrameAtTime(i4);
        } else {
            frameAtTime = a2.getFrameAtTime();
        }
        a2.release();
        parcelFileDescriptor.close();
        return frameAtTime;
    }

    l(a aVar, int i2) {
        this.a = aVar;
        this.b = i2;
    }
}
