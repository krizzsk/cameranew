package com.pinguo.camera360.gallery;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.album.animations.StateTransAnim;
import com.pinguo.camera360.k.b.a;
import us.pinguo.advconfigdata.AdvConfigManager;
import vStudio.Android.Camera360.R;
/* compiled from: LocalAlbumSetListPage.java */
/* loaded from: classes3.dex */
public class z extends s {

    /* compiled from: LocalAlbumSetListPage.java */
    /* loaded from: classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            z.this.E();
        }
    }

    private void M0() {
        Bundle bundle = new Bundle();
        bundle.putInt("media-type", 1302);
        bundle.putString("media-path-id", "");
        bundle.putString("media-name", this.a.getResources().getString(R.string.favorite_title));
        bundle.putInt("layout_type", 4);
        bundle.putInt("toolbar_type", 11);
        bundle.putParcelable("bundle_key_goto", x().getParcelable("bundle_key_goto"));
        a0(z.class, u.class, StateTransAnim.Transition.TranslateIn);
        this.a.E0().o(u.class, bundle);
    }

    @Override // com.pinguo.camera360.gallery.s
    protected void B0() {
        Bundle bundle = new Bundle();
        bundle.putInt("media-type", 1304);
        bundle.putString("media-path-id", "");
        a0(z.class, t.class, StateTransAnim.Transition.TranslateOut);
        this.a.E0().s(this, t.class, bundle);
    }

    @Override // com.pinguo.camera360.gallery.s
    protected void C0() {
        Bundle bundle = new Bundle();
        bundle.putInt("media-type", 1201);
        bundle.putString("media-path-id", "path-big-album-def");
        a0(z.class, w.class, StateTransAnim.Transition.TranslateIn);
        this.a.E0().s(this, w.class, bundle);
    }

    @Override // com.pinguo.camera360.gallery.s, com.pinguo.camera360.gallery.ActivityState
    public void G(Bundle bundle, Bundle bundle2) {
        super.G(bundle, bundle2);
        new com.pinguo.camera360.gallery.ui.r(this.a, this.x);
        if (AdvConfigManager.getInstance().getItemHightPrioritys("eae77201a0313555644877c074710069") != null) {
            us.pinguo.foundation.statistics.h.a.d("show");
        }
    }

    @Override // com.pinguo.camera360.gallery.s
    protected void G0(int i2) {
        if (this.s) {
            com.pinguo.camera360.gallery.data.y B = this.r.B(i2);
            if (B != null && (B instanceof com.pinguo.camera360.gallery.data.p)) {
                M0();
                return;
            }
            int z = this.r.z(i2);
            if (z == 0) {
                return;
            }
            int[] iArr = new int[2];
            r0(i2, iArr);
            Bundle bundle = new Bundle();
            bundle.putInt("media-type", 1303);
            bundle.putString("media-path-id", String.valueOf(z));
            bundle.putString("media-name", B.s());
            bundle.putIntArray("set-center", iArr);
            bundle.putInt("layout_type", 3);
            bundle.putInt("toolbar_type", 9);
            bundle.putParcelable("bundle_key_goto", x().getParcelable("bundle_key_goto"));
            a0(z.class, y.class, StateTransAnim.Transition.TranslateIn);
            this.a.E0().r(y.class, 1, bundle);
        }
    }

    @Override // com.pinguo.camera360.gallery.s, com.pinguo.camera360.gallery.ActivityState
    protected boolean H(Menu menu) {
        this.F.k(new a());
        return super.H(menu);
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
    }

    @Override // com.pinguo.camera360.gallery.s
    protected void K0(int i2) {
        a.d.g(i2);
    }

    @Override // com.pinguo.camera360.gallery.s, com.pinguo.camera360.gallery.ActivityState
    public void L() {
        super.L();
    }

    @Override // com.pinguo.camera360.gallery.s
    protected void L0(int i2, boolean z) {
    }

    @Override // com.pinguo.camera360.gallery.s
    protected int q0() {
        return this.a.getResources().getColor(R.color.personal_bg_color);
    }

    @Override // com.pinguo.camera360.gallery.s
    protected com.pinguo.camera360.gallery.ui.h t0() {
        return new com.pinguo.camera360.gallery.ui.q(this.a, this.y, this.x, g0.a(this.a).b, this.G.l());
    }

    @Override // com.pinguo.camera360.gallery.s
    protected com.pinguo.camera360.gallery.ui.b0.a u0() {
        com.pinguo.camera360.gallery.ui.b0.a d2 = com.pinguo.camera360.gallery.ui.b0.a.d(5, 0);
        d2.L(this.z.f6717l);
        return d2;
    }

    @Override // com.pinguo.camera360.gallery.s
    protected com.pinguo.camera360.gallery.ui.toolbar.b v0() {
        return com.pinguo.camera360.gallery.ui.toolbar.r.a(12);
    }

    @Override // com.pinguo.camera360.gallery.ActivityState
    public int w() {
        return 1;
    }

    @Override // com.pinguo.camera360.gallery.s
    protected boolean z0() {
        return true;
    }
}
