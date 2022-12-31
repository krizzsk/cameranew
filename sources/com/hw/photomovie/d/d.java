package com.hw.photomovie.d;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import androidx.work.Data;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
/* compiled from: GLES20Canvas.java */
/* loaded from: classes2.dex */
public class d implements f {
    private static final String B = "d";
    private static final float[] C = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    private static final g D = new e();

    /* renamed from: f  reason: collision with root package name */
    private int f5166f;

    /* renamed from: g  reason: collision with root package name */
    private int f5167g;

    /* renamed from: i  reason: collision with root package name */
    private int f5169i;

    /* renamed from: j  reason: collision with root package name */
    private int f5170j;

    /* renamed from: k  reason: collision with root package name */
    private int f5171k;

    /* renamed from: l  reason: collision with root package name */
    private int f5172l;
    private final float[] z;
    private float[] a = new float[128];
    private float[] b = new float[8];
    private com.hw.photomovie.util.a c = new com.hw.photomovie.util.a();

    /* renamed from: d  reason: collision with root package name */
    private int f5164d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f5165e = 0;

    /* renamed from: h  reason: collision with root package name */
    private float[] f5168h = new float[16];
    b[] m = {new a("aPosition"), new c("uMatrix"), new c("uColor")};
    b[] n = {new a("aPosition"), new c("uMatrix"), new c("uTextureMatrix"), new c("uTextureSampler"), new c("uAlpha")};
    b[] o = {new a("aPosition"), new c("uMatrix"), new c("uTextureMatrix"), new c("uTextureSampler"), new c("uAlpha")};
    b[] p = {new a("aPosition"), new c("uMatrix"), new a("aTextureCoordinate"), new c("uTextureSampler"), new c("uAlpha")};
    private final com.hw.photomovie.util.a q = new com.hw.photomovie.util.a();
    private final com.hw.photomovie.util.a r = new com.hw.photomovie.util.a();
    private int s = 0;
    private int t = 0;
    private ArrayList<h> u = new ArrayList<>();
    private final float[] v = new float[32];
    private final float[] w = new float[4];
    private final RectF x = new RectF();
    private final RectF y = new RectF();
    private final int[] A = new int[1];

    /* compiled from: GLES20Canvas.java */
    /* loaded from: classes2.dex */
    private static class a extends b {
        public a(String str) {
            super(str);
        }

