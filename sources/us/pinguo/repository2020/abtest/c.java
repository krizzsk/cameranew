package us.pinguo.repository2020.abtest;
/* compiled from: DomesticPriceTestManager.kt */
/* loaded from: classes6.dex */
public final class c {
    public static final c a = new c();

    private c() {
    }

    public final String a() {
        String o = ABTestManager.a.o("ov_android_vip_sub_pcr_test");
        if (o == null) {
            return null;
        }
        switch (o.hashCode()) {
            case -289970728:
                if (o.equals("VIP_yearly_14.99")) {
                    return "vip_month_12_14.99";
                }
                break;
            case -289821773:
                if (o.equals("VIP_yearly_19.99")) {
                    return "vip_month_12_19.99";
                }
                break;
            case -288898252:
                if (o.equals("VIP_yearly_29.99")) {
                    return "vip_month_12_29.99";
                }
                break;
            case 1376262955:
                if (o.equals("VIP_yearly_6.99")) {
                    return "vip_month_12_6.99";
                }
                break;
            case 1376352328:
                if (o.equals("VIP_yearly_9.99")) {
                    return "vip_month_12_9.99";
                }
                break;
        }
        return "vip_month_12";
    }
}
