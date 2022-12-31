package us.pinguo.advsdk.network;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import us.pinguo.advsdk.manager.PgAdvManager;
import us.pinguo.advstrategy.PgAdvStrategyManager;
import us.pinguo.advstrategy.strategybean.StrategyItem;
/* loaded from: classes3.dex */
public class ExpNetWorkUtils {
    private static ExpNetWorkUtils c;
    private boolean a = true;
    private String b;

    ExpNetWorkUtils() {
    }

    private String c(HashMap<String, String> hashMap) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            if (sb.toString().contains("=")) {
                sb.append(",");
            }
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        String sb2 = sb.toString();
        us.pinguo.advsdk.utils.b.a("result = " + sb2);
        return sb2;
    }

    public static ExpNetWorkUtils getInstance() {
        if (c == null) {
            c = new ExpNetWorkUtils();
        }
        return c;
    }

    public StrategyItem a(Context context, String str) {
        StrategyItem strategyItem = PgAdvStrategyManager.getInstance().getStrategyKeeper(context).getStrategyItem(str);
        if (strategyItem == null) {
            return null;
        }
        if (!strategyItem.isEnable()) {
            us.pinguo.advsdk.utils.b.a(strategyItem.unit_desc + ":" + strategyItem.unit_id + ":is closed");
            return strategyItem;
        } else if (this.a) {
            return strategyItem;
        } else {
            us.pinguo.advsdk.utils.b.a("ad not enable");
            return null;
        }
    }

    public boolean b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            us.pinguo.advsdk.utils.b.a("StrategyItem unitid is null ");
            return false;
        }
        StrategyItem strategyItem = PgAdvStrategyManager.getInstance().getStrategyKeeper(context).getStrategyItem(str);
        if (strategyItem == null) {
            us.pinguo.advsdk.utils.b.a("StrategyItem item is null ,closed the request ,unitId = " + str);
            return false;
        } else if (!strategyItem.isEnable()) {
            us.pinguo.advsdk.utils.b.a(strategyItem.unit_desc + ":" + strategyItem.unit_id + ":is closed");
            return false;
        } else if (this.a) {
            return true;
        } else {
            us.pinguo.advsdk.utils.b.a("ad not enable");
            return false;
        }
    }

    public void d(Context context, String str) {
        e(context, a(context, str));
    }

    public void e(Context context, StrategyItem strategyItem) {
        f(context, strategyItem, "overlapping_experiment_prod_post");
    }

    public void f(Context context, StrategyItem strategyItem, String str) {
        if (strategyItem == null || TextUtils.isEmpty(strategyItem.prod_tag)) {
            return;
        }
        String strategyDataVersion = PgAdvStrategyManager.getInstance().getStrategyKeeper(context).getStrategyDataVersion();
        if (TextUtils.isEmpty(this.b)) {
            this.b = us.pinguo.advsdk.utils.d.d(context);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("exp_version", strategyDataVersion);
        hashMap.put("exp_tag_set", strategyItem.getProductTag());
        hashMap.put("device_id", this.b);
        try {
            PgAdvManager.getInstance().r().e(str, c(hashMap));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
    }
}
