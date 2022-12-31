package com.facebook.ads.redexgen.X;

import android.os.Build;
import androidx.annotation.Nullable;
/* renamed from: com.facebook.ads.redexgen.X.2F  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C2F extends C0828Eq {
    public C2F(XT xt) {
        super(xt);
        setCarouselLayoutManager(xt);
    }

    @Nullable
    public C1143Rg getFullscreenCarouselRecyclerViewAdapter() {
        if (getAdapter() instanceof C1143Rg) {
            return (C1143Rg) getAdapter();
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.C0828Eq
    public C1469be getLayoutManager() {
        return (C1469be) super.getLayoutManager();
    }

    private void setCarouselLayoutManager(XT xt) {
        C1469be c1469be = new C1469be(xt, 0, false);
        if (Build.VERSION.SDK_INT >= 24) {
            c1469be.A1V(true);
        }
        super.setLayoutManager(c1469be);
    }

    @Override // com.facebook.ads.redexgen.X.C0828Eq
    public void setLayoutManager(C4M c4m) {
    }
}
