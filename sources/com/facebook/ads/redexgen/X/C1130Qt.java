package com.facebook.ads.redexgen.X;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* renamed from: com.facebook.ads.redexgen.X.Qt  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1130Qt implements Map<String, String> {
    public static byte[] A01;
    public static String[] A02 = {"PF87FPxaVTPso7PkqBpb9R8ptdrOrcnN", "LLxQm2Zb2cHXH3GFymsIhrLJVNNE7YVf", "GuFHMY1Ngi3Kc2EktfHyZFCwamvVcTYP", "RLQ8yg86xneBytoGnRzJJpBSehxbgMLw", "NMpoE2AaAPP7Vgv", "uWFt37UVBdA9eGMxe0FCLaB7SA4moHLj", "Z5zgjYqznpdx1Id", "YNAb6cApL15ElRgBdI6o6I27RW0RMDqg"};
    public Map<String, String> A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A02[0].charAt(17) == '0') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[6] = "S05lPw0aRgv2lts";
            strArr[4] = "ULH8g1fEmmBcyVg";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 49);
            i5++;
        }
    }

    public static void A03() {
        A01 = new byte[]{-56, -63, -48, -49, -63, -88, -77};
    }

    static {
        A03();
    }

    public C1130Qt() {
        this.A00 = new HashMap();
    }

    public C1130Qt(Map<String, String> map) {
        this.A00 = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Map
    /* renamed from: A01 */
    public final String get(Object obj) {
        return this.A00.get(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Map
    /* renamed from: A02 */
    public final String remove(Object obj) {
        return this.A00.remove(obj);
    }

    public final C1130Qt A04(String str, String str2) {
        this.A00.put(str, str2);
        return this;
    }

    public final C1130Qt A05(Map<? extends String, ? extends String> arg) {
        putAll(arg);
        return this;
    }

    public final String A06() {
        if (this.A00 == null) {
            return A00(0, 0, 66);
        }
        StringBuilder sb = new StringBuilder();
        for (String str : this.A00.keySet()) {
            if (sb.length() > 0) {
                String[] strArr = A02;
                String str2 = strArr[5];
                String key = strArr[2];
                if (str2.charAt(2) != key.charAt(2)) {
                    throw new RuntimeException();
                }
                A02[1] = "xulkP76phNp8oPrFkycOZ9oAWaaFvsfs";
                sb.append(A00(0, 1, 113));
            }
            sb.append(str);
            String str3 = this.A00.get(str);
            if (str3 != null) {
                sb.append(A00(1, 1, 83));
                try {
                    sb.append(URLEncoder.encode(str3, A00(2, 5, 74)));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    @Override // java.util.Map
    /* renamed from: A07 */
    public final String put(String str, String str2) {
        return this.A00.put(str, str2);
    }

    public final byte[] A08() {
        byte[] bArr = null;
        try {
            bArr = A06().getBytes(A00(2, 5, 74));
            return bArr;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return bArr;
        }
    }

    @Override // java.util.Map
    public final void clear() {
        this.A00.clear();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return this.A00.containsKey(obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return this.A00.containsValue(obj);
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, String>> entrySet() {
        return this.A00.entrySet();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.A00.isEmpty();
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return this.A00.keySet();
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends String> map) {
        Map<? extends String, ? extends String> arg = this.A00;
        arg.putAll(map);
    }

    @Override // java.util.Map
    public final int size() {
        return this.A00.size();
    }

    @Override // java.util.Map
    public final Collection<String> values() {
        return this.A00.values();
    }
}
