package com.pinguo.album.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Matrix;
import android.opengl.GLSurfaceView;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.pinguo.album.animations.d;
import com.pinguo.album.opengles.h;
import com.pinguo.album.opengles.j;
import com.pinguo.album.opengles.l;
import com.pinguo.album.opengles.y;
import com.pinguo.album.views.b;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;
/* loaded from: classes3.dex */
public class GLRenderView extends GLSurfaceView implements GLSurfaceView.Renderer, com.pinguo.album.views.b {
    private GL11 a;
    private l b;
    private com.pinguo.album.views.a c;

    /* renamed from: d  reason: collision with root package name */
    private com.pinguo.album.common.c f6099d;

    /* renamed from: e  reason: collision with root package name */
    private int f6100e;

    /* renamed from: f  reason: collision with root package name */
    private Matrix f6101f;

    /* renamed from: g  reason: collision with root package name */
    private int f6102g;

    /* renamed from: h  reason: collision with root package name */
    private int f6103h;

    /* renamed from: i  reason: collision with root package name */
    private volatile boolean f6104i;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f6105j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f6106k;

    /* renamed from: l  reason: collision with root package name */
    private final ReentrantLock f6107l;
    private final Condition m;
    private boolean n;
    private final ArrayList<d> o;
    private final ArrayDeque<b.a> p;
    private final b q;
    private float[] r;
    private Runnable s;

