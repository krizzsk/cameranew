package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.Oo  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1073Oo {
    public static final Map<String, WeakReference<C1072On>> A00 = new HashMap();

    public static int A00() {
        return A00.size();
    }

    public static C1072On A01(XT xt, AnonymousClass16 anonymousClass16, int i2, InterfaceC1070Ol interfaceC1070Ol) {
        C1072On c1072On = new C1072On(xt, anonymousClass16, xt.A00().A08(), i2);
        c1072On.A0W(interfaceC1070Ol);
        c1072On.A0e(true);
        A00.put(anonymousClass16.A0V(), new WeakReference<>(c1072On));
        return c1072On;
    }

    @Nullable
    public static C1072On A02(String str) {
        WeakReference<C1072On> weakReference = A00.get(str);
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static void A03(String str) {
        A00.remove(str);
    }
}
