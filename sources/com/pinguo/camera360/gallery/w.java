package com.pinguo.camera360.gallery;

import android.os.Bundle;
import android.view.View;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.album.animations.StateTransAnim;
import vStudio.Android.Camera360.R;
/* compiled from: GalleryListPage.java */
/* loaded from: classes3.dex */
public class w extends s {

    /* compiled from: GalleryListPage.java */
    /* loaded from: classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            w.this.o0();
        }
    }

    @Override // com.pinguo.camera360.gallery.s
    public void B0() {
        Bundle bundle = new Bundle();
        bundle.putInt("media-type", 1000);
        bundle.putString("media-path-id", "path-set");
        a0(z.class, w.class, StateTransAnim.Transition.TranslateOut);
        this.a.E0().s(this, z.class, bundle);
    }

    @Override // com.pinguo.camera360.gallery.s
    protected void I0(int i2) {
        if (us.pinguo.foundation.utils.x.a.b(this.a)) {
            return;
        }
        this.a.O0(i2);
    }

    @Override // com.pinguo.camera360.gallery.s, com.pinguo.camera360.gallery.ActivityState
    public void J() {
        super.J();
        this.a.L0();
    }

    @Override // com.pinguo.camera360.gallery.s
    protected void K0(int i2) {
    }

    @Override // com.pinguo.camera360.gallery.s
    protected void L0(int i2, boolean z) {
        com.pinguo.camera360.gallery.i0.a.c().h(i2);
        U(i2 <= 0, R.drawable.empty_story, R.string.empty_album_set_tips, R.string.add_pics, new a());
        if (z) {
            y0();
        }
    }

    @Override // com.pinguo.camera360.gallery.s
    protected com.pinguo.camera360.gallery.ui.b0.a u0() {
        com.pinguo.camera360.gallery.ui.b0.a d2 = com.pinguo.camera360.gallery.ui.b0.a.d(1, 0);
        d2.L(this.z.f6717l);
        return d2;
    }

    @Override // com.pinguo.camera360.gallery.ActivityState
    public int w() {
        return 2;
    }
}
