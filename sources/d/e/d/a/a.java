package d.e.d.a;

import java.util.HashMap;
/* compiled from: ISNEventParams.java */
/* loaded from: classes2.dex */
public class a {
    private HashMap<String, Object> a = new HashMap<>();

    public a a(String str, Object obj) {
        if (obj != null) {
            this.a.put(str, com.ironsource.sdk.utils.f.c(obj.toString()));
        }
        return this;
    }

    public HashMap<String, Object> b() {
        return this.a;
    }
}
