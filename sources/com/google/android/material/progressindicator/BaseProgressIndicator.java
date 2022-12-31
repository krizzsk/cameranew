package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.ProgressBar;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.R;
import com.google.android.material.progressindicator.b;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Arrays;
/* loaded from: classes2.dex */
public abstract class BaseProgressIndicator<S extends com.google.android.material.progressindicator.b> extends ProgressBar {
    static final int n = R.style.Widget_MaterialComponents_ProgressIndicator;
    S a;
    private int b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4416d;

    /* renamed from: e  reason: collision with root package name */
    private final int f4417e;

    /* renamed from: f  reason: collision with root package name */
    private long f4418f;

    /* renamed from: g  reason: collision with root package name */
    com.google.android.material.progressindicator.a f4419g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4420h;

    /* renamed from: i  reason: collision with root package name */
    private int f4421i;

    /* renamed from: j  reason: collision with root package name */
    private final Runnable f4422j;

    /* renamed from: k  reason: collision with root package name */
    private final Runnable f4423k;

    /* renamed from: l  reason: collision with root package name */
    private final Animatable2Compat.AnimationCallback f4424l;
    private final Animatable2Compat.AnimationCallback m;

    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseProgressIndicator.this.p();
        }
    }

    /* loaded from: classes2.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseProgressIndicator.this.o();
            BaseProgressIndicator.this.f4418f = -1L;
        }
    }

    /* loaded from: classes2.dex */
    class c extends Animatable2Compat.AnimationCallback {
        c() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
        public void onAnimationEnd(Drawable drawable) {
            BaseProgressIndicator.this.setIndeterminate(false);
            BaseProgressIndicator.this.setProgressCompat(0, false);
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            baseProgressIndicator.setProgressCompat(baseProgressIndicator.b, BaseProgressIndicator.this.c);
        }
    }

    /* loaded from: classes2.dex */
    class d extends Animatable2Compat.AnimationCallback {
        d() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
        public void onAnimationEnd(Drawable drawable) {
            super.onAnimationEnd(drawable);
            if (BaseProgressIndicator.this.f4420h) {
                return;
            }
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            int i2 = baseProgressIndicator.f4421i;
            baseProgressIndicator.setVisibility(i2);
            VdsAgent.onSetViewVisibility(baseProgressIndicator, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(com.google.android.material.theme.a.a.c(context, attributeSet, i2, n), attributeSet, i2);
        this.f4420h = false;
        this.f4421i = 4;
        this.f4422j = new a();
        this.f4423k = new b();
        this.f4424l = new c();
        this.m = new d();
        Context context2 = getContext();
        this.a = i(context2, attributeSet);
        TypedArray h2 = com.google.android.material.internal.k.h(context2, attributeSet, R.styleable.BaseProgressIndicator, i2, i3, new int[0]);
        h2.getInt(R.styleable.BaseProgressIndicator_showDelay, -1);
        this.f4417e = Math.min(h2.getInt(R.styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
        h2.recycle();
        this.f4419g = new com.google.android.material.progressindicator.a();
        this.f4416d = true;
    }

    @Nullable
    private g<S> j() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().t();
        } else if (getProgressDrawable() == null) {
            return null;
        } else {
            return getProgressDrawable().u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        ((f) getCurrentDrawable()).o(false, false, true);
        if (r()) {
            setVisibility(4);
            VdsAgent.onSetViewVisibility(this, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.f4417e > 0) {
            SystemClock.uptimeMillis();
        }
        setVisibility(0);
        VdsAgent.onSetViewVisibility(this, 0);
    }

    private boolean r() {
        return (getProgressDrawable() == null || !getProgressDrawable().isVisible()) && (getIndeterminateDrawable() == null || !getIndeterminateDrawable().isVisible());
    }

    private void s() {
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().s().d(this.f4424l);
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().registerAnimationCallback(this.m);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().registerAnimationCallback(this.m);
        }
    }

    private void t() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().unregisterAnimationCallback(this.m);
            getIndeterminateDrawable().s().h();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().unregisterAnimationCallback(this.m);
        }
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    protected void h(boolean z) {
        if (this.f4416d) {
            ((f) getCurrentDrawable()).o(u(), false, z);
        }
    }

    abstract S i(@NonNull Context context, @NonNull AttributeSet attributeSet);

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    @Override // android.widget.ProgressBar
    @Nullable
    /* renamed from: k */
    public i<S> getIndeterminateDrawable() {
        return (i) super.getIndeterminateDrawable();
    }

    @NonNull
    public int[] l() {
        return this.a.c;
    }

    @Override // android.widget.ProgressBar
    @Nullable
    /* renamed from: m */
    public e<S> getProgressDrawable() {
        return (e) super.getProgressDrawable();
    }

    @Px
    public int n() {
        return this.a.a;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        s();
        if (u()) {
            p();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f4423k);
        removeCallbacks(this.f4422j);
        ((f) getCurrentDrawable()).h();
        t();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(@NonNull Canvas canvas) {
        int save = canvas.save();
        if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
            canvas.translate(getPaddingLeft(), getPaddingTop());
        }
        if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
        }
        getCurrentDrawable().draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i2, int i3) {
        int paddingLeft;
        int paddingTop;
        super.onMeasure(i2, i3);
        g<S> j2 = j();
        if (j2 == null) {
            return;
        }
        int e2 = j2.e();
        int d2 = j2.d();
        if (e2 < 0) {
            paddingLeft = getMeasuredWidth();
        } else {
            paddingLeft = e2 + getPaddingLeft() + getPaddingRight();
        }
        if (d2 < 0) {
            paddingTop = getMeasuredHeight();
        } else {
            paddingTop = d2 + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(paddingLeft, paddingTop);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
        h(i2 == 0);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        h(false);
    }

    boolean q() {
        View view = this;
        while (view.getVisibility() == 0) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                return getWindowVisibility() == 0;
            } else if (!(parent instanceof View)) {
                return true;
            } else {
                view = (View) parent;
            }
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setAnimatorDurationScaleProvider(@NonNull com.google.android.material.progressindicator.a aVar) {
        this.f4419g = aVar;
        if (getProgressDrawable() != null) {
            getProgressDrawable().c = aVar;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().c = aVar;
        }
    }

    public void setHideAnimationBehavior(int i2) {
        this.a.f4433f = i2;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z) {
        if (z == isIndeterminate()) {
            return;
        }
        if (u() && z) {
            throw new IllegalStateException("Cannot switch to indeterminate mode while the progress indicator is visible.");
        }
        f fVar = (f) getCurrentDrawable();
        if (fVar != null) {
            fVar.h();
        }
        super.setIndeterminate(z);
        f fVar2 = (f) getCurrentDrawable();
        if (fVar2 != null) {
            fVar2.o(u(), false, false);
        }
        this.f4420h = false;
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else if (drawable instanceof i) {
            ((f) drawable).h();
            super.setIndeterminateDrawable(drawable);
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
        }
    }

    public void setIndicatorColor(@ColorInt int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{com.google.android.material.b.a.b(getContext(), R.attr.colorPrimary, -1)};
        }
        if (Arrays.equals(l(), iArr)) {
            return;
        }
        this.a.c = iArr;
        getIndeterminateDrawable().s().c();
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i2) {
        if (isIndeterminate()) {
            return;
        }
        setProgressCompat(i2, false);
    }

    public void setProgressCompat(int i2, boolean z) {
        if (isIndeterminate()) {
            if (getProgressDrawable() != null) {
                this.b = i2;
                this.c = z;
                this.f4420h = true;
                if (getIndeterminateDrawable().isVisible() && this.f4419g.a(getContext().getContentResolver()) != 0.0f) {
                    getIndeterminateDrawable().s().f();
                    return;
                } else {
                    this.f4424l.onAnimationEnd(getIndeterminateDrawable());
                    return;
                }
            }
            return;
        }
        super.setProgress(i2);
        if (getProgressDrawable() == null || z) {
            return;
        }
        getProgressDrawable().jumpToCurrentState();
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else if (drawable instanceof e) {
            e eVar = (e) drawable;
            eVar.h();
            super.setProgressDrawable(eVar);
            eVar.y(getProgress() / getMax());
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
        }
    }

    public void setShowAnimationBehavior(int i2) {
        this.a.f4432e = i2;
        invalidate();
    }

    public void setTrackColor(@ColorInt int i2) {
        S s = this.a;
        if (s.f4431d != i2) {
            s.f4431d = i2;
            invalidate();
        }
    }

    public void setTrackCornerRadius(@Px int i2) {
        S s = this.a;
        if (s.b != i2) {
            s.b = Math.min(i2, s.a / 2);
        }
    }

    public void setTrackThickness(@Px int i2) {
        S s = this.a;
        if (s.a != i2) {
            s.a = i2;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i2) {
        if (i2 != 0 && i2 != 4 && i2 != 8) {
            throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
        this.f4421i = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u() {
        return ViewCompat.isAttachedToWindow(this) && getWindowVisibility() == 0 && q();
    }
}
