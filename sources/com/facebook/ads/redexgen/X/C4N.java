package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;
/* renamed from: com.facebook.ads.redexgen.X.4N  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C4N extends ViewGroup.MarginLayoutParams {
    public AbstractC05784e A00;
    public boolean A01;
    public boolean A02;
    public final Rect A03;

    public C4N(int i2, int i3) {
        super(i2, i3);
        this.A03 = new Rect();
        this.A01 = true;
        this.A02 = false;
    }

    public C4N(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.A03 = new Rect();
        this.A01 = true;
        this.A02 = false;
    }

    public C4N(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.A03 = new Rect();
        this.A01 = true;
        this.A02 = false;
    }

    public C4N(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.A03 = new Rect();
        this.A01 = true;
        this.A02 = false;
    }

    public C4N(C4N c4n) {
        super((ViewGroup.LayoutParams) c4n);
        this.A03 = new Rect();
        this.A01 = true;
        this.A02 = false;
    }

    public final int A00() {
        return this.A00.A0I();
    }

    public final boolean A01() {
        return this.A00.A0f();
    }

    public final boolean A02() {
        return this.A00.A0c();
    }

    public final boolean A03() {
        return this.A00.A0b();
    }
}
