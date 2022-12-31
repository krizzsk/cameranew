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
public class LWSProgRvSmash extends c0 implements com.ironsource.mediationsdk.n0.u {

    /* renamed from: g  reason: collision with root package name */
    private SMASH_STATE f5431g;

    /* renamed from: h  reason: collision with root package name */
    private w f5432h;

    /* renamed from: i  reason: collision with root package name */
    private Timer f5433i;

    /* renamed from: j  reason: collision with root package name */
    private int f5434j;

    /* renamed from: k  reason: collision with root package name */
    private String f5435k;

    /* renamed from: l  reason: collision with root package name */
    private String f5436l;
    private com.ironsource.mediationsdk.model.o m;
    private long n;
    private String o;
    private JSONObject p;
    private int q;
    private String r;
    private final Object s;
    private final Object t;
    private long u;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public enum SMASH_STATE {
        NO_INIT,
        INIT_IN_PROGRESS,
        NOT_LOADED,
        LOAD_IN_PROGRESS,
        LOADED,
        SHOW_IN_PROGRESS,
        ENDED
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
            SMASH_STATE smash_state = LWSProgRvSmash.this.f5431g;
            SMASH_STATE smash_state2 = SMASH_STATE.LOAD_IN_PROGRESS;
            String str = "Rewarded Video - load instance time out";
            if (smash_state == smash_state2 || LWSProgRvSmash.this.f5431g == SMASH_STATE.INIT_IN_PROGRESS) {
                if (LWSProgRvSmash.this.f5431g == smash_state2) {
                    i2 = InputDeviceCompat.SOURCE_GAMEPAD;
                } else {
                    i2 = 1032;
                    str = "Rewarded Video - init instance time out";
                }
                LWSProgRvSmash.this.l0(SMASH_STATE.NOT_LOADED);
                z = true;
            } else {
                i2 = TypedValues.PositionType.TYPE_POSITION_TYPE;
                z = false;
            }
            LWSProgRvSmash.this.d0(str);
            if (z) {
                LWSProgRvSmash.this.g0(1200, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i2)}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(LWSProgRvSmash.this.V())}});
                LWSProgRvSmash.this.g0(1212, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i2)}, new Object[]{"reason", str}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(LWSProgRvSmash.this.V())}});
                LWSProgRvSmash.this.f5432h.e(LWSProgRvSmash.this);
                return;
            }
            LWSProgRvSmash.this.g0(1208, new Object[][]{new Object[]{"errorCode", Integer.valueOf((int) InputDeviceCompat.SOURCE_GAMEPAD)}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(LWSProgRvSmash.this.V())}, new Object[]{"ext1", LWSProgRvSmash.this.f5431g.name()}});
        }
    }

    public LWSProgRvSmash(String str, String str2, com.ironsource.mediationsdk.model.l lVar, w wVar, int i2, b bVar, int i3) {
        super(new com.ironsource.mediationsdk.model.a(lVar, lVar.o()), bVar);
        this.s = new Object();
        this.t = new Object();
        this.f5435k = str;
        this.f5436l = str2;
        this.f5432h = wVar;
        this.f5433i = null;
        this.f5434j = i2;
        this.a.updateRewardedVideoListener(this);
        this.f5540f = i3;
        this.f5431g = SMASH_STATE.NO_INIT;
        this.u = 0L;
        if (this.b.i()) {
            X();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long V() {
        return new Date().getTime() - this.n;
    }

    private void X() {
        d0("initForBidding()");
        l0(SMASH_STATE.INIT_IN_PROGRESS);
        k0();
        try {
            this.a.initRewardedVideoForBidding(this.f5435k, this.f5436l, this.f5538d, this);
        } catch (Throwable th) {
            e0("initForBidding exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            t(new com.ironsource.mediationsdk.logger.b(1040, th.getLocalizedMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(String str) {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.INTERNAL, "LWSProgRvSmash " + x() + " " + hashCode() + "  : " + str, 0);
    }

    private void e0(String str) {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.INTERNAL, "LWSProgRvSmash " + x() + " " + hashCode() + " : " + str, 3);
    }

    private void f0(int i2) {
        h0(i2, null, false);
    }

    private void h0(int i2, Object[][] objArr, boolean z) {
        com.ironsource.mediationsdk.model.o oVar;
        Map<String, Object> J = J();
        if (!TextUtils.isEmpty(this.o)) {
            J.put("auctionId", this.o);
        }
        JSONObject jSONObject = this.p;
        if (jSONObject != null && jSONObject.length() > 0) {
            J.put("genericParams", this.p);
        }
        if (z && (oVar = this.m) != null && !TextUtils.isEmpty(oVar.c())) {
            J.put("placement", this.m.c());
        }
        if (m0(i2)) {
            RewardedVideoEventsManager.getInstance().W(J, this.q, this.r);
        }
        J.put("sessionDepth", Integer.valueOf(this.f5540f));
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    J.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.INTERNAL, x() + " smash: RV sendProviderEvent " + Log.getStackTraceString(e2), 3);
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
            d0("setCustomParams() " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(SMASH_STATE smash_state) {
        d0("current state=" + this.f5431g + ", new state=" + smash_state);
        synchronized (this.s) {
            this.f5431g = smash_state;
        }
    }

    private boolean m0(int i2) {
        return i2 == 1001 || i2 == 1002 || i2 == 1200 || i2 == 1212 || i2 == 1213 || i2 == 1005 || i2 == 1203 || i2 == 1201 || i2 == 1202 || i2 == 1006 || i2 == 1010;
    }

    private void n0() {
        synchronized (this.t) {
            Timer timer = new Timer();
            this.f5433i = timer;
            timer.schedule(new a(), this.f5434j * 1000);
        }
    }

    private void o0() {
        synchronized (this.t) {
            Timer timer = this.f5433i;
            if (timer != null) {
                timer.cancel();
                this.f5433i = null;
            }
        }
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void A() {
    }

    @Override // com.ironsource.mediationsdk.c0
    public int I() {
        return 2;
    }

    public String T() {
        return this.o;
    }

    public Map<String, Object> U() {
        try {
            if (L()) {
                return this.a.getRewardedVideoBiddingData(this.f5538d);
            }
            return null;
        } catch (Throwable th) {
            e0("getBiddingData exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            g0(81316, new Object[][]{new Object[]{"errorCode", 5001}, new Object[]{"reason", th.getLocalizedMessage()}});
            return null;
        }
    }

    public LoadWhileShowSupportState W() {
        return this.a.getLoadWhileShowSupportState(this.f5538d);
    }

    public boolean Y() {
        return this.f5431g == SMASH_STATE.LOADED;
    }

    public boolean Z() {
        SMASH_STATE smash_state = this.f5431g;
        return smash_state == SMASH_STATE.INIT_IN_PROGRESS || smash_state == SMASH_STATE.LOAD_IN_PROGRESS;
    }

    public boolean a0() {
        try {
            if (L()) {
                return this.f5431g == SMASH_STATE.LOADED && b0();
            }
            return b0();
        } catch (Throwable th) {
            e0("isReadyToShow exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            g0(81316, new Object[][]{new Object[]{"errorCode", 5002}, new Object[]{"reason", th.getLocalizedMessage()}});
            return false;
        }
    }

    public boolean b0() {
        return this.a.isRewardedVideoAvailable(this.f5538d);
    }

    public void c0(String str) {
        SMASH_STATE smash_state;
        SMASH_STATE smash_state2;
        d0("loadVideo() auctionId: " + this.o + " state: " + this.f5431g);
        N(false);
        synchronized (this.s) {
            smash_state = this.f5431g;
            smash_state2 = SMASH_STATE.LOAD_IN_PROGRESS;
            if (smash_state != smash_state2 && smash_state != SMASH_STATE.SHOW_IN_PROGRESS) {
                l0(smash_state2);
            }
        }
        if (smash_state == smash_state2) {
            g0(81316, new Object[][]{new Object[]{"errorCode", 5003}, new Object[]{"reason", "load during load"}});
        } else if (smash_state == SMASH_STATE.SHOW_IN_PROGRESS) {
            g0(81316, new Object[][]{new Object[]{"errorCode", 5004}, new Object[]{"reason", "load during show"}});
        } else {
            n0();
            this.n = new Date().getTime();
            f0(1001);
            try {
                if (L()) {
                    this.a.loadRewardedVideoForBidding(this.f5538d, this, str);
                    return;
                }
                k0();
                this.a.initRewardedVideo(this.f5435k, this.f5436l, this.f5538d, this);
            } catch (Throwable th) {
                e0("loadVideo exception: " + th.getLocalizedMessage());
                th.printStackTrace();
                g0(81316, new Object[][]{new Object[]{"errorCode", 5005}, new Object[]{"reason", th.getLocalizedMessage()}});
            }
        }
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void d() {
        d0("onRewardedVideoAdEnded");
        this.f5432h.B(this);
        i0(1205);
    }

    public void g0(int i2, Object[][] objArr) {
        h0(i2, objArr, false);
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void i(boolean z) {
        boolean z2;
        d0("onRewardedVideoAvailabilityChanged available=" + z + " state=" + this.f5431g.name());
        synchronized (this.s) {
            if (this.f5431g == SMASH_STATE.LOAD_IN_PROGRESS) {
                l0(z ? SMASH_STATE.LOADED : SMASH_STATE.NOT_LOADED);
                z2 = false;
            } else {
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                g0(1207, new Object[][]{new Object[]{"ext1", this.f5431g.name()}});
                return;
            } else {
                g0(1208, new Object[][]{new Object[]{"errorCode", 1034}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(V())}, new Object[]{"ext1", this.f5431g.name()}});
                return;
            }
        }
        o0();
        g0(z ? 1002 : 1200, new Object[][]{new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(V())}});
        if (z) {
            this.f5432h.z(this);
        } else {
            this.f5432h.e(this);
        }
    }

    public void j0(int i2, Object[][] objArr) {
        h0(i2, objArr, true);
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void k(com.ironsource.mediationsdk.logger.b bVar) {
        d0("onRewardedVideoAdShowFailed error=" + bVar.b());
        j0(1202, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}});
        synchronized (this.s) {
            if (this.f5431g == SMASH_STATE.SHOW_IN_PROGRESS) {
                l0(SMASH_STATE.ENDED);
                this.f5432h.s(bVar, this);
                return;
            }
            g0(81316, new Object[][]{new Object[]{"errorCode", 5006}, new Object[]{"reason", "showFailed: " + this.f5431g}});
        }
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void o() {
        d0("onRewardedVideoAdStarted");
        this.f5432h.b(this);
        i0(1204);
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void onRewardedVideoAdClosed() {
        d0("onRewardedVideoAdClosed");
        synchronized (this.s) {
            if (this.f5431g != SMASH_STATE.SHOW_IN_PROGRESS) {
                i0(1203);
                g0(81316, new Object[][]{new Object[]{"errorCode", 5009}, new Object[]{"reason", "adClosed: " + this.f5431g}});
                return;
            }
            l0(SMASH_STATE.ENDED);
            this.u = new Date().getTime();
            this.f5432h.w(this);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void onRewardedVideoAdOpened() {
        d0("onRewardedVideoAdOpened");
        this.f5432h.x(this);
        i0(CloseFrame.NOCODE);
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void s(com.ironsource.mediationsdk.logger.b bVar) {
        if (bVar.a() == 1058) {
            g0(1213, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(V())}});
            return;
        }
        if (bVar.a() == 1057) {
            System.currentTimeMillis();
        }
        g0(1212, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(V())}});
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void t(com.ironsource.mediationsdk.logger.b bVar) {
        d0("onRewardedVideoInitFailed error=" + bVar.b());
        o0();
        g0(1200, new Object[][]{new Object[]{"errorCode", 1033}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(V())}});
        g0(1212, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}, new Object[]{TypedValues.TransitionType.S_DURATION, Long.valueOf(V())}});
        synchronized (this.s) {
            if (this.f5431g == SMASH_STATE.INIT_IN_PROGRESS) {
                l0(SMASH_STATE.NO_INIT);
                this.f5432h.e(this);
                return;
            }
            g0(81316, new Object[][]{new Object[]{"errorCode", 5008}, new Object[]{"reason", "initFailed: " + this.f5431g}});
        }
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void u() {
        d0("onRewardedVideoAdVisible");
        i0(1206);
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void v() {
        d0("onRewardedVideoAdClicked");
        this.f5432h.t(this, this.m);
        i0(1006);
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void y() {
        d0("onRewardedVideoAdRewarded");
        long time = new Date().getTime();
        this.f5432h.v(this, this.m);
        Map<String, Object> J = J();
        com.ironsource.mediationsdk.model.o oVar = this.m;
        if (oVar != null) {
            J.put("placement", oVar.c());
            J.put("rewardName", this.m.e());
            J.put("rewardAmount", Integer.valueOf(this.m.d()));
        }
        if (!TextUtils.isEmpty(IronSourceObject.getInstance().q())) {
            J.put("dynamicUserId", IronSourceObject.getInstance().q());
        }
        if (IronSourceObject.getInstance().z() != null) {
            for (String str : IronSourceObject.getInstance().z().keySet()) {
                J.put("custom_" + str, IronSourceObject.getInstance().z().get(str));
            }
        }
        if (!TextUtils.isEmpty(this.o)) {
            J.put("auctionId", this.o);
        }
        JSONObject jSONObject = this.p;
        if (jSONObject != null && jSONObject.length() > 0) {
            J.put("genericParams", this.p);
        }
        if (m0(1010)) {
            RewardedVideoEventsManager.getInstance().W(J, this.q, this.r);
        }
        J.put("sessionDepth", Integer.valueOf(this.f5540f));
        d.e.b.b bVar = new d.e.b.b(1010, new JSONObject(J));
        bVar.a("transId", IronSourceUtils.O("" + Long.toString(bVar.e()) + this.f5435k + x()));
        long j2 = this.u;
        if (j2 != 0) {
            long j3 = time - j2;
            d0("onRewardedVideoAdRewarded timeAfterClosed=" + j3);
            bVar.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(j3));
        }
        RewardedVideoEventsManager.getInstance().P(bVar);
    }

    @Override // com.ironsource.mediationsdk.n0.u
    public void z() {
        d0("onRewardedVideoInitSuccess");
        synchronized (this.s) {
            if (this.f5431g == SMASH_STATE.INIT_IN_PROGRESS) {
                l0(SMASH_STATE.NOT_LOADED);
                return;
            }
            g0(81316, new Object[][]{new Object[]{"errorCode", 5007}, new Object[]{"reason", "initSuccess: " + this.f5431g}});
        }
    }

    public LWSProgRvSmash(LWSProgRvSmash lWSProgRvSmash, w wVar, b bVar, int i2, String str, JSONObject jSONObject, int i3, String str2) {
        this(lWSProgRvSmash.f5435k, lWSProgRvSmash.f5436l, lWSProgRvSmash.b.g(), wVar, lWSProgRvSmash.f5434j, bVar, i2);
        this.o = str;
        this.p = jSONObject;
        this.q = i3;
        this.r = str2;
    }
}
