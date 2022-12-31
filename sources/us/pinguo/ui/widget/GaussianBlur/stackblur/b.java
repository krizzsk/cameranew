package us.pinguo.ui.widget.GaussianBlur.stackblur;

import android.graphics.Bitmap;
import androidx.core.view.ViewCompat;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import us.pinguo.foundation.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JavaBlurProcess.java */
/* loaded from: classes6.dex */
public class b implements us.pinguo.ui.widget.GaussianBlur.stackblur.a {
    private static final short[] a = {512, 512, 456, 512, 328, 456, 335, 512, 405, 328, 271, 456, 388, 335, 292, 512, 454, 405, 364, 328, 298, 271, 496, 456, 420, 388, 360, 335, 312, 292, 273, 512, 482, 454, 428, 405, 383, 364, 345, 328, 312, 298, 284, 271, 259, 496, 475, 456, 437, 420, 404, 388, 374, 360, 347, 335, 323, 312, 302, 292, 282, 273, 265, 512, 497, 482, 468, 454, 441, 428, 417, 405, 394, 383, 373, 364, 354, 345, 337, 328, 320, 312, 305, 298, 291, 284, 278, 271, 265, 259, 507, 496, 485, 475, 465, 456, 446, 437, 428, 420, 412, 404, 396, 388, 381, 374, 367, 360, 354, 347, 341, 335, 329, 323, 318, 312, 307, 302, 297, 292, 287, 282, 278, 273, 269, 265, 261, 512, 505, 497, 489, 482, 475, 468, 461, 454, 447, 441, 435, 428, 422, 417, 411, 405, 399, 394, 389, 383, 378, 373, 368, 364, 359, 354, 350, 345, 341, 337, 332, 328, 324, 320, 316, 312, 309, 305, 301, 298, 294, 291, 287, 284, 281, 278, 274, 271, 268, 265, 262, 259, 257, 507, 501, 496, 491, 485, 480, 475, 470, 465, 460, 456, 451, 446, 442, 437, 433, 428, 424, 420, 416, 412, 408, 404, 400, 396, 392, 388, 385, 381, 377, 374, 370, 367, 363, 360, 357, 354, 350, 347, 344, 341, 338, 335, 332, 329, 326, 323, 320, 318, 315, 312, 310, 307, 304, 302, 299, 297, 294, 292, 289, 287, 285, 282, 280, 278, 275, 273, 271, 269, 267, 265, 263, 261, 259};
    private static final byte[] b = {9, 11, 12, Draft_75.CR, Draft_75.CR, 14, 14, 15, 15, 15, 15, 16, 16, 16, 16, 17, 17, 17, 17, 17, 17, 17, 18, 18, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24};

    /* compiled from: JavaBlurProcess.java */
    /* loaded from: classes6.dex */
    private static class a implements Callable<Void> {
        private final int[] a;
        private final int b;
        private final int c;

        /* renamed from: d  reason: collision with root package name */
        private final int f12145d;

        /* renamed from: e  reason: collision with root package name */
        private final int f12146e;

        /* renamed from: f  reason: collision with root package name */
        private final int f12147f;

        /* renamed from: g  reason: collision with root package name */
        private final int f12148g;

