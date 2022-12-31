package com.pinguo.album;

import android.content.Context;
import com.pinguo.camera360.gallery.data.LocalBlobCacheService;
import us.pinguo.librouter.application.BaseApplication;
/* compiled from: PGAlbumAppManager.java */
/* loaded from: classes3.dex */
public class e {
    private static e c = new e();
    private LocalBlobCacheService a;
    private a b;

    private e() {
    }

    public static e e() {
        return c;
    }

    public a a() {
        if (this.b == null) {
            this.b = new a();
        }
        return this.b;
    }

    public Context b() {
        return BaseApplication.d();
    }

    public synchronized LocalBlobCacheService c() {
        if (this.a == null) {
            this.a = new LocalBlobCacheService(BaseApplication.d());
        }
        return this.a;
    }

    public synchronized void d() {
        this.a = null;
        this.b = null;
    }
}
