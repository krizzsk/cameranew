package us.pinguo.webview.f.h;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: PGShowMenuItems.java */
/* loaded from: classes6.dex */
public class l extends us.pinguo.webview.f.b<y, us.pinguo.webview.f.e> {

    /* renamed from: d  reason: collision with root package name */
    private static final Set<String> f12500d;

    static {
        HashSet hashSet = new HashSet();
        f12500d = hashSet;
        hashSet.add("qq");
        hashSet.add("qqzone");
        hashSet.add(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE);
        hashSet.add("wechatMoments");
        hashSet.add(us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.webview.f.b
    /* renamed from: h */
    public y c(JSONObject jSONObject) {
        try {
            y yVar = new y();
            ArrayList arrayList = new ArrayList();
            if (jSONObject.has("list")) {
                JSONArray jSONArray = jSONObject.getJSONArray("list");
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    if (jSONObject2.has("name") && FirebaseAnalytics.Event.SHARE.equals(jSONObject2.getString("name")) && jSONObject2.has("list")) {
                        JSONArray jSONArray2 = jSONObject2.getJSONArray("list");
                        int length2 = jSONArray2.length();
                        for (int i3 = 0; i3 < length2; i3++) {
                            JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                            if (jSONObject3.has("name")) {
                                String string = jSONObject3.getString("name");
                                if (f12500d.contains(string)) {
                                    arrayList.add(string);
                                }
                            }
                        }
                    }
                }
            }
            yVar.a = arrayList;
            return yVar;
        } catch (Exception unused) {
            return null;
        }
    }
}
