package com.tencent.stat.a;

import android.content.Context;
import com.tencent.stat.DeviceInfo;
import com.tencent.stat.StatConfig;
import com.tencent.stat.n;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class e {
    private static volatile boolean a = false;
    protected String b;

    /* renamed from: d  reason: collision with root package name */
    protected int f8254d;

    /* renamed from: e  reason: collision with root package name */
    protected DeviceInfo f8255e;

    /* renamed from: f  reason: collision with root package name */
    protected int f8256f;

    /* renamed from: g  reason: collision with root package name */
    protected String f8257g;

    /* renamed from: h  reason: collision with root package name */
    protected String f8258h;

    /* renamed from: i  reason: collision with root package name */
    protected String f8259i;

    /* renamed from: k  reason: collision with root package name */
    protected Context f8261k;

    /* renamed from: j  reason: collision with root package name */
    protected String f8260j = null;
    protected long c = System.currentTimeMillis() / 1000;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, int i2) {
        this.b = null;
        this.f8255e = null;
        this.f8257g = null;
        this.f8258h = null;
        this.f8259i = null;
        this.f8261k = context;
        this.f8254d = i2;
        this.b = StatConfig.getAppKey(context);
        this.f8257g = StatConfig.getCustomUserId(context);
        this.f8255e = n.a(context).b(context);
        this.f8256f = com.tencent.stat.common.k.w(context).intValue();
        this.f8259i = com.tencent.stat.common.k.n(context);
        this.f8258h = StatConfig.getInstallChannel(context);
    }

    public abstract f a();

    public abstract boolean a(JSONObject jSONObject);

    public long b() {
        return this.c;
    }

    public boolean b(JSONObject jSONObject) {
        try {
            com.tencent.stat.common.k.a(jSONObject, "ky", this.b);
            jSONObject.put("et", a().a());
            DeviceInfo deviceInfo = this.f8255e;
            if (deviceInfo != null) {
                jSONObject.put(DeviceInfo.TAG_IMEI, deviceInfo.getImei());
                com.tencent.stat.common.k.a(jSONObject, DeviceInfo.TAG_MAC, this.f8255e.getMac());
                jSONObject.put("ut", this.f8255e.getUserType());
            }
            com.tencent.stat.common.k.a(jSONObject, "cui", this.f8257g);
            if (a() != f.SESSION_ENV) {
                com.tencent.stat.common.k.a(jSONObject, "av", this.f8259i);
                com.tencent.stat.common.k.a(jSONObject, "ch", this.f8258h);
            }
            com.tencent.stat.common.k.a(jSONObject, DeviceInfo.TAG_MID, StatConfig.getMid(this.f8261k));
            jSONObject.put("idx", this.f8256f);
            jSONObject.put("si", this.f8254d);
            jSONObject.put(DeviceInfo.TAG_TIMESTAMPS, this.c);
            if (this.f8255e.getUserType() == 0 && com.tencent.stat.common.k.E(this.f8261k) == 1) {
                jSONObject.put("ia", 1);
            }
            return a(jSONObject);
        } catch (Throwable unused) {
            return false;
        }
    }

    public Context c() {
        return this.f8261k;
    }

    public String d() {
        try {
            JSONObject jSONObject = new JSONObject();
            b(jSONObject);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
