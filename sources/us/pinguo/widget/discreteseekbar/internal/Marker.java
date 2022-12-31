package us.pinguo.widget.discreteseekbar.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.common.network.common.header.PGTransHeader;
import us.pinguo.widget.discreteseekbar.R;
import us.pinguo.widget.discreteseekbar.internal.a.c;
import us.pinguo.widget.discreteseekbar.internal.b.b;
/* loaded from: classes6.dex */
public class Marker extends ViewGroup implements b.InterfaceC0469b {
    private TextView a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    b f12547d;

    /* renamed from: e  reason: collision with root package name */
    private int f12548e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12549f;

    public Marker(Context context, AttributeSet attributeSet, int i2, String str, int i3, int i4, boolean z, ColorStateList colorStateList, int i5) {
        super(context, attributeSet, i2);
        this.f12548e = 30;
        this.f12549f = true;
        setVisibility(0);
        VdsAgent.onSetViewVisibility(this, 0);
        this.f12549f = z;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DiscreteSeekBar, R.attr.discreteSeekBarStyle, R.style.Widget_DiscreteSeekBar);
        int i6 = ((int) (displayMetrics.density * 0.0f)) * 2;
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.DiscreteSeekBar_dsb_indicatorTextAppearance, R.style.Widget_DiscreteIndicatorTextAppearance);
        TextView textView = new TextView(context);
        this.a = textView;
        textView.setPadding(i6, 0, i6, 0);
        this.a.setTextAppearance(context, resourceId);
        this.a.setGravity(17);
        this.a.setText(str);
        this.a.setMaxLines(1);
        this.a.setSingleLine(true);
        c.h(this.a, 5);
        TextView textView2 = this.a;
        textView2.setVisibility(4);
        VdsAgent.onSetViewVisibility(textView2, 4);
        if (colorStateList != null) {
            this.a.setTextColor(colorStateList);
        }
        if (i5 > 0) {
            this.a.setTextSize(0, i5);
        }
        setPadding(i6, i6, i6, i6);
        e(str);
        this.c = i4;
        b bVar = new b(obtainStyledAttributes.getColorStateList(R.styleable.DiscreteSeekBar_dsb_indicatorColor), i3);
        this.f12547d = bVar;
        bVar.setCallback(this);
        this.f12547d.u(this);
        this.f12547d.t(i6);
        ViewCompat.setElevation(this, obtainStyledAttributes.getDimension(R.styleable.DiscreteSeekBar_dsb_indicatorElevation, displayMetrics.density * 8.0f));
        if (Build.VERSION.SDK_INT >= 21) {
            c.f(this, this.f12547d);
        }
        obtainStyledAttributes.recycle();
    }

    @Override // us.pinguo.widget.discreteseekbar.internal.b.b.InterfaceC0469b
    public void a() {
        if (getParent() instanceof b.InterfaceC0469b) {
            ((b.InterfaceC0469b) getParent()).a();
        }
    }

    @Override // us.pinguo.widget.discreteseekbar.internal.b.b.InterfaceC0469b
    public void b() {
        TextView textView = this.a;
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
        if (getParent() instanceof b.InterfaceC0469b) {
            ((b.InterfaceC0469b) getParent()).b();
        }
    }

    public void c() {
        this.f12547d.stop();
        if (this.f12549f) {
            TextView textView = this.a;
            textView.setVisibility(4);
            VdsAgent.onSetViewVisibility(textView, 4);
            this.f12547d.m();
            return;
        }
        TextView textView2 = this.a;
        textView2.setVisibility(4);
        VdsAgent.onSetViewVisibility(textView2, 4);
        a();
    }

    public void d() {
        if (this.f12549f) {
            this.f12547d.stop();
            this.f12547d.n();
            return;
        }
        TextView textView = this.a;
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.f12547d.draw(canvas);
        super.dispatchDraw(canvas);
    }

    public void e(String str) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        CharSequence text = this.a.getText();
        TextView textView = this.a;
        textView.setText(PGTransHeader.CONNECTOR + str);
        this.a.measure(View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, Integer.MIN_VALUE));
        int max = Math.max(this.a.getMeasuredWidth(), this.a.getMeasuredHeight());
        this.b = max;
        this.b = Math.max(max, (int) (this.f12548e * displayMetrics.density));
        removeView(this.a);
        TextView textView2 = this.a;
        int i2 = this.b;
        addView(textView2, new FrameLayout.LayoutParams(i2, i2, 51));
        if (!TextUtils.isEmpty(text)) {
            this.a.setText(text);
        } else {
            this.a.setText("");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f12547d.stop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        TextView textView = this.a;
        int i6 = this.b;
        textView.layout(paddingLeft, paddingTop, paddingLeft + i6, i6 + paddingTop);
        if (this.f12549f) {
            this.f12547d.setBounds(paddingLeft, paddingTop, width, height);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        measureChildren(i2, i3);
        int paddingLeft = this.b + getPaddingLeft() + getPaddingRight();
        int paddingTop = this.b + getPaddingTop() + getPaddingBottom();
        int i4 = this.b;
        setMeasuredDimension(paddingLeft, paddingTop + (((int) ((i4 * 1.41f) - i4)) / 2) + this.c);
    }

    public void setColors(int i2, int i3) {
        this.f12547d.s(i2, i3);
    }

    public void setValue(CharSequence charSequence) {
        this.a.setText(charSequence);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f12547d || super.verifyDrawable(drawable);
    }
}
