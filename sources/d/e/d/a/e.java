package d.e.d.a;

import android.content.Context;
import android.util.Pair;
import com.ironsource.sdk.data.ISNEnums$ProductType;
import com.tapjoy.TJAdUnitConstants;
import d.e.a.a;
import d.e.d.a.b;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;
import us.pinguo.common.network.HttpRequest;
/* compiled from: ISNEventsUtils.java */
/* loaded from: classes2.dex */
public class e {
    public static d.e.a.a a(JSONObject jSONObject) {
        a.C0295a c0295a = new a.C0295a(jSONObject.optString("endpoint"));
        c0295a.l();
        c0295a.j(jSONObject.optBoolean(TJAdUnitConstants.String.ENABLED));
        c0295a.k(new c());
        c0295a.g(c());
        c0295a.i(false);
        return c0295a.h();
    }

    public static b b(Context context, String str, String str2, Map<String, String> map) throws Exception {
        b.C0297b c0297b = new b.C0297b();
        if (map != null && map.containsKey("sessionid")) {
            c0297b.d(map.get("sessionid"));
        }
        c0297b.c(context);
        c0297b.e(str);
        c0297b.b(str2);
        return c0297b.a();
    }

    private static ArrayList<Pair<String, String>> c() {
        ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
        arrayList.add(new Pair<>(HttpRequest.HEADER_CONTENT_TYPE, HttpRequest.CONTENT_TYPE_JSON));
        arrayList.add(new Pair<>(HttpRequest.PARAM_CHARSET, "utf-8"));
        return arrayList;
    }

    public static boolean d(com.ironsource.sdk.data.b bVar) {
        if (bVar == null || bVar.e().get("inAppBidding") == null) {
            return false;
        }
        return Boolean.parseBoolean(bVar.e().get("inAppBidding"));
    }

    public static ISNEnums$ProductType e(com.ironsource.sdk.data.b bVar, ISNEnums$ProductType iSNEnums$ProductType) {
        return (bVar == null || bVar.e() == null || bVar.e().get("rewarded") == null) ? iSNEnums$ProductType : Boolean.parseBoolean(bVar.e().get("rewarded")) ? ISNEnums$ProductType.RewardedVideo : ISNEnums$ProductType.Interstitial;
    }
}
