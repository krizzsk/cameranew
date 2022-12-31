package com.pinguo.camera360.gallery.photopick;

import android.os.Bundle;
import com.pinguo.camera360.gallery.c0;
import com.pinguo.camera360.gallery.data.Path;
import com.pinguo.camera360.gallery.data.w;
import com.pinguo.camera360.gallery.data.y;
import com.pinguo.camera360.gallery.ui.toolbar.r;
/* compiled from: PhotoPickPhotoPage.java */
/* loaded from: classes3.dex */
public class g extends c0 {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.c0, com.pinguo.camera360.gallery.ActivityState
    public void E() {
        s0();
    }

    @Override // com.pinguo.camera360.gallery.c0, com.pinguo.camera360.gallery.ActivityState
    public void G(Bundle bundle, Bundle bundle2) {
        super.G(bundle, bundle2);
        this.t.R0(false);
        this.F.o();
    }

    @Override // com.pinguo.camera360.gallery.c0, com.pinguo.camera360.gallery.ui.u.i
    public void m(int i2, int i3) {
        w g2 = this.u.g(0);
        if (g2 != null && g2.y() && c0.C0(i2, i3, this.t)) {
            this.p = us.pinguo.inspire_proxy.media.e.j(this.a, g2.o());
        }
    }

    @Override // com.pinguo.camera360.gallery.c0
    protected y t0(Path path) {
        y e2 = this.a.P().e(path, "");
        e2.A();
        return e2;
    }

    @Override // com.pinguo.camera360.gallery.c0
    protected com.pinguo.camera360.gallery.ui.toolbar.b u0(int i2) {
        return r.a(14);
    }

    @Override // com.pinguo.camera360.gallery.c0
    protected boolean v0() {
        return false;
    }
}
