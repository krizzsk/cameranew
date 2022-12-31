package com.bytedance.sdk.openadsdk.core.d;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: TempPkgModel.java */
/* loaded from: classes.dex */
public class k {
    private String a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private List<a> f1611d;

    /* compiled from: TempPkgModel.java */
    /* loaded from: classes.dex */
    public static class a {
        private String a;
        private String b;
        private int c;

        public String a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }

        public int c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                String str = this.a;
                return str != null && str.equals(((a) obj).a());
            }
            return super.equals(obj);
        }

        public int hashCode() {
            int i2 = this.c;
            String str = this.a;
            if (str != null) {
                i2 = (i2 * 31) + str.hashCode();
            }
            String str2 = this.b;
            return str2 != null ? (i2 * 31) + str2.hashCode() : i2;
        }

        public void a(String str) {
            this.a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public void a(int i2) {
            this.c = i2;
        }
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public List<a> d() {
        if (this.f1611d == null) {
            this.f1611d = new ArrayList();
        }
        return this.f1611d;
    }

    public boolean e() {
        return (c() == null || b() == null || a() == null) ? false : true;
    }

    public String f() {
        if (e()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("name", a());
                jSONObject.putOpt("version", b());
                jSONObject.putOpt("main", c());
                JSONArray jSONArray = new JSONArray();
                if (d() != null) {
                    for (a aVar : d()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("url", aVar.a());
                        jSONObject2.putOpt("md5", aVar.b());
                        jSONObject2.putOpt("level", Integer.valueOf(aVar.c()));
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.putOpt("resources", jSONArray);
                return jSONObject.toString();
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public void a(String str) {
        this.a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public void a(List<a> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f1611d = list;
    }

    public static k a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            k kVar = new k();
            try {
                kVar.a(jSONObject.getString("name"));
                kVar.b(jSONObject.getString("version"));
                kVar.c(jSONObject.getString("main"));
                JSONArray jSONArray = jSONObject.getJSONArray("resources");
                ArrayList arrayList = new ArrayList();
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        a aVar = new a();
                        aVar.a(jSONObject2.getString("url"));
                        aVar.b(jSONObject2.getString("md5"));
                        aVar.a(jSONObject2.getInt("level"));
                        arrayList.add(aVar);
                    }
                }
                kVar.a(arrayList);
                if (!kVar.e()) {
                    return null;
                }
            } catch (Throwable unused) {
            }
            return kVar;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static k d(String str) {
        if (str == null) {
            return null;
        }
        try {
            return a(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }
}
