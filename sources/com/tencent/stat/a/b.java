package com.tencent.stat.a;

import android.content.Context;
import java.util.Map;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends e {
    protected c a;

    /* renamed from: l  reason: collision with root package name */
    private long f8252l;

    public b(Context context, int i2, String str) {
        super(context, i2);
        c cVar = new c();
        this.a = cVar;
        this.f8252l = -1L;
        cVar.a = str;
    }

    @Override // com.tencent.stat.a.e
    public f a() {
        return f.CUSTOM;
    }

    public void a(long j2) {
        this.f8252l = j2;
    }

    public void a(Properties properties) {
        if (properties != null) {
            this.a.c = (Properties) properties.clone();
        }
    }

    public void a(String[] strArr) {
        if (strArr != null) {
            this.a.b = (String[]) strArr.clone();
        }
    }

    @Override // com.tencent.stat.a.e
    public boolean a(JSONObject jSONObject) {
        jSONObject.put("ei", this.a.a);
        long j2 = this.f8252l;
        if (j2 > 0) {
            jSONObject.put("du", j2);
        }
        c cVar = this.a;
        if (cVar.c == null && cVar.b == null) {
            jSONObject.put("kv", new JSONObject());
        }
        if (this.a.b != null) {
            JSONArray jSONArray = new JSONArray();
            for (String str : this.a.b) {
                jSONArray.put(str);
            }
            jSONObject.put("ar", jSONArray);
        }
        if (this.a.c != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                for (Map.Entry entry : this.a.c.entrySet()) {
                    jSONObject2.put(entry.getKey().toString(), entry.getValue().toString());
                }
            } catch (Exception unused) {
                jSONObject2 = new JSONObject(this.a.c);
            }
            jSONObject.put("kv", jSONObject2);
            return true;
        }
        return true;
    }
}
