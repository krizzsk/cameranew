package us.pinguo.push;

import com.tapjoy.TapjoyAuctionFlags;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;
/* compiled from: PushCenter.java */
/* loaded from: classes6.dex */
public class a {
    private static final SimpleDateFormat a = new SimpleDateFormat("yyyyMMdd HH:mm", Locale.ENGLISH);

    private static Date a(String str) {
        if (str != null && !"".equals(str.trim())) {
            try {
                return a.parse(str);
            } catch (ParseException unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.Object] */
    public static c b(String str) {
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt(jSONObject.getString("type"));
            c a2 = f.b().a(Integer.valueOf(parseInt));
            if (a2 == null) {
                return null;
            }
            a2.f11771d = parseInt;
            a2.a = str;
            a2.b = jSONObject.getString(TapjoyAuctionFlags.AUCTION_ID);
            Date a3 = a(jSONObject.optString("from"));
            a2.f11772e = a3;
            if (a3 == null) {
                a2.f11772e = a(jSONObject.optString("fromDate"));
            }
            Date a4 = a(jSONObject.optString("to"));
            a2.f11773f = a4;
            if (a4 == null) {
                a2.f11773f = a(jSONObject.optString("toDate"));
            }
            int parseInt2 = Integer.parseInt(jSONObject.getString("show"));
            a2.c = parseInt2;
            if (parseInt2 == 1) {
                h c = h.c(jSONObject.getString("notify"));
                if (c == null) {
                    return null;
                }
                a2.f11774g = c;
            }
            ?? i2 = a2.i(jSONObject.getString("data"));
            a2.f11775h = i2;
            if (i2 == 0) {
                a2.h(1, str);
            }
            return a2;
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
            return null;
        }
    }
}
