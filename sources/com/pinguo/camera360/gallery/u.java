package com.pinguo.camera360.gallery;

import com.pinguo.album.animations.StateTransAnim;
import vStudio.Android.Camera360.R;
/* compiled from: FavoriteAlbumPage.java */
/* loaded from: classes3.dex */
public class u extends o {
    @Override // com.pinguo.camera360.gallery.o, com.pinguo.camera360.gallery.ActivityState
    protected void E() {
        if (this.p.i()) {
            this.p.f();
            return;
        }
        a0(u.class, z.class, StateTransAnim.Transition.TranslateOut);
        this.a.E0().d(this);
    }

    @Override // com.pinguo.camera360.gallery.o
    protected com.pinguo.camera360.gallery.ui.b0.a F0(int i2) {
        return com.pinguo.camera360.gallery.ui.b0.a.c(i2);
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
        T(z, R.drawable.empty_camera, R.string.no_favorite_pic);
        this.J.n(!z, 0);
        I0();
    }
}
