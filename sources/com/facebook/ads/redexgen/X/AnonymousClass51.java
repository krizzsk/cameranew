package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.51  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class AnonymousClass51 implements View.OnLongClickListener {
    public final /* synthetic */ AnonymousClass52 A00;

    public AnonymousClass51(AnonymousClass52 anonymousClass52) {
        this.A00 = anonymousClass52;
    }

    public /* synthetic */ AnonymousClass51(AnonymousClass52 anonymousClass52, C05984y c05984y) {
        this(anonymousClass52);
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (AnonymousClass52.A02(this.A00) != null && AnonymousClass52.A00(this.A00) != null) {
            AnonymousClass52.A02(this.A00).setBounds(0, 0, AnonymousClass52.A00(this.A00).getWidth(), AnonymousClass52.A00(this.A00).getHeight());
            AnonymousClass52.A02(this.A00).A0D(!AnonymousClass52.A02(this.A00).A0E());
        }
        return true;
    }
}
