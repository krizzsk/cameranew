package com.pinguo.camera360.gallery.ui;

import android.os.ConditionVariable;
import com.pinguo.album.views.b;
import com.pinguo.camera360.gallery.RootActivity;
/* compiled from: PreparePageFadeoutTexture.java */
/* loaded from: classes3.dex */
public class w implements b.a {
    private com.pinguo.album.opengles.q a;
    private ConditionVariable b = new ConditionVariable(false);
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private com.pinguo.album.views.a f6687d;

    public w(com.pinguo.album.views.a aVar) {
        this.c = false;
        if (aVar == null) {
            this.c = true;
            return;
        }
        int p = aVar.p();
        int n = aVar.n();
        if (p != 0 && n != 0) {
            this.a = new com.pinguo.album.opengles.q(p, n, true);
            this.f6687d = aVar;
            return;
        }
        this.c = true;
    }

    public static void e(RootActivity rootActivity, com.pinguo.album.views.a aVar) {
        w wVar = new w(aVar);
        if (wVar.d()) {
            return;
        }
        com.pinguo.album.views.b E = rootActivity.E();
        E.g();
        try {
            E.f();
            E.j(wVar);
            com.pinguo.album.opengles.q c = wVar.c();
            if (c == null) {
                return;
            }
            rootActivity.H0().d("fade_texture", c);
        } finally {
            E.c();
        }
    }

    @Override // com.pinguo.album.views.b.a
    public void a() {
        synchronized (this) {
            this.c = true;
        }
    }

    @Override // com.pinguo.album.views.b.a
    public boolean b(com.pinguo.album.opengles.l lVar, boolean z) {
        if (!this.c) {
            try {
                lVar.q(this.a);
                this.f6687d.y(lVar);
                lVar.w();
            } catch (RuntimeException unused) {
                this.a = null;
            }
        } else {
            this.a = null;
        }
        this.b.open();
        return false;
    }

    public synchronized com.pinguo.album.opengles.q c() {
        if (this.c) {
            return null;
        }
        if (this.b.block(200L)) {
            return this.a;
        }
        this.c = true;
        return null;
    }

    public boolean d() {
        return this.c;
    }
}
