package com.facebook.ads.redexgen.X;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.Nullable;
/* renamed from: com.facebook.ads.redexgen.X.b0  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1430b0 implements C5L {
    public final /* synthetic */ ImageView A00;
    public final /* synthetic */ C5N A01;
    public final /* synthetic */ C1198Tj A02;

    public C1430b0(C5N c5n, ImageView imageView, C1198Tj c1198Tj) {
        this.A01 = c5n;
        this.A00 = imageView;
        this.A02 = c1198Tj;
    }

    @Override // com.facebook.ads.redexgen.X.C5L
    public final void AAj(@Nullable Drawable drawable) {
        C1198Tj.A0b(drawable, this.A00);
        this.A02.A1I(drawable);
    }
}
