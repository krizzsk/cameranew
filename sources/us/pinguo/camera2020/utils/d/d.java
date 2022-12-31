package us.pinguo.camera2020.utils.d;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.view.Surface;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import us.pinguo.svideo.c.g;
import us.pinguo.svideo.c.h;
import us.pinguo.svideo.ending.VideoEnding;
import us.pinguo.svideo.manager.VideoRecorderAdapter;
import us.pinguo.svideo.utils.SVideoUtil;
import us.pinguo.util.v;
/* compiled from: RecordHelperUnity.java */
/* loaded from: classes3.dex */
public class d {
    private static g a = null;
    private static volatile Surface b = null;
    private static us.pinguo.svideo.utils.gles.b c = null;

    /* renamed from: d  reason: collision with root package name */
    private static int f9249d = 0;

    /* renamed from: e  reason: collision with root package name */
    private static int f9250e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f9251f = true;

    /* renamed from: g  reason: collision with root package name */
    private static EGL10 f9252g;

    /* renamed from: h  reason: collision with root package name */
    private static EGLDisplay f9253h;

    /* renamed from: i  reason: collision with root package name */
    private static EGLSurface f9254i;

    /* renamed from: j  reason: collision with root package name */
    private static EGLContext f9255j;

    /* renamed from: k  reason: collision with root package name */
    private static int f9256k;

    /* renamed from: l  reason: collision with root package name */
    private static int f9257l;
    private static boolean m;
    private static b n;

    public static void a(Surface surface) {
        if (f9252g == null) {
            f9252g = (EGL10) EGLContext.getEGL();
        }
        f9253h = f9252g.eglGetCurrentDisplay();
        f9255j = f9252g.eglGetCurrentContext();
        f9254i = f9252g.eglGetCurrentSurface(12377);
        try {
            c = new us.pinguo.svideo.utils.gles.b(surface, f9255j, false, 1);
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
            c = null;
        }
    }

    private static void b(int i2) {
        GLES20.glFinish();
        c.a();
        n.a(i2, 0);
    }

    private static void c(int i2, int i3, int i4, int i5, int i6) {
        GLES20.glFinish();
        c.b(f9254i);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        GLES30.glBlitFramebuffer(0, 0, i5, i6, 0, 0, i3, i4, 16384, 9728);
        if (GLES30.glGetError() != 0) {
            f9251f = false;
            b(i2);
        }
    }

    private static synchronized void d(int i2, int i3, int i4) {
        synchronized (d.class) {
            if (m && a != null) {
                us.pinguo.common.log.a.k("releaseEGLEnv", new Object[0]);
                g();
                a.e(true, null, b, 0L);
                a = null;
                b = null;
            }
            if (a != null && b != null) {
                if (c == null) {
                    if (VideoRecorderAdapter.h() && us.pinguo.svideo.utils.gles.d.a(v.a())) {
                        f9251f = true;
                    } else {
                        f9251f = false;
                    }
                    us.pinguo.common.log.a.k("useGlBlitFramebuffer:" + f9251f, new Object[0]);
                    if (b == null) {
                        us.pinguo.common.log.a.k("surface还未创建好，return", new Object[0]);
                        return;
                    }
                    a(b);
                }
                if (n == null) {
                    n = new b(i3, i4);
                }
                if (c != null && f9252g != null) {
                    g gVar = a;
                    if (gVar != null) {
                        gVar.e(false, null, null, 0L);
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    int i5 = f9250e;
                    int i6 = i4 == i3 ? i5 : f9249d;
                    if (f9251f) {
                        c(i2, i5, i6, i3, i4);
                    } else {
                        b(i2);
                    }
                    SVideoUtil.h(System.nanoTime());
                    c.e();
                    EGL10 egl10 = f9252g;
                    EGLDisplay eGLDisplay = f9253h;
                    EGLSurface eGLSurface = f9254i;
                    egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, f9255j);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    f9256k++;
                    f9257l = (int) (f9257l + (currentTimeMillis2 - currentTimeMillis));
                    us.pinguo.common.log.a.m("surfaceRecord", "record surface:" + (f9257l / f9256k) + "ms useGlBlitFramebuffer:" + f9251f + " record:" + i5 + "X" + i6 + " surface:" + i3 + "X" + i4, new Object[0]);
                    return;
                }
                return;
            }
            f9256k = 0;
            f9257l = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(Surface surface) {
        b = surface;
        SVideoUtil.c = true;
    }

    public static void f(int i2, int i3, int i4) {
        d(i2, i3, i4);
    }

    public static void g() {
        us.pinguo.svideo.utils.gles.b bVar = c;
        if (bVar != null) {
            bVar.d(true);
            c = null;
            EGL10 egl10 = f9252g;
            if (egl10 != null) {
                EGLDisplay eGLDisplay = f9253h;
                EGLSurface eGLSurface = f9254i;
                egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, f9255j);
            }
        }
        f9252g = null;
        f9255j = null;
        f9254i = null;
        f9253h = null;
        b = null;
        n = null;
    }

    public static void h() {
        us.pinguo.svideo.utils.gles.b bVar = c;
        if (bVar != null) {
            bVar.c(true);
            c = null;
        }
        f9252g = null;
        f9255j = null;
        f9254i = null;
        f9253h = null;
        b = null;
        n = null;
    }

    public static synchronized void i(g gVar, h hVar) {
        synchronized (d.class) {
            us.pinguo.common.log.a.k("setPreviewSurfaceListener+:" + gVar, new Object[0]);
            if (gVar == null) {
                m = true;
                a = null;
                us.pinguo.common.log.a.k("setPreviewSurfaceListener return", new Object[0]);
                if (!VideoEnding.a && c != null) {
                    h();
                }
                return;
            }
            m = false;
            a = gVar;
            if (hVar != null) {
                hVar.a(a.a);
            }
            us.pinguo.common.log.a.k("setPreviewSurfaceListener-", new Object[0]);
        }
    }
}
