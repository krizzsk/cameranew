package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.BatteryManager;
import android.os.Build;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import javax.inject.Singleton;
@Singleton
/* renamed from: com.facebook.ads.redexgen.X.Zi  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1350Zi extends C06266b {
    public static byte[] A01;
    public static String[] A02 = {"bPMdIRdGv", "GS1RiQ0Fe2OXcQcIkCuEDku7WILZ5IDY", "TsFhxeN3ooiOzKyGYimy4dCB8t9rX6Qk", "tDBwPFCmRryD0Q4apJFJlrgk6DNKamUD", "oUUA5cBoIxHqACzkd5Y2T9kUvSWODdEm", "FnX3lwsUZnwMMkDv8sp6DIbywwAIHXWj", "YZLb9o623eUfyZOuivTCDkgv5wbAGsEp", "CfH0aVj4RQl6Eoew8HOriE9Hjjy"};
    public final BatteryManager A00;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 124);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-7, 19, 18, 37, 37, 22, 35, 42, 30, 18, 31, 18, 24, 22, 35, 42, -11, -18, -1, -18, -11, 60, 81, 0, -16, -18, -7, -14};
    }

    static {
        A02();
    }

    public C1350Zi(Context context, AnonymousClass61 anonymousClass61) {
        super(context, anonymousClass61);
        this.A00 = (BatteryManager) context.getSystemService(A01(1, 14, 53));
    }

    public final InterfaceC06356k A0G() {
        return new C1358Zq(this);
    }

    public final InterfaceC06356k A0H() {
        return new C1352Zk(this);
    }

    public final InterfaceC06356k A0I() {
        HashMap hashMap = new HashMap();
        hashMap.put(A01(21, 1, 82), 2);
        hashMap.put(A01(0, 1, 28), 3);
        return new C1353Zl(this, hashMap);
    }

    public final InterfaceC06356k A0J() {
        HashMap hashMap = new HashMap();
        hashMap.put(A01(15, 1, 66), A01(16, 5, 13));
        hashMap.put(A01(22, 1, 98), A01(23, 5, 17));
        return new C1363Zv(this, hashMap);
    }

    public final InterfaceC06356k A0K() {
        return new C1355Zn(this);
    }

    public final InterfaceC06356k A0L() {
        return new C1360Zs(this);
    }

    public final InterfaceC06356k A0M() {
        return new C1357Zp(this);
    }

    public final InterfaceC06356k A0N() {
        return new C1351Zj(this);
    }

    public final InterfaceC06356k A0O() {
        return new C1359Zr(this);
    }

    public final InterfaceC06356k A0P() {
        return new C1362Zu(this);
    }

    public final InterfaceC06356k A0Q() {
        return new C1356Zo(this);
    }

    public final InterfaceC06356k A0R() {
        return new C1361Zt(this);
    }

    public final InterfaceC06356k A0S() {
        return new C1354Zm(this);
    }

    public final AbstractC06506z A0T(int i2) {
        if (Build.VERSION.SDK_INT < 21) {
            return A07(EnumC06466v.A05);
        }
        BatteryManager batteryManager = this.A00;
        if (A02[4].charAt(5) != 'c') {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[3] = "Z0BpikLZimvh7GQ0e0YfQZg6u7WmYRcx";
        strArr[6] = "N2CtCcOuXuTLuGr2kU7dW0gd7w3dfDGl";
        if (batteryManager != null) {
            return A04(batteryManager.getIntProperty(i2));
        }
        return A07(EnumC06466v.A07);
    }

    @SuppressLint({"Nullable Dereference"})
    public final AbstractC06506z A0U(HashMap<String, Integer> resultMap) {
        if (Build.VERSION.SDK_INT < 21) {
            return A07(EnumC06466v.A05);
        }
        BatteryManager batteryManager = this.A00;
        if (A02[4].charAt(5) != 'c') {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[3] = "VX9OpHMsf9E36khSHc5jiQggPTjCMNcl";
        strArr[6] = "9ZxqnrvyvCCPPfnmtmMIQlgDqEWsMyB8";
        if (batteryManager != null) {
            Set<String> keySet = resultMap.keySet();
            HashMap<String, Integer> hashMap = new HashMap<>();
            for (String str : keySet) {
                hashMap.put(str, Integer.valueOf(this.A00.getIntProperty(resultMap.get(str).intValue())));
            }
            return A0C(hashMap);
        }
        return A07(EnumC06466v.A07);
    }
}
