package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
/* renamed from: com.facebook.ads.redexgen.X.38  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class AnonymousClass38 extends ViewGroup.LayoutParams {
    public float A00;
    public int A01;
    public int A02;
    public boolean A03;
    public int A04;
    public boolean A05;

    public AnonymousClass38() {
        super(-1, -1);
        this.A00 = 0.0f;
    }

    public AnonymousClass38(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.A00 = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3F.A0w);
        this.A04 = obtainStyledAttributes.getInteger(0, 48);
        obtainStyledAttributes.recycle();
    }
}
