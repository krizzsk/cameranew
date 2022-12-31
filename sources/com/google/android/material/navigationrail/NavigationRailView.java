package com.google.android.material.navigationrail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R;
import com.google.android.material.internal.k;
import com.google.android.material.navigation.NavigationBarView;
/* loaded from: classes2.dex */
public class NavigationRailView extends NavigationBarView {

    /* renamed from: h  reason: collision with root package name */
    private final int f4414h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private View f4415i;

    public NavigationRailView(@NonNull Context context) {
        this(context, null);
    }

    private NavigationRailMenuView o() {
        return (NavigationRailMenuView) h();
    }

    private boolean p() {
        View view = this.f4415i;
        return (view == null || view.getVisibility() == 8) ? false : true;
    }

    private int q(int i2) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i2) == 1073741824 || suggestedMinimumWidth <= 0) {
            return i2;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), suggestedMinimumWidth + getPaddingLeft() + getPaddingRight()), 1073741824);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int f() {
        return 7;
    }

    public void l(@LayoutRes int i2) {
        m(LayoutInflater.from(getContext()).inflate(i2, (ViewGroup) this, false));
    }

    public void m(@NonNull View view) {
        r();
        this.f4415i = view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = this.f4414h;
        addView(view, 0, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.navigation.NavigationBarView
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* renamed from: n */
    public NavigationRailMenuView e(@NonNull Context context) {
        return new NavigationRailMenuView(context);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        NavigationRailMenuView o = o();
        int i6 = 0;
        if (p()) {
            int bottom = this.f4415i.getBottom() + this.f4414h;
            int top = o.getTop();
            if (top < bottom) {
                i6 = bottom - top;
            }
        } else if (o.t()) {
            i6 = this.f4414h;
        }
        if (i6 > 0) {
            o.layout(o.getLeft(), o.getTop() + i6, o.getRight(), o.getBottom() + i6);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int q = q(i2);
        super.onMeasure(q, i3);
        if (p()) {
            measureChild(o(), q, View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.f4415i.getMeasuredHeight()) - this.f4414h, Integer.MIN_VALUE));
        }
    }

    public void r() {
        View view = this.f4415i;
        if (view != null) {
            removeView(view);
            this.f4415i = null;
        }
    }

    public void setMenuGravity(int i2) {
        o().y(i2);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationRailStyle);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, R.style.Widget_MaterialComponents_NavigationRailView);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f4414h = getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_rail_margin);
        TintTypedArray i4 = k.i(getContext(), attributeSet, R.styleable.NavigationRailView, i2, i3, new int[0]);
        int resourceId = i4.getResourceId(R.styleable.NavigationRailView_headerLayout, 0);
        if (resourceId != 0) {
            l(resourceId);
        }
        setMenuGravity(i4.getInt(R.styleable.NavigationRailView_menuGravity, 49));
        i4.recycle();
    }
}
