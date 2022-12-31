package com.pinguo.album.opengles;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import androidx.work.Data;
import com.tencent.bugly.crashreport.CrashReport;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
/* compiled from: GLES20Canvas.java */
/* loaded from: classes3.dex */
public class j implements l {
    private static final float[] G = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    private static final m H = new k();
    private final float[] E;

    /* renamed from: f  reason: collision with root package name */
    private int f6076f;

    /* renamed from: g  reason: collision with root package name */
    private int f6077g;

    /* renamed from: i  reason: collision with root package name */
    private int f6079i;

    /* renamed from: j  reason: collision with root package name */
    private int f6080j;

    /* renamed from: k  reason: collision with root package name */
    private int f6081k;

    /* renamed from: l  reason: collision with root package name */
    private int f6082l;
    private int m;
    private int n;
    private int o;
    private float[] a = new float[128];
    private float[] b = new float[8];
    private us.pinguo.foundation.utils.r c = new us.pinguo.foundation.utils.r();

    /* renamed from: d  reason: collision with root package name */
    private int f6074d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f6075e = 0;

    /* renamed from: h  reason: collision with root package name */
    private float[] f6078h = new float[16];
    b[] p = {new a("aPosition"), new c("uMatrix"), new c("uColor")};
    b[] q = {new a("aPosition"), new c("uMatrix"), new c("uTextureMatrix"), new c("uTextureSampler"), new c("uAlpha")};
    b[] r = {new a("aPosition"), new c("uMatrix"), new c("uTextureMatrix"), new c("uTextureSampler"), new c("uAlpha")};
    b[] s = {new a("aPosition"), new c("uMatrix"), new a("aTextureCoordinate"), new c("uTextureSampler"), new c("uAlpha")};
    private final us.pinguo.foundation.utils.r t = new us.pinguo.foundation.utils.r();
    private final us.pinguo.foundation.utils.r u = new us.pinguo.foundation.utils.r();
    private int v = 0;
    private int w = 0;
    private int x = 0;
    private int[] y = new int[1];
    private ArrayList<q> z = new ArrayList<>();
    private final float[] A = new float[32];
    private final float[] B = new float[4];
    private final RectF C = new RectF();
    private final RectF D = new RectF();
    private final int[] F = new int[1];

    /* compiled from: GLES20Canvas.java */
    /* loaded from: classes3.dex */
    private static class a extends b {
        public a(String str) {
            super(str);
        }

