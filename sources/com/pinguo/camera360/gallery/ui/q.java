package com.pinguo.camera360.gallery.ui;

import android.content.res.Resources;
import androidx.core.view.ViewCompat;
import com.pinguo.camera360.gallery.RootActivity;
import com.pinguo.camera360.gallery.ui.g;
import com.pinguo.camera360.gallery.ui.h;
import us.pinguo.foundation.utils.n0;
import vStudio.Android.Camera360.R;
/* compiled from: LocalAlbumSetListSlotRenderer.java */
/* loaded from: classes3.dex */
public class q extends h {
    private com.pinguo.album.opengles.t A;
    private int u;
    private int v;
    private int w;
    private int x;
    private com.pinguo.album.opengles.e y;
    private com.pinguo.album.opengles.e z;

    public q(RootActivity rootActivity, z zVar, o oVar, h.b bVar, int i2) {
        super(rootActivity, zVar, oVar, bVar, i2);
        this.u = 0;
        this.v = 0;
        this.w = 0;
        Resources resources = rootActivity.getResources();
        this.u = resources.getDimensionPixelSize(R.dimen.album_set_count_font_size);
        this.v = resources.getDimensionPixelSize(R.dimen.local_album_set_slot_gap);
        this.w = resources.getDimensionPixelSize(R.dimen.album_set_pic_slot_paddingright);
        this.x = resources.getDimensionPixelSize(R.dimen.local_album_set_title_left_padding);
        this.a = this.v;
        this.y = new com.pinguo.album.opengles.e(resources.getColor(R.color.personal_color));
        this.A = com.pinguo.album.opengles.t.L(resources.getString(R.string.system_album), this.u, resources.getColor(R.color.system_album_title_color), false);
        this.z = new com.pinguo.album.opengles.e(-1);
    }

    private int H(com.pinguo.album.opengles.l lVar, int i2, int i3) {
        lVar.s(2);
        int i4 = this.v;
        lVar.a(-i4, -i4);
        this.z.a(lVar, 0, 0, n0.i(), i3 + (this.v * 2));
        lVar.b();
        return 0;
    }

    private int I(com.pinguo.album.opengles.l lVar, int i2) {
        lVar.s(2);
        lVar.a(this.v, 0.0f);
        com.pinguo.album.opengles.r rVar = this.f6507h;
        rVar.a(lVar, 0, (i2 - this.v) - rVar.getHeight(), this.f6507h.getWidth(), this.f6507h.getHeight());
        lVar.b();
        return 0;
    }

    private int J(com.pinguo.album.opengles.l lVar, g.d dVar, int i2, int i3) {
        com.pinguo.album.opengles.t L = com.pinguo.album.opengles.t.L(dVar.f6553g, this.m.f6562e, ViewCompat.MEASURED_STATE_MASK, false);
        L.a(lVar, i3 + this.w, (i3 - L.getHeight()) >> 1, L.getWidth(), L.getHeight());
        return 0;
    }

    private int K(com.pinguo.album.opengles.l lVar, int i2) {
        lVar.s(2);
        lVar.a(-this.v, 0.0f);
        this.y.a(lVar, 0, i2 + this.v, n0.i(), 2);
        lVar.b();
        return 0;
    }

    private int L(com.pinguo.album.opengles.l lVar, int i2) {
        lVar.s(2);
        lVar.a(-this.v, 0.0f);
        this.y.a(lVar, 0, -this.v, n0.i(), 2);
        lVar.b();
        return 0;
    }

    private int M(com.pinguo.album.opengles.l lVar, int i2) {
        lVar.s(2);
        int height = this.A.getHeight();
        com.pinguo.album.opengles.t tVar = this.A;
        tVar.a(lVar, 0, ((-this.v) - ((n0.c(40) - height) / 2)) - height, tVar.getWidth(), this.A.getHeight());
        lVar.b();
        return 0;
    }

    @Override // com.pinguo.camera360.gallery.ui.h
    protected int A(com.pinguo.album.opengles.l lVar, g.d dVar, int i2, int i3) {
        if (dVar.f6550d != null) {
            lVar.s(2);
            lVar.a(i2 + this.x, 0.0f);
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
        int A;
        g.d r = this.n.r(i2);
        if (lVar == null || r == null) {
            return 0;
        }
        int H = 0 | H(lVar, i3, i4) | z(lVar, r, i3, i4);
        if (i2 == 0) {
            A = J(lVar, r, i3, i4) | H | I(lVar, i4);
        } else {
            A = A(lVar, r, i3, i4) | H;
        }
        int K = A | K(lVar, i4);
        if (i2 == 1) {
            K = K | L(lVar, i4) | M(lVar, i4);
        }
        return B(lVar, i2, r, n0.i(), i4 + (this.v * 2)) | K;
    }
}
