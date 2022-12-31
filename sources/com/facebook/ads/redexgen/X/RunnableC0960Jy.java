package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.Jy  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class RunnableC0960Jy implements Runnable {
    public static byte[] A03;
    public final /* synthetic */ C8J A00;
    public final /* synthetic */ K1 A01;
    public final /* synthetic */ String A02;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 121);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{3, 27, 5, 60, 61, 39, 32, 59, 38, 45, 89, 78, 91, 68, 89, 95, 66, 69, 76, 54, 33, 53, 49, 33, 55, 48, 27, 45, 32};
    }

    public RunnableC0960Jy(K1 k1, String str, C8J c8j) {
        this.A01 = k1;
        this.A02 = str;
        this.A00 = c8j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List list;
        List list2;
        ArrayList arrayList;
        List list3;
        int i2;
        int i3;
        int i4;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            C06818n c06818n = new C06818n(A00(0, 3, 52));
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONObject.put(A00(3, 7, 45), jSONArray);
            jSONObject.put(A00(19, 10, 61), this.A02);
            list = this.A01.A0D;
            synchronized (list) {
                list2 = this.A01.A0D;
                arrayList = new ArrayList(list2);
                list3 = this.A01.A0D;
                list3.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                K0 k0 = (K0) it.next();
                StringBuilder sb = new StringBuilder();
                sb.append(A00(0, 0, 60));
                i2 = k0.A00;
                sb.append(i2);
                sb.append(';');
                i3 = k0.A02;
                sb.append(i3);
                sb.append(';');
                i4 = k0.A01;
                sb.append(i4);
                jSONArray.put(sb.toString());
            }
            c06818n.A05(jSONObject);
            c06818n.A03(1);
            this.A00.A06().A8r(A00(10, 9, 82), C06808m.A2D, c06818n);
        } catch (JSONException unused) {
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
