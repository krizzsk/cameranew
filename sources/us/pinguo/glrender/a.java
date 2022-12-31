package us.pinguo.glrender;

import android.opengl.GLES20;
import android.util.Log;
import androidx.work.Data;
/* compiled from: FBO.java */
/* loaded from: classes4.dex */
class a {
    private static int b;
    private static int c;
    private int a;

    public a(b bVar) {
        c();
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i2 = iArr[0];
        b = iArr[0];
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexImage2D(3553, 0, 6402, bVar.d(), bVar.b(), 0, 6402, 5123, null);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, Data.MAX_DATA_BYTES, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glBindTexture(3553, 0);
        GLES20.glGenFramebuffers(1, iArr, 0);
        int i3 = iArr[0];
        this.a = i3;
        c = i3;
        GLES20.glBindFramebuffer(36160, i3);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, bVar.c(), 0);
        GLES20.glFramebufferTexture2D(36160, 36096, 3553, i2, 0);
        GLES20.glBindFramebuffer(36160, 0);
        if (GLES20.glCheckFramebufferStatus(36160) != 36053) {
            Log.e("FBO", "GL_FRAMEBUFFER NOT COMPLETE");
        } else {
            Log.d("FBO", "GL_FRAMEBUFFER COMPLETE");
        }
    }

    public static void c() {
        if (b > 0) {
            us.pinguo.common.log.a.c("delete last depth id:" + b, new Object[0]);
            GLES20.glDeleteTextures(1, new int[]{b}, 0);
            b = 0;
        }
        if (c > 0) {
            us.pinguo.common.log.a.c("delete last framebuffer id:" + c, new Object[0]);
            GLES20.glDeleteFramebuffers(1, new int[]{c}, 0);
            c = 0;
        }
    }

    public void a() {
        GLES20.glBindFramebuffer(36160, this.a);
        GLES20.glBindBuffer(34963, 0);
        GLES20.glBindBuffer(34962, 0);
        c.a("glBindBuffer GL_ARRAY_BUFFER 0");
    }

    public void b() {
        GLES20.glBindFramebuffer(36160, 0);
    }
}
