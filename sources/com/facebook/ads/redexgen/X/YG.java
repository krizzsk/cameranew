package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class YG extends C06266b {
    public final Context A00;

    public YG(Context context, AnonymousClass61 anonymousClass61) {
        super(context, anonymousClass61);
        this.A00 = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Nullable Dereference"})
    public AbstractC06506z A03(HashMap<String, YH> hashMap) {
        return new C1292Xc(SystemClock.elapsedRealtime(), A02(), hashMap, EnumC06496y.A0C);
    }

    public final InterfaceC06356k A0G(List<C06346j> list, EnumC06316g enumC06316g) {
        return new YI(this, list, enumC06316g);
    }
}
