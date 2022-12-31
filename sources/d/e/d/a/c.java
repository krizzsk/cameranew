package d.e.d.a;

import android.util.Base64;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ISNEventsFormatter.java */
/* loaded from: classes2.dex */
public class c implements d.e.a.d {
    @Override // d.e.a.d
    public String a(Map<String, Object> map) {
        try {
            return String.format("%s=%s", "data", Base64.encodeToString(new JSONObject().put("table", "supersonic.adunitanalytics.ad_unit_events").put("data", new JSONObject(map)).toString().getBytes(), 2));
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
