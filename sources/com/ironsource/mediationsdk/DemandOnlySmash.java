package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DemandOnlySmash {
    protected b a;
    protected com.ironsource.mediationsdk.model.a b;
    protected JSONObject c;

    /* renamed from: f  reason: collision with root package name */
    int f5402f;

    /* renamed from: j  reason: collision with root package name */
    protected String f5406j;

    /* renamed from: k  reason: collision with root package name */
    private final Object f5407k = new Object();

    /* renamed from: l  reason: collision with root package name */
    private final Object f5408l = new Object();

    /* renamed from: d  reason: collision with root package name */
    private SMASH_STATE f5400d = SMASH_STATE.NOT_LOADED;

    /* renamed from: e  reason: collision with root package name */
    private Timer f5401e = null;

    /* renamed from: g  reason: collision with root package name */
    protected String f5403g = "";

    /* renamed from: h  reason: collision with root package name */
    protected JSONObject f5404h = null;

    /* renamed from: i  reason: collision with root package name */
    protected List<String> f5405i = new ArrayList();

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public enum SMASH_STATE {
        NOT_LOADED,
        LOAD_IN_PROGRESS,
        LOADED,
        SHOW_IN_PROGRESS
    }

    public DemandOnlySmash(com.ironsource.mediationsdk.model.a aVar, b bVar) {
        this.b = aVar;
        this.a = bVar;
        this.c = aVar.b();
    }

    public boolean B() {
        return this.b.i();
    }

    public void C(String str) {
        this.f5403g = str;
    }

    public void D(String str) {
        this.f5406j = AuctionDataUtils.getInstance().l(str);
    }

    public void E(JSONObject jSONObject) {
        this.f5404h = jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(SMASH_STATE smash_state) {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.INTERNAL, "DemandOnlySmash " + this.b.e() + ": current state=" + this.f5400d + ", new state=" + smash_state, 0);
        synchronized (this.f5407k) {
            this.f5400d = smash_state;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(TimerTask timerTask) {
        synchronized (this.f5408l) {
            H();
            Timer timer = new Timer();
            this.f5401e = timer;
            timer.schedule(timerTask, this.f5402f * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H() {
        synchronized (this.f5408l) {
            Timer timer = this.f5401e;
            if (timer != null) {
                timer.cancel();
                this.f5401e = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SMASH_STATE b(SMASH_STATE[] smash_stateArr, SMASH_STATE smash_state) {
        SMASH_STATE smash_state2;
        synchronized (this.f5407k) {
            smash_state2 = this.f5400d;
            if (Arrays.asList(smash_stateArr).contains(this.f5400d)) {
                F(smash_state);
            }
        }
        return smash_state2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l(SMASH_STATE smash_state, SMASH_STATE smash_state2) {
        synchronized (this.f5407k) {
            if (this.f5400d == smash_state) {
                F(smash_state2);
                return true;
            }
            return false;
        }
    }

    public String m() {
        return this.b.e();
    }

    public int n() {
        return this.b.c();
    }

    public Map<String, Object> q() {
        HashMap hashMap = new HashMap();
        try {
            b bVar = this.a;
            hashMap.put("providerAdapterVersion", bVar != null ? bVar.getVersion() : "");
            b bVar2 = this.a;
            hashMap.put("providerSDKVersion", bVar2 != null ? bVar2.getCoreSDKVersion() : "");
            hashMap.put("spId", this.b.h());
            hashMap.put("provider", this.b.a());
            hashMap.put("isDemandOnly", 1);
            if (B()) {
                hashMap.put("programmatic", 1);
                hashMap.put("instanceType", 2);
                if (!TextUtils.isEmpty(this.f5403g)) {
                    hashMap.put("auctionId", this.f5403g);
                }
                JSONObject jSONObject = this.f5404h;
                if (jSONObject != null && jSONObject.length() > 0) {
                    hashMap.put("genericParams", this.f5404h);
                }
            } else {
                hashMap.put("programmatic", 0);
                hashMap.put("instanceType", 1);
            }
            if (!TextUtils.isEmpty(this.f5406j)) {
                hashMap.put("dynamicDemandSource", this.f5406j);
            }
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            i2.e(ironSourceTag, "getProviderEventData " + m() + ")", e2);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String r() {
        SMASH_STATE smash_state = this.f5400d;
        return smash_state == null ? "null" : smash_state.toString();
    }

    public String x() {
        return this.b.h();
    }
}
