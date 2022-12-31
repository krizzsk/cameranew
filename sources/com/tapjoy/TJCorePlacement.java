package com.tapjoy;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TJAdUnit;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.internal.b;
import com.tapjoy.internal.cb;
import com.tapjoy.internal.fi;
import com.tapjoy.internal.fm;
import com.tapjoy.internal.fq;
import com.tapjoy.internal.fu;
import com.tapjoy.internal.fv;
import com.tapjoy.internal.fw;
import com.tapjoy.internal.ga;
import com.tapjoy.internal.gf;
import com.tapjoy.internal.gi;
import com.tapjoy.internal.gv;
import com.tapjoy.internal.gw;
import com.tapjoy.internal.gz;
import com.tapjoy.internal.he;
import com.tapjoy.internal.hg;
import com.tapjoy.internal.hi;
import com.tapjoy.internal.ij;
import com.tapjoy.internal.jq;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* loaded from: classes3.dex */
public class TJCorePlacement {
    static final String a = "TJCorePlacement";
    Context b;
    TJPlacementData c;

    /* renamed from: d  reason: collision with root package name */
    String f7216d;

    /* renamed from: e  reason: collision with root package name */
    long f7217e;

    /* renamed from: g  reason: collision with root package name */
    TJAdUnit f7219g;

    /* renamed from: j  reason: collision with root package name */
    boolean f7222j;
    String m;
    String n;
    String o;
    String p;
    HashMap q;
    private Map s;
    private fm t;
    private boolean y;
    private Map r = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    final fw f7218f = new fw();

    /* renamed from: h  reason: collision with root package name */
    boolean f7220h = false;
    private boolean u = false;
    private ij v = null;

    /* renamed from: i  reason: collision with root package name */
    hg f7221i = null;
    private volatile boolean w = false;
    private volatile boolean x = false;

    /* renamed from: k  reason: collision with root package name */
    volatile boolean f7223k = false;

