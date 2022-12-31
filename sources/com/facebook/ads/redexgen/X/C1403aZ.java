package com.facebook.ads.redexgen.X;

import android.app.ActivityManager;
/* renamed from: com.facebook.ads.redexgen.X.aZ  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1403aZ implements InterfaceC06356k {
    public static String[] A01 = {"ks6FgoJovve7iHM2pZkl", "wha53u", "49wSJ7V8XkDKZTUcjMDnpoSn", "1JQ5I5ad77Yrp3ewkirQ0oRutiEmvr6i", "jAt3ZHaaMbDXz0fIQiir7V", "EKdcAjdCbYFTR4bnYqi4SV", "MwtlcC", "w1RouBmka6J1zGDRhikmrfItH78owLWg"};
    public final /* synthetic */ C1392aO A00;

    public C1403aZ(C1392aO c1392aO) {
        this.A00 = c1392aO;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        ActivityManager activityManager;
        activityManager = this.A00.A02;
        if (activityManager != null) {
            return this.A00.A0F(ActivityManager.isUserAMonkey());
        }
        C1392aO c1392aO = this.A00;
        EnumC06466v enumC06466v = EnumC06466v.A07;
        if (A01[2].length() != 23) {
            String[] strArr = A01;
            strArr[3] = "MHidzBjnmsHNQkooJipxy3AaWgleVPOv";
            strArr[7] = "EW2Ra62KpqEXQLSIkiFDqiivYFqdEGvM";
            return c1392aO.A07(enumC06466v);
        }
        throw new RuntimeException();
    }
}
