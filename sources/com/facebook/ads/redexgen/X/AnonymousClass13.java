package com.facebook.ads.redexgen.X;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.ads.AdError;
/* renamed from: com.facebook.ads.redexgen.X.13  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass13 extends BroadcastReceiver {
    public static String[] A03 = {"JgmY627JJ4fVvMUsUI7dBJzvca", "2Fivc7ze9Y6M7vLBAhVCw66dd2zEUTp", "oqNyJxLxp23hnAfKGRpFUMlaCTnSy4au", "HRO7fC4J0U3bXqsrOiWljP6J940cuLTJ", "rhEs9JkkityiMJcgD18RNPKtdGmllPs6", "c8I5EiJJKjWgwuyghylYWruaZ4nXJiut", "YeKDqRnNq5JcEGU0HYsnt6sxK1D4K6hE", "zIQMBMVVQmczFglCifMrZtV9RNUhKeCf"};
    public AbstractC1533co A00;
    public AnonymousClass12 A01;
    public String A02;

    public AnonymousClass13(String str, AbstractC1533co abstractC1533co, AnonymousClass12 anonymousClass12) {
        this.A00 = abstractC1533co;
        this.A01 = anonymousClass12;
        this.A02 = str;
    }

    public final IntentFilter A00() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(EnumC1097Pm.A06.A03(this.A02));
        intentFilter.addAction(EnumC1097Pm.A09.A03(this.A02));
        intentFilter.addAction(EnumC1097Pm.A04.A03(this.A02));
        intentFilter.addAction(EnumC1097Pm.A0A.A03(this.A02));
        intentFilter.addAction(EnumC1097Pm.A05.A03(this.A02));
        intentFilter.addAction(EnumC1097Pm.A0C.A03(this.A02));
        intentFilter.addAction(EnumC1097Pm.A0B.A03(this.A02));
        intentFilter.addAction(EnumC1097Pm.A03.A03(this.A02));
        return intentFilter;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (EnumC1097Pm.A06.A03(this.A02).equals(action)) {
            AnonymousClass12 anonymousClass12 = this.A01;
            AbstractC1533co abstractC1533co = this.A00;
            if (A03[1].length() != 11) {
                A03[0] = "z37hhVYNur1y5njE4t22VYTMbB";
                anonymousClass12.ABz(abstractC1533co);
                return;
            }
        } else if (EnumC1097Pm.A09.A03(this.A02).equals(action)) {
            boolean A1C = JD.A1C(context);
            String[] strArr = A03;
            if (strArr[3].charAt(16) != strArr[4].charAt(16)) {
                A03[0] = "a2nbOp8yH430aeg70B0MHQFnwN";
                if (A1C) {
                    AnonymousClass12 anonymousClass122 = this.A01;
                    AbstractC1533co abstractC1533co2 = this.A00;
                    AdError adError = AdError.AD_PRESENTATION_ERROR;
                    String[] strArr2 = A03;
                    if (strArr2[3].charAt(16) != strArr2[4].charAt(16)) {
                        String[] strArr3 = A03;
                        strArr3[2] = "Smm3aT6IchFgLH9ob00fwQqxHFnPPG6O";
                        strArr3[5] = "wzZfDEncWZ9M4YUYJFr8Gzf2lfnMb6hd";
                        anonymousClass122.AC0(abstractC1533co2, adError);
                        return;
                    }
                    String[] strArr4 = A03;
                    strArr4[6] = "douVyTcHxmEKv1YyJqQbVTsvWWCOpXBn";
                    strArr4[7] = "x6yn97aV8hj96Z0WREVv4HAdEeLr9VIY";
                    anonymousClass122.AC0(abstractC1533co2, adError);
                    return;
                }
                this.A01.AC0(this.A00, AdError.INTERNAL_ERROR);
                return;
            }
        } else if (EnumC1097Pm.A04.A03(this.A02).equals(action)) {
            this.A01.ABw(this.A00);
            return;
        } else if (EnumC1097Pm.A0A.A03(this.A02).equals(action)) {
            this.A01.ABy(this.A00);
            return;
        } else if (EnumC1097Pm.A05.A03(this.A02).equals(action)) {
            this.A01.onRewardedVideoClosed();
            return;
        } else if (EnumC1097Pm.A0B.A03(this.A02).equals(action)) {
            this.A01.ABu(this.A00);
            return;
        } else if (EnumC1097Pm.A0C.A03(this.A02).equals(action)) {
            this.A01.ABv(this.A00);
            return;
        } else if (!EnumC1097Pm.A03.A03(this.A02).equals(action)) {
            return;
        } else {
            this.A01.onRewardedVideoActivityDestroyed();
            return;
        }
        throw new RuntimeException();
    }
}