        @Override // com.pinguo.album.opengles.j.b
        public void a(int i2) {
            this.a = GLES20.glGetAttribLocation(i2, this.b);
            j.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GLES20Canvas.java */
    /* loaded from: classes3.dex */
    public static abstract class b {
        public int a;
        protected final String b;

        public b(String str) {
            this.b = str;
        }

        public abstract void a(int i2);
    }

    /* compiled from: GLES20Canvas.java */
    /* loaded from: classes3.dex */
    private static class c extends b {
        public c(String str) {
            super(str);
        }

        @Override // com.pinguo.album.opengles.j.b
        public void a(int i2) {
            this.a = GLES20.glGetUniformLocation(i2, this.b);
            j.D();
        }
    }

    public j() {
        float[] fArr = new float[16];
        this.E = fArr;
        Matrix.setIdentityM(fArr, 0);
        Matrix.setIdentityM(this.a, this.f6075e);
        this.b[this.f6074d] = 1.0f;
        this.z.add(null);
        this.o = r(H(G));
        int Q = Q(35633, "uniform mat4 uMatrix;\nattribute vec2 aPosition;\nvoid main() {\n  vec4 pos = vec4(aPosition, 0.0, 1.0);\n  gl_Position = uMatrix * pos;\n}\n");
        int Q2 = Q(35633, "uniform mat4 uMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 pos = vec4(aPosition, 0.0, 1.0);\n  gl_Position = uMatrix * pos;\n  vTextureCoord = (uTextureMatrix * pos).xy;\n}\n");
        int Q3 = Q(35633, "uniform mat4 uMatrix;\nattribute vec2 aPosition;\nattribute vec2 aTextureCoordinate;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 pos = vec4(aPosition, 0.0, 1.0);\n  gl_Position = uMatrix * pos;\n  vTextureCoord = aTextureCoordinate;\n}\n");
        int Q4 = Q(35632, "precision mediump float;\nuniform vec4 uColor;\nvoid main() {\n  gl_FragColor = uColor;\n}\n");
        int Q5 = Q(35632, "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nuniform sampler2D uTextureSampler;\nvoid main() {\n  gl_FragColor = texture2D(uTextureSampler, vTextureCoord);\n  gl_FragColor *= uAlpha;\n}\n");
        int Q6 = Q(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nuniform samplerExternalOES uTextureSampler;\nvoid main() {\n  gl_FragColor = texture2D(uTextureSampler, vTextureCoord);\n  gl_FragColor *= uAlpha;\n}\n");
        this.f6081k = C(Q, Q4, this.p);
        this.f6082l = C(Q2, Q5, this.q);
        this.m = C(Q2, Q6, this.r);
        this.n = C(Q3, Q5, this.s);
        GLES20.glBlendFunc(1, 771);
        D();
    }

    private int C(int i2, int i3, b[] bVarArr) {
        int glCreateProgram = GLES20.glCreateProgram();
        D();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, i2);
            D();
            GLES20.glAttachShader(glCreateProgram, i3);
            D();
            GLES20.glLinkProgram(glCreateProgram);
            D();
            int[] iArr = this.F;
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                us.pinguo.common.log.a.e("Could not link program: ", new Object[0]);
                us.pinguo.common.log.a.e(GLES20.glGetProgramInfoLog(glCreateProgram), new Object[0]);
                GLES20.glDeleteProgram(glCreateProgram);
                glCreateProgram = 0;
            }
            for (b bVar : bVarArr) {
                bVar.a(glCreateProgram);
            }
            return glCreateProgram;
        }
        throw new RuntimeException("Cannot create GL program: " + GLES20.glGetError());
    }

