package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.google.android.material.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CalendarStyle.java */
/* loaded from: classes2.dex */
public final class b {
    @NonNull
    final a a;
    @NonNull
    final a b;
    @NonNull
    final a c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    final a f4237d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    final a f4238e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    final a f4239f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    final a f4240g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    final Paint f4241h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(com.google.android.material.f.b.c(context, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), R.styleable.MaterialCalendar);
        this.a = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayStyle, 0));
        this.f4240g = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.b = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_daySelectedStyle, 0));
        this.c = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList a = com.google.android.material.f.c.a(context, obtainStyledAttributes, R.styleable.MaterialCalendar_rangeFillColor);
        this.f4237d = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearStyle, 0));
        this.f4238e = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.f4239f = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.f4241h = paint;
        paint.setColor(a.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
