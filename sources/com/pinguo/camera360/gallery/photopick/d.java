package com.pinguo.camera360.gallery.photopick;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.album.animations.StateTransAnim;
import com.pinguo.camera360.gallery.ActivityState;
import com.pinguo.camera360.gallery.data.y;
import com.pinguo.camera360.gallery.g0;
import com.pinguo.camera360.gallery.photopick.PhotoPickLauncher;
import com.pinguo.camera360.gallery.s;
import com.pinguo.camera360.gallery.ui.r;
import com.pinguo.camera360.gallery.ui.v;
import java.io.Serializable;
import vStudio.Android.Camera360.R;
/* compiled from: PhotoPickAlbumSetPage.java */
/* loaded from: classes3.dex */
public class d extends s {
    private PhotoPickLauncher.LaunchMode L;

    /* compiled from: PhotoPickAlbumSetPage.java */
    /* loaded from: classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            if (((ActivityState) d.this).a instanceof PhotoPickActivity) {
                ((PhotoPickActivity) ((ActivityState) d.this).a).onBackPressed();
            } else {
                ((ActivityState) d.this).a.E0().d(d.this);
            }
        }
    }

    /* compiled from: PhotoPickAlbumSetPage.java */
    /* loaded from: classes3.dex */
    class b implements Toolbar.OnMenuItemClickListener {
        b() {
        }

        @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
        @Instrumented
        public boolean onMenuItemClick(MenuItem menuItem) {
            VdsAgent.onMenuItemClick(this, menuItem);
            if (((ActivityState) d.this).a instanceof PhotoPickActivity) {
                ((PhotoPickActivity) ((ActivityState) d.this).a).W0();
                VdsAgent.handleClickResult(new Boolean(true));
                return true;
            }
            VdsAgent.handleClickResult(new Boolean(false));
            return false;
        }
    }

    @Override // com.pinguo.camera360.gallery.s, com.pinguo.camera360.gallery.ActivityState
    public void G(Bundle bundle, Bundle bundle2) {
        Serializable serializable = bundle.getSerializable("photo_pick_mode");
        if (serializable != null) {
            this.L = (PhotoPickLauncher.LaunchMode) serializable;
        } else {
            this.L = PhotoPickLauncher.LaunchMode.MULTI_PHOTO_NEW;
        }
        super.G(bundle, bundle2);
        new r(this.a, this.x);
    }

    @Override // com.pinguo.camera360.gallery.s
    protected void G0(int i2) {
        if (this.s) {
            y B = this.r.B(i2);
            int z = this.r.z(i2);
            if (z == 0) {
                return;
            }
            r0(i2, new int[2]);
            Bundle bundle = new Bundle();
            bundle.putInt("media-type", 1303);
            bundle.putString("media-path-id", String.valueOf(z));
            bundle.putString("media-name", B.s());
            bundle.putSerializable("photo_pick_mode", this.L);
            a0(d.class, c.class, StateTransAnim.Transition.TranslateIn);
            this.a.E0().r(c.class, 1, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.s, com.pinguo.camera360.gallery.ActivityState
    public boolean H(Menu menu) {
        this.F.g(this.a.F0(), this.a.G0(), menu, this.a);
        this.F.d();
        this.F.k(new a());
        this.F.l(new b());
        this.F.p(PhotoPickBroker.k().i());
        return true;
    }

    @Override // com.pinguo.camera360.gallery.s
    protected void L0(int i2, boolean z) {
        if (z) {
            y0();
        }
    }

    @Override // com.pinguo.camera360.gallery.s
    protected int q0() {
        return this.a.getResources().getColor(R.color.personal_bg_color);
    }

    @Override // com.pinguo.camera360.gallery.s
    protected com.pinguo.camera360.gallery.ui.h t0() {
        g0 a2 = g0.a(this.a);
        a2.a.c = 0;
        return new v(this.a, this.y, this.x, a2.b, this.G.l());
    }

    @Override // com.pinguo.camera360.gallery.s
    protected com.pinguo.camera360.gallery.ui.b0.a u0() {
        return com.pinguo.camera360.gallery.ui.b0.a.c(5);
    }

    @Override // com.pinguo.camera360.gallery.s
    protected com.pinguo.camera360.gallery.ui.toolbar.b v0() {
        return com.pinguo.camera360.gallery.ui.toolbar.r.a(7);
    }
}
