package com.bumptech.glide.request;
/* compiled from: ThumbnailRequestCoordinator.java */
/* loaded from: classes.dex */
public class e implements b, a {
    private a a;
    private a b;
    private b c;

    public e(b bVar) {
        this.c = bVar;
    }

    private boolean h() {
        b bVar = this.c;
        return bVar == null || bVar.c(this);
    }

    private boolean i() {
        b bVar = this.c;
        return bVar == null || bVar.d(this);
    }

    private boolean j() {
        b bVar = this.c;
        return bVar != null && bVar.a();
    }

    @Override // com.bumptech.glide.request.b
    public boolean a() {
        return j() || b();
    }

    @Override // com.bumptech.glide.request.a
    public boolean b() {
        return this.a.b() || this.b.b();
    }

    @Override // com.bumptech.glide.request.b
    public boolean c(a aVar) {
        return h() && aVar.equals(this.a) && !a();
    }

    @Override // com.bumptech.glide.request.a
    public void clear() {
        this.b.clear();
        this.a.clear();
    }

    @Override // com.bumptech.glide.request.b
    public boolean d(a aVar) {
        return i() && (aVar.equals(this.a) || !this.a.b());
    }

    @Override // com.bumptech.glide.request.a
    public boolean e() {
        return this.a.e() || this.b.e();
    }

    @Override // com.bumptech.glide.request.a
    public void f() {
        if (!this.b.isRunning()) {
            this.b.f();
        }
        if (this.a.isRunning()) {
            return;
        }
        this.a.f();
    }

    @Override // com.bumptech.glide.request.b
    public void g(a aVar) {
        if (aVar.equals(this.b)) {
            return;
        }
        b bVar = this.c;
        if (bVar != null) {
            bVar.g(this);
        }
        if (this.b.e()) {
            return;
        }
        this.b.clear();
    }

    @Override // com.bumptech.glide.request.a
    public boolean isCancelled() {
        return this.a.isCancelled();
    }

    @Override // com.bumptech.glide.request.a
    public boolean isRunning() {
        return this.a.isRunning();
    }

    public void k(a aVar, a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    @Override // com.bumptech.glide.request.a
    public void pause() {
        this.a.pause();
        this.b.pause();
    }

    @Override // com.bumptech.glide.request.a
    public void recycle() {
        this.a.recycle();
        this.b.recycle();
    }
}
