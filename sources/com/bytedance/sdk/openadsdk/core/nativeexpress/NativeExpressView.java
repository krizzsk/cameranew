package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.c.p;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.o;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tapjoy.TapjoyConstants;
import com.tencent.open.SocialConstants;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
import us.pinguo.inspire.api.QiniuAuthToken;
/* loaded from: classes.dex */
public class NativeExpressView extends FrameLayout implements j {
    private final AtomicBoolean A;
    private String B;
    private float C;
    private float D;
    private final AtomicBoolean E;
    private com.bytedance.sdk.openadsdk.c.j F;
    private p G;
    private String H;
    private com.bytedance.sdk.openadsdk.dislike.b a;
    private TTDislikeDialogAbstract b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f1698d;

    /* renamed from: e  reason: collision with root package name */
    protected final AtomicBoolean f1699e;

    /* renamed from: f  reason: collision with root package name */
    protected final Context f1700f;

    /* renamed from: g  reason: collision with root package name */
    protected WeakReference<SSWebView> f1701g;

    /* renamed from: h  reason: collision with root package name */
    protected v f1702h;

    /* renamed from: i  reason: collision with root package name */
    protected String f1703i;

    /* renamed from: j  reason: collision with root package name */
    protected AdSlot f1704j;

    /* renamed from: k  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.d.h f1705k;

    /* renamed from: l  reason: collision with root package name */
    protected TTNativeExpressAd.ExpressVideoAdListener f1706l;
    protected FrameLayout m;
    protected boolean n;
    protected boolean o;
    protected ScheduledFuture<?> p;
    protected c q;
    protected boolean r;
    protected BackupView s;
    private int t;
    private int u;
    private TTNativeExpressAd.ExpressAdInteractionListener v;
    private d w;
    private e x;
    private final Map<String, d.a.a.a.a.a.b> y;
    private final AtomicBoolean z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private int b;

