package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.b;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.f;
import com.bumptech.glide.request.g.h;
import com.bumptech.glide.request.g.j;
import java.util.Queue;
/* loaded from: classes.dex */
public final class GenericRequest<A, T, Z, R> implements a, h, d {
    private static final Queue<GenericRequest<?, ?, ?, ?>> D = com.bumptech.glide.l.h.c(0);
    private b.c A;
    private long B;
    private Status C;
    private final String a = String.valueOf(hashCode());
    private com.bumptech.glide.load.b b;
    private Drawable c;

    /* renamed from: d  reason: collision with root package name */
    private int f823d;

    /* renamed from: e  reason: collision with root package name */
    private int f824e;

    /* renamed from: f  reason: collision with root package name */
    private int f825f;

    /* renamed from: g  reason: collision with root package name */
    private Context f826g;

    /* renamed from: h  reason: collision with root package name */
    private f<Z> f827h;

    /* renamed from: i  reason: collision with root package name */
    private com.bumptech.glide.j.f<A, T, Z, R> f828i;

    /* renamed from: j  reason: collision with root package name */
    private b f829j;

    /* renamed from: k  reason: collision with root package name */
    private A f830k;

    /* renamed from: l  reason: collision with root package name */
    private Class<R> f831l;
    private boolean m;
    private Priority n;
    private j<R> o;
    private c<? super A, R> p;
    private float q;
    private com.bumptech.glide.load.engine.b r;
    private com.bumptech.glide.request.f.d<R> s;
    private int t;
    private int u;
    private DiskCacheStrategy v;
    private Drawable w;
    private Drawable x;
    private boolean y;
    private i<?> z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CANCELLED,
        CLEARED,
        PAUSED
    }

    private GenericRequest() {
    }

    private boolean g() {
        b bVar = this.f829j;
        return bVar == null || bVar.c(this);
    }

    private boolean h() {
        b bVar = this.f829j;
        return bVar == null || bVar.d(this);
    }

    private static void j(String str, Object obj, String str2) {
        if (obj == null) {
            StringBuilder sb = new StringBuilder(str);
            sb.append(" must not be null");
            if (str2 != null) {
                sb.append(", ");
                sb.append(str2);
            }
            throw new NullPointerException(sb.toString());
        }
    }

    private Drawable k() {
        if (this.x == null && this.f825f > 0) {
            this.x = this.f826g.getResources().getDrawable(this.f825f);
        }
        return this.x;
    }

    private Drawable l() {
        if (this.c == null && this.f823d > 0) {
            this.c = this.f826g.getResources().getDrawable(this.f823d);
        }
        return this.c;
    }

    private Drawable m() {
        if (this.w == null && this.f824e > 0) {
            this.w = this.f826g.getResources().getDrawable(this.f824e);
        }
        return this.w;
    }

    private void n(com.bumptech.glide.j.f<A, T, Z, R> fVar, A a, com.bumptech.glide.load.b bVar, Context context, Priority priority, j<R> jVar, float f2, Drawable drawable, int i2, Drawable drawable2, int i3, Drawable drawable3, int i4, c<? super A, R> cVar, b bVar2, com.bumptech.glide.load.engine.b bVar3, f<Z> fVar2, Class<R> cls, boolean z, com.bumptech.glide.request.f.d<R> dVar, int i5, int i6, DiskCacheStrategy diskCacheStrategy) {
        this.f828i = fVar;
        this.f830k = a;
        this.b = bVar;
        this.c = drawable3;
        this.f823d = i4;
        this.f826g = context.getApplicationContext();
        this.n = priority;
        this.o = jVar;
        this.q = f2;
        this.w = drawable;
        this.f824e = i2;
        this.x = drawable2;
        this.f825f = i3;
        this.p = cVar;
        this.f829j = bVar2;
        this.r = bVar3;
        this.f827h = fVar2;
        this.f831l = cls;
        this.m = z;
        this.s = dVar;
        this.t = i5;
        this.u = i6;
        this.v = diskCacheStrategy;
        this.C = Status.PENDING;
        if (a != null) {
            j("ModelLoader", fVar.g(), "try .using(ModelLoader)");
            j("Transcoder", fVar.c(), "try .as*(Class).transcode(ResourceTranscoder)");
            j("Transformation", fVar2, "try .transform(UnitTransformation.get())");
            if (diskCacheStrategy.cacheSource()) {
                j("SourceEncoder", fVar.b(), "try .sourceEncoder(Encoder) or .diskCacheStrategy(NONE/RESULT)");
            } else {
                j("SourceDecoder", fVar.e(), "try .decoder/.imageDecoder/.videoDecoder(ResourceDecoder) or .diskCacheStrategy(ALL/SOURCE)");
            }
            if (diskCacheStrategy.cacheSource() || diskCacheStrategy.cacheResult()) {
                j("CacheDecoder", fVar.f(), "try .cacheDecoder(ResouceDecoder) or .diskCacheStrategy(NONE)");
            }
            if (diskCacheStrategy.cacheResult()) {
                j("Encoder", fVar.d(), "try .encode(ResourceEncoder) or .diskCacheStrategy(NONE/SOURCE)");
            }
        }
    }

    private boolean p() {
        b bVar = this.f829j;
        return bVar == null || !bVar.a();
    }

    private void q(String str) {
        Log.v("GenericRequest", str + " this: " + this.a);
    }

    private void r() {
        b bVar = this.f829j;
        if (bVar != null) {
            bVar.g(this);
        }
    }

    public static <A, T, Z, R> GenericRequest<A, T, Z, R> s(com.bumptech.glide.j.f<A, T, Z, R> fVar, A a, com.bumptech.glide.load.b bVar, Context context, Priority priority, j<R> jVar, float f2, Drawable drawable, int i2, Drawable drawable2, int i3, Drawable drawable3, int i4, c<? super A, R> cVar, b bVar2, com.bumptech.glide.load.engine.b bVar3, f<Z> fVar2, Class<R> cls, boolean z, com.bumptech.glide.request.f.d<R> dVar, int i5, int i6, DiskCacheStrategy diskCacheStrategy) {
        GenericRequest<?, ?, ?, ?> poll = D.poll();
        if (poll == null) {
            poll = new GenericRequest();
        }
        poll.n(fVar, a, bVar, context, priority, jVar, f2, drawable, i2, drawable2, i3, drawable3, i4, cVar, bVar2, bVar3, fVar2, cls, z, dVar, i5, i6, diskCacheStrategy);
        return poll;
    }

    private void t(i<?> iVar, R r) {
        boolean p = p();
        this.C = Status.COMPLETE;
        this.z = iVar;
        c<? super A, R> cVar = this.p;
        if (cVar == null || !cVar.b(r, (A) this.f830k, this.o, this.y, p)) {
            this.o.b(r, this.s.a(this.y, p));
        }
        r();
        if (Log.isLoggable("GenericRequest", 2)) {
            q("Resource ready in " + com.bumptech.glide.l.d.a(this.B) + " size: " + (iVar.getSize() * 9.5367431640625E-7d) + " fromCache: " + this.y);
        }
    }

    private void u(i iVar) {
        this.r.k(iVar);
        this.z = null;
    }

    private void v(Exception exc) {
        if (g()) {
            Drawable l2 = this.f830k == null ? l() : null;
            if (l2 == null) {
                l2 = k();
            }
            if (l2 == null) {
                l2 = m();
            }
            this.o.h(exc, l2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.d
    public void a(i<?> iVar) {
        if (iVar == null) {
            onException(new Exception("Expected to receive a Resource<R> with an object of " + this.f831l + " inside, but instead got null."));
            return;
        }
        Object obj = iVar.get();
        if (obj != null && this.f831l.isAssignableFrom(obj.getClass())) {
            if (!h()) {
                u(iVar);
                this.C = Status.COMPLETE;
                return;
            }
            t(iVar, obj);
            return;
        }
        u(iVar);
        StringBuilder sb = new StringBuilder();
        sb.append("Expected to receive an object of ");
        sb.append(this.f831l);
        sb.append(" but instead got ");
        sb.append(obj != null ? obj.getClass() : "");
        sb.append("{");
        sb.append(obj);
        sb.append("}");
        sb.append(" inside Resource{");
        sb.append(iVar);
        sb.append("}.");
        sb.append(obj == null ? " To indicate failure return a null Resource object, rather than a Resource object containing null data." : "");
        onException(new Exception(sb.toString()));
    }

    @Override // com.bumptech.glide.request.a
    public boolean b() {
        return e();
    }

    @Override // com.bumptech.glide.request.g.h
    public void c(int i2, int i3) {
        if (Log.isLoggable("GenericRequest", 2)) {
            q("Got onSizeReady in " + com.bumptech.glide.l.d.a(this.B));
        }
        if (this.C != Status.WAITING_FOR_SIZE) {
            return;
        }
        this.C = Status.RUNNING;
        int round = Math.round(this.q * i2);
        int round2 = Math.round(this.q * i3);
        com.bumptech.glide.load.g.c<T> a = this.f828i.g().a(this.f830k, round, round2);
        if (a == null) {
            onException(new Exception("Failed to load model: '" + this.f830k + "'"));
            return;
        }
        com.bumptech.glide.load.resource.transcode.b<Z, R> c = this.f828i.c();
        if (Log.isLoggable("GenericRequest", 2)) {
            q("finished setup for calling load in " + com.bumptech.glide.l.d.a(this.B));
        }
        this.y = true;
        this.A = this.r.g(this.b, round, round2, a, this.f828i, this.f827h, c, this.n, this.m, this.v, this);
        this.y = this.z != null;
        if (Log.isLoggable("GenericRequest", 2)) {
            q("finished onSizeReady in " + com.bumptech.glide.l.d.a(this.B));
        }
    }

    @Override // com.bumptech.glide.request.a
    public void clear() {
        com.bumptech.glide.l.h.a();
        Status status = this.C;
        Status status2 = Status.CLEARED;
        if (status == status2) {
            return;
        }
        i();
        i<?> iVar = this.z;
        if (iVar != null) {
            u(iVar);
        }
        if (g()) {
            this.o.f(m());
        }
        this.C = status2;
    }

    @Override // com.bumptech.glide.request.a
    public boolean e() {
        return this.C == Status.COMPLETE;
    }

    @Override // com.bumptech.glide.request.a
    public void f() {
        this.B = com.bumptech.glide.l.d.b();
        if (this.f830k == null) {
            onException(null);
            return;
        }
        this.C = Status.WAITING_FOR_SIZE;
        if (com.bumptech.glide.l.h.k(this.t, this.u)) {
            c(this.t, this.u);
        } else {
            this.o.i(this);
        }
        if (!e() && !o() && g()) {
            this.o.d(m());
        }
        if (Log.isLoggable("GenericRequest", 2)) {
            q("finished run method in " + com.bumptech.glide.l.d.a(this.B));
        }
    }

    void i() {
        this.C = Status.CANCELLED;
        b.c cVar = this.A;
        if (cVar != null) {
            cVar.a();
            this.A = null;
        }
    }

    @Override // com.bumptech.glide.request.a
    public boolean isCancelled() {
        Status status = this.C;
        return status == Status.CANCELLED || status == Status.CLEARED;
    }

    @Override // com.bumptech.glide.request.a
    public boolean isRunning() {
        Status status = this.C;
        return status == Status.RUNNING || status == Status.WAITING_FOR_SIZE;
    }

    public boolean o() {
        return this.C == Status.FAILED;
    }

    @Override // com.bumptech.glide.request.d
    public void onException(Exception exc) {
        if (Log.isLoggable("GenericRequest", 3)) {
            Log.d("GenericRequest", "load failed", exc);
        }
        this.C = Status.FAILED;
        c<? super A, R> cVar = this.p;
        if (cVar == null || !cVar.a(exc, (A) this.f830k, this.o, p())) {
            v(exc);
        }
    }

    @Override // com.bumptech.glide.request.a
    public void pause() {
        clear();
        this.C = Status.PAUSED;
    }

    @Override // com.bumptech.glide.request.a
    public void recycle() {
        this.f828i = null;
        this.f830k = null;
        this.f826g = null;
        this.o = null;
        this.w = null;
        this.x = null;
        this.c = null;
        this.p = null;
        this.f829j = null;
        this.f827h = null;
        this.s = null;
        this.y = false;
        this.A = null;
        D.offer(this);
    }
}
