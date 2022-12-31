package com.facebook.ads.redexgen.X;

import android.app.KeyguardManager;
import android.os.Build;
/* renamed from: com.facebook.ads.redexgen.X.Yw  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1338Yw implements InterfaceC06356k {
    public final /* synthetic */ C1334Ys A00;

    public C1338Yw(C1334Ys c1334Ys) {
        this.A00 = c1334Ys;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        KeyguardManager keyguardManager;
        KeyguardManager keyguardManager2;
        if (Build.VERSION.SDK_INT >= 22) {
            keyguardManager = this.A00.A00;
            if (keyguardManager == null) {
                return this.A00.A07(EnumC06466v.A07);
            }
            C1334Ys c1334Ys = this.A00;
            keyguardManager2 = c1334Ys.A00;
            return c1334Ys.A0F(keyguardManager2.isDeviceLocked());
        }
        return this.A00.A07(EnumC06466v.A05);
    }
}
