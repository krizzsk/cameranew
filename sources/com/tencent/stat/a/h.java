package com.tencent.stat.a;

import android.content.Context;
import com.tencent.stat.StatAppMonitor;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends e {

    /* renamed from: l  reason: collision with root package name */
    private static String f8269l;
    private static String m;
    private StatAppMonitor a;

    public h(Context context, int i2, StatAppMonitor statAppMonitor) {
        super(context, i2);
        this.a = null;
        this.a = statAppMonitor.m38clone();
    }

    @Override // com.tencent.stat.a.e
    public f a() {
        return f.MONITOR_STAT;
    }

    @Override // com.tencent.stat.a.e
    public boolean a(JSONObject jSONObject) {
        StatAppMonitor statAppMonitor = this.a;
        if (statAppMonitor == null) {
            return false;
        }
        jSONObject.put("na", statAppMonitor.getInterfaceName());
        jSONObject.put("rq", this.a.getReqSize());
        jSONObject.put("rp", this.a.getRespSize());
        jSONObject.put("rt", this.a.getResultType());
        jSONObject.put("tm", this.a.getMillisecondsConsume());
        jSONObject.put("rc", this.a.getReturnCode());
        jSONObject.put("sp", this.a.getSampling());
        if (m == null) {
            m = com.tencent.stat.common.k.r(this.f8261k);
        }
        com.tencent.stat.common.k.a(jSONObject, "av", m);
        if (f8269l == null) {
            f8269l = com.tencent.stat.common.k.m(this.f8261k);
        }
        com.tencent.stat.common.k.a(jSONObject, "op", f8269l);
        jSONObject.put("cn", com.tencent.stat.common.k.p(this.f8261k));
        return true;
    }
}
