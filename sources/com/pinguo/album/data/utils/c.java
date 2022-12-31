package com.pinguo.album.data.utils;

import android.graphics.Bitmap;
/* compiled from: BitmapLoader.java */
/* loaded from: classes3.dex */
public abstract class c implements com.pinguo.album.d<Bitmap> {
    private int a = 0;
    private com.pinguo.album.c<Bitmap> b;
    private Bitmap c;

    @Override // com.pinguo.album.d
    public void b(com.pinguo.album.c<Bitmap> cVar) {
        synchronized (this) {
            this.b = null;
            Bitmap bitmap = cVar.get();
            this.c = bitmap;
            if (this.a == 4) {
                if (bitmap != null) {
                    h(bitmap);
                    this.c = null;
                }
            } else if (cVar.isCancelled() && this.c == null) {
                if (this.a == 1) {
                    this.b = j(this);
                }
            } else {
                Bitmap bitmap2 = this.c;
                this.a = bitmap2 == null ? 3 : 2;
                f(bitmap2);
            }
        }
    }

    public synchronized void c() {
        if (this.a == 1) {
            this.a = 0;
            com.pinguo.album.c<Bitmap> cVar = this.b;
            if (cVar != null) {
                cVar.cancel();
            }
        }
    }

    public synchronized Bitmap d() {
        return this.c;
    }

    public synchronized boolean e() {
        return this.a == 1;
    }

    protected abstract void f(Bitmap bitmap);

    public synchronized void g() {
        this.a = 4;
        Bitmap bitmap = this.c;
        if (bitmap != null) {
            h(bitmap);
            this.c = null;
        }
        com.pinguo.album.c<Bitmap> cVar = this.b;
        if (cVar != null) {
            cVar.cancel();
        }
    }

    protected void h(Bitmap bitmap) {
        PGAlbumBitmapPool.getInstance().e(bitmap);
    }

    public synchronized void i() {
        if (this.a == 0) {
            this.a = 1;
            if (this.b == null) {
                this.b = j(this);
            }
        }
    }

    protected abstract com.pinguo.album.c<Bitmap> j(com.pinguo.album.d<Bitmap> dVar);
}
