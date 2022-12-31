package com.ironsource.mediationsdk.p0;
/* compiled from: SmashTimeoutTimer.java */
/* loaded from: classes2.dex */
public class c extends com.ironsource.mediationsdk.p0.a<a> {

    /* compiled from: SmashTimeoutTimer.java */
    /* loaded from: classes2.dex */
    public interface a {
        void onTimeout();
    }

    public c(long j2) {
        super(j2);
    }

    @Override // com.ironsource.mediationsdk.p0.a
    protected void b() {
        T t = this.c;
        if (t != 0) {
            ((a) t).onTimeout();
        }
    }

    public void e(a aVar) {
        c(aVar);
    }

    public void f() {
        d();
    }
}
