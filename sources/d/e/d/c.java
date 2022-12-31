package d.e.d;

import com.google.firebase.messaging.Constants;
import java.util.HashMap;
import java.util.Map;
/* compiled from: IronSourceAdInstance.java */
/* loaded from: classes2.dex */
public class c {
    private String a;
    private String b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8543d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, String> f8544e;

    /* renamed from: f  reason: collision with root package name */
    private d.e.d.n.c f8545f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f8546g = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, String str2, boolean z, boolean z2, Map<String, String> map, d.e.d.n.c cVar) {
        this.a = str;
        this.b = str2;
        this.c = z;
        this.f8543d = z2;
        this.f8544e = map;
        this.f8545f = cVar;
    }

    public Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.FirelogAnalytics.PARAM_INSTANCE_ID, this.a);
        hashMap.put("instanceName", this.b);
        hashMap.put("rewarded", Boolean.toString(this.c));
        hashMap.put("inAppBidding", Boolean.toString(this.f8543d));
        hashMap.put("apiVersion", String.valueOf(2));
        Map<String, String> map = this.f8544e;
        if (map != null) {
            hashMap.putAll(map);
        }
        return hashMap;
    }

    public final d.e.d.n.c b() {
        return this.f8545f;
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return this.b;
    }

    public boolean e() {
        return this.f8543d;
    }

    public boolean f() {
        return this.f8546g;
    }

    public boolean g() {
        return this.c;
    }

    public void h(boolean z) {
        this.f8546g = z;
    }
}
