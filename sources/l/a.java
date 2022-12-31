package l;

import android.content.Context;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.advstrategy.PgAdvStrategyManager;
/* compiled from: XiaomiChannelUtil.java */
/* loaded from: classes7.dex */
public class a {
    private static Boolean a;

    public static boolean a(Context context) {
        Boolean bool = a;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = false;
        if (PgAdvStrategyManager.getInstance().getStrategyKeeper(context).getGlobleOpenKey(IADStatisticBase.UNIT_ID_GLOBAL, "discard_channel_xiaomi")) {
            a = Boolean.FALSE;
            return false;
        }
        try {
            z = ((Boolean) Class.forName("miui.os.MiuiInit").getMethod("isPreinstalledPackage", String.class).invoke(null, context.getPackageName())).booleanValue();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        a = Boolean.valueOf(z);
        return z;
    }
}
