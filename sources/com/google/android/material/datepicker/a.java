package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
/* compiled from: CalendarItemStyle.java */
/* loaded from: classes2.dex */
final class a {
    @NonNull
    private final Rect a;
    private final ColorStateList b;
    private final ColorStateList c;

    /* renamed from: d  reason: collision with root package name */
    private final ColorStateList f4234d;

    /* renamed from: e  reason: collision with root package name */
    private final int f4235e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.android.material.shape.m f4236f;

    private a(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i2, com.google.android.material.shape.m mVar, @NonNull Rect rect) {
        Preconditions.checkArgumentNonnegative(rect.left);
        Preconditions.checkArgumentNonnegative(rect.top);
        Preconditions.checkArgumentNonnegative(rect.right);
        Preconditions.checkArgumentNonnegative(rect.bottom);
        this.a = rect;
        this.b = colorStateList2;
        this.c = colorStateList;
        this.f4234d = colorStateList3;
        this.f4235e = i2;
        this.f4236f = mVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static a a(@NonNull Context context, @StyleRes int i2) {
        Preconditions.checkArgument(i2 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R.styleable.MaterialCalendarItem);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetLeft, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetTop, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetRight, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList a = com.google.android.material.f.c.a(context, obtainStyledAttributes, R.styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList a2 = com.google.android.material.f.c.a(context, obtainStyledAttributes, R.styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList a3 = com.google.android.material.f.c.a(context, obtainStyledAttributes, R.styleable.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        com.google.android.material.shape.m m = com.google.android.material.shape.m.b(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearance, 0), obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).m();
        obtainStyledAttributes.recycle();
        return new a(a, a2, a3, dimensionPixelSize, m, rect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.a.bottom;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.a.top;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(@NonNull TextView textView) {
        com.google.android.material.shape.h hVar = new com.google.android.material.shape.h();
        com.google.android.material.shape.h hVar2 = new com.google.android.material.shape.h();
        hVar.setShapeAppearanceModel(this.f4236f);
        hVar2.setShapeAppearanceModel(this.f4236f);
        hVar.W(this.c);
        hVar.g0(this.f4235e, this.f4234d);
        textView.setTextColor(this.b);
        Drawable rippleDrawable = Build.VERSION.SDK_INT >= 21 ? new RippleDrawable(this.b.withAlpha(30), hVar, hVar2) : hVar;
        Rect rect = this.a;
        ViewCompat.setBackground(textView, new InsetDrawable(rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
