package us.pinguo.smaatoapi.network;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.open.SocialConstants;
import com.zhy.android.percent.support.PercentLayoutHelper;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.inspire.api.QiniuAuthToken;
import us.pinguo.smaatoapi.a;
import us.pinguo.smaatoapi.network.a;
/* loaded from: classes6.dex */
public class InsertitialLoader implements a.b {

    /* renamed from: e  reason: collision with root package name */
    private static InsertitialLoader f11990e;
    private Context a;
    private a.InterfaceC0444a b;
    public us.pinguo.smaatoapi.c.a c;

    /* renamed from: d  reason: collision with root package name */
    public us.pinguo.smaatoapi.a f11991d;

    public InsertitialLoader(Context context) {
        this.a = context;
    }

    public static InsertitialLoader b(Context context) {
        if (f11990e == null) {
            f11990e = new InsertitialLoader(context);
        }
        return f11990e;
    }

    @Override // us.pinguo.smaatoapi.network.a.b
    public void a(String str, String str2) {
        JSONArray jSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            this.c = new us.pinguo.smaatoapi.c.a();
            char c = 65535;
            int hashCode = str2.hashCode();
            if (hashCode != 73635) {
                if (hashCode == 1173835880 && str2.equals("Richmedia")) {
                    c = 1;
                }
            } else if (str2.equals("Img")) {
                c = 0;
            }
            JSONArray jSONArray2 = null;
            if (c == 0) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(QiniuAuthToken.TYPE_IMAGE);
                JSONObject jSONObject3 = jSONObject2.getJSONObject(SocialConstants.PARAM_IMG_URL);
                String string = jSONObject3.getString("url");
                String string2 = jSONObject3.getString("ctaurl");
                int i2 = jSONObject3.getInt(PercentLayoutHelper.PercentLayoutInfo.BASEMODE.W);
                int i3 = jSONObject3.getInt(PercentLayoutHelper.PercentLayoutInfo.BASEMODE.H);
                JSONArray jSONArray3 = jSONObject2.getJSONArray("impressiontrackers");
                jSONArray = jSONObject2.getJSONArray("clicktrackers");
                this.c.k(string2);
                this.c.o(string);
                this.c.m(i3);
                this.c.r(i2);
                this.c.q(this.b);
                this.c.j(str2);
                jSONArray2 = jSONArray3;
            } else if (c != 1) {
                jSONArray = null;
            } else {
                JSONObject jSONObject4 = jSONObject.getJSONObject("richmedia");
                JSONObject jSONObject5 = jSONObject4.getJSONObject("mediadata");
                String string3 = jSONObject5.getString(FirebaseAnalytics.Param.CONTENT);
                int i4 = jSONObject5.getInt(PercentLayoutHelper.PercentLayoutInfo.BASEMODE.W);
                int i5 = jSONObject5.getInt(PercentLayoutHelper.PercentLayoutInfo.BASEMODE.H);
                jSONArray2 = jSONObject4.getJSONArray("impressiontrackers");
                jSONArray = jSONObject4.getJSONArray("clicktrackers");
                this.c.n(string3);
                this.c.m(i5);
                this.c.r(i4);
                this.c.q(this.b);
                this.c.j(str2);
            }
            if (jSONArray2 != null) {
                for (int i6 = 0; i6 < jSONArray2.length(); i6++) {
                    arrayList.add(jSONArray2.getString(i6));
                }
            }
            if (jSONArray != null) {
                for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                    arrayList2.add(jSONArray.getString(i7));
                }
            }
            this.c.l(arrayList2);
            this.c.p(arrayList);
            us.pinguo.smaatoapi.a aVar = new us.pinguo.smaatoapi.a(this.a, this.c);
            this.f11991d = aVar;
            this.b.a(aVar);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void c(a.InterfaceC0444a interfaceC0444a, String str, String str2) {
        this.b = interfaceC0444a;
        a.d(this.a, "display", str, str2, this);
    }

    @Override // us.pinguo.smaatoapi.network.a.b
    public void error(String str) {
        this.b.d(str);
    }
}