    /* renamed from: l  reason: collision with root package name */
    volatile boolean f7224l = false;
    private TJAdUnit.TJAdUnitWebViewListener z = new TJAdUnit.TJAdUnitWebViewListener() { // from class: com.tapjoy.TJCorePlacement.1
        @Override // com.tapjoy.TJAdUnit.TJAdUnitWebViewListener
        public final void onClick() {
            TJCorePlacement.e(TJCorePlacement.this);
        }

        @Override // com.tapjoy.TJAdUnit.TJAdUnitWebViewListener
        public final void onClosed() {
            if (TJCorePlacement.this.f7220h) {
                TJPlacementManager.decrementPlacementCacheCount();
                TJCorePlacement.this.f7220h = false;
            }
            if (TJCorePlacement.this.u) {
                TJPlacementManager.decrementPlacementPreRenderCount();
                TJCorePlacement.this.u = false;
            }
        }

        @Override // com.tapjoy.TJAdUnit.TJAdUnitWebViewListener
        public final void onContentReady() {
            TJCorePlacement.this.e();
        }
    };
    private TJAdUnit.TJAdUnitVideoListener A = new TJAdUnit.TJAdUnitVideoListener() { // from class: com.tapjoy.TJCorePlacement.2
        @Override // com.tapjoy.TJAdUnit.TJAdUnitVideoListener
        public final void onVideoCompleted() {
            TJPlacement a2 = TJCorePlacement.this.a("SHOW");
            if (a2 == null || a2.getVideoListener() == null) {
                return;
            }
            a2.getVideoListener().onVideoComplete(a2);
        }

        @Override // com.tapjoy.TJAdUnit.TJAdUnitVideoListener
        public final void onVideoError(String str) {
            TJPlacement a2 = TJCorePlacement.this.a("SHOW");
            if (a2 == null || a2.getVideoListener() == null) {
                return;
            }
            a2.getVideoListener().onVideoError(a2, str);
        }

        @Override // com.tapjoy.TJAdUnit.TJAdUnitVideoListener
        public final void onVideoStart() {
            TJPlacement a2 = TJCorePlacement.this.a("SHOW");
            if (a2 == null || a2.getVideoListener() == null) {
                return;
            }
            a2.getVideoListener().onVideoStart(a2);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public TJCorePlacement(String str, String str2, boolean z) {
        Activity c = b.c();
        this.b = c;
        if (c == null) {
            TapjoyLog.d(a, "getVisibleActivity() is NULL. Activity can be explicitly set via `Tapjoy.setActivity(Activity)`");
        }
        this.y = z;
        TJPlacementData tJPlacementData = new TJPlacementData(str2, getPlacementContentUrl());
        this.c = tJPlacementData;
        tJPlacementData.setPlacementName(str);
        this.f7216d = UUID.randomUUID().toString();
        TJAdUnit tJAdUnit = new TJAdUnit();
        this.f7219g = tJAdUnit;
        tJAdUnit.setWebViewListener(this.z);
        this.f7219g.setVideoListener(this.A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.x) {
            return;
        }
        this.f7224l = true;
        String str = a;
        TapjoyLog.i(str, "Content is ready for placement " + this.c.getPlacementName());
        if (this.f7219g.isPrerendered()) {
            fw fwVar = this.f7218f;
            Boolean bool = Boolean.TRUE;
            gf.a aVar = fwVar.b;
            if (aVar != null) {
                aVar.a("prerendered", bool);
            }
            gf.a aVar2 = fwVar.f7547e;
            if (aVar2 != null) {
                aVar2.a("prerendered", bool);
            }
        }
        fw fwVar2 = this.f7218f;
        gf.a aVar3 = fwVar2.f7547e;
        if (aVar3 != null) {
            fwVar2.f7547e = null;
            aVar3.b().c();
        }
        TJPlacement a2 = a("REQUEST");
        if (a2 == null || a2.getListener() == null) {
            return;
        }
        a2.getListener().onContentReady(a2);
        this.x = true;
    }

    static /* synthetic */ String g(TJCorePlacement tJCorePlacement) {
        return tJCorePlacement.c.getPlacementName();
    }

    static /* synthetic */ void j(TJCorePlacement tJCorePlacement) {
        fm fmVar = new fm(tJCorePlacement.c.getPlacementName(), tJCorePlacement.c.getPlacementType());
        tJCorePlacement.t = fmVar;
        tJCorePlacement.f7219g.setAdContentTracker(fmVar);
    }

    static /* synthetic */ void l(TJCorePlacement tJCorePlacement) {
        tJCorePlacement.f7223k = true;
        tJCorePlacement.b(tJCorePlacement.a("REQUEST"));
    }

    public TJAdUnit getAdUnit() {
        return this.f7219g;
    }

    public Context getContext() {
        return this.b;
    }

    public String getPlacementContentUrl() {
        String b = b();
        if (!jq.c(b)) {
            return TapjoyConnectCore.getPlacementURL() + "v1/apps/" + b + "/content?";
        }
        TapjoyLog.i(a, "Placement content URL cannot be generated for null app ID");
        return "";
    }

    public TJPlacementData getPlacementData() {
        return this.c;
    }

    public boolean isContentAvailable() {
        return this.f7223k;
    }

    public boolean isContentReady() {
        return this.f7224l;
    }

    public boolean isLimited() {
        return this.y;
    }

    public void setContext(Context context) {
        this.b = context;
    }

    private synchronized void d() {
        String url = this.c.getUrl();
        if (jq.c(url)) {
            url = getPlacementContentUrl();
            if (jq.c(url)) {
                gf.b("TJPlacement.requestContent").a("TJPlacement is missing APP_ID").c();
                a(TapjoyErrorMessage.ErrorType.SDK_ERROR, new TJError(0, "TJPlacement is missing APP_ID"));
                return;
            }
            this.c.updateUrl(url);
        }
        String str = a;
        TapjoyLog.d(str, "sendContentRequest -- URL: " + url + " name: " + this.c.getPlacementName());
        a(url, (Map) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        try {
            ij.a aVar = (ij.a) this.v.a(URI.create(this.c.getUrl()), new ByteArrayInputStream(str.getBytes()));
            hg hgVar = aVar.a;
            this.f7221i = hgVar;
            hgVar.b();
            if (!aVar.a.c()) {
                TapjoyLog.e(a, "Failed to load fiverocks placement");
                return false;
            }
            fq fqVar = null;
            hg hgVar2 = this.f7221i;
            if (hgVar2 instanceof he) {
                fqVar = new fu(this.c.getPlacementName(), this.c.getPlacementType(), this.t);
            } else if (hgVar2 instanceof gv) {
                fqVar = new fv(this.c.getPlacementName(), this.c.getPlacementType(), this.t);
            }
            this.f7218f.a = fqVar;
            return true;
        } catch (cb e2) {
            TapjoyLog.e(a, e2.toString());
            e2.printStackTrace();
            return false;
        } catch (IOException e3) {
            TapjoyLog.e(a, e3.toString());
            e3.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(TJPlacement tJPlacement) {
        boolean z = false;
        if (tJPlacement == null) {
            a(TapjoyErrorMessage.ErrorType.SDK_ERROR, new TJError(0, "Cannot request content from a NULL placement"));
            return;
        }
        a("REQUEST", tJPlacement);
        if (this.f7217e - SystemClock.elapsedRealtime() > 0) {
            String str = a;
            TapjoyLog.d(str, "Content has not expired yet for " + this.c.getPlacementName());
            if (this.f7223k) {
                gf.b("TJPlacement.requestContent").a(FirebaseAnalytics.Param.CONTENT_TYPE, a()).a("from", "cache").c();
                this.x = false;
                b(tJPlacement);
                e();
                return;
            }
            gf.b("TJPlacement.requestContent").a(FirebaseAnalytics.Param.CONTENT_TYPE, PortalFollowFeeds.TYPE_NONE).a("from", "cache").c();
            b(tJPlacement);
            return;
        }
        if (this.f7223k) {
            gf.c("TJPlacement.requestContent").a("was_available", Boolean.TRUE);
        }
        if (this.f7224l) {
            gf.c("TJPlacement.requestContent").a("was_ready", Boolean.TRUE);
        }
        if (!jq.c(this.o)) {
            HashMap hashMap = new HashMap();
            hashMap.put(TJAdUnitConstants.PARAM_PLACEMENT_MEDIATION_AGENT, this.o);
            hashMap.put(TJAdUnitConstants.PARAM_PLACEMENT_MEDIATION_ID, this.p);
            HashMap hashMap2 = this.q;
            if (hashMap2 != null && !hashMap2.isEmpty()) {
                z = true;
            }
            if (z) {
                for (String str2 : this.q.keySet()) {
                    hashMap.put(TJAdUnitConstants.AUCTION_PARAM_PREFIX + str2, this.q.get(str2));
                }
                a(this.c.getAuctionMediationURL(), hashMap);
                return;
            }
            a(this.c.getMediationURL(), hashMap);
            return;
        }
        d();
    }

    static /* synthetic */ void e(TJCorePlacement tJCorePlacement) {
        TJPlacement a2 = tJCorePlacement.a("SHOW");
        String str = a;
        TapjoyLog.i(str, "Handle onClick for placement " + tJCorePlacement.c.getPlacementName());
        if (a2 == null || a2.getListener() == null) {
            return;
        }
        a2.getListener().onClick(a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TJPlacement tJPlacement) {
        fw fwVar = this.f7218f;
        String placementName = this.c.getPlacementName();
        String placementType = this.c.getPlacementType();
        String a2 = a();
        fwVar.c = 0;
        fwVar.b = gf.e("PlacementContent.funnel").a().a("placement", placementName).a("placement_type", placementType).a(FirebaseAnalytics.Param.CONTENT_TYPE, a2).a("state", Integer.valueOf(fwVar.c));
        fwVar.b.c();
        if (!PortalFollowFeeds.TYPE_NONE.equals(a2)) {
            fwVar.f7547e = gf.e("PlacementContent.ready").a().a("placement", placementName).a("placement_type", placementType).a(FirebaseAnalytics.Param.CONTENT_TYPE, a2);
        }
        if (tJPlacement == null || tJPlacement.getListener() == null) {
            return;
        }
        String str = a;
        TapjoyLog.i(str, "Content request delivered successfully for placement " + this.c.getPlacementName() + ", contentAvailable: " + isContentAvailable() + ", mediationAgent: " + this.o);
        tJPlacement.getListener().onRequestSuccess(tJPlacement);
    }

    private synchronized void a(final String str, Map map) {
        if (this.w) {
            String str2 = a;
            TapjoyLog.i(str2, "Placement " + this.c.getPlacementName() + " is already requesting content");
            gf.b("TJPlacement.requestContent").b("already doing").c();
            return;
        }
        this.c.resetPlacementRequestData();
        fw fwVar = this.f7218f;
        String str3 = null;
        fwVar.b = null;
        fwVar.f7546d = null;
        fwVar.a = null;
        this.f7219g.resetContentLoadState();
        this.w = false;
        this.x = false;
        this.f7223k = false;
        this.f7224l = false;
        this.f7221i = null;
        this.v = null;
        this.w = true;
        final TJPlacement a2 = a("REQUEST");
        if (!this.y) {
            Map genericURLParams = TapjoyConnectCore.getGenericURLParams();
            this.s = genericURLParams;
            genericURLParams.putAll(TapjoyConnectCore.getTimeStampAndVerifierParams());
        } else {
            Map limitedGenericURLParams = TapjoyConnectCore.getLimitedGenericURLParams();
            this.s = limitedGenericURLParams;
            limitedGenericURLParams.putAll(TapjoyConnectCore.getLimitedTimeStampAndVerifierParams());
        }
        TapjoyUtil.safePut(this.s, TJAdUnitConstants.PARAM_PLACEMENT_NAME, this.c.getPlacementName(), true);
        TapjoyUtil.safePut(this.s, TJAdUnitConstants.PARAM_PLACEMENT_PRELOAD, "true", true);
        TapjoyUtil.safePut(this.s, "debug", Boolean.toString(gw.a), true);
        gz a3 = gz.a();
        Map map2 = this.s;
        hi hiVar = a3.b;
        if (hiVar != null) {
            hiVar.b();
            str3 = hiVar.b.a();
        }
        TapjoyUtil.safePut(map2, TJAdUnitConstants.PARAM_ACTION_ID_EXCLUSION, str3, true);
        TapjoyUtil.safePut(this.s, TJAdUnitConstants.PARAM_PLACEMENT_BY_SDK, String.valueOf(this.f7222j), true);
        TapjoyUtil.safePut(this.s, TJAdUnitConstants.PARAM_PUSH_ID, a2.pushId, true);
        TapjoyUtil.safePut(this.s, TapjoyConstants.TJC_MEDIATION_SOURCE, this.m, true);
        TapjoyUtil.safePut(this.s, TapjoyConstants.TJC_ADAPTER_VERSION, this.n, true);
        if (!jq.c(TapjoyConnectCore.getCustomParameter())) {
            TapjoyUtil.safePut(this.s, TapjoyConstants.TJC_CUSTOM_PARAMETER, TapjoyConnectCore.getCustomParameter(), true);
        }
        if (map != null) {
            this.s.putAll(map);
        }
        final fi fiVar = new fi(ga.b().b("placement_request_content_retry_timeout"));
        final gi c = ga.b().c("placement_request_content_retry_backoff");
        final gf.a d2 = gf.d("TJPlacement.requestContent");
        new Thread() { // from class: com.tapjoy.TJCorePlacement.3
            /* JADX WARN: Code restructure failed: missing block: B:61:0x030b, code lost:
                if (r3 > r7) goto L59;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            private boolean a() {
                /*
                    Method dump skipped, instructions count: 806
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.TJCorePlacement.AnonymousClass3.a():boolean");
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                gf.a("TJPlacement.requestContent", d2);
                int i2 = 0;
                while (!a()) {
                    i2++;
                    TJCorePlacement.this.s.put(TapjoyConstants.TJC_RETRY, Integer.toString(i2));
                    if (i2 == 1) {
                        d2.a("retry_timeout", Long.valueOf(fiVar.b));
                    }
                    d2.a("retry_count", i2);
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String b() {
        if (!this.y) {
            return TapjoyConnectCore.getAppID();
        }
        return TapjoyConnectCore.getLimitedAppID();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a() {
        return this.f7221i != null ? "mm" : this.f7223k ? "ad" : PortalFollowFeeds.TYPE_NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, TJPlacement tJPlacement) {
        synchronized (this.r) {
            this.r.put(str, tJPlacement);
            if (tJPlacement != null) {
                String str2 = a;
                TapjoyLog.d(str2, "Setting " + str + " placement: " + tJPlacement.getGUID());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final TJPlacement a(String str) {
        TJPlacement tJPlacement;
        synchronized (this.r) {
            tJPlacement = (TJPlacement) this.r.get(str);
            if (tJPlacement != null) {
                String str2 = a;
                TapjoyLog.d(str2, "Returning " + str + " placement: " + tJPlacement.getGUID());
            }
        }
        return tJPlacement;
    }

    final void a(TapjoyErrorMessage.ErrorType errorType, TJError tJError) {
        a(a("REQUEST"), errorType, tJError);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(TJPlacement tJPlacement, TapjoyErrorMessage.ErrorType errorType, TJError tJError) {
        String str = a;
        TapjoyLog.e(str, new TapjoyErrorMessage(errorType, "Content request failed for placement " + this.c.getPlacementName() + "; Reason= " + tJError.message));
        if (tJPlacement == null || tJPlacement.getListener() == null) {
            return;
        }
        tJPlacement.getListener().onRequestFailure(tJPlacement, tJError);
    }

    static /* synthetic */ void a(TJCorePlacement tJCorePlacement, String str) {
        if (str != null) {
            try {
                String str2 = a;
                TapjoyLog.d(str2, "Disable preload flag is set for placement " + tJCorePlacement.c.getPlacementName());
                tJCorePlacement.c.setRedirectURL(new JSONObject(str).getString(TapjoyConstants.TJC_REDIRECT_URL));
                tJCorePlacement.c.setPreloadDisabled(true);
                tJCorePlacement.c.setHasProgressSpinner(true);
                TapjoyLog.d(str2, "redirect_url:" + tJCorePlacement.c.getRedirectURL());
                return;
            } catch (JSONException unused) {
                throw new TapjoyException("TJPlacement request failed, malformed server response");
            }
        }
        throw new TapjoyException("TJPlacement request failed due to null response");
    }
}
