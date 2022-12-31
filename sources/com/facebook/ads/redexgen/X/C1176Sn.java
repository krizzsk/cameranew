package com.facebook.ads.redexgen.X;

import android.widget.ImageView;
/* renamed from: com.facebook.ads.redexgen.X.Sn  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1176Sn implements InterfaceC1040Nf {
    public final /* synthetic */ NW A00;

    public C1176Sn(NW nw) {
        this.A00 = nw;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1040Nf
    public final void A9y(boolean z) {
        boolean z2;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        z2 = this.A00.A07;
        if (z2) {
            imageView = this.A00.A00;
            if (imageView != null) {
                imageView2 = this.A00.A00;
                imageView2.setEnabled(z);
                imageView3 = this.A00.A00;
                imageView3.setAlpha(z ? 1.0f : 0.3f);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1040Nf
    public final void AAc(boolean z) {
        boolean z2;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        z2 = this.A00.A07;
        if (z2) {
            imageView = this.A00.A02;
            if (imageView != null) {
                imageView2 = this.A00.A02;
                imageView2.setEnabled(z);
                imageView3 = this.A00.A02;
                imageView3.setAlpha(z ? 1.0f : 0.3f);
            }
        }
    }
}
