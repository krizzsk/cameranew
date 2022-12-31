package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.t;
/* loaded from: classes.dex */
public class TTRatingBar extends LinearLayout {
    private int a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private float f1863d;

    /* renamed from: e  reason: collision with root package name */
    private float f1864e;

    /* renamed from: f  reason: collision with root package name */
    private float f1865f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f1866g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f1867h;

    /* renamed from: i  reason: collision with root package name */
    private Drawable f1868i;

    public TTRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 5;
        this.b = 0;
        this.c = 0;
        setOrientation(0);
        this.f1866g = t.c(context, "tt_star_empty_bg");
        this.f1867h = t.c(context, "tt_star_full_bg");
        this.f1868i = t.c(context, "tt_star_empty_bg");
        this.f1863d = ac.c(context, 15.0f);
        this.f1864e = ac.c(context, 15.0f);
        this.f1865f = ac.c(context, 5.0f);
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.f1863d), Math.round(this.f1864e)));
        imageView.setPadding(0, 0, Math.round(this.f1865f), 0);
        return imageView;
    }

    public void a() {
        removeAllViews();
        for (int i2 = 0; i2 < getStarFillNum(); i2++) {
            ImageView starImageView = getStarImageView();
            starImageView.setImageDrawable(getStarFillDrawable());
            addView(starImageView);
        }
        for (int i3 = 0; i3 < getStarHalfNum(); i3++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setImageDrawable(getStarHalfDrawable());
            addView(starImageView2);
        }
        for (int i4 = 0; i4 < getStarEmptyNum(); i4++) {
            ImageView starImageView3 = getStarImageView();
            starImageView3.setImageDrawable(getStarEmptyDrawable());
            addView(starImageView3);
        }
    }

    public Drawable getStarEmptyDrawable() {
        return this.f1866g;
    }

    public int getStarEmptyNum() {
        return this.c;
    }

    public Drawable getStarFillDrawable() {
        return this.f1867h;
    }

    public int getStarFillNum() {
        return this.a;
    }

    public Drawable getStarHalfDrawable() {
        return this.f1868i;
    }

    public int getStarHalfNum() {
        return this.b;
    }

    public float getStarImageHeight() {
        return this.f1864e;
    }

    public float getStarImagePadding() {
        return this.f1865f;
    }

    public float getStarImageWidth() {
        return this.f1863d;
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.f1866g = drawable;
    }

    public void setStarEmptyNum(int i2) {
        this.c = i2;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.f1867h = drawable;
    }

    public void setStarFillNum(int i2) {
        this.a = i2;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.f1868i = drawable;
    }

    public void setStarHalfNum(int i2) {
        this.b = i2;
    }

    public void setStarImageHeight(float f2) {
        this.f1864e = f2;
    }

    public void setStarImagePadding(float f2) {
        this.f1865f = f2;
    }

    public void setStarImageWidth(float f2) {
        this.f1863d = f2;
    }
}
