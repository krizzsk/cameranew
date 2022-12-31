package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.infer.annotation.Nullsafe$Mode;
@Nullsafe(Nullsafe$Mode.LOCAL)
/* renamed from: com.facebook.ads.redexgen.X.dh  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC1587dh {
    @Nullable
    public InterfaceC1588di A00;

    public final void A00() {
        InterfaceC1588di interfaceC1588di = this.A00;
        if (interfaceC1588di != null) {
            interfaceC1588di.onStart();
        }
    }

    public final void A01() {
        InterfaceC1588di interfaceC1588di = this.A00;
        if (interfaceC1588di != null) {
            interfaceC1588di.onStop();
        }
    }

    public final void A02(InterfaceC1588di interfaceC1588di) {
        this.A00 = interfaceC1588di;
    }
}
