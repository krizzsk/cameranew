package us.pinguo.glrender;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: GLRender.kt */
/* loaded from: classes4.dex */
public final class GLRender {

    /* renamed from: j  reason: collision with root package name */
    public static final a f11126j = new a(null);
    private final Context a;
    private SurfaceTexture b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f11127d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11128e;

    /* renamed from: f  reason: collision with root package name */
    private Texture2DExt f11129f;

    /* renamed from: g  reason: collision with root package name */
    private b f11130g;

    /* renamed from: h  reason: collision with root package name */
    private us.pinguo.glrender.a f11131h;

    /* renamed from: i  reason: collision with root package name */
    private float[] f11132i;

    /* compiled from: GLRender.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final void a() {
            us.pinguo.glrender.a.c();
            b.a();
            Texture2DExt.a();
        }
    }

    public GLRender(Context context) {
        s.h(context, "context");
        this.a = context;
        this.f11132i = new float[16];
    }

    public final synchronized void a() {
        this.b = null;
        this.f11128e = false;
        this.f11129f = null;
        this.f11130g = null;
        this.c = 0;
        this.f11127d = 0;
        this.f11131h = null;
    }

    public final void b() {
        this.f11129f = null;
    }

    public final synchronized void c() {
        us.pinguo.common.log.a.c("clearSurfaceTexture", new Object[0]);
        this.f11128e = false;
        this.b = null;
    }

    public final void d() {
        Texture2DExt texture2DExt = new Texture2DExt(this.a);
        this.f11129f = texture2DExt;
        s.e(texture2DExt);
        us.pinguo.common.log.a.c(s.q("createTexture:", Integer.valueOf(texture2DExt.d())), new Object[0]);
    }

    public final synchronized int e(int i2, int i3) {
        Texture2DExt texture2DExt;
        int i4;
        int i5;
        int i6 = -1;
        if (this.b != null && (texture2DExt = this.f11129f) != null) {
            if (!this.f11128e) {
                s.e(texture2DExt);
                us.pinguo.common.log.a.c(s.q("attachToGLContext:", Integer.valueOf(texture2DExt.d())), new Object[0]);
                SurfaceTexture surfaceTexture = this.b;
                s.e(surfaceTexture);
                Texture2DExt texture2DExt2 = this.f11129f;
                s.e(texture2DExt2);
                surfaceTexture.attachToGLContext(texture2DExt2.d());
                this.f11128e = true;
            }
            Integer num = null;
            if (this.f11130g == null && (i4 = this.c) != 0 && (i5 = this.f11127d) != 0) {
                this.f11130g = new b(i4, i5);
                StringBuilder sb = new StringBuilder();
                sb.append("create output Texture2D:");
                b bVar = this.f11130g;
                sb.append(bVar == null ? null : Integer.valueOf(bVar.c()));
                sb.append(", width=");
                sb.append(this.c);
                sb.append(", height=");
                sb.append(this.f11127d);
                us.pinguo.common.log.a.c(sb.toString(), new Object[0]);
                this.f11131h = new us.pinguo.glrender.a(this.f11130g);
                us.pinguo.common.log.a.c("create FBO, width=" + this.c + ", height=" + this.f11127d, new Object[0]);
            }
            Matrix.setIdentityM(this.f11132i, 0);
            us.pinguo.glrender.a aVar = this.f11131h;
            if (aVar != null) {
                aVar.a();
            }
            GLES20.glViewport(0, 0, this.c, this.f11127d);
            Texture2DExt texture2DExt3 = this.f11129f;
            if (texture2DExt3 != null) {
                texture2DExt3.c(this.f11132i);
            }
            us.pinguo.glrender.a aVar2 = this.f11131h;
            if (aVar2 != null) {
                aVar2.b();
            }
            GLES20.glViewport(0, 0, i2, i3);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Render frame get madeImageTexture=");
            b bVar2 = this.f11130g;
            if (bVar2 != null) {
                num = Integer.valueOf(bVar2.c());
            }
            sb2.append(num);
            sb2.append(", targetSize=");
            sb2.append(i2);
            sb2.append(" x ");
            sb2.append(i3);
            us.pinguo.common.log.a.q(sb2.toString(), new Object[0]);
            b bVar3 = this.f11130g;
            if (bVar3 != null) {
                i6 = bVar3.c();
            }
            return i6;
        }
        us.pinguo.common.log.a.c("Render frame ignore cause input is null", new Object[0]);
        return -1;
    }

    public final boolean f() {
        return this.b != null;
    }

    public final boolean g() {
        return this.f11129f != null;
    }

    public final synchronized void h(SurfaceTexture surfaceTexture) {
        s.h(surfaceTexture, "surfaceTexture");
        us.pinguo.common.log.a.c("setInputSurfaceTexture", new Object[0]);
        if (!s.c(this.b, surfaceTexture)) {
            this.b = surfaceTexture;
            this.f11128e = false;
        }
    }

    public final void i(int i2, int i3) {
        us.pinguo.common.log.a.c("setInputTextureSize, width=" + i2 + ", height=" + i3, new Object[0]);
        this.c = i2;
        this.f11127d = i3;
    }

    public final synchronized void j() {
        Texture2DExt texture2DExt;
        int i2;
        int i3;
        us.pinguo.common.log.a.q("updateTexImage", new Object[0]);
        if (this.b != null && (texture2DExt = this.f11129f) != null) {
            if (!this.f11128e) {
                s.e(texture2DExt);
                us.pinguo.common.log.a.c(s.q("attachToGLContext:", Integer.valueOf(texture2DExt.d())), new Object[0]);
                SurfaceTexture surfaceTexture = this.b;
                s.e(surfaceTexture);
                Texture2DExt texture2DExt2 = this.f11129f;
                s.e(texture2DExt2);
                surfaceTexture.attachToGLContext(texture2DExt2.d());
                this.f11128e = true;
            }
            if (this.f11130g == null && (i2 = this.c) != 0 && (i3 = this.f11127d) != 0) {
                this.f11130g = new b(i2, i3);
                StringBuilder sb = new StringBuilder();
                sb.append("create output Texture2D:");
                b bVar = this.f11130g;
                sb.append(bVar == null ? null : Integer.valueOf(bVar.c()));
                sb.append(", width=");
                sb.append(this.c);
                sb.append(", height=");
                sb.append(this.f11127d);
                us.pinguo.common.log.a.c(sb.toString(), new Object[0]);
                this.f11131h = new us.pinguo.glrender.a(this.f11130g);
                us.pinguo.common.log.a.c("create FBO, width=" + this.c + ", height=" + this.f11127d, new Object[0]);
            }
            try {
                SurfaceTexture surfaceTexture2 = this.b;
                if (surfaceTexture2 != null) {
                    surfaceTexture2.updateTexImage();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