        public a(int[] iArr, int i2, int i3, int i4, int i5, int i6, int i7) {
            this.a = iArr;
            this.b = i2;
            this.c = i3;
            this.f12145d = i4;
            this.f12146e = i5;
            this.f12147f = i6;
            this.f12148g = i7;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            b.c(this.a, this.b, this.c, this.f12145d, this.f12146e, this.f12147f, this.f12148g);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(int[] iArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8;
        int i9 = i2 - 1;
        int i10 = i3 - 1;
        int i11 = (i4 * 2) + 1;
        short s = a[i4];
        byte b2 = b[i4];
        int[] iArr2 = new int[i11];
        if (i7 == 1) {
            int i12 = ((i6 + 1) * i3) / i5;
            for (int i13 = (i6 * i3) / i5; i13 < i12; i13++) {
                int i14 = i2 * i13;
                int i15 = 0;
                long j2 = 0;
                long j3 = 0;
                long j4 = 0;
                long j5 = 0;
                long j6 = 0;
                long j7 = 0;
                while (i15 <= i4) {
                    iArr2[i15] = iArr[i14];
                    i15++;
                    j2 += ((iArr[i14] >>> 16) & 255) * i15;
                    j3 += ((iArr[i14] >>> 8) & 255) * i15;
                    j4 += (iArr[i14] & 255) * i15;
                    j5 += (iArr[i14] >>> 16) & 255;
                    j6 += (iArr[i14] >>> 8) & 255;
                    j7 += iArr[i14] & 255;
                }
                int i16 = i14;
                long j8 = 0;
                long j9 = 0;
                long j10 = 0;
                for (int i17 = 1; i17 <= i4; i17++) {
                    if (i17 <= i9) {
                        i16++;
                    }
                    iArr2[i17 + i4] = iArr[i16];
                    int i18 = (i4 + 1) - i17;
                    j2 += ((iArr[i16] >>> 16) & 255) * i18;
                    j3 += ((iArr[i16] >>> 8) & 255) * i18;
                    j4 += (iArr[i16] & 255) * i18;
                    j8 += (iArr[i16] >>> 16) & 255;
                    j9 += (iArr[i16] >>> 8) & 255;
                    j10 += iArr[i16] & 255;
                }
                int i19 = i4 > i9 ? i9 : i4;
                int i20 = i19 + i14;
                int i21 = i4;
                int i22 = 0;
                while (i22 < i2) {
                    int i23 = i12;
                    long j11 = j8;
                    int i24 = i20;
                    int i25 = i22;
                    long j12 = s;
                    iArr[i14] = (int) ((((j12 * j4) >>> b2) & 255) | (iArr[i14] & ViewCompat.MEASURED_STATE_MASK) | ((((j2 * j12) >>> b2) & 255) << 16) | ((((j3 * j12) >>> b2) & 255) << 8));
                    i14++;
                    long j13 = j2 - j5;
                    long j14 = j3 - j6;
                    long j15 = j4 - j7;
                    int i26 = (i21 + i11) - i4;
                    if (i26 >= i11) {
                        i26 -= i11;
                    }
                    long j16 = j5 - ((iArr2[i26] >>> 16) & 255);
                    long j17 = j6 - ((iArr2[i26] >>> 8) & 255);
                    long j18 = j7 - (iArr2[i26] & 255);
                    if (i19 < i9) {
                        i8 = i24 + 1;
                        i19++;
                    } else {
                        i8 = i24;
                    }
                    iArr2[i26] = iArr[i8];
                    long j19 = j11 + ((iArr[i8] >>> 16) & 255);
                    int i27 = i19;
                    short s2 = s;
                    long j20 = j9 + ((iArr[i8] >>> 8) & 255);
                    long j21 = j10 + (iArr[i8] & 255);
                    j2 = j13 + j19;
                    j3 = j14 + j20;
                    j4 = j15 + j21;
                    i21++;
                    if (i21 >= i11) {
                        i21 = 0;
                    }
                    j5 = j16 + ((iArr2[i21] >>> 16) & 255);
                    j6 = j17 + ((iArr2[i21] >>> 8) & 255);
                    j7 = j18 + (iArr2[i21] & 255);
                    j8 = j19 - ((iArr2[i21] >>> 16) & 255);
                    j9 = j20 - ((iArr2[i21] >>> 8) & 255);
                    j10 = j21 - (iArr2[i21] & 255);
                    i19 = i27;
                    i20 = i8;
                    s = s2;
                    i22 = i25 + 1;
                    i12 = i23;
                }
            }
            return;
        }
        short s3 = s;
        if (i7 == 2) {
            int i28 = (i6 * i2) / i5;
            int i29 = ((i6 + 1) * i2) / i5;
            while (i28 < i29) {
                int i30 = 0;
                long j22 = 0;
                long j23 = 0;
                long j24 = 0;
                long j25 = 0;
                long j26 = 0;
                long j27 = 0;
                while (i30 <= i4) {
                    iArr2[i30] = iArr[i28];
                    i30++;
                    j22 += ((iArr[i28] >>> 16) & 255) * i30;
                    j23 += ((iArr[i28] >>> 8) & 255) * i30;
                    j24 += (iArr[i28] & 255) * i30;
                    j25 += (iArr[i28] >>> 16) & 255;
                    j26 += (iArr[i28] >>> 8) & 255;
                    j27 += iArr[i28] & 255;
                    b2 = b2;
                }
                byte b3 = b2;
                int i31 = i28;
                int i32 = 1;
                long j28 = 0;
                long j29 = 0;
                long j30 = 0;
                while (i32 <= i4) {
                    if (i32 <= i10) {
                        i31 += i2;
                    }
                    iArr2[i32 + i4] = iArr[i31];
                    int i33 = (i4 + 1) - i32;
                    j22 += ((iArr[i31] >>> 16) & 255) * i33;
                    j23 += ((iArr[i31] >>> 8) & 255) * i33;
                    j24 += (iArr[i31] & 255) * i33;
                    j28 += (iArr[i31] >>> 16) & 255;
                    j29 += (iArr[i31] >>> 8) & 255;
                    j30 += iArr[i31] & 255;
                    i32++;
                    iArr2 = iArr2;
                }
                int[] iArr3 = iArr2;
                int i34 = i4 > i10 ? i10 : i4;
                int i35 = (i34 * i2) + i28;
                int i36 = i4;
                int i37 = i28;
                int i38 = 0;
                while (i38 < i3) {
                    int i39 = i28;
                    int i40 = i29;
                    int i41 = i35;
                    short s4 = s3;
                    int i42 = i38;
                    long j31 = s4;
                    iArr[i37] = (int) ((iArr[i37] & ViewCompat.MEASURED_STATE_MASK) | ((((j22 * j31) >>> b3) & 255) << 16) | ((((j23 * j31) >>> b3) & 255) << 8) | (((j31 * j24) >>> b3) & 255));
                    i37 += i2;
                    long j32 = j22 - j25;
                    long j33 = j23 - j26;
                    long j34 = j24 - j27;
                    int i43 = (i36 + i11) - i4;
                    if (i43 >= i11) {
                        i43 -= i11;
                    }
                    long j35 = j25 - ((iArr3[i43] >>> 16) & 255);
                    long j36 = j26 - ((iArr3[i43] >>> 8) & 255);
                    long j37 = j27 - (iArr3[i43] & 255);
                    if (i34 < i10) {
                        i35 = i41 + i2;
                        i34++;
                    } else {
                        i35 = i41;
                    }
                    iArr3[i43] = iArr[i35];
                    long j38 = j28 + ((iArr[i35] >>> 16) & 255);
                    long j39 = j29 + ((iArr[i35] >>> 8) & 255);
                    long j40 = j30 + (iArr[i35] & 255);
                    j22 = j32 + j38;
                    j23 = j33 + j39;
                    j24 = j34 + j40;
                    int i44 = i36 + 1;
                    i36 = i44 >= i11 ? 0 : i44;
                    j25 = j35 + ((iArr3[i36] >>> 16) & 255);
                    j26 = j36 + ((iArr3[i36] >>> 8) & 255);
                    j27 = j37 + (iArr3[i36] & 255);
                    j28 = j38 - ((iArr3[i36] >>> 16) & 255);
                    j29 = j39 - ((iArr3[i36] >>> 8) & 255);
                    j30 = j40 - (iArr3[i36] & 255);
                    i38 = i42 + 1;
                    i29 = i40;
                    s3 = s4;
                    i28 = i39;
                }
                i28++;
                b2 = b3;
                iArr2 = iArr3;
            }
        }
    }

    @Override // us.pinguo.ui.widget.GaussianBlur.stackblur.a
    public Bitmap a(Bitmap bitmap, float f2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i2 = c.f12149d;
        ArrayList arrayList = new ArrayList(i2);
        ArrayList arrayList2 = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = (int) f2;
            int i5 = i3;
            arrayList.add(new a(iArr, width, height, i4, i2, i5, 1));
            arrayList2.add(new a(iArr, width, height, i4, i2, i5, 2));
        }
        try {
            ExecutorService executorService = c.f12150e;
            executorService.invokeAll(arrayList);
            try {
                executorService.invokeAll(arrayList2);
                return Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
            } catch (InterruptedException e2) {
                e.e(e2);
                return null;
            }
        } catch (InterruptedException e3) {
            e.e(e3);
            return null;
        }
    }
}
