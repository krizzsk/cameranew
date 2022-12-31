package us.pinguo.glrender;

import android.opengl.GLES20;
import androidx.work.Data;
/* compiled from: Texture2D.java */
/* loaded from: classes4.dex */
class b {

    /* renamed from: d  reason: collision with root package name */
    private static int f11138d;
    private int a;
    private int b;
    private int c;

    public b(int i2, int i3) {
        a();
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i4 = iArr[0];
        this.a = i4;
        f11138d = i4;
        GLES20.glBindTexture(3553, i4);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, Data.MAX_DATA_BYTES, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6408, i2, i3, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        this.b = i2;
        this.c = i3;
    }

    public static void a() {
        if (f11138d > 0) {
            us.pinguo.common.log.a.c("delete last texture id:" + f11138d, new Object[0]);
            GLES20.glDeleteTextures(1, new int[]{f11138d}, 0);
            f11138d = 0;
        }
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.a;
    }

    public int d() {
        return this.b;
    }
}
