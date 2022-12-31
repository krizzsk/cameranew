package com.facebook.ads.redexgen.X;

import android.telephony.TelephonyManager;
/* loaded from: assets/audience_network.dex */
public class Y9 implements InterfaceC06356k {
    public static String[] A01 = {"1jYE18OinQfv5WLTq2cVBe585KmN", "X325BmovX2W2cAXv5JjOdne9uqamI6Ku", "itArcmOQ038W2qOxTmWDysJ", "YLO301mgb0CV", "8Iuh4U1kakUbsQ2Nn", "O3ZH7jI89PddtJoXg7iV4O6wtsqjtnrU", "1x9H6MAyleaM4oP8QSazbLvKby53Pv0n", "YmZygv2VfDGVkOFuuIE9CAITaRVNY9b1"};
    public final /* synthetic */ C1312Xw A00;

    public Y9(C1312Xw c1312Xw) {
        this.A00 = c1312Xw;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        TelephonyManager telephonyManager;
        TelephonyManager telephonyManager2;
        telephonyManager = this.A00.A00;
        if (telephonyManager != null) {
            C1312Xw c1312Xw = this.A00;
            telephonyManager2 = c1312Xw.A00;
            String simCountryIso = telephonyManager2.getSimCountryIso();
            String[] strArr = A01;
            if (strArr[6].charAt(3) != strArr[5].charAt(3)) {
                throw new RuntimeException();
            }
            A01[2] = "tduom2IhCerqtA7iCB";
            return c1312Xw.A08(simCountryIso);
        }
        return this.A00.A07(EnumC06466v.A07);
    }
}
