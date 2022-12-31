package us.pinguo.util;

import android.opengl.GLES10;
import android.opengl.GLES20;
import android.os.Build;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
/* compiled from: GLInfoUtils.java */
/* loaded from: classes6.dex */
public class n {
    private static a a;

    /* compiled from: GLInfoUtils.java */
    /* loaded from: classes6.dex */
    public static class a {
        public final String a;
        public final int b;

        public a(String str, int i2, String str2) {
            this.a = str;
            this.b = i2;
        }
    }

    public static String a() {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return c().a;
            } catch (Throwable unused) {
                return "unknown";
            }
        }
        return b().a;
    }

    private static a b() {
        a aVar = a;
        if (aVar != null) {
            return aVar;
        }
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        a aVar2 = new a(GLES10.glGetString(7936) + "/" + GLES10.glGetString(7937), iArr[0], GLES20.glGetString(7939));
        a = aVar2;
        return aVar2;
    }

    private static a c() {
        a aVar = a;
        if (aVar != null) {
            return aVar;
        }
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(eglGetDisplay, new int[2]);
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr = new int[1];
        egl10.eglChooseConfig(eglGetDisplay, new int[]{12351, 12430, 12329, 0, 12339, 1, 12344}, eGLConfigArr, 1, iArr);
        int i2 = iArr[0];
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLSurface eglCreatePbufferSurface = egl10.eglCreatePbufferSurface(eglGetDisplay, eGLConfig, new int[]{12375, 64, 12374, 64, 12344});
        EGLContext eglCreateContext = egl10.eglCreateContext(eglGetDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 1, 12344});
        egl10.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext);
        int[] iArr2 = new int[1];
        GLES10.glGetIntegerv(3379, iArr2, 0);
        String glGetString = GLES20.glGetString(7939);
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        egl10.eglMakeCurrent(eglGetDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        egl10.eglDestroySurface(eglGetDisplay, eglCreatePbufferSurface);
        egl10.eglDestroyContext(eglGetDisplay, eglCreateContext);
        egl10.eglTerminate(eglGetDisplay);
        a aVar2 = new a(GLES10.glGetString(7936) + "/" + GLES10.glGetString(7937), iArr2[0], glGetString);
        a = aVar2;
        return aVar2;
    }

    public static int d() {
        int i2;
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                i2 = c().b;
            } catch (Throwable unused) {
                i2 = 4096;
            }
        } else {
            i2 = b().b;
        }
        return Math.max(2048, i2);
    }
}
