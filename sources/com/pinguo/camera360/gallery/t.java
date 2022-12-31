package com.pinguo.camera360.gallery;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.album.animations.StateTransAnim;
import vStudio.Android.Camera360.R;
/* compiled from: DefaultAlbumPage.java */
/* loaded from: classes3.dex */
public class t extends o {
    private com.pinguo.camera360.adv.b T;
    private Handler U = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultAlbumPage.java */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            t.this.a.finish();
            us.pinguo.foundation.b.j(t.this.a);
        }
    }

    /* compiled from: DefaultAlbumPage.java */
    /* loaded from: classes3.dex */
    class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            t.this.T.e();
        }
    }

    @Override // com.pinguo.camera360.gallery.o
    protected com.pinguo.camera360.gallery.ui.b0.a F0(int i2) {
        com.pinguo.camera360.gallery.ui.b0.a d2 = com.pinguo.camera360.gallery.ui.b0.a.d(i2, 0);
        d2.L(this.D.f6717l);
        return d2;
    }

    @Override // com.pinguo.camera360.gallery.o, com.pinguo.camera360.gallery.ActivityState
    protected void G(Bundle bundle, Bundle bundle2) {
        super.G(bundle, bundle2);
        this.s.C();
        this.E.C();
        com.pinguo.camera360.adv.b bVar = new com.pinguo.camera360.adv.b(this.a);
        this.T = bVar;
        bVar.c();
    }

    @Override // com.pinguo.camera360.gallery.o, com.pinguo.camera360.gallery.ActivityState
    protected void I() {
        this.s.A();
        this.E.z();
        super.I();
    }

    @Override // com.pinguo.camera360.gallery.o, com.pinguo.camera360.gallery.ActivityState
    protected void J() {
        super.J();
        this.T.d(Boolean.FALSE);
        this.T.b();
    }

    @Override // com.pinguo.camera360.gallery.o, com.pinguo.camera360.gallery.ActivityState
    protected void L() {
        super.L();
        this.T.d(Boolean.TRUE);
    }

    @Override // com.pinguo.camera360.gallery.o
    protected void M0() {
    }

    @Override // com.pinguo.camera360.gallery.o
    protected void N0() {
        if (this.p.i()) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("media-type", 1000);
        bundle.putString("media-path-id", "path-set");
        a0(z.class, t.class, StateTransAnim.Transition.TranslateIn);
        this.a.E0().s(this, z.class, bundle);
    }

    @Override // com.pinguo.camera360.gallery.o
    protected void S0() {
        this.s.y();
    }

    @Override // com.pinguo.camera360.gallery.o
    protected void X0() {
        this.s.z();
        us.pinguo.common.log.a.k("resumeDataAndRender start", new Object[0]);
        this.G = this.q.r();
        us.pinguo.common.log.a.k("resumeDataAndRender end", new Object[0]);
        h1(this.G);
    }

    @Override // com.pinguo.camera360.gallery.o
    protected void a1(int i2) {
        super.a1(i2 * 2);
    }

    @Override // com.pinguo.camera360.gallery.o
    protected void d1(int i2) {
        super.d1(i2);
        this.T.b();
        this.U.removeCallbacksAndMessages(null);
        this.U.sendEmptyMessageDelayed(0, 1000L);
    }

    @Override // com.pinguo.camera360.gallery.o
    protected void f1(boolean z) {
        if (z) {
            us.pinguo.foundation.statistics.h.a.s0("picture_select_entrence_button", "my_album", "press");
        } else {
            us.pinguo.foundation.statistics.h.a.s0("picture_select_entrence_button", "my_album", "click");
        }
    }

    @Override // com.pinguo.camera360.gallery.o
    protected void h1(int i2) {
        boolean z = i2 <= 0;
        g1(z);
        V(z, R.drawable.empty_camera, R.string.empty_album_tips, new a());
        this.J.n(!z, 0, 1, 2);
        I0();
    }

    @Override // com.pinguo.camera360.gallery.ActivityState
    public int w() {
        return 0;
    }
}
