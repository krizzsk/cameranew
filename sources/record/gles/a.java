package record.gles;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
/* compiled from: GlUtil.java */
/* loaded from: classes3.dex */
public class a {
    public static final float[] a;

    static {
        float[] fArr = new float[16];
        a = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    public static void a(String str) {
        int glGetError;
        if (GLES20.glGetError() == 0) {
            return;
        }
        String str2 = str + ": glError 0x" + Integer.toHexString(glGetError);
        Log.e("Grafika", str2);
        throw new RuntimeException(str2);
    }
}
