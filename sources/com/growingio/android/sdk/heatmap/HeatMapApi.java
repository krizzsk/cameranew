package com.growingio.android.sdk.heatmap;

import android.annotation.TargetApi;
import com.growingio.android.sdk.base.event.HttpCallBack;
import com.growingio.android.sdk.base.event.HttpEvent;
import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.NetworkConfig;
import com.growingio.android.sdk.models.ActionEvent;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.eventcenter.EventCenter;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
/* loaded from: classes2.dex */
public class HeatMapApi {
    private static final long HEAT_MAP_DURATION = 259200000;
    private static final long ONE_DAY = 86400000;
    private static final String TAG = "GIO.HeatMapApi";
    private static final Object requestLocker = new Object();

    /* loaded from: classes2.dex */
    public interface HeatMapCallback {
        void getHeatMapFinish(HeatMapResponse heatMapResponse);
    }

    @TargetApi(11)
    public static void getHeatMapData(String str, HeatMapCallback heatMapCallback) {
        requestHeatMapData(str, heatMapCallback);
    }

    private static void requestHeatMapData(String str, final HeatMapCallback heatMapCallback) {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("domain", CoreInitialize.coreAppState().getSPN());
            jSONObject.put(PGEditResultActivity2.PATH, str);
            jSONObject.put("beginTime", currentTimeMillis - HEAT_MAP_DURATION);
            jSONObject.put("endTime", currentTimeMillis);
            jSONObject.put("metric", ActionEvent.CLICK_TYPE_NAME);
            jSONObject.put("withIndex", true);
        } catch (JSONException unused) {
            LogUtil.d(TAG, "gen postHeatMapData json error");
        }
        HttpEvent createCircleHttpEvent = HttpEvent.createCircleHttpEvent(NetworkConfig.getInstance().getEndPoint() + Constants.HEAT_MAP_TAIL, jSONObject, false);
        createCircleHttpEvent.setCallBack(new HttpCallBack() { // from class: com.growingio.android.sdk.heatmap.HeatMapApi.1
            @Override // com.growingio.android.sdk.base.event.HttpCallBack
            public void afterRequest(Integer num, byte[] bArr, long j2, Map<String, List<String>> map) {
                synchronized (HeatMapApi.requestLocker) {
                    try {
                        final HeatMapResponse heatMapResponse = new HeatMapResponse(new JSONObject(new String(bArr)));
                        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.growingio.android.sdk.heatmap.HeatMapApi.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HeatMapCallback.this.getHeatMapFinish(heatMapResponse);
                            }
                        });
                    } catch (JSONException unused2) {
                        LogUtil.d(HeatMapApi.TAG, "parse the HeatMap error");
                    }
                }
            }
        });
        EventCenter.getInstance().post(createCircleHttpEvent);
    }
}
