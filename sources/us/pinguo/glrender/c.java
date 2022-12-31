package us.pinguo.glrender;

import android.opengl.GLES20;
import com.tencent.bugly.crashreport.CrashReport;
/* compiled from: Utils.java */
/* loaded from: classes4.dex */
public class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            CrashReport.postCatchedException(new RuntimeException(str + ": glError " + glGetError));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i2, String str) {
        int glCreateShader = GLES20.glCreateShader(i2);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }
}
