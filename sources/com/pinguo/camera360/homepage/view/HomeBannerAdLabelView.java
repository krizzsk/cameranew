package com.pinguo.camera360.homepage.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
import us.pinguo.util.g;
/* compiled from: HomeBannerAdLabelView.kt */
/* loaded from: classes3.dex */
public final class HomeBannerAdLabelView extends View {
    private final Paint a;
    private final int b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final Path f6807d;

    /* renamed from: e  reason: collision with root package name */
    private final int f6808e;

    /* renamed from: f  reason: collision with root package name */
    private final String f6809f;

    /* renamed from: g  reason: collision with root package name */
    private float f6810g;

    /* renamed from: h  reason: collision with root package name */
    private float f6811h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeBannerAdLabelView(Context context) {
        super(context);
        s.h(context, "context");
        new LinkedHashMap();
        this.a = new Paint(1);
        this.b = Color.parseColor("#33000000");
        this.c = Color.parseColor("#FFFFFFFF");
        this.f6807d = new Path();
        Context context2 = getContext();
        s.g(context2, "context");
        g.a(context2, 20.0f);
        Context context3 = getContext();
        s.g(context3, "context");
        this.f6808e = g.a(context3, 8.0f);
        this.f6809f = "AD";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        s.h(canvas, "canvas");
        this.a.setStyle(Paint.Style.FILL);
        this.a.setColor(this.b);
        canvas.drawPath(this.f6807d, this.a);
        this.a.setColor(this.c);
        canvas.drawText(this.f6809f, this.f6810g, this.f6811h, this.a);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        float measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        this.f6807d.reset();
        this.f6807d.moveTo(0.0f, measuredHeight);
        this.f6807d.arcTo(0.0f, 0.0f, measuredWidth, measuredWidth, 180.0f, 90.0f, false);
        this.f6807d.lineTo(measuredWidth, 0.0f);
        this.f6807d.lineTo(measuredWidth, measuredHeight - this.f6808e);
        Path path = this.f6807d;
        int i4 = this.f6808e;
        path.arcTo(measuredWidth - (i4 * 2.0f), measuredHeight - (i4 * 2.0f), measuredWidth, measuredHeight, 0.0f, 90.0f, false);
        this.f6807d.lineTo(0.0f, measuredHeight);
        Context context = getContext();
        s.g(context, "context");
        float b = g.b(context, 12.0f);
        this.a.setTextSize(b);
        this.f6810g = (measuredWidth - this.a.measureText(this.f6809f)) * 0.5f;
        this.f6811h = (measuredHeight + b) * 0.5f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeBannerAdLabelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = new Paint(1);
        this.b = Color.parseColor("#33000000");
        this.c = Color.parseColor("#FFFFFFFF");
        this.f6807d = new Path();
        Context context2 = getContext();
        s.g(context2, "context");
        g.a(context2, 20.0f);
        Context context3 = getContext();
        s.g(context3, "context");
        this.f6808e = g.a(context3, 8.0f);
        this.f6809f = "AD";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeBannerAdLabelView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = new Paint(1);
        this.b = Color.parseColor("#33000000");
        this.c = Color.parseColor("#FFFFFFFF");
        this.f6807d = new Path();
        Context context2 = getContext();
        s.g(context2, "context");
        g.a(context2, 20.0f);
        Context context3 = getContext();
        s.g(context3, "context");
        this.f6808e = g.a(context3, 8.0f);
        this.f6809f = "AD";
    }
}
