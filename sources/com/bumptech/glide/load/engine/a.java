package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.cache.a;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DecodeJob.java */
/* loaded from: classes.dex */
public class a<A, T, Z> {
    private static final b m = new b();
    private final e a;
    private final int b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bumptech.glide.load.g.c<A> f710d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bumptech.glide.j.b<A, T> f711e;

    /* renamed from: f  reason: collision with root package name */
    private final com.bumptech.glide.load.f<T> f712f;

    /* renamed from: g  reason: collision with root package name */
    private final com.bumptech.glide.load.resource.transcode.b<T, Z> f713g;

    /* renamed from: h  reason: collision with root package name */
    private final InterfaceC0027a f714h;

    /* renamed from: i  reason: collision with root package name */
    private final DiskCacheStrategy f715i;

    /* renamed from: j  reason: collision with root package name */
    private final Priority f716j;

    /* renamed from: k  reason: collision with root package name */
    private final b f717k;

    /* renamed from: l  reason: collision with root package name */
    private volatile boolean f718l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodeJob.java */
    /* renamed from: com.bumptech.glide.load.engine.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0027a {
        com.bumptech.glide.load.engine.cache.a a();
    }

    /* compiled from: DecodeJob.java */
    /* loaded from: classes.dex */
    static class b {
        b() {
        }