    public static void D() {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Throwable th = new Throwable();
            us.pinguo.common.log.a.e("GL error: " + glGetError, th);
        }
    }

    private static void E() {
        String str;
        int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
        if (glCheckFramebufferStatus != 36053) {
            switch (glCheckFramebufferStatus) {
                case 36054:
                    str = "GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT";
                    break;
                case 36055:
                    str = "GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT";
                    break;
                case 36057:
                    str = "GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS";
                    break;
                case 36061:
                    str = "GL_FRAMEBUFFER_UNSUPPORTED";
                    break;
                default:
                    str = "";
                    break;
            }
            throw new RuntimeException(str + ":" + Integer.toHexString(glCheckFramebufferStatus));
        }
    }

    private static void F(RectF rectF, RectF rectF2, com.pinguo.album.opengles.a aVar) {
        int width = aVar.getWidth();
        int height = aVar.getHeight();
        int h2 = aVar.h();
        int g2 = aVar.g();
        float f2 = h2;
        rectF.left /= f2;
        float f3 = rectF.right / f2;
        rectF.right = f3;
        float f4 = g2;
        rectF.top /= f4;
        rectF.bottom /= f4;
        float f5 = width / f2;
        if (f3 > f5) {
            rectF2.right = rectF2.left + ((rectF2.width() * (f5 - rectF.left)) / rectF.width());
            rectF.right = f5;
        }
        float f6 = height / f4;
        if (rectF.bottom > f6) {
            rectF2.bottom = rectF2.top + ((rectF2.height() * (f6 - rectF.top)) / rectF.height());
            rectF.bottom = f6;
        }
    }

    private static void G(com.pinguo.album.opengles.a aVar, RectF rectF) {
        int width = aVar.getWidth();
        int height = aVar.getHeight();
        int i2 = 1;
        int i3 = 0;
        if (aVar.i()) {
            width--;
            height--;
            i3 = 1;
        } else {
            i2 = 0;
        }
        rectF.set(i2, i3, width, height);
    }

    private static FloatBuffer H(float[] fArr) {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(fArr, 0, fArr.length).position(0);
        return asFloatBuffer;
    }

    private void I(int i2, int i3, int i4, float f2, float f3, float f4, float f5, int i5, float f6) {
        R(i3, i5, f6);
        J(this.p, i2, i4, f2, f3, f4, f5);
    }

    private void J(b[] bVarArr, int i2, int i3, float f2, float f3, float f4, float f5) {
        U(bVarArr, f2, f3, f4, f5);
        int i4 = bVarArr[0].a;
        GLES20.glEnableVertexAttribArray(i4);
        D();
        GLES20.glDrawArrays(i2, 0, i3);
        D();
        GLES20.glDisableVertexAttribArray(i4);
        D();
    }

    private void K(com.pinguo.album.opengles.a aVar, RectF rectF, RectF rectF2) {
        X(rectF);
        L(aVar, this.E, rectF2);
    }

    private void L(com.pinguo.album.opengles.a aVar, float[] fArr, RectF rectF) {
        b[] T = T(aVar);
        V(T, 0);
        GLES20.glUniformMatrix4fv(T[2].a, 1, false, fArr, 0);
        D();
        if (aVar.l()) {
            s(2);
            a(0.0f, rectF.centerY());
            k(1.0f, -1.0f, 1.0f);
            a(0.0f, -rectF.centerY());
        }
        J(T, 5, 4, rectF.left, rectF.top, rectF.width(), rectF.height());
        if (aVar.l()) {
            b();
        }
        this.w++;
    }

    private void M(boolean z) {
        if (z) {
            GLES20.glEnable(3042);
            D();
            return;
        }
        GLES20.glDisable(3042);
        D();
    }

    private float[] O(int i2) {
        float N = (((i2 >>> 24) & 255) / 255.0f) * N();
        float[] fArr = this.B;
        fArr[0] = (((i2 >>> 16) & 255) / 255.0f) * N;
        fArr[1] = (((i2 >>> 8) & 255) / 255.0f) * N;
        fArr[2] = ((i2 & 255) / 255.0f) * N;
        fArr[3] = N;
        return fArr;
    }

    private q P() {
        ArrayList<q> arrayList = this.z;
        return arrayList.get(arrayList.size() - 1);
    }

    private static int Q(int i2, String str) {
        int glCreateShader = GLES20.glCreateShader(i2);
        GLES20.glShaderSource(glCreateShader, str);
        D();
        GLES20.glCompileShader(glCreateShader);
        D();
        return glCreateShader;
    }

    private void R(int i2, int i3, float f2) {
        GLES20.glUseProgram(this.f6081k);
        D();
        if (f2 > 0.0f) {
            GLES20.glLineWidth(f2);
            D();
        }
        float[] O = O(i3);
        boolean z = O[3] < 1.0f;
        M(z);
        if (z) {
            GLES20.glBlendColor(O[0], O[1], O[2], O[3]);
            D();
        }
        GLES20.glUniform4fv(this.p[2].a, 1, O, 0);
        V(this.p, i2);
        D();
    }

    private void S(com.pinguo.album.opengles.a aVar, int i2, b[] bVarArr) {
        GLES20.glUseProgram(i2);
        D();
        M(!aVar.b() || N() < 0.95f);
        GLES20.glActiveTexture(33984);
        D();
        aVar.n(this);
        GLES20.glBindTexture(aVar.f(), aVar.e());
        D();
        GLES20.glUniform1i(bVarArr[3].a, 0);
        D();
        GLES20.glUniform1f(bVarArr[4].a, N());
        D();
    }

    private b[] T(com.pinguo.album.opengles.a aVar) {
        b[] bVarArr;
        int i2;
        if (aVar.f() == 3553) {
            bVarArr = this.q;
            i2 = this.f6082l;
        } else {
            bVarArr = this.r;
            i2 = this.m;
        }
        S(aVar, i2, bVarArr);
        return bVarArr;
    }

    private void U(b[] bVarArr, float f2, float f3, float f4, float f5) {
        Matrix.translateM(this.A, 0, this.a, this.f6075e, f2, f3, 0.0f);
        Matrix.scaleM(this.A, 0, f4, f5, 1.0f);
        float[] fArr = this.A;
        Matrix.multiplyMM(fArr, 16, this.f6078h, 0, fArr, 0);
        GLES20.glUniformMatrix4fv(bVarArr[1].a, 1, false, this.A, 16);
        D();
    }

    private void V(b[] bVarArr, int i2) {
        GLES20.glBindBuffer(34962, this.o);
        D();
        GLES20.glVertexAttribPointer(bVarArr[0].a, 2, 5126, false, 8, i2 * 8);
        D();
        GLES20.glBindBuffer(34962, 0);
        D();
    }

    private void W(com.pinguo.album.opengles.a aVar, q qVar) {
        if (aVar == null && qVar != null) {
            GLES20.glGenFramebuffers(1, this.y, 0);
            D();
            GLES20.glBindFramebuffer(36160, this.y[0]);
            D();
        } else if (aVar != null && qVar == null) {
            GLES20.glBindFramebuffer(36160, 0);
            D();
            GLES20.glDeleteFramebuffers(1, this.y, 0);
            D();
        }
        if (qVar == null) {
            c(this.f6079i, this.f6080j);
            return;
        }
        c(qVar.getWidth(), qVar.getHeight());
        if (!qVar.m()) {
            qVar.u(this);
        }
        GLES20.glFramebufferTexture2D(36160, 36064, qVar.f(), qVar.e(), 0);
        D();
        E();
    }

    private void X(RectF rectF) {
        this.E[0] = rectF.width();
        this.E[5] = rectF.height();
        float[] fArr = this.E;
        fArr[12] = rectF.left;
        fArr[13] = rectF.top;
    }

    private int Y(Buffer buffer, int i2) {
        H.a(1, this.F, 0);
        D();
        int i3 = this.F[0];
        GLES20.glBindBuffer(34962, i3);
        D();
        GLES20.glBufferData(34962, buffer.capacity() * i2, buffer, 35044);
        D();
        return i3;
    }

    @Override // com.pinguo.album.opengles.l
    public void A(com.pinguo.album.opengles.a aVar, int i2, int i3, int i4, int i5, int i6, int i7) {
        S(aVar, this.n, this.s);
        GLES20.glBindBuffer(34963, i6);
        D();
        GLES20.glBindBuffer(34962, i4);
        D();
        int i8 = this.s[0].a;
        GLES20.glVertexAttribPointer(i8, 2, 5126, false, 8, 0);
        D();
        GLES20.glBindBuffer(34962, i5);
        D();
        int i9 = this.s[2].a;
        GLES20.glVertexAttribPointer(i9, 2, 5126, false, 8, 0);
        D();
        GLES20.glBindBuffer(34962, 0);
        D();
        GLES20.glEnableVertexAttribArray(i8);
        D();
        GLES20.glEnableVertexAttribArray(i9);
        D();
        U(this.s, i2, i3, 1.0f, 1.0f);
        GLES20.glDrawElements(5, i7, 5121, 0);
        D();
        GLES20.glDisableVertexAttribArray(i8);
        D();
        GLES20.glDisableVertexAttribArray(i9);
        D();
        GLES20.glBindBuffer(34963, 0);
        D();
        this.v++;
    }

    @Override // com.pinguo.album.opengles.l
    public void B(float[] fArr) {
        GLES20.glClearColor(fArr[1], fArr[2], fArr[3], fArr[0]);
        D();
        GLES20.glClear(16384);
        D();
    }

    public float N() {
        return this.b[this.f6074d];
    }

    @Override // com.pinguo.album.opengles.l
    public void a(float f2, float f3) {
        int i2 = this.f6075e;
        float[] fArr = this.a;
        int i3 = i2 + 12;
        fArr[i3] = fArr[i3] + (fArr[i2 + 0] * f2) + (fArr[i2 + 4] * f3);
        int i4 = i2 + 13;
        fArr[i4] = fArr[i4] + (fArr[i2 + 1] * f2) + (fArr[i2 + 5] * f3);
        int i5 = i2 + 14;
        fArr[i5] = fArr[i5] + (fArr[i2 + 2] * f2) + (fArr[i2 + 6] * f3);
        int i6 = i2 + 15;
        fArr[i6] = fArr[i6] + (fArr[i2 + 3] * f2) + (fArr[i2 + 7] * f3);
    }

    @Override // com.pinguo.album.opengles.l
    public void b() {
        int d2 = this.c.d();
        if ((d2 & 1) == 1) {
            this.f6074d--;
        }
        if ((d2 & 2) == 2) {
            this.f6075e -= 16;
        }
    }

    @Override // com.pinguo.album.opengles.l
    public void c(int i2, int i3) {
        this.f6076f = i2;
        this.f6077g = i3;
        GLES20.glViewport(0, 0, i2, i3);
        D();
        Matrix.setIdentityM(this.a, this.f6075e);
        float f2 = i3;
        Matrix.orthoM(this.f6078h, 0, 0.0f, i2, 0.0f, f2, -1.0f, 1.0f);
        if (P() == null) {
            this.f6079i = i2;
            this.f6080j = i3;
            Matrix.translateM(this.a, this.f6075e, 0.0f, f2, 0.0f);
            Matrix.scaleM(this.a, this.f6075e, 1.0f, -1.0f, 1.0f);
        }
    }

    @Override // com.pinguo.album.opengles.l
    public void d() {
        s(-1);
    }

    @Override // com.pinguo.album.opengles.l
    public void e() {
        synchronized (this.t) {
            us.pinguo.foundation.utils.r rVar = this.t;
            if (rVar.e() > 0) {
                H.d(null, rVar.e(), rVar.c(), 0);
                rVar.b();
            }
            us.pinguo.foundation.utils.r rVar2 = this.u;
            if (rVar2.e() > 0) {
                H.c(null, rVar2.e(), rVar2.c(), 0);
                rVar2.b();
            }
        }
    }

    @Override // com.pinguo.album.opengles.l
    public m f() {
        return H;
    }

    @Override // com.pinguo.album.opengles.l
    public void g(float f2, float f3, float f4, float f5, int i2) {
        I(5, 0, 4, f2, f3, f4, f5, i2, 0.0f);
        this.x++;
    }

    @Override // com.pinguo.album.opengles.l
    public int h(ByteBuffer byteBuffer) {
        return Y(byteBuffer, 1);
    }

    @Override // com.pinguo.album.opengles.l
    public void i(com.pinguo.album.opengles.a aVar, RectF rectF, RectF rectF2) {
        if (rectF2.width() <= 0.0f || rectF2.height() <= 0.0f) {
            return;
        }
        this.C.set(rectF);
        this.D.set(rectF2);
        F(this.C, this.D, aVar);
        K(aVar, this.C, this.D);
    }

    @Override // com.pinguo.album.opengles.l
    public void j(float[] fArr, int i2) {
        float[] fArr2 = this.A;
        float[] fArr3 = this.a;
        int i3 = this.f6075e;
        Matrix.multiplyMM(fArr2, 0, fArr3, i3, fArr, i2);
        System.arraycopy(fArr2, 0, fArr3, i3, 16);
    }

    @Override // com.pinguo.album.opengles.l
    public void k(float f2, float f3, float f4) {
        Matrix.scaleM(this.a, this.f6075e, f2, f3, f4);
    }

    @Override // com.pinguo.album.opengles.l
    public void l(com.pinguo.album.opengles.a aVar, int i2, int i3, int i4, int i5) {
        if (i4 <= 0 || i5 <= 0) {
            return;
        }
        G(aVar, this.C);
        this.D.set(i2, i3, i2 + i4, i3 + i5);
        F(this.C, this.D, aVar);
        K(aVar, this.C, this.D);
    }

    @Override // com.pinguo.album.opengles.l
    public void m() {
        D();
        GLES20.glClear(16384);
        D();
    }

    @Override // com.pinguo.album.opengles.l
    public void n(int i2) {
        synchronized (this.t) {
            this.u.a(i2);
        }
    }

    @Override // com.pinguo.album.opengles.l
    public boolean o(com.pinguo.album.opengles.a aVar) {
        boolean m = aVar.m();
        if (m) {
            synchronized (this.t) {
                this.t.a(aVar.e());
            }
        }
        return m;
    }

    @Override // com.pinguo.album.opengles.l
    public void p(float f2, float f3, float f4) {
        Matrix.translateM(this.a, this.f6075e, f2, f3, f4);
    }

    @Override // com.pinguo.album.opengles.l
    public void q(q qVar) {
        d();
        q P = P();
        this.z.add(qVar);
        W(P, qVar);
    }

    @Override // com.pinguo.album.opengles.l
    public int r(FloatBuffer floatBuffer) {
        return Y(floatBuffer, 4);
    }

    @Override // com.pinguo.album.opengles.l
    public void s(int i2) {
        if ((i2 & 1) == 1) {
            float N = N();
            int i3 = this.f6074d + 1;
            this.f6074d = i3;
            float[] fArr = this.b;
            if (fArr.length <= i3) {
                this.b = Arrays.copyOf(fArr, fArr.length * 2);
            }
            this.b[this.f6074d] = N;
        }
        if ((i2 & 2) == 2) {
            int i4 = this.f6075e;
            int i5 = i4 + 16;
            this.f6075e = i5;
            float[] fArr2 = this.a;
            if (fArr2.length <= i5) {
                this.a = Arrays.copyOf(fArr2, fArr2.length * 2);
            }
            float[] fArr3 = this.a;
            System.arraycopy(fArr3, i4, fArr3, this.f6075e, 16);
        }
        this.c.a(i2);
    }

    @Override // com.pinguo.album.opengles.l
    public void setAlpha(float f2) {
        this.b[this.f6074d] = f2;
    }

    @Override // com.pinguo.album.opengles.l
    public void t(com.pinguo.album.opengles.a aVar, int i2, int i3) {
        int f2 = aVar.f();
        GLES20.glBindTexture(f2, aVar.e());
        D();
        GLES20.glTexImage2D(f2, 0, i2, aVar.h(), aVar.g(), 0, i2, i3, null);
    }

    @Override // com.pinguo.album.opengles.l
    public void u(com.pinguo.album.opengles.a aVar, int i2, int i3, Bitmap bitmap, int i4, int i5) {
        int f2 = aVar.f();
        GLES20.glBindTexture(f2, aVar.e());
        D();
        if (bitmap == null) {
            CrashReport.postCatchedException(new NullPointerException("texSubImage2D can't be used with a null Bitmap"));
        } else if (bitmap.isRecycled()) {
            CrashReport.postCatchedException(new IllegalArgumentException("bitmap is recycled"));
        } else {
            GLUtils.texSubImage2D(f2, 0, i2, i3, bitmap, i4, i5);
        }
    }

    @Override // com.pinguo.album.opengles.l
    public void v(float f2, float f3, float f4, float f5) {
        if (f2 == 0.0f) {
            return;
        }
        float[] fArr = this.A;
        Matrix.setRotateM(fArr, 0, f2, f3, f4, f5);
        float[] fArr2 = this.a;
        int i2 = this.f6075e;
        Matrix.multiplyMM(fArr, 16, fArr2, i2, fArr, 0);
        System.arraycopy(fArr, 16, fArr2, i2, 16);
    }

    @Override // com.pinguo.album.opengles.l
    public void w() {
        ArrayList<q> arrayList = this.z;
        W(arrayList.remove(arrayList.size() - 1), P());
        b();
    }

    @Override // com.pinguo.album.opengles.l
    public void x(com.pinguo.album.opengles.a aVar, Bitmap bitmap) {
        int f2 = aVar.f();
        GLES20.glBindTexture(f2, aVar.e());
        D();
        GLUtils.texImage2D(f2, 0, bitmap, 0);
    }

    @Override // com.pinguo.album.opengles.l
    public void y(com.pinguo.album.opengles.a aVar) {
        int f2 = aVar.f();
        GLES20.glBindTexture(f2, aVar.e());
        D();
        GLES20.glTexParameteri(f2, 10242, 33071);
        GLES20.glTexParameteri(f2, 10243, 33071);
        GLES20.glTexParameterf(f2, 10241, 9729.0f);
        GLES20.glTexParameterf(f2, Data.MAX_DATA_BYTES, 9729.0f);
    }

    @Override // com.pinguo.album.opengles.l
    public void z(float f2) {
        setAlpha(N() * f2);
    }
}
