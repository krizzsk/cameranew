package us.pinguo.camera2020.model.render;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.Size;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.f;
import us.pinguo.glrender.GLRender;
import us.pinguo.processor.k.b;
/* compiled from: ViewFinderRenderManager.kt */
/* loaded from: classes3.dex */
public final class c {
    private final us.pinguo.processor.k.b a;
    private GLRender b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private us.pinguo.camera2020.utils.c<Integer> f9200d;

    /* renamed from: e  reason: collision with root package name */
    private us.pinguo.camera2020.utils.c<Integer> f9201e;

    /* renamed from: f  reason: collision with root package name */
    private int f9202f;

    /* renamed from: g  reason: collision with root package name */
    private int f9203g;

    /* renamed from: h  reason: collision with root package name */
    private int f9204h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9205i;

    /* renamed from: j  reason: collision with root package name */
    private a f9206j;

    /* compiled from: ViewFinderRenderManager.kt */
    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    public c(Context context, us.pinguo.processor.k.b liveRenderer) {
        s.h(context, "context");
        s.h(liveRenderer, "liveRenderer");
        this.a = liveRenderer;
        this.b = new GLRender(context);
        this.c = -1;
        this.f9202f = -1;
        this.f9205i = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(c this$0) {
        s.h(this$0, "this$0");
        a aVar = this$0.f9206j;
        if (aVar == null) {
            return;
        }
        aVar.a();
    }

    public final void a() {
        this.b.c();
    }

    public final void b() {
        this.f9205i = false;
        us.pinguo.camera2020.utils.c<Integer> cVar = this.f9200d;
        if (cVar != null) {
            cVar.b();
        }
        us.pinguo.camera2020.utils.c<Integer> cVar2 = this.f9201e;
        if (cVar2 != null) {
            cVar2.b();
        }
        this.f9202f = -1;
    }

    public final void c(boolean z) {
        int a2;
        if (z) {
            int i2 = this.f9203g;
            int i3 = this.f9204h;
            if (i2 >= i3) {
                i2 = i3;
            }
            a2 = b.a.a(this.a, this.c, new Size(i2, i2), false, 4, null);
        } else {
            a2 = b.a.a(this.a, this.c, new Size(this.f9203g, this.f9204h), false, 4, null);
        }
        us.pinguo.camera2020.utils.c<Integer> cVar = this.f9201e;
        if (cVar != null) {
            cVar.c(Integer.valueOf(a2));
        }
        this.f9202f = a2;
        us.pinguo.common.log.a.q("doNativeFilterRender set texture=" + a2 + " native-step-2", new Object[0]);
    }

    public final void d() {
        this.f9205i = true;
    }

    public final int e() {
        Integer d2;
        int i2 = -1;
        if (this.f9205i) {
            us.pinguo.common.log.a.q("getCameraTexture:$ camera-step-2.5", new Object[0]);
            us.pinguo.camera2020.utils.c<Integer> cVar = this.f9200d;
            if (cVar != null && (d2 = cVar.d(33L)) != null) {
                i2 = d2.intValue();
            }
            us.pinguo.common.log.a.q("getCameraTexture:" + i2 + " camera-step-3", new Object[0]);
        }
        return i2;
    }

    public final int f() {
        us.pinguo.camera2020.utils.c<Integer> cVar = this.f9201e;
        Integer d2 = cVar == null ? null : cVar.d(1500L);
        int intValue = d2 == null ? this.f9202f : d2.intValue();
        us.pinguo.common.log.a.q("getFilterTextureId:" + intValue + " wait get native-step-3", new Object[0]);
        return intValue;
    }

    public final int g() {
        return this.f9204h;
    }

    public final int h() {
        return this.f9203g;
    }

    public final void i() {
        GLRender.f11126j.a();
    }

    public final void k() {
        if (this.f9205i) {
            us.pinguo.common.log.a.q("doGLRender start render", new Object[0]);
            if (this.b.f()) {
                if (!this.b.g()) {
                    this.b.d();
                    int e2 = this.b.e(this.f9203g, this.f9204h);
                    us.pinguo.camera2020.utils.c<Integer> cVar = this.f9200d;
                    if (cVar != null) {
                        cVar.c(Integer.valueOf(e2));
                    }
                    us.pinguo.common.log.a.c("makeCameraTexture new=" + e2 + " camera-step-2", new Object[0]);
                    this.a.init();
                    f.c(new Runnable() { // from class: us.pinguo.camera2020.model.render.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            c.l(c.this);
                        }
                    });
                } else {
                    int e3 = this.b.e(this.f9203g, this.f9204h);
                    us.pinguo.camera2020.utils.c<Integer> cVar2 = this.f9200d;
                    if (cVar2 != null) {
                        cVar2.c(Integer.valueOf(e3));
                    }
                    us.pinguo.common.log.a.q("makeCameraTexture=" + e3 + " camera-step-2", new Object[0]);
                }
            } else {
                us.pinguo.camera2020.utils.c<Integer> cVar3 = this.f9200d;
                if (cVar3 != null) {
                    cVar3.c(-1);
                }
            }
            this.b.j();
        }
    }

    public final void m() {
        if (this.f9205i) {
            this.f9200d = new us.pinguo.camera2020.utils.c<>();
            us.pinguo.common.log.a.q("requestCameraTexture camera-step-1", new Object[0]);
        }
    }

    public final void n(a aVar) {
        this.f9206j = aVar;
    }

    public final void o(SurfaceTexture surfaceTexture) {
        s.h(surfaceTexture, "surfaceTexture");
        this.b.h(surfaceTexture);
    }

    public final void p(int i2, int i3) {
        us.pinguo.common.log.a.c("setTextureSize start, target=(" + i2 + " x " + i3 + "), last=(" + this.f9203g + " x " + this.f9204h + ')', new Object[0]);
        if (i2 == this.f9203g && i3 == this.f9204h) {
            this.b.b();
            return;
        }
        this.b.a();
        this.f9203g = i2;
        this.f9204h = i3;
        this.b.i(i2, i3);
    }

    public final void q(int i2) {
        this.c = i2;
        this.f9201e = new us.pinguo.camera2020.utils.c<>();
        us.pinguo.common.log.a.q("setUnityTextureId:" + i2 + " native-step-1", new Object[0]);
    }
}
