package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.InputDeviceCompat;
import com.growingio.android.sdk.java_websocket.framing.CloseFrame;
import com.ironsource.mediationsdk.events.RewardedVideoEventsManager;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.SessionDepthManager;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ProgRvSmash extends c0 implements com.ironsource.mediationsdk.n0.u {
    private String A;
    private final Object B;
    private final Object C;

    /* renamed from: g  reason: collision with root package name */
    private SMASH_STATE f5486g;

    /* renamed from: h  reason: collision with root package name */
    private b0 f5487h;

    /* renamed from: i  reason: collision with root package name */
    private Timer f5488i;

    /* renamed from: j  reason: collision with root package name */
    private int f5489j;

    /* renamed from: k  reason: collision with root package name */
    private String f5490k;

    /* renamed from: l  reason: collision with root package name */
    private String f5491l;
    private String m;
    private boolean n;
    private boolean o;
    private boolean p;
    private com.ironsource.mediationsdk.model.o q;
    private long r;
    private String s;
    private JSONObject t;
    private String u;
    private int v;
    private String w;
    private int x;
    private int y;
    private String z;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public enum SMASH_STATE {
        NO_INIT,
        INIT_IN_PROGRESS,
        NOT_LOADED,
        LOAD_IN_PROGRESS,
        LOADED,
        SHOW_IN_PROGRESS
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            int i2;
            boolean z;
            String str = "Rewarded Video - load instance time out";
            synchronized (ProgRvSmash.this.C) {
                SMASH_STATE smash_state = ProgRvSmash.this.f5486g;
                SMASH_STATE smash_state2 = SMASH_STATE.LOAD_IN_PROGRESS;
                if (smash_state != smash_state2 && ProgRvSmash.this.f5486g != SMASH_STATE.INIT_IN_PROGRESS) {
                    i2 = TypedValues.PositionType.TYPE_POSITION_TYPE;
                    z = false;
                }
                if (ProgRvSmash.this.f5486g == smash_state2) {
                    i2 = InputDeviceCompat.SOURCE_GAMEPAD;
                } else {
                    str = "Rewarded Video - init instance time out";
                    i2 = 1032;
                }
                ProgRvSmash.this.l0(SMASH_STATE.NOT_LOADED);
                z = true;
            }
            ProgRvSmash.this.c0(str);
            if (z) {
                ProgRvSmash.this.g0(1200, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i2)}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(ProgRvSmash.this.W())}});
                ProgRvSmash.this.g0(1212, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i2)}, new Object[]{"reason", str}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(ProgRvSmash.this.W())}});
                b0 b0Var = ProgRvSmash.this.f5487h;
                ProgRvSmash progRvSmash = ProgRvSmash.this;
                b0Var.J(progRvSmash, progRvSmash.s);
                return;
            }
            ProgRvSmash.this.g0(1208, new Object[][]{new Object[]{"errorCode", Integer.valueOf((int) InputDeviceCompat.SOURCE_GAMEPAD)}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(ProgRvSmash.this.W())}, new Object[]{"ext1", ProgRvSmash.this.f5486g.name()}});
        }
    }

    public ProgRvSmash(String str, String str2, com.ironsource.mediationsdk.model.l lVar, b0 b0Var, int i2, b bVar) {
        super(new com.ironsource.mediationsdk.model.a(lVar, lVar.o()), bVar);
        this.B = new Object();
        this.C = new Object();
        this.f5486g = SMASH_STATE.NO_INIT;
        this.f5490k = str;
        this.f5491l = str2;
        this.f5487h = b0Var;
        this.f5488i = null;
        this.f5489j = i2;
        this.a.addRewardedVideoListener(this);
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = null;
        this.s = "";
        this.t = null;
        this.f5540f = 1;
        e0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long W() {
        return new Date().getTime() - this.r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(String str) {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.INTERNAL, "ProgRvSmash " + x() + " : " + str, 0);
    }

    private void d0(String str) {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.INTERNAL, "ProgRvSmash " + x() + " : " + str, 3);
    }

    private void e0() {
        this.u = "";
        this.x = -1;
        this.A = "";
        this.m = "";
        this.y = this.f5540f;
        this.z = "";
    }

    private void f0(int i2) {
        h0(i2, null, false);
    }

    private void h0(int i2, Object[][] objArr, boolean z) {
        com.ironsource.mediationsdk.model.o oVar;
        Map<String, Object> J = J();
        if (!TextUtils.isEmpty(this.s)) {
            J.put("auctionId", this.s);
        }
        JSONObject jSONObject = this.t;
        if (jSONObject != null && jSONObject.length() > 0) {
            J.put("genericParams", this.t);
        }
        if (z && (oVar = this.q) != null && !TextUtils.isEmpty(oVar.c())) {
            J.put("placement", this.q.c());
        }
        if (m0(i2)) {
            RewardedVideoEventsManager.getInstance().W(J, this.v, this.w);
        }
        J.put("sessionDepth", Integer.valueOf(this.f5540f));
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    J.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.INTERNAL, x() + " smash: RV sendMediationEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        RewardedVideoEventsManager.getInstance().P(new d.e.b.b(i2, new JSONObject(J)));
        if (i2 == 1203) {
            SessionDepthManager.getInstance().d(1);
        }
    }

    private void i0(int i2) {
        j0(i2, null);
    }

    private void k0() {
        try {
            String w = IronSourceObject.getInstance().w();
            if (!TextUtils.isEmpty(w)) {
                this.a.setMediationSegment(w);
            }
            String c = com.ironsource.mediationsdk.k0.a.a().c();
            if (TextUtils.isEmpty(c)) {
                return;
            }
            this.a.setPluginData(c, com.ironsource.mediationsdk.k0.a.a().b());
        } catch (Exception e2) {
            c0("setCustomParams() " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(SMASH_STATE smash_state) {
        c0("current state=" + this.f5486g + ", new state=" + smash_state);
        synchronized (this.C) {
            this.f5486g = smash_state;
        }
    }

    private boolean m0(int i2) {
        return i2 == 1001 || i2 == 1002 || i2 == 1200 || i2 == 1213 || i2 == 1212 || i2 == 1005 || i2 == 1203 || i2 == 1201 || i2 == 1202 || i2 == 1006 || i2 == 1010;
    }

    private void n0() {
        synchronized (this.B) {
            o0();
            Timer timer = new Timer();
            this.f5488i = timer;
            timer.schedule(new a(), this.f5489j * 1000);
        }
    }

    private void o0() {
        synchronized (this.B) {
            Timer timer = this.f5488i;
            if (timer != null) {
                timer.cancel();
                this.f5488i = null;
            }
        }
    }

    private void q0(String str, String str2, int i2, String str3, int i3, String str4) {
        this.u = str2;
        this.m = str;
        this.x = i2;
        this.A = str3;
        this.y = i3;
        this.z = str4;
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void A() {
    }

    public Map<String, Object> V() {
        try {
            if (L()) {
                return this.a.getRewardedVideoBiddingData(this.f5538d);
            }
            return null;
        } catch (Throwable th) {
            d0("getBiddingData exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            g0(81316, new Object[][]{new Object[]{"errorCode", 5001}, new Object[]{"reason", th.getLocalizedMessage()}});
            return null;
        }
    }

    public void X() {
        c0("initForBidding()");
        l0(SMASH_STATE.INIT_IN_PROGRESS);
        k0();
        try {
            this.a.initRewardedVideoForBidding(this.f5490k, this.f5491l, this.f5538d, this);
        } catch (Throwable th) {
            d0("initForBidding exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            t(new com.ironsource.mediationsdk.logger.b(1040, th.getLocalizedMessage()));
        }
    }

    public boolean Y() {
        SMASH_STATE smash_state = this.f5486g;
        return smash_state == SMASH_STATE.INIT_IN_PROGRESS || smash_state == SMASH_STATE.LOAD_IN_PROGRESS;
    }

    public boolean Z() {
        try {
            if (L()) {
                return this.p && this.f5486g == SMASH_STATE.LOADED && a0();
            }
            return a0();
        } catch (Throwable th) {
            d0("isReadyToShow exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            g0(81316, new Object[][]{new Object[]{"errorCode", 5002}, new Object[]{"reason", th.getLocalizedMessage()}});
            return false;
        }
    }

    public boolean a0() {
        return this.a.isRewardedVideoAvailable(this.f5538d);
    }

    public void b0(String str, String str2, JSONObject jSONObject, int i2, String str3, int i3, String str4) {
        SMASH_STATE smash_state;
        SMASH_STATE smash_state2;
        c0("loadVideo() auctionId: " + str2 + " state: " + this.f5486g);
        N(false);
        this.p = true;
        synchronized (this.C) {
            smash_state = this.f5486g;
            smash_state2 = SMASH_STATE.LOAD_IN_PROGRESS;
            if (smash_state != smash_state2 && smash_state != SMASH_STATE.SHOW_IN_PROGRESS) {
                l0(smash_state2);
            }
        }
        if (smash_state == smash_state2) {
            g0(81316, new Object[][]{new Object[]{"errorCode", 5003}, new Object[]{"reason", "load during load"}});
            this.o = true;
            q0(str, str2, i2, str3, i3, str4);
            this.f5487h.J(this, str2);
        } else if (smash_state == SMASH_STATE.SHOW_IN_PROGRESS) {
            g0(81316, new Object[][]{new Object[]{"errorCode", 5004}, new Object[]{"reason", "load during show"}});
            this.n = true;
            q0(str, str2, i2, str3, i3, str4);
        } else {
            this.f5539e = str4;
            this.s = str2;
            this.t = jSONObject;
            this.v = i2;
            this.w = str3;
            this.f5540f = i3;
            n0();
            this.r = new Date().getTime();
            f0(1001);
            try {
                if (L()) {
                    this.a.loadRewardedVideoForBidding(this.f5538d, this, str);
                } else if (smash_state == SMASH_STATE.NO_INIT) {
                    k0();
                    this.a.initRewardedVideo(this.f5490k, this.f5491l, this.f5538d, this);
                } else {
                    this.a.fetchRewardedVideoForAutomaticLoad(this.f5538d, this);
                }
            } catch (Throwable th) {
                d0("loadRewardedVideoForBidding exception: " + th.getLocalizedMessage());
                th.printStackTrace();
                g0(81316, new Object[][]{new Object[]{"errorCode", 5005}, new Object[]{"reason", th.getLocalizedMessage()}});
            }
        }
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void d() {
        c0("onRewardedVideoAdEnded");
        this.f5487h.m(this);
        i0(1205);
    }

    public void g0(int i2, Object[][] objArr) {
        h0(i2, objArr, false);
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void i(boolean z) {
        boolean z2;
        c0("onRewardedVideoAvailabilityChanged available=" + z + " state=" + this.f5486g.name());
        synchronized (this.C) {
            if (this.f5486g == SMASH_STATE.LOAD_IN_PROGRESS) {
                l0(z ? SMASH_STATE.LOADED : SMASH_STATE.NOT_LOADED);
                z2 = false;
            } else {
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                g0(1207, new Object[][]{new Object[]{"ext1", this.f5486g.name()}});
                return;
            } else {
                g0(1208, new Object[][]{new Object[]{"errorCode", 1034}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(W())}, new Object[]{"ext1", this.f5486g.name()}});
                return;
            }
        }
        o0();
        g0(z ? 1002 : 1200, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(W())}});
        if (!this.o) {
            if (z) {
                this.f5487h.H(this, this.s);
                return;
            } else {
                this.f5487h.J(this, this.s);
                return;
            }
        }
        this.o = false;
        c0("onRewardedVideoAvailabilityChanged to " + z + "and mShouldLoadAfterLoad is true - calling loadVideo");
        b0(this.m, this.u, this.t, this.x, this.A, this.y, this.z);
        e0();
    }

    public void j0(int i2, Object[][] objArr) {
        h0(i2, objArr, true);
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void k(com.ironsource.mediationsdk.logger.b bVar) {
        c0("onRewardedVideoAdShowFailed error=" + bVar.b());
        j0(1202, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}});
        synchronized (this.C) {
            if (this.f5486g == SMASH_STATE.SHOW_IN_PROGRESS) {
                l0(SMASH_STATE.NOT_LOADED);
                this.f5487h.n(bVar, this);
                return;
            }
            g0(81316, new Object[][]{new Object[]{"errorCode", 5006}, new Object[]{"reason", "showFailed: " + this.f5486g}});
        }
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void o() {
        c0("onRewardedVideoAdStarted");
        this.f5487h.O(this);
        i0(1204);
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void onRewardedVideoAdClosed() {
        c0("onRewardedVideoAdClosed");
        synchronized (this.C) {
            if (this.f5486g != SMASH_STATE.SHOW_IN_PROGRESS) {
                i0(1203);
                g0(81316, new Object[][]{new Object[]{"errorCode", 5009}, new Object[]{"reason", "adClosed: " + this.f5486g}});
                return;
            }
            l0(SMASH_STATE.NOT_LOADED);
            this.f5487h.l(this);
            if (this.n) {
                c0("onRewardedVideoAdClosed and mShouldLoadAfterClose is true - calling loadRewardedVideoForBidding");
                this.n = false;
                b0(this.m, this.u, this.t, this.x, this.A, this.y, this.z);
                e0();
            }
        }
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void onRewardedVideoAdOpened() {
        c0("onRewardedVideoAdOpened");
        this.f5487h.k(this);
        i0(CloseFrame.NOCODE);
    }

    public void p0() {
        if (L()) {
            this.p = false;
        }
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void s(com.ironsource.mediationsdk.logger.b bVar) {
        if (bVar.a() == 1058) {
            g0(1213, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(W())}});
            return;
        }
        if (bVar.a() == 1057) {
            System.currentTimeMillis();
        }
        g0(1212, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(W())}});
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void t(com.ironsource.mediationsdk.logger.b bVar) {
        c0("onRewardedVideoInitFailed error=" + bVar.b());
        o0();
        g0(1200, new Object[][]{new Object[]{"errorCode", 1033}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(W())}});
        g0(1212, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(W())}});
        synchronized (this.C) {
            if (this.f5486g == SMASH_STATE.INIT_IN_PROGRESS) {
                l0(SMASH_STATE.NO_INIT);
                this.f5487h.J(this, this.s);
                return;
            }
            g0(81316, new Object[][]{new Object[]{"errorCode", 5008}, new Object[]{"reason", "initFailed: " + this.f5486g}});
        }
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void u() {
        c0("onRewardedVideoAdVisible");
        i0(1206);
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void v() {
        c0("onRewardedVideoAdClicked");
        this.f5487h.q(this, this.q);
        i0(1006);
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void y() {
        c0("onRewardedVideoAdRewarded");
        this.f5487h.h(this, this.q);
        Map<String, Object> J = J();
        com.ironsource.mediationsdk.model.o oVar = this.q;
        if (oVar != null) {
            J.put("placement", oVar.c());
            J.put("rewardName", this.q.e());
            J.put("rewardAmount", Integer.valueOf(this.q.d()));
        }
        if (!TextUtils.isEmpty(IronSourceObject.getInstance().q())) {
            J.put("dynamicUserId", IronSourceObject.getInstance().q());
        }
        if (IronSourceObject.getInstance().z() != null) {
            for (String str : IronSourceObject.getInstance().z().keySet()) {
                J.put("custom_" + str, IronSourceObject.getInstance().z().get(str));
            }
        }
        if (!TextUtils.isEmpty(this.s)) {
            J.put("auctionId", this.s);
        }
        JSONObject jSONObject = this.t;
        if (jSONObject != null && jSONObject.length() > 0) {
            J.put("genericParams", this.t);
        }
        if (m0(1010)) {
            RewardedVideoEventsManager.getInstance().W(J, this.v, this.w);
        }
        J.put("sessionDepth", Integer.valueOf(this.f5540f));
        d.e.b.b bVar = new d.e.b.b(1010, new JSONObject(J));
        bVar.a("transId", IronSourceUtils.O("" + Long.toString(bVar.e()) + this.f5490k + x()));
        RewardedVideoEventsManager.getInstance().P(bVar);
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void z() {
        c0("onRewardedVideoInitSuccess");
        synchronized (this.C) {
            if (this.f5486g == SMASH_STATE.INIT_IN_PROGRESS) {
                l0(SMASH_STATE.NOT_LOADED);
                return;
            }
            g0(81316, new Object[][]{new Object[]{"errorCode", 5007}, new Object[]{"reason", "initSuccess: " + this.f5486g}});
        }
    }
}
