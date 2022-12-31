package vStudio.Android.Camera360.home.inspire.proxy;

import android.content.SharedPreferences;
import java.util.List;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.foundation.e;
import us.pinguo.foundation.utils.f0;
import us.pinguo.foundation.utils.k;
/* loaded from: classes7.dex */
public class AdvSelector {
    private static String getAdvGroupId(List<AdvItem> list) {
        String str;
        StringBuilder sb = new StringBuilder();
        for (AdvItem advItem : list) {
            if (advItem != null && (str = advItem.advId) != null) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static AdvItem getItem(String str) {
        AdvItem advItem;
        List<AdvItem> items = AdvConfigManager.getInstance().getItems(str);
        if (k.a(items)) {
            return null;
        }
        if (f0.b(getAdvGroupId(items), getSavedGroupId(str))) {
            advItem = AdvConfigManager.getInstance().getNextItem(getSavedAdvId(str), str, true);
        } else {
            AdvItem nextItem = AdvConfigManager.getInstance().getNextItem(null, str, true);
            saveAdvGroupId(str, items);
            advItem = nextItem;
        }
        saveAdvId(str, advItem);
        return advItem;
    }

    private static SharedPreferences getPreferences() {
        return e.b().getSharedPreferences("inspire_share_pref", 0);
    }

    private static String getSavedAdvId(String str) {
        SharedPreferences preferences = getPreferences();
        return preferences.getString("guid_adv:" + str, "");
    }

    private static String getSavedGroupId(String str) {
        SharedPreferences preferences = getPreferences();
        return preferences.getString("guid_group:" + str, "");
    }

    private static void saveAdvGroupId(String str, List<AdvItem> list) {
        SharedPreferences.Editor edit = getPreferences().edit();
        edit.putString("guid_group:" + str, getAdvGroupId(list)).apply();
    }

    private static void saveAdvId(String str, AdvItem advItem) {
        SharedPreferences.Editor edit = getPreferences().edit();
        edit.putString("guid_adv:" + str, advItem == null ? "" : advItem.advId).apply();
    }
}