        public a(int i2) {
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b == 1) {
                o.c("NativeExpressView", "MSG_RENDER_TIME_OUT-->OnAdRenderRunnable......run....");
                NativeExpressView.this.a(false, 0.0f, 0.0f, 107);
            }
        }
    }

    public NativeExpressView(@NonNull Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, AdSlot adSlot, String str) {
        super(context);
        this.f1699e = new AtomicBoolean(false);
        this.f1703i = "embeded_ad";
        this.y = Collections.synchronizedMap(new HashMap());
        this.z = new AtomicBoolean(false);
        this.A = new AtomicBoolean(false);
        this.B = null;
        this.o = false;
        this.r = false;
        this.E = new AtomicBoolean(false);
        this.H = "{\"id\":0,\"tplId\":0,\"title\":\"\",\"data\":{\"id\":\"root\",\"type\":\"vessel\",\"values\":{\"widthMode\":\"fixed\",\"width\":320,\"height\":320},\"children\":[[{\"type\":\"text\",\"values\":{\"fontSize\":19,\"fontWeight\":500,\"color\":\"#222222\",\"lineHeight\":1.3,\"data\":\"title\"}}],[{\"type\":\"text\",\"values\":{\"fontSize\":15,\"fontWeight\":500,\"color\":\"#999999\",\"lineHeight\":1,\"data\":\"subtitle\"}}],[{\"type\":\"image\",\"values\":{},\"children\":[]}],[{\"type\":\"vessel\",\"values\":{\"height\":40,\"paddingTop\":10,\"paddingRight\":15,\"paddingBottom\":10,\"paddingLeft\":15},\"children\":[[{\"type\":\"logo\",\"values\":{}},{\"type\":\"text\",\"values\":{\"widthMode\":\"auto\",\"paddingTop\":3,\"paddingRight\":0,\"paddingBottom\":3,\"paddingLeft\":6,\"fontSize\":12,\"color\":\"#999999\",\"lineHeight\":1,\"data\":\"source\"}},{\"type\":\"text\",\"values\":{\"widthMode\":\"auto\",\"paddingTop\":3,\"paddingRight\":0,\"paddingBottom\":3,\"paddingLeft\":10,\"fontSize\":12,\"color\":\"#999999\",\"lineHeight\":1,\"data\":\"time\"}},{\"type\":\"empty\",\"values\":{\"height\":18}},{\"type\":\"dislike\",\"values\":{}}]]}]]}}";
        this.f1703i = str;
        this.f1700f = context;
        this.f1705k = hVar;
        a(adSlot);
        a();
    }

    private void c() {
        this.c = this.f1705k.J();
        this.f1698d = this.f1705k.M();
        this.u = 3154;
        this.t = ab.a(this.f1703i);
        this.B = this.f1704j.getCodeId();
    }

    private void d() {
        a(getWebView());
        com.bytedance.sdk.openadsdk.c.j a2 = new com.bytedance.sdk.openadsdk.c.j(this.f1700f, this.f1705k, getWebView()).a(true);
        this.F = a2;
        a2.a(this.G);
        getWebView().setWebViewClient(new f(this.f1700f, this.f1702h, this.f1705k, this.F));
        getWebView().setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this.f1702h, this.F));
        getWebView().setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                NativeExpressView nativeExpressView = NativeExpressView.this;
                d.a.a.a.a.a.b a3 = d.a.a.a.a.a.c.a(nativeExpressView.f1700f, nativeExpressView.f1705k, nativeExpressView.f1703i);
                if (a3 != null) {
                    a3.a();
                }
            }
        });
    }

    private boolean e() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.f1705k;
        return (hVar == null || hVar.u() == null || TextUtils.isEmpty(this.f1705k.u().e())) ? false : true;
    }

    private boolean f() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.f1705k;
        return hVar != null && hVar.e() == 1 && (this.f1705k.N() == 5 || this.f1705k.N() == 15);
    }

    private int getAdSlotType() {
        String str = this.f1703i;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1695837674:
                if (str.equals("banner_ad")) {
                    c = 0;
                    break;
                }
                break;
            case -1364000502:
                if (str.equals("rewarded_video")) {
                    c = 1;
                    break;
                }
                break;
            case -764631662:
                if (str.equals("fullscreen_interstitial_ad")) {
                    c = 2;
                    break;
                }
                break;
            case 174971131:
                if (str.equals("splash_ad")) {
                    c = 3;
                    break;
                }
                break;
            case 1844104722:
                if (str.equals("interaction")) {
                    c = 4;
                    break;
                }
                break;
            case 1912999166:
                if (str.equals("draw_ad")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 1;
            case 1:
                return 7;
            case 2:
                return 8;
            case 3:
                return 3;
            case 4:
                return 2;
            case 5:
                return 9;
            default:
                return 5;
        }
    }

    private JSONObject getCreativeJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("button_text", this.f1705k.I());
            if (this.f1705k.y() != null) {
                jSONObject.put("icon", this.f1705k.y().a());
            }
            JSONArray jSONArray = new JSONArray();
            if (this.f1705k.B() != null) {
                for (int i2 = 0; i2 < this.f1705k.B().size(); i2++) {
                    com.bytedance.sdk.openadsdk.core.d.g gVar = this.f1705k.B().get(i2);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("height", gVar.c());
                    jSONObject2.put("width", gVar.b());
                    jSONObject2.put("url", gVar.a());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put(QiniuAuthToken.TYPE_IMAGE, jSONArray);
            jSONObject.put("image_mode", this.f1705k.N());
            jSONObject.put("interaction_type", this.f1705k.x());
            jSONObject.put("title", this.f1705k.G());
            jSONObject.put(SocialConstants.PARAM_COMMENT, this.f1705k.H());
            jSONObject.put("source", this.f1705k.w());
            if (this.f1705k.K() != null) {
                jSONObject.put("comment_num", this.f1705k.K().e());
                jSONObject.put(FirebaseAnalytics.Param.SCORE, this.f1705k.K().d());
                jSONObject.put("app_size", this.f1705k.K().f());
                jSONObject.put("app", this.f1705k.K().g());
            }
            if (this.f1705k.v() != null) {
                jSONObject.put("video", this.f1705k.v().l());
            }
            if (this.f1705k.u() != null) {
                jSONObject.put("dynamic_creative", this.f1705k.u().g());
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject getTemplateInfo() {
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", this.C);
            jSONObject2.put("height", this.D);
            if (this.o) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObject.put("AdSize", jSONObject2);
            jSONObject.put("creative", getCreativeJson());
            if (this.f1705k.u() != null) {
                str = this.f1705k.u().e();
                str2 = this.f1705k.u().f();
            } else {
                str = null;
                str2 = null;
            }
            if (!TextUtils.isEmpty(str)) {
                this.H = str;
            } else if (com.bytedance.sdk.openadsdk.core.widget.webview.a.a.b(this.f1705k) != null) {
                this.H = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.b(this.f1705k).e();
            }
            jSONObject.put("template_Plugin", this.H);
            jSONObject.put("diff_template_Plugin", str2);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private void n() {
        com.bytedance.sdk.openadsdk.f.a.a().a(com.bytedance.sdk.openadsdk.f.a.c.b().a(getAdSlotType()).c(this.B).e(ab.h(this.f1698d)).a("dynamic_backup_render_new"));
    }

    private void o() {
        if (this.z.getAndSet(false) && getWebView().getParent() == null && !this.r) {
            o.e("webviewpool", "attachCallback+++========-----------===========");
            a();
            h();
        }
    }

    private void p() {
        if (this.z.getAndSet(true) || this.r) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.webview.d.a().a(this, this.f1701g, j());
    }

    private void q() {
        try {
            ScheduledFuture<?> scheduledFuture = this.p;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            boolean cancel = this.p.cancel(false);
            o.b("NativeExpressView", "MSG_RENDER_TIME_OUT-->mRenderTimeOutFuture-->cancel.....success=" + cancel);
            this.p = null;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.G = new p(1, this.f1703i, this.f1705k);
        v vVar = new v(this.f1700f);
        this.f1702h = vVar;
        vVar.a((WebView) getWebView()).a(this.f1705k).a(this.c).b(this.f1698d).b(this.t).c(ab.e(this.f1705k)).a((j) this).a(getTemplateInfo()).a(this.G);
    }

    public void g() {
        if (this.f1702h == null || this.E.get()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("expressShow", true);
            this.f1702h.a("expressShow", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public d getClickCreativeListener() {
        return this.w;
    }

    public e getClickListener() {
        return this.x;
    }

    public int getExpectExpressHeight() {
        return Float.valueOf(this.D).intValue();
    }

    public int getExpectExpressWidth() {
        return Float.valueOf(this.C).intValue();
    }

    public SSWebView getWebView() {
        WeakReference<SSWebView> weakReference = this.f1701g;
        if (weakReference != null && weakReference.get() != null) {
            return this.f1701g.get();
        }
        WeakReference<SSWebView> c = com.bytedance.sdk.openadsdk.core.widget.webview.d.a().c();
        this.f1701g = c;
        return c.get();
    }

    public void h() {
        this.A.set(true);
        this.G.a();
        this.p = com.bytedance.sdk.openadsdk.i.a.a().a(new a(1), com.bytedance.sdk.openadsdk.core.o.h().m());
        if (!com.bytedance.sdk.openadsdk.core.widget.webview.a.a.g()) {
            a(false, 0.0f, 0.0f, 102);
            return;
        }
        String c = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.f() != null ? com.bytedance.sdk.openadsdk.core.widget.webview.a.a.f().c() : null;
        if (TextUtils.isEmpty(c)) {
            a(false, 0.0f, 0.0f, 102);
            return;
        }
        com.bytedance.sdk.openadsdk.core.d.l b = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.b(this.f1705k);
        if (b == null && !e()) {
            a(false, 0.0f, 0.0f, 103);
            return;
        }
        String f2 = b != null ? b.f() : null;
        if (e() && !TextUtils.isEmpty(this.f1705k.u().a())) {
            f2 = this.f1705k.u().a();
        }
        if (com.bytedance.sdk.openadsdk.core.widget.webview.a.f.b(f2) && !"https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/latest/index.html".equals(c)) {
            a(false, 0.0f, 0.0f, 102);
        } else {
            getWebView().loadUrl(c);
        }
    }

    public void i() {
        if (getWebView() != null && !this.E.get()) {
            try {
                if (this.f1703i.equals("embeded_ad")) {
                    com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.f1700f).a(true).a(getWebView());
                }
                getWebView().resumeTimers();
            } catch (Exception unused) {
            }
        }
    }

    boolean j() {
        if ("embeded_ad".equals(this.f1703i) || "draw_ad".equals(this.f1703i)) {
            return false;
        }
        this.E.set(true);
        return true;
    }

    public void k() {
        try {
            com.bytedance.sdk.openadsdk.core.widget.webview.d.a().a(this, this.f1701g, true);
            this.E.set(true);
            this.f1702h = null;
            this.a = null;
            this.b = null;
            this.f1704j = null;
            this.f1705k = null;
            this.v = null;
            this.w = null;
            this.x = null;
            this.y.clear();
            this.f1706l = null;
            removeAllViews();
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            q();
        } catch (Throwable th) {
            o.c("NativeExpressView", "detach error", th);
        }
    }

    public void l() {
        try {
            com.bytedance.sdk.openadsdk.core.widget.webview.d.a().a(this, this.f1701g, true);
            this.E.set(true);
        } catch (Throwable th) {
            o.a("NativeExpressView", "backupDestroy remove webview error", th);
        }
        try {
            FrameLayout frameLayout = this.m;
            if (frameLayout == null || frameLayout.getParent() == null) {
                return;
            }
            removeView(this.m);
        } catch (Throwable th2) {
            o.a("NativeExpressView", "backupDestroy remove video container error", th2);
        }
    }

    public boolean m() {
        return this.r;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        o.e("webviewpool", "onAttachedToWindow+++");
        o();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        p();
        o.e("webviewpool", "onDetachedFromWindow===");
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        o.e("webviewpool", "onFinishTemporaryDetach+++");
        o();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        p();
    }

    public void setBackupListener(c cVar) {
        this.q = cVar;
    }

    public void setClickCreativeListener(d dVar) {
        this.w = dVar;
    }

    public void setClickListener(e eVar) {
        this.x = eVar;
    }

    public void setDislike(com.bytedance.sdk.openadsdk.dislike.b bVar) {
        BackupView backupView = this.s;
        if (backupView != null) {
            backupView.setDislikeInner(bVar);
        }
        this.a = bVar;
    }

    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.v = expressAdInteractionListener;
    }

    public void setOuterDislike(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        BackupView backupView = this.s;
        if (backupView != null) {
            backupView.setDislikeOuter(tTDislikeDialogAbstract);
        }
        this.b = tTDislikeDialogAbstract;
    }

    public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        this.f1706l = expressVideoAdListener;
    }

    private void a(AdSlot adSlot) {
        this.f1704j = adSlot;
        if (adSlot == null) {
            return;
        }
        this.C = adSlot.getExpressViewAcceptedWidth();
        this.D = this.f1704j.getExpressViewAcceptedHeight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        setBackgroundColor(0);
        if (getWebView().getParent() != null) {
            ((ViewGroup) getWebView().getParent()).removeView(getWebView());
        }
        getWebView().setBackgroundColor(0);
        addView(getWebView(), new FrameLayout.LayoutParams(-1, -1));
        c();
        b();
        d();
        getWebView().addJavascriptInterface(this.f1702h, "SDK_INJECT_GLOBAL");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, float f2, float f3, int i2) {
        boolean z2 = true;
        if (this.f1699e.getAndSet(true)) {
            return;
        }
        if (z) {
            this.G.b();
            a(f2, f3);
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.v;
            if (expressAdInteractionListener != null) {
                expressAdInteractionListener.onRenderSuccess(this, f2, f3);
            }
        } else {
            this.G.a(i2);
            this.G.c();
            this.G.a(true);
            c cVar = this.q;
            this.r = (cVar == null || !cVar.a(this, i2)) ? false : false;
            this.G.d();
            if (this.r) {
                n();
                com.bytedance.sdk.openadsdk.c.d.e(com.bytedance.sdk.openadsdk.core.o.a(), this.f1705k, this.f1703i, "dynamic_backup_render", null);
                BackupView backupView = (BackupView) findViewWithTag("tt_express_backup_fl_tag_26");
                this.s = backupView;
                TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener2 = this.v;
                if (expressAdInteractionListener2 != null) {
                    expressAdInteractionListener2.onRenderSuccess(this, backupView.getRealWidth(), this.s.getRealHeight());
                }
            } else {
                TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener3 = this.v;
                if (expressAdInteractionListener3 != null) {
                    expressAdInteractionListener3.onRenderFail(this, com.bytedance.sdk.openadsdk.core.g.a(i2), i2);
                }
            }
            a(i2);
        }
        this.G.h();
        this.G.i();
    }

    private void a(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.f1700f).a(!this.f1703i.equals("embeded_ad")).a(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            sSWebView.clearCache(true);
            sSWebView.clearHistory();
            WebSettings settings = sSWebView.getSettings();
            settings.setUserAgentString(com.bytedance.sdk.openadsdk.utils.l.a(sSWebView, this.u));
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
            settings.setJavaScriptEnabled(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setCacheMode(2);
            settings.setDomStorageEnabled(true);
            settings.setDatabaseEnabled(true);
            settings.setAppCacheEnabled(true);
            settings.setAllowFileAccess(true);
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            settings.setUseWideViewPort(true);
        } catch (Exception e2) {
            o.e("NativeExpressView", e2.toString());
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.j jVar) {
        if (jVar == null) {
            a(false, 0.0f, 0.0f, 105);
            return;
        }
        boolean a2 = jVar.a();
        a(a2, (float) jVar.b(), (float) jVar.c(), a2 ? 0 : jVar.h());
    }

    private void a(float f2, float f3) {
        if (f2 <= 0.0f || f3 <= 0.0f) {
            return;
        }
        int a2 = (int) ac.a(this.f1700f, f2);
        int a3 = (int) ac.a(this.f1700f, f3);
        o.e("ExpressView", "width:" + a2);
        o.e("ExpressView", "height:" + a3);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getWebView().getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(a2, a3);
        }
        layoutParams.width = a2;
        layoutParams.height = a3;
        getWebView().setLayoutParams(layoutParams);
    }

    public void a(int i2, com.bytedance.sdk.openadsdk.core.d.f fVar) {
        if (i2 == -1 || fVar == null) {
            return;
        }
        int i3 = fVar.a;
        int i4 = fVar.b;
        int i5 = fVar.c;
        int i6 = fVar.f1574d;
        if (i2 == 1) {
            FrameLayout frameLayout = this.m;
            if (frameLayout != null) {
                frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
            }
            e eVar = this.x;
            if (eVar != null) {
                eVar.a(fVar);
                this.x.a(this, i3, i4, i5, i6);
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.v;
            if (expressAdInteractionListener != null) {
                expressAdInteractionListener.onAdClicked(this, this.f1705k.x());
            }
        } else if (i2 == 2) {
            d dVar = this.w;
            if (dVar != null) {
                dVar.a(fVar);
                this.w.a(this, i3, i4, i5, i6);
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener2 = this.v;
            if (expressAdInteractionListener2 != null) {
                expressAdInteractionListener2.onAdClicked(this, this.f1705k.x());
            }
        } else if (i2 == 3) {
            TTDislikeDialogAbstract tTDislikeDialogAbstract = this.b;
            if (tTDislikeDialogAbstract != null) {
                tTDislikeDialogAbstract.show();
                VdsAgent.showDialog(tTDislikeDialogAbstract);
            } else {
                com.bytedance.sdk.openadsdk.dislike.b bVar = this.a;
                if (bVar != null) {
                    bVar.showDislikeDialog();
                }
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener3 = this.v;
            if (expressAdInteractionListener3 != null) {
                expressAdInteractionListener3.onAdClicked(this, this.f1705k.x());
            }
        } else if (i2 != 4) {
        } else {
            FrameLayout frameLayout2 = this.m;
            if (frameLayout2 != null) {
                frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
            }
            o.b("ClickCreativeListener", "创意....mAdType=" + this.f1703i + ",!mVideoPause=" + (true ^ this.n) + "，isAutoPlay=" + ab.f(this.f1705k));
            if ("embeded_ad".equals(this.f1703i) && f() && !this.n && ab.f(this.f1705k)) {
                o.b("ClickCreativeListener", "创意....");
                d dVar2 = this.w;
                if (dVar2 != null) {
                    dVar2.a(fVar);
                    this.w.a(this, i3, i4, i5, i6);
                }
            } else {
                o.b("ClickCreativeListener", "普通....");
                e eVar2 = this.x;
                if (eVar2 != null) {
                    eVar2.a(fVar);
                    this.x.a(this, i3, i4, i5, i6);
                }
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener4 = this.v;
            if (expressAdInteractionListener4 != null) {
                expressAdInteractionListener4.onAdClicked(this, this.f1705k.x());
            }
        }
    }

    private void a(int i2) {
        com.bytedance.sdk.openadsdk.f.a.a().c(com.bytedance.sdk.openadsdk.f.a.c.b().a(getAdSlotType()).c(this.B).e(ab.h(this.f1698d)).b(i2).f(com.bytedance.sdk.openadsdk.core.g.a(i2)));
    }

    protected void a(final boolean z, final float f2, final float f3, final int i2) {
        q();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b(z, f2, f3, i2);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
                @Override // java.lang.Runnable
                public void run() {
                    NativeExpressView.this.b(z, f2, f3, i2);
                }
            });
        }
    }
}
