package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.Timer;
/* loaded from: classes2.dex */
public abstract class AbstractSmash {
    b b;
    com.ironsource.mediationsdk.model.l c;

    /* renamed from: d  reason: collision with root package name */
    String f5363d;

    /* renamed from: e  reason: collision with root package name */
    String f5364e;

    /* renamed from: f  reason: collision with root package name */
    boolean f5365f;

    /* renamed from: g  reason: collision with root package name */
    String f5366g;

    /* renamed from: h  reason: collision with root package name */
    String f5367h;

    /* renamed from: k  reason: collision with root package name */
    Timer f5370k;

    /* renamed from: l  reason: collision with root package name */
    Timer f5371l;
    int m;
    int n;
    int o;
    int p;

    /* renamed from: j  reason: collision with root package name */
    int f5369j = 0;

    /* renamed from: i  reason: collision with root package name */
    int f5368i = 0;
    MEDIATION_STATE a = MEDIATION_STATE.NOT_INITIATED;
    com.ironsource.mediationsdk.logger.c r = com.ironsource.mediationsdk.logger.c.i();
    protected Long q = null;

    /* loaded from: classes2.dex */
    public enum MEDIATION_STATE {
        NOT_INITIATED(0),
        INIT_FAILED(1),
        INITIATED(2),
        AVAILABLE(3),
        NOT_AVAILABLE(4),
        EXHAUSTED(5),
        CAPPED_PER_SESSION(6),
        INIT_PENDING(7),
        LOAD_PENDING(8),
        CAPPED_PER_DAY(9),
        NEEDS_RELOAD(10);
        
        private int mValue;

        MEDIATION_STATE(int i2) {
            this.mValue = i2;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractSmash(com.ironsource.mediationsdk.model.l lVar) {
        this.f5363d = lVar.m();
        this.f5364e = lVar.k();
        this.f5365f = lVar.t();
        this.c = lVar;
        this.f5366g = lVar.p();
        this.f5367h = lVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int B() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int C() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MEDIATION_STATE D() {
        return this.a;
    }

    public String E() {
        if (this.f5365f) {
            return this.f5363d;
        }
        return this.f5364e;
    }

    public int F() {
        return this.p;
    }

    public String G() {
        return this.f5366g;
    }

    boolean H() {
        return this.a == MEDIATION_STATE.CAPPED_PER_DAY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean I() {
        return this.f5368i >= this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean J() {
        return this.f5369j >= this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean K() {
        return (J() || I() || H()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(String str, String str2) {
        com.ironsource.mediationsdk.logger.c cVar = this.r;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        cVar.d(ironSourceTag, str + " exception: " + r() + " | " + str2, 3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M() {
        this.f5369j++;
        this.f5368i++;
        if (I()) {
            P(MEDIATION_STATE.CAPPED_PER_SESSION);
        } else if (J()) {
            P(MEDIATION_STATE.EXHAUSTED);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(b bVar) {
        this.b = bVar;
    }

    public void O(String str) {
        if (this.b != null) {
            com.ironsource.mediationsdk.logger.c cVar = this.r;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
            cVar.d(ironSourceTag, E() + ":setMediationSegment(segment:" + str + ")", 1);
            this.b.setMediationSegment(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void P(MEDIATION_STATE mediation_state) {
        if (this.a == mediation_state) {
            return;
        }
        this.a = mediation_state;
        com.ironsource.mediationsdk.logger.c cVar = this.r;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        cVar.d(ironSourceTag, "Smart Loading - " + r() + " state changed to " + mediation_state.toString(), 0);
        b bVar = this.b;
        if (bVar != null && (mediation_state == MEDIATION_STATE.CAPPED_PER_SESSION || mediation_state == MEDIATION_STATE.CAPPED_PER_DAY)) {
            bVar.setMediationState(mediation_state, n());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(String str, String str2) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.setPluginData(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(int i2) {
        this.p = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S() {
        try {
            try {
                Timer timer = this.f5370k;
                if (timer != null) {
                    timer.cancel();
                }
            } catch (Exception e2) {
                L("stopInitTimer", e2.getLocalizedMessage());
            }
        } finally {
            this.f5370k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T() {
        try {
            try {
                Timer timer = this.f5371l;
                if (timer != null) {
                    timer.cancel();
                }
            } catch (Exception e2) {
                L("stopLoadTimer", e2.getLocalizedMessage());
            }
        } finally {
            this.f5371l = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b();

    public Long l() {
        return this.q;
    }

    public String m() {
        if (!TextUtils.isEmpty(this.f5367h)) {
            return this.f5367h;
        }
        return E();
    }

    protected abstract String n();

    public b q() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String r() {
        return this.f5364e;
    }

    public int x() {
        return this.o;
    }
}
