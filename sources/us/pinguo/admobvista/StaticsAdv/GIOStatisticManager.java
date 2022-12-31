package us.pinguo.admobvista.StaticsAdv;

import android.text.TextUtils;
import com.growingio.android.sdk.collection.AbstractGrowingIO;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GIOStatisticManager {
    private static final String DIMENSION = "K";
    public static final String KEY_ADV_ALBUM_PV = "adv_album_pv";
    public static final String KEY_ADV_EDIT_PV = "adv_edit_pv";
    public static final String KEY_ADV_HOME_PV = "adv_home_pv";
    public static final String KEY_ADV_PREVIEW_PV = "adv_preview_pv";
    public static final String KEY_ADV_RESULT_PV = "adv_result_pv";
    public static final String KEY_DAU_INNER = "adv_dau_inner";

    public static void onEvent(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("K", "v");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        AbstractGrowingIO.getInstance().track(str, jSONObject);
    }
}
