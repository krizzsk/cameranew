package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.0t  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C04900t {
    public static byte[] A03;
    public static String[] A04 = {"Nqgg", "8wGIqWp", "y92csH8tMmRGnIZZsga62xjDucPy6znH", "NuhdC57WslsG6uEsDnOxbiezpeKaNBmF", "EG4F575TP", "HLT5liagTN6y0JvSt92F6CLrVRU5nCH8", "PjujBbxPTNTRaLXrj7yD38jvaiKi7YAc", "GRbHVCF"};
    public final LinkedHashSet<String> A01 = new LinkedHashSet<>();
    public JSONObject A00 = new JSONObject();
    public final AtomicReference<String> A02 = new AtomicReference<>(A00(0, 2, 25));

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 79);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{Draft_75.CR, 11, 56, 58, 43, 74, 65, 76, 93, 86, 95, 91, 74, 75, 112, 70, 75, 86, 90, 67, 100, 88, 90, 75, 75, 94, 95, 100, 90, 73, 73, 90, 66, 100, 87, 94, 85, 92, 79, 83, 112, 124, 124, 106, 109, 109, 122, 113, 124, 122, 108, 19, 6, 17, 10, 12, 7, 22, 1, 27, 26, 49, 1, Draft_75.CR, Draft_75.CR, 27, 28, 28, 11, 0, Draft_75.CR, 11, 49, 29, 11, Draft_75.CR, 29, 97, 118, 108, 109, 70, 105, 124, 107, 112, 118, 125};
    }

    static {
        A01();
    }

    public final String A02() {
        String str = this.A02.get();
        return str == null ? A00(0, 2, 25) : str;
    }

    public final JSONObject A03() {
        return this.A00;
    }

    public final synchronized void A04() {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.A01.iterator();
        while (it.hasNext()) {
            String encryptedAdId = it.next();
            jSONArray.put(encryptedAdId);
        }
        AtomicReference<String> atomicReference = this.A02;
        String encryptedAdId2 = jSONArray.toString();
        atomicReference.set(encryptedAdId2);
    }

    public final void A05(String str) throws JSONException {
        if (str == null || str.trim().isEmpty()) {
            return;
        }
        this.A00 = new JSONObject(str);
        Iterator<String> keys = this.A00.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (this.A00.get(next) instanceof String) {
                A09(new JSONObject((String) this.A00.get(next)));
            }
        }
    }

    public final synchronized void A06(String str) {
        if (this.A01.size() >= C1M.A00()) {
            Iterator<String> it = this.A01.iterator();
            if (it.hasNext()) {
                this.A01.remove(it.next());
            }
        }
        this.A01.add(str);
        C06215w.A03();
    }

    public final synchronized void A07(String str) throws JSONException {
        if (str != null) {
            if (!str.trim().isEmpty()) {
                JSONArray jSONArray = new JSONArray(str);
                for (int i2 = 0; i2 < jSONArray.length() && i2 < C1M.A00(); i2++) {
                    this.A01.add(jSONArray.getString(i2));
                }
            }
        }
    }

    public final synchronized void A08(String str) {
        this.A01.remove(str);
        C06215w.A03();
    }

    public final void A09(JSONObject jSONObject) throws JSONException {
        String optString = jSONObject.optString(A00(5, 12, 96), null);
        int optInt = jSONObject.optInt(A00(51, 6, 44));
        int optInt2 = jSONObject.optInt(A00(77, 11, 86));
        int optInt3 = jSONObject.optInt(A00(17, 23, 116), 50);
        long optLong = jSONObject.optLong(A00(2, 3, 20));
        C1M c1m = new C1M(optString);
        if (optString != null && this.A00.has(optString) && (this.A00.get(optString) instanceof C1M)) {
            c1m = (C1M) this.A00.get(optString);
        }
        String A00 = A00(40, 11, 80);
        if (jSONObject.has(A00)) {
            c1m.A06((JSONArray) jSONObject.get(A00));
        }
        String A002 = A00(57, 20, 33);
        if (jSONObject.has(A002)) {
            c1m.A04(jSONObject.optInt(A002));
        }
        c1m.A05(optInt, optInt2, optLong, optInt3);
        String[] strArr = A04;
        String str = strArr[3];
        String str2 = strArr[2];
        int maxCappedArrayLength = str.charAt(11);
        if (maxCappedArrayLength != str2.charAt(11)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[3] = "tpg9MOL30KnGen5hdACKzszPCJWxtgkM";
        strArr2[2] = "0kRc9hG2BxRGhE0oYKlFhIYiMAEEJmAF";
        this.A00.put(optString, c1m);
    }
}
