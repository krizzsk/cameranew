package com.pinguo.camera360.gallery.ui;

import android.content.res.Resources;
import com.pinguo.camera360.gallery.RootActivity;
import com.pinguo.camera360.gallery.ui.g;
import com.pinguo.camera360.gallery.ui.h;
import us.pinguo.foundation.utils.n0;
import vStudio.Android.Camera360.R;
/* compiled from: PickAlbumSetListSlotRenderer.java */
/* loaded from: classes3.dex */
public class v extends h {
    private int u;
    private int v;
    private com.pinguo.album.opengles.e w;
    private com.pinguo.album.opengles.e x;

    public v(RootActivity rootActivity, z zVar, o oVar, h.b bVar, int i2) {
        super(rootActivity, zVar, oVar, bVar, i2);
        this.u = 0;
        Resources resources = rootActivity.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.local_album_set_slot_gap);
        this.u = dimensionPixelSize;
        this.a = dimensionPixelSize;
        this.v = resources.getDimensionPixelSize(R.dimen.local_album_set_title_left_padding);
        this.w = new com.pinguo.album.opengles.e(resources.getColor(R.color.personal_color));
        this.x = new com.pinguo.album.opengles.e(-1);
    }

    private int H(com.pinguo.album.opengles.l lVar, int i2, int i3) {
        lVar.s(2);
        int i4 = this.u;
        lVar.a(-i4, -i4);
        this.x.a(lVar, 0, 0, n0.i(), i3 + (this.u * 2));
        lVar.b();
        return 0;
    }

    private int I(com.pinguo.album.opengles.l lVar, int i2) {
        lVar.s(2);
        lVar.a(-this.u, 0.0f);
        this.w.a(lVar, 0, i2 + this.u, n0.i(), 2);
        lVar.b();
        return 0;
    }

    @Override // com.pinguo.camera360.gallery.ui.h
    protected int A(com.pinguo.album.opengles.l lVar, g.d dVar, int i2, int i3) {
        if (dVar.f6550d != null) {
            lVar.s(2);
            lVar.a(i2 + this.v, 0.0f);
            com.pinguo.album.opengles.c cVar = dVar.f6550d;
            cVar.a(lVar, 0, 0, cVar.getWidth(), dVar.f6550d.getHeight());
            lVar.b();
            return 0;
        }
        return 0;
    }

    @Override // com.pinguo.camera360.gallery.ui.h
    public void D(com.pinguo.camera360.gallery.q qVar) {
        super.E(qVar, true);
        this.n.C(2);
    }

    @Override // com.pinguo.camera360.gallery.ui.h, com.pinguo.camera360.gallery.ui.z.e
    public int g(com.pinguo.album.opengles.l lVar, int i2, int i3, int i4) {
        g.d r = this.n.r(i2);
        if (lVar == null || r == null) {
            return 0;
        }
        return B(lVar, i2, r, n0.i(), i4 + (this.u * 2)) | A(lVar, r, i3, i4) | 0 | H(lVar, i3, i4) | z(lVar, r, i3, i4) | I(lVar, i4);
    }
}
