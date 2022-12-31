package com.pinguo.camera360.gallery.ui;

import android.app.Activity;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import us.pinguo.foundation.utils.n0;
/* compiled from: AlbumCoverImageView.java */
/* loaded from: classes3.dex */
public class d extends com.pinguo.album.views.a {

    /* renamed from: l  reason: collision with root package name */
    private com.pinguo.album.opengles.c f6522l;
    private com.pinguo.album.opengles.c m;
    private GestureDetector n;
    private float o;
    private p s;
    private int v;
    private float p = 0.0f;
    private com.pinguo.album.animations.i q = null;
    private com.pinguo.album.animations.a r = null;
    private int t = 3;
    private int u = 0;

    /* compiled from: AlbumCoverImageView.java */
    /* loaded from: classes3.dex */
    class a implements GestureDetector.OnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (d.this.s != null) {
                int x = (int) motionEvent2.getX();
                int y = ((int) motionEvent2.getY()) - ((int) motionEvent.getY());
                int abs = Math.abs(y);
                int x2 = x - ((int) motionEvent.getX());
                if (abs > Math.abs(x2)) {
                    d.this.t = y > 0 ? 3 : 4;
                    d.this.s.o(d.this.t);
                } else if (x2 < 0) {
                    d.this.s.o(2);
                } else {
                    d.this.s.o(1);
                }
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return true;
        }
    }

    public d(Activity activity, com.pinguo.album.opengles.c cVar, float f2, int i2) {
        this.o = 0.0f;
        this.v = 0;
        this.f6522l = cVar;
        this.o = f2;
        this.v = i2;
        this.n = new GestureDetector(activity, new a());
    }

    private void M(com.pinguo.album.opengles.l lVar) {
        int width;
        int height;
        if (this.f6522l == null) {
            return;
        }
        lVar.s(3);
        long a2 = com.pinguo.album.animations.c.a();
        com.pinguo.album.animations.a aVar = this.r;
        boolean b = aVar != null ? aVar.b(a2) : false;
        float f2 = this.o;
        Rect e2 = e();
        com.pinguo.album.animations.a aVar2 = this.r;
        if (aVar2 != null) {
            if (aVar2.d()) {
                this.r.m(lVar, 0, e2);
                f2 = this.o - ((f2 / 2.0f) * this.r.n());
            } else {
                lVar.setAlpha(1.0f - this.r.n());
            }
        }
        int L = L();
        int K = K();
        int i2 = this.v;
        if (i2 != 90 && i2 != 270) {
            height = ((int) (e2.width() - (L * f2))) / 2;
            width = ((int) (e2.height() - (K * f2))) / 2;
        } else {
            int width2 = e2.width() / 2;
            int height2 = e2.height() / 2;
            lVar.a(width2, height2);
            lVar.v(this.v, 0.0f, 0.0f, 1.0f);
            lVar.a(-height2, -width2);
            L = K();
            K = L();
            width = ((int) (e2.width() - (L * f2))) / 2;
            height = ((int) (e2.height() - (K * f2))) / 2;
        }
        us.pinguo.common.log.a.k("renderCurrentItem mNextTextureRotation 222= " + this.u + " width = " + L + " height = " + K, new Object[0]);
        us.pinguo.common.log.a.k("renderCurrentItem x = " + height + " y = " + width + " newScale = " + f2 + "rect.width() = " + e2.width() + " height = " + e2.height(), new Object[0]);
        lVar.p((float) height, (float) width, 0.0f);
        lVar.k(f2, f2, 0.0f);
        this.f6522l.c(lVar, 0, 0);
        lVar.b();
        if (b) {
            q();
        }
    }

    private void N(com.pinguo.album.opengles.l lVar) {
        int height;
        int i2;
        if (this.m == null) {
            return;
        }
        lVar.s(3);
        long a2 = com.pinguo.album.animations.c.a();
        com.pinguo.album.animations.i iVar = this.q;
        boolean b = iVar != null ? iVar.b(a2) : false;
        com.pinguo.album.animations.i iVar2 = this.q;
        if (iVar2 != null && iVar2.d()) {
            this.q.m(lVar, 0, null);
        } else {
            this.f6522l = this.m;
            this.o = this.p;
            this.v = this.u;
        }
        Rect e2 = e();
        int width = this.m.getWidth();
        int height2 = this.m.getHeight();
        int i3 = this.u;
        if (i3 != 90 && i3 != 270) {
            height = ((int) (e2.width() - (width * this.p))) / 2;
            i2 = ((int) (e2.height() - (height2 * this.p))) / 2;
        } else {
            int width2 = e2.width() / 2;
            int height3 = e2.height() / 2;
            lVar.a(width2, height3);
            lVar.v(this.u, 0.0f, 0.0f, 1.0f);
            lVar.a(-height3, -width2);
            us.pinguo.common.log.a.k("renderCurrentItem mNextTextureRotation 111= " + this.u + " width = " + width + " height = " + height2, new Object[0]);
            int height4 = this.m.getHeight();
            int width3 = this.m.getWidth();
            int width4 = ((int) (((float) e2.width()) - (((float) height4) * this.p))) / 2;
            height = ((int) (((float) e2.height()) - (((float) width3) * this.p))) / 2;
            i2 = width4;
        }
        lVar.p(height, i2, 0.0f);
        float f2 = this.p;
        lVar.k(f2, f2, 0.0f);
        this.m.c(lVar, 0, 0);
        lVar.b();
        if (b) {
            q();
        }
    }

    public void I() {
        com.pinguo.album.opengles.c cVar = this.m;
        if (cVar != null) {
            cVar.o();
            this.m = null;
        }
        com.pinguo.album.opengles.c cVar2 = this.f6522l;
        if (cVar2 != null) {
            cVar2.o();
            this.f6522l = null;
        }
    }

    public void J() {
        com.pinguo.album.animations.i iVar = new com.pinguo.album.animations.i(n0.h());
        this.q = iVar;
        int i2 = this.t;
        if (i2 == 3) {
            iVar.n(4);
        } else if (i2 == 4) {
            iVar.n(3);
        }
        this.q.j(new AccelerateDecelerateInterpolator());
        this.q.i(500);
        this.q.l();
        com.pinguo.album.animations.a aVar = new com.pinguo.album.animations.a();
        this.r = aVar;
        aVar.i(IjkMediaCodecInfo.RANK_SECURE);
        this.r.l();
        q();
    }

    public int K() {
        return this.f6522l.getHeight();
    }

    public int L() {
        return this.f6522l.getWidth();
    }

    public void O(p pVar) {
        this.s = pVar;
    }

    public void P(com.pinguo.album.opengles.c cVar, float f2, int i2) {
        this.m = cVar;
        this.p = f2;
        this.u = i2;
        us.pinguo.common.log.a.k("renderCurrentItem mNextIconTexture = " + this.m + " mNewTextureScale = " + this.p, new Object[0]);
        q();
    }

    @Override // com.pinguo.album.views.a
    protected boolean w(MotionEvent motionEvent) {
        this.n.onTouchEvent(motionEvent);
        motionEvent.getAction();
        return true;
    }

    @Override // com.pinguo.album.views.a
    public void y(com.pinguo.album.opengles.l lVar) {
        super.y(lVar);
        M(lVar);
        N(lVar);
    }
}
