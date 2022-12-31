package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.6b  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C06266b {
    public static byte[] A03;
    public static String[] A04 = {"o84FpHzEZxPfIbBPVc3PyJBEasuCfO6c", "JrI1dU8TTdtObirIwzr9PDFTf", "Oz2bxznKOZIoYiu00r0tMjRqahT5L8eX", "WyAMbI9dOM56rsavBzGbIzP4LEeOBa2a", "QAd1wzNDoH5I97BQWX3GR9O2v", "PJ66RTAVo3tttPzwttyvOY4w2twOeZmh", "FZtFZJQ3MyLobIqHR00oY", "wJgkVVpmtRvVSLM2dL7kjEoPPerdmE0p"};
    public final Context A00;
    public final Intent A01;
    public final AnonymousClass61 A02;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 8);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-114, -101, -111, -97, -100, -106, -111, 91, -106, -101, -95, -110, -101, -95, 91, -114, -112, -95, -106, -100, -101, 91, 111, 110, -127, -127, 114, Byte.MAX_VALUE, -122, -116, 112, 117, 110, 123, 116, 114, 113};
    }

    static {
        A01();
    }

    public C06266b(Context context, AnonymousClass61 anonymousClass61) {
        this.A00 = context;
        this.A02 = anonymousClass61;
        this.A01 = this.A00.registerReceiver(null, new IntentFilter(A00(0, 37, 37)));
    }

    @Nullable
    public final C06486x A02() {
        if (this.A02.A0a() == EnumC06396o.A0G) {
            return null;
        }
        Context context = this.A00;
        String[] strArr = A04;
        if (strArr[6].length() != strArr[1].length()) {
            A04[2] = "BdLEpYuR7vP7Yavjfaa4glVMZlrsrS6q";
            C06486x signalValueContext = new C06486x(context == null ? A00(0, 0, 34) : context.getPackageName());
            return signalValueContext;
        }
        throw new RuntimeException();
    }

    public final AbstractC06506z A03(float f2) {
        return new C1297Xh(SystemClock.elapsedRealtime(), A02(), f2);
    }

    public final AbstractC06506z A04(int i2) {
        return new C1295Xf(SystemClock.elapsedRealtime(), A02(), i2);
    }

    public final AbstractC06506z A05(int i2, HashMap<String, String> hashMap) {
        if (this.A01 != null) {
            HashMap<String, Integer> hashMap2 = new HashMap<>();
            for (String str : hashMap.keySet()) {
                String[] strArr = A04;
                if (strArr[7].length() != strArr[0].length()) {
                    throw new RuntimeException();
                }
                A04[2] = "InQCvX9bMvCeYEwlTxFUxsBs8sRyWh3b";
                Intent intent = this.A01;
                String key = hashMap.get(str);
                hashMap2.put(str, Integer.valueOf(intent.getIntExtra(key, i2)));
            }
            return A0C(hashMap2);
        }
        return A07(EnumC06466v.A07);
    }

    public final AbstractC06506z A06(long j2) {
        return new C1293Xd(SystemClock.elapsedRealtime(), A02(), j2);
    }

    public final AbstractC06506z A07(EnumC06466v enumC06466v) {
        return new C1298Xi(SystemClock.elapsedRealtime(), A02(), new C06476w(enumC06466v));
    }

    public final AbstractC06506z A08(String str) {
        return new C1290Xa(SystemClock.elapsedRealtime(), A02(), str);
    }

    public final AbstractC06506z A09(String str) {
        Intent intent = this.A01;
        if (intent != null) {
            return A08(intent.getStringExtra(str));
        }
        return A07(EnumC06466v.A07);
    }

    public final AbstractC06506z A0A(String str, int i2) {
        Intent intent = this.A01;
        if (intent != null) {
            int intExtra = intent.getIntExtra(str, i2);
            if (A04[4].length() != 16) {
                A04[2] = "oU3Fbet9HTJlYuGSJV9pu56iNwFexhrg";
                return A04(intExtra);
            }
            throw new RuntimeException();
        }
        return A07(EnumC06466v.A07);
    }

    public final AbstractC06506z A0B(String str, boolean z) {
        Intent intent = this.A01;
        if (intent != null) {
            return A0F(intent.getBooleanExtra(str, z));
        }
        return A07(EnumC06466v.A07);
    }

    public final AbstractC06506z A0C(HashMap<String, Integer> hashMap) {
        return new C1296Xg(SystemClock.elapsedRealtime(), A02(), hashMap);
    }

    public final AbstractC06506z A0D(List<InterfaceC06416q> list) {
        return new C1294Xe(SystemClock.elapsedRealtime(), A02(), list, EnumC06496y.A03);
    }

    public final AbstractC06506z A0E(List<String> resultList) {
        return new C1294Xe(SystemClock.elapsedRealtime(), A02(), resultList, EnumC06496y.A0C);
    }

    public final AbstractC06506z A0F(boolean z) {
        return new C1300Xk(SystemClock.elapsedRealtime(), A02(), z);
    }
}