        @Override // com.hw.photomovie.d.d.b
        public void a(int i2) {
            this.a = GLES20.glGetAttribLocation(i2, this.b);
            d.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: GLES20Canvas.java */
    /* loaded from: classes2.dex */
    public static abstract class b {
        public int a;
        protected final String b;

        public b(String str) {
            this.b = str;
        }

        public abstract void a(int i2);
    }

    /* compiled from: GLES20Canvas.java */
    /* loaded from: classes2.dex */
    private static class c extends b {
        public c(String str) {
            super(str);
        }

        @Override // com.hw.photomovie.d.d.b
        public void a(int i2) {
            this.a = GLES20.glGetUniformLocation(i2, this.b);
            d.r();
        }
    }

    public d() {
        float[] fArr = new float[16];
        this.z = fArr;
        Matrix.setIdentityM(fArr, 0);
        Matrix.setIdentityM(this.a, this.f5165e);
        this.b[this.f5164d] = 1.0f;
        this.u.add(null);
        this.f5172l = N(u(C));
        int D2 = D(35633, "uniform mat4 uMatrix;\nattribute vec2 aPosition;\nvoid main() {\n  vec4 pos = vec4(aPosition, 0.0, 1.0);\n  gl_Position = uMatrix * pos;\n}\n");
        int D3 = D(35633, "uniform mat4 uMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 pos = vec4(aPosition, 0.0, 1.0);\n  gl_Position = uMatrix * pos;\n  vTextureCoord = (uTextureMatrix * pos).xy;\n}\n");
        int D4 = D(35633, "uniform mat4 uMatrix;\nattribute vec2 aPosition;\nattribute vec2 aTextureCoordinate;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 pos = vec4(aPosition, 0.0, 1.0);\n  gl_Position = uMatrix * pos;\n  vTextureCoord = aTextureCoordinate;\n}\n");
        int D5 = D(35632, "precision mediump float;\nuniform vec4 uColor;\nvoid main() {\n  gl_FragColor = uColor;\n}\n");
        int D6 = D(35632, "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nuniform sampler2D uTextureSampler;\nvoid main() {\n  gl_FragColor = texture2D(uTextureSampler, vTextureCoord);\n  gl_FragColor *= uAlpha;\n}\n");
        int D7 = D(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nuniform samplerExternalOES uTextureSampler;\nvoid main() {\n  gl_FragColor = texture2D(uTextureSampler, vTextureCoord);\n  gl_FragColor *= uAlpha;\n}\n");
        this.f5169i = q(D2, D5, this.m);
        this.f5170j = q(D3, D6, this.n);
        this.f5171k = q(D3, D7, this.o);
        q(D4, D6, this.p);
        GLES20.glBlendFunc(1, 771);
        r();
    }

    private float[] B(int i2) {
        float A = (((i2 >>> 24) & 255) / 255.0f) * A();
        float[] fArr = this.w;
        fArr[0] = (((i2 >>> 16) & 255) / 255.0f) * A;
        fArr[1] = (((i2 >>> 8) & 255) / 255.0f) * A;
        fArr[2] = ((i2 & 255) / 255.0f) * A;
        fArr[3] = A;
        return fArr;
    }

    private h C() {
        ArrayList<h> arrayList = this.u;
        return arrayList.get(arrayList.size() - 1);
    }

    private static int D(int i2, String str) {
        int glCreateShader = GLES20.glCreateShader(i2);
        GLES20.glShaderSource(glCreateShader, str);
        r();
        GLES20.glCompileShader(glCreateShader);
        r();
        return glCreateShader;
    }

    private void E(int i2, int i3, float f2) {
        GLES20.glUseProgram(this.f5169i);
        r();
        if (f2 > 0.0f) {
            GLES20.glLineWidth(f2);
            r();
        }
        float[] B2 = B(i3);
        boolean z = B2[3] < 1.0f;
        z(z);
        if (z) {
            GLES20.glBlendColor(B2[0], B2[1], B2[2], B2[3]);
            r();
        }
        GLES20.glUniform4fv(this.m[2].a, 1, B2, 0);
        K(this.m, i2);
        r();
    }

    private void F(com.hw.photomovie.d.a aVar, int i2, b[] bVarArr) {
        GLES20.glUseProgram(i2);
        r();
        z(!aVar.b() || A() < 0.95f);
        GLES20.glActiveTexture(33984);
        r();
        aVar.l(this);
        GLES20.glBindTexture(aVar.e(), aVar.d());
        r();
        GLES20.glUniform1i(bVarArr[3].a, 0);
        r();
        GLES20.glUniform1f(bVarArr[4].a, A());
        r();
    }

    private void J(b[] bVarArr, float f2, float f3, float f4, float f5) {
        Matrix.translateM(this.v, 0, this.a, this.f5165e, f2, f3, 0.0f);
        Matrix.scaleM(this.v, 0, f4, f5, 1.0f);
        float[] fArr = this.v;
        Matrix.multiplyMM(fArr, 16, this.f5168h, 0, fArr, 0);
        GLES20.glUniformMatrix4fv(bVarArr[1].a, 1, false, this.v, 16);
        r();
    }

    private void K(b[] bVarArr, int i2) {
        GLES20.glBindBuffer(34962, this.f5172l);
        r();
        GLES20.glVertexAttribPointer(bVarArr[0].a, 2, 5126, false, 8, i2 * 8);
        r();
        GLES20.glBindBuffer(34962, 0);
        r();
    }

    private void L(RectF rectF) {
        this.z[0] = rectF.width();
        this.z[5] = rectF.height();
        float[] fArr = this.z;
        fArr[12] = rectF.left;
        fArr[13] = rectF.top;
    }

    private int M(Buffer buffer, int i2) {
        D.a(1, this.A, 0);
        r();
        int i3 = this.A[0];
        GLES20.glBindBuffer(34962, i3);
        r();
        GLES20.glBufferData(34962, buffer.capacity() * i2, buffer, 35044);
        r();
        return i3;
    }

    private int q(int i2, int i3, b[] bVarArr) {
        int glCreateProgram = GLES20.glCreateProgram();
        r();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, i2);
            r();
            GLES20.glAttachShader(glCreateProgram, i3);
            r();
            GLES20.glLinkProgram(glCreateProgram);
            r();
            int[] iArr = this.A;
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                String str = B;
                com.hw.photomovie.util.b.a(str, "Could not link program: ");
                com.hw.photomovie.util.b.a(str, GLES20.glGetProgramInfoLog(glCreateProgram));
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

    public static void r() {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Throwable th = new Throwable();
            String str = B;
            com.hw.photomovie.util.b.b(str, "GL error: " + glGetError, th);
        }
    }

    private static void s(RectF rectF, RectF rectF2, com.hw.photomovie.d.a aVar) {
        int h2 = aVar.h();
        int c2 = aVar.c();
        int g2 = aVar.g();
        int f2 = aVar.f();
        float f3 = g2;
        rectF.left /= f3;
        float f4 = rectF.right / f3;
        rectF.right = f4;
        float f5 = f2;
        rectF.top /= f5;
        rectF.bottom /= f5;
        float f6 = h2 / f3;
        if (f4 > f6) {
            rectF2.right = rectF2.left + ((rectF2.width() * (f6 - rectF.left)) / rectF.width());
            rectF.right = f6;
        }
        float f7 = c2 / f5;
        if (rectF.bottom > f7) {
            rectF2.bottom = rectF2.top + ((rectF2.height() * (f7 - rectF.top)) / rectF.height());
            rectF.bottom = f7;
        }
    }

    private static void t(com.hw.photomovie.d.a aVar, RectF rectF) {
        int h2 = aVar.h();
        int c2 = aVar.c();
        int i2 = 1;
        int i3 = 0;
        if (aVar.i()) {
            h2--;
            c2--;
            i3 = 1;
        } else {
            i2 = 0;
        }
        rectF.set(i2, i3, h2, c2);
    }

    private static FloatBuffer u(float[] fArr) {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(fArr, 0, fArr.length).position(0);
        return asFloatBuffer;
    }

    private void v(int i2, int i3, int i4, float f2, float f3, float f4, float f5, int i5, float f6) {
        E(i3, i5, f6);
        w(this.m, i2, i4, f2, f3, f4, f5);
    }

    private void w(b[] bVarArr, int i2, int i3, float f2, float f3, float f4, float f5) {
        J(bVarArr, f2, f3, f4, f5);
        int i4 = bVarArr[0].a;
        GLES20.glEnableVertexAttribArray(i4);
        r();
        GLES20.glDrawArrays(i2, 0, i3);
        r();
        GLES20.glDisableVertexAttribArray(i4);
        r();
    }

    private void x(com.hw.photomovie.d.a aVar, RectF rectF, RectF rectF2) {
        L(rectF);
        y(aVar, this.z, rectF2);
    }

    private void y(com.hw.photomovie.d.a aVar, float[] fArr, RectF rectF) {
        b[] G = G(aVar);
        K(G, 0);
        GLES20.glUniformMatrix4fv(G[2].a, 1, false, fArr, 0);
        r();
        if (aVar.j()) {
            H(2);
            a(0.0f, rectF.centerY());
            I(1.0f, -1.0f, 1.0f);
            a(0.0f, -rectF.centerY());
        }
        w(G, 5, 4, rectF.left, rectF.top, rectF.width(), rectF.height());
        if (aVar.j()) {
            b();
        }
        this.s++;
    }

    private void z(boolean z) {
        if (z) {
            GLES20.glEnable(3042);
            r();
            return;
        }
        GLES20.glDisable(3042);
        r();
    }

    public float A() {
        return this.b[this.f5164d];
    }

    protected b[] G(com.hw.photomovie.d.a aVar) {
        b[] bVarArr;
        int i2;
        if (aVar.e() == 3553) {
            bVarArr = this.n;
            i2 = this.f5170j;
        } else {
            bVarArr = this.o;
            i2 = this.f5171k;
        }
        F(aVar, i2, bVarArr);
        return bVarArr;
    }

    public void H(int i2) {
        if ((i2 & 1) == 1) {
            float A = A();
            int i3 = this.f5164d + 1;
            this.f5164d = i3;
            float[] fArr = this.b;
            if (fArr.length <= i3) {
                this.b = Arrays.copyOf(fArr, fArr.length * 2);
            }
            this.b[this.f5164d] = A;
        }
        if ((i2 & 2) == 2) {
            int i4 = this.f5165e;
            int i5 = i4 + 16;
            this.f5165e = i5;
            float[] fArr2 = this.a;
            if (fArr2.length <= i5) {
                this.a = Arrays.copyOf(fArr2, fArr2.length * 2);
            }
            float[] fArr3 = this.a;
            System.arraycopy(fArr3, i4, fArr3, this.f5165e, 16);
        }
        this.c.a(i2);
    }

    public void I(float f2, float f3, float f4) {
        Matrix.scaleM(this.a, this.f5165e, f2, f3, f4);
    }

    public int N(FloatBuffer floatBuffer) {
        return M(floatBuffer, 4);
    }

    @Override // com.hw.photomovie.d.f
    public void a(float f2, float f3) {
        int i2 = this.f5165e;
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

    @Override // com.hw.photomovie.d.f
    public void b() {
        int d2 = this.c.d();
        if ((d2 & 1) == 1) {
            this.f5164d--;
        }
        if ((d2 & 2) == 2) {
            this.f5165e -= 16;
        }
    }

    @Override // com.hw.photomovie.d.f
    public void c(int i2, int i3) {
        this.f5166f = i2;
        this.f5167g = i3;
        GLES20.glViewport(0, 0, i2, i3);
        r();
        Matrix.setIdentityM(this.a, this.f5165e);
        float f2 = i2;
        float f3 = i3;
        Matrix.orthoM(this.f5168h, 0, 0.0f, f2, 0.0f, f3, -1.0f, 1.0f);
        if (C() == null) {
            Matrix.translateM(this.a, this.f5165e, 0.0f, f3, 0.0f);
            Matrix.scaleM(this.a, this.f5165e, 1.0f, -1.0f, 1.0f);
        }
    }

    @Override // com.hw.photomovie.d.f
    public void d() {
        H(-1);
    }

    @Override // com.hw.photomovie.d.f
    public void e() {
        synchronized (this.q) {
            com.hw.photomovie.util.a aVar = this.q;
            if (aVar.e() > 0) {
                D.d(null, aVar.e(), aVar.c(), 0);
                aVar.b();
            }
            com.hw.photomovie.util.a aVar2 = this.r;
            if (aVar2.e() > 0) {
                D.c(null, aVar2.e(), aVar2.c(), 0);
                aVar2.b();
            }
        }
    }

    @Override // com.hw.photomovie.d.f
    public g f() {
        return D;
    }

    @Override // com.hw.photomovie.d.f
    public void g(float f2, float f3, float f4, float f5, int i2) {
        v(5, 0, 4, f2, f3, f4, f5, i2, 0.0f);
        this.t++;
    }

    @Override // com.hw.photomovie.d.f
    public void h(com.hw.photomovie.d.a aVar, int i2, int i3, int i4, int i5) {
        if (i4 <= 0 || i5 <= 0) {
            return;
        }
        t(aVar, this.x);
        this.y.set(i2, i3, i2 + i4, i3 + i5);
        s(this.x, this.y, aVar);
        x(aVar, this.x, this.y);
    }

    @Override // com.hw.photomovie.d.f
    public void i(com.hw.photomovie.d.a aVar, int i2, int i3) {
        int e2 = aVar.e();
        GLES20.glBindTexture(e2, aVar.d());
        r();
        GLES20.glTexImage2D(e2, 0, i2, aVar.g(), aVar.f(), 0, i2, i3, null);
    }

    @Override // com.hw.photomovie.d.f
    public void j(com.hw.photomovie.d.a aVar) {
        int e2 = aVar.e();
        GLES20.glBindTexture(e2, aVar.d());
        r();
        GLES20.glTexParameteri(e2, 10242, 33071);
        GLES20.glTexParameteri(e2, 10243, 33071);
        GLES20.glTexParameterf(e2, 10241, 9729.0f);
        GLES20.glTexParameterf(e2, Data.MAX_DATA_BYTES, 9729.0f);
    }

    @Override // com.hw.photomovie.d.f
    public void k(com.hw.photomovie.d.a aVar, int i2, int i3, Bitmap bitmap, int i4, int i5) {
        int e2 = aVar.e();
        GLES20.glBindTexture(e2, aVar.d());
        r();
        GLUtils.texSubImage2D(e2, 0, i2, i3, bitmap, i4, i5);
    }

    @Override // com.hw.photomovie.d.f
    public void l(com.hw.photomovie.d.a aVar, RectF rectF, RectF rectF2) {
        if (rectF2.width() <= 0.0f || rectF2.height() <= 0.0f) {
            return;
        }
        this.x.set(rectF);
        this.y.set(rectF2);
        s(this.x, this.y, aVar);
        x(aVar, this.x, this.y);
    }

    @Override // com.hw.photomovie.d.f
    public void m(com.hw.photomovie.d.a aVar, Bitmap bitmap) {
        int e2 = aVar.e();
        GLES20.glBindTexture(e2, aVar.d());
        r();
        GLUtils.texImage2D(e2, 0, bitmap, 0);
    }

    @Override // com.hw.photomovie.d.f
    public void n() {
        GLES20.glBindBuffer(34962, 0);
        r();
    }

    @Override // com.hw.photomovie.d.f
    public void o() {
        GLES20.glBindBuffer(34962, this.f5172l);
        r();
    }

    @Override // com.hw.photomovie.d.f
    public boolean p(com.hw.photomovie.d.a aVar) {
        boolean k2 = aVar.k();
        if (k2) {
            synchronized (this.q) {
                this.q.a(aVar.d());
            }
        }
        return k2;
    }

    @Override // com.hw.photomovie.d.f
    public void setAlpha(float f2) {
        this.b[this.f5164d] = f2;
    }
}
