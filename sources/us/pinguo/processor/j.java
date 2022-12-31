package us.pinguo.processor;

import android.graphics.Bitmap;
import android.graphics.RectF;
import kotlin.jvm.internal.s;
import us.pinguo.androidsdk.PGNativeMethod;
/* compiled from: RendererBridge.kt */
/* loaded from: classes6.dex */
public final class j {
    private final long a;

    public j(long j2) {
        this.a = j2;
    }

    public final boolean a(int i2, boolean z, int i3, RectF rectF, boolean z2, boolean z3, int i4, boolean z4) {
        j jVar;
        RectF rectF2;
        if (rectF == null) {
            rectF2 = new RectF(-1.0f, -1.0f, -1.0f, -1.0f);
            jVar = this;
        } else {
            jVar = this;
            rectF2 = rectF;
        }
        return PGNativeMethod.adjustImage(jVar.a, i2, z, i3, rectF2.left, rectF2.top, rectF2.right, rectF2.bottom, z2, z3, i4, z4);
    }

    public final boolean b(int i2) {
        return PGNativeMethod.clearImage(this.a, i2);
    }

    public final boolean c() {
        return PGNativeMethod.clearOutputImage(this.a);
    }

    public final boolean d(String path, int i2) {
        s.h(path, "path");
        return PGNativeMethod.getMakedImage2JpegFile(this.a, path, i2);
    }

    public final int e() {
        return PGNativeMethod.getMakedImageTextureID(this.a);
    }

    public final boolean f() {
        return PGNativeMethod.make(this.a);
    }

    public final boolean g(String effect) {
        s.h(effect, "effect");
        return PGNativeMethod.setEffect(this.a, effect);
    }

    public final boolean h(int i2, Bitmap bitmap) {
        s.h(bitmap, "bitmap");
        return PGNativeMethod.setImageFromBitmap(this.a, i2, bitmap, 0.0f, 1.0f);
    }

    public final boolean i(int i2, byte[] jpgData) {
        s.h(jpgData, "jpgData");
        return PGNativeMethod.setImageFromJPEG(this.a, i2, jpgData, 0.0f, 1.0f, 0);
    }

    public final boolean j(int i2, String path) {
        s.h(path, "path");
        return PGNativeMethod.setImageFromPath(this.a, i2, path, 0.0f, 1.0f, 0);
    }

    public final boolean k(int i2, int i3, int i4, int i5, boolean z) {
        return PGNativeMethod.setImageFromSimple2D(this.a, i2, i3, i4, i5, z);
    }

    public final boolean l(int i2, String path) {
        s.h(path, "path");
        return PGNativeMethod.setSupportImageFromPNGPath(this.a, i2, path, 0.0f, 1.0f);
    }
}
