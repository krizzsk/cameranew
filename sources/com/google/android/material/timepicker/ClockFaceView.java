package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.timepicker.ClockHandView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Arrays;
/* loaded from: classes2.dex */
class ClockFaceView extends RadialViewGroup implements ClockHandView.d {

    /* renamed from: d  reason: collision with root package name */
    private final ClockHandView f4638d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f4639e;

    /* renamed from: f  reason: collision with root package name */
    private final RectF f4640f;

    /* renamed from: g  reason: collision with root package name */
    private final SparseArray<TextView> f4641g;

    /* renamed from: h  reason: collision with root package name */
    private final AccessibilityDelegateCompat f4642h;

    /* renamed from: i  reason: collision with root package name */
    private final int[] f4643i;

    /* renamed from: j  reason: collision with root package name */
    private final float[] f4644j;

    /* renamed from: k  reason: collision with root package name */
    private final int f4645k;

    /* renamed from: l  reason: collision with root package name */
    private final int f4646l;
    private final int m;
    private final int n;
    private String[] o;
    private float p;
    private final ColorStateList q;

    /* loaded from: classes2.dex */
    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (ClockFaceView.this.isShown()) {
                ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                ClockFaceView.this.i(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.f4638d.g()) - ClockFaceView.this.f4645k);
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes2.dex */
    class b extends AccessibilityDelegateCompat {
        b() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            int intValue = ((Integer) view.getTag(R.id.material_value_index)).intValue();
            if (intValue > 0) {
                accessibilityNodeInfoCompat.setTraversalAfter((View) ClockFaceView.this.f4641g.get(intValue - 1));
            }
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, intValue, 1, false, view.isSelected()));
        }
    }

    public ClockFaceView(@NonNull Context context) {
        this(context, null);
    }

    private void p() {
        RectF d2 = this.f4638d.d();
        for (int i2 = 0; i2 < this.f4641g.size(); i2++) {
            TextView textView = this.f4641g.get(i2);
            if (textView != null) {
                textView.getDrawingRect(this.f4639e);
                this.f4639e.offset(textView.getPaddingLeft(), textView.getPaddingTop());
                offsetDescendantRectToMyCoords(textView, this.f4639e);
                this.f4640f.set(this.f4639e);
                textView.getPaint().setShader(q(d2, this.f4640f));
                textView.invalidate();
            }
        }
    }

    private RadialGradient q(RectF rectF, RectF rectF2) {
        if (RectF.intersects(rectF, rectF2)) {
            return new RadialGradient(rectF.centerX() - this.f4640f.left, rectF.centerY() - this.f4640f.top, rectF.width() * 0.5f, this.f4643i, this.f4644j, Shader.TileMode.CLAMP);
        }
        return null;
    }

    private static float r(float f2, float f3, float f4) {
        return Math.max(Math.max(f2, f3), f4);
    }

    private void t(@StringRes int i2) {
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = this.f4641g.size();
        for (int i3 = 0; i3 < Math.max(this.o.length, size); i3++) {
            TextView textView = this.f4641g.get(i3);
            if (i3 >= this.o.length) {
                removeView(textView);
                this.f4641g.remove(i3);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(R.layout.material_clockface_textview, (ViewGroup) this, false);
                    this.f4641g.put(i3, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                VdsAgent.onSetViewVisibility(textView, 0);
                textView.setText(this.o[i3]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(i3));
                ViewCompat.setAccessibilityDelegate(textView, this.f4642h);
                textView.setTextColor(this.q);
                if (i2 != 0) {
                    textView.setContentDescription(getResources().getString(i2, this.o[i3]));
                }
            }
        }
    }

    @Override // com.google.android.material.timepicker.ClockHandView.d
    public void f(float f2, boolean z) {
        if (Math.abs(this.p - f2) > 0.001f) {
            this.p = f2;
            p();
        }
    }

    @Override // com.google.android.material.timepicker.RadialViewGroup
    public void i(int i2) {
        if (i2 != h()) {
            super.i(i2);
            this.f4638d.k(h());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.o.length, false, 1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int r = (int) (this.n / r(this.f4646l / displayMetrics.heightPixels, this.m / displayMetrics.widthPixels, 1.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(r, 1073741824);
        setMeasuredDimension(r, r);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    public void s(String[] strArr, @StringRes int i2) {
        this.o = strArr;
        t(i2);
    }

    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialClockStyle);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4639e = new Rect();
        this.f4640f = new RectF();
        this.f4641g = new SparseArray<>();
        this.f4644j = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClockFaceView, i2, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList a2 = com.google.android.material.f.c.a(context, obtainStyledAttributes, R.styleable.ClockFaceView_clockNumberTextColor);
        this.q = a2;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.f4638d = clockHandView;
        this.f4645k = resources.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int colorForState = a2.getColorForState(new int[]{16842913}, a2.getDefaultColor());
        this.f4643i = new int[]{colorForState, colorForState, a2.getDefaultColor()};
        clockHandView.b(this);
        int defaultColor = AppCompatResources.getColorStateList(context, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList a3 = com.google.android.material.f.c.a(context, obtainStyledAttributes, R.styleable.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(a3 != null ? a3.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new a());
        setFocusable(true);
        obtainStyledAttributes.recycle();
        this.f4642h = new b();
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        s(strArr, 0);
        this.f4646l = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.m = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.n = resources.getDimensionPixelSize(R.dimen.material_clock_size);
    }
}
