package us.pinguo.edit2020.manager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.s;
import us.pinguo.repository2020.utils.k;
/* compiled from: FaceDetectorCache.kt */
/* loaded from: classes4.dex */
final class f implements Callable<us.pinguo.facedetector.c> {
    private final String a;
    private final int b;
    private final int c;

    public f(String path, int i2, int i3) {
        s.h(path, "path");
        this.a = path;
        this.b = i2;
        this.c = i3;
    }

    private final Bitmap b(String str, int i2) {
        byte[] a;
        a = kotlin.io.g.a(new File(str));
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(a, 0, a.length, options);
        int max = Math.max(options.outWidth, options.outHeight);
        if (max < 10) {
            return null;
        }
        float f2 = max / this.b;
        options.inSampleSize = f2 >= 1.75f ? f2 < 3.5f ? 2 : f2 < 7.0f ? 4 : 8 : 1;
        options.inJustDecodeBounds = false;
        options.inDither = false;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(a, 0, a.length, options);
        return i2 == 0 ? decodeByteArray : us.pinguo.util.e.p(decodeByteArray, i2);
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public us.pinguo.facedetector.c call() {
        us.pinguo.facedetector.c r;
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap b = b(this.a, this.c);
        if (b == null || (r = k.r(k.a, b, 0, 2, null)) == null) {
            return null;
        }
        us.pinguo.common.log.a.c("face result callback:" + r.c() + "   time:" + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
        return r;
    }
}
