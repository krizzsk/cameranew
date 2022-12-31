package com.pinguo.camera360.gallery;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.gallery.data.Path;
import java.util.ArrayList;
import vStudio.Android.Camera360.R;
/* compiled from: AlbumSetListPage.java */
/* loaded from: classes3.dex */
public class r extends s {
    private ArrayList<Path> L;
    protected com.pinguo.camera360.gallery.ui.r M;

    /* compiled from: AlbumSetListPage.java */
    /* loaded from: classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            r.this.E();
        }
    }

    @Override // com.pinguo.camera360.gallery.s
    public void E0(int i2) {
        this.M.w(R.id.action_add, this.r.B(i2).g(), this.L, null);
        this.a.E0().d(this);
    }

    @Override // com.pinguo.camera360.gallery.s, com.pinguo.camera360.gallery.ActivityState
    public void G(Bundle bundle, Bundle bundle2) {
        super.G(bundle, bundle2);
        this.L = bundle.getParcelableArrayList("path_list");
        this.M = new com.pinguo.camera360.gallery.ui.r(this.a, this.x);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.s, com.pinguo.camera360.gallery.ActivityState
    public boolean H(Menu menu) {
        this.F.k(new a());
        return super.H(menu);
    }

    @Override // com.pinguo.camera360.gallery.s
    protected int q0() {
        return this.a.getResources().getColor(R.color.personal_bg_color);
    }

    @Override // com.pinguo.camera360.gallery.s
    protected com.pinguo.camera360.gallery.ui.h t0() {
        g0 a2 = g0.a(this.a);
        a2.a.c = 0;
        return new com.pinguo.camera360.gallery.ui.v(this.a, this.y, this.x, a2.b, this.G.l());
    }

    @Override // com.pinguo.camera360.gallery.s
    protected com.pinguo.camera360.gallery.ui.b0.a u0() {
        return com.pinguo.camera360.gallery.ui.b0.a.d(5, this.z.f6717l);
    }

    @Override // com.pinguo.camera360.gallery.s
    protected com.pinguo.camera360.gallery.ui.toolbar.b v0() {
        return com.pinguo.camera360.gallery.ui.toolbar.r.a(8);
    }

    @Override // com.pinguo.camera360.gallery.s
    protected boolean z0() {
        return true;
    }
}
