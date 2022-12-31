package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.timepicker.ClockHandView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.Locale;
/* loaded from: classes2.dex */
class TimePickerView extends ConstraintLayout {
    private final Chip a;
    private final Chip b;
    private final ClockHandView c;

    /* renamed from: d  reason: collision with root package name */
    private final ClockFaceView f4667d;

    /* renamed from: e  reason: collision with root package name */
    private final MaterialButtonToggleGroup f4668e;

    /* renamed from: f  reason: collision with root package name */
    private final View.OnClickListener f4669f;

    /* renamed from: g  reason: collision with root package name */
    private f f4670g;

    /* renamed from: h  reason: collision with root package name */
    private g f4671h;

    /* renamed from: i  reason: collision with root package name */
    private e f4672i;

    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            if (TimePickerView.this.f4671h != null) {
                TimePickerView.this.f4671h.e(((Integer) view.getTag(R.id.selection_type)).intValue());
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements MaterialButtonToggleGroup.e {
        b() {
        }

        @Override // com.google.android.material.button.MaterialButtonToggleGroup.e
        public void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i2, boolean z) {
            int i3 = i2 == R.id.material_clock_period_pm_button ? 1 : 0;
            if (TimePickerView.this.f4670g == null || !z) {
                return;
            }
            TimePickerView.this.f4670g.d(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            boolean onDoubleTap = super.onDoubleTap(motionEvent);
            if (TimePickerView.this.f4672i != null) {
                TimePickerView.this.f4672i.a();
            }
            return onDoubleTap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements View.OnTouchListener {
        final /* synthetic */ GestureDetector a;

        d(TimePickerView timePickerView, GestureDetector gestureDetector) {
            this.a = gestureDetector;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.a.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    interface e {
        void a();
    }

    /* loaded from: classes2.dex */
    interface f {
        void d(int i2);
    }

    /* loaded from: classes2.dex */
    interface g {
        void e(int i2);
    }

    public TimePickerView(Context context) {
        this(context, null);
    }

    private void t() {
        Chip chip = this.a;
        int i2 = R.id.selection_type;
        chip.setTag(i2, 12);
        this.b.setTag(i2, 10);
        this.a.setOnClickListener(this.f4669f);
        this.b.setOnClickListener(this.f4669f);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void v() {
        d dVar = new d(this, new GestureDetector(getContext(), new c()));
        this.a.setOnTouchListener(dVar);
        this.b.setOnTouchListener(dVar);
    }

    private void y() {
        if (this.f4668e.getVisibility() == 0) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this);
            constraintSet.clear(R.id.material_clock_display, ViewCompat.getLayoutDirection(this) == 0 ? 2 : 1);
            constraintSet.applyTo(this);
        }
    }

    public void j(ClockHandView.d dVar) {
        this.c.b(dVar);
    }

    public void k(int i2) {
        this.a.setChecked(i2 == 12);
        this.b.setChecked(i2 == 10);
    }

    public void l(boolean z) {
        this.c.j(z);
    }

    public void m(float f2, boolean z) {
        this.c.m(f2, z);
    }

    public void n(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.setAccessibilityDelegate(this.a, accessibilityDelegateCompat);
    }

    public void o(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.setAccessibilityDelegate(this.b, accessibilityDelegateCompat);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        y();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (view == this && i2 == 0) {
            y();
        }
    }

    public void p(ClockHandView.c cVar) {
        this.c.o(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(@Nullable e eVar) {
        this.f4672i = eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(f fVar) {
        this.f4670g = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(g gVar) {
        this.f4671h = gVar;
    }

    public void u(String[] strArr, @StringRes int i2) {
        this.f4667d.s(strArr, i2);
    }

    public void w() {
        MaterialButtonToggleGroup materialButtonToggleGroup = this.f4668e;
        materialButtonToggleGroup.setVisibility(0);
        VdsAgent.onSetViewVisibility(materialButtonToggleGroup, 0);
    }

    @SuppressLint({"DefaultLocale"})
    public void x(int i2, int i3, int i4) {
        this.f4668e.j(i2 == 1 ? R.id.material_clock_period_pm_button : R.id.material_clock_period_am_button);
        Locale locale = getResources().getConfiguration().locale;
        String format = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i4));
        String format2 = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
        this.a.setText(format);
        this.b.setText(format2);
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4669f = new a();
        LayoutInflater.from(context).inflate(R.layout.material_timepicker, this);
        this.f4667d = (ClockFaceView) findViewById(R.id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        this.f4668e = materialButtonToggleGroup;
        materialButtonToggleGroup.g(new b());
        this.a = (Chip) findViewById(R.id.material_minute_tv);
        this.b = (Chip) findViewById(R.id.material_hour_tv);
        this.c = (ClockHandView) findViewById(R.id.material_clock_hand);
        v();
        t();
    }
}
