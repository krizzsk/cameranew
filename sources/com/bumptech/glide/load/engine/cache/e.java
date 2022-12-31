package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.g.a;
import com.bumptech.glide.load.engine.cache.a;
import java.io.File;
import java.io.IOException;
/* compiled from: DiskLruCacheWrapper.java */
/* loaded from: classes.dex */
public class e implements a {

    /* renamed from: f  reason: collision with root package name */
    private static e f746f;
    private final c a = new c();
    private final h b = new h();
    private final File c;

    /* renamed from: d  reason: collision with root package name */
    private final int f747d;

    /* renamed from: e  reason: collision with root package name */
    private com.bumptech.glide.g.a f748e;

    protected e(File file, int i2) {
        this.c = file;
        this.f747d = i2;
    }

    public static synchronized a d(File file, int i2) {
        e eVar;
        synchronized (e.class) {
            if (f746f == null) {
                f746f = new e(file, i2);
            }
            eVar = f746f;
        }
        return eVar;
    }

    private synchronized com.bumptech.glide.g.a e() throws IOException {
        if (this.f748e == null) {
            this.f748e = com.bumptech.glide.g.a.N(this.c, 1, 1, this.f747d);
        }
        return this.f748e;
    }

    @Override // com.bumptech.glide.load.engine.cache.a
    public void a(com.bumptech.glide.load.b bVar, a.b bVar2) {
        String a = this.b.a(bVar);
        this.a.a(bVar);
        try {
            try {
                a.b x = e().x(a);
                if (x != null) {
                    try {
                        if (bVar2.a(x.f(0))) {
                            x.e();
                        }
                        x.b();
                    } catch (Throwable th) {
                        x.b();
                        throw th;
                    }
                }
            } catch (IOException e2) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e2);
                }
            }
        } finally {
            this.a.b(bVar);
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.a
    public File b(com.bumptech.glide.load.b bVar) {
        try {
            a.d z = e().z(this.b.a(bVar));
            if (z != null) {
                return z.a(0);
            }
            return null;
        } catch (IOException e2) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e2);
                return null;
            }
            return null;
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.a
    public void c(com.bumptech.glide.load.b bVar) {
        try {
            e().T(this.b.a(bVar));
        } catch (IOException e2) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", e2);
            }
        }
    }
}
