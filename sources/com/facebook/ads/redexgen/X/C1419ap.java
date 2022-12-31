package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.ap  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1419ap implements C5Z {
    public static byte[] A03;
    public static String[] A04 = {"Yyt8Jrp", "FvQHlihhdkZe9tXm7YLHdG4gIBqm", "h7ITXytSbKbsxwMfZDKdUPEvMsTrizAq", "0TuNzKSIMRKA8K3EzRQL94hbriXTa7QT", "ySuQOOQJHVodSpCznPaDLfXVVxuxvbGA", "XYB8XYCfCTfWBGtKG07Wi1HuHmIQx2qC", "71D0xe3tljOi7f3b0iOVOXaXnoSWhNo4", "dwdYeokke3ChTNA3vTF4hdqHGwVronGN"};
    public final R4 A01;
    public Set<InterfaceC06025c> A00 = new HashSet();
    public final List<InterfaceC06015b> A02 = new ArrayList();

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 107);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{-72, -72, -67, 11, -46, -72, -67, 11, 41, 59, 59, 45, 60, 59};
    }

    static {
        A02();
    }

    public C1419ap(GC gc) {
        this.A01 = gc.A4M(R5.A0B);
        this.A01.A3E(new C1420aq(this));
        A03();
    }

    @Nullable
    public static Set<InterfaceC06025c> A01(JSONObject jSONObject) {
        C1418ao A00;
        HashSet hashSet = new HashSet();
        JSONArray optJSONArray = jSONObject.optJSONArray(A00(8, 6, 93));
        if (optJSONArray == null) {
            return null;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject assetJson = optJSONArray.optJSONObject(i2);
            if (assetJson == null || (A00 = C1418ao.A00(assetJson)) == null) {
                return null;
            }
            hashSet.add(A00);
            int i3 = A04[1].length();
            if (i3 == 21) {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[6] = "2zeGpFgTpOohtr7xv9EhLTO87hKhrQIZ";
            strArr[3] = "Z45Lb0RXWpRaUi2IX7mXCACeVe5qt7dU";
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void A03() {
        if (!this.A01.A8U()) {
            BuildConfigApi.isDebug();
            return;
        }
        Set<InterfaceC06025c> A01 = A01(this.A01.A6F());
        if (!this.A00.equals(A01) && A01 != null) {
            this.A00 = A01;
            for (InterfaceC06015b listener : this.A02) {
                listener.A3Q();
            }
        }
        if (BuildConfigApi.isDebug()) {
            for (InterfaceC06025c interfaceC06025c : this.A00) {
                String.format(Locale.US, A00(0, 8, 45), interfaceC06025c.A7c(), interfaceC06025c.getUrl());
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.C5Z
    public final void A3C(InterfaceC06015b interfaceC06015b) {
        this.A02.add(interfaceC06015b);
    }

    @Override // com.facebook.ads.redexgen.X.C5Z
    public final synchronized Set<InterfaceC06025c> A5g() {
        return new HashSet(this.A00);
    }
}