    /* loaded from: classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GLRenderView.this.s();
        }
    }

    public GLRenderView(Context context) {
        this(context, null);
    }

    private void p() {
        int i2;
        int i3;
        this.f6103h &= -3;
        int width = getWidth();
        int height = getHeight();
        com.pinguo.album.common.c cVar = this.f6099d;
        if (cVar != null) {
            i2 = cVar.b();
            i3 = this.f6099d.a();
        } else {
            i2 = 0;
            i3 = 0;
        }
        if (this.f6100e != i3) {
            this.f6100e = i3;
            if (i3 % BaseBlurEffect.ROTATION_180 != 0) {
                this.f6101f.setRotate(i3);
                this.f6101f.preTranslate((-width) / 2, (-height) / 2);
                this.f6101f.postTranslate(height / 2, width / 2);
            } else {
                this.f6101f.setRotate(i3, width / 2, height / 2);
            }
        }
        this.f6102g = i2;
        if (this.f6100e % BaseBlurEffect.ROTATION_180 != 0) {
            height = width;
            width = height;
        }
        us.pinguo.common.log.a.k("layout content pane " + width + "x" + height + " (compensation " + this.f6100e + ")", new Object[0]);
        com.pinguo.album.views.a aVar = this.c;
        if (aVar == null || width == 0 || height == 0) {
            return;
        }
        aVar.r(0, 0, width, height);
    }

    private void q(GL10 gl10) {
        this.b.e();
        y.C();
        this.f6104i = false;
        com.pinguo.album.common.c cVar = this.f6099d;
        if ((cVar != null && this.f6102g != cVar.b()) || (this.f6103h & 2) != 0) {
            p();
        }
        this.b.s(-1);
        r(-this.f6100e);
        com.pinguo.album.views.a aVar = this.c;
        if (aVar != null) {
            aVar.y(this.b);
        } else {
            this.b.m();
        }
        this.b.b();
        if (!this.o.isEmpty()) {
            long a2 = com.pinguo.album.animations.c.a();
            int size = this.o.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.o.get(i2).k(a2);
            }
            this.o.clear();
        }
        if (y.G()) {
            requestRender();
        }
        synchronized (this.p) {
            if (!this.p.isEmpty()) {
                this.q.a();
            }
        }
    }

    private void r(int i2) {
        if (i2 == 0) {
            return;
        }
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        this.b.a(width, height);
        this.b.v(i2, 0.0f, 0.0f, 1.0f);
        if (i2 % BaseBlurEffect.ROTATION_180 != 0) {
            this.b.a(-height, -width);
        } else {
            this.b.a(-width, -height);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        super.requestRender();
    }

    @Override // com.pinguo.album.views.b
    public int a() {
        return this.f6100e;
    }

    @Override // com.pinguo.album.views.b
    public int b() {
        return this.f6102g;
    }

    @Override // com.pinguo.album.views.b
    public void c() {
        this.f6107l.lock();
    }

    @Override // com.pinguo.album.views.b
    public void d() {
        this.f6107l.lock();
        this.n = false;
        this.m.signalAll();
        this.f6107l.unlock();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (isEnabled()) {
            int action = motionEvent.getAction();
            if (action != 3 && action != 1) {
                if (!this.f6106k && action != 0) {
                    return false;
                }
            } else {
                this.f6106k = false;
            }
            if (this.f6100e != 0) {
                motionEvent = com.pinguo.album.j.b.d(motionEvent, this.f6101f);
            }
            this.f6107l.lock();
            try {
                com.pinguo.album.views.a aVar = this.c;
                if (aVar != null && aVar.g(motionEvent)) {
                    z = true;
                }
                if (action == 0 && z) {
                    this.f6106k = true;
                }
                return z;
            } finally {
                this.f6107l.unlock();
            }
        }
        return false;
    }

    @Override // com.pinguo.album.views.b
    public void e() {
        this.f6107l.lock();
        this.n = true;
        this.f6107l.unlock();
    }

    @Override // com.pinguo.album.views.b
    public void f() {
        synchronized (this.p) {
            while (!this.p.isEmpty()) {
                this.p.removeLast().a();
            }
        }
    }

    @Override // com.pinguo.album.views.b
    public void g() {
        this.f6107l.unlock();
    }

    @Override // com.pinguo.album.views.b
    public void h() {
        this.f6107l.lock();
        try {
            if (this.c != null) {
                int i2 = this.f6103h;
                if ((i2 & 2) == 0 && (i2 & 1) != 0) {
                    this.f6103h = i2 | 2;
                    requestRender();
                }
            }
        } finally {
            this.f6107l.unlock();
        }
    }

    @Override // com.pinguo.album.views.b
    public void i() {
        this.f6104i = false;
        this.f6105j = true;
    }

    @Override // com.pinguo.album.views.b
    public void j(b.a aVar) {
        synchronized (this.p) {
            this.p.addLast(aVar);
            this.q.a();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        if (this.f6104i || !this.f6105j) {
            this.f6105j = false;
            float[] fArr = this.r;
            if (fArr != null) {
                gl10.glClearColor(fArr[1], fArr[2], fArr[3], fArr[0]);
            }
            com.pinguo.album.animations.c.c();
            this.f6107l.lock();
            while (this.n) {
                this.m.awaitUninterruptibly();
            }
            try {
                q(gl10);
            } finally {
                this.f6107l.unlock();
            }
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (z) {
            h();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        this.b.c(i2, i3);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GL11 gl11 = (GL11) gl10;
        if (this.a != null) {
            us.pinguo.common.log.a.k("GLObject has changed from " + this.a + " to " + gl11, new Object[0]);
        }
        this.f6107l.lock();
        try {
            this.a = gl11;
            this.b = com.pinguo.album.common.a.f6018g ? new j() : new h(gl11);
            com.pinguo.album.opengles.a.k();
            this.f6107l.unlock();
            setRenderMode(0);
        } catch (Throwable th) {
            this.f6107l.unlock();
            throw th;
        }
    }

    @Override // android.opengl.GLSurfaceView, com.pinguo.album.views.b
    @SuppressLint({"NewApi"})
    public void requestRender() {
        if (this.f6104i) {
            return;
        }
        this.f6104i = true;
        if (com.pinguo.album.common.a.f6017f) {
            postOnAnimation(this.s);
        } else {
            super.requestRender();
        }
    }

    @Override // com.pinguo.album.views.b
    public void setContentPane(com.pinguo.album.views.a aVar) {
        com.pinguo.album.views.a aVar2 = this.c;
        if (aVar2 == aVar) {
            return;
        }
        if (aVar2 != null) {
            if (this.f6106k) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.c.g(obtain);
                obtain.recycle();
                this.f6106k = false;
            }
            this.c.f();
            com.pinguo.album.opengles.a.t();
        }
        this.c = aVar;
        if (aVar != null) {
            aVar.d(this);
            h();
        }
    }

    @Override // com.pinguo.album.views.b
    public void setContentPaneBackground(float[] fArr) {
        this.r = fArr;
    }

    @Override // com.pinguo.album.views.b
    public void setOrientationSource(com.pinguo.album.common.c cVar) {
        this.f6099d = cVar;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        d();
        super.surfaceChanged(surfaceHolder, i2, i3, i4);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        d();
        super.surfaceCreated(surfaceHolder);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        d();
        super.surfaceDestroyed(surfaceHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements Runnable {
        private boolean a;

        private b() {
            this.a = false;
        }

        public void a() {
            if (this.a) {
                return;
            }
            this.a = true;
            GLRenderView.this.queueEvent(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (GLRenderView.this.p) {
                this.a = false;
                if (GLRenderView.this.p.isEmpty()) {
                    return;
                }
                b.a aVar = (b.a) GLRenderView.this.p.removeFirst();
                GLRenderView.this.f6107l.lock();
                try {
                    boolean b = aVar.b(GLRenderView.this.b, GLRenderView.this.f6104i);
                    GLRenderView.this.f6107l.unlock();
                    synchronized (GLRenderView.this.p) {
                        if (b) {
                            GLRenderView.this.p.addLast(aVar);
                        }
                        if (!GLRenderView.this.f6104i && !GLRenderView.this.p.isEmpty()) {
                            a();
                        }
                    }
                } catch (Throwable th) {
                    GLRenderView.this.f6107l.unlock();
                    throw th;
                }
            }
        }

        /* synthetic */ b(GLRenderView gLRenderView, a aVar) {
            this();
        }
    }

    public GLRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6101f = new Matrix();
        this.f6103h = 2;
        this.f6104i = false;
        this.f6105j = false;
        this.f6106k = false;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f6107l = reentrantLock;
        this.m = reentrantLock.newCondition();
        this.o = new ArrayList<>();
        this.p = new ArrayDeque<>();
        this.q = new b(this, null);
        this.s = new a();
        this.f6103h |= 1;
        setEGLContextClientVersion(com.pinguo.album.common.a.f6018g ? 2 : 1);
        boolean z = com.pinguo.album.common.a.b;
        if (z) {
            setEGLConfigChooser(8, 8, 8, 0, 0, 0);
        } else {
            setEGLConfigChooser(5, 6, 5, 0, 0, 0);
        }
        setRenderer(this);
        if (z) {
            getHolder().setFormat(3);
        } else {
            getHolder().setFormat(4);
        }
    }
}
