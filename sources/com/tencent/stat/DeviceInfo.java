package com.tencent.stat;

import com.tencent.stat.common.StatLogger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DeviceInfo {
    public static final int NEW_USER = 0;
    public static final int OLD_USER = 1;
    public static final String TAG_ANDROID_ID = "aid";
    public static final String TAG_FLAG = "__MTA_DEVICE_INFO__";
    public static final String TAG_IMEI = "ui";
    public static final String TAG_MAC = "mc";
    public static final String TAG_MID = "mid";
    public static final String TAG_TIMESTAMPS = "ts";
    public static final String TAG_VERSION = "ver";
    public static final int UPGRADE_USER = 2;

    /* renamed from: h  reason: collision with root package name */
    private static StatLogger f8218h = com.tencent.stat.common.k.b();
    private String a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f8219d;

    /* renamed from: e  reason: collision with root package name */
    private int f8220e;

    /* renamed from: f  reason: collision with root package name */
    private int f8221f;

    /* renamed from: g  reason: collision with root package name */
    private long f8222g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeviceInfo() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.f8219d = "0";
        this.f8221f = 0;
        this.f8222g = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeviceInfo(String str, String str2, int i2) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.f8219d = "0";
        this.f8221f = 0;
        this.f8222g = 0L;
        this.a = str;
        this.b = str2;
        this.f8220e = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DeviceInfo a(String str) {
        DeviceInfo deviceInfo = new DeviceInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(TAG_IMEI)) {
                deviceInfo.d(jSONObject.getString(TAG_IMEI));
            }
            if (!jSONObject.isNull(TAG_MAC)) {
                deviceInfo.e(jSONObject.getString(TAG_MAC));
            }
            if (!jSONObject.isNull(TAG_MID)) {
                deviceInfo.c(jSONObject.getString(TAG_MID));
            }
            if (!jSONObject.isNull(TAG_ANDROID_ID)) {
                deviceInfo.b(jSONObject.getString(TAG_ANDROID_ID));
            }
            if (!jSONObject.isNull(TAG_TIMESTAMPS)) {
                deviceInfo.a(jSONObject.getLong(TAG_TIMESTAMPS));
            }
            if (!jSONObject.isNull(TAG_VERSION)) {
                deviceInfo.a(jSONObject.getInt(TAG_VERSION));
            }
        } catch (JSONException e2) {
            f8218h.e((Exception) e2);
        }
        return deviceInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f8221f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(DeviceInfo deviceInfo) {
        if (deviceInfo == null) {
            return 1;
        }
        String mid = getMid();
        String mid2 = deviceInfo.getMid();
        if (mid == null || mid2 == null || !mid.equals(mid2)) {
            int a = a();
            int a2 = deviceInfo.a();
            if (a > a2) {
                return 1;
            }
            if (a == a2) {
                int i2 = (b() > deviceInfo.b() ? 1 : (b() == deviceInfo.b() ? 0 : -1));
                if (i2 > 0) {
                    return 1;
                }
                if (i2 == 0) {
                    return 0;
                }
            }
            return -1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i2) {
        this.f8221f = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j2) {
        this.f8222g = j2;
    }

    long b() {
        return this.f8222g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i2) {
        this.f8220e = i2;
    }

    void b(String str) {
        this.c = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.tencent.stat.common.k.a(jSONObject, TAG_IMEI, this.a);
            com.tencent.stat.common.k.a(jSONObject, TAG_MAC, this.b);
            com.tencent.stat.common.k.a(jSONObject, TAG_MID, this.f8219d);
            com.tencent.stat.common.k.a(jSONObject, TAG_ANDROID_ID, this.c);
            jSONObject.put(TAG_TIMESTAMPS, this.f8222g);
            jSONObject.put(TAG_VERSION, this.f8221f);
        } catch (JSONException e2) {
            f8218h.e((Exception) e2);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str) {
        this.f8219d = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str) {
        this.a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str) {
        this.b = str;
    }

    public String getImei() {
        return this.a;
    }

    public String getMac() {
        return this.b;
    }

    public String getMid() {
        return this.f8219d;
    }

    public int getUserType() {
        return this.f8220e;
    }

    public String toString() {
        return c().toString();
    }
}
