package us.pinguo.processor;

import android.graphics.Bitmap;
import android.util.Log;
import android.util.Size;
import java.util.concurrent.CountDownLatch;
import kotlin.Pair;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.s;
import kotlin.k;
/* compiled from: Processor2020.kt */
/* loaded from: classes6.dex */
public final class i {
    private static c c;

    /* renamed from: d  reason: collision with root package name */
    private static byte[] f11767d;

    /* renamed from: e  reason: collision with root package name */
    private static int f11768e;

    /* renamed from: f  reason: collision with root package name */
    private static CountDownLatch f11769f;
    public static final i a = new i();
    private static us.pinguo.processor.k.c b = new us.pinguo.processor.k.a();

    /* renamed from: g  reason: collision with root package name */
    private static PreviewProcessState f11770g = PreviewProcessState.COMPLETE;

    /* compiled from: Processor2020.kt */
    /* loaded from: classes6.dex */
    public static final class a implements us.pinguo.processor.k.d {
        final /* synthetic */ Size a;
        final /* synthetic */ Ref$ObjectRef<Bitmap> b;
        final /* synthetic */ Ref$ObjectRef<String> c;

        a(Size size, Ref$ObjectRef<Bitmap> ref$ObjectRef, Ref$ObjectRef<String> ref$ObjectRef2) {
            this.a = size;
            this.b = ref$ObjectRef;
            this.c = ref$ObjectRef2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
            r3 = r3;
         */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // us.pinguo.processor.k.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(android.graphics.Bitmap r3, java.lang.String r4) {
            /*
                r2 = this;
                if (r3 == 0) goto L17
                android.util.Size r0 = r2.a
                int r0 = r0.getWidth()
                float r0 = (float) r0
                android.util.Size r1 = r2.a
                int r1 = r1.getHeight()
                float r1 = (float) r1
                float r0 = r0 / r1
                us.pinguo.processor.i r1 = us.pinguo.processor.i.a
                android.graphics.Bitmap r3 = us.pinguo.processor.i.a(r1, r3, r0)
            L17:
                kotlin.jvm.internal.Ref$ObjectRef<android.graphics.Bitmap> r0 = r2.b
                r0.element = r3
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r3 = r2.c
                r3.element = r4
                java.util.concurrent.CountDownLatch r3 = us.pinguo.processor.i.b()
                if (r3 != 0) goto L26
                goto L29
            L26:
                r3.countDown()
            L29:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: us.pinguo.processor.i.a.a(android.graphics.Bitmap, java.lang.String):void");
        }
    }

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap d(Bitmap bitmap, float f2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0) {
            return bitmap;
        }
        float f3 = width;
        float f4 = height;
        float f5 = f3 / f4;
        if (Math.abs(f2 - f5) <= 0.02f) {
            return bitmap;
        }
        if (f2 < f5) {
            int i2 = (int) ((f4 * f2) + 0.5f);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, (width - i2) / 2, 0, i2, height);
            s.g(createBitmap, "createBitmap(bitmap, left, 0, newW, bmpH)");
            return createBitmap;
        }
        int i3 = (int) ((f3 / f2) + 0.5f);
        Bitmap createBitmap2 = Bitmap.createBitmap(bitmap, 0, (height - i3) / 2, width, i3);
        s.g(createBitmap2, "createBitmap(bitmap, 0, top, bmpW, newH)");
        return createBitmap2;
    }

    public final void c() {
        if (f11770g == PreviewProcessState.START) {
            j(PreviewProcessState.CANCLING);
        }
        if (f11770g == PreviewProcessState.LONG_RENDERING) {
            CountDownLatch countDownLatch = f11769f;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            j(PreviewProcessState.CANCLING);
            b.e();
        }
    }

    public final void e() {
        int i2 = f11768e;
        if (i2 != 0) {
            b.d(i2);
        }
        c cVar = c;
        if (cVar != null) {
            cVar.l();
        }
        c = null;
    }

    public final PreviewProcessState f() {
        return f11770g;
    }

    public final boolean g(d makeInfo) {
        s.h(makeInfo, "makeInfo");
        return b.a(makeInfo);
    }

    public final Pair<Integer, String> h(int i2, Size size, d makeInfo, boolean z, boolean z2) {
        s.h(size, "size");
        s.h(makeInfo, "makeInfo");
        PreviewProcessState previewProcessState = f11770g;
        PreviewProcessState previewProcessState2 = PreviewProcessState.CANCLING;
        if (previewProcessState == previewProcessState2) {
            return k.a(Integer.valueOf(i2), z2 ? "CANCEL" : "EXIT");
        } else if (z2) {
            byte[] f2 = b.f(i2, size, true);
            f11769f = new CountDownLatch(1);
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            j(PreviewProcessState.LONG_RENDERING);
            b.d(f2, makeInfo, new a(size, ref$ObjectRef, ref$ObjectRef2));
            CountDownLatch countDownLatch = f11769f;
            if (countDownLatch != null) {
                countDownLatch.await();
            }
            if (ref$ObjectRef.element == 0) {
                boolean z3 = f11770g == previewProcessState2;
                b.b();
                return k.a(0, z3 ? "CANCEL" : (String) ref$ObjectRef2.element);
            }
            if (f11768e == 0) {
                f11768e = b.c();
            }
            T t = ref$ObjectRef.element;
            s.e(t);
            Pair<Integer, String> a2 = k.a(Integer.valueOf(b.a((Bitmap) t, f11768e, true)), null);
            b.b();
            if (f11770g == previewProcessState2) {
                j(PreviewProcessState.COMPLETE);
                return k.a(Integer.valueOf(i2), z2 ? "CANCEL" : "EXIT");
            }
            return a2;
        } else {
            c cVar = c;
            if (cVar == null) {
                byte[] bArr = f11767d;
                if (bArr != null) {
                    cVar = new c(bArr);
                    cVar.init();
                    c = cVar;
                } else {
                    s.z("shader");
                    throw null;
                }
            }
            cVar.o(0);
            cVar.p(makeInfo);
            cVar.i();
            return k.a(Integer.valueOf(cVar.a(i2, size, z)), null);
        }
    }

    public final boolean i(d makeInfo) {
        s.h(makeInfo, "makeInfo");
        return b.c(makeInfo.a());
    }

    public final void j(PreviewProcessState value) {
        s.h(value, "value");
        f11770g = value;
        Log.e("UnityTest", s.q("previewProcessState:", value.name()));
    }

    public final void k(us.pinguo.processor.k.c oldProxy) {
        s.h(oldProxy, "oldProxy");
        b = oldProxy;
    }

    public final void l(byte[] shader) {
        s.h(shader, "shader");
        f11767d = shader;
        new g(shader);
    }
}
