package g;

import android.content.Context;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.advstrategy.PgAdvStrategyManager;
/* compiled from: OppoChannelUtil.java */
/* loaded from: classes3.dex */
public class a {
    private static final Boolean a = Boolean.FALSE;

    public static boolean a(Context context) {
        if (PgAdvStrategyManager.getInstance().getStrategyKeeper(context).getGlobleOpenKey(IADStatisticBase.UNIT_ID_GLOBAL, "discard_channel_oppo")) {
            return false;
        }
        if (a.booleanValue()) {
            us.pinguo.admobvista.f.a.b(context, "is_oppo_preinstall", Boolean.TRUE);
            return true;
        }
        return ((Boolean) us.pinguo.admobvista.f.a.a(context, "is_oppo_preinstall", Boolean.FALSE)).booleanValue();
    }
}
