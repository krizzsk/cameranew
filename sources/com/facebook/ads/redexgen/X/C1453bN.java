package com.facebook.ads.redexgen.X;

import android.graphics.drawable.ColorDrawable;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.api.AdCompanionView;
import com.facebook.ads.internal.api.AdCompanionViewApi;
import com.facebook.ads.internal.api.AdComponentViewApi;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.bN  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1453bN extends AnonymousClass57 implements AdCompanionViewApi {
    public static byte[] A05;
    @Nullable
    public AnonymousClass16 A00;
    @Nullable
    public AdCompanionView A01;
    @Nullable
    public XT A02;
    @Nullable
    public JT A03;
    @Nullable
    public C06949a A04;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 21);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{-120, -108, -110, 83, -117, -122, -120, -118, -121, -108, -108, -112, 83, -122, -119, -104, 83, -114, -109, -103, -118, -105, -104, -103, -114, -103, -114, -122, -111, 83, -120, -111, -114, -120, -112, -118, -119};
    }

    public final void A02() {
        this.A04 = null;
    }

    public final void A03(XT xt, AnonymousClass16 anonymousClass16) {
        AdCompanionView adCompanionView = this.A01;
        if (adCompanionView == null) {
            return;
        }
        this.A02 = xt;
        this.A00 = anonymousClass16;
        AnonymousClass31.A0A(adCompanionView, new ColorDrawable(0));
        this.A03 = this.A02.A08();
        this.A04 = new C06949a(this.A02, this.A03, this.A00, A00(0, 37, 16), 1);
        this.A01.addView(this.A04);
    }

    @Override // com.facebook.ads.internal.api.AdComponentViewApiProvider
    public final AdComponentViewApi getAdComponentViewApi() {
        return this;
    }

    @Override // com.facebook.ads.internal.api.AdCompanionViewApi
    public final void initialize(AdCompanionView adCompanionView) {
        this.A01 = adCompanionView;
    }
}
