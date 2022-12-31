package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPrivacyPolicy;
/* loaded from: classes3.dex */
final class gd extends gc {
    @Override // com.tapjoy.internal.gc
    public final Object a(Context context, String str, TJPlacementListener tJPlacementListener) {
        return new TJPlacement(context, str, tJPlacementListener);
    }

    @Override // com.tapjoy.internal.gc
    public final Object b() {
        return TJPrivacyPolicy.getInstance();
    }
}
