package com.hw.photomovie.render;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes2.dex */
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: l  reason: collision with root package name */
    private static final k f5180l = new k();
    private final WeakReference<GLTextureView> a;
    private j b;
    private n c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5181d;

    /* renamed from: e  reason: collision with root package name */
    private f f5182e;

    /* renamed from: f  reason: collision with root package name */
    private g f5183f;

    /* renamed from: g  reason: collision with root package name */
    private h f5184g;

    /* renamed from: h  reason: collision with root package name */
    private l f5185h;

    /* renamed from: i  reason: collision with root package name */
    private int f5186i;

    /* renamed from: j  reason: collision with root package name */
    private int f5187j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5188k;

    /* loaded from: classes2.dex */
    private abstract class b implements f {
        protected int[] a;

        public b(int[] iArr) {
            this.a = c(iArr);
        }

        private int[] c(int[] iArr) {
            if (GLTextureView.this.f5187j == 2 || GLTextureView.this.f5187j == 3) {
                int length = iArr.length;
                int[] iArr2 = new int[length + 2];
                int i2 = length - 1;
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                iArr2[i2] = 12352;
                if (GLTextureView.this.f5187j == 2) {
                    iArr2[length] = 4;
                } else {
                    iArr2[length] = 64;
                }
                iArr2[length + 1] = 12344;
                return iArr2;
            }
            return iArr;
        }

        @Override // com.hw.photomovie.render.GLTextureView.f
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.a, null, 0, iArr)) {
                int i2 = iArr[0];
                if (i2 > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i2];
                    if (egl10.eglChooseConfig(eGLDisplay, this.a, eGLConfigArr, i2, iArr)) {
                        EGLConfig b = b(egl10, eGLDisplay, eGLConfigArr);
                        if (b != null) {
                            return b;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }

        abstract EGLConfig b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);
    }

    /* loaded from: classes2.dex */
    private class c extends b {
        private int[] c;

        /* renamed from: d  reason: collision with root package name */
        protected int f5189d;

        /* renamed from: e  reason: collision with root package name */
        protected int f5190e;

        /* renamed from: f  reason: collision with root package name */
        protected int f5191f;

        /* renamed from: g  reason: collision with root package name */
        protected int f5192g;

        /* renamed from: h  reason: collision with root package name */
        protected int f5193h;

        /* renamed from: i  reason: collision with root package name */
        protected int f5194i;

        public c(int i2, int i3, int i4, int i5, int i6, int i7) {
            super(new int[]{12324, i2, 12323, i3, 12322, i4, 12321, i5, 12325, i6, 12326, i7, 12344});
            this.c = new int[1];
            this.f5189d = i2;
            this.f5190e = i3;
            this.f5191f = i4;
            this.f5192g = i5;
            this.f5193h = i6;
            this.f5194i = i7;
        }

        private int d(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2, int i3) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, this.c) ? this.c[0] : i3;
        }

        @Override // com.hw.photomovie.render.GLTextureView.b
        public EGLConfig b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int d2 = d(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int d3 = d(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (d2 >= this.f5193h && d3 >= this.f5194i) {
                    int d4 = d(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int d5 = d(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int d6 = d(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int d7 = d(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (d4 == this.f5189d && d5 == this.f5190e && d6 == this.f5191f && d7 == this.f5192g) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    private class d implements g {
        private int a;

        private d() {
            this.a = 12440;
        }

        @Override // com.hw.photomovie.render.GLTextureView.g
        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
            StringBuilder sb = new StringBuilder();
            sb.append("tid=");
            sb.append(Thread.currentThread().getId());
            Log.i("DefaultContextFactory", sb.toString());
            i.k("eglDestroyContex", egl10.eglGetError());
            throw null;
        }

        @Override // com.hw.photomovie.render.GLTextureView.g
        public EGLContext b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.a, GLTextureView.this.f5187j, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.f5187j == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }
    }

    /* loaded from: classes2.dex */
    private static class e implements h {
        private e() {
        }

        @Override // com.hw.photomovie.render.GLTextureView.h
        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }

        @Override // com.hw.photomovie.render.GLTextureView.h
        public EGLSurface b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e2) {
                Log.e("GLSurfaceView", "eglCreateWindowSurface", e2);
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* loaded from: classes2.dex */
    public interface g {
        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);

        EGLContext b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);
    }

    /* loaded from: classes2.dex */
    public interface h {
        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);

        EGLSurface b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class i {
        private WeakReference<GLTextureView> a;
        EGL10 b;
        EGLDisplay c;

        /* renamed from: d  reason: collision with root package name */
        EGLSurface f5196d;

        /* renamed from: e  reason: collision with root package name */
        EGLConfig f5197e;

        /* renamed from: f  reason: collision with root package name */
        EGLContext f5198f;

        public i(WeakReference<GLTextureView> weakReference) {
            this.a = weakReference;
        }

        private void d() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.f5196d;
            if (eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                return;
            }
            this.b.eglMakeCurrent(this.c, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            GLTextureView gLTextureView = this.a.get();
            if (gLTextureView != null) {
                gLTextureView.f5184g.a(this.b, this.c, this.f5196d);
            }
            this.f5196d = null;
        }

        public static String f(String str, int i2) {
            return str + " failed: " + GLUtils.getEGLErrorString(i2);
        }

        public static void g(String str, String str2, int i2) {
            Log.w(str, f(str2, i2));
        }

        private void j(String str) {
            k(str, this.b.eglGetError());
            throw null;
        }

        public static void k(String str, int i2) {
            String f2 = f(str, i2);
            Log.e("EglHelper", "throwEglException tid=" + Thread.currentThread().getId() + " " + f2);
            throw new RuntimeException(f2);
        }

        GL a() {
            GL gl = this.f5198f.getGL();
            GLTextureView gLTextureView = this.a.get();
            if (gLTextureView != null) {
                if (gLTextureView.f5185h != null) {
                    gl = gLTextureView.f5185h.a(gl);
                }
                if ((gLTextureView.f5186i & 3) != 0) {
                    return GLDebugHelper.wrap(gl, (gLTextureView.f5186i & 1) != 0 ? 1 : 0, (gLTextureView.f5186i & 2) != 0 ? new m() : null);
                }
                return gl;
            }
            return gl;
        }

        public boolean b() {
            Log.w("EglHelper", "createSurface()  tid=" + Thread.currentThread().getId());
            if (this.b != null) {
                if (this.c != null) {
                    if (this.f5197e != null) {
                        d();
                        GLTextureView gLTextureView = this.a.get();
                        if (gLTextureView != null) {
                            this.f5196d = gLTextureView.f5184g.b(this.b, this.c, this.f5197e, gLTextureView.getSurfaceTexture());
                        } else {
                            this.f5196d = null;
                        }
                        EGLSurface eGLSurface = this.f5196d;
                        if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                            if (this.b.eglMakeCurrent(this.c, eGLSurface, eGLSurface, this.f5198f)) {
                                return true;
                            }
                            g("EGLHelper", "eglMakeCurrent", this.b.eglGetError());
                            return false;
                        }
                        if (this.b.eglGetError() == 12299) {
                            Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                        }
                        return false;
                    }
                    throw new RuntimeException("mEglConfig not initialized");
                }
                throw new RuntimeException("eglDisplay not initialized");
            }
            throw new RuntimeException("egl not initialized");
        }

        public void c() {
            Log.w("EglHelper", "destroySurface()  tid=" + Thread.currentThread().getId());
            d();
        }

        public void e() {
            Log.w("EglHelper", "finish() tid=" + Thread.currentThread().getId());
            if (this.f5198f != null) {
                GLTextureView gLTextureView = this.a.get();
                if (gLTextureView != null) {
                    gLTextureView.f5183f.a(this.b, this.c, this.f5198f);
                }
                this.f5198f = null;
            }
            EGLDisplay eGLDisplay = this.c;
            if (eGLDisplay != null) {
                this.b.eglTerminate(eGLDisplay);
                this.c = null;
            }
        }

        public void h() {
            Log.w("EglHelper", "start() tid=" + Thread.currentThread().getId());
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.b = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.c = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.b.eglInitialize(eglGetDisplay, new int[2])) {
                    GLTextureView gLTextureView = this.a.get();
                    if (gLTextureView != null) {
                        this.f5197e = gLTextureView.f5182e.a(this.b, this.c);
                        this.f5198f = gLTextureView.f5183f.b(this.b, this.c, this.f5197e);
                    } else {
                        this.f5197e = null;
                        this.f5198f = null;
                    }
                    EGLContext eGLContext = this.f5198f;
                    if (eGLContext != null && eGLContext != EGL10.EGL_NO_CONTEXT) {
                        Log.w("EglHelper", "createContext " + this.f5198f + " tid=" + Thread.currentThread().getId());
                        this.f5196d = null;
                        return;
                    }
                    this.f5198f = null;
                    j("createContext");
                    throw null;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public int i() {
            if (this.b.eglSwapBuffers(this.c, this.f5196d)) {
                return 12288;
            }
            return this.b.eglGetError();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class j extends Thread {
        private boolean a;
        private boolean b;
        private boolean c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f5199d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f5200e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f5201f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f5202g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f5203h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f5204i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f5205j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f5206k;
        private boolean q;
        private i u;
        private WeakReference<GLTextureView> v;
        private ArrayList<Runnable> r = new ArrayList<>();
        private boolean s = true;
        private Runnable t = null;

        /* renamed from: l  reason: collision with root package name */
        private int f5207l = 0;
        private int m = 0;
        private boolean o = true;
        private int n = 1;
        private boolean p = false;

        j(WeakReference<GLTextureView> weakReference) {
            this.v = weakReference;
        }

        /* JADX WARN: Removed duplicated region for block: B:190:0x0427 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:169:0x041e -> B:165:0x041a). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void d() throws java.lang.InterruptedException {
            /*
                Method dump skipped, instructions count: 1074
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hw.photomovie.render.GLTextureView.j.d():void");
        }

        private boolean h() {
            return !this.f5199d && this.f5200e && !this.f5201f && this.f5207l > 0 && this.m > 0 && (this.o || this.n == 1);
        }

        private void l() {
            if (this.f5203h) {
                this.u.e();
                this.f5203h = false;
                GLTextureView.f5180l.a(this);
            }
        }

        private void m() {
            if (this.f5204i) {
                this.f5204i = false;
                this.u.c();
            }
        }

        public boolean a() {
            return this.f5203h && this.f5204i && h();
        }

        public int c() {
            int i2;
            synchronized (GLTextureView.f5180l) {
                i2 = this.n;
            }
            return i2;
        }

        public void e() {
            synchronized (GLTextureView.f5180l) {
                Log.i("GLThread", "onPause tid=" + getId());
                this.c = true;
                GLTextureView.f5180l.notifyAll();
                while (!this.b && !this.f5199d) {
                    Log.i("Main thread", "onPause waiting for mPaused.");
                    try {
                        GLTextureView.f5180l.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void f() {
            synchronized (GLTextureView.f5180l) {
                Log.i("GLThread", "onResume tid=" + getId());
                this.c = false;
                this.o = true;
                this.q = false;
                GLTextureView.f5180l.notifyAll();
                while (!this.b && this.f5199d && !this.q) {
                    Log.i("Main thread", "onResume waiting for !mPaused.");
                    try {
                        GLTextureView.f5180l.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void g(int i2, int i3) {
            synchronized (GLTextureView.f5180l) {
                this.f5207l = i2;
                this.m = i3;
                this.s = true;
                this.o = true;
                this.q = false;
                if (Thread.currentThread() == this) {
                    return;
                }
                GLTextureView.f5180l.notifyAll();
                while (!this.b && !this.f5199d && !this.q && a()) {
                    Log.i("Main thread", "onWindowResize waiting for render complete from tid=" + getId());
                    try {
                        GLTextureView.f5180l.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void i() {
            synchronized (GLTextureView.f5180l) {
                this.a = true;
                GLTextureView.f5180l.notifyAll();
                while (!this.b) {
                    try {
                        GLTextureView.f5180l.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void j() {
            synchronized (GLTextureView.f5180l) {
                this.o = true;
                GLTextureView.f5180l.notifyAll();
            }
        }

        public void k(int i2) {
            if (i2 >= 0 && i2 <= 1) {
                synchronized (GLTextureView.f5180l) {
                    this.n = i2;
                    GLTextureView.f5180l.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public void n() {
            synchronized (GLTextureView.f5180l) {
                Log.i("GLThread", "surfaceCreated tid=" + getId());
                this.f5200e = true;
                this.f5205j = false;
                GLTextureView.f5180l.notifyAll();
                while (this.f5202g && !this.f5205j && !this.b) {
                    try {
                        GLTextureView.f5180l.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void o() {
            synchronized (GLTextureView.f5180l) {
                Log.i("GLThread", "surfaceDestroyed tid=" + getId());
                this.f5200e = false;
                GLTextureView.f5180l.notifyAll();
                while (!this.f5202g && !this.b) {
                    try {
                        GLTextureView.f5180l.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            Log.i("GLThread", "starting tid=" + getId());
            try {
                d();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                GLTextureView.f5180l.b(this);
                throw th;
            }
            GLTextureView.f5180l.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class k {
        private k() {
        }

        public void a(j jVar) {
            notifyAll();
        }

        public synchronized void b(j jVar) {
            Log.i("GLThread", "exiting tid=" + jVar.getId());
            jVar.b = true;
            notifyAll();
        }
    }

    /* loaded from: classes2.dex */
    public interface l {
        GL a(GL gl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class m extends Writer {
        private StringBuilder a = new StringBuilder();

        m() {
        }

        private void d() {
            if (this.a.length() > 0) {
                Log.v("GLSurfaceView", this.a.toString());
                StringBuilder sb = this.a;
                sb.delete(0, sb.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            d();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            d();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) {
            for (int i4 = 0; i4 < i3; i4++) {
                char c = cArr[i2 + i4];
                if (c == '\n') {
                    d();
                } else {
                    this.a.append(c);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface n {
        void a();

        boolean onDrawFrame(GL10 gl10);

        void onSurfaceChanged(GL10 gl10, int i2, int i3);

        void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig);
    }

    /* loaded from: classes2.dex */
    private class o extends c {
        public o(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    public GLTextureView(Context context) {
        super(context);
        this.a = new WeakReference<>(this);
        k();
    }

    private void j() {
        if (this.b != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private void k() {
        super.setSurfaceTextureListener(this);
    }

    protected void finalize() throws Throwable {
        try {
            j jVar = this.b;
            if (jVar != null) {
                jVar.i();
            }
        } finally {
            super.finalize();
        }
    }

    public void l() {
        this.b.e();
    }

    public void m() {
        this.b.f();
    }

    public void n() {
        this.b.j();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d("GLSurfaceView", "onAttachedToWindow reattach =" + this.f5181d);
        if (this.f5181d && this.c != null) {
            j jVar = this.b;
            int c2 = jVar != null ? jVar.c() : 1;
            j jVar2 = new j(this.a);
            this.b = jVar2;
            if (c2 != 1) {
                jVar2.k(c2);
            }
            this.b.start();
        }
        this.f5181d = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        Log.d("GLSurfaceView", "onDetachedFromWindow");
        j jVar = this.b;
        if (jVar != null) {
            jVar.i();
        }
        this.f5181d = true;
        super.onDetachedFromWindow();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.b.n();
        onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.b.o();
        n nVar = this.c;
        if (nVar != null) {
            nVar.a();
            return true;
        }
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.b.g(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setDebugFlags(int i2) {
        this.f5186i = i2;
    }

    public void setEGLConfigChooser(f fVar) {
        j();
        this.f5182e = fVar;
    }

    public void setEGLContextClientVersion(int i2) {
        j();
        this.f5187j = i2;
    }

    public void setEGLContextFactory(g gVar) {
        j();
        this.f5183f = gVar;
    }

    public void setEGLWindowSurfaceFactory(h hVar) {
        j();
        this.f5184g = hVar;
    }

    public void setGLWrapper(l lVar) {
        this.f5185h = lVar;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.f5188k = z;
    }

    public void setRenderMode(int i2) {
        this.b.k(i2);
    }

    public void setRenderer(n nVar) {
        j();
        if (this.f5182e == null) {
            this.f5182e = new o(true);
        }
        if (this.f5183f == null) {
            this.f5183f = new d();
        }
        if (this.f5184g == null) {
            this.f5184g = new e();
        }
        this.c = nVar;
        j jVar = new j(this.a);
        this.b = jVar;
        jVar.start();
    }

    @Override // android.view.TextureView
    @Deprecated
    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        Log.e("GLSurfaceView", "setSurfaceTextureListener preserved, setRenderer() instead?");
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new o(z));
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new WeakReference<>(this);
        k();
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new c(i2, i3, i4, i5, i6, i7));
    }
}
