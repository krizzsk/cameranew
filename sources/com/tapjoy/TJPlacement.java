package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.internal.fn;
import com.tapjoy.internal.fq;
import com.tapjoy.internal.fw;
import com.tapjoy.internal.ge;
import com.tapjoy.internal.gf;
import com.tapjoy.internal.gs;
import com.tapjoy.internal.gv;
import com.tapjoy.internal.gz;
import com.tapjoy.internal.he;
import com.tapjoy.internal.hg;
import com.tapjoy.internal.jq;
import java.util.HashMap;
import java.util.UUID;
import us.pinguo.androidsdk.PGImageSDK;
/* loaded from: classes3.dex */
public class TJPlacement {
    TJPlacementListener a;
    private TJCorePlacement b;
    private TJPlacementListener c;

    /* renamed from: d  reason: collision with root package name */
    private TJPlacementVideoListener f7234d;

    /* renamed from: e  reason: collision with root package name */
    private String f7235e;
    public String pushId;

    @Deprecated
    public TJPlacement(Context context, String str, TJPlacementListener tJPlacementListener) {
        TJCorePlacement a = TJPlacementManager.a(str);
        a = a == null ? TJPlacementManager.a(str, "", "", false, false) : a;
        a.setContext(context);
        a(a, tJPlacementListener);
    }

    private void a(TJCorePlacement tJCorePlacement, TJPlacementListener tJPlacementListener) {
        this.b = tJCorePlacement;
        this.f7235e = UUID.randomUUID().toString();
        this.c = tJPlacementListener;
        this.a = tJPlacementListener != null ? (TJPlacementListener) fn.a(tJPlacementListener, TJPlacementListener.class) : null;
        FiveRocksIntegration.addPlacementCallback(getName(), this);
    }

    public static void dismissContent() {
        TJPlacementManager.dismissContentShowing("true".equals(TapjoyConnectCore.getConnectFlagValue("TJC_OPTION_DISMISS_CONTENT_ALL")));
    }

    public String getGUID() {
        return this.f7235e;
    }

    public TJPlacementListener getListener() {
        return this.c;
    }

    public String getName() {
        return this.b.getPlacementData() != null ? this.b.getPlacementData().getPlacementName() : "";
    }

    public TJPlacementVideoListener getVideoListener() {
        return this.f7234d;
    }

    public boolean isContentAvailable() {
        this.b.f7218f.a(1);
        return this.b.isContentAvailable();
    }

    public boolean isContentReady() {
        boolean isContentReady = this.b.isContentReady();
        fw fwVar = this.b.f7218f;
        if (isContentReady) {
            fwVar.a(4);
        } else {
            fwVar.a(2);
        }
        return isContentReady;
    }

    public boolean isLimited() {
        return this.b.isLimited();
    }

    public void requestContent() {
        boolean isLimitedConnected;
        String name = getName();
        TapjoyLog.i("TJPlacement", "requestContent() called for placement " + name);
        gf.a("TJPlacement.requestContent").a("placement", name).a("placement_type", this.b.c.getPlacementType());
        if (ge.a() != null && jq.c(ge.a().b)) {
            TapjoyLog.w("TJPlacement", "[INFO] Your application calls requestContent without having previously called setUserConsent. You can review Tapjoy supported consent API here - https://dev.tapjoy.com/sdk-integration/#sdk11122_gdpr_release.");
        }
        if (!isLimited()) {
            isLimitedConnected = TapjoyConnectCore.isConnected();
        } else {
            isLimitedConnected = TapjoyConnectCore.isLimitedConnected();
        }
        if (!isLimitedConnected) {
            gf.b("TJPlacement.requestContent").b("not connected").c();
            a(new TJError(0, "SDK not connected -- connect must be called first with a successful callback"));
        } else if (this.b.getContext() == null) {
            gf.b("TJPlacement.requestContent").b("no context").c();
            a(new TJError(0, "Context is null -- TJPlacement requires a valid Context."));
        } else if (jq.c(name)) {
            gf.b("TJPlacement.requestContent").b("invalid name").c();
            a(new TJError(0, "Invalid placement name -- TJPlacement requires a valid placement name."));
        } else {
            try {
                this.b.a(this);
            } finally {
                gf.d("TJPlacement.requestContent");
            }
        }
    }

    public void setAdapterVersion(String str) {
        this.b.n = str;
    }

    public void setAuctionData(HashMap hashMap) {
        if (hashMap != null && !hashMap.isEmpty()) {
            TJCorePlacement tJCorePlacement = this.b;
            tJCorePlacement.q = hashMap;
            String b = tJCorePlacement.b();
            if (!jq.c(b)) {
                tJCorePlacement.c.setAuctionMediationURL(TapjoyConnectCore.getPlacementURL() + "v1/apps/" + b + "/bid_content?");
                return;
            }
            TapjoyLog.i(TJCorePlacement.a, "Placement auction data can not be set for a null app ID");
            return;
        }
        TapjoyLog.d("TJPlacement", "auctionData can not be null or empty");
    }

    public void setMediationId(String str) {
        this.b.p = str;
    }

