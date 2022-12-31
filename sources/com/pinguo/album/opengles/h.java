package com.pinguo.album.opengles;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.opengl.GLU;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import androidx.work.Data;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL11;
import javax.microedition.khronos.opengles.GL11Ext;
import javax.microedition.khronos.opengles.GL11ExtensionPack;
/* compiled from: GLES11Canvas.java */
/* loaded from: classes3.dex */
public class h implements l {
    private GL11 a;

    /* renamed from: e  reason: collision with root package name */
    private int f6064e;

    /* renamed from: f  reason: collision with root package name */
    private c f6065f;

    /* renamed from: h  reason: collision with root package name */
    private float f6067h;

    /* renamed from: j  reason: collision with root package name */
    private b f6069j;
    private int p;
    private int q;
    private q t;
    int u;
    int v;
    int w;
    int x;
    private static final float[] y = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    private static float[] z = new float[4];
    private static m A = new i();
    private final float[] b = new float[16];
    private final float[] c = new float[16];

    /* renamed from: d  reason: collision with root package name */
    private final float[] f6063d = new float[4];

    /* renamed from: g  reason: collision with root package name */
    private final ArrayList<q> f6066g = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private final ArrayList<b> f6068i = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private final RectF f6070k = new RectF();

    /* renamed from: l  reason: collision with root package name */
    private final RectF f6071l = new RectF();
    private final float[] m = new float[32];
    private final us.pinguo.foundation.utils.r n = new us.pinguo.foundation.utils.r();
    private final us.pinguo.foundation.utils.r o = new us.pinguo.foundation.utils.r();
    private boolean r = true;
    private int[] s = new int[1];

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GLES11Canvas.java */
    /* loaded from: classes3.dex */
    public static class b {
        float a;
        float[] b;
        b c;

        private b() {
            this.b = new float[16];
        }

