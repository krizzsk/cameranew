package us.pinguo.repository2020.abtest;

import java.util.ArrayList;
import kotlin.collections.u;
import kotlin.jvm.internal.Lambda;
/* compiled from: HWPriceTestManager.kt */
/* loaded from: classes6.dex */
final class HWPriceTestManager$testedProductIdList$2 extends Lambda implements kotlin.jvm.b.a<ArrayList<String>> {
    public static final HWPriceTestManager$testedProductIdList$2 INSTANCE = new HWPriceTestManager$testedProductIdList$2();

    HWPriceTestManager$testedProductIdList$2() {
        super(0);
    }

    @Override // kotlin.jvm.b.a
    public final ArrayList<String> invoke() {
        ArrayList<String> f2;
        f2 = u.f("hw_yearly_vip_0699", "hw_yearly_vip_0999", "hw_yearly_vip_1499", "hw_yearly_vip_1999", "hw_yearly_vip_2999");
        return f2;
    }
}
