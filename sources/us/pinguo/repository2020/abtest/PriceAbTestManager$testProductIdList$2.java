package us.pinguo.repository2020.abtest;

import java.util.ArrayList;
import kotlin.collections.u;
import kotlin.jvm.internal.Lambda;
/* compiled from: PriceAbTestManager.kt */
/* loaded from: classes6.dex */
final class PriceAbTestManager$testProductIdList$2 extends Lambda implements kotlin.jvm.b.a<ArrayList<String>> {
    public static final PriceAbTestManager$testProductIdList$2 INSTANCE = new PriceAbTestManager$testProductIdList$2();

    PriceAbTestManager$testProductIdList$2() {
        super(0);
    }

    @Override // kotlin.jvm.b.a
    public final ArrayList<String> invoke() {
        ArrayList<String> f2;
        f2 = u.f("yearly_vip_0699_3dayfree", "yearly_vip_0999_3dayfree", "yearly_vip_1499_3dayfree", "yearly_vip_1999_3dayfree", "yearly_vip_2999_3dayfree");
        return f2;
    }
}
