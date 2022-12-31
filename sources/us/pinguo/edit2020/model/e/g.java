package us.pinguo.edit2020.model.e;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.edit2020.model.e.e;
/* compiled from: TextureRender.kt */
/* loaded from: classes4.dex */
public final class g implements TextureView.SurfaceTextureListener {
    private int a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private SurfaceTexture f10560d;

    /* renamed from: f  reason: collision with root package name */
    private TextureView f10562f;

    /* renamed from: g  reason: collision with root package name */
    private h f10563g;

    /* renamed from: h  reason: collision with root package name */
    private f f10564h;

    /* renamed from: e  reason: collision with root package name */
    private long f10561e = -1;

    /* renamed from: i  reason: collision with root package name */
    private final Runnable f10565i = new Runnable() { // from class: us.pinguo.edit2020.model.e.a
        @Override // java.lang.Runnable
        public final void run() {
            g.k(g.this);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(g this$0) {
        s.h(this$0, "this$0");
        f fVar = this$0.f10564h;
        if (fVar == null) {
            return;
        }
        fVar.b();
    }

    private final boolean f() {
        return this.a != 0 && this.b > 0 && this.c > 0;
    }

    private final void i(kotlin.jvm.b.a<u> aVar) {
        SurfaceTexture surfaceTexture;
        if (f()) {
            h hVar = this.f10563g;
            if (hVar == null || (surfaceTexture = this.f10560d) == null) {
                return;
            }
            hVar.b(surfaceTexture);
            hVar.j(this.f10565i);
            hVar.h(this.f10565i, aVar);
            return;
        }
        h hVar2 = this.f10563g;
        if (hVar2 == null) {
            return;
        }
        hVar2.j(this.f10565i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void j(g gVar, kotlin.jvm.b.a aVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            aVar = null;
        }
        gVar.i(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(g this$0) {
        s.h(this$0, "this$0");
        f fVar = this$0.f10564h;
        if (fVar == null) {
            return;
        }
        fVar.f(this$0.a, this$0.b, this$0.c);
        fVar.c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void m(g gVar, kotlin.jvm.b.a aVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            aVar = null;
        }
        gVar.l(aVar);
    }

    public final void a() {
        h hVar = this.f10563g;
        if (hVar != null) {
            hVar.a();
        }
        this.f10563g = null;
        this.f10564h = null;
        TextureView textureView = this.f10562f;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(null);
        }
        o(null);
        SurfaceTexture surfaceTexture = this.f10560d;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        this.f10560d = null;
    }

    public final void b() {
        h hVar;
        h hVar2 = this.f10563g;
        if (hVar2 != null) {
            hVar2.d();
        }
        SurfaceTexture surfaceTexture = this.f10560d;
        if (surfaceTexture == null || (hVar = this.f10563g) == null) {
            return;
        }
        hVar.b(surfaceTexture);
    }

    public final void c() {
        this.f10564h = new f(true);
        this.f10563g = new h(new e.a() { // from class: us.pinguo.edit2020.model.e.b
            @Override // us.pinguo.edit2020.model.e.e.a
            public final void a() {
                g.d(g.this);
            }
        });
    }

    public final boolean e() {
        h hVar = this.f10563g;
        if (hVar == null) {
            return false;
        }
        return hVar.e();
    }

    public final void l(kotlin.jvm.b.a<u> aVar) {
        if (System.currentTimeMillis() - this.f10561e < 50) {
            us.pinguo.common.log.a.c("requestRender-skip", new Object[0]);
            return;
        }
        us.pinguo.common.log.a.c("requestRender-render", new Object[0]);
        i(aVar);
        this.f10561e = System.currentTimeMillis();
    }

    public final void n(int i2, int i3, int i4) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
    }

    public final void o(TextureView textureView) {
        this.f10562f = textureView;
        if (textureView == null) {
            return;
        }
        textureView.setSurfaceTextureListener(this);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int i2, int i3) {
        TextureView textureView;
        s.h(surface, "surface");
        f fVar = this.f10564h;
        if (fVar != null) {
            fVar.e(i2, i3);
        }
        SurfaceTexture surfaceTexture = this.f10560d;
        if (surfaceTexture == null) {
            this.f10560d = surface;
            j(this, null, 1, null);
        } else if (s.c(surfaceTexture, surface) || (textureView = this.f10562f) == null) {
        } else {
            textureView.setSurfaceTexture(surfaceTexture);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        s.h(surface, "surface");
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int i2, int i3) {
        s.h(surface, "surface");
        f fVar = this.f10564h;
        if (fVar == null) {
            return;
        }
        fVar.e(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        s.h(surface, "surface");
    }
}
