package us.pinguo.inspire.model;

import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.inspire.Inspire;
/* loaded from: classes9.dex */
public class OfflineProcessorHelper {

    /* loaded from: classes9.dex */
    public static class OfflineResponse {
        public String data;
        public String message;
        public int status;
    }

    public static OfflineResponse getOfflineRespData(String str) {
        OfflineResponse offlineResponse = new OfflineResponse();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("status")) {
                offlineResponse.status = jSONObject.getInt("status");
            }
            if (!jSONObject.isNull("message")) {
                offlineResponse.message = jSONObject.getString("message");
            }
            if (!jSONObject.isNull("data")) {
                offlineResponse.data = jSONObject.getString("data");
            }
        } catch (JSONException e2) {
            Inspire.f(e2);
        }
        return offlineResponse;
    }
}
