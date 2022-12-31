package com.hw.photomovie.b;

import android.graphics.Bitmap;
/* compiled from: PhotoData.java */
/* loaded from: classes2.dex */
public abstract class b {
    public static final int STATE_BITMAP = 4;
    public static final int STATE_DOWNLOADING = 1;
    public static final int STATE_ERROR = -1;
    public static final int STATE_LOADING = 3;
    public static final int STATE_LOCAL = 2;
    public static final int STATE_REMOTE = 0;
    protected volatile Bitmap mBitmap;
    protected String mLocalUri;
    private c mPhotoInfo;
    protected int mState;
    protected int mTargetState;
    protected String mUri;

    /* compiled from: PhotoData.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a(b bVar);

        void b(b bVar, Bitmap bitmap);

        void c(b bVar, com.hw.photomovie.b.a aVar);

        void d(b bVar, int i2, int i3);
    }

    /* compiled from: PhotoData.java */
    /* renamed from: com.hw.photomovie.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0199b implements a {
        @Override // com.hw.photomovie.b.b.a
        public void a(b bVar) {
        }

        @Override // com.hw.photomovie.b.b.a
        public void d(b bVar, int i2, int i3) {
        }
    }

    public b(String str, int i2) {
        this(str, i2, null);
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Bitmap getBitmapAndRelease() {
        Bitmap bitmap = this.mBitmap;
        this.mBitmap = null;
        return bitmap;
    }

    public c getPhotoInfo() {
        return this.mPhotoInfo;
    }

    public int getState() {
        return this.mState;
    }

    public int getTargetState() {
        return this.mTargetState;
    }

    public String getUri() {
        return this.mUri;
    }

    public boolean isLocal() {
        int i2 = this.mState;
        return i2 == 2 || i2 == 3 || i2 == 4;
    }

    public abstract void prepareData(int i2, a aVar);

    public void setBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            this.mBitmap = bitmap;
        }
    }

    public void setPhotoInfo(c cVar) {
    }

    public b(String str, int i2, c cVar) {
        this.mUri = str;
        this.mState = i2;
    }
}
