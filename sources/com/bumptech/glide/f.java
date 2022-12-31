package com.bumptech.glide;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.model.k;
import com.bumptech.glide.manager.c;
import com.bumptech.glide.manager.g;
import com.bumptech.glide.manager.h;
import com.bumptech.glide.manager.l;
/* compiled from: RequestManager.java */
/* loaded from: classes.dex */
public class f implements h {
    private final Context a;
    private final g b;
    private final l c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bumptech.glide.e f633d;

    /* renamed from: e  reason: collision with root package name */
    private final d f634e;

    /* renamed from: f  reason: collision with root package name */
    private b f635f;

    /* compiled from: RequestManager.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        final /* synthetic */ g a;

        a(g gVar) {
            this.a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(f.this);
        }
    }

    /* compiled from: RequestManager.java */
    /* loaded from: classes.dex */
    public interface b {
        <T> void a(com.bumptech.glide.c<T, ?, ?, ?> cVar);
    }

    /* compiled from: RequestManager.java */
    /* loaded from: classes.dex */
    public final class c<A, T> {
        private final k<A, T> a;
        private final Class<T> b;

        /* JADX WARN: Field signature parse error: a
        jadx.core.utils.exceptions.JadxRuntimeException: Can't parse type: TA at position 1 ('A'), unexpected: T
        	at jadx.core.dex.nodes.parser.SignatureParser.consumeType(SignatureParser.java:169)
        	at jadx.core.dex.visitors.SignatureProcessor.parseFieldSignature(SignatureProcessor.java:83)
        	at jadx.core.dex.visitors.SignatureProcessor.visit(SignatureProcessor.java:33)
         */
        /* compiled from: RequestManager.java */
        /* loaded from: classes.dex */
        public final class a {
            private final Object a;
            private final Class<A> b;
            private final boolean c = true;

            a(A a) {
                this.a = a;
                this.b = f.p(a);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public <Z> com.bumptech.glide.d<A, T, Z> a(Class<Z> cls) {
                d dVar = f.this.f634e;
                com.bumptech.glide.d dVar2 = new com.bumptech.glide.d(f.this.a, f.this.f633d, this.b, c.this.a, c.this.b, cls, f.this.c, f.this.b, f.this.f634e);
                dVar.a(dVar2);
                com.bumptech.glide.d<A, T, Z> dVar3 = (com.bumptech.glide.d<A, T, Z>) dVar2;
                if (this.c) {
                    dVar3.m(this.a);
                }
                return dVar3;
            }
        }

        c(k<A, T> kVar, Class<T> cls) {
            this.a = kVar;
            this.b = cls;
        }

        public c<A, T>.a c(A a2) {
            return new a(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestManager.java */
    /* loaded from: classes.dex */
    public class d {
        d() {
        }

        public <A, X extends com.bumptech.glide.c<A, ?, ?, ?>> X a(X x) {
            if (f.this.f635f != null) {
                f.this.f635f.a(x);
            }
            return x;
        }
    }

    /* compiled from: RequestManager.java */
    /* loaded from: classes.dex */
    private static class e implements c.a {
        private final l a;

        public e(l lVar) {
            this.a = lVar;
        }

        @Override // com.bumptech.glide.manager.c.a
        public void a(boolean z) {
            if (z) {
                this.a.d();
            }
        }
    }

    public f(Context context, g gVar, com.bumptech.glide.manager.k kVar) {
        this(context, gVar, kVar, new l(), new com.bumptech.glide.manager.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> Class<T> p(T t) {
        if (t != null) {
            return (Class<T>) t.getClass();
        }
        return null;
    }

    private <T> com.bumptech.glide.b<T> r(Class<T> cls) {
        k e2 = com.bumptech.glide.e.e(cls, this.a);
        k b2 = com.bumptech.glide.e.b(cls, this.a);
        if (cls != null && e2 == null && b2 == null) {
            throw new IllegalArgumentException("Unknown type " + cls + ". You must provide a Model of a type for which there is a registered ModelLoader, if you are using a custom model, you must first call Glide#register with a ModelLoaderFactory for your custom model class");
        }
        d dVar = this.f634e;
        com.bumptech.glide.b<T> bVar = new com.bumptech.glide.b<>(cls, e2, b2, this.a, this.f633d, this.c, this.b, dVar);
        dVar.a(bVar);
        return bVar;
    }

    public com.bumptech.glide.b<String> o() {
        return r(String.class);
    }

    @Override // com.bumptech.glide.manager.h
    public void onDestroy() {
        this.c.a();
    }

    @Override // com.bumptech.glide.manager.h
    public void onStart() {
        v();
    }

    @Override // com.bumptech.glide.manager.h
    public void onStop() {
        u();
    }

    public com.bumptech.glide.b<String> q(String str) {
        com.bumptech.glide.b<String> o = o();
        o.A(str);
        return o;
    }

    public void s() {
        this.f633d.h();
    }

    public void t(int i2) {
        this.f633d.p(i2);
    }

    public void u() {
        com.bumptech.glide.l.h.a();
        this.c.b();
    }

    public void v() {
        com.bumptech.glide.l.h.a();
        this.c.e();
    }

    public <A, T> c<A, T> w(k<A, T> kVar, Class<T> cls) {
        return new c<>(kVar, cls);
    }

    f(Context context, g gVar, com.bumptech.glide.manager.k kVar, l lVar, com.bumptech.glide.manager.d dVar) {
        this.a = context.getApplicationContext();
        this.b = gVar;
        this.c = lVar;
        this.f633d = com.bumptech.glide.e.i(context);
        this.f634e = new d();
        com.bumptech.glide.manager.c a2 = dVar.a(context, new e(lVar));
        if (com.bumptech.glide.l.h.h()) {
            new Handler(Looper.getMainLooper()).post(new a(gVar));
        } else {
            gVar.a(this);
        }
        gVar.a(a2);
    }
}