    public void setMediationName(String str) {
        TapjoyLog.d("TJPlacement", "setMediationName=" + str);
        if (jq.c(str)) {
            return;
        }
        TJCorePlacement tJCorePlacement = this.b;
        Context context = tJCorePlacement != null ? tJCorePlacement.getContext() : null;
        TJCorePlacement a = TJPlacementManager.a(getName(), str, "", false, isLimited());
        this.b = a;
        a.o = str;
        a.m = str;
        a.c.setPlacementType(str);
        String b = a.b();
        if (!jq.c(b)) {
            a.c.setMediationURL(TapjoyConnectCore.getPlacementURL() + "v1/apps/" + b + "/mediation_content?");
        } else {
            TapjoyLog.i(TJCorePlacement.a, "Placement mediation name can not be set for a null app ID");
        }
        if (context != null) {
            this.b.setContext(context);
        }
    }

    public void setVideoListener(TJPlacementVideoListener tJPlacementVideoListener) {
        this.f7234d = tJPlacementVideoListener;
    }

    public void showContent() {
        int i2;
        String name = getName();
        TapjoyLog.i("TJPlacement", "showContent() called for placement " + name);
        TJCorePlacement tJCorePlacement = this.b;
        gf.a("TJPlacement.showContent").a("placement", tJCorePlacement.c.getPlacementName()).a("placement_type", tJCorePlacement.c.getPlacementType()).a(FirebaseAnalytics.Param.CONTENT_TYPE, tJCorePlacement.a());
        fw fwVar = tJCorePlacement.f7218f;
        fwVar.a(8);
        fq fqVar = fwVar.a;
        if (fqVar != null) {
            fqVar.a();
        }
        if (!this.b.isContentAvailable()) {
            TapjoyLog.e("TJPlacement", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "No placement content available. Can not show content for non-200 placement."));
            gf.b("TJPlacement.showContent").b("no content").c();
            return;
        }
        try {
            final TJCorePlacement tJCorePlacement2 = this.b;
            if (TapjoyConnectCore.isFullScreenViewOpen()) {
                TapjoyLog.w(TJCorePlacement.a, "Only one view can be presented at a time.");
                gf.b("TJPlacement.showContent").b("another content showing").c();
            } else {
                if (TapjoyConnectCore.isViewOpen()) {
                    TapjoyLog.w(TJCorePlacement.a, "Will close N2E content.");
                    TJPlacementManager.dismissContentShowing(false);
                }
                tJCorePlacement2.a("SHOW", this);
                gf.a d2 = gf.d("TJPlacement.showContent");
                if (tJCorePlacement2.f7219g.isPrerendered()) {
                    d2.a("prerendered", Boolean.TRUE);
                }
                if (tJCorePlacement2.isContentReady()) {
                    d2.a("content_ready", Boolean.TRUE);
                }
                tJCorePlacement2.f7218f.f7546d = d2;
                final String uuid = UUID.randomUUID().toString();
                hg hgVar = tJCorePlacement2.f7221i;
                if (hgVar != null) {
                    hgVar.f7614f = uuid;
                    if (hgVar == null) {
                        i2 = 1;
                    } else if (hgVar instanceof gv) {
                        i2 = 3;
                    } else {
                        i2 = hgVar instanceof he ? 2 : 0;
                    }
                    TapjoyConnectCore.viewWillOpen(uuid, i2);
                    tJCorePlacement2.f7221i.f7613e = new gs() { // from class: com.tapjoy.TJCorePlacement.4
                        @Override // com.tapjoy.internal.gs
                        public final void a(Context context, String str, String str2) {
                            if (str2 == null) {
                                TJCorePlacement.this.c.setRedirectURL(str);
                            } else {
                                TJCorePlacement.this.c.setBaseURL(str);
                                TJCorePlacement.this.c.setHttpResponse(str2);
                            }
                            TJCorePlacement.this.c.setHasProgressSpinner(true);
                            TJCorePlacement.this.c.setContentViewId(uuid);
                            Intent intent = new Intent(TJCorePlacement.this.b, TJAdUnitActivity.class);
                            intent.putExtra(TJAdUnitConstants.EXTRA_TJ_PLACEMENT_DATA, TJCorePlacement.this.c);
                            intent.setFlags(PGImageSDK.SDK_STATUS_CREATE);
                            context.startActivity(intent);
                        }
                    };
                    gz.a(new Runnable() { // from class: com.tapjoy.TJCorePlacement.5
                        @Override // java.lang.Runnable
                        public final void run() {
                            TJCorePlacement.this.f7221i.a(gz.a().p, TJCorePlacement.this.f7218f);
                        }
                    });
                } else {
                    tJCorePlacement2.c.setContentViewId(uuid);
                    Intent intent = new Intent(tJCorePlacement2.b, TJAdUnitActivity.class);
                    intent.putExtra(TJAdUnitConstants.EXTRA_TJ_PLACEMENT_DATA, tJCorePlacement2.c);
                    intent.setFlags(PGImageSDK.SDK_STATUS_CREATE);
                    tJCorePlacement2.b.startActivity(intent);
                }
                tJCorePlacement2.f7217e = 0L;
                tJCorePlacement2.f7223k = false;
                tJCorePlacement2.f7224l = false;
            }
        } finally {
            gf.d("TJPlacement.showContent");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TJPlacement(TJCorePlacement tJCorePlacement, TJPlacementListener tJPlacementListener) {
        a(tJCorePlacement, tJPlacementListener);
    }

    private void a(TJError tJError) {
        this.b.a(this, TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, tJError);
    }
}
