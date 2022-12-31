package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(14)
/* loaded from: classes2.dex */
public final class zzbbm extends Thread implements SurfaceTexture.OnFrameAvailableListener, zzbbj {
    private static final float[] zzelq = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private int height;
    private int width;
    private final float[] zzelb;
    private final zzbbh zzelr;
    private final float[] zzels;
    private final float[] zzelt;
    private final float[] zzelu;
    private final float[] zzelv;
    private final float[] zzelw;
    private final float[] zzelx;
    private float zzely;
    private float zzelz;
    private float zzema;
    private SurfaceTexture zzemb;
    private SurfaceTexture zzemc;
    private int zzemd;
    private int zzeme;
    private int zzemf;
    private FloatBuffer zzemg;
    private final CountDownLatch zzemh;
    private final Object zzemi;
    private EGL10 zzemj;
    private EGLDisplay zzemk;
    private EGLContext zzeml;
    private EGLSurface zzemm;
    private volatile boolean zzemn;
    private volatile boolean zzemo;

    public zzbbm(Context context) {
        super("SphericalVideoProcessor");
        float[] fArr = zzelq;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.zzemg = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        this.zzelb = new float[9];
        this.zzels = new float[9];
        this.zzelt = new float[9];
        this.zzelu = new float[9];
        this.zzelv = new float[9];
        this.zzelw = new float[9];
        this.zzelx = new float[9];
        this.zzely = Float.NaN;
        zzbbh zzbbhVar = new zzbbh(context);
        this.zzelr = zzbbhVar;
        zzbbhVar.zza(this);
        this.zzemh = new CountDownLatch(1);
        this.zzemi = new Object();
    }

    private final boolean zzaay() {
        EGLSurface eGLSurface;
        EGLSurface eGLSurface2 = this.zzemm;
        boolean z = false;
        if (eGLSurface2 != null && eGLSurface2 != (eGLSurface = EGL10.EGL_NO_SURFACE)) {
            z = this.zzemj.eglDestroySurface(this.zzemk, this.zzemm) | this.zzemj.eglMakeCurrent(this.zzemk, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT) | false;
            this.zzemm = null;
        }
        EGLContext eGLContext = this.zzeml;
        if (eGLContext != null) {
            z |= this.zzemj.eglDestroyContext(this.zzemk, eGLContext);
            this.zzeml = null;
        }
        EGLDisplay eGLDisplay = this.zzemk;
        if (eGLDisplay != null) {
            boolean eglTerminate = z | this.zzemj.eglTerminate(eGLDisplay);
            this.zzemk = null;
            return eglTerminate;
        }
        return z;
    }

    private static int zzd(int i2, String str) {
        int glCreateShader = GLES20.glCreateShader(i2);
        zzfb("createShader");
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            zzfb("shaderSource");
            GLES20.glCompileShader(glCreateShader);
            zzfb("compileShader");
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            zzfb("getShaderiv");
            if (iArr[0] == 0) {
                StringBuilder sb = new StringBuilder(37);
                sb.append("Could not compile shader ");
                sb.append(i2);
                sb.append(":");
                Log.e("SphericalVideoRenderer", sb.toString());
                Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(glCreateShader));
                GLES20.glDeleteShader(glCreateShader);
                zzfb("deleteShader");
                return 0;
            }
            return glCreateShader;
        }
        return glCreateShader;
    }

    private static void zzfb(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21);
            sb.append(str);
            sb.append(": glError ");
            sb.append(glGetError);
            Log.e("SphericalVideoRenderer", sb.toString());
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzemf++;
        synchronized (this.zzemi) {
            this.zzemi.notifyAll();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01cf A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.graphics.SurfaceTexture, android.graphics.SurfaceTexture$OnFrameAvailableListener] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 1020
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbm.run():void");
    }

    public final void zza(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.width = i2;
        this.height = i3;
        this.zzemc = surfaceTexture;
    }

    public final void zzaaw() {
        synchronized (this.zzemi) {
            this.zzemo = true;
            this.zzemc = null;
            this.zzemi.notifyAll();
        }
    }

    public final SurfaceTexture zzaax() {
        if (this.zzemc == null) {
            return null;
        }
        try {
            this.zzemh.await();
        } catch (InterruptedException unused) {
        }
        return this.zzemb;
    }

    public final void zzb(float f2, float f3) {
        float f4;
        float f5;
        float f6;
        int i2 = this.width;
        int i3 = this.height;
        if (i2 > i3) {
            f4 = (f2 * 1.7453293f) / i2;
            f5 = f3 * 1.7453293f;
            f6 = i2;
        } else {
            f4 = (f2 * 1.7453293f) / i3;
            f5 = f3 * 1.7453293f;
            f6 = i3;
        }
        this.zzelz -= f4;
        float f7 = this.zzema - (f5 / f6);
        this.zzema = f7;
        if (f7 < -1.5707964f) {
            this.zzema = -1.5707964f;
        }
        if (this.zzema > 1.5707964f) {
            this.zzema = 1.5707964f;
        }
    }

    public final void zzm(int i2, int i3) {
        synchronized (this.zzemi) {
            this.width = i2;
            this.height = i3;
            this.zzemn = true;
            this.zzemi.notifyAll();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbbj
    public final void zzwa() {
        synchronized (this.zzemi) {
            this.zzemi.notifyAll();
        }
    }

    private static void zza(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[1] * fArr3[3]) + (fArr2[2] * fArr3[6]);
        fArr[1] = (fArr2[0] * fArr3[1]) + (fArr2[1] * fArr3[4]) + (fArr2[2] * fArr3[7]);
        fArr[2] = (fArr2[0] * fArr3[2]) + (fArr2[1] * fArr3[5]) + (fArr2[2] * fArr3[8]);
        fArr[3] = (fArr2[3] * fArr3[0]) + (fArr2[4] * fArr3[3]) + (fArr2[5] * fArr3[6]);
        fArr[4] = (fArr2[3] * fArr3[1]) + (fArr2[4] * fArr3[4]) + (fArr2[5] * fArr3[7]);
        fArr[5] = (fArr2[3] * fArr3[2]) + (fArr2[4] * fArr3[5]) + (fArr2[5] * fArr3[8]);
        fArr[6] = (fArr2[6] * fArr3[0]) + (fArr2[7] * fArr3[3]) + (fArr2[8] * fArr3[6]);
        fArr[7] = (fArr2[6] * fArr3[1]) + (fArr2[7] * fArr3[4]) + (fArr2[8] * fArr3[7]);
        fArr[8] = (fArr2[6] * fArr3[2]) + (fArr2[7] * fArr3[5]) + (fArr2[8] * fArr3[8]);
    }

    private static void zzb(float[] fArr, float f2) {
        double d2 = f2;
        fArr[0] = (float) Math.cos(d2);
        fArr[1] = (float) (-Math.sin(d2));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(d2);
        fArr[4] = (float) Math.cos(d2);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private static void zza(float[] fArr, float f2) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        double d2 = f2;
        fArr[4] = (float) Math.cos(d2);
        fArr[5] = (float) (-Math.sin(d2));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(d2);
        fArr[8] = (float) Math.cos(d2);
    }
}
