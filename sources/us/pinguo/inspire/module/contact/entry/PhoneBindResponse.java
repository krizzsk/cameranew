package us.pinguo.inspire.module.contact.entry;

import com.tapjoy.TapjoyConstants;
import d.f.a.b.d;
import java.util.Iterator;
import org.json.JSONObject;
import us.pinguo.inspire.module.profile.UserInfoLoader;
/* loaded from: classes4.dex */
public class PhoneBindResponse {
    public UserInfoLoader.TempUserInfo mInfo = new UserInfoLoader.TempUserInfo();
    public String message;
    public int status;

    public static PhoneBindResponse parseGson(String str) {
        PhoneBindResponse phoneBindResponse = new PhoneBindResponse();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equals("status")) {
                    phoneBindResponse.status = jSONObject.getInt(next);
                } else if (next.equals("message")) {
                    phoneBindResponse.message = jSONObject.getString(next);
                } else if (next.equals("data")) {
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                        Iterator<String> keys2 = jSONObject2.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            if (next2.equals("setPass")) {
                                phoneBindResponse.mInfo.setPass = jSONObject2.getInt(next2);
                            } else if (next2.equals(TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE)) {
                                phoneBindResponse.mInfo.mobile = jSONObject2.getString(next2);
                            }
                        }
                    } catch (Exception e2) {
                        d.c(e2);
                    }
                }
            }
        } catch (Exception e3) {
            d.c(e3);
        }
        return phoneBindResponse;
    }
}
