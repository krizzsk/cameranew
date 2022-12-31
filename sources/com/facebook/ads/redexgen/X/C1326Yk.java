package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import java.util.HashMap;
/* renamed from: com.facebook.ads.redexgen.X.Yk  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1326Yk extends C06266b {
    public C1326Yk(Context context, AnonymousClass61 anonymousClass61) {
        super(context, anonymousClass61);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Nullable Dereference"})
    public AbstractC06506z A02(HashMap<String, C1327Yl> hashMap) {
        return new C1292Xc(SystemClock.elapsedRealtime(), A02(), hashMap, EnumC06496y.A0C);
    }

    public final InterfaceC06356k A0G() {
        return new C1328Ym(this);
    }
}
