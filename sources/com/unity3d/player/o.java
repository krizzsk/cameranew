package com.unity3d.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
/* loaded from: classes3.dex */
public final class o extends View {
    final int a;
    final int b;
    Bitmap c;

    /* renamed from: d  reason: collision with root package name */
    Bitmap f8419d;

    /* renamed from: com.unity3d.player.o$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.a().length];
            a = iArr;
            try {
                iArr[a.a - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[a.b - 1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[a.c - 1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    static final class a {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;

        /* renamed from: d  reason: collision with root package name */
        private static final /* synthetic */ int[] f8420d = {1, 2, 3};

        public static int[] a() {
            return (int[]) f8420d.clone();
        }
    }

    public o(Context context, int i2) {
        super(context);
        this.a = i2;
        int identifier = getResources().getIdentifier("unity_static_splash", "drawable", getContext().getPackageName());
        this.b = identifier;
        if (identifier != 0) {
            forceLayout();
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.c;
        if (bitmap != null) {
            bitmap.recycle();
            this.c = null;
        }
        Bitmap bitmap2 = this.f8419d;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f8419d = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x006a, code lost:
        if (r14 < r12) goto L37;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        /*
            r9 = this;
            int r10 = r9.b
            if (r10 != 0) goto L5
            return
        L5:
            android.graphics.Bitmap r10 = r9.c
            r11 = 0
            if (r10 != 0) goto L1d
            android.graphics.BitmapFactory$Options r10 = new android.graphics.BitmapFactory$Options
            r10.<init>()
            r10.inScaled = r11
            android.content.res.Resources r12 = r9.getResources()
            int r13 = r9.b
            android.graphics.Bitmap r10 = android.graphics.BitmapFactory.decodeResource(r12, r13, r10)
            r9.c = r10
        L1d:
            android.graphics.Bitmap r10 = r9.c
            int r10 = r10.getWidth()
            android.graphics.Bitmap r12 = r9.c
            int r12 = r12.getHeight()
            int r13 = r9.getWidth()
            int r14 = r9.getHeight()
            if (r13 == 0) goto Lc9
            if (r14 != 0) goto L37
            goto Lc9
        L37:
            float r0 = (float) r10
            float r1 = (float) r12
            float r0 = r0 / r1
            float r1 = (float) r13
            float r2 = (float) r14
            float r3 = r1 / r2
            r4 = 1
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 > 0) goto L45
            r3 = 1
            goto L46
        L45:
            r3 = 0
        L46:
            int[] r5 = com.unity3d.player.o.AnonymousClass1.a
            int r6 = r9.a
            int r7 = r6 + (-1)
            r5 = r5[r7]
            r7 = 2
            if (r5 == r4) goto L65
            if (r5 == r7) goto L57
            r8 = 3
            if (r5 == r8) goto L57
            goto L70
        L57:
            int r10 = com.unity3d.player.o.a.c
            if (r6 != r10) goto L5d
            r10 = 1
            goto L5e
        L5d:
            r10 = 0
        L5e:
            r10 = r10 ^ r3
            if (r10 == 0) goto L6c
            float r1 = r1 / r0
            int r12 = (int) r1
            r10 = r13
            goto L70
        L65:
            if (r13 >= r10) goto L6a
            float r1 = r1 / r0
            int r12 = (int) r1
            r10 = r13
        L6a:
            if (r14 >= r12) goto L70
        L6c:
            float r2 = r2 * r0
            int r10 = (int) r2
            r12 = r14
        L70:
            android.graphics.Bitmap r13 = r9.f8419d
            if (r13 == 0) goto L8f
            int r13 = r13.getWidth()
            if (r13 != r10) goto L83
            android.graphics.Bitmap r13 = r9.f8419d
            int r13 = r13.getHeight()
            if (r13 != r12) goto L83
            return
        L83:
            android.graphics.Bitmap r13 = r9.f8419d
            android.graphics.Bitmap r14 = r9.c
            if (r13 == r14) goto L8f
            r13.recycle()
            r13 = 0
            r9.f8419d = r13
        L8f:
            android.graphics.Bitmap r13 = r9.c
            android.graphics.Bitmap r10 = android.graphics.Bitmap.createScaledBitmap(r13, r10, r12, r4)
            r9.f8419d = r10
            android.content.res.Resources r12 = r9.getResources()
            android.util.DisplayMetrics r12 = r12.getDisplayMetrics()
            int r12 = r12.densityDpi
            r10.setDensity(r12)
            android.graphics.drawable.ColorDrawable r10 = new android.graphics.drawable.ColorDrawable
            r12 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r10.<init>(r12)
            android.graphics.drawable.BitmapDrawable r12 = new android.graphics.drawable.BitmapDrawable
            android.content.res.Resources r13 = r9.getResources()
            android.graphics.Bitmap r14 = r9.f8419d
            r12.<init>(r13, r14)
            r13 = 17
            r12.setGravity(r13)
            android.graphics.drawable.LayerDrawable r13 = new android.graphics.drawable.LayerDrawable
            android.graphics.drawable.Drawable[] r14 = new android.graphics.drawable.Drawable[r7]
            r14[r11] = r10
            r14[r4] = r12
            r13.<init>(r14)
            r9.setBackground(r13)
        Lc9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.o.onLayout(boolean, int, int, int, int):void");
    }
}
