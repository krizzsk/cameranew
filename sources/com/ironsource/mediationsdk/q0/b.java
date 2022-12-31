package com.ironsource.mediationsdk.q0;

import java.util.HashMap;
import java.util.Map;
/* compiled from: IronsourceMapUtilities.java */
/* loaded from: classes2.dex */
public class b {
    public static Map<String, Object> a(Object[][] objArr) {
        HashMap hashMap = new HashMap();
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    hashMap.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception unused) {
            }
        }
        return hashMap;
    }
}
