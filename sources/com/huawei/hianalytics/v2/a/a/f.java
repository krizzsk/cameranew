package com.huawei.hianalytics.v2.a.a;

import com.huawei.hianalytics.util.m;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {
    private String a;
    private g b;
    private h c;

    /* renamed from: d  reason: collision with root package name */
    private b f5130d;

    /* renamed from: e  reason: collision with root package name */
    private a[] f5131e;

    public f(String str) {
        this.a = str;
    }

    public void a(b bVar) {
        this.f5130d = bVar;
    }

    public void a(g gVar) {
        this.b = gVar;
    }

    public void a(h hVar) {
        this.c = hVar;
    }

    public void a(List<a> list) {
        this.f5131e = list == null ? null : (a[]) list.toArray(new a[list.size()]);
    }

    public a[] a() {
        a[] aVarArr = this.f5131e;
        if (aVarArr == null) {
            return new a[0];
        }
        a[] aVarArr2 = new a[aVarArr.length];
        System.arraycopy(aVarArr, 0, aVarArr2, 0, aVarArr.length);
        return aVarArr2;
    }

    public JSONObject b() {
        String str;
        b bVar;
        if (this.f5131e == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            int i2 = 0;
            if (this.b != null) {
                if (this.f5131e[0].d() != null) {
                    String d2 = this.f5131e[0].d();
                    StringBuffer stringBuffer = new StringBuffer("hmshi");
                    stringBuffer.append(d2);
                    stringBuffer.append("qrt");
                    this.b.b(stringBuffer.toString());
                }
                jSONObject.put("header", this.b.b());
            }
            if (this.c != null && (bVar = this.f5130d) != null) {
                JSONObject a = bVar.a();
                a.put("properties", this.c.a());
                jSONObject2.put("events_common", a);
            }
            JSONArray jSONArray = new JSONArray();
            while (true) {
                a[] aVarArr = this.f5131e;
                if (i2 >= aVarArr.length) {
                    break;
                }
                jSONArray.put(aVarArr[i2].a());
                i2++;
            }
            jSONObject2.put("events", jSONArray);
            byte[] a2 = m.a(jSONObject2.toString().getBytes("UTF-8"));
            byte[] c = com.huawei.hianalytics.util.d.c();
            jSONObject.put("event", com.huawei.hianalytics.util.d.a(c, com.huawei.hianalytics.util.d.b(this.a, c, a2)));
        } catch (UnsupportedEncodingException unused) {
            str = "getBitZip(): UnsupportedEncodingException";
            com.huawei.hianalytics.b.b.c("UploadData", str);
            return jSONObject;
        } catch (JSONException unused2) {
            str = "toJsonObj(): JSONException";
            com.huawei.hianalytics.b.b.c("UploadData", str);
            return jSONObject;
        }
        return jSONObject;
    }
}
