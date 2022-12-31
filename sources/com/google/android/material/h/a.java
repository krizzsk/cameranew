package com.google.android.material.h;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
/* compiled from: ShadowRenderer.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class a {

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f4317i = new int[3];

    /* renamed from: j  reason: collision with root package name */
    private static final float[] f4318j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f4319k = new int[4];

    /* renamed from: l  reason: collision with root package name */
    private static final float[] f4320l = {0.0f, 0.0f, 0.5f, 1.0f};
    @NonNull
    private final Paint a;
    @NonNull
    private final Paint b;
    @NonNull
    private final Paint c;

    /* renamed from: d  reason: collision with root package name */
    private int f4321d;

    /* renamed from: e  reason: collision with root package name */
    private int f4322e;

    /* renamed from: f  reason: collision with root package name */
    private int f4323f;

    /* renamed from: g  reason: collision with root package name */
    private final Path f4324g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f4325h;

    public a() {
        this(ViewCompat.MEASURED_STATE_MASK);
    }

    public void a(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i2, float f2, float f3) {
        boolean z = f3 < 0.0f;
        Path path = this.f4324g;
        if (z) {
            int[] iArr = f4319k;
            iArr[0] = 0;
            iArr[1] = this.f4323f;
            iArr[2] = this.f4322e;
            iArr[3] = this.f4321d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f2, f3);
            path.close();
            float f4 = -i2;
            rectF.inset(f4, f4);
            int[] iArr2 = f4319k;
            iArr2[0] = 0;
            iArr2[1] = this.f4321d;
            iArr2[2] = this.f4322e;
            iArr2[3] = this.f4323f;
        }
        float width = rectF.width() / 2.0f;
        if (width <= 0.0f) {
            return;
        }
        float f5 = 1.0f - (i2 / width);
        float[] fArr = f4320l;
        fArr[1] = f5;
        fArr[2] = ((1.0f - f5) / 2.0f) + f5;
        this.b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, f4319k, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f4325h);
        }
        canvas.drawArc(rectF, f2, f3, true, this.b);
        canvas.restore();
    }

    public void b(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i2) {
        rectF.bottom += i2;
        rectF.offset(0.0f, -i2);
        int[] iArr = f4317i;
        iArr[0] = this.f4323f;
        iArr[1] = this.f4322e;
        iArr[2] = this.f4321d;
        Paint paint = this.c;
        float f2 = rectF.left;
        paint.setShader(new LinearGradient(f2, rectF.top, f2, rectF.bottom, iArr, f4318j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.c);
        canvas.restore();
    }

    @NonNull
    public Paint c() {
        return this.a;
    }

    public void d(int i2) {
        this.f4321d = ColorUtils.setAlphaComponent(i2, 68);
        this.f4322e = ColorUtils.setAlphaComponent(i2, 20);
        this.f4323f = ColorUtils.setAlphaComponent(i2, 0);
        this.a.setColor(this.f4321d);
    }

    public a(int i2) {
        this.f4324g = new Path();
        this.f4325h = new Paint();
        this.a = new Paint();
        d(i2);
        this.f4325h.setColor(0);
        Paint paint = new Paint(4);
        this.b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.c = new Paint(paint);
    }
}
