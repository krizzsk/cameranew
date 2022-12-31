package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.utils.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* compiled from: ProgSmash.java */
/* loaded from: classes2.dex */
public abstract class c0 implements m.a {
    protected b a;
    protected com.ironsource.mediationsdk.model.a b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    protected JSONObject f5538d;

    /* renamed from: e  reason: collision with root package name */
    protected String f5539e;

    /* renamed from: f  reason: collision with root package name */
    protected int f5540f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(com.ironsource.mediationsdk.model.a aVar, b bVar) {
        this.b = aVar;
        this.a = bVar;
        this.f5538d = aVar.b();
    }

    @Override // com.ironsource.mediationsdk.utils.m.a
    public int B() {
        return this.b.d();
    }

    public String D() {
        return String.format("%s %s", G(), Integer.valueOf(hashCode()));
    }

    public int E() {
        return this.b.c();
    }

    public boolean F() {
        return this.c;
    }

    public String G() {
        if (this.b.g().t()) {
            return this.b.g().m();
        }
        return this.b.g().l();
    }

    public String H() {
        return this.b.f();
    }

    public int I() {
        return 1;
    }

    public Map<String, Object> J() {
        HashMap hashMap = new HashMap();
        try {
            b bVar = this.a;
            hashMap.put("providerAdapterVersion", bVar != null ? bVar.getVersion() : "");
            b bVar2 = this.a;
            hashMap.put("providerSDKVersion", bVar2 != null ? bVar2.getCoreSDKVersion() : "");
            hashMap.put("spId", this.b.h());
            hashMap.put("provider", this.b.a());
            hashMap.put("instanceType", Integer.valueOf(L() ? 2 : 1));
            hashMap.put("programmatic", Integer.valueOf(I()));
            if (!TextUtils.isEmpty(this.f5539e)) {
                hashMap.put("dynamicDemandSource", this.f5539e);
            }
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            i2.e(ironSourceTag, "getProviderEventData " + x() + ")", e2);
        }
        return hashMap;
    }

    public int K() {
        return this.f5540f;
    }

    public boolean L() {
        return this.b.i();
    }

    public void M(String str) {
        this.f5539e = AuctionDataUtils.getInstance().l(str);
    }

    public void N(boolean z) {
        this.c = z;
    }

    @Override // com.ironsource.mediationsdk.utils.m.a
    public String x() {
        return this.b.e();
    }
}
