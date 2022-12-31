package us.pinguo.facedetector.pinguo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.util.ArrayList;
import java.util.Comparator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.collections.m;
import kotlin.collections.y;
import kotlin.jvm.internal.s;
import us.pinguo.facedetector.Config;
import us.pinguo.facedetector.ImageMode;
import us.pinguo.facedetector.c;
import us.pinguo.facedetector.d;
import us.pinguo.facedetector_pinguo_jni.PGFaceDetectorJNI;
/* compiled from: PinguoDetector.kt */
/* loaded from: classes4.dex */
public final class b implements d {
    private final PGFaceDetectorJNI a;
    private final long b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f10974d;

    /* renamed from: e  reason: collision with root package name */
    private Config.Mode f10975e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10976f;

    /* renamed from: g  reason: collision with root package name */
    private String f10977g;

    /* renamed from: h  reason: collision with root package name */
    private String f10978h;

    /* renamed from: i  reason: collision with root package name */
    private String f10979i;

    /* compiled from: Comparisons.kt */
    /* loaded from: classes4.dex */
    public static final class a<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int a;
            a = kotlin.w.b.a(Integer.valueOf(((us.pinguo.facedetector.b) t).d()), Integer.valueOf(((us.pinguo.facedetector.b) t2).d()));
            return a;
        }
    }

    public b(String key, String userCode, String productCode) {
        s.i(key, "key");
        s.i(userCode, "userCode");
        s.i(productCode, "productCode");
        this.f10977g = key;
        this.f10978h = userCode;
        this.f10979i = productCode;
        PGFaceDetectorJNI pGFaceDetectorJNI = new PGFaceDetectorJNI();
        this.a = pGFaceDetectorJNI;
        this.b = pGFaceDetectorJNI.nativeCreateHandler();
        this.f10974d = 256;
        this.f10975e = Config.Mode.STATIC_NORMAL;
    }

    private final int g(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return 0;
                }
                return BaseBlurEffect.ROTATION_270;
            }
            return BaseBlurEffect.ROTATION_180;
        }
        return 90;
    }

    private final int h(int i2) {
        if (i2 != 90) {
            if (i2 != 180) {
                return i2 != 270 ? 0 : 1;
            }
            return 2;
        }
        return 3;
    }

    private final int i(ImageMode imageMode) {
        int i2 = us.pinguo.facedetector.pinguo.a.a[imageMode.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            return 11;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    return 3;
                }
                return 2;
            }
            return 1;
        }
        return 0;
    }

    private final int j(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? 0 : 90 : BaseBlurEffect.ROTATION_180 : BaseBlurEffect.ROTATION_270;
    }

    @Override // us.pinguo.facedetector.d
    public Config a() {
        Config config = new Config();
        config.f(j(this.c));
        config.g(this.f10974d);
        config.e(this.f10975e);
        return config;
    }

    @Override // us.pinguo.facedetector.d
    public void b() {
        long j2 = this.b;
        if (0 == j2) {
            return;
        }
        this.a.nativeRewindTrackingState(j2);
    }

    @Override // us.pinguo.facedetector.d
    public void c(Config config) {
        s.i(config, "config");
        this.c = h(config.b());
        this.f10974d = config.c();
        this.f10975e = config.a();
        this.f10976f = config.a() != Config.Mode.STATIC_NORMAL;
    }

    @Override // us.pinguo.facedetector.d
    public c d(byte[] imageData, int i2, int i3, ImageMode imageMode) {
        s.i(imageData, "imageData");
        s.i(imageMode, "imageMode");
        long j2 = this.b;
        if (0 == j2) {
            return new c(new us.pinguo.facedetector.b[0], 0, 0);
        }
        this.a.nativeWaitDetectionFinish(j2);
        float[] nativeRun = this.a.nativeRun(this.b, this.c, imageData, i2, i3, i(imageMode), this.f10974d, this.f10976f);
        if (nativeRun.length == 0) {
            return new c(new us.pinguo.facedetector.b[0], 0, 0);
        }
        int j3 = j(this.c);
        int i4 = (int) nativeRun[0];
        int i5 = (int) nativeRun[1];
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        int i7 = 2;
        while (i6 < i4) {
            int i8 = i7 + 1;
            float f2 = nativeRun[i7];
            int i9 = i8 + 1;
            float f3 = nativeRun[i8];
            int i10 = i9 + 1;
            float f4 = nativeRun[i9];
            int i11 = i10 + 1;
            float f5 = nativeRun[i10];
            int i12 = i11 + 1;
            float f6 = nativeRun[i11];
            int i13 = i12 + 1;
            ArrayList arrayList2 = arrayList;
            double d2 = 180.0f;
            double d3 = ((-nativeRun[i12]) * 3.141592653589793d) / d2;
            int i14 = i13 + 1;
            int i15 = i4;
            float f7 = j3 - nativeRun[i13];
            if (f7 >= 180.0f) {
                f7 = (f7 - 360.0f) % 360.0f;
            }
            double d4 = (f7 * 3.141592653589793d) / d2;
            int i16 = i14 + 1;
            int i17 = j3;
            double d5 = (nativeRun[i14] * 3.141592653589793d) / d2;
            float f8 = nativeRun[i16];
            float[] fArr = new float[212];
            int i18 = i16 + 1 + 10;
            i6++;
            m.d(nativeRun, fArr, 0, i18, (i6 * i5) + 2);
            arrayList2.add(new us.pinguo.facedetector.b((int) f8, new Rect((int) f2, (int) f3, (int) f4, (int) f5), fArr, (float) d5, (float) d3, (float) d4));
            i7 = i18 + 212;
            arrayList = arrayList2;
            i5 = i5;
            nativeRun = nativeRun;
            i4 = i15;
            j3 = i17;
        }
        ArrayList arrayList3 = arrayList;
        if (arrayList3.size() > 1) {
            y.p(arrayList3, new a());
        }
        int g2 = g(this.c);
        Object[] array = arrayList3.toArray(new us.pinguo.facedetector.b[0]);
        if (array != null) {
            c cVar = new c((us.pinguo.facedetector.b[]) array, i2, i3);
            if (g2 != 90 && g2 != 270) {
                cVar.a(g2, false, i2, i3);
            } else {
                cVar.a(g2, false, i3, i2);
            }
            return cVar;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Override // us.pinguo.facedetector.d
    public boolean e(Context context, byte[] model) {
        boolean nativeInit;
        s.i(context, "context");
        s.i(model, "model");
        long j2 = this.b;
        if (0 == j2) {
            return false;
        }
        nativeInit = this.a.nativeInit(j2, (r19 & 2) != 0 ? 1 : 0, (r19 & 4) != 0 ? 0.72f : 0.0f, (r19 & 8) != 0 ? 0.4f : 0.0f, this.f10977g, this.f10978h, this.f10979i);
        return nativeInit;
    }

    @Override // us.pinguo.facedetector.d
    public c f(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            return d(us.pinguo.facedetector.e.a.a(bitmap), bitmap.getWidth(), bitmap.getHeight(), ImageMode.RGBA);
        }
        return new c(new us.pinguo.facedetector.b[0], 0, 0);
    }
}
