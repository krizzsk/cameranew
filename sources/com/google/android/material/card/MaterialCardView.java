package com.google.android.material.card;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import com.google.android.material.R;
import com.google.android.material.shape.i;
import com.google.android.material.shape.m;
import com.google.android.material.shape.o;
/* loaded from: classes2.dex */
public class MaterialCardView extends CardView implements Checkable, o {

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f4159f = {16842911};

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f4160g = {16842912};

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f4161h = {R.attr.state_dragged};

    /* renamed from: i  reason: collision with root package name */
    private static final int f4162i = R.style.Widget_MaterialComponents_CardView;
    @NonNull
    private final com.google.android.material.card.a a;
    private boolean b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4163d;

    /* renamed from: e  reason: collision with root package name */
    private a f4164e;

    /* loaded from: classes2.dex */
    public interface a {
        void a(MaterialCardView materialCardView, boolean z);
    }

    public MaterialCardView(Context context) {
        this(context, null);
    }

    private void h() {
        if (Build.VERSION.SDK_INT > 26) {
            this.a.j();
        }
    }

    @NonNull
    private RectF i() {
        RectF rectF = new RectF();
        rectF.set(this.a.k().getBounds());
        return rectF;
    }

    @Override // androidx.cardview.widget.CardView
    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return this.a.l();
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.a.p().bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.a.p().left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.a.p().right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.a.p().top;
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.a.n();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        return super.getRadius();
    }

    public boolean k() {
        com.google.android.material.card.a aVar = this.a;
        return aVar != null && aVar.s();
    }

    public boolean l() {
        return this.f4163d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(int i2, int i3, int i4, int i5) {
        super.setContentPadding(i2, i3, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.f(this, this.a.k());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 3);
        if (k()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, f4159f);
        }
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, f4160g);
        }
        if (l()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, f4161h);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(k());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.a.u(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.b) {
            if (!this.a.r()) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                this.a.v(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@ColorInt int i2) {
        this.a.w(ColorStateList.valueOf(i2));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f2) {
        super.setCardElevation(f2);
        this.a.O();
    }

    public void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        this.a.x(colorStateList);
    }

    public void setCheckable(boolean z) {
        this.a.y(z);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.c != z) {
            toggle();
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        this.a.z(drawable);
    }

    public void setCheckedIconMargin(@Dimension int i2) {
        this.a.A(i2);
    }

    public void setCheckedIconMarginResource(@DimenRes int i2) {
        if (i2 != -1) {
            this.a.A(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setCheckedIconResource(@DrawableRes int i2) {
        this.a.z(AppCompatResources.getDrawable(getContext(), i2));
    }

    public void setCheckedIconSize(@Dimension int i2) {
        this.a.B(i2);
    }

    public void setCheckedIconSizeResource(@DimenRes int i2) {
        if (i2 != 0) {
            this.a.B(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        this.a.C(colorStateList);
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        com.google.android.material.card.a aVar = this.a;
        if (aVar != null) {
            aVar.M();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int i2, int i3, int i4, int i5) {
        this.a.J(i2, i3, i4, i5);
    }

    public void setDragged(boolean z) {
        if (this.f4163d != z) {
            this.f4163d = z;
            refreshDrawableState();
            h();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f2) {
        super.setMaxCardElevation(f2);
        this.a.Q();
    }

    public void setOnCheckedChangeListener(@Nullable a aVar) {
        this.f4164e = aVar;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.a.Q();
        this.a.N();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.a.E(f2);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f2) {
        super.setRadius(f2);
        this.a.D(f2);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        this.a.F(colorStateList);
    }

    public void setRippleColorResource(@ColorRes int i2) {
        this.a.F(AppCompatResources.getColorStateList(getContext(), i2));
    }

    @Override // com.google.android.material.shape.o
    public void setShapeAppearanceModel(@NonNull m mVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(mVar.u(i()));
        }
        this.a.G(mVar);
    }

    public void setStrokeColor(@ColorInt int i2) {
        this.a.H(ColorStateList.valueOf(i2));
    }

    public void setStrokeWidth(@Dimension int i2) {
        this.a.I(i2);
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.a.Q();
        this.a.N();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (k() && isEnabled()) {
            this.c = !this.c;
            refreshDrawableState();
            h();
            a aVar = this.f4164e;
            if (aVar != null) {
                aVar.a(this, this.c);
            }
        }
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialCardViewStyle);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        this.a.w(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.a.H(colorStateList);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialCardView(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r6 = com.google.android.material.card.MaterialCardView.f4162i
            android.content.Context r8 = com.google.android.material.theme.a.a.c(r8, r9, r10, r6)
            r7.<init>(r8, r9, r10)
            r8 = 0
            r7.c = r8
            r7.f4163d = r8
            r0 = 1
            r7.b = r0
            android.content.Context r0 = r7.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialCardView
            int[] r5 = new int[r8]
            r1 = r9
            r3 = r10
            r4 = r6
            android.content.res.TypedArray r8 = com.google.android.material.internal.k.h(r0, r1, r2, r3, r4, r5)
            com.google.android.material.card.a r0 = new com.google.android.material.card.a
            r0.<init>(r7, r9, r10, r6)
            r7.a = r0
            android.content.res.ColorStateList r9 = super.getCardBackgroundColor()
            r0.w(r9)
            int r9 = super.getContentPaddingLeft()
            int r10 = super.getContentPaddingTop()
            int r1 = super.getContentPaddingRight()
            int r2 = super.getContentPaddingBottom()
            r0.J(r9, r10, r1, r2)
            r0.t(r8)
            r8.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.card.MaterialCardView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
