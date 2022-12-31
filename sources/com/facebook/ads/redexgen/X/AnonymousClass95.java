package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.95  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass95 {
    public static byte[] A0G;
    public static final AdPlacementType A0H;
    public static final String A0I;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public AdPlacementType A0B;
    public List<AnonymousClass93> A0C;
    public boolean A0D;
    public boolean A0E;
    public final long A0F = System.currentTimeMillis();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 13 out of bounds for length 13
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:202)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:134)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:118)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:564)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:39)
     */
    public AnonymousClass95(Map<String, String> map) {
        char c;
        this.A01 = -1;
        this.A00 = -1;
        this.A0B = A0H;
        this.A03 = 1;
        this.A0A = 0;
        this.A04 = 0;
        this.A05 = 20;
        this.A08 = 0;
        this.A09 = 1000;
        this.A06 = 10000;
        this.A07 = 200;
        this.A02 = 3600;
        this.A0D = false;
        this.A0E = false;
        this.A0C = null;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            switch (key.hashCode()) {
                case -1899431321:
                    if (key.equals(A01(55, 18, 70))) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case -1561601017:
                    if (key.equals(A01(189, 17, 75))) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -856794442:
                    if (key.equals(A01(283, 26, 70))) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case -726276175:
                    if (key.equals(A01(206, 15, 104))) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case -634541425:
                    if (key.equals(A01(73, 32, 35))) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -553208868:
                    if (key.equals(A01(46, 9, 62))) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 3575610:
                    if (key.equals(A01(221, 4, 35))) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 700812481:
                    if (key.equals(A01(105, 26, 17))) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 858630459:
                    if (key.equals(A01(309, 24, 113))) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 986744879:
                    if (key.equals(A01(225, 27, 93))) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case 1085444827:
                    if (key.equals(A01(182, 7, 94))) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1183549815:
                    if (key.equals(A01(252, 31, 68))) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 1230806061:
                    if (key.equals(A01(131, 20, 73))) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 1503616961:
                    if (key.equals(A01(151, 16, 73))) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case 2002133996:
                    if (key.equals(A01(167, 15, 64))) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    this.A0B = AdPlacementType.fromString(entry.getValue());
                    break;
                case 1:
                    this.A03 = Integer.parseInt(entry.getValue());
                    break;
                case 2:
                    this.A0A = Integer.parseInt(entry.getValue());
                    break;
                case 3:
                    this.A04 = Integer.parseInt(entry.getValue());
                    break;
                case 4:
                    this.A05 = Integer.parseInt(entry.getValue());
                    break;
                case 5:
                    this.A02 = Integer.parseInt(entry.getValue());
                    break;
                case 6:
                    this.A0D = Boolean.valueOf(entry.getValue()).booleanValue();
                    break;
                case 7:
                    this.A0E = Boolean.valueOf(entry.getValue()).booleanValue();
                    break;
                case '\b':
                    this.A01 = Integer.parseInt(entry.getValue());
                    break;
                case '\t':
                    this.A00 = Integer.parseInt(entry.getValue());
                    break;
                case '\n':
                    this.A08 = Integer.parseInt(entry.getValue());
                    break;
                case 11:
                    this.A09 = Integer.parseInt(entry.getValue());
                    break;
                case '\f':
                    this.A06 = Integer.parseInt(entry.getValue());
                    break;
                case '\r':
                    this.A0C = AnonymousClass93.A01(entry.getValue());
                    try {
                        CookieManager cookieManager = CookieManager.getInstance();
                        boolean acceptCookie = cookieManager.acceptCookie();
                        cookieManager.setAcceptCookie(true);
                        for (AnonymousClass93 anonymousClass93 : this.A0C) {
                            if (anonymousClass93.A04()) {
                                cookieManager.setCookie(anonymousClass93.A01, anonymousClass93.A00 + A01(24, 1, 3) + anonymousClass93.A02 + A01(0, 8, 102) + anonymousClass93.A01 + A01(8, 9, 87) + anonymousClass93.A03() + A01(17, 7, 72));
                            }
                        }
                        if (Build.VERSION.SDK_INT < 21) {
                            CookieSyncManager.getInstance().startSync();
                        }
                        cookieManager.setAcceptCookie(acceptCookie);
                        break;
                    } catch (Exception e2) {
                        Log.w(A0I, A01(25, 21, 59), e2);
                        break;
                    }
                case 14:
                    try {
                        this.A07 = Integer.parseInt(entry.getValue());
                        break;
                    } catch (NumberFormatException unused) {
                        this.A07 = 200;
                        break;
                    }
            }
        }
    }

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0G, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 114);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A0G = new byte[]{47, 80, 123, 121, 117, 125, 122, 41, 30, 96, 93, 85, 76, 87, 64, 86, 24, 1, 74, 91, 78, 82, 7, 21, 76, 15, 40, 32, 37, 44, 45, 105, 61, 38, 105, 58, 44, 61, 105, 42, 38, 38, 34, 32, 44, 103, 47, 45, 47, 36, 41, 45, 46, 32, 41, 87, 91, 90, 66, 107, 64, 70, 85, 87, 95, 93, 90, 83, 107, 80, 85, 64, 85, 56, 63, 39, 48, 61, 56, 53, 48, 37, 56, 62, 63, 14, 53, 36, 35, 48, 37, 56, 62, 63, 14, 56, 63, 14, 34, 52, 50, 62, 63, 53, 34, 14, 10, Draft_75.CR, 60, 21, 10, 6, 20, 2, 1, 10, 15, 10, 23, 26, 60, 19, 6, 17, 0, 6, Draft_75.CR, 23, 2, 4, 6, 84, 85, 72, 82, 79, 94, 100, 90, 95, 100, 94, 67, 75, 94, 73, 82, 94, 85, 88, 94, 75, 87, 90, 88, 94, 86, 94, 85, 79, 100, 83, 94, 82, 92, 83, 79, 66, 94, 83, 81, 87, 95, 87, 92, 70, 109, 69, 91, 86, 70, 90, 94, 73, 74, 94, 73, 95, 68, 75, 92, 95, 75, 92, 74, 81, 102, 77, 81, 75, 92, 74, 81, 86, 85, 93, 104, Byte.MAX_VALUE, 107, 111, Byte.MAX_VALUE, 105, 110, 69, 110, 115, 119, Byte.MAX_VALUE, 117, 111, 110, 37, 40, 33, 52, 89, 70, 75, 74, 64, 112, 91, 70, 66, 74, 112, 95, 64, 67, 67, 70, 65, 72, 112, 70, 65, 91, 74, 93, 89, 78, 67, 64, 95, 83, 65, 87, 84, 95, 90, 95, 66, 79, 105, 85, 94, 83, 85, 93, 105, 95, 88, 95, 66, 95, 87, 90, 105, 82, 83, 90, 87, 79, 66, 93, 81, 67, 85, 86, 93, 88, 93, 64, 77, 107, 87, 92, 81, 87, 95, 107, 93, 90, 64, 81, 70, 66, 85, 88, 117, 106, 102, 116, 98, 97, 106, 111, 106, 119, 122, 92, 96, 107, 102, 96, 104, 92, 119, 106, 96, 104, 102, 113};
    }

    static {
        A02();
        A0I = AnonymousClass95.class.getSimpleName();
        A0H = AdPlacementType.UNKNOWN;
    }

    public static AnonymousClass95 A00(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> keys = jSONObject.keys();
        HashMap hashMap = new HashMap();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, String.valueOf(jSONObject.opt(next)));
        }
        return new AnonymousClass95(hashMap);
    }

    public final int A03() {
        return this.A02 * 1000;
    }

    public final int A04() {
        return this.A03;
    }

    public final int A05() {
        return this.A06;
    }

    public final int A06() {
        return this.A07;
    }

    public final int A07() {
        return this.A08;
    }

    public final int A08() {
        return this.A09;
    }

    public final int A09() {
        return this.A0A;
    }

    public final long A0A() {
        return this.A04 * 1000;
    }

    public final long A0B() {
        return this.A05 * 1000;
    }

    public final long A0C() {
        return this.A0F;
    }

    public final AdPlacementType A0D() {
        return this.A0B;
    }

    public final boolean A0E() {
        return this.A0D;
    }

    public final boolean A0F() {
        return this.A0E;
    }
}
