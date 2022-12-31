package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public final class PQ {
    public static byte[] A09;
    public static String[] A0A = {"wShQC8dEdCdDsonD9ckCi5w9U", "b5c2oWnzHv5UWiyt71KIAMilmtcSqC1N", "4oZvc6d7ZwR5AqDgCDxuZ3", "CpRmP5RSNkzg3ZlMUDzKwsVogZKCCIfv", "sNKw3geGf4TvnRH7EsTwjKTQ1PVdzKbr", "vkOXVJfFXuiRjckYDq31YMz3bRLaI4ty", "WCP05eFM3owSSVORqqhL5dWCzqIHotme", "3PgjMBtjqMKuKf4b6dM3cFumw"};
    public String A00;
    public String A01;
    public final C8J A02;
    public final JT A03;
    public final C0937Jb A04;
    public final PP A05;
    public final String A06;
    public final Map<String, String> A07;
    public final boolean A08;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A09, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 9);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A09 = new byte[]{-110, -91, -92, -92, -97, -98, -113, -109, -100, -103, -109, -101, Byte.MIN_VALUE, -109, -110, -110, -115, -116, 125, -116, Byte.MAX_VALUE, -117, -125, -112, -103, -113, -118, -114, -116, -99, -113, -118, -98, -109, -102, -94, -118, -96, -101, -59, -42, -59, -50, -44, -65, -59, -40, -44, -46, -63, 123, -116, 123, -124, -118, 117, -118, -113, -122, 123, -46, -52, -40, -48, -54, -41, -38, -52, -49, -110, -117, -100, -117, -110, -123, -119, -107, -109, -106, -110, -117, -102, -117, -122, Byte.MAX_VALUE, -112, Byte.MAX_VALUE, -122, 121, -120, 123, -121, Byte.MAX_VALUE, -40, -63};
    }

    static {
        A04();
    }

    public PQ(C8J c8j, PP pp, JT jt, Map<String, String> map, String str) {
        this.A02 = c8j;
        this.A05 = pp;
        this.A03 = jt;
        this.A07 = map;
        this.A06 = str;
        this.A04 = new C0937Jb(this.A06, this.A03);
        this.A08 = JD.A1M(pp.getContext());
    }

    private void A01() {
        HashMap hashMap = new HashMap();
        hashMap.put(A00(50, 10, 13), A00(60, 9, 98));
        A07(hashMap);
    }

    private void A02() {
        this.A04.A02(EnumC0936Ja.A0Y, null);
    }

    private void A03() {
        HashMap hashMap = new HashMap();
        hashMap.put(A00(50, 10, 13), A00(23, 16, 34));
        A07(hashMap);
    }

    private void A05(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(A00(83, 10, 17), String.valueOf(str));
        HashMap hashMap2 = new HashMap();
        hashMap2.put(A00(50, 10, 13), A00(69, 14, 29));
        hashMap2.put(A00(39, 11, 87), C0988Le.A01(hashMap));
        A07(hashMap2);
    }

    private void A06(String str, float f2, float f3) {
        HashMap hashMap = new HashMap();
        hashMap.put(A00(12, 11, 21), str);
        hashMap.put(A00(93, 1, 87), String.valueOf(f2));
        hashMap.put(A00(94, 1, 63), String.valueOf(f3));
        HashMap hashMap2 = new HashMap();
        hashMap2.put(A00(50, 10, 13), A00(0, 12, 39));
        hashMap2.put(A00(39, 11, 87), C0988Le.A01(hashMap));
        A07(hashMap2);
    }

    private void A07(Map<String, String> map) {
        if (TextUtils.isEmpty(this.A06)) {
            return;
        }
        Map<String, String> data = this.A07;
        map.putAll(data);
        Map<String, String> data2 = PR.A01(this.A02, this.A00, this.A01);
        map.putAll(data2);
        this.A03.A93(this.A06, map);
        if (A0A[2].length() != 22) {
            throw new RuntimeException();
        }
        String[] strArr = A0A;
        strArr[0] = "HxovkwELrWr5bBRZF5CQfpfOo";
        strArr[7] = "TU6dTWUJiKZlmHYRZZZtjyCrH";
    }

    @JavascriptInterface
    public void initializeLogging(String str, String str2) {
        if (!this.A08) {
            return;
        }
        this.A00 = str;
        this.A01 = str2;
    }

    @JavascriptInterface
    public void logButtonClick(String str, float f2, float f3) {
        if (!this.A08) {
            return;
        }
        A06(str, f2, f3);
    }

    @JavascriptInterface
    public void logEndCardShowUp() {
        if (!this.A08) {
            return;
        }
        A03();
    }

    @JavascriptInterface
    public void logGameLoad() {
        if (!this.A08) {
            return;
        }
        A01();
    }

    @JavascriptInterface
    public void logLevelComplete(String str) {
        if (!this.A08) {
            return;
        }
        A05(str);
    }

    @JavascriptInterface
    public void onCTAClick() {
        A02();
        this.A05.A0A();
    }
}
