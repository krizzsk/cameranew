package us.pinguo.smaatoapi.network;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyConstants;
import com.tencent.open.SocialConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.smaatoapi.b;
import us.pinguo.smaatoapi.network.a;
/* loaded from: classes6.dex */
public class NativeLoader implements a.b {
    private static NativeLoader c;
    private Context a;
    private b.d b;

    public NativeLoader(Context context) {
        this.a = context;
    }

    public static NativeLoader b(Context context) {
        if (c == null) {
            c = new NativeLoader(context);
        }
        return c;
    }

    @Override // us.pinguo.smaatoapi.network.a.b
    public void a(String str, String str2) {
        us.pinguo.smaatoapi.b bVar = new us.pinguo.smaatoapi.b();
        bVar.k(this.a);
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject(TapjoyConstants.TJC_PLUGIN_NATIVE);
            JSONObject jSONObject2 = jSONObject.getJSONObject("link");
            JSONArray jSONArray = jSONObject2.getJSONArray("clicktrackers");
            bVar.n(jSONObject2.getString("url"));
            if (jSONArray.length() > 0) {
                bVar.o(jSONArray.getString(0));
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray("assets");
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                if (jSONObject3.has("title")) {
                    bVar.u(jSONObject3.getJSONObject("title").getString("text"));
                } else if (jSONObject3.has(SocialConstants.PARAM_IMG_URL)) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject(SocialConstants.PARAM_IMG_URL);
                    int i3 = jSONObject4.getInt("type");
                    if (i3 == 1) {
                        bVar.p(jSONObject4.getString("url"));
                    } else if (i3 == 3) {
                        bVar.s(jSONObject4.getString("url"));
                    }
                } else if (jSONObject3.has("data")) {
                    JSONObject jSONObject5 = jSONObject3.getJSONObject("data");
                    int i4 = jSONObject5.getInt("type");
                    if (i4 == 2) {
                        bVar.t(jSONObject5.getString(FirebaseAnalytics.Param.VALUE));
                    } else if (i4 == 12) {
                        bVar.m(jSONObject5.getString(FirebaseAnalytics.Param.VALUE));
                    }
                }
            }
            JSONArray jSONArray3 = jSONObject.getJSONArray("eventtrackers");
            if (jSONArray3.length() > 0) {
                bVar.q(jSONArray3.getJSONObject(0).getString("url"));
            }
            this.b.c(bVar);
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.b.e(e2.getMessage());
        }
    }

    public void c(b.d dVar, String str, String str2) {
        this.b = dVar;
        a.d(this.a, TapjoyConstants.TJC_PLUGIN_NATIVE, str, str2, this);
    }

    @Override // us.pinguo.smaatoapi.network.a.b
    public void error(String str) {
        this.b.e(str);
    }
}
