package d.e.b;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: EventData.java */
/* loaded from: classes2.dex */
public class b {
    private int a;
    private long b;
    private JSONObject c;

    public b(int i2, long j2, JSONObject jSONObject) {
        this.a = -1;
        this.b = -1L;
        this.a = i2;
        this.b = j2;
        if (jSONObject == null) {
            this.c = new JSONObject();
        } else {
            this.c = jSONObject;
        }
    }

    public void a(String str, Object obj) {
        try {
            this.c.put(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public String b() {
        return this.c.toString();
    }

    public JSONObject c() {
        return this.c;
    }

    public int d() {
        return this.a;
    }

    public long e() {
        return this.b;
    }

    public void f(int i2) {
        this.a = i2;
    }

    public b(int i2, JSONObject jSONObject) {
        this.a = -1;
        this.b = -1L;
        this.a = i2;
        this.b = System.currentTimeMillis();
        if (jSONObject == null) {
            this.c = new JSONObject();
        } else {
            this.c = jSONObject;
        }
    }
}
