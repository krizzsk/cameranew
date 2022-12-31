package com.pinguo.camera360.camera.peanut.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.t.b.a;
import vStudio.Android.Camera360.R;
/* compiled from: VipTimeCountDownView.kt */
/* loaded from: classes3.dex */
public final class VipTimeCountDownView extends View {
    private String[] a;
    private Drawable b;
    private float c;

    /* renamed from: d  reason: collision with root package name */
    private Pair<Float, Float> f6255d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f6256e;

    /* renamed from: f  reason: collision with root package name */
    private float f6257f;

    /* renamed from: g  reason: collision with root package name */
    private float f6258g;

    /* renamed from: h  reason: collision with root package name */
    private float f6259h;

    /* renamed from: i  reason: collision with root package name */
    private float f6260i;

    /* renamed from: j  reason: collision with root package name */
    private final Paint f6261j;

    public VipTimeCountDownView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        new LinkedHashMap();
        String[] strArr = new String[6];
        for (int i3 = 0; i3 < 6; i3++) {
            strArr[i3] = "0";
        }
        this.a = strArr;
        this.f6257f = a.c(getContext(), 2.0f);
        this.f6258g = a.c(getContext(), 3.0f);
        Paint paint = new Paint(1);
        this.f6261j = paint;
        paint.setColor(Color.parseColor("#FFFFFFFF"));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float floatValue;
        s.h(canvas, "canvas");
        if (this.b == null) {
            setCellBackground(R.drawable.time_count_down_bg_dark);
        }
        if (this.f6256e == null) {
            setDotDrawable(R.drawable.time_count_down_dot_white);
        }
        if (this.f6255d == null) {
            setDotSize(new Pair<>(Float.valueOf(us.pinguo.common.widget.i.a.b(2)), Float.valueOf(us.pinguo.common.widget.i.a.b(8))));
        }
        float f2 = 0.0f;
        int i2 = 0;
        while (i2 < 6) {
            int i3 = i2 + 1;
            Drawable drawable = this.b;
            if (drawable != null) {
                drawable.setBounds((int) f2, 0, (int) (this.c + f2), getMeasuredHeight());
                Drawable drawable2 = this.b;
                if (drawable2 != null) {
                    drawable2.draw(canvas);
                    String str = this.a[i2];
                    canvas.drawText(str, ((this.c - this.f6261j.measureText(str)) / 2.0f) + f2, ((getMeasuredHeight() + this.f6259h) / 2.0f) - this.f6260i, this.f6261j);
                    float f3 = f2 + this.c;
                    if (i2 != 1 && i2 != 3) {
                        floatValue = this.f6257f;
                    } else {
                        f3 += this.f6258g;
                        Drawable drawable3 = this.f6256e;
                        if (drawable3 != null) {
                            int i4 = (int) f3;
                            float measuredHeight = getMeasuredHeight();
                            Pair<Float, Float> pair = this.f6255d;
                            if (pair != null) {
                                int floatValue2 = (int) ((measuredHeight - pair.getSecond().floatValue()) / 2.0f);
                                Pair<Float, Float> pair2 = this.f6255d;
                                if (pair2 != null) {
                                    int floatValue3 = (int) (pair2.getFirst().floatValue() + f3);
                                    float measuredHeight2 = getMeasuredHeight();
                                    Pair<Float, Float> pair3 = this.f6255d;
                                    if (pair3 != null) {
                                        drawable3.setBounds(i4, floatValue2, floatValue3, (int) ((measuredHeight2 + pair3.getSecond().floatValue()) / 2.0f));
                                        Drawable drawable4 = this.f6256e;
                                        if (drawable4 != null) {
                                            drawable4.draw(canvas);
                                            Pair<Float, Float> pair4 = this.f6255d;
                                            if (pair4 == null) {
                                                s.z("dotSize");
                                                throw null;
                                            }
                                            floatValue = pair4.getFirst().floatValue() + this.f6258g;
                                        } else {
                                            s.z("dotDrawable");
                                            throw null;
                                        }
                                    } else {
                                        s.z("dotSize");
                                        throw null;
                                    }
                                } else {
                                    s.z("dotSize");
                                    throw null;
                                }
                            } else {
                                s.z("dotSize");
                                throw null;
                            }
                        } else {
                            s.z("dotDrawable");
                            throw null;
                        }
                    }
                    f2 = f3 + floatValue;
                    i2 = i3;
                } else {
                    s.z("cellBgDrawable");
                    throw null;
                }
            } else {
                s.z("cellBgDrawable");
                throw null;
            }
        }
    }

    public final void setCellBackground(int i2) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), i2);
        if (drawable != null) {
            this.b = drawable;
            if (drawable != null) {
                drawable.setCallback(null);
            } else {
                s.z("cellBgDrawable");
                throw null;
            }
        }
    }

    public final void setCellWidth(float f2) {
        this.c = f2;
    }

    public final void setDotDrawable(int i2) {
        if (ContextCompat.getDrawable(getContext(), i2) != null) {
            Drawable drawable = ContextCompat.getDrawable(getContext(), i2);
            s.e(drawable);
            s.g(drawable, "getDrawable(context, res)!!");
            this.f6256e = drawable;
            if (drawable != null) {
                drawable.setCallback(null);
            } else {
                s.z("dotDrawable");
                throw null;
            }
        }
    }

    public final void setDotSize(Pair<Float, Float> size) {
        s.h(size, "size");
        this.f6255d = size;
    }

    public final void setNumTextTypeSize(float f2) {
        this.f6259h = f2;
        this.f6261j.setTextSize(f2);
        this.f6260i = this.f6261j.getFontMetrics().descent / 2.0f;
    }

    public final void setRemainingTimeInMillis(long j2) {
        if (j2 < 0) {
            j2 = 0;
        }
        long j3 = j2 / 1000;
        long j4 = 3600;
        long j5 = j3 / j4;
        long j6 = 10;
        this.a[0] = String.valueOf(j5 / j6);
        this.a[1] = String.valueOf(j5 % j6);
        long j7 = j3 - (j5 * j4);
        long j8 = 60;
        long j9 = j7 / j8;
        this.a[2] = String.valueOf(j9 / j6);
        this.a[3] = String.valueOf(j9 % j6);
        long j10 = j7 - (j9 * j8);
        this.a[4] = String.valueOf(j10 / j6);
        this.a[5] = String.valueOf(j10 % j6);
    }

    public VipTimeCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new LinkedHashMap();
        String[] strArr = new String[6];
        for (int i2 = 0; i2 < 6; i2++) {
            strArr[i2] = "0";
        }
        this.a = strArr;
        this.f6257f = a.c(getContext(), 2.0f);
        this.f6258g = a.c(getContext(), 3.0f);
        Paint paint = new Paint(1);
        this.f6261j = paint;
        paint.setColor(Color.parseColor("#FFFFFFFF"));
    }

    public VipTimeCountDownView(Context context) {
        super(context);
        new LinkedHashMap();
        String[] strArr = new String[6];
        for (int i2 = 0; i2 < 6; i2++) {
            strArr[i2] = "0";
        }
        this.a = strArr;
        this.f6257f = a.c(getContext(), 2.0f);
        this.f6258g = a.c(getContext(), 3.0f);
        Paint paint = new Paint(1);
        this.f6261j = paint;
        paint.setColor(Color.parseColor("#FFFFFFFF"));
    }
}