        public void a(h hVar) {
            float f2 = this.a;
            if (f2 >= 0.0f) {
                hVar.setAlpha(f2);
            }
            float[] fArr = this.b;
            if (fArr[0] != Float.NEGATIVE_INFINITY) {
                System.arraycopy(fArr, 0, hVar.b, 0, 16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GLES11Canvas.java */
    /* loaded from: classes3.dex */
    public static class c {
        private final GL11 a;
        private int b = 7681;
        private float c = 1.0f;

        /* renamed from: d  reason: collision with root package name */
        private int f6072d = 3553;

        /* renamed from: e  reason: collision with root package name */
        private boolean f6073e = true;

        public c(GL11 gl11) {
            this.a = gl11;
            gl11.glDisable(2896);
            gl11.glEnable(3024);
            gl11.glEnableClientState(32884);
            gl11.glEnableClientState(32888);
            gl11.glEnable(3553);
            gl11.glTexEnvf(8960, 8704, 7681.0f);
            gl11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            gl11.glClearStencil(0);
            gl11.glEnable(3042);
            gl11.glBlendFunc(1, 771);
            gl11.glPixelStorei(3317, 2);
        }

        public void a(boolean z) {
            if (this.f6073e == z) {
                return;
            }
            this.f6073e = z;
            if (z) {
                this.a.glEnable(3042);
            } else {
                this.a.glDisable(3042);
            }
        }

        public void b(int i2, float f2) {
            a(!com.pinguo.album.j.a.n(i2) || f2 < 0.95f);
            this.c = -1.0f;
            e(0);
            float f3 = ((((i2 >>> 24) * f2) * 65535.0f) / 255.0f) / 255.0f;
            this.a.glColor4x(Math.round(((i2 >> 16) & 255) * f3), Math.round(((i2 >> 8) & 255) * f3), Math.round((i2 & 255) * f3), Math.round(f3 * 255.0f));
        }

        public void c(int i2) {
            if (this.b == i2) {
                return;
            }
            this.b = i2;
            this.a.glTexEnvf(8960, 8704, i2);
        }

        public void d(float f2) {
            if (this.c == f2) {
                return;
            }
            this.c = f2;
            if (f2 >= 0.95f) {
                this.a.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                c(7681);
                return;
            }
            this.a.glColor4f(f2, f2, f2, f2);
            c(8448);
        }

        public void e(int i2) {
            int i3 = this.f6072d;
            if (i3 == i2) {
                return;
            }
            if (i3 != 0) {
                this.a.glDisable(i3);
            }
            this.f6072d = i2;
            if (i2 != 0) {
                this.a.glEnable(i2);
            }
        }
    }

    public h(GL11 gl11) {
        this.a = gl11;
        this.f6065f = new c(gl11);
        float[] fArr = y;
        FloatBuffer asFloatBuffer = D((fArr.length * 32) / 8).asFloatBuffer();
        asFloatBuffer.put(fArr, 0, fArr.length).position(0);
        int[] iArr = new int[1];
        A.a(1, iArr, 0);
        int i2 = iArr[0];
        this.f6064e = i2;
        gl11.glBindBuffer(34962, i2);
        gl11.glBufferData(34962, asFloatBuffer.capacity() * 4, asFloatBuffer, 35044);
        gl11.glVertexPointer(2, 5126, 0, 0);
        gl11.glTexCoordPointer(2, 5126, 0, 0);
        gl11.glClientActiveTexture(33985);
        gl11.glTexCoordPointer(2, 5126, 0, 0);
        gl11.glClientActiveTexture(33984);
        gl11.glEnableClientState(32888);
    }

    private static ByteBuffer D(int i2) {
        return ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
    }

    private boolean E(com.pinguo.album.opengles.a aVar) {
        if (aVar.n(this)) {
            int f2 = aVar.f();
            this.f6065f.e(f2);
            this.a.glBindTexture(f2, aVar.e());
            return true;
        }
        return false;
    }

    private static void F(GL11ExtensionPack gL11ExtensionPack) {
        String str;
        int glCheckFramebufferStatusOES = gL11ExtensionPack.glCheckFramebufferStatusOES(36160);
        if (glCheckFramebufferStatusOES != 36053) {
            switch (glCheckFramebufferStatusOES) {
                case 36054:
                    str = "FRAMEBUFFER_ATTACHMENT";
                    break;
                case 36055:
                    str = "FRAMEBUFFER_MISSING_ATTACHMENT";
                    break;
                case 36056:
                default:
                    str = "";
                    break;
                case 36057:
                    str = "FRAMEBUFFER_INCOMPLETE_DIMENSIONS";
                    break;
                case 36058:
                    str = "FRAMEBUFFER_FORMATS";
                    break;
                case 36059:
                    str = "FRAMEBUFFER_DRAW_BUFFER";
                    break;
                case 36060:
                    str = "FRAMEBUFFER_READ_BUFFER";
                    break;
                case 36061:
                    str = "FRAMEBUFFER_UNSUPPORTED";
                    break;
            }
            throw new RuntimeException(str + ":" + Integer.toHexString(glCheckFramebufferStatusOES));
        }
    }

    private static void G(RectF rectF, RectF rectF2, com.pinguo.album.opengles.a aVar) {
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

    private void H(com.pinguo.album.opengles.a aVar, int i2, int i3, int i4, int i5) {
        if (K(this.b)) {
            if (aVar.i()) {
                Q(1.0f / aVar.h(), 1.0f / aVar.g(), (aVar.getWidth() - 1.0f) / aVar.h(), (aVar.getHeight() - 1.0f) / aVar.g());
            } else {
                Q(0.0f, 0.0f, aVar.getWidth() / aVar.h(), aVar.getHeight() / aVar.g());
            }
            S(i2, i3, i4, i5);
            return;
        }
        float[] L = L(this.b, i2, i3 + i5, i2 + i4, i3);
        int i6 = (int) (L[0] + 0.5f);
        int i7 = (int) (L[1] + 0.5f);
        int i8 = ((int) (L[2] + 0.5f)) - i6;
        int i9 = ((int) (L[3] + 0.5f)) - i7;
        if (i8 <= 0 || i9 <= 0) {
            return;
        }
        ((GL11Ext) this.a).glDrawTexiOES(i6, i7, 0, i8, i9);
        this.x++;
    }

    private void I(com.pinguo.album.opengles.a aVar, int i2, int i3, int i4, int i5, float f2) {
        if (i4 <= 0 || i5 <= 0) {
            return;
        }
        this.f6065f.a(this.r && (!aVar.b() || f2 < 0.95f));
        if (E(aVar)) {
            this.f6065f.d(f2);
            H(aVar, i2, i3, i4, i5);
        }
    }

    private void J(b bVar) {
        bVar.c = this.f6069j;
        this.f6069j = bVar;
    }

    private static boolean K(float[] fArr) {
        return Math.abs(fArr[4]) > 1.0E-5f || Math.abs(fArr[1]) > 1.0E-5f || fArr[0] < -1.0E-5f || fArr[5] > 1.0E-5f;
    }

    private float[] L(float[] fArr, int i2, int i3, int i4, int i5) {
        float[] fArr2 = this.f6063d;
        float f2 = i2;
        float f3 = i3;
        float f4 = (fArr[3] * f2) + (fArr[7] * f3) + fArr[15];
        fArr2[0] = (((fArr[0] * f2) + (fArr[4] * f3)) + fArr[12]) / f4;
        fArr2[1] = (((fArr[1] * f2) + (fArr[5] * f3)) + fArr[13]) / f4;
        float f5 = i4;
        float f6 = i5;
        float f7 = (fArr[0] * f5) + (fArr[4] * f6) + fArr[12];
        float f8 = (fArr[1] * f5) + (fArr[5] * f6) + fArr[13];
        float f9 = (fArr[3] * f5) + (fArr[7] * f6) + fArr[15];
        fArr2[2] = f7 / f9;
        fArr2[3] = f8 / f9;
        return fArr2;
    }

    private b M() {
        b bVar = this.f6069j;
        if (bVar != null) {
            this.f6069j = bVar.c;
            return bVar;
        }
        return new b();
    }

    private void N() {
        System.arraycopy(this.m, 0, this.b, 0, 16);
    }

    private void O() {
        System.arraycopy(this.b, 0, this.m, 0, 16);
    }

    private void P(q qVar) {
        GL11ExtensionPack gL11ExtensionPack = (GL11ExtensionPack) this.a;
        if (this.t == null && qVar != null) {
            A.a(1, this.s, 0);
            gL11ExtensionPack.glBindFramebufferOES(36160, this.s[0]);
        }
        if (this.t != null && qVar == null) {
            gL11ExtensionPack.glBindFramebufferOES(36160, 0);
            gL11ExtensionPack.glDeleteFramebuffersOES(1, this.s, 0);
        }
        this.t = qVar;
        if (qVar == null) {
            c(this.p, this.q);
            return;
        }
        c(qVar.getWidth(), qVar.getHeight());
        if (!qVar.m()) {
            qVar.u(this);
        }
        gL11ExtensionPack.glFramebufferTexture2DOES(36160, 36064, 3553, qVar.e(), 0);
        F(gL11ExtensionPack);
    }

    private void Q(float f2, float f3, float f4, float f5) {
        this.a.glMatrixMode(5890);
        float[] fArr = this.c;
        fArr[0] = f4 - f2;
        fArr[5] = f5 - f3;
        fArr[10] = 1.0f;
        fArr[12] = f2;
        fArr[13] = f3;
        fArr[15] = 1.0f;
        this.a.glLoadMatrixf(fArr, 0);
        this.a.glMatrixMode(5888);
    }

    private void R(RectF rectF) {
        Q(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    private void S(float f2, float f3, float f4, float f5) {
        GL11 gl11 = this.a;
        O();
        a(f2, f3);
        k(f4, f5, 1.0f);
        gl11.glLoadMatrixf(this.b, 0);
        gl11.glDrawArrays(5, 0, 4);
        N();
        this.w++;
    }

    private int T(Buffer buffer, int i2) {
        int[] iArr = new int[1];
        A.a(1, iArr, 0);
        int i3 = iArr[0];
        this.a.glBindBuffer(34962, i3);
        this.a.glBufferData(34962, buffer.capacity() * i2, buffer, 35044);
        return i3;
    }

    @Override // com.pinguo.album.opengles.l
    public void A(com.pinguo.album.opengles.a aVar, int i2, int i3, int i4, int i5, int i6, int i7) {
        float f2 = this.f6067h;
        if (E(aVar)) {
            this.f6065f.a(this.r && (!aVar.b() || f2 < 0.95f));
            this.f6065f.d(f2);
            Q(0.0f, 0.0f, 1.0f, 1.0f);
            O();
            a(i2, i3);
            this.a.glLoadMatrixf(this.b, 0);
            this.a.glBindBuffer(34962, i4);
            this.a.glVertexPointer(2, 5126, 0, 0);
            this.a.glBindBuffer(34962, i5);
            this.a.glTexCoordPointer(2, 5126, 0, 0);
            this.a.glBindBuffer(34963, i6);
            this.a.glDrawElements(5, i7, 5121, 0);
            this.a.glBindBuffer(34962, this.f6064e);
            this.a.glVertexPointer(2, 5126, 0, 0);
            this.a.glTexCoordPointer(2, 5126, 0, 0);
            N();
            this.v++;
        }
    }

    @Override // com.pinguo.album.opengles.l
    public void B(float[] fArr) {
        if (fArr != null && fArr.length == 4) {
            this.a.glClearColor(fArr[1], fArr[2], fArr[3], fArr[0]);
        } else {
            this.a.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        }
        this.a.glClear(16384);
    }

    @Override // com.pinguo.album.opengles.l
    public void a(float f2, float f3) {
        float[] fArr = this.b;
        fArr[12] = fArr[12] + (fArr[0] * f2) + (fArr[4] * f3);
        fArr[13] = fArr[13] + (fArr[1] * f2) + (fArr[5] * f3);
        fArr[14] = fArr[14] + (fArr[2] * f2) + (fArr[6] * f3);
        fArr[15] = fArr[15] + (fArr[3] * f2) + (fArr[7] * f3);
    }

    @Override // com.pinguo.album.opengles.l
    public void b() {
        if (!this.f6068i.isEmpty()) {
            ArrayList<b> arrayList = this.f6068i;
            b remove = arrayList.remove(arrayList.size() - 1);
            remove.a(this);
            J(remove);
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.pinguo.album.opengles.l
    public void c(int i2, int i3) {
        if (this.t == null) {
            this.p = i2;
            this.q = i3;
        }
        this.f6067h = 1.0f;
        GL11 gl11 = this.a;
        gl11.glViewport(0, 0, i2, i3);
        gl11.glMatrixMode(5889);
        gl11.glLoadIdentity();
        float f2 = i3;
        GLU.gluOrtho2D(gl11, 0.0f, i2, 0.0f, f2);
        gl11.glMatrixMode(5888);
        gl11.glLoadIdentity();
        float[] fArr = this.b;
        Matrix.setIdentityM(fArr, 0);
        if (this.t == null) {
            Matrix.translateM(fArr, 0, 0.0f, f2, 0.0f);
            Matrix.scaleM(fArr, 0, 1.0f, -1.0f, 1.0f);
        }
    }

    @Override // com.pinguo.album.opengles.l
    public void d() {
        s(-1);
    }

    @Override // com.pinguo.album.opengles.l
    public void e() {
        synchronized (this.n) {
            us.pinguo.foundation.utils.r rVar = this.n;
            if (rVar.e() > 0) {
                A.d(this.a, rVar.e(), rVar.c(), 0);
                rVar.b();
            }
            us.pinguo.foundation.utils.r rVar2 = this.o;
            if (rVar2.e() > 0) {
                A.c(this.a, rVar2.e(), rVar2.c(), 0);
                rVar2.b();
            }
        }
    }

    @Override // com.pinguo.album.opengles.l
    public m f() {
        return A;
    }

    @Override // com.pinguo.album.opengles.l
    public void g(float f2, float f3, float f4, float f5, int i2) {
        this.f6065f.b(i2, this.f6067h);
        GL11 gl11 = this.a;
        O();
        a(f2, f3);
        k(f4, f5, 1.0f);
        gl11.glLoadMatrixf(this.b, 0);
        gl11.glDrawArrays(5, 0, 4);
        N();
        this.u++;
    }

    @Override // com.pinguo.album.opengles.l
    public int h(ByteBuffer byteBuffer) {
        return T(byteBuffer, 1);
    }

    @Override // com.pinguo.album.opengles.l
    public void i(com.pinguo.album.opengles.a aVar, RectF rectF, RectF rectF2) {
        if (rectF2.width() <= 0.0f || rectF2.height() <= 0.0f) {
            return;
        }
        this.f6070k.set(rectF);
        this.f6071l.set(rectF2);
        RectF rectF3 = this.f6070k;
        RectF rectF4 = this.f6071l;
        this.f6065f.a(this.r && (!aVar.b() || this.f6067h < 0.95f));
        if (E(aVar)) {
            G(rectF3, rectF4, aVar);
            R(rectF3);
            this.f6065f.d(this.f6067h);
            S(rectF4.left, rectF4.top, rectF4.width(), rectF4.height());
        }
    }

    @Override // com.pinguo.album.opengles.l
    public void j(float[] fArr, int i2) {
        float[] fArr2 = this.m;
        Matrix.multiplyMM(fArr2, 0, this.b, 0, fArr, i2);
        System.arraycopy(fArr2, 0, this.b, 0, 16);
    }

    @Override // com.pinguo.album.opengles.l
    public void k(float f2, float f3, float f4) {
        Matrix.scaleM(this.b, 0, f2, f3, f4);
    }

    @Override // com.pinguo.album.opengles.l
    public void l(com.pinguo.album.opengles.a aVar, int i2, int i3, int i4, int i5) {
        I(aVar, i2, i3, i4, i5, this.f6067h);
    }

    @Override // com.pinguo.album.opengles.l
    public void m() {
        this.a.glClear(16384);
    }

    @Override // com.pinguo.album.opengles.l
    public void n(int i2) {
        synchronized (this.n) {
            this.o.a(i2);
        }
    }

    @Override // com.pinguo.album.opengles.l
    public boolean o(com.pinguo.album.opengles.a aVar) {
        synchronized (this.n) {
            if (aVar.m()) {
                this.n.a(aVar.a);
                return true;
            }
            return false;
        }
    }

    @Override // com.pinguo.album.opengles.l
    public void p(float f2, float f3, float f4) {
        Matrix.translateM(this.b, 0, f2, f3, f4);
    }

    @Override // com.pinguo.album.opengles.l
    public void q(q qVar) {
        d();
        this.f6066g.add(this.t);
        P(qVar);
    }

    @Override // com.pinguo.album.opengles.l
    public int r(FloatBuffer floatBuffer) {
        return T(floatBuffer, 4);
    }

    @Override // com.pinguo.album.opengles.l
    public void s(int i2) {
        b M = M();
        if ((i2 & 1) != 0) {
            M.a = this.f6067h;
        } else {
            M.a = -1.0f;
        }
        if ((i2 & 2) != 0) {
            System.arraycopy(this.b, 0, M.b, 0, 16);
        } else {
            M.b[0] = Float.NEGATIVE_INFINITY;
        }
        this.f6068i.add(M);
    }

    @Override // com.pinguo.album.opengles.l
    public void setAlpha(float f2) {
        this.f6067h = f2;
    }

    @Override // com.pinguo.album.opengles.l
    public void t(com.pinguo.album.opengles.a aVar, int i2, int i3) {
        int f2 = aVar.f();
        this.a.glBindTexture(f2, aVar.e());
        this.a.glTexImage2D(f2, 0, i2, aVar.h(), aVar.g(), 0, i2, i3, null);
    }

    @Override // com.pinguo.album.opengles.l
    public void u(com.pinguo.album.opengles.a aVar, int i2, int i3, Bitmap bitmap, int i4, int i5) {
        int f2 = aVar.f();
        this.a.glBindTexture(f2, aVar.e());
        GLUtils.texSubImage2D(f2, 0, i2, i3, bitmap, i4, i5);
    }

    @Override // com.pinguo.album.opengles.l
    public void v(float f2, float f3, float f4, float f5) {
        if (f2 == 0.0f) {
            return;
        }
        float[] fArr = this.m;
        Matrix.setRotateM(fArr, 0, f2, f3, f4, f5);
        Matrix.multiplyMM(fArr, 16, this.b, 0, fArr, 0);
        System.arraycopy(fArr, 16, this.b, 0, 16);
    }

    @Override // com.pinguo.album.opengles.l
    public void w() {
        ArrayList<q> arrayList = this.f6066g;
        P(arrayList.remove(arrayList.size() - 1));
        b();
    }

    @Override // com.pinguo.album.opengles.l
    public void x(com.pinguo.album.opengles.a aVar, Bitmap bitmap) {
        int f2 = aVar.f();
        this.a.glBindTexture(f2, aVar.e());
        GLUtils.texImage2D(f2, 0, bitmap, 0);
    }

    @Override // com.pinguo.album.opengles.l
    public void y(com.pinguo.album.opengles.a aVar) {
        int width = aVar.getWidth();
        int height = aVar.getHeight();
        float[] fArr = z;
        fArr[0] = 0.0f;
        fArr[1] = height;
        fArr[2] = width;
        fArr[3] = -height;
        int f2 = aVar.f();
        this.a.glBindTexture(f2, aVar.e());
        this.a.glTexParameterfv(f2, 35741, z, 0);
        this.a.glTexParameteri(f2, 10242, 33071);
        this.a.glTexParameteri(f2, 10243, 33071);
        this.a.glTexParameterf(f2, 10241, 9729.0f);
        this.a.glTexParameterf(f2, Data.MAX_DATA_BYTES, 9729.0f);
    }

    @Override // com.pinguo.album.opengles.l
    public void z(float f2) {
        this.f6067h *= f2;
    }
}
