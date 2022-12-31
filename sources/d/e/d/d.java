package d.e.d;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: IronSourceAdInstanceBuilder.java */
/* loaded from: classes2.dex */
public class d {
    private String a;
    private boolean b = false;
    private boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, String> f8547d;

    /* renamed from: e  reason: collision with root package name */
    private d.e.d.n.c f8548e;

    public d(String str, d.e.d.n.c cVar) throws NullPointerException {
        com.ironsource.sdk.utils.f.C(str, "Instance name can't be null");
        this.a = str;
        com.ironsource.sdk.utils.f.D(cVar, "InterstitialListener name can't be null");
        this.f8548e = cVar;
    }

    public c a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.a);
            jSONObject.put("rewarded", this.b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new c(this.c ? g.b() : g.a(jSONObject), this.a, this.b, this.c, this.f8547d, this.f8548e);
    }

    public d b(Map<String, String> map) {
        this.f8547d = map;
        return this;
    }

    public d c() {
        this.c = true;
        return this;
    }

    public d d() {
        this.b = true;
        return this;
    }
}
