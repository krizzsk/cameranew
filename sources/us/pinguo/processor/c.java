package us.pinguo.processor;

import android.opengl.GLES20;
import android.util.Size;
import kotlin.jvm.internal.s;
/* compiled from: LiveRenderer.kt */
/* loaded from: classes6.dex */
public final class c extends a implements us.pinguo.processor.k.b {

    /* renamed from: g  reason: collision with root package name */
    private final byte[] f11755g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11756h;

    /* renamed from: i  reason: collision with root package name */
    private d f11757i;

    /* renamed from: j  reason: collision with root package name */
    private int f11758j;

    public c(byte[] shader) {
        s.h(shader, "shader");
        this.f11755g = shader;
        this.f11757i = e.a();
    }

    @Override // us.pinguo.processor.k.b
    public int a(int i2, Size previewSize, boolean z) {
        s.h(previewSize, "previewSize");
        j e2 = e();
        if (e2 == null || this.f11756h) {
            return i2;
        }
        d dVar = this.f11757i;
        if (e2.k(0, i2, previewSize.getWidth(), previewSize.getHeight(), false) && g(dVar, this.f11758j, z)) {
            int e3 = e2.e();
            return !GLES20.glIsTexture(e3) ? i2 : e3;
        }
        return i2;
    }

    @Override // us.pinguo.processor.k.b
    public void init() {
        this.f11756h = false;
        f(this.f11755g);
    }

    public void l() {
        this.f11756h = true;
        d();
    }

    public final int m() {
        return this.f11758j;
    }

    public final d n() {
        return this.f11757i;
    }

    public final void o(int i2) {
        this.f11758j = i2;
    }

    public final void p(d dVar) {
        s.h(dVar, "<set-?>");
        this.f11757i = dVar;
    }
}
