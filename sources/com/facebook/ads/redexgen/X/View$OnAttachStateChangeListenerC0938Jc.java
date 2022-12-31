package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Jc  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class View$OnAttachStateChangeListenerC0938Jc implements View.OnAttachStateChangeListener {
    public final /* synthetic */ EnumC0936Ja A00;
    public final /* synthetic */ C0937Jb A01;

    public View$OnAttachStateChangeListenerC0938Jc(C0937Jb c0937Jb, EnumC0936Ja enumC0936Ja) {
        this.A01 = c0937Jb;
        this.A00 = enumC0936Ja;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.A01.A02(this.A00, null);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
