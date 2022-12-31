package com.ironsource.mediationsdk.p0;
/* compiled from: BannerReloadTimer.java */
/* loaded from: classes2.dex */
public class b extends com.ironsource.mediationsdk.p0.a<a> {

    /* compiled from: BannerReloadTimer.java */
    /* loaded from: classes2.dex */
    public interface a {
        void r();
    }

    public b(int i2) {
        super(i2 * 1000);
    }

    @Override // com.ironsource.mediationsdk.p0.a
    protected void b() {
        T t = this.c;
        if (t != 0) {
            ((a) t).r();
        }
    }

    public void e(a aVar) {
        c(aVar);
    }
}
