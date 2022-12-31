package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.SharedPreferences;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public final class MO {
    public static byte[] A01;
    public final Context A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 90);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-2, 28, 30, 16, 41, 11, 22, 33, 11, 35, 29, 41, 29, 18, 25, 33, 39, 41, 27, 52, 33, 22, 40, 41, 52, 22, 41, 41, 26, 34, 37, 41, 40, 34, 36, 22, 47, 28, 17, 35, 36, 47, 17, 36, 36, 21, 29, 32, 36, 47, 36, 25, 29, 21, 26, 28, 14, 39, 20, 9, 27, 28, 39, 26, Draft_75.CR, 27, 29, 20, 28, 39, 11, 23, 12, Draft_75.CR, -38, -27, -16, -38, -14, -20};
    }

    public MO(Context context) {
        this.A00 = context;
    }

    private void A02(StringBuilder sb) {
        int i2 = 0;
        int lastIndex = 0;
        while (true) {
            int indexOf = sb.indexOf(A00(0, 1, 120), i2);
            if (indexOf != -1) {
                lastIndex++;
                if (lastIndex == 5) {
                    sb.delete(indexOf, sb.length());
                    return;
                }
                i2 = indexOf + 1;
            } else {
                return;
            }
        }
    }

    public final void A03(String str) {
        SharedPreferences A00 = C0967Kg.A00(this.A00);
        String A002 = A00(16, 17, 123);
        String string = A00.getString(A002, null);
        StringBuilder sb = new StringBuilder(str);
        if (string != null) {
            sb.append(',');
            sb.append(string);
        }
        A02(sb);
        SharedPreferences.Editor edit = A00.edit();
        String previous = sb.toString();
        edit.putString(A002, previous);
        String previous2 = A00(74, 6, 31);
        if (previous2.equals(str)) {
            String previous3 = A00(1, 15, 112);
            edit.putBoolean(previous3, true);
        }
        edit.apply();
    }

    public final void A04(String str) {
        C0967Kg.A00(this.A00).edit().putString(A00(54, 20, 110), str).apply();
    }

    public final void A05(Map<String, String> map) {
        SharedPreferences A00 = C0967Kg.A00(this.A00);
        String A002 = A00(33, 21, 118);
        String A003 = A00(0, 0, 10);
        map.put(A002, A00.getString(A002, A003));
        String A004 = A00(54, 20, 110);
        map.put(A004, A00.getString(A004, A003));
        String A005 = A00(16, 17, 123);
        map.put(A005, A00.getString(A005, A003));
    }

    public final boolean A06() {
        return C0967Kg.A00(this.A00).getBoolean(A00(1, 15, 112), false);
    }
}
