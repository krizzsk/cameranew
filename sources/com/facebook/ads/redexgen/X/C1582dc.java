package com.facebook.ads.redexgen.X;

import android.view.View;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.infer.annotation.Nullsafe$Mode;
import java.util.Collection;
import java.util.Map;
import java.util.WeakHashMap;
@Nullsafe(Nullsafe$Mode.LOCAL)
/* renamed from: com.facebook.ads.redexgen.X.dc  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1582dc {
    public final Map<View, C1589dj> A00 = new WeakHashMap();

    public final C1589dj A00(View view) {
        C1589dj c1589dj = this.A00.get(view);
        if (c1589dj == null) {
            return C1589dj.A06;
        }
        return c1589dj;
    }

    public final void A01(View view) {
        this.A00.remove(view);
    }

    public final void A02(View view, C1589dj c1589dj) {
        this.A00.put(view, c1589dj);
    }

    public final void A03(Collection<View> collection) {
        for (View view : this.A00.keySet()) {
            collection.add(view);
        }
    }
}
