package com.google.android.material.switchmaterial;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.R;
import com.google.android.material.b.a;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.p;
/* loaded from: classes2.dex */
public class SwitchMaterial extends SwitchCompat {

    /* renamed from: e  reason: collision with root package name */
    private static final int f4562e = R.style.Widget_MaterialComponents_CompoundButton_Switch;

    /* renamed from: f  reason: collision with root package name */
    private static final int[][] f4563f = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    @NonNull
    private final ElevationOverlayProvider a;
    @Nullable
    private ColorStateList b;
    @Nullable
    private ColorStateList c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4564d;

    public SwitchMaterial(@NonNull Context context) {
        this(context, null);
    }

    private ColorStateList a() {
        if (this.b == null) {
            int d2 = a.d(this, R.attr.colorSurface);
            int d3 = a.d(this, R.attr.colorControlActivated);
            float dimension = getResources().getDimension(R.dimen.mtrl_switch_thumb_elevation);
            if (this.a.e()) {
                dimension += p.g(this);
            }
            int c = this.a.c(d2, dimension);
            int[][] iArr = f4563f;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = a.h(d2, d3, 1.0f);
            iArr2[1] = c;
            iArr2[2] = a.h(d2, d3, 0.38f);
            iArr2[3] = c;
            this.b = new ColorStateList(iArr, iArr2);
        }
        return this.b;
    }

    private ColorStateList b() {
        if (this.c == null) {
            int[][] iArr = f4563f;
            int[] iArr2 = new int[iArr.length];
            int d2 = a.d(this, R.attr.colorSurface);
            int d3 = a.d(this, R.attr.colorControlActivated);
            int d4 = a.d(this, R.attr.colorOnSurface);
            iArr2[0] = a.h(d2, d3, 0.54f);
            iArr2[1] = a.h(d2, d4, 0.32f);
            iArr2[2] = a.h(d2, d3, 0.12f);
            iArr2[3] = a.h(d2, d4, 0.12f);
            this.c = new ColorStateList(iArr, iArr2);
        }
        return this.c;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f4564d && getThumbTintList() == null) {
            setThumbTintList(a());
        }
        if (this.f4564d && getTrackTintList() == null) {
            setTrackTintList(b());
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f4564d = z;
        if (z) {
            setThumbTintList(a());
            setTrackTintList(b());
            return;
        }
        setThumbTintList(null);
        setTrackTintList(null);
    }

    public SwitchMaterial(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SwitchMaterial(@androidx.annotation.NonNull android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.switchmaterial.SwitchMaterial.f4562e
            android.content.Context r7 = com.google.android.material.theme.a.a.c(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            android.content.Context r0 = r6.getContext()
            com.google.android.material.elevation.ElevationOverlayProvider r7 = new com.google.android.material.elevation.ElevationOverlayProvider
            r7.<init>(r0)
            r6.a = r7
            int[] r2 = com.google.android.material.R.styleable.SwitchMaterial
            r7 = 0
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.k.h(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R.styleable.SwitchMaterial_useMaterialThemeColors
            boolean r7 = r8.getBoolean(r9, r7)
            r6.f4564d = r7
            r8.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.switchmaterial.SwitchMaterial.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
