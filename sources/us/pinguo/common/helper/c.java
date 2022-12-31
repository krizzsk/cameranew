package us.pinguo.common.helper;

import android.graphics.Bitmap;
import android.graphics.PointF;
import androidx.core.view.MotionEventCompat;
import com.tencent.bugly.crashreport.CrashReport;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.libdeepvision.Restoration;
import us.pinguo.libdeepvision.bean.ResultImage;
import us.pinguo.libdeepvision.callback.RestorationCancelCallback;
import us.pinguo.libdeepvision.callback.ResultImageCallback;
import us.pinguo.util.e;
import us.pinguo.util.v;
/* compiled from: RestorationHelper.kt */
/* loaded from: classes4.dex */
public final class c implements Runnable {
    private final String a;
    private final String b;
    private final List<List<PointF>> c;

    /* renamed from: d  reason: collision with root package name */
    private l<? super String, u> f9923d;

    /* renamed from: e  reason: collision with root package name */
    private final ResultImageCallback f9924e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f9925f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f9926g;

    /* compiled from: RestorationHelper.kt */
    /* loaded from: classes4.dex */
    public static final class a extends RestorationCancelCallback {
        final /* synthetic */ RestorationCancelCallback a;

        a(RestorationCancelCallback restorationCancelCallback) {
            this.a = restorationCancelCallback;
        }

        @Override // us.pinguo.libdeepvision.callback.RestorationCancelCallback
        public void cancel(boolean z) {
            RestorationCancelCallback restorationCancelCallback = this.a;
            if (restorationCancelCallback == null) {
                return;
            }
            restorationCancelCallback.cancel(z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(String lastPath, String srcPath, List<? extends List<? extends PointF>> list, l<? super String, u> lVar, ResultImageCallback progressCallback) {
        s.h(lastPath, "lastPath");
        s.h(srcPath, "srcPath");
        s.h(progressCallback, "progressCallback");
        this.a = lastPath;
        this.b = srcPath;
        this.c = list;
        this.f9923d = lVar;
        this.f9924e = progressCallback;
    }

    public static /* synthetic */ void b(c cVar, RestorationCancelCallback restorationCancelCallback, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            restorationCancelCallback = null;
        }
        cVar.a(restorationCancelCallback);
    }

    public final void a(RestorationCancelCallback restorationCancelCallback) {
        if (this.f9926g) {
            return;
        }
        this.f9926g = true;
        Restoration.a(new a(restorationCancelCallback));
    }

    public final boolean c() {
        return this.f9925f;
    }

    public final void d() {
        Restoration.c();
    }

    public final void e(boolean z) {
        this.f9925f = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        List<List<PointF>> list = this.c;
        String imagePath = (list == null || list.isEmpty()) ^ true ? b.c.a() : b.c.b();
        if (s.c(this.b, this.a)) {
            s.g(imagePath, "imagePath");
            if (us.pinguo.util.l.m(imagePath)) {
                l<? super String, u> lVar = this.f9923d;
                if (lVar != null) {
                    lVar.invoke(imagePath);
                }
                this.f9923d = null;
                this.f9925f = false;
                this.f9926g = false;
                return;
            }
        }
        if (Restoration.b(v.a(), "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", "vStudio.Android.Camera360")) {
            if (this.f9926g) {
                this.f9923d = null;
                this.f9925f = false;
                this.f9926g = false;
                d();
                return;
            }
            try {
                Bitmap r = e.r(this.b, null, 2, null);
                if (r == null) {
                    l<? super String, u> lVar2 = this.f9923d;
                    if (lVar2 != null) {
                        lVar2.invoke(null);
                    }
                    this.f9923d = null;
                    this.f9925f = false;
                    this.f9926g = false;
                    d();
                    return;
                }
                int width = r.getWidth();
                int height = r.getHeight();
                try {
                    byte[] bArr = new byte[width * height * 3];
                    if (this.f9926g) {
                        this.f9923d = null;
                        this.f9925f = false;
                        this.f9926g = false;
                        d();
                        return;
                    }
                    int i2 = 0;
                    while (i2 < height) {
                        int i3 = i2 + 1;
                        int i4 = 0;
                        while (i4 < width) {
                            int i5 = i4 + 1;
                            int i6 = (width * i2) + i4;
                            int pixel = r.getPixel(i4, i2);
                            int i7 = i6 * 3;
                            bArr[i7] = (byte) ((16711680 & pixel) >> 16);
                            bArr[i7 + 1] = (byte) ((pixel & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
                            bArr[i7 + 2] = (byte) (pixel & 255);
                            i4 = i5;
                        }
                        i2 = i3;
                    }
                    if (!r.isRecycled()) {
                        r.recycle();
                    }
                    if (this.f9926g) {
                        this.f9923d = null;
                        this.f9925f = false;
                        this.f9926g = false;
                        d();
                        return;
                    }
                    ResultImage restore = Restoration.restore(bArr, width, height, this.c, 3, this.f9924e);
                    if (!this.f9926g && restore != null) {
                        Bitmap createBitmap = Bitmap.createBitmap(restore.width, restore.height, Bitmap.Config.ARGB_8888);
                        createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(restore.resultImage));
                        s.g(imagePath, "imagePath");
                        e.t(imagePath, createBitmap, 90);
                        createBitmap.recycle();
                        d();
                        this.f9925f = false;
                        l<? super String, u> lVar3 = this.f9923d;
                        if (lVar3 == null) {
                            return;
                        }
                        lVar3.invoke(imagePath);
                        return;
                    }
                    this.f9923d = null;
                    this.f9925f = false;
                    this.f9926g = false;
                    d();
                    return;
                } catch (OutOfMemoryError e2) {
                    if (!r.isRecycled()) {
                        r.recycle();
                    }
                    l<? super String, u> lVar4 = this.f9923d;
                    if (lVar4 != null) {
                        lVar4.invoke(null);
                    }
                    this.f9923d = null;
                    this.f9925f = false;
                    this.f9926g = false;
                    d();
                    e2.printStackTrace();
                    CrashReport.postCatchedException(e2);
                    return;
                }
            } catch (Throwable th) {
                l<? super String, u> lVar5 = this.f9923d;
                if (lVar5 != null) {
                    lVar5.invoke("");
                }
                this.f9923d = null;
                this.f9925f = false;
                this.f9926g = false;
                d();
                th.printStackTrace();
                CrashReport.postCatchedException(th);
                return;
            }
        }
        l<? super String, u> lVar6 = this.f9923d;
        if (lVar6 != null) {
            lVar6.invoke("");
        }
        this.f9923d = null;
        this.f9925f = false;
        this.f9926g = false;
        d();
    }
}
