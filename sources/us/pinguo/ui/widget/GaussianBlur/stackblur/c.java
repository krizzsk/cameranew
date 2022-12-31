package us.pinguo.ui.widget.GaussianBlur.stackblur;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import us.pinguo.foundation.e;
/* compiled from: StackBlurManager.java */
/* loaded from: classes6.dex */
public class c {

    /* renamed from: d  reason: collision with root package name */
    static final int f12149d;

    /* renamed from: e  reason: collision with root package name */
    static final ExecutorService f12150e;
    private final Bitmap a;
    private Bitmap b;
    private final a c;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f12149d = availableProcessors;
        f12150e = Executors.newFixedThreadPool(availableProcessors);
    }

    public c(Bitmap bitmap, float f2) {
        try {
            Matrix matrix = new Matrix();
            matrix.setScale(f2, f2);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError e2) {
            e.e(e2);
        }
        this.a = bitmap;
        this.c = new b();
    }

    public Bitmap a(int i2) {
        Bitmap a = this.c.a(this.a, i2);
        this.b = a;
        return a;
    }

    public c(Bitmap bitmap, int i2) {
        if (Math.max(bitmap.getWidth(), bitmap.getHeight()) > i2) {
            float f2 = i2;
            float min = Math.min(f2 / bitmap.getWidth(), f2 / bitmap.getHeight());
            this.a = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * min), Math.round(min * bitmap.getHeight()), true);
        } else {
            this.a = bitmap;
        }
        this.c = new b();
    }
}
