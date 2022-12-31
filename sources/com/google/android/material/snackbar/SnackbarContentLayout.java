package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class SnackbarContentLayout extends LinearLayout implements a {
    private TextView a;
    private Button b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f4559d;

    public SnackbarContentLayout(@NonNull Context context) {
        this(context, null);
    }

    private static void e(@NonNull View view, int i2, int i3) {
        if (ViewCompat.isPaddingRelative(view)) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), i2, ViewCompat.getPaddingEnd(view), i3);
        } else {
            view.setPadding(view.getPaddingLeft(), i2, view.getPaddingRight(), i3);
        }
    }

    private boolean f(int i2, int i3, int i4) {
        boolean z;
        if (i2 != getOrientation()) {
            setOrientation(i2);
            z = true;
        } else {
            z = false;
        }
        if (this.a.getPaddingTop() == i3 && this.a.getPaddingBottom() == i4) {
            return z;
        }
        e(this.a, i3, i4);
        return true;
    }

    @Override // com.google.android.material.snackbar.a
    public void a(int i2, int i3) {
        this.a.setAlpha(0.0f);
        long j2 = i3;
        long j3 = i2;
        this.a.animate().alpha(1.0f).setDuration(j2).setStartDelay(j3).start();
        if (this.b.getVisibility() == 0) {
            this.b.setAlpha(0.0f);
            this.b.animate().alpha(1.0f).setDuration(j2).setStartDelay(j3).start();
        }
    }

    @Override // com.google.android.material.snackbar.a
    public void b(int i2, int i3) {
        this.a.setAlpha(1.0f);
        long j2 = i3;
        long j3 = i2;
        this.a.animate().alpha(0.0f).setDuration(j2).setStartDelay(j3).start();
        if (this.b.getVisibility() == 0) {
            this.b.setAlpha(1.0f);
            this.b.animate().alpha(0.0f).setDuration(j2).setStartDelay(j3).start();
        }
    }

    public TextView c() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(float f2) {
        if (f2 != 1.0f) {
            this.b.setTextColor(com.google.android.material.b.a.h(com.google.android.material.b.a.d(this, R.attr.colorSurface), this.b.getCurrentTextColor(), f2));
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (TextView) findViewById(R.id.snackbar_text);
        this.b = (Button) findViewById(R.id.snackbar_action);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0053, code lost:
        if (f(1, r0, r0 - r1) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005e, code lost:
        if (f(0, r0, r0) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
        r3 = true;
     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = r7.c
            if (r0 <= 0) goto L18
            int r0 = r7.getMeasuredWidth()
            int r1 = r7.c
            if (r0 <= r1) goto L18
            r8 = 1073741824(0x40000000, float:2.0)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            super.onMeasure(r8, r9)
        L18:
            android.content.res.Resources r0 = r7.getResources()
            int r1 = com.google.android.material.R.dimen.design_snackbar_padding_vertical_2lines
            int r0 = r0.getDimensionPixelSize(r1)
            android.content.res.Resources r1 = r7.getResources()
            int r2 = com.google.android.material.R.dimen.design_snackbar_padding_vertical
            int r1 = r1.getDimensionPixelSize(r2)
            android.widget.TextView r2 = r7.a
            android.text.Layout r2 = r2.getLayout()
            int r2 = r2.getLineCount()
            r3 = 0
            r4 = 1
            if (r2 <= r4) goto L3c
            r2 = 1
            goto L3d
        L3c:
            r2 = 0
        L3d:
            if (r2 == 0) goto L56
            int r5 = r7.f4559d
            if (r5 <= 0) goto L56
            android.widget.Button r5 = r7.b
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.f4559d
            if (r5 <= r6) goto L56
            int r1 = r0 - r1
            boolean r0 = r7.f(r4, r0, r1)
            if (r0 == 0) goto L61
            goto L60
        L56:
            if (r2 == 0) goto L59
            goto L5a
        L59:
            r0 = r1
        L5a:
            boolean r0 = r7.f(r3, r0, r0)
            if (r0 == 0) goto L61
        L60:
            r3 = 1
        L61:
            if (r3 == 0) goto L66
            super.onMeasure(r8, r9)
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.SnackbarContentLayout.onMeasure(int, int):void");
    }

    public void setMaxInlineActionWidth(int i2) {
        this.f4559d = i2;
    }

    public SnackbarContentLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
        this.c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
        this.f4559d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
        obtainStyledAttributes.recycle();
    }
}
