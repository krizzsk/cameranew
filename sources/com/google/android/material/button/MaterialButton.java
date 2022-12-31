package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.shape.i;
import com.google.android.material.shape.m;
import com.google.android.material.shape.o;
import java.util.Iterator;
import java.util.LinkedHashSet;
/* loaded from: classes2.dex */
public class MaterialButton extends AppCompatButton implements Checkable, o {
    private static final int[] n = {16842911};
    private static final int[] o = {16842912};
    private static final int p = R.style.Widget_MaterialComponents_Button;
    @NonNull
    private final com.google.android.material.button.a a;
    @NonNull
    private final LinkedHashSet<a> b;
    @Nullable
    private b c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private PorterDuff.Mode f4130d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private ColorStateList f4131e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Drawable f4132f;
    @Px

    /* renamed from: g  reason: collision with root package name */
    private int f4133g;
    @Px

    /* renamed from: h  reason: collision with root package name */
    private int f4134h;
    @Px

    /* renamed from: i  reason: collision with root package name */
    private int f4135i;
    @Px

    /* renamed from: j  reason: collision with root package name */
    private int f4136j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4137k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f4138l;
    private int m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        boolean a;

        /* loaded from: classes2.dex */
        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* renamed from: b */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(@NonNull Parcel parcel) {
            this.a = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.a ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            a(parcel);
        }
    }

    /* loaded from: classes2.dex */
    public interface a {
        void a(MaterialButton materialButton, boolean z);
    }

    /* loaded from: classes2.dex */
    interface b {
        void a(MaterialButton materialButton, boolean z);
    }

    public MaterialButton(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    private String b() {
        return (i() ? CompoundButton.class : Button.class).getName();
    }

    private int g() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int h() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        return Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
    }

    private boolean j() {
        int i2 = this.m;
        return i2 == 3 || i2 == 4;
    }

    private boolean k() {
        int i2 = this.m;
        return i2 == 1 || i2 == 2;
    }

    private boolean l() {
        int i2 = this.m;
        return i2 == 16 || i2 == 32;
    }

    private boolean m() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    private boolean n() {
        com.google.android.material.button.a aVar = this.a;
        return (aVar == null || aVar.j()) ? false : true;
    }

    private void p() {
        if (k()) {
            TextViewCompat.setCompoundDrawablesRelative(this, this.f4132f, null, null, null);
        } else if (j()) {
            TextViewCompat.setCompoundDrawablesRelative(this, null, null, this.f4132f, null);
        } else if (l()) {
            TextViewCompat.setCompoundDrawablesRelative(this, null, this.f4132f, null, null);
        }
    }

    private void t(boolean z) {
        Drawable drawable = this.f4132f;
        if (drawable != null) {
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            this.f4132f = mutate;
            DrawableCompat.setTintList(mutate, this.f4131e);
            PorterDuff.Mode mode = this.f4130d;
            if (mode != null) {
                DrawableCompat.setTintMode(this.f4132f, mode);
            }
            int i2 = this.f4133g;
            if (i2 == 0) {
                i2 = this.f4132f.getIntrinsicWidth();
            }
            int i3 = this.f4133g;
            if (i3 == 0) {
                i3 = this.f4132f.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f4132f;
            int i4 = this.f4134h;
            int i5 = this.f4135i;
            drawable2.setBounds(i4, i5, i2 + i4, i3 + i5);
        }
        if (z) {
            p();
            return;
        }
        Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this);
        boolean z2 = false;
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        if ((k() && drawable3 != this.f4132f) || ((j() && drawable5 != this.f4132f) || (l() && drawable4 != this.f4132f))) {
            z2 = true;
        }
        if (z2) {
            p();
        }
    }

    private void u(int i2, int i3) {
        if (this.f4132f == null || getLayout() == null) {
            return;
        }
        if (!k() && !j()) {
            if (l()) {
                this.f4134h = 0;
                if (this.m == 16) {
                    this.f4135i = 0;
                    t(false);
                    return;
                }
                int i4 = this.f4133g;
                if (i4 == 0) {
                    i4 = this.f4132f.getIntrinsicHeight();
                }
                int g2 = (((((i3 - g()) - getPaddingTop()) - i4) - this.f4136j) - getPaddingBottom()) / 2;
                if (this.f4135i != g2) {
                    this.f4135i = g2;
                    t(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f4135i = 0;
        int i5 = this.m;
        if (i5 != 1 && i5 != 3) {
            int i6 = this.f4133g;
            if (i6 == 0) {
                i6 = this.f4132f.getIntrinsicWidth();
            }
            int h2 = (((((i2 - h()) - ViewCompat.getPaddingEnd(this)) - i6) - this.f4136j) - ViewCompat.getPaddingStart(this)) / 2;
            if (m() != (this.m == 4)) {
                h2 = -h2;
            }
            if (this.f4134h != h2) {
                this.f4134h = h2;
                t(false);
                return;
            }
            return;
        }
        this.f4134h = 0;
        t(false);
    }

    public void a(@NonNull a aVar) {
        this.b.add(aVar);
    }

    public Drawable c() {
        return this.f4132f;
    }

    @Px
    public int d() {
        return this.f4133g;
    }

    @NonNull
    public m e() {
        if (n()) {
            return this.a.e();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    @Px
    public int f() {
        if (n()) {
            return this.a.f();
        }
        return 0;
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        if (n()) {
            return this.a.g();
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (n()) {
            return this.a.h();
        }
        return super.getSupportBackgroundTintMode();
    }

    public boolean i() {
        com.google.android.material.button.a aVar = this.a;
        return aVar != null && aVar.k();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f4137k;
    }

    public void o(@NonNull a aVar) {
        this.b.remove(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (n()) {
            i.f(this, this.a.c());
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (i()) {
            Button.mergeDrawableStates(onCreateDrawableState, n);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(onCreateDrawableState, o);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(b());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(b());
        accessibilityNodeInfo.setCheckable(i());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        com.google.android.material.button.a aVar;
        super.onLayout(z, i2, i3, i4, i5);
        if (Build.VERSION.SDK_INT != 21 || (aVar = this.a) == null) {
            return;
        }
        aVar.C(i5 - i3, i4 - i2);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.a);
    }

    @Override // android.widget.TextView, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.f4137k;
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        u(i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        u(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(@Nullable b bVar) {
        this.c = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(boolean z) {
        if (n()) {
            this.a.u(z);
        }
    }

    @Override // android.view.View
    public void setBackground(@NonNull Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i2) {
        if (n()) {
            this.a.m(i2);
        } else {
            super.setBackgroundColor(i2);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(@NonNull Drawable drawable) {
        if (n()) {
            if (drawable != getBackground()) {
                Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
                this.a.n();
                super.setBackgroundDrawable(drawable);
                return;
            }
            getBackground().setState(drawable.getState());
            return;
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(@DrawableRes int i2) {
        setBackgroundDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (n()) {
            this.a.o(z);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (i() && isEnabled() && this.f4137k != z) {
            this.f4137k = z;
            refreshDrawableState();
            if (this.f4138l) {
                return;
            }
            this.f4138l = true;
            Iterator<a> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().a(this, this.f4137k);
            }
            this.f4138l = false;
        }
    }

    public void setCornerRadius(@Px int i2) {
        if (n()) {
            this.a.p(i2);
        }
    }

    public void setCornerRadiusResource(@DimenRes int i2) {
        if (n()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        if (n()) {
            this.a.c().V(f2);
        }
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (this.f4132f != drawable) {
            this.f4132f = drawable;
            t(true);
            u(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i2) {
        if (this.m != i2) {
            this.m = i2;
            u(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(@Px int i2) {
        if (this.f4136j != i2) {
            this.f4136j = i2;
            setCompoundDrawablePadding(i2);
        }
    }

    public void setIconResource(@DrawableRes int i2) {
        setIcon(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    public void setIconSize(@Px int i2) {
        if (i2 >= 0) {
            if (this.f4133g != i2) {
                this.f4133g = i2;
                t(true);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("iconSize cannot be less than 0");
    }

    public void setIconTint(@Nullable ColorStateList colorStateList) {
        if (this.f4131e != colorStateList) {
            this.f4131e = colorStateList;
            t(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f4130d != mode) {
            this.f4130d = mode;
            t(false);
        }
    }

    public void setIconTintResource(@ColorRes int i2) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), i2));
    }

    public void setInsetBottom(@Dimension int i2) {
        this.a.q(i2);
    }

    public void setInsetTop(@Dimension int i2) {
        this.a.r(i2);
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        b bVar = this.c;
        if (bVar != null) {
            bVar.a(this, z);
        }
        super.setPressed(z);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (n()) {
            this.a.s(colorStateList);
        }
    }

    public void setRippleColorResource(@ColorRes int i2) {
        if (n()) {
            setRippleColor(AppCompatResources.getColorStateList(getContext(), i2));
        }
    }

    @Override // com.google.android.material.shape.o
    public void setShapeAppearanceModel(@NonNull m mVar) {
        if (n()) {
            this.a.t(mVar);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (n()) {
            this.a.v(colorStateList);
        }
    }

    public void setStrokeColorResource(@ColorRes int i2) {
        if (n()) {
            setStrokeColor(AppCompatResources.getColorStateList(getContext(), i2));
        }
    }

    public void setStrokeWidth(@Px int i2) {
        if (n()) {
            this.a.w(i2);
        }
    }

    public void setStrokeWidthResource(@DimenRes int i2) {
        if (n()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (n()) {
            this.a.x(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (n()) {
            this.a.y(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f4137k);
    }

    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialButton(@androidx.annotation.NonNull android.content.Context r9, @androidx.annotation.Nullable android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r6 = com.google.android.material.button.MaterialButton.p
            android.content.Context r9 = com.google.android.material.theme.a.a.c(r9, r10, r11, r6)
            r8.<init>(r9, r10, r11)
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.b = r9
            r9 = 0
            r8.f4137k = r9
            r8.f4138l = r9
            android.content.Context r7 = r8.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialButton
            int[] r5 = new int[r9]
            r0 = r7
            r1 = r10
            r3 = r11
            r4 = r6
            android.content.res.TypedArray r0 = com.google.android.material.internal.k.h(r0, r1, r2, r3, r4, r5)
            int r1 = com.google.android.material.R.styleable.MaterialButton_iconPadding
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.f4136j = r1
            int r1 = com.google.android.material.R.styleable.MaterialButton_iconTintMode
            r2 = -1
            int r1 = r0.getInt(r1, r2)
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r1 = com.google.android.material.internal.p.i(r1, r2)
            r8.f4130d = r1
            android.content.Context r1 = r8.getContext()
            int r2 = com.google.android.material.R.styleable.MaterialButton_iconTint
            android.content.res.ColorStateList r1 = com.google.android.material.f.c.a(r1, r0, r2)
            r8.f4131e = r1
            android.content.Context r1 = r8.getContext()
            int r2 = com.google.android.material.R.styleable.MaterialButton_icon
            android.graphics.drawable.Drawable r1 = com.google.android.material.f.c.d(r1, r0, r2)
            r8.f4132f = r1
            int r1 = com.google.android.material.R.styleable.MaterialButton_iconGravity
            r2 = 1
            int r1 = r0.getInteger(r1, r2)
            r8.m = r1
            int r1 = com.google.android.material.R.styleable.MaterialButton_iconSize
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.f4133g = r1
            com.google.android.material.shape.m$b r10 = com.google.android.material.shape.m.e(r7, r10, r11, r6)
            com.google.android.material.shape.m r10 = r10.m()
            com.google.android.material.button.a r11 = new com.google.android.material.button.a
            r11.<init>(r8, r10)
            r8.a = r11
            r11.l(r0)
            r0.recycle()
            int r10 = r8.f4136j
            r8.setCompoundDrawablePadding(r10)
            android.graphics.drawable.Drawable r10 = r8.f4132f
            if (r10 == 0) goto L84
            r9 = 1
        L84:
            r8.t(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
