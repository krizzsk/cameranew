package us.pinguo.repository2020.utils;

import android.graphics.Bitmap;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.facedetector.Config;
import us.pinguo.facedetector.ImageMode;
/* compiled from: FaceDetectorInstance.kt */
/* loaded from: classes6.dex */
public final class k {

    /* renamed from: d  reason: collision with root package name */
    private static volatile us.pinguo.facedetector.d f11947d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f11948e;

    /* renamed from: f  reason: collision with root package name */
    private static int f11949f;

    /* renamed from: j  reason: collision with root package name */
    private static int f11953j;
    public static final k a = new k();
    private static final ExecutorService b = Executors.newSingleThreadExecutor();
    private static final Object c = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static int f11950g = 1;

    /* renamed from: h  reason: collision with root package name */
    private static int f11951h = 128;

    /* renamed from: i  reason: collision with root package name */
    private static int f11952i = 256;

    private k() {
    }

    private final void a() {
        us.pinguo.facedetector.d dVar = f11947d;
        Config a2 = dVar == null ? null : dVar.a();
        if (a2 == null) {
            return;
        }
        a2.e(Config.Mode.TRACKING_ROBUST);
        a2.h(true);
        k kVar = a;
        a2.f(kVar.f());
        a2.g(kVar.g());
        us.pinguo.facedetector.d dVar2 = f11947d;
        if (dVar2 != null) {
            dVar2.c(a2);
        }
        f11948e = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        a.h();
    }

    private final void h() {
        if (f11947d != null) {
            return;
        }
        synchronized (c) {
            if (f11947d != null) {
                return;
            }
            us.pinguo.facedetector.d a2 = new j().a();
            f11948e = false;
            f11947d = a2;
            u uVar = u.a;
        }
    }

    private final us.pinguo.facedetector.c i(Bitmap bitmap, int i2) {
        us.pinguo.facedetector.c f2;
        us.pinguo.facedetector.d dVar = f11947d;
        if (dVar == null) {
            return null;
        }
        synchronized (c) {
            Config a2 = dVar.a();
            a2.e(Config.Mode.STATIC_NORMAL);
            a2.d(0.8f);
            a2.h(false);
            a2.f(i2);
            a2.g(a.d());
            dVar.c(a2);
            f11948e = true;
            f2 = dVar.f(bitmap);
        }
        return f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o() {
        synchronized (c) {
            us.pinguo.facedetector.d dVar = f11947d;
            if (dVar != null) {
                dVar.b();
            }
            u uVar = u.a;
        }
    }

    public static /* synthetic */ us.pinguo.facedetector.c r(k kVar, Bitmap bitmap, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return kVar.q(bitmap, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v1, types: [us.pinguo.facedetector.c, T] */
    public static final void s(Ref$ObjectRef result, Bitmap bitmap, int i2, CountDownLatch countDownLatch) {
        s.h(result, "$result");
        s.h(bitmap, "$bitmap");
        s.h(countDownLatch, "$countDownLatch");
        k kVar = a;
        kVar.h();
        result.element = kVar.i(bitmap, i2);
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void u(Ref$ObjectRef result, byte[] imageData, int i2, int i3, ImageMode imageMode, CountDownLatch countDownLatch) {
        s.h(result, "$result");
        s.h(imageData, "$imageData");
        s.h(imageMode, "$imageMode");
        s.h(countDownLatch, "$countDownLatch");
        synchronized (c) {
            T t = 0;
            t = 0;
            if (f11947d != null) {
                if (f11948e) {
                    a.a();
                }
                us.pinguo.facedetector.d dVar = f11947d;
                if (dVar != null) {
                    t = dVar.d(imageData, i2, i3, imageMode);
                }
            }
            result.element = t;
            countDownLatch.countDown();
            u uVar = u.a;
        }
    }

    public final void b() {
        b.execute(d.a);
    }

    public final int d() {
        return f11952i;
    }

    public final int e() {
        return f11950g;
    }

    public final int f() {
        return f11953j;
    }

    public final int g() {
        return f11951h;
    }

    public final void n() {
        b.execute(b.a);
    }

    public final void p(int i2) {
        f11953j = i2 % BaseBlurEffect.ROTATION_360;
        if (i2 != f11949f) {
            synchronized (c) {
                us.pinguo.facedetector.d dVar = f11947d;
                if (dVar != null) {
                    Config a2 = dVar.a();
                    a2.f(f11953j);
                    dVar.c(a2);
                    f11949f = f11953j;
                }
                u uVar = u.a;
            }
        }
    }

    public final us.pinguo.facedetector.c q(final Bitmap bitmap, final int i2) {
        s.h(bitmap, "bitmap");
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        b.execute(new Runnable() { // from class: us.pinguo.repository2020.utils.a
            @Override // java.lang.Runnable
            public final void run() {
                k.s(Ref$ObjectRef.this, bitmap, i2, countDownLatch);
            }
        });
        countDownLatch.await();
        return (us.pinguo.facedetector.c) ref$ObjectRef.element;
    }

    public final us.pinguo.facedetector.c t(final byte[] imageData, final int i2, final int i3, final ImageMode imageMode) {
        s.h(imageData, "imageData");
        s.h(imageMode, "imageMode");
        if (f11947d == null) {
            return null;
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        b.execute(new Runnable() { // from class: us.pinguo.repository2020.utils.c
            @Override // java.lang.Runnable
            public final void run() {
                k.u(Ref$ObjectRef.this, imageData, i2, i3, imageMode, countDownLatch);
            }
        });
        countDownLatch.await();
        return (us.pinguo.facedetector.c) ref$ObjectRef.element;
    }
}
