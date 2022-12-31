package com.pinguo.camera360.gallery;

import android.os.Bundle;
import android.view.MenuItem;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.album.animations.StateTransAnim;
import vStudio.Android.Camera360.R;
/* compiled from: GalleryAlbumPage.java */
/* loaded from: classes3.dex */
public class v extends o {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.o, com.pinguo.camera360.gallery.ActivityState
    public void E() {
        if (this.p.i()) {
            this.p.f();
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("media-type", 1201);
        bundle.putString("media-path-id", "path-big-album-def");
        a0(v.class, w.class, StateTransAnim.Transition.TranslateOut);
        this.a.E0().q(w.class, bundle);
    }

    @Override // com.pinguo.camera360.gallery.o
    protected com.pinguo.camera360.gallery.ui.b0.a F0(int i2) {
        return com.pinguo.camera360.gallery.ui.b0.a.c(i2);
    }

    @Override // com.pinguo.camera360.gallery.o
    protected void M0() {
        if (this.p.i()) {
            this.p.f();
            return;
        }
        a0(v.class, m.class, StateTransAnim.Transition.TranslateOut);
        this.a.E0().d(this);
    }

    @Override // com.pinguo.camera360.gallery.o
    protected void f1(boolean z) {
        if (z) {
            us.pinguo.foundation.statistics.h.a.s0("picture_select_entrence_button", "other_album", "press");
        } else {
            us.pinguo.foundation.statistics.h.a.s0("picture_select_entrence_button", "other_album", "click");
        }
    }

    @Override // com.pinguo.camera360.gallery.o
    protected void h1(int i2) {
        boolean z = i2 <= 0;
        g1(z);
        T(z, R.drawable.empty_camera, R.string.empty_gallery_page_tips);
        I0();
        this.J.n(!z, 1, 2, 3);
    }

    @Override // com.pinguo.camera360.gallery.o, androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    @Instrumented
    public boolean onMenuItemClick(MenuItem menuItem) {
        VdsAgent.onMenuItemClick(this, menuItem);
        if (menuItem.getItemId() == R.id.action_delete) {
            if (this.G == 0) {
                VdsAgent.handleClickResult(new Boolean(false));
                return false;
            }
            this.M.p(menuItem.getItemId(), R.string.remove_pic_tips, null);
            VdsAgent.handleClickResult(new Boolean(true));
            return true;
        }
        boolean onMenuItemClick = super.onMenuItemClick(menuItem);
        VdsAgent.handleClickResult(new Boolean(onMenuItemClick));
        return onMenuItemClick;
    }
}
