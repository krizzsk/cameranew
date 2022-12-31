package com.camera360.dynamic_feature_splice;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
/* compiled from: SpliceUtils.kt */
/* loaded from: classes8.dex */
public final class SpliceUtils {
    public static final SpliceUtils a = new SpliceUtils();
    private static final RectF b = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    private static final kotlin.f c;

    static {
        kotlin.f b2;
        b2 = kotlin.h.b(SpliceUtils$spliceWidth$2.INSTANCE);
        c = b2;
    }

    private SpliceUtils() {
    }

    private final boolean f(Bitmap bitmap, String str) {
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(copy);
        canvas.drawColor(-1);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
            BufferedOutputStream bufferedOutputStream = fileOutputStream instanceof BufferedOutputStream ? (BufferedOutputStream) fileOutputStream : new BufferedOutputStream(fileOutputStream, 8192);
            copy.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
            kotlin.io.b.a(bufferedOutputStream, null);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(java.lang.String r8, java.lang.String r9, kotlin.coroutines.Continuation<? super android.graphics.Point> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.camera360.dynamic_feature_splice.SpliceUtils$coverOther2jpg$1
            if (r0 == 0) goto L13
            r0 = r10
            com.camera360.dynamic_feature_splice.SpliceUtils$coverOther2jpg$1 r0 = (com.camera360.dynamic_feature_splice.SpliceUtils$coverOther2jpg$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.camera360.dynamic_feature_splice.SpliceUtils$coverOther2jpg$1 r0 = new com.camera360.dynamic_feature_splice.SpliceUtils$coverOther2jpg$1
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r0 = r0.L$0
            com.camera360.dynamic_feature_splice.SpliceUtils r0 = (com.camera360.dynamic_feature_splice.SpliceUtils) r0
            kotlin.j.b(r10)
            goto L62
        L33:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3b:
            kotlin.j.b(r10)
            android.content.res.Resources r10 = android.content.res.Resources.getSystem()
            android.util.DisplayMetrics r10 = r10.getDisplayMetrics()
            int r10 = r10.heightPixels
            float r10 = (float) r10
            r2 = 1067030938(0x3f99999a, float:1.2)
            float r10 = r10 * r2
            int r10 = (int) r10
            r0.L$0 = r7
            r0.L$1 = r9
            r0.I$0 = r10
            r0.label = r3
            java.lang.Object r8 = us.pinguo.util.FileIOUtils.c(r8, r0)
            if (r8 != r1) goto L5e
            return r1
        L5e:
            r0 = r7
            r6 = r10
            r10 = r8
            r8 = r6
        L62:
            byte[] r10 = (byte[]) r10
            r1 = 0
            if (r10 != 0) goto L68
            return r1
        L68:
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options
            r2.<init>()
            r2.inSampleSize = r3
            r2.inJustDecodeBounds = r3
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream
            r4.<init>(r10)
            android.graphics.BitmapFactory.decodeStream(r4, r1, r2)
            int r4 = r2.outWidth
            int r5 = r2.outHeight
            if (r4 <= 0) goto Lbd
            if (r5 > 0) goto L82
            goto Lbd
        L82:
            int r4 = java.lang.Math.max(r4, r5)
            float r4 = (float) r4
            float r8 = (float) r8
            float r4 = r4 / r8
            r8 = 1045220557(0x3e4ccccd, float:0.2)
            float r4 = r4 + r8
            int r8 = (int) r4
            if (r8 >= r3) goto L91
            goto L92
        L91:
            r3 = r8
        L92:
            r2.inSampleSize = r3
            r8 = 0
            r2.inJustDecodeBounds = r8
            r2.inDither = r8
            android.graphics.Bitmap$Config r8 = android.graphics.Bitmap.Config.ARGB_8888
            r2.inPreferredConfig = r8
            java.io.ByteArrayInputStream r8 = new java.io.ByteArrayInputStream
            r8.<init>(r10)
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeStream(r8, r1, r2)
            if (r8 != 0) goto La9
            return r1
        La9:
            boolean r9 = r0.f(r8, r9)
            if (r9 == 0) goto Lbd
            android.graphics.Point r9 = new android.graphics.Point
            int r10 = r8.getWidth()
            int r8 = r8.getHeight()
            r9.<init>(r10, r8)
            return r9
        Lbd:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.camera360.dynamic_feature_splice.SpliceUtils.g(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0090 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(com.camera360.dynamic_feature_splice.m1 r8, android.graphics.Point r9, float r10, java.lang.String r11, kotlin.coroutines.Continuation<? super java.lang.String> r12) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.camera360.dynamic_feature_splice.SpliceUtils.h(com.camera360.dynamic_feature_splice.m1, android.graphics.Point, float, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(com.camera360.dynamic_feature_splice.m1 r18, java.lang.String r19, kotlin.coroutines.Continuation<? super us.pinguo.image.SpliceInfo> r20) {
        /*
            Method dump skipped, instructions count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.camera360.dynamic_feature_splice.SpliceUtils.i(com.camera360.dynamic_feature_splice.m1, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00aa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(com.camera360.dynamic_feature_splice.m1 r12, java.lang.String r13, kotlin.coroutines.Continuation<? super us.pinguo.image.SpliceInfo> r14) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.camera360.dynamic_feature_splice.SpliceUtils.j(com.camera360.dynamic_feature_splice.m1, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Rect k(RectF rectF) {
        return new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    private final int l(Point point, int i2, int i3, RectF rectF) {
        int i4;
        if (i3 != 90 && i3 != 270) {
            i4 = point.x;
        } else {
            i4 = point.y;
        }
        float width = ((i4 * (rectF == null ? 1.0f : rectF.width())) / i2) + 0.2f;
        int i5 = 1;
        if (width < 2.0f) {
            return 1;
        }
        while (width >= 2.0f) {
            i5 *= 2;
            width /= 2.0f;
        }
        return i5;
    }

    private final int m() {
        return ((Number) c.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0077 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(java.lang.String r18, android.graphics.Point r19, int r20, int r21, android.graphics.RectF r22, kotlin.coroutines.Continuation<? super android.graphics.Bitmap> r23) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.camera360.dynamic_feature_splice.SpliceUtils.n(java.lang.String, android.graphics.Point, int, int, android.graphics.RectF, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0112 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b3  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00f7 -> B:45:0x011f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0113 -> B:44:0x0119). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object o(java.util.List<com.camera360.dynamic_feature_splice.m1> r11, java.lang.String r12, kotlin.coroutines.Continuation<? super java.lang.Boolean> r13) {
        /*
            Method dump skipped, instructions count: 470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.camera360.dynamic_feature_splice.SpliceUtils.o(java.util.List, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.String r10, int r11, int r12, int r13, kotlin.coroutines.Continuation<? super java.util.ArrayList<android.graphics.Bitmap>> r14) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.camera360.dynamic_feature_splice.SpliceUtils.p(java.lang.String, int, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
