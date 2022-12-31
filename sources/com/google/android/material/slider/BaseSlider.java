package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R;
import com.google.android.material.internal.k;
import com.google.android.material.internal.o;
import com.google.android.material.internal.p;
import com.google.android.material.shape.h;
import com.google.android.material.shape.m;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.slider.a;
import com.google.android.material.slider.b;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends com.google.android.material.slider.a<S>, T extends com.google.android.material.slider.b<S>> extends View {
    private static final String f0 = BaseSlider.class.getSimpleName();
    static final int g0 = R.style.Widget_MaterialComponents_Slider;
    private int A;
    private float B;
    private MotionEvent C;
    private com.google.android.material.slider.c D;
    private boolean E;
    private float F;
    private float G;
    private ArrayList<Float> H;
    private int I;
    private int J;
    private float K;
    private float[] L;
    private boolean M;
    private int N;
    private boolean O;
    private boolean P;
    private boolean Q;
    @NonNull
    private ColorStateList R;
    @NonNull
    private ColorStateList S;
    @NonNull
    private ColorStateList T;
    @NonNull
    private ColorStateList U;
    @NonNull
    private ColorStateList V;
    @NonNull
    private final h W;
    @NonNull
    private final Paint a;
    @NonNull
    private final Paint b;
    @NonNull
    private final Paint c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final Paint f4533d;
    private float d0;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final Paint f4534e;
    private int e0;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final Paint f4535f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final e f4536g;

    /* renamed from: h  reason: collision with root package name */
    private final AccessibilityManager f4537h;

    /* renamed from: i  reason: collision with root package name */
    private BaseSlider<S, L, T>.d f4538i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final f f4539j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final List<com.google.android.material.i.a> f4540k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final List<L> f4541l;
    @NonNull
    private final List<T> m;
    private boolean n;
    private ValueAnimator o;
    private ValueAnimator p;
    private final int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new a();
        float a;
        float b;
        ArrayList<Float> c;

        /* renamed from: d  reason: collision with root package name */
        float f4542d;

        /* renamed from: e  reason: collision with root package name */
        boolean f4543e;

        /* loaded from: classes2.dex */
        static class a implements Parcelable.Creator<SliderState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: a */
            public SliderState createFromParcel(@NonNull Parcel parcel) {
                return new SliderState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: b */
            public SliderState[] newArray(int i2) {
                return new SliderState[i2];
            }
        }

        /* synthetic */ SliderState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeFloat(this.a);
            parcel.writeFloat(this.b);
            parcel.writeList(this.c);
            parcel.writeFloat(this.f4542d);
            parcel.writeBooleanArray(new boolean[]{this.f4543e});
        }

        SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        private SliderState(@NonNull Parcel parcel) {
            super(parcel);
            this.a = parcel.readFloat();
            this.b = parcel.readFloat();
            ArrayList<Float> arrayList = new ArrayList<>();
            this.c = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.f4542d = parcel.readFloat();
            this.f4543e = parcel.createBooleanArray()[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements f {
        final /* synthetic */ AttributeSet a;
        final /* synthetic */ int b;

        a(AttributeSet attributeSet, int i2) {
            this.a = attributeSet;
            this.b = i2;
        }

        @Override // com.google.android.material.slider.BaseSlider.f
        public com.google.android.material.i.a a() {
            TypedArray h2 = k.h(BaseSlider.this.getContext(), this.a, R.styleable.Slider, this.b, BaseSlider.g0, new int[0]);
            com.google.android.material.i.a Z = BaseSlider.Z(BaseSlider.this.getContext(), h2);
            h2.recycle();
            return Z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            for (com.google.android.material.i.a aVar : BaseSlider.this.f4540k) {
                aVar.x0(floatValue);
            }
            ViewCompat.postInvalidateOnAnimation(BaseSlider.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            for (com.google.android.material.i.a aVar : BaseSlider.this.f4540k) {
                p.e(BaseSlider.this).remove(aVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class e extends ExploreByTouchHelper {
        private final BaseSlider<?, ?, ?> a;
        Rect b;

        e(BaseSlider<?, ?, ?> baseSlider) {
            super(baseSlider);
            this.b = new Rect();
            this.a = baseSlider;
        }

        @NonNull
        private String a(int i2) {
            if (i2 == this.a.J().size() - 1) {
                return this.a.getContext().getString(R.string.material_slider_range_end);
            }
            return i2 == 0 ? this.a.getContext().getString(R.string.material_slider_range_start) : "";
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float f2, float f3) {
            for (int i2 = 0; i2 < this.a.J().size(); i2++) {
                this.a.n0(i2, this.b);
                if (this.b.contains((int) f2, (int) f3)) {
                    return i2;
                }
            }
            return -1;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> list) {
            for (int i2 = 0; i2 < this.a.J().size(); i2++) {
                list.add(Integer.valueOf(i2));
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int i2, int i3, Bundle bundle) {
            if (this.a.isEnabled()) {
                if (i3 == 4096 || i3 == 8192) {
                    float k2 = this.a.k(20);
                    if (i3 == 8192) {
                        k2 = -k2;
                    }
                    if (this.a.N()) {
                        k2 = -k2;
                    }
                    if (this.a.l0(i2, MathUtils.clamp(this.a.J().get(i2).floatValue() + k2, this.a.F(), this.a.I()))) {
                        this.a.o0();
                        this.a.postInvalidate();
                        invalidateVirtualView(i2);
                        return true;
                    }
                    return false;
                }
                if (i3 == 16908349 && bundle != null && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)) {
                    if (this.a.l0(i2, bundle.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE))) {
                        this.a.o0();
                        this.a.postInvalidate();
                        invalidateVirtualView(i2);
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int i2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
            List<Float> J = this.a.J();
            float floatValue = J.get(i2).floatValue();
            float F = this.a.F();
            float I = this.a.I();
            if (this.a.isEnabled()) {
                if (floatValue > F) {
                    accessibilityNodeInfoCompat.addAction(8192);
                }
                if (floatValue < I) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
            }
            accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, F, I, floatValue));
            accessibilityNodeInfoCompat.setClassName(SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (this.a.getContentDescription() != null) {
                sb.append(this.a.getContentDescription());
                sb.append(",");
            }
            if (J.size() > 1) {
                sb.append(a(i2));
                sb.append(this.a.y(floatValue));
            }
            accessibilityNodeInfoCompat.setContentDescription(sb.toString());
            this.a.n0(i2, this.b);
            accessibilityNodeInfoCompat.setBoundsInParent(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface f {
        com.google.android.material.i.a a();
    }

    public BaseSlider(@NonNull Context context) {
        this(context, null);
    }

    private static float B(ValueAnimator valueAnimator, float f2) {
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return f2;
        }
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        valueAnimator.cancel();
        return floatValue;
    }

    private float C(int i2, float f2) {
        float E = this.K == 0.0f ? E() : 0.0f;
        if (this.e0 == 0) {
            E = p(E);
        }
        if (N()) {
            E = -E;
        }
        int i3 = i2 + 1;
        int i4 = i2 - 1;
        return MathUtils.clamp(f2, i4 < 0 ? this.F : this.H.get(i4).floatValue() + E, i3 >= this.H.size() ? this.G : this.H.get(i3).floatValue() - E);
    }

    @ColorInt
    private int D(@NonNull ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    private float G() {
        double k0 = k0(this.d0);
        if (N()) {
            k0 = 1.0d - k0;
        }
        float f2 = this.G;
        float f3 = this.F;
        return (float) ((k0 * (f2 - f3)) + f3);
    }

    private float H() {
        float f2 = this.d0;
        if (N()) {
            f2 = 1.0f - f2;
        }
        float f3 = this.G;
        float f4 = this.F;
        return (f2 * (f3 - f4)) + f4;
    }

    private void L() {
        this.a.setStrokeWidth(this.v);
        this.b.setStrokeWidth(this.v);
        this.f4534e.setStrokeWidth(this.v / 2.0f);
        this.f4535f.setStrokeWidth(this.v / 2.0f);
    }

    private boolean M() {
        ViewParent parent = getParent();
        while (true) {
            boolean z = false;
            if (!(parent instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) ? true : true) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
            parent = parent.getParent();
        }
    }

    private void O(@NonNull Resources resources) {
        this.t = resources.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
        this.r = dimensionPixelOffset;
        this.w = dimensionPixelOffset;
        this.s = resources.getDimensionPixelSize(R.dimen.mtrl_slider_thumb_radius);
        this.x = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_top);
        this.A = resources.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
    }

    private void P() {
        if (this.K <= 0.0f) {
            return;
        }
        q0();
        int min = Math.min((int) (((this.G - this.F) / this.K) + 1.0f), (this.N / (this.v * 2)) + 1);
        float[] fArr = this.L;
        if (fArr == null || fArr.length != min * 2) {
            this.L = new float[min * 2];
        }
        float f2 = this.N / (min - 1);
        for (int i2 = 0; i2 < min * 2; i2 += 2) {
            float[] fArr2 = this.L;
            fArr2[i2] = this.w + ((i2 / 2) * f2);
            fArr2[i2 + 1] = l();
        }
    }

    private void Q(@NonNull Canvas canvas, int i2, int i3) {
        if (i0()) {
            int V = (int) (this.w + (V(this.H.get(this.J).floatValue()) * i2));
            if (Build.VERSION.SDK_INT < 28) {
                int i4 = this.z;
                canvas.clipRect(V - i4, i3 - i4, V + i4, i4 + i3, Region.Op.UNION);
            }
            canvas.drawCircle(V, i3, this.z, this.f4533d);
        }
    }

    private void R(@NonNull Canvas canvas) {
        if (!this.M || this.K <= 0.0f) {
            return;
        }
        float[] z = z();
        int b0 = b0(this.L, z[0]);
        int b02 = b0(this.L, z[1]);
        int i2 = b0 * 2;
        canvas.drawPoints(this.L, 0, i2, this.f4534e);
        int i3 = b02 * 2;
        canvas.drawPoints(this.L, i2, i3 - i2, this.f4535f);
        float[] fArr = this.L;
        canvas.drawPoints(fArr, i3, fArr.length - i3, this.f4534e);
    }

    private void S() {
        this.w = this.r + Math.max(this.y - this.s, 0);
        if (ViewCompat.isLaidOut(this)) {
            p0(getWidth());
        }
    }

    private boolean T(int i2) {
        int i3 = this.J;
        int clamp = (int) MathUtils.clamp(i3 + i2, 0L, this.H.size() - 1);
        this.J = clamp;
        if (clamp == i3) {
            return false;
        }
        if (this.I != -1) {
            this.I = clamp;
        }
        o0();
        postInvalidate();
        return true;
    }

    private boolean U(int i2) {
        if (N()) {
            i2 = i2 == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i2;
        }
        return T(i2);
    }

    private float V(float f2) {
        float f3 = this.F;
        float f4 = (f2 - f3) / (this.G - f3);
        return N() ? 1.0f - f4 : f4;
    }

    private Boolean W(int i2, @NonNull KeyEvent keyEvent) {
        if (i2 != 61) {
            if (i2 != 66) {
                if (i2 != 81) {
                    if (i2 == 69) {
                        T(-1);
                        return Boolean.TRUE;
                    } else if (i2 != 70) {
                        switch (i2) {
                            case 21:
                                U(-1);
                                return Boolean.TRUE;
                            case 22:
                                U(1);
                                return Boolean.TRUE;
                            case 23:
                                break;
                            default:
                                return null;
                        }
                    }
                }
                T(1);
                return Boolean.TRUE;
            }
            this.I = this.J;
            postInvalidate();
            return Boolean.TRUE;
        } else if (keyEvent.hasNoModifiers()) {
            return Boolean.valueOf(T(1));
        } else {
            if (keyEvent.isShiftPressed()) {
                return Boolean.valueOf(T(-1));
            }
            return Boolean.FALSE;
        }
    }

    private void X() {
        for (T t : this.m) {
            t.a(this);
        }
    }

    private void Y() {
        for (T t : this.m) {
            t.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static com.google.android.material.i.a Z(@NonNull Context context, @NonNull TypedArray typedArray) {
        return com.google.android.material.i.a.q0(context, null, 0, typedArray.getResourceId(R.styleable.Slider_labelStyle, R.style.Widget_MaterialComponents_Tooltip));
    }

    private static int b0(float[] fArr, float f2) {
        return Math.round(f2 * ((fArr.length / 2) - 1));
    }

    private void c0(Context context, AttributeSet attributeSet, int i2) {
        TypedArray h2 = k.h(context, attributeSet, R.styleable.Slider, i2, g0, new int[0]);
        this.F = h2.getFloat(R.styleable.Slider_android_valueFrom, 0.0f);
        this.G = h2.getFloat(R.styleable.Slider_android_valueTo, 1.0f);
        setValues(Float.valueOf(this.F));
        this.K = h2.getFloat(R.styleable.Slider_android_stepSize, 0.0f);
        int i3 = R.styleable.Slider_trackColor;
        boolean hasValue = h2.hasValue(i3);
        int i4 = hasValue ? i3 : R.styleable.Slider_trackColorInactive;
        if (!hasValue) {
            i3 = R.styleable.Slider_trackColorActive;
        }
        ColorStateList a2 = com.google.android.material.f.c.a(context, h2, i4);
        if (a2 == null) {
            a2 = AppCompatResources.getColorStateList(context, R.color.material_slider_inactive_track_color);
        }
        setTrackInactiveTintList(a2);
        ColorStateList a3 = com.google.android.material.f.c.a(context, h2, i3);
        if (a3 == null) {
            a3 = AppCompatResources.getColorStateList(context, R.color.material_slider_active_track_color);
        }
        setTrackActiveTintList(a3);
        this.W.W(com.google.android.material.f.c.a(context, h2, R.styleable.Slider_thumbColor));
        int i5 = R.styleable.Slider_thumbStrokeColor;
        if (h2.hasValue(i5)) {
            setThumbStrokeColor(com.google.android.material.f.c.a(context, h2, i5));
        }
        setThumbStrokeWidth(h2.getDimension(R.styleable.Slider_thumbStrokeWidth, 0.0f));
        ColorStateList a4 = com.google.android.material.f.c.a(context, h2, R.styleable.Slider_haloColor);
        if (a4 == null) {
            a4 = AppCompatResources.getColorStateList(context, R.color.material_slider_halo_color);
        }
        setHaloTintList(a4);
        this.M = h2.getBoolean(R.styleable.Slider_tickVisible, true);
        int i6 = R.styleable.Slider_tickColor;
        boolean hasValue2 = h2.hasValue(i6);
        int i7 = hasValue2 ? i6 : R.styleable.Slider_tickColorInactive;
        if (!hasValue2) {
            i6 = R.styleable.Slider_tickColorActive;
        }
        ColorStateList a5 = com.google.android.material.f.c.a(context, h2, i7);
        if (a5 == null) {
            a5 = AppCompatResources.getColorStateList(context, R.color.material_slider_inactive_tick_marks_color);
        }
        setTickInactiveTintList(a5);
        ColorStateList a6 = com.google.android.material.f.c.a(context, h2, i6);
        if (a6 == null) {
            a6 = AppCompatResources.getColorStateList(context, R.color.material_slider_active_tick_marks_color);
        }
        setTickActiveTintList(a6);
        setThumbRadius(h2.getDimensionPixelSize(R.styleable.Slider_thumbRadius, 0));
        setHaloRadius(h2.getDimensionPixelSize(R.styleable.Slider_haloRadius, 0));
        setThumbElevation(h2.getDimension(R.styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(h2.getDimensionPixelSize(R.styleable.Slider_trackHeight, 0));
        this.u = h2.getInt(R.styleable.Slider_labelBehavior, 0);
        if (!h2.getBoolean(R.styleable.Slider_android_enabled, true)) {
            setEnabled(false);
        }
        h2.recycle();
    }

    private void d0(int i2) {
        BaseSlider<S, L, T>.d dVar = this.f4538i;
        if (dVar == null) {
            this.f4538i = new d(this, null);
        } else {
            removeCallbacks(dVar);
        }
        this.f4538i.a(i2);
        postDelayed(this.f4538i, 200L);
    }

    private void g0(com.google.android.material.i.a aVar, float f2) {
        aVar.y0(y(f2));
        int V = (this.w + ((int) (V(f2) * this.N))) - (aVar.getIntrinsicWidth() / 2);
        int l2 = l() - (this.A + this.y);
        aVar.setBounds(V, l2 - aVar.getIntrinsicHeight(), aVar.getIntrinsicWidth() + V, l2);
        Rect rect = new Rect(aVar.getBounds());
        com.google.android.material.internal.c.c(p.d(this), this, rect);
        aVar.setBounds(rect);
        p.e(this).add(aVar);
    }

    private void h(com.google.android.material.i.a aVar) {
        aVar.w0(p.d(this));
    }

    private void h0(@NonNull ArrayList<Float> arrayList) {
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList);
            if (this.H.size() == arrayList.size() && this.H.equals(arrayList)) {
                return;
            }
            this.H = arrayList;
            this.Q = true;
            this.J = 0;
            o0();
            n();
            r();
            postInvalidate();
            return;
        }
        throw new IllegalArgumentException("At least one value must be set");
    }

    private Float i(int i2) {
        float k2 = this.P ? k(20) : j();
        if (i2 == 21) {
            if (!N()) {
                k2 = -k2;
            }
            return Float.valueOf(k2);
        } else if (i2 == 22) {
            if (N()) {
                k2 = -k2;
            }
            return Float.valueOf(k2);
        } else if (i2 != 69) {
            if (i2 == 70 || i2 == 81) {
                return Float.valueOf(k2);
            }
            return null;
        } else {
            return Float.valueOf(-k2);
        }
    }

    private boolean i0() {
        return this.O || Build.VERSION.SDK_INT < 21 || !(getBackground() instanceof RippleDrawable);
    }

    private float j() {
        float f2 = this.K;
        if (f2 == 0.0f) {
            return 1.0f;
        }
        return f2;
    }

    private boolean j0(float f2) {
        return l0(this.I, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float k(int i2) {
        float f2;
        float f3;
        float j2 = j();
        return (this.G - this.F) / j2 <= i2 ? j2 : Math.round(f2 / f3) * j2;
    }

    private double k0(float f2) {
        float f3 = this.K;
        if (f3 > 0.0f) {
            int i2 = (int) ((this.G - this.F) / f3);
            return Math.round(f2 * i2) / i2;
        }
        return f2;
    }

    private int l() {
        return this.x + (this.u == 1 ? this.f4540k.get(0).getIntrinsicHeight() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l0(int i2, float f2) {
        if (Math.abs(f2 - this.H.get(i2).floatValue()) < 1.0E-4d) {
            return false;
        }
        this.H.set(i2, Float.valueOf(C(i2, f2)));
        this.J = i2;
        q(i2);
        return true;
    }

    private ValueAnimator m(boolean z) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(B(z ? this.p : this.o, z ? 0.0f : 1.0f), z ? 1.0f : 0.0f);
        ofFloat.setDuration(z ? 83L : 117L);
        ofFloat.setInterpolator(z ? com.google.android.material.animation.a.f4033e : com.google.android.material.animation.a.c);
        ofFloat.addUpdateListener(new b());
        return ofFloat;
    }

    private boolean m0() {
        return j0(G());
    }

    private void n() {
        if (this.f4540k.size() > this.H.size()) {
            List<com.google.android.material.i.a> subList = this.f4540k.subList(this.H.size(), this.f4540k.size());
            for (com.google.android.material.i.a aVar : subList) {
                if (ViewCompat.isAttachedToWindow(this)) {
                    o(aVar);
                }
            }
            subList.clear();
        }
        while (this.f4540k.size() < this.H.size()) {
            com.google.android.material.i.a a2 = this.f4539j.a();
            this.f4540k.add(a2);
            if (ViewCompat.isAttachedToWindow(this)) {
                h(a2);
            }
        }
        int i2 = this.f4540k.size() == 1 ? 0 : 1;
        for (com.google.android.material.i.a aVar2 : this.f4540k) {
            aVar2.i0(i2);
        }
    }

    private void o(com.google.android.material.i.a aVar) {
        o e2 = p.e(this);
        if (e2 != null) {
            e2.remove(aVar);
            aVar.s0(p.d(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        if (i0() || getMeasuredWidth() <= 0) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof RippleDrawable) {
            int V = (int) ((V(this.H.get(this.J).floatValue()) * this.N) + this.w);
            int l2 = l();
            int i2 = this.z;
            DrawableCompat.setHotspotBounds(background, V - i2, l2 - i2, V + i2, l2 + i2);
        }
    }

    private float p(float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        float f3 = (f2 - this.w) / this.N;
        float f4 = this.F;
        return (f3 * (f4 - this.G)) + f4;
    }

    private void p0(int i2) {
        this.N = Math.max(i2 - (this.w * 2), 0);
        P();
    }

    private void q(int i2) {
        for (L l2 : this.f4541l) {
            l2.a(this, this.H.get(i2).floatValue(), true);
        }
        AccessibilityManager accessibilityManager = this.f4537h;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        d0(i2);
    }

    private void q0() {
        if (this.Q) {
            s0();
            t0();
            r0();
            u0();
            x0();
            this.Q = false;
        }
    }

    private void r() {
        for (L l2 : this.f4541l) {
            Iterator<Float> it = this.H.iterator();
            while (it.hasNext()) {
                l2.a(this, it.next().floatValue(), false);
            }
        }
    }

    private void r0() {
        if (this.K > 0.0f && !v0(this.G)) {
            throw new IllegalStateException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.toString(this.K), Float.toString(this.F), Float.toString(this.G)));
        }
    }

    private void s(@NonNull Canvas canvas, int i2, int i3) {
        float[] z = z();
        int i4 = this.w;
        float f2 = i2;
        float f3 = i3;
        canvas.drawLine(i4 + (z[0] * f2), f3, i4 + (z[1] * f2), f3, this.b);
    }

    private void s0() {
        if (this.F >= this.G) {
            throw new IllegalStateException(String.format("valueFrom(%s) must be smaller than valueTo(%s)", Float.toString(this.F), Float.toString(this.G)));
        }
    }

    private void t(@NonNull Canvas canvas, int i2, int i3) {
        int i4;
        float[] z = z();
        float f2 = i2;
        float f3 = this.w + (z[1] * f2);
        if (f3 < i4 + i2) {
            float f4 = i3;
            canvas.drawLine(f3, f4, i4 + i2, f4, this.a);
        }
        int i5 = this.w;
        float f5 = i5 + (z[0] * f2);
        if (f5 > i5) {
            float f6 = i3;
            canvas.drawLine(i5, f6, f5, f6, this.a);
        }
    }

    private void t0() {
        if (this.G <= this.F) {
            throw new IllegalStateException(String.format("valueTo(%s) must be greater than valueFrom(%s)", Float.toString(this.G), Float.toString(this.F)));
        }
    }

    private void u(@NonNull Canvas canvas, int i2, int i3) {
        if (!isEnabled()) {
            Iterator<Float> it = this.H.iterator();
            while (it.hasNext()) {
                canvas.drawCircle(this.w + (V(it.next().floatValue()) * i2), i3, this.y, this.c);
            }
        }
        Iterator<Float> it2 = this.H.iterator();
        while (it2.hasNext()) {
            canvas.save();
            int V = this.w + ((int) (V(it2.next().floatValue()) * i2));
            int i4 = this.y;
            canvas.translate(V - i4, i3 - i4);
            this.W.draw(canvas);
            canvas.restore();
        }
    }

    private void u0() {
        Iterator<Float> it = this.H.iterator();
        while (it.hasNext()) {
            Float next = it.next();
            if (next.floatValue() >= this.F && next.floatValue() <= this.G) {
                if (this.K > 0.0f && !v0(next.floatValue())) {
                    throw new IllegalStateException(String.format("Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)", Float.toString(next.floatValue()), Float.toString(this.F), Float.toString(this.K), Float.toString(this.K)));
                }
            } else {
                throw new IllegalStateException(String.format("Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)", Float.toString(next.floatValue()), Float.toString(this.F), Float.toString(this.G)));
            }
        }
    }

    private void v() {
        if (this.u == 2) {
            return;
        }
        if (!this.n) {
            this.n = true;
            ValueAnimator m = m(true);
            this.o = m;
            this.p = null;
            m.start();
        }
        Iterator<com.google.android.material.i.a> it = this.f4540k.iterator();
        for (int i2 = 0; i2 < this.H.size() && it.hasNext(); i2++) {
            if (i2 != this.J) {
                g0(it.next(), this.H.get(i2).floatValue());
            }
        }
        if (it.hasNext()) {
            g0(it.next(), this.H.get(this.J).floatValue());
            return;
        }
        throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(this.f4540k.size()), Integer.valueOf(this.H.size())));
    }

    private boolean v0(float f2) {
        double doubleValue = new BigDecimal(Float.toString(f2)).subtract(new BigDecimal(Float.toString(this.F))).divide(new BigDecimal(Float.toString(this.K)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(doubleValue)) - doubleValue) < 1.0E-4d;
    }

    private void w() {
        if (this.n) {
            this.n = false;
            ValueAnimator m = m(false);
            this.p = m;
            this.o = null;
            m.addListener(new c());
            this.p.start();
        }
    }

    private float w0(float f2) {
        return (V(f2) * this.N) + this.w;
    }

    private void x(int i2) {
        if (i2 == 1) {
            T(Integer.MAX_VALUE);
        } else if (i2 == 2) {
            T(Integer.MIN_VALUE);
        } else if (i2 == 17) {
            U(Integer.MAX_VALUE);
        } else if (i2 != 66) {
        } else {
            U(Integer.MIN_VALUE);
        }
    }

    private void x0() {
        float f2 = this.K;
        if (f2 == 0.0f) {
            return;
        }
        if (((int) f2) != f2) {
            Log.w(f0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", "stepSize", Float.valueOf(f2)));
        }
        float f3 = this.F;
        if (((int) f3) != f3) {
            Log.w(f0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", "valueFrom", Float.valueOf(f3)));
        }
        float f4 = this.G;
        if (((int) f4) != f4) {
            Log.w(f0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", "valueTo", Float.valueOf(f4)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String y(float f2) {
        if (K()) {
            return this.D.a(f2);
        }
        return String.format(((float) ((int) f2)) == f2 ? "%.0f" : "%.2f", Float.valueOf(f2));
    }

    private float[] z() {
        float floatValue = ((Float) Collections.max(J())).floatValue();
        float floatValue2 = ((Float) Collections.min(J())).floatValue();
        if (this.H.size() == 1) {
            floatValue2 = this.F;
        }
        float V = V(floatValue2);
        float V2 = V(floatValue);
        return N() ? new float[]{V2, V} : new float[]{V, V2};
    }

    public int A() {
        return this.I;
    }

    protected float E() {
        return 0.0f;
    }

    public float F() {
        return this.F;
    }

    public float I() {
        return this.G;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public List<Float> J() {
        return new ArrayList(this.H);
    }

    public boolean K() {
        return this.D != null;
    }

    final boolean N() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    protected boolean a0() {
        if (this.I != -1) {
            return true;
        }
        float H = H();
        float w0 = w0(H);
        this.I = 0;
        float abs = Math.abs(this.H.get(0).floatValue() - H);
        for (int i2 = 1; i2 < this.H.size(); i2++) {
            float abs2 = Math.abs(this.H.get(i2).floatValue() - H);
            float w02 = w0(this.H.get(i2).floatValue());
            if (Float.compare(abs2, abs) > 1) {
                break;
            }
            boolean z = !N() ? w02 - w0 >= 0.0f : w02 - w0 <= 0.0f;
            if (Float.compare(abs2, abs) < 0) {
                this.I = i2;
            } else {
                if (Float.compare(abs2, abs) != 0) {
                    continue;
                } else if (Math.abs(w02 - w0) < this.q) {
                    this.I = -1;
                    return false;
                } else if (z) {
                    this.I = i2;
                }
            }
            abs = abs2;
        }
        return this.I != -1;
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        return this.f4536g.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.a.setColor(D(this.V));
        this.b.setColor(D(this.U));
        this.f4534e.setColor(D(this.T));
        this.f4535f.setColor(D(this.S));
        for (com.google.android.material.i.a aVar : this.f4540k) {
            if (aVar.isStateful()) {
                aVar.setState(getDrawableState());
            }
        }
        if (this.W.isStateful()) {
            this.W.setState(getDrawableState());
        }
        this.f4533d.setColor(D(this.R));
        this.f4533d.setAlpha(63);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e0(int i2) {
        this.I = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f0(int i2) {
        this.e0 = i2;
    }

    @Override // android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    void n0(int i2, Rect rect) {
        int V = this.w + ((int) (V(J().get(i2).floatValue()) * this.N));
        int l2 = l();
        int i3 = this.y;
        rect.set(V - i3, l2 - i3, V + i3, l2 + i3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (com.google.android.material.i.a aVar : this.f4540k) {
            h(aVar);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        BaseSlider<S, L, T>.d dVar = this.f4538i;
        if (dVar != null) {
            removeCallbacks(dVar);
        }
        this.n = false;
        for (com.google.android.material.i.a aVar : this.f4540k) {
            o(aVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(@NonNull Canvas canvas) {
        if (this.Q) {
            q0();
            P();
        }
        super.onDraw(canvas);
        int l2 = l();
        t(canvas, this.N, l2);
        if (((Float) Collections.max(J())).floatValue() > this.F) {
            s(canvas, this.N, l2);
        }
        R(canvas);
        if ((this.E || isFocused()) && isEnabled()) {
            Q(canvas, this.N, l2);
            if (this.I != -1) {
                v();
            }
        }
        u(canvas, this.N, l2);
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i2, @Nullable Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (!z) {
            this.I = -1;
            w();
            this.f4536g.clearKeyboardFocusForVirtualView(this.J);
            return;
        }
        x(i2);
        this.f4536g.requestKeyboardFocusForVirtualView(this.J);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, @NonNull KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (this.H.size() == 1) {
            this.I = 0;
        }
        if (this.I == -1) {
            Boolean W = W(i2, keyEvent);
            return W != null ? W.booleanValue() : super.onKeyDown(i2, keyEvent);
        }
        this.P |= keyEvent.isLongPress();
        Float i3 = i(i2);
        if (i3 != null) {
            if (j0(this.H.get(this.I).floatValue() + i3.floatValue())) {
                o0();
                postInvalidate();
            }
            return true;
        }
        if (i2 != 23) {
            if (i2 == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return T(1);
                }
                if (keyEvent.isShiftPressed()) {
                    return T(-1);
                }
                return false;
            } else if (i2 != 66) {
                return super.onKeyDown(i2, keyEvent);
            }
        }
        this.I = -1;
        w();
        postInvalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, @NonNull KeyEvent keyEvent) {
        this.P = false;
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(this.t + (this.u == 1 ? this.f4540k.get(0).getIntrinsicHeight() : 0), 1073741824));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.F = sliderState.a;
        this.G = sliderState.b;
        h0(sliderState.c);
        this.K = sliderState.f4542d;
        if (sliderState.f4543e) {
            requestFocus();
        }
        r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.a = this.F;
        sliderState.b = this.G;
        sliderState.c = new ArrayList<>(this.H);
        sliderState.f4542d = this.K;
        sliderState.f4543e = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        p0(i2);
        o0();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (isEnabled()) {
            float x = motionEvent.getX();
            float f2 = (x - this.w) / this.N;
            this.d0 = f2;
            float max = Math.max(0.0f, f2);
            this.d0 = max;
            this.d0 = Math.min(1.0f, max);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.B = x;
                if (!M()) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    if (a0()) {
                        requestFocus();
                        this.E = true;
                        m0();
                        o0();
                        invalidate();
                        X();
                    }
                }
            } else if (actionMasked == 1) {
                this.E = false;
                MotionEvent motionEvent2 = this.C;
                if (motionEvent2 != null && motionEvent2.getActionMasked() == 0 && Math.abs(this.C.getX() - motionEvent.getX()) <= this.q && Math.abs(this.C.getY() - motionEvent.getY()) <= this.q && a0()) {
                    X();
                }
                if (this.I != -1) {
                    m0();
                    this.I = -1;
                    Y();
                }
                w();
                invalidate();
            } else if (actionMasked == 2) {
                if (!this.E) {
                    if (M() && Math.abs(x - this.B) < this.q) {
                        return false;
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                    X();
                }
                if (a0()) {
                    this.E = true;
                    m0();
                    o0();
                    invalidate();
                }
            }
            setPressed(this.E);
            this.C = MotionEvent.obtain(motionEvent);
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setLayerType(z ? 0 : 2, null);
    }

    public void setFocusedThumbIndex(int i2) {
        if (i2 >= 0 && i2 < this.H.size()) {
            this.J = i2;
            this.f4536g.requestKeyboardFocusForVirtualView(i2);
            postInvalidate();
            return;
        }
        throw new IllegalArgumentException("index out of range");
    }

    public void setHaloRadius(@IntRange(from = 0) @Dimension int i2) {
        if (i2 == this.z) {
            return;
        }
        this.z = i2;
        Drawable background = getBackground();
        if (!i0() && (background instanceof RippleDrawable)) {
            com.google.android.material.c.a.a((RippleDrawable) background, this.z);
        } else {
            postInvalidate();
        }
    }

    public void setHaloRadiusResource(@DimenRes int i2) {
        setHaloRadius(getResources().getDimensionPixelSize(i2));
    }

    public void setHaloTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.R)) {
            return;
        }
        this.R = colorStateList;
        Drawable background = getBackground();
        if (!i0() && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        this.f4533d.setColor(D(colorStateList));
        this.f4533d.setAlpha(63);
        invalidate();
    }

    public void setLabelBehavior(int i2) {
        if (this.u != i2) {
            this.u = i2;
            requestLayout();
        }
    }

    public void setLabelFormatter(@Nullable com.google.android.material.slider.c cVar) {
        this.D = cVar;
    }

    public void setStepSize(float f2) {
        if (f2 >= 0.0f) {
            if (this.K != f2) {
                this.K = f2;
                this.Q = true;
                postInvalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.toString(f2), Float.toString(this.F), Float.toString(this.G)));
    }

    public void setThumbElevation(float f2) {
        this.W.V(f2);
    }

    public void setThumbElevationResource(@DimenRes int i2) {
        setThumbElevation(getResources().getDimension(i2));
    }

    public void setThumbRadius(@IntRange(from = 0) @Dimension int i2) {
        if (i2 == this.y) {
            return;
        }
        this.y = i2;
        S();
        h hVar = this.W;
        m.b a2 = m.a();
        a2.q(0, this.y);
        hVar.setShapeAppearanceModel(a2.m());
        h hVar2 = this.W;
        int i3 = this.y;
        hVar2.setBounds(0, 0, i3 * 2, i3 * 2);
        postInvalidate();
    }

    public void setThumbRadiusResource(@DimenRes int i2) {
        setThumbRadius(getResources().getDimensionPixelSize(i2));
    }

    public void setThumbStrokeColor(@Nullable ColorStateList colorStateList) {
        this.W.h0(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(@ColorRes int i2) {
        if (i2 != 0) {
            setThumbStrokeColor(AppCompatResources.getColorStateList(getContext(), i2));
        }
    }

    public void setThumbStrokeWidth(float f2) {
        this.W.i0(f2);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(@DimenRes int i2) {
        if (i2 != 0) {
            setThumbStrokeWidth(getResources().getDimension(i2));
        }
    }

    public void setThumbTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.W.x())) {
            return;
        }
        this.W.W(colorStateList);
        invalidate();
    }

    public void setTickActiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.S)) {
            return;
        }
        this.S = colorStateList;
        this.f4535f.setColor(D(colorStateList));
        invalidate();
    }

    public void setTickInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.T)) {
            return;
        }
        this.T = colorStateList;
        this.f4534e.setColor(D(colorStateList));
        invalidate();
    }

    public void setTickTintList(@NonNull ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z) {
        if (this.M != z) {
            this.M = z;
            postInvalidate();
        }
    }

    public void setTrackActiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.U)) {
            return;
        }
        this.U = colorStateList;
        this.b.setColor(D(colorStateList));
        invalidate();
    }

    public void setTrackHeight(@IntRange(from = 0) @Dimension int i2) {
        if (this.v != i2) {
            this.v = i2;
            L();
            postInvalidate();
        }
    }

    public void setTrackInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.V)) {
            return;
        }
        this.V = colorStateList;
        this.a.setColor(D(colorStateList));
        invalidate();
    }

    public void setTrackTintList(@NonNull ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f2) {
        this.F = f2;
        this.Q = true;
        postInvalidate();
    }

    public void setValueTo(float f2) {
        this.G = f2;
        this.Q = true;
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setValues(@NonNull Float... fArr) {
        ArrayList<Float> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, fArr);
        h0(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d implements Runnable {
        int a;

        private d() {
            this.a = -1;
        }

        void a(int i2) {
            this.a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.this.f4536g.sendEventForVirtualView(this.a, 4);
        }

        /* synthetic */ d(BaseSlider baseSlider, a aVar) {
            this();
        }
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sliderStyle);
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.c(context, attributeSet, i2, g0), attributeSet, i2);
        this.f4540k = new ArrayList();
        this.f4541l = new ArrayList();
        this.m = new ArrayList();
        this.n = false;
        this.E = false;
        this.H = new ArrayList<>();
        this.I = -1;
        this.J = -1;
        this.K = 0.0f;
        this.M = true;
        this.P = false;
        h hVar = new h();
        this.W = hVar;
        this.e0 = 0;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.a = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        Paint paint3 = new Paint(1);
        this.c = paint3;
        paint3.setStyle(Paint.Style.FILL);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint4 = new Paint(1);
        this.f4533d = paint4;
        paint4.setStyle(Paint.Style.FILL);
        Paint paint5 = new Paint();
        this.f4534e = paint5;
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setStrokeCap(Paint.Cap.ROUND);
        Paint paint6 = new Paint();
        this.f4535f = paint6;
        paint6.setStyle(Paint.Style.STROKE);
        paint6.setStrokeCap(Paint.Cap.ROUND);
        O(context2.getResources());
        this.f4539j = new a(attributeSet, i2);
        c0(context2, attributeSet, i2);
        setFocusable(true);
        setClickable(true);
        hVar.e0(2);
        this.q = ViewConfiguration.get(context2).getScaledTouchSlop();
        e eVar = new e(this);
        this.f4536g = eVar;
        ViewCompat.setAccessibilityDelegate(this, eVar);
        this.f4537h = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setValues(@NonNull List<Float> list) {
        h0(new ArrayList<>(list));
    }
}
