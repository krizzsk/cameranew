package us.pinguo.inspire.module.profile;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.json.JSONObject;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.model.InspireGeo;
/* loaded from: classes4.dex */
public class InspireLocationManager {
    public static final String EN_US = "en_us";
    private static final String NAME_KEY = "n";
    public static final String ZH_CN = "zh_cn";
    public static final String ZH_TW = "zh_tw";
    private static Context mContext;
    private static String mLocationJson;
    private static InspireLocationManager sInspireLocationManager;
    private static Map sLocationMap;

    /* loaded from: classes4.dex */
    public interface LocationResultListener {
        void onResult(InspireGeo inspireGeo);
    }

    private InspireLocationManager() {
        mContext = Inspire.a();
    }

    private InputStream getInputStream(Context context) throws IOException {
        String lowerCase = context.getResources().getConfiguration().locale.toString().toLowerCase();
        if (lowerCase.equals(ZH_CN)) {
            return mContext.getAssets().open("zh.json");
        }
        if (lowerCase.equals(ZH_TW)) {
            return mContext.getAssets().open("tw.json");
        }
        return mContext.getAssets().open("en.json");
    }

    public static synchronized InspireLocationManager getInstance() {
        InspireLocationManager inspireLocationManager;
        synchronized (InspireLocationManager.class) {
            if (sInspireLocationManager == null) {
                sInspireLocationManager = new InspireLocationManager();
            }
            inspireLocationManager = sInspireLocationManager;
        }
        return inspireLocationManager;
    }

    private InspireGeo getLocationGeoFromJson(String str, String str2, String str3) {
        InspireGeo inspireGeo = new InspireGeo();
        try {
            if (TextUtils.isEmpty(mLocationJson)) {
                InputStream inputStream = getInputStream(mContext);
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                inputStream.close();
                mLocationJson = new String(bArr, "UTF-8");
            }
            JSONObject jSONObject = new JSONObject(mLocationJson).getJSONObject(str);
            inspireGeo.country = jSONObject.getString(NAME_KEY);
            JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
            inspireGeo.province = jSONObject2.getString(NAME_KEY);
            inspireGeo.city = jSONObject2.getJSONObject(str3).getString(NAME_KEY);
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
        }
        return inspireGeo;
    }

    private InspireGeo getLocationGeoFromMap(String str, String str2, String str3) {
        InspireGeo inspireGeo = new InspireGeo();
        try {
            if (sLocationMap == null) {
                if (TextUtils.isEmpty(mLocationJson)) {
                    String object = new LocationCodeResourceCache(us.pinguo.inspire.util.r.a(mContext)).getObject();
                    mLocationJson = object;
                    if (TextUtils.isEmpty(object)) {
                        us.pinguo.common.log.a.m("FK", "get from inner file.............", new Object[0]);
                        InputStream inputStream = getInputStream(mContext);
                        byte[] bArr = new byte[inputStream.available()];
                        inputStream.read(bArr);
                        inputStream.close();
                        mLocationJson = new String(bArr, "UTF-8");
                    } else {
                        us.pinguo.common.log.a.m("FK", "get from cache.............", new Object[0]);
                    }
                }
                sLocationMap = (Map) new com.google.gson.e().k(mLocationJson, new com.google.gson.t.a<Map>() { // from class: us.pinguo.inspire.module.profile.InspireLocationManager.1
                }.getType());
            }
            Map map = (Map) sLocationMap.get(str);
            Map map2 = (Map) map.get(str2);
            inspireGeo.country = (String) map.get(NAME_KEY);
            inspireGeo.province = (String) map2.get(NAME_KEY);
            inspireGeo.city = (String) ((Map) map2.get(str3)).get(NAME_KEY);
            us.pinguo.common.log.a.m("FK", "LocationManager:" + inspireGeo.toString(), new Object[0]);
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
        }
        return inspireGeo;
    }

    public void getGeo(String str, String str2, String str3, LocationResultListener locationResultListener) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            if (locationResultListener != null) {
                locationResultListener.onResult(new InspireGeo());
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        InspireGeo locationGeoFromMap = getLocationGeoFromMap(str, str2, str3);
        long currentTimeMillis2 = System.currentTimeMillis();
        us.pinguo.common.log.a.m("FKK", "cost Time:" + (currentTimeMillis2 - currentTimeMillis), new Object[0]);
        if (locationResultListener != null) {
            locationResultListener.onResult(locationGeoFromMap);
        }
    }
}
