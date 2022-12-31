package us.pinguo.repository2020.abtest;

import java.util.ArrayList;
/* compiled from: HWPriceTestManager.kt */
/* loaded from: classes6.dex */
public final class HWPriceTestManager {
    public static final HWPriceTestManager a = new HWPriceTestManager();
    private static final kotlin.f b;

    static {
        kotlin.f b2;
        b2 = kotlin.h.b(HWPriceTestManager$testedProductIdList$2.INSTANCE);
        b = b2;
    }

    private HWPriceTestManager() {
    }

    public final String a() {
        String o = ABTestManager.a.o("hw_android_vip_sub_pcr_test");
        if (o == null) {
            return null;
        }
        switch (o.hashCode()) {
            case -289970728:
                if (o.equals("VIP_yearly_14.99")) {
                    return "hw_yearly_vip_1499";
                }
                break;
            case -289821773:
                if (o.equals("VIP_yearly_19.99")) {
                    return "hw_yearly_vip_1999";
                }
                break;
            case -288898252:
                if (o.equals("VIP_yearly_29.99")) {
                    return "hw_yearly_vip_2999";
                }
                break;
            case 1376262955:
                if (o.equals("VIP_yearly_6.99")) {
                    return "hw_yearly_vip_0699";
                }
                break;
            case 1376352328:
                if (o.equals("VIP_yearly_9.99")) {
                    return "hw_yearly_vip_0999";
                }
                break;
        }
        return "yearly_vip_2399";
    }

    public final ArrayList<String> b() {
        return (ArrayList) b.getValue();
    }
}
