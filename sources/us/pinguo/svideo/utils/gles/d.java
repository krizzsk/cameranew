package us.pinguo.svideo.utils.gles;

import android.app.ActivityManager;
import android.content.Context;
import android.opengl.Matrix;
/* compiled from: GlUtil.java */
/* loaded from: classes6.dex */
public class d {
    public static final float[] a;

    static {
        float[] fArr = new float[16];
        a = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    public static boolean a(Context context) {
        return ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= 196608;
    }
}
