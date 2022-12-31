package com.tencent.stat;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class NetworkMonitor {
    private long a = 0;
    private int b = 0;
    private String c = "";

    /* renamed from: d  reason: collision with root package name */
    private int f8223d = 0;

    /* renamed from: e  reason: collision with root package name */
    private String f8224e = "";

    public String getDomain() {
        return this.c;
    }

    public long getMillisecondsConsume() {
        return this.a;
    }

    public int getPort() {
        return this.f8223d;
    }

    public String getRemoteIp() {
        return this.f8224e;
    }

    public int getStatusCode() {
        return this.b;
    }

    public void setDomain(String str) {
        this.c = str;
    }

    public void setMillisecondsConsume(long j2) {
        this.a = j2;
    }

    public void setPort(int i2) {
        this.f8223d = i2;
    }

    public void setRemoteIp(String str) {
        this.f8224e = str;
    }

    public void setStatusCode(int i2) {
        this.b = i2;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tm", this.a);
            jSONObject.put("st", this.b);
            String str = this.c;
            if (str != null) {
                jSONObject.put("dm", str);
            }
            jSONObject.put("pt", this.f8223d);
            String str2 = this.f8224e;
            if (str2 != null) {
                jSONObject.put("rip", str2);
            }
            jSONObject.put(DeviceInfo.TAG_TIMESTAMPS, System.currentTimeMillis() / 1000);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
