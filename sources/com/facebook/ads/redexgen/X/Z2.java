package com.facebook.ads.redexgen.X;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public class Z2 implements InterfaceC06356k {
    public static String[] A02 = {"2ZaMFzGKyd9hSHjcUno1udsEhbeu09ce", "vtEgA47YqlpfzAewuy7ISaRlDIFsO2a2", "0pnteHQI04JELPJiiEYAY3M", "2nICVeqwE", "Lm6L6ti1RgkYKkQwD0idrMIu4GdN9z0L", "56JOKRJet", "nEp6Q7dVZjXWwne9d2QyLy7miVXBQb0l", "dXPHGnc4ncUJghGdDaugHzl"};
    public final /* synthetic */ Z0 A00;
    public final /* synthetic */ List A01;

    public Z2(Z0 z0, List list) {
        this.A00 = z0;
        this.A01 = list;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        AbstractC06506z A022;
        String A07;
        File A03;
        HashMap hashMap = new HashMap();
        Iterator it = this.A01.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            String[] strArr = A02;
            if (strArr[2].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[2] = "3z5KEoLDxtAdyJAxPBbZMV2";
            strArr2[5] = "xCESy1UOQ";
            if (!hasNext) {
                A022 = this.A00.A02(hashMap);
                return A022;
            }
            C06346j c06346j = (C06346j) it.next();
            if (c06346j.A02()) {
                A07 = Z0.A07((String) c06346j.A01());
                A03 = Z0.A03(A07);
                hashMap.put(A07, new Z1(A03));
            }
        }
    }
}
