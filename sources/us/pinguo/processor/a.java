package us.pinguo.processor;

import android.graphics.Bitmap;
import android.util.Log;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import kotlin.jvm.internal.s;
import kotlin.text.t;
import us.pinguo.androidsdk.GPUEditor;
import us.pinguo.androidsdk.PGNativeMethod;
import us.pinguo.util.v;
/* compiled from: BaseRenderer.kt */
/* loaded from: classes6.dex */
public class a {
    private long a;
    private j b;

    /* renamed from: d  reason: collision with root package name */
    private long f11752d;

    /* renamed from: f  reason: collision with root package name */
    private int f11754f;
    private final HashSet<Integer> c = new HashSet<>();

    /* renamed from: e  reason: collision with root package name */
    private String f11753e = "";

    public static /* synthetic */ boolean h(a aVar, d dVar, int i2, boolean z, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                z = false;
            }
            return aVar.g(dVar, i2, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rendererEffect");
    }

    private final boolean k(List<f> list, int i2, boolean z) {
        boolean x;
        boolean m;
        boolean p;
        j jVar = this.b;
        if (jVar == null) {
            return false;
        }
        this.c.clear();
        for (f fVar : list) {
            String c = fVar.c();
            int b = fVar.b();
            Bitmap a = fVar.a();
            if (a == null) {
                p = t.p(c);
                if (p) {
                    continue;
                }
            }
            if (a != null) {
                jVar.h(b, a);
            } else {
                x = t.x(c, "assets://", false, 2, null);
                if (x) {
                    try {
                        String substring = c.substring(9);
                        s.g(substring, "this as java.lang.String).substring(startIndex)");
                        InputStream open = v.a().getAssets().open(substring);
                        s.g(open, "getAppContext().assets.open(assetsPath)");
                        Bitmap a2 = us.pinguo.util.e.a(kotlin.io.a.c(open));
                        if (a2 == null) {
                            return false;
                        }
                        jVar.h(b, a2);
                    } catch (IOException unused) {
                        return false;
                    }
                } else {
                    m = t.m(c, ".png", false, 2, null);
                    if (m) {
                        jVar.l(b, fVar.c());
                    } else {
                        jVar.j(b, fVar.c());
                    }
                }
            }
            if (fVar.d() == 0) {
                j(b, (i2 + BaseBlurEffect.ROTATION_180) % BaseBlurEffect.ROTATION_360, z);
            }
            this.c.add(Integer.valueOf(b));
        }
        return true;
    }

    public final void b() {
        this.f11752d = PGNativeMethod.createEGLDisplay();
    }

    public final void c() {
        long j2 = this.f11752d;
        if (j2 != 0) {
            PGNativeMethod.destroyEGLDisplay(j2);
        }
    }

    public final void d() {
        if (this.a != 0) {
            Log.d("PGNativeMethod", "destroyAndroidSDK");
            PGNativeMethod.destroyAndroidSDK(this.a);
            this.a = 0L;
        }
    }

    public final j e() {
        return this.b;
    }

    public final boolean f(byte[] shader) {
        s.h(shader, "shader");
        if (this.a == 0) {
            Log.d("PGNativeMethod", "createAndroidSDK");
            long createAndroidSDK = PGNativeMethod.createAndroidSDK(GPUEditor.EFFECT_KEY, v.a(), shader);
            this.a = createAndroidSDK;
            this.b = new j(createAndroidSDK);
            return true;
        }
        return false;
    }

    public boolean g(d eft, int i2, boolean z) {
        String c;
        s.h(eft, "eft");
        j jVar = this.b;
        if (jVar == null) {
            return false;
        }
        String str = eft.a() + '_' + eft.d() + '_' + eft.c();
        if (!s.c(this.f11753e, str)) {
            if (!k(eft.b(), i2, z)) {
                return false;
            }
            if (eft.d()) {
                c = s.q(eft.c(), "|Effect=LightZ_Vignette;vignetteStrong=0.7;centerStrong=0;vignetteScale=0;vignetteRange=0.8");
            } else {
                c = eft.c();
            }
            if (!jVar.g(c)) {
                return false;
            }
        } else if ((this.f11754f != i2 || z) && !k(eft.b(), i2, z)) {
            return false;
        }
        if (jVar.f()) {
            this.f11753e = str;
            this.f11754f = i2;
            return true;
        }
        return false;
    }

    public final void i() {
        this.f11753e = "";
        this.f11754f = 0;
    }

    public final void j(int i2, int i3, boolean z) {
        int i4 = (360 - i3) % BaseBlurEffect.ROTATION_360;
        boolean z2 = i4 % BaseBlurEffect.ROTATION_180 != 0;
        j jVar = this.b;
        if (jVar == null) {
            return;
        }
        jVar.a(i2, z2, i4, null, !z, false, 0, false);
    }
}
