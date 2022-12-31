package com.pinguo.album.views;

import android.content.Context;
import android.opengl.Matrix;
import com.pinguo.album.opengles.l;
import com.pinguo.album.views.utils.EdgeEffect;
/* loaded from: classes3.dex */
public class EdgeView extends a {

    /* renamed from: l  reason: collision with root package name */
    private EdgeEffect[] f6098l = new EdgeEffect[4];
    private float[] m = new float[64];

    public EdgeView(Context context) {
        for (int i2 = 0; i2 < 4; i2++) {
            this.f6098l[i2] = new EdgeEffect(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.album.views.a
    public void v(boolean z, int i2, int i3, int i4, int i5) {
        if (z) {
            int i6 = i4 - i2;
            int i7 = i5 - i3;
            for (int i8 = 0; i8 < 4; i8++) {
                if ((i8 & 1) == 0) {
                    this.f6098l[i8].b(i6, i7);
                } else {
                    this.f6098l[i8].b(i7, i6);
                }
            }
            Matrix.setIdentityM(this.m, 0);
            Matrix.setIdentityM(this.m, 16);
            Matrix.setIdentityM(this.m, 32);
            Matrix.setIdentityM(this.m, 48);
            Matrix.rotateM(this.m, 16, 90.0f, 0.0f, 0.0f, 1.0f);
            Matrix.scaleM(this.m, 16, 1.0f, -1.0f, 1.0f);
            Matrix.translateM(this.m, 32, 0.0f, i7, 0.0f);
            Matrix.scaleM(this.m, 32, 1.0f, -1.0f, 1.0f);
            Matrix.translateM(this.m, 48, i6, 0.0f, 0.0f);
            Matrix.rotateM(this.m, 48, 90.0f, 0.0f, 0.0f, 1.0f);
        }
    }

    @Override // com.pinguo.album.views.a
    public void y(l lVar) {
        super.y(lVar);
        boolean z = false;
        for (int i2 = 0; i2 < 4; i2++) {
            lVar.s(2);
            lVar.j(this.m, i2 * 16);
            z |= this.f6098l[i2].a(lVar);
            lVar.b();
        }
        if (z) {
            q();
        }
    }
}
