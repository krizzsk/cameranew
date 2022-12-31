package com.google.android.material.i;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.f.c;
import com.google.android.material.f.d;
import com.google.android.material.internal.h;
import com.google.android.material.internal.k;
import com.google.android.material.shape.f;
import com.google.android.material.shape.g;
import com.google.android.material.shape.h;
import com.google.android.material.shape.j;
import com.google.android.material.shape.m;
/* compiled from: TooltipDrawable.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class a extends h implements h.b {
    @Nullable
    private final Paint.FontMetrics A;
    @NonNull
    private final com.google.android.material.internal.h B;
    @NonNull
    private final View.OnLayoutChangeListener C;
    @NonNull
    private final Rect D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private float K;
    private float L;
    private float M;
    private float N;
    @Nullable
    private CharSequence y;
    @NonNull
    private final Context z;

    /* compiled from: TooltipDrawable.java */
    /* renamed from: com.google.android.material.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class View$OnLayoutChangeListenerC0174a implements View.OnLayoutChangeListener {
        View$OnLayoutChangeListenerC0174a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            a.this.A0(view);
        }
    }

    private a(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(context, attributeSet, i2, i3);
        this.A = new Paint.FontMetrics();
        com.google.android.material.internal.h hVar = new com.google.android.material.internal.h(this);
        this.B = hVar;
        this.C = new View$OnLayoutChangeListenerC0174a();
        this.D = new Rect();
        this.K = 1.0f;
        this.L = 1.0f;
        this.M = 0.5f;
        this.N = 1.0f;
        this.z = context;
        hVar.e().density = context.getResources().getDisplayMetrics().density;
        hVar.e().setTextAlign(Paint.Align.CENTER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(@NonNull View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.J = iArr[0];
        view.getWindowVisibleDisplayFrame(this.D);
    }

    private float n0() {
        int i2;
        if (((this.D.right - getBounds().right) - this.J) - this.H < 0) {
            i2 = ((this.D.right - getBounds().right) - this.J) - this.H;
        } else if (((this.D.left - getBounds().left) - this.J) + this.H <= 0) {
            return 0.0f;
        } else {
            i2 = ((this.D.left - getBounds().left) - this.J) + this.H;
        }
        return i2;
    }

    private float o0() {
        this.B.e().getFontMetrics(this.A);
        Paint.FontMetrics fontMetrics = this.A;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private float p0(@NonNull Rect rect) {
        return rect.centerY() - o0();
    }

    @NonNull
    public static a q0(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        a aVar = new a(context, attributeSet, i2, i3);
        aVar.v0(attributeSet, i2, i3);
        return aVar;
    }

    private f r0() {
        float width = ((float) (getBounds().width() - (this.I * Math.sqrt(2.0d)))) / 2.0f;
        return new j(new g(this.I), Math.min(Math.max(-n0(), -width), width));
    }

    private void t0(@NonNull Canvas canvas) {
        if (this.y == null) {
            return;
        }
        Rect bounds = getBounds();
        int p0 = (int) p0(bounds);
        if (this.B.d() != null) {
            this.B.e().drawableState = getState();
            this.B.j(this.z);
            this.B.e().setAlpha((int) (this.N * 255.0f));
        }
        CharSequence charSequence = this.y;
        canvas.drawText(charSequence, 0, charSequence.length(), bounds.centerX(), p0, this.B.e());
    }

    private float u0() {
        CharSequence charSequence = this.y;
        if (charSequence == null) {
            return 0.0f;
        }
        return this.B.f(charSequence.toString());
    }

    private void v0(@Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        TypedArray h2 = k.h(this.z, attributeSet, R.styleable.Tooltip, i2, i3, new int[0]);
        this.I = this.z.getResources().getDimensionPixelSize(R.dimen.mtrl_tooltip_arrowSize);
        m.b v = C().v();
        v.s(r0());
        setShapeAppearanceModel(v.m());
        y0(h2.getText(R.styleable.Tooltip_android_text));
        z0(c.f(this.z, h2, R.styleable.Tooltip_android_textAppearance));
        W(ColorStateList.valueOf(h2.getColor(R.styleable.Tooltip_backgroundTint, com.google.android.material.b.a.g(ColorUtils.setAlphaComponent(com.google.android.material.b.a.c(this.z, 16842801, a.class.getCanonicalName()), 229), ColorUtils.setAlphaComponent(com.google.android.material.b.a.c(this.z, R.attr.colorOnBackground, a.class.getCanonicalName()), 153)))));
        h0(ColorStateList.valueOf(com.google.android.material.b.a.c(this.z, R.attr.colorSurface, a.class.getCanonicalName())));
        this.E = h2.getDimensionPixelSize(R.styleable.Tooltip_android_padding, 0);
        this.F = h2.getDimensionPixelSize(R.styleable.Tooltip_android_minWidth, 0);
        this.G = h2.getDimensionPixelSize(R.styleable.Tooltip_android_minHeight, 0);
        this.H = h2.getDimensionPixelSize(R.styleable.Tooltip_android_layout_margin, 0);
        h2.recycle();
    }

    @Override // com.google.android.material.internal.h.b
    public void a() {
        invalidateSelf();
    }

    @Override // com.google.android.material.shape.h, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        canvas.save();
        canvas.scale(this.K, this.L, getBounds().left + (getBounds().width() * 0.5f), getBounds().top + (getBounds().height() * this.M));
        canvas.translate(n0(), (float) (-((this.I * Math.sqrt(2.0d)) - this.I)));
        super.draw(canvas);
        t0(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) Math.max(this.B.e().getTextSize(), this.G);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) Math.max((this.E * 2) + u0(), this.F);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.shape.h, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m.b v = C().v();
        v.s(r0());
        setShapeAppearanceModel(v.m());
    }

    @Override // com.google.android.material.shape.h, android.graphics.drawable.Drawable, com.google.android.material.internal.h.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public void s0(@Nullable View view) {
        if (view == null) {
            return;
        }
        view.removeOnLayoutChangeListener(this.C);
    }

    public void w0(@Nullable View view) {
        if (view == null) {
            return;
        }
        A0(view);
        view.addOnLayoutChangeListener(this.C);
    }

    public void x0(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.M = 1.2f;
        this.K = f2;
        this.L = f2;
        this.N = com.google.android.material.animation.a.b(0.0f, 1.0f, 0.19f, 1.0f, f2);
        invalidateSelf();
    }

    public void y0(@Nullable CharSequence charSequence) {
        if (TextUtils.equals(this.y, charSequence)) {
            return;
        }
        this.y = charSequence;
        this.B.i(true);
        invalidateSelf();
    }

    public void z0(@Nullable d dVar) {
        this.B.h(dVar, this.z);
    }
}