        public OutputStream a(File file) throws FileNotFoundException {
            return new BufferedOutputStream(new FileOutputStream(file));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes.dex */
    public class c<DataType> implements a.b {
        private final com.bumptech.glide.load.a<DataType> a;
        private final DataType b;

        public c(com.bumptech.glide.load.a<DataType> aVar, DataType datatype) {
            this.a = aVar;
            this.b = datatype;
        }

        @Override // com.bumptech.glide.load.engine.cache.a.b
        public boolean a(File file) {
            OutputStream outputStream = null;
            try {
                try {
                    outputStream = a.this.f717k.a(file);
                    boolean a = this.a.a(this.b, outputStream);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                            return a;
                        } catch (IOException unused) {
                            return a;
                        }
                    }
                    return a;
                } catch (FileNotFoundException e2) {
                    if (Log.isLoggable("DecodeJob", 3)) {
                        Log.d("DecodeJob", "Failed to find file to write to disk cache", e2);
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return false;
                }
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        }
    }

    public a(e eVar, int i2, int i3, com.bumptech.glide.load.g.c<A> cVar, com.bumptech.glide.j.b<A, T> bVar, com.bumptech.glide.load.f<T> fVar, com.bumptech.glide.load.resource.transcode.b<T, Z> bVar2, InterfaceC0027a interfaceC0027a, DiskCacheStrategy diskCacheStrategy, Priority priority) {
        this(eVar, i2, i3, cVar, bVar, fVar, bVar2, interfaceC0027a, diskCacheStrategy, priority, m);
    }

    private i<T> b(A a) throws IOException {
        long b2 = com.bumptech.glide.l.d.b();
        this.f714h.a().a(this.a.b(), new c(this.f711e.b(), a));
        if (Log.isLoggable("DecodeJob", 2)) {
            j("Wrote source to cache", b2);
        }
        long b3 = com.bumptech.glide.l.d.b();
        i<T> i2 = i(this.a.b());
        if (Log.isLoggable("DecodeJob", 2) && i2 != null) {
            j("Decoded source from cache", b3);
        }
        return i2;
    }

    private i<T> e(A a) throws IOException {
        if (this.f715i.cacheSource()) {
            return b(a);
        }
        long b2 = com.bumptech.glide.l.d.b();
        i<T> a2 = this.f711e.e().a(a, this.b, this.c);
        if (Log.isLoggable("DecodeJob", 2)) {
            j("Decoded from source", b2);
            return a2;
        }
        return a2;
    }

    private i<T> g() throws Exception {
        try {
            long b2 = com.bumptech.glide.l.d.b();
            A b3 = this.f710d.b(this.f716j);
            if (Log.isLoggable("DecodeJob", 2)) {
                j("Fetched data", b2);
            }
            if (this.f718l) {
                return null;
            }
            return e(b3);
        } finally {
            this.f710d.a();
        }
    }

    private i<T> i(com.bumptech.glide.load.b bVar) throws IOException {
        File b2 = this.f714h.a().b(bVar);
        if (b2 == null) {
            return null;
        }
        try {
            i<T> a = this.f711e.f().a(b2, this.b, this.c);
            if (a == null) {
            }
            return a;
        } finally {
            this.f714h.a().c(bVar);
        }
    }

    private void j(String str, long j2) {
        Log.v("DecodeJob", str + " in " + com.bumptech.glide.l.d.a(j2) + ", key: " + this.a);
    }

    private i<Z> k(i<T> iVar) {
        if (iVar == null) {
            return null;
        }
        return this.f713g.a(iVar);
    }

    private i<T> l(i<T> iVar) {
        if (iVar == null) {
            return null;
        }
        i<T> a = this.f712f.a(iVar, this.b, this.c);
        if (!iVar.equals(a)) {
            iVar.recycle();
        }
        return a;
    }

    private i<Z> m(i<T> iVar) {
        long b2 = com.bumptech.glide.l.d.b();
        i<T> l2 = l(iVar);
        if (Log.isLoggable("DecodeJob", 2)) {
            j("Transformed resource from source", b2);
        }
        n(l2);
        long b3 = com.bumptech.glide.l.d.b();
        i<Z> k2 = k(l2);
        if (Log.isLoggable("DecodeJob", 2)) {
            j("Transcoded transformed from source", b3);
        }
        return k2;
    }

    private void n(i<T> iVar) {
        if (iVar == null || !this.f715i.cacheResult()) {
            return;
        }
        long b2 = com.bumptech.glide.l.d.b();
        this.f714h.a().a(this.a, new c(this.f711e.d(), iVar));
        if (Log.isLoggable("DecodeJob", 2)) {
            j("Wrote transformed from source to cache", b2);
        }
    }

    public void c() {
        this.f718l = true;
        this.f710d.cancel();
    }

    public i<Z> d() throws Exception {
        return m(g());
    }

    public i<Z> f() throws Exception {
        if (this.f715i.cacheResult()) {
            long b2 = com.bumptech.glide.l.d.b();
            i<T> i2 = i(this.a);
            if (Log.isLoggable("DecodeJob", 2)) {
                j("Decoded transformed from cache", b2);
            }
            long b3 = com.bumptech.glide.l.d.b();
            i<Z> k2 = k(i2);
            if (Log.isLoggable("DecodeJob", 2)) {
                j("Transcoded transformed from cache", b3);
            }
            return k2;
        }
        return null;
    }

    public i<Z> h() throws Exception {
        if (this.f715i.cacheSource()) {
            long b2 = com.bumptech.glide.l.d.b();
            i<T> i2 = i(this.a.b());
            if (Log.isLoggable("DecodeJob", 2)) {
                j("Decoded source from cache", b2);
            }
            return m(i2);
        }
        return null;
    }

    a(e eVar, int i2, int i3, com.bumptech.glide.load.g.c<A> cVar, com.bumptech.glide.j.b<A, T> bVar, com.bumptech.glide.load.f<T> fVar, com.bumptech.glide.load.resource.transcode.b<T, Z> bVar2, InterfaceC0027a interfaceC0027a, DiskCacheStrategy diskCacheStrategy, Priority priority, b bVar3) {
        this.a = eVar;
        this.b = i2;
        this.c = i3;
        this.f710d = cVar;
        this.f711e = bVar;
        this.f712f = fVar;
        this.f713g = bVar2;
        this.f714h = interfaceC0027a;
        this.f715i = diskCacheStrategy;
        this.f716j = priority;
        this.f717k = bVar3;
    }
}
