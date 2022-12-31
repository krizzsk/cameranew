package com.pinguo.camera360.gallery.ui;

import android.content.Context;
import android.graphics.Rect;
import com.pinguo.album.animations.b;
import com.pinguo.camera360.gallery.util.ScrollerHelper;
import us.pinguo.foundation.utils.n0;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class AlbumScrollerIcon extends com.pinguo.album.views.a implements b.a {

    /* renamed from: l  reason: collision with root package name */
    private final com.pinguo.album.opengles.u f6455l;
    private final ScrollerHelper m;
    private Rect n;
    private com.pinguo.album.opengles.t q;
    private final com.pinguo.album.opengles.p r;
    private final int s;
    private int t;
    private final int v;
    private com.pinguo.album.animations.i o = null;
    private com.pinguo.album.animations.i p = null;
    private boolean u = false;

    public AlbumScrollerIcon(Context context) {
        this.m = new ScrollerHelper(context);
        this.f6455l = new com.pinguo.album.opengles.r(context, R.drawable.album_scroll_icon);
        D(4);
        this.s = context.getResources().getDimensionPixelSize(R.dimen.album_scroller_textsize);
        this.v = context.getResources().getDimensionPixelSize(R.dimen.album_scroller_tip_trans_dis);
        this.r = new com.pinguo.album.opengles.p(context, R.drawable.scroller_black);
        this.t = n0.c(6);
    }

    private boolean L(com.pinguo.album.opengles.l lVar) {
        if (!this.u || this.q == null) {
            return false;
        }
        lVar.s(3);
        long a = com.pinguo.album.animations.c.a();
        com.pinguo.album.animations.i iVar = this.p;
        boolean b = iVar != null ? iVar.b(a) : false;
        int e2 = this.m.e();
        Rect e3 = e();
        if (this.u) {
            int width = (e3.left - this.q.getWidth()) - this.t;
            int n = (-e2) + ((n() - this.q.getHeight()) >> 1) + this.n.top;
            int width2 = this.q.getWidth();
            int height = this.q.getHeight();
            com.pinguo.album.animations.i iVar2 = this.p;
            if (iVar2 != null) {
                iVar2.m(lVar, 0, e3);
            }
            com.pinguo.album.opengles.p pVar = this.r;
            int i2 = this.t;
            pVar.a(lVar, width - i2, n - i2, (i2 * 2) + width2, height + (i2 * 2));
            this.q.a(lVar, width, n, width2, height);
        }
        lVar.b();
        return b;
    }

    @Override // com.pinguo.album.views.a
    public void D(int i2) {
        super.D(i2);
        if (i2 == 0) {
            com.pinguo.album.animations.i iVar = this.o;
            if (iVar != null && iVar.d()) {
                this.o.c();
            }
            this.o = null;
        }
    }

    public int F() {
        return (int) (this.f6455l.getHeight() * 0.75d);
    }

    public int G() {
        return (int) (this.f6455l.getWidth() * 0.75d);
    }

    public int H() {
        return this.m.e();
    }

    public void I() {
        com.pinguo.album.animations.i iVar = new com.pinguo.album.animations.i(G(), 1);
        this.o = iVar;
        iVar.i(500);
        this.o.h(this);
        this.o.l();
        com.pinguo.album.animations.i iVar2 = this.p;
        if (iVar2 != null && this.u && this.q != null) {
            iVar2.i(500);
            this.p.o(G() + this.q.getWidth() + (this.t * 3));
            this.p.n(1);
            this.p.l();
        }
        q();
    }

    public void J() {
        if (this.u) {
            this.u = false;
            q();
        }
    }

    public void K(float f2, int i2) {
        this.m.h(Math.round(f2), -i2, 0);
        this.m.a(0L);
    }

    public void M() {
        com.pinguo.album.animations.i iVar = this.p;
        if (iVar == null) {
            return;
        }
        iVar.o(this.v);
        this.p.n(2);
        this.p.i(200);
        this.p.l();
        q();
    }

    public void N(int i2) {
        this.m.g(-i2);
    }

    public void O(String str) {
        com.pinguo.album.opengles.t tVar = this.q;
        if (tVar != null) {
            tVar.o();
        }
        this.q = com.pinguo.album.opengles.t.L(str, this.s, -1, false);
        q();
    }

    public void P() {
        if (this.p == null) {
            this.p = new com.pinguo.album.animations.i();
        }
        this.p.o(this.v);
        this.p.i(200);
        this.p.n(1);
        this.p.l();
        q();
        this.u = true;
    }

    @Override // com.pinguo.album.animations.b.a
    public void a() {
        this.o.c();
        D(4);
        this.u = false;
    }

    @Override // com.pinguo.album.animations.b.a
    public void b() {
    }

    @Override // com.pinguo.album.views.a
    public Rect e() {
        int e2 = this.m.e();
        Rect rect = this.n;
        return new Rect(rect.left, rect.top - e2, rect.right, rect.bottom - e2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.album.views.a
    public void v(boolean z, int i2, int i3, int i4, int i5) {
        super.v(z, i2, i3, i4, i5);
        us.pinguo.common.log.a.k("AlbumScrollerIcon onLayout left = " + i2 + " top = " + i3 + " right = " + i4 + " bottom = " + i5, new Object[0]);
        if (this.n == null) {
            Rect e2 = super.e();
            this.n = new Rect(e2.left, e2.top, e2.right, e2.bottom);
        }
    }

    @Override // com.pinguo.album.views.a
    public void y(com.pinguo.album.opengles.l lVar) {
        super.y(lVar);
        if (o() != 0) {
            return;
        }
        lVar.s(3);
        long a = com.pinguo.album.animations.c.a();
        com.pinguo.album.animations.i iVar = this.o;
        boolean b = iVar != null ? iVar.b(a) : false;
        int e2 = this.m.e();
        this.m.g(e2);
        Rect e3 = e();
        com.pinguo.album.animations.i iVar2 = this.o;
        if (iVar2 != null) {
            iVar2.m(lVar, 0, e3);
        }
        this.f6455l.a(lVar, e3.left, (-e2) + this.n.top, p(), n());
        lVar.b();
        boolean L = L(lVar);
        if (b || L) {
            q();
        }
    }
}
