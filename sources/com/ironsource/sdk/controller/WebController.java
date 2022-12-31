package com.ironsource.sdk.controller;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.collection.Constants;
import com.ironsource.sdk.ISNAdView.ISNAdView;
import com.ironsource.sdk.WPAD.AdViewsManager;
import com.ironsource.sdk.data.AdUnitsState;
import com.ironsource.sdk.data.ISNEnums$ControllerType;
import com.ironsource.sdk.data.ISNEnums$DebugMode;
import com.ironsource.sdk.data.ISNEnums$ProductType;
import com.ironsource.sdk.fileSystem.ISNFile;
import com.ironsource.sdk.service.PackagesInstallationService;
import com.tapjoy.TJAdUnitConstants;
import com.tencent.tauth.AuthActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
import us.pinguo.inspire.module.MissionDetail.TaskDetailBasePresenter;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* loaded from: classes2.dex */
public class WebController extends WebView implements com.ironsource.sdk.controller.j, d.e.d.o.c, DownloadListener {
    public static int U = 0;
    public static String V = "is_store";
    public static String W = "external_url";
    public static String d0 = "secondary_web_view";
    private static String e0 = "success";
    private static String f0 = "fail";
    private String A;
    private ControllerHtmlFile B;
    private com.ironsource.sdk.controller.q C;
    private AdUnitsState D;
    private Object E;
    Handler F;
    private boolean G;
    private com.ironsource.sdk.controller.h H;
    private OMIDJSAdapter I;
    private PermissionsJSAdapter J;
    private com.ironsource.sdk.controller.b K;
    private com.ironsource.sdk.controller.p L;
    private DeviceDataJSAdapter M;
    private com.ironsource.sdk.controller.a N;
    private com.ironsource.sdk.controller.i O;
    private com.ironsource.sdk.controller.r P;
    private com.ironsource.sdk.controller.e Q;
    private com.ironsource.sdk.service.b.b R;
    com.ironsource.sdk.controller.c S;
    private d.e.d.n.g T;
    private String a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f5726d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, String> f5727e;

    /* renamed from: f  reason: collision with root package name */
    private d.e.d.o.b f5728f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f5729g;

    /* renamed from: h  reason: collision with root package name */
    private p f5730h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f5731i;

    /* renamed from: j  reason: collision with root package name */
    private CountDownTimer f5732j;

    /* renamed from: k  reason: collision with root package name */
    public CountDownTimer f5733k;

    /* renamed from: l  reason: collision with root package name */
    private int f5734l;
    private int m;
    private String n;
    private ChromeClient o;
    private View p;
    private FrameLayout q;
    private WebChromeClient.CustomViewCallback r;
    private FrameLayout s;
    private State t;
    private String u;
    private d.e.d.n.h.d v;
    private d.e.d.n.h.c w;
    private d.e.d.n.e x;
    private d.e.d.n.h.b y;
    private Boolean z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ChromeClient extends WebChromeClient {
        private ChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public View getVideoLoadingProgressView() {
            FrameLayout frameLayout = new FrameLayout(WebController.this.r1());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return frameLayout;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            com.ironsource.sdk.utils.d.d("MyApplication", consoleMessage.message() + " -- From line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            WebView webView2 = new WebView(webView.getContext());
            webView2.setWebChromeClient(this);
            VdsAgent.setWebChromeClient(webView2, this);
            webView2.setWebViewClient(new q(WebController.this, null));
            ((WebView.WebViewTransport) message.obj).setWebView(webView2);
            message.sendToTarget();
            com.ironsource.sdk.utils.d.d("onCreateWindow", "onCreateWindow");
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            com.ironsource.sdk.utils.d.d("Test", "onHideCustomView");
            if (WebController.this.p == null) {
                return;
            }
            View view = WebController.this.p;
            view.setVisibility(8);
            VdsAgent.onSetViewVisibility(view, 8);
            WebController.this.q.removeView(WebController.this.p);
            WebController.this.p = null;
            FrameLayout frameLayout = WebController.this.q;
            frameLayout.setVisibility(8);
            VdsAgent.onSetViewVisibility(frameLayout, 8);
            WebController.this.r.onCustomViewHidden();
            WebController webController = WebController.this;
            webController.setVisibility(0);
            VdsAgent.onSetViewVisibility(webController, 0);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            VdsAgent.onProgressChangedStart(webView, i2);
            super.onProgressChanged(webView, i2);
            VdsAgent.onProgressChangedEnd(webView, i2);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            com.ironsource.sdk.utils.d.d("Test", "onShowCustomView");
            WebController webController = WebController.this;
            webController.setVisibility(8);
            VdsAgent.onSetViewVisibility(webController, 8);
            if (WebController.this.p != null) {
                com.ironsource.sdk.utils.d.d("Test", "mCustomView != null");
                customViewCallback.onCustomViewHidden();
                return;
            }
            com.ironsource.sdk.utils.d.d("Test", "mCustomView == null");
            WebController.this.q.addView(view);
            WebController.this.p = view;
            WebController.this.r = customViewCallback;
            FrameLayout frameLayout = WebController.this.q;
            frameLayout.setVisibility(0);
            VdsAgent.onSetViewVisibility(frameLayout, 0);
        }

        /* synthetic */ ChromeClient(WebController webController, g gVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public enum State {
        Display,
        Gone
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ StringBuilder b;

        a(String str, StringBuilder sb) {
            this.a = str;
            this.b = sb;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.utils.d.d(WebController.this.a, this.a);
            try {
                if (WebController.this.z != null) {
                    if (WebController.this.z.booleanValue()) {
                        WebController.this.g1(this.b.toString());
                    } else {
                        WebController webController = WebController.this;
                        String str = this.a;
                        webController.loadUrl(str);
                        VdsAgent.loadUrl(webController, str);
                    }
                } else if (Build.VERSION.SDK_INT >= 19) {
                    try {
                        WebController.this.g1(this.b.toString());
                        WebController.this.z = Boolean.TRUE;
                    } catch (NoSuchMethodError e2) {
                        String str2 = WebController.this.a;
                        com.ironsource.sdk.utils.d.b(str2, "evaluateJavascrip NoSuchMethodError: SDK version=" + Build.VERSION.SDK_INT + " " + e2);
                        WebController webController2 = WebController.this;
                        String str3 = this.a;
                        webController2.loadUrl(str3);
                        VdsAgent.loadUrl(webController2, str3);
                        WebController.this.z = Boolean.FALSE;
                    }
                } else {
                    WebController webController3 = WebController.this;
                    String str4 = this.a;
                    webController3.loadUrl(str4);
                    VdsAgent.loadUrl(webController3, str4);
                    WebController.this.z = Boolean.FALSE;
                }
            } catch (Throwable th) {
                String str5 = WebController.this.a;
                com.ironsource.sdk.utils.d.b(str5, "injectJavascript: " + th.toString());
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WebController.this.M1(1);
        }
    }

    /* loaded from: classes2.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WebController.this.M1(1);
        }
    }

    /* loaded from: classes2.dex */
    class d implements Runnable {
        final /* synthetic */ com.ironsource.sdk.data.c a;

        d(com.ironsource.sdk.data.c cVar) {
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.e eVar = WebController.this.Q;
            eVar.l("controller html - failed to download - " + this.a.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        e(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WebController.this.s1() == ISNEnums$DebugMode.MODE_3.getValue()) {
                Context r1 = WebController.this.r1();
                Toast makeText = Toast.makeText(r1, this.a + " : " + this.b, 1);
                makeText.show();
                VdsAgent.showToast(makeText);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements Runnable {
        final /* synthetic */ ISNEnums$ProductType a;
        final /* synthetic */ String b;

        f(ISNEnums$ProductType iSNEnums$ProductType, String str) {
            this.a = iSNEnums$ProductType;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ISNEnums$ProductType iSNEnums$ProductType = this.a;
            if (iSNEnums$ProductType == ISNEnums$ProductType.RewardedVideo || iSNEnums$ProductType == ISNEnums$ProductType.Interstitial) {
                d.e.d.n.h.a o1 = WebController.this.o1(iSNEnums$ProductType);
                if (o1 != null) {
                    o1.B(this.a, this.b);
                }
            } else if (iSNEnums$ProductType == ISNEnums$ProductType.OfferWall) {
                WebController.this.x.onOWAdClosed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g extends com.ironsource.sdk.service.b.b {
        g(JSONObject jSONObject, Context context) {
            super(jSONObject, context);
        }

        @Override // com.ironsource.sdk.service.b.b, com.ironsource.sdk.service.b.d
        public void a() {
            if (WebController.this.f5729g) {
                WebController.this.b2(PortalFollowFeeds.TYPE_NONE);
            }
        }

        @Override // com.ironsource.sdk.service.b.b, com.ironsource.sdk.service.b.d
        public void b(String str, JSONObject jSONObject) {
            if (jSONObject == null || !WebController.this.f5729g) {
                return;
            }
            try {
                jSONObject.put("connectionType", str);
                WebController.this.a2(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.ironsource.sdk.service.b.b, com.ironsource.sdk.service.b.d
        public void c(String str, JSONObject jSONObject) {
            if (WebController.this.f5729g) {
                WebController.this.b2(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements com.ironsource.sdk.controller.r {
        h() {
        }

        @Override // com.ironsource.sdk.controller.r
        public void a(String str, JSONObject jSONObject) {
            WebController.this.K1(WebController.this.l1(str, jSONObject.toString()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class i extends CountDownTimer {
        final /* synthetic */ int a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(long j2, long j3, int i2) {
            super(j2, j3);
            this.a = i2;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            com.ironsource.sdk.utils.d.d(WebController.this.a, "Loading Controller Timer Finish");
            int i2 = this.a;
            if (i2 == 3) {
                WebController.this.Q.l("controller html - failed to load into web-view");
            } else {
                WebController.this.M1(i2 + 1);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            String str = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str, "Loading Controller Timer Tick " + j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class j implements s {
        j() {
        }

        @Override // com.ironsource.sdk.controller.WebController.s
        public void a(String str, ISNEnums$ProductType iSNEnums$ProductType, com.ironsource.sdk.data.b bVar) {
            WebController.this.l2(str, iSNEnums$ProductType, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class k implements s {
        k() {
        }

        @Override // com.ironsource.sdk.controller.WebController.s
        public void a(String str, ISNEnums$ProductType iSNEnums$ProductType, com.ironsource.sdk.data.b bVar) {
            WebController.this.l2(str, iSNEnums$ProductType, bVar);
        }
    }

    /* loaded from: classes2.dex */
    class l implements s {
        l() {
        }

        @Override // com.ironsource.sdk.controller.WebController.s
        public void a(String str, ISNEnums$ProductType iSNEnums$ProductType, com.ironsource.sdk.data.b bVar) {
            WebController.this.l2(str, iSNEnums$ProductType, bVar);
        }
    }

    /* loaded from: classes2.dex */
    class m implements s {
        m() {
        }

        @Override // com.ironsource.sdk.controller.WebController.s
        public void a(String str, ISNEnums$ProductType iSNEnums$ProductType, com.ironsource.sdk.data.b bVar) {
            WebController.this.l2(str, iSNEnums$ProductType, bVar);
        }
    }

    /* loaded from: classes2.dex */
    class n implements s {
        n() {
        }

        @Override // com.ironsource.sdk.controller.WebController.s
        public void a(String str, ISNEnums$ProductType iSNEnums$ProductType, com.ironsource.sdk.data.b bVar) {
            WebController.this.l2(str, iSNEnums$ProductType, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class o implements Runnable {
        final /* synthetic */ ISNEnums$ProductType a;
        final /* synthetic */ com.ironsource.sdk.data.b b;
        final /* synthetic */ String c;

        o(ISNEnums$ProductType iSNEnums$ProductType, com.ironsource.sdk.data.b bVar, String str) {
            this.a = iSNEnums$ProductType;
            this.b = bVar;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ISNEnums$ProductType iSNEnums$ProductType = ISNEnums$ProductType.RewardedVideo;
            ISNEnums$ProductType iSNEnums$ProductType2 = this.a;
            if (iSNEnums$ProductType != iSNEnums$ProductType2 && ISNEnums$ProductType.Interstitial != iSNEnums$ProductType2 && ISNEnums$ProductType.Banner != iSNEnums$ProductType2) {
                if (ISNEnums$ProductType.OfferWall == iSNEnums$ProductType2) {
                    WebController.this.x.onOfferwallInitFail(this.c);
                    return;
                } else if (ISNEnums$ProductType.OfferWallCredits == iSNEnums$ProductType2) {
                    WebController.this.x.onGetOWCreditsFailed(this.c);
                    return;
                } else {
                    return;
                }
            }
            com.ironsource.sdk.data.b bVar = this.b;
            if (bVar == null || TextUtils.isEmpty(bVar.f())) {
                return;
            }
            d.e.d.n.h.a o1 = WebController.this.o1(this.a);
            String str = WebController.this.a;
            Log.d(str, "onAdProductInitFailed (message:" + this.c + ")(" + this.a + ")");
            if (o1 != null) {
                o1.y(this.a, this.b.f(), this.c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class p {
        ISNEnums$ProductType a;
        String b;

        public p(ISNEnums$ProductType iSNEnums$ProductType, String str) {
            this.a = iSNEnums$ProductType;
            this.b = str;
        }

        String a() {
            return this.b;
        }

        ISNEnums$ProductType b() {
            return this.a;
        }
    }

    /* loaded from: classes2.dex */
    private class q extends WebViewClient {
        private q() {
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(26)
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            String str = WebController.this.a;
            com.ironsource.sdk.utils.d.b(str, "Chromium process crashed - detail.didCrash(): " + renderProcessGoneDetail.didCrash());
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Context r1 = WebController.this.r1();
            Intent intent = new Intent(r1, OpenUrlActivity.class);
            intent.putExtra(WebController.W, str);
            intent.putExtra(WebController.d0, false);
            r1.startActivity(intent);
            return true;
        }

        /* synthetic */ q(WebController webController, g gVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public class r {

        /* loaded from: classes2.dex */
        class a implements Runnable {
            final /* synthetic */ String a;

            a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                WebController.this.x.onOWShowSuccess(this.a);
            }
        }

        /* loaded from: classes2.dex */
        class a0 implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ String b;

            a0(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                String str2 = WebController.this.a;
                Log.d(str2, "onRVShowFail(message:" + this.a + ")");
                WebController.this.v.L(this.b, str);
            }
        }

        /* loaded from: classes2.dex */
        class b implements Runnable {
            final /* synthetic */ String a;

            b(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                WebController.this.x.onOWShowFail(str);
            }
        }

        /* loaded from: classes2.dex */
        public class b0 {
            public b0() {
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public void a(boolean z, String str, com.ironsource.sdk.data.d dVar) {
                dVar.h(z ? WebController.e0 : WebController.f0, str);
                WebController.this.W1(dVar.toString(), z, null, null);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public void b(boolean z, String str, String str2) {
                com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d();
                dVar.h(z ? WebController.e0 : WebController.f0, str);
                dVar.h("data", str2);
                WebController.this.W1(dVar.toString(), z, null, null);
            }

            public void c(boolean z, String str, JSONObject jSONObject) {
                try {
                    jSONObject.put(z ? WebController.e0 : WebController.f0, str);
                    WebController.this.W1(jSONObject.toString(), z, null, null);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    e2.getMessage();
                }
            }
        }

        /* loaded from: classes2.dex */
        class c implements Runnable {
            final /* synthetic */ String a;

            c(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(WebController.this.a, "onInterstitialInitSuccess()");
                WebController.this.w.I(ISNEnums$ProductType.Interstitial, this.a, null);
            }
        }

        /* loaded from: classes2.dex */
        class d implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ String b;

            d(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                String str2 = WebController.this.a;
                Log.d(str2, "onInterstitialInitFail(message:" + str + ")");
                WebController.this.w.y(ISNEnums$ProductType.Interstitial, this.b, str);
            }
        }

        /* loaded from: classes2.dex */
        class e implements Runnable {
            final /* synthetic */ d.e.d.n.h.a a;
            final /* synthetic */ ISNEnums$ProductType b;
            final /* synthetic */ String c;

            e(r rVar, d.e.d.n.h.a aVar, ISNEnums$ProductType iSNEnums$ProductType, String str) {
                this.a = aVar;
                this.b = iSNEnums$ProductType;
                this.c = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.C(this.b, this.c);
            }
        }

        /* loaded from: classes2.dex */
        class f implements Runnable {
            final /* synthetic */ String a;

            f(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                WebController.this.w.G(ISNEnums$ProductType.Interstitial, this.a);
                WebController.this.w.F(this.a);
            }
        }

        /* loaded from: classes2.dex */
        class g implements Runnable {
            g() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(WebController.this.a, "onOfferWallInitSuccess()");
                WebController.this.x.onOfferwallInitSuccess();
            }
        }

        /* loaded from: classes2.dex */
        class h implements Runnable {
            final /* synthetic */ String a;

            h(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                String str2 = WebController.this.a;
                Log.d(str2, "onOfferWallInitFail(message:" + str + ")");
                WebController.this.x.onOfferwallInitFail(str);
            }
        }

        /* loaded from: classes2.dex */
        class i implements Runnable {
            final /* synthetic */ String a;

            i(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                WebController.this.w.D(this.a);
            }
        }

        /* loaded from: classes2.dex */
        class j implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ String b;

            j(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                WebController.this.w.m(this.b, str);
            }
        }

        /* loaded from: classes2.dex */
        class k implements Runnable {
            k() {
            }

            @Override // java.lang.Runnable
            public void run() {
                WebController.this.Y1();
            }
        }

        /* loaded from: classes2.dex */
        class l implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ String b;

            l(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                WebController.this.w.j(this.b, str);
            }
        }

        /* loaded from: classes2.dex */
        class m implements Runnable {
            final /* synthetic */ String a;

            m(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(WebController.this.a, "onBannerInitSuccess()");
                WebController.this.y.I(ISNEnums$ProductType.Banner, this.a, null);
            }
        }

        /* loaded from: classes2.dex */
        class n implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ String b;

            n(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                String str2 = WebController.this.a;
                Log.d(str2, "onBannerInitFail(message:" + str + ")");
                WebController.this.y.y(ISNEnums$ProductType.Banner, this.b, str);
            }
        }

        /* loaded from: classes2.dex */
        class o implements Runnable {
            final /* synthetic */ String a;

            o(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(WebController.this.a, "onBannerLoadSuccess()");
                WebController.this.y.s(this.a);
            }
        }

        /* loaded from: classes2.dex */
        class p implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ String b;

            p(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(WebController.this.a, "onLoadBannerFail()");
                String str = this.a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                WebController.this.y.z(this.b, str);
            }
        }

        /* loaded from: classes2.dex */
        class q implements Runnable {
            final /* synthetic */ String a;

            q(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                WebController.this.x.onGetOWCreditsFailed(str);
            }
        }

        /* renamed from: com.ironsource.sdk.controller.WebController$r$r  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class RunnableC0213r implements Runnable {
            final /* synthetic */ ISNEnums$ProductType a;
            final /* synthetic */ String b;
            final /* synthetic */ String c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ JSONObject f5736d;

            RunnableC0213r(ISNEnums$ProductType iSNEnums$ProductType, String str, String str2, JSONObject jSONObject) {
                this.a = iSNEnums$ProductType;
                this.b = str;
                this.c = str2;
                this.f5736d = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                ISNEnums$ProductType iSNEnums$ProductType = this.a;
                if (iSNEnums$ProductType == ISNEnums$ProductType.Interstitial || iSNEnums$ProductType == ISNEnums$ProductType.RewardedVideo) {
                    d.e.d.n.h.a o1 = WebController.this.o1(iSNEnums$ProductType);
                    if (o1 != null) {
                        o1.l(this.a, this.b, this.c, this.f5736d);
                    }
                } else if (iSNEnums$ProductType == ISNEnums$ProductType.OfferWall) {
                    WebController.this.x.onOfferwallEventNotificationReceived(this.c, this.f5736d);
                }
            }
        }

        /* loaded from: classes2.dex */
        class s implements Runnable {
            final /* synthetic */ String a;

            s(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    String str = WebController.this.a;
                    com.ironsource.sdk.utils.d.d(str, "omidAPI(" + this.a + ")");
                    com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(this.a);
                    OMIDJSAdapter oMIDJSAdapter = WebController.this.I;
                    String dVar2 = dVar.toString();
                    r rVar = r.this;
                    b0 b0Var = new b0();
                    WebController webController = WebController.this;
                    webController.C1();
                    oMIDJSAdapter.a(dVar2, b0Var, webController);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    String str2 = WebController.this.a;
                    com.ironsource.sdk.utils.d.d(str2, "omidAPI failed with exception " + e2.getMessage());
                }
            }
        }

        /* loaded from: classes2.dex */
        class t implements Runnable {
            t() {
            }

            @Override // java.lang.Runnable
            public void run() {
                WebController.this.T1();
            }
        }

        /* loaded from: classes2.dex */
        class u implements Runnable {
            u() {
            }

            @Override // java.lang.Runnable
            public void run() {
                WebController.this.removeJavascriptInterface("GenerateTokenForMessaging");
            }
        }

        /* loaded from: classes2.dex */
        class v implements Runnable {
            v() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (Build.VERSION.SDK_INT >= 21) {
                    WebController.this.getSettings().setMixedContentMode(0);
                }
            }
        }

        /* loaded from: classes2.dex */
        class w implements Runnable {
            final /* synthetic */ com.ironsource.sdk.data.a a;
            final /* synthetic */ String b;

            w(com.ironsource.sdk.data.a aVar, String str) {
                this.a = aVar;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (Integer.parseInt(this.a.m()) > 0) {
                    Log.d(WebController.this.a, "onRVInitSuccess()");
                    WebController.this.v.I(ISNEnums$ProductType.RewardedVideo, this.b, this.a);
                    return;
                }
                WebController.this.v.u(this.b);
            }
        }

        /* loaded from: classes2.dex */
        class x implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ String b;
            final /* synthetic */ int c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ boolean f5738d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ int f5739e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ boolean f5740f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ String f5741g;

            /* renamed from: h  reason: collision with root package name */
            final /* synthetic */ String f5742h;

            x(String str, String str2, int i2, boolean z, int i3, boolean z2, String str3, String str4) {
                this.a = str;
                this.b = str2;
                this.c = i2;
                this.f5738d = z;
                this.f5739e = i3;
                this.f5740f = z2;
                this.f5741g = str3;
                this.f5742h = str4;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.a.equalsIgnoreCase(ISNEnums$ProductType.RewardedVideo.toString())) {
                    WebController.this.v.A(this.b, this.c);
                } else if (this.a.equalsIgnoreCase(ISNEnums$ProductType.OfferWall.toString()) && this.f5738d && WebController.this.x.onOWAdCredited(this.c, this.f5739e, this.f5740f) && !TextUtils.isEmpty(this.f5741g)) {
                    if (com.ironsource.sdk.utils.b.e().k(this.f5741g, WebController.this.c, WebController.this.f5726d)) {
                        WebController.this.W1(this.f5742h, true, null, null);
                    } else {
                        WebController.this.W1(this.f5742h, false, "Time Stamp could not be stored", null);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class y implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ int b;

            y(String str, int i2) {
                this.a = str;
                this.b = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                WebController.this.w.onInterstitialAdRewarded(this.a, this.b);
            }
        }

        /* loaded from: classes2.dex */
        class z implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ String b;

            z(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                String str2 = WebController.this.a;
                Log.d(str2, "onRVInitFail(message:" + str + ")");
                WebController.this.v.y(ISNEnums$ProductType.RewardedVideo, this.b, str);
            }
        }

        public r() {
        }

        private void a(JSONObject jSONObject) {
            try {
                jSONObject.put("controllerSourceData", WebController.this.B.i());
            } catch (Exception unused) {
            }
        }

        private void b(JSONObject jSONObject) {
            try {
                FeaturesManager featuresManager = FeaturesManager.getInstance();
                if (featuresManager.b().isEmpty()) {
                    return;
                }
                jSONObject.put("nativeFeatures", new JSONArray((Collection) featuresManager.b()));
            } catch (Exception e2) {
                d.e.d.a.a aVar = new d.e.d.a.a();
                aVar.a("callfailreason", e2.getMessage());
                d.e.d.a.d.d(d.e.d.a.f.n, aVar.b());
                com.ironsource.sdk.utils.d.a(WebController.this.a, "getControllerConfig Error while adding supported features data from FeaturesManager");
            }
        }

        private void c(JSONObject jSONObject, String str) {
            if (d(str)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    jSONObject.putOpt("testerABGroup", jSONObject2.get("testerABGroup"));
                    jSONObject.putOpt("testFriendlyName", jSONObject2.get("testFriendlyName"));
                } catch (JSONException unused) {
                    com.ironsource.sdk.utils.d.a(WebController.this.a, "getControllerConfig Error while parsing Tester AB Group parameters");
                }
            }
        }

        private void e(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            WebController.this.K1(WebController.this.l1(str, str2));
        }

        private void f(JSONObject jSONObject) {
            b(jSONObject);
            c(jSONObject, com.ironsource.sdk.utils.f.u());
            a(jSONObject);
        }

        private void g(String str, int i2) {
            com.ironsource.sdk.data.b d2;
            WebController webController = WebController.this;
            ISNEnums$ProductType iSNEnums$ProductType = ISNEnums$ProductType.Interstitial;
            if (webController.j2(iSNEnums$ProductType.toString()) && (d2 = WebController.this.H.d(iSNEnums$ProductType, str)) != null && d2.j()) {
                WebController.this.Z1(new y(str, i2));
            }
        }

        private void i(String str, boolean z2) {
            com.ironsource.sdk.data.b d2 = WebController.this.H.d(ISNEnums$ProductType.Interstitial, str);
            if (d2 != null) {
                d2.k(z2);
            }
        }

        @JavascriptInterface
        public void adClicked(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "adClicked(" + str + ")");
            com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(str);
            String f2 = dVar.f("productType");
            String d2 = com.ironsource.sdk.utils.f.d(dVar);
            if (TextUtils.isEmpty(d2)) {
                return;
            }
            ISNEnums$ProductType B1 = WebController.this.B1(f2);
            d.e.d.n.h.a o1 = WebController.this.o1(B1);
            if (B1 == null || o1 == null) {
                return;
            }
            WebController.this.Z1(new e(this, o1, B1, d2));
        }

        @JavascriptInterface
        public void adCredited(String str) {
            String str2;
            boolean z2;
            boolean z3;
            Log.d(WebController.this.b, "adCredited(" + str + ")");
            com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(str);
            String f2 = dVar.f("credits");
            boolean z4 = false;
            int parseInt = f2 != null ? Integer.parseInt(f2) : 0;
            String d2 = com.ironsource.sdk.utils.f.d(dVar);
            String f3 = dVar.f("productType");
            if (TextUtils.isEmpty(f3)) {
                Log.d(WebController.this.b, "adCredited | product type is missing");
            }
            if (ISNEnums$ProductType.Interstitial.toString().equalsIgnoreCase(f3)) {
                g(d2, parseInt);
                return;
            }
            String f4 = dVar.f("total");
            int parseInt2 = f4 != null ? Integer.parseInt(f4) : 0;
            if (!ISNEnums$ProductType.OfferWall.toString().equalsIgnoreCase(f3)) {
                str2 = null;
                z2 = false;
                z3 = false;
            } else if (dVar.g("signature") || dVar.g("timestamp") || dVar.g("totalCreditsFlag")) {
                WebController.this.W1(str, false, "One of the keys are missing: signature/timestamp/totalCreditsFlag", null);
                return;
            } else {
                if (dVar.f("signature").equalsIgnoreCase(com.ironsource.sdk.utils.f.p(f4 + WebController.this.c + WebController.this.f5726d))) {
                    z4 = true;
                } else {
                    WebController.this.W1(str, false, "Controller signature is not equal to SDK signature", null);
                }
                boolean d3 = dVar.d("totalCreditsFlag");
                str2 = dVar.f("timestamp");
                z3 = d3;
                z2 = z4;
            }
            if (WebController.this.j2(f3)) {
                WebController.this.Z1(new x(f3, d2, parseInt, z2, parseInt2, z3, str2, str));
            }
        }

        @JavascriptInterface
        public void adUnitsReady(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "adUnitsReady(" + str + ")");
            String d2 = com.ironsource.sdk.utils.f.d(new com.ironsource.sdk.data.d(str));
            com.ironsource.sdk.data.a aVar = new com.ironsource.sdk.data.a(str);
            if (!aVar.o()) {
                WebController.this.W1(str, false, "Num Of Ad Units Do Not Exist", null);
                return;
            }
            WebController.this.W1(str, true, null, null);
            String n2 = aVar.n();
            if (ISNEnums$ProductType.RewardedVideo.toString().equalsIgnoreCase(n2) && WebController.this.j2(n2)) {
                WebController.this.Z1(new w(aVar, d2));
            }
        }

        @JavascriptInterface
        public void adViewAPI(String str) {
            try {
                String str2 = WebController.this.a;
                com.ironsource.sdk.utils.d.d(str2, "adViewAPI(" + str + ")");
                WebController.this.N.c(new com.ironsource.sdk.data.d(str).toString(), new b0());
            } catch (Exception e2) {
                e2.printStackTrace();
                String str3 = WebController.this.a;
                com.ironsource.sdk.utils.d.d(str3, "adViewAPI failed with exception " + e2.getMessage());
            }
        }

        @JavascriptInterface
        public void bannerViewAPI(String str) {
            try {
                WebController.this.K.c(str);
            } catch (Exception e2) {
                e2.printStackTrace();
                String str2 = WebController.this.a;
                com.ironsource.sdk.utils.d.b(str2, "bannerViewAPI failed with exception " + e2.getMessage());
            }
        }

        @JavascriptInterface
        public void clearLastUpdateTimeData(String str) {
            try {
                ArrayList<String> a2 = com.ironsource.sdk.utils.b.e().a();
                com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(str);
                if (!a2.isEmpty()) {
                    dVar.h("removedAdsLastUpdateTime", a2.toString());
                }
                WebController.this.W1(dVar.toString(), true, null, null);
            } catch (Exception e2) {
                WebController.this.W1(str, false, e2.getMessage(), null);
                e2.printStackTrace();
            }
        }

        boolean d(String str) {
            if (TextUtils.isEmpty(str) || str.contains(TaskDetailBasePresenter.SCENE_LIST)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getString("testerABGroup").isEmpty()) {
                    return false;
                }
                return !jSONObject.getString("testFriendlyName").isEmpty();
            } catch (JSONException e2) {
                e2.printStackTrace();
                return false;
            }
        }

        @JavascriptInterface
        public void deleteFile(String str) {
            try {
                String str2 = WebController.this.a;
                com.ironsource.sdk.utils.d.d(str2, "deleteFile(" + str + ")");
                com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(str);
                String f2 = dVar.f("file");
                String f3 = dVar.f(PGEditResultActivity2.PATH);
                if (f3 != null && !TextUtils.isEmpty(f2)) {
                    ISNFile iSNFile = new ISNFile(com.ironsource.sdk.utils.c.a(WebController.this.A, f3), f2);
                    if (!iSNFile.exists()) {
                        WebController.this.W1(str, false, "File not exist", "1");
                        return;
                    }
                    WebController.this.W1(str, com.ironsource.sdk.utils.c.f(iSNFile), null, null);
                    return;
                }
                WebController.this.W1(str, false, "Missing parameters for file", "1");
            } catch (Exception e2) {
                WebController.this.W1(str, false, e2.getMessage(), null);
                e2.printStackTrace();
            }
        }

        @JavascriptInterface
        public void deleteFolder(String str) {
            try {
                String str2 = WebController.this.a;
                com.ironsource.sdk.utils.d.d(str2, "deleteFolder(" + str + ")");
                String f2 = new com.ironsource.sdk.data.d(str).f(PGEditResultActivity2.PATH);
                if (f2 == null) {
                    WebController.this.W1(str, false, "Missing parameters for file", "1");
                    return;
                }
                ISNFile iSNFile = new ISNFile(com.ironsource.sdk.utils.c.a(WebController.this.A, f2));
                if (!iSNFile.exists()) {
                    WebController.this.W1(str, false, "Folder not exist", "1");
                    return;
                }
                WebController.this.W1(str, com.ironsource.sdk.utils.c.h(iSNFile.getPath()), null, null);
            } catch (Exception e2) {
                WebController.this.W1(str, false, e2.getMessage(), null);
                e2.printStackTrace();
            }
        }

        @JavascriptInterface
        public void deviceDataAPI(String str) {
            try {
                String str2 = WebController.this.a;
                com.ironsource.sdk.utils.d.d(str2, "deviceDataAPI(" + str + ")");
                WebController.this.M.a(new com.ironsource.sdk.data.d(str).toString(), new b0());
            } catch (Exception e2) {
                e2.printStackTrace();
                String str3 = WebController.this.a;
                com.ironsource.sdk.utils.d.d(str3, "deviceDataAPI failed with exception " + e2.getMessage());
            }
        }

        @JavascriptInterface
        public void displayWebView(String str) {
            Intent intent;
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "displayWebView(" + str + ")");
            WebController.this.W1(str, true, null, null);
            com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(str);
            boolean booleanValue = ((Boolean) dVar.c("display")).booleanValue();
            String f2 = dVar.f("productType");
            boolean d2 = dVar.d("standaloneView");
            String f3 = dVar.f("adViewId");
            String d3 = com.ironsource.sdk.utils.f.d(dVar);
            boolean d4 = dVar.d("ctrWVPauseResume");
            if (booleanValue) {
                WebController.this.G = dVar.d("immersive");
                boolean d5 = dVar.d("activityThemeTranslucent");
                State A1 = WebController.this.A1();
                State state = State.Display;
                if (A1 == state) {
                    String str3 = WebController.this.a;
                    com.ironsource.sdk.utils.d.d(str3, "State: " + WebController.this.t);
                    return;
                }
                WebController.this.setState(state);
                String str4 = WebController.this.a;
                com.ironsource.sdk.utils.d.d(str4, "State: " + WebController.this.t);
                Context r1 = WebController.this.r1();
                String x1 = WebController.this.x1();
                int h2 = com.ironsource.environment.e.h(r1);
                if (d2) {
                    ControllerView controllerView = new ControllerView(r1);
                    controllerView.addView(WebController.this.s);
                    controllerView.l(WebController.this);
                    return;
                }
                if (d5) {
                    intent = new Intent(r1, InterstitialActivity.class);
                } else {
                    intent = new Intent(r1, ControllerActivity.class);
                }
                ISNEnums$ProductType iSNEnums$ProductType = ISNEnums$ProductType.RewardedVideo;
                if (iSNEnums$ProductType.toString().equalsIgnoreCase(f2)) {
                    if ("application".equals(x1)) {
                        x1 = com.ironsource.sdk.utils.f.K(com.ironsource.environment.e.c(r1));
                    }
                    intent.putExtra("productType", iSNEnums$ProductType.toString());
                    WebController.this.D.b(iSNEnums$ProductType.ordinal());
                    WebController.this.D.o(d3);
                    if (WebController.this.j2(iSNEnums$ProductType.toString())) {
                        WebController.this.v.G(iSNEnums$ProductType, d3);
                    }
                } else {
                    ISNEnums$ProductType iSNEnums$ProductType2 = ISNEnums$ProductType.OfferWall;
                    if (iSNEnums$ProductType2.toString().equalsIgnoreCase(f2)) {
                        intent.putExtra("productType", iSNEnums$ProductType2.toString());
                        WebController.this.D.b(iSNEnums$ProductType2.ordinal());
                    } else {
                        ISNEnums$ProductType iSNEnums$ProductType3 = ISNEnums$ProductType.Interstitial;
                        if (iSNEnums$ProductType3.toString().equalsIgnoreCase(f2)) {
                            if ("application".equals(x1)) {
                                x1 = com.ironsource.sdk.utils.f.K(com.ironsource.environment.e.c(r1));
                            }
                            intent.putExtra("productType", iSNEnums$ProductType3.toString());
                        }
                    }
                }
                if (f3 != null) {
                    intent.putExtra("adViewId", f3);
                }
                intent.putExtra("ctrWVPauseResume", d4);
                intent.setFlags(536870912);
                intent.putExtra("immersive", WebController.this.G);
                intent.putExtra("orientation_set_flag", x1);
                intent.putExtra("rotation_set_flag", h2);
                WebController webController = WebController.this;
                webController.f5730h = new p(webController.B1(f2), d3);
                r1.startActivity(intent);
                return;
            }
            WebController.this.setState(State.Gone);
            WebController.this.W0();
        }

        @JavascriptInterface
        public void fileSystemAPI(String str) {
            try {
                String str2 = WebController.this.a;
                com.ironsource.sdk.utils.d.d(str2, "fileSystemAPI(" + str + ")");
                WebController.this.O.h(new JSONObject(str), new b0());
            } catch (Exception e2) {
                e2.printStackTrace();
                String str3 = WebController.this.a;
                com.ironsource.sdk.utils.d.d(str3, "fileSystemAPI failed with exception " + e2.getMessage());
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x005c, code lost:
            if (android.text.TextUtils.isEmpty(r0) == false) goto L6;
         */
        @android.webkit.JavascriptInterface
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void getApplicationInfo(java.lang.String r5) {
            /*
                r4 = this;
                com.ironsource.sdk.controller.WebController r0 = com.ironsource.sdk.controller.WebController.this
                java.lang.String r0 = com.ironsource.sdk.controller.WebController.C0(r0)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getApplicationInfo("
                r1.append(r2)
                r1.append(r5)
                java.lang.String r2 = ")"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.ironsource.sdk.utils.d.d(r0, r1)
                com.ironsource.sdk.controller.WebController r0 = com.ironsource.sdk.controller.WebController.this
                java.lang.String r0 = com.ironsource.sdk.controller.WebController.H(r0, r5)
                com.ironsource.sdk.controller.WebController r1 = com.ironsource.sdk.controller.WebController.this
                java.lang.String r1 = com.ironsource.sdk.controller.WebController.I(r1, r5)
                com.ironsource.sdk.data.d r2 = new com.ironsource.sdk.data.d
                r2.<init>(r5)
                java.lang.String r5 = "productType"
                java.lang.String r5 = r2.f(r5)
                java.lang.String r2 = com.ironsource.sdk.utils.f.d(r2)
                com.ironsource.sdk.controller.WebController r3 = com.ironsource.sdk.controller.WebController.this
                java.lang.Object[] r5 = com.ironsource.sdk.controller.WebController.Q(r3, r5, r2)
                r2 = 0
                r2 = r5[r2]
                java.lang.String r2 = (java.lang.String) r2
                r3 = 1
                r5 = r5[r3]
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                boolean r5 = r5.booleanValue()
                if (r5 == 0) goto L58
                boolean r5 = android.text.TextUtils.isEmpty(r1)
                if (r5 != 0) goto L5f
                r0 = r1
                goto L60
            L58:
                boolean r5 = android.text.TextUtils.isEmpty(r0)
                if (r5 != 0) goto L5f
                goto L60
            L5f:
                r0 = 0
            L60:
                boolean r5 = android.text.TextUtils.isEmpty(r0)
                if (r5 != 0) goto L75
                com.ironsource.sdk.controller.WebController r5 = com.ironsource.sdk.controller.WebController.this
                java.lang.String r1 = "onGetApplicationInfoSuccess"
                java.lang.String r3 = "onGetApplicationInfoFail"
                java.lang.String r5 = com.ironsource.sdk.controller.WebController.K(r5, r0, r2, r1, r3)
                com.ironsource.sdk.controller.WebController r0 = com.ironsource.sdk.controller.WebController.this
                com.ironsource.sdk.controller.WebController.r0(r0, r5)
            L75:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.WebController.r.getApplicationInfo(java.lang.String):void");
        }

        @JavascriptInterface
        public void getCachedFilesMap(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "getCachedFilesMap(" + str + ")");
            String i1 = WebController.this.i1(str);
            if (TextUtils.isEmpty(i1)) {
                return;
            }
            com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(str);
            if (!dVar.a(PGEditResultActivity2.PATH)) {
                WebController.this.W1(str, false, "path key does not exist", null);
                return;
            }
            String str3 = (String) dVar.c(PGEditResultActivity2.PATH);
            if (!com.ironsource.sdk.utils.c.t(WebController.this.A, str3)) {
                WebController.this.W1(str, false, "path file does not exist on disk", null);
                return;
            }
            WebController.this.K1(WebController.this.n1(i1, com.ironsource.sdk.utils.c.k(WebController.this.A, str3), "onGetCachedFilesMapSuccess", "onGetCachedFilesMapFail"));
        }

        @JavascriptInterface
        public void getConnectivityInfo(String str) {
            String l1;
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "getConnectivityInfo(" + str + ")");
            com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(str);
            String f2 = dVar.f(WebController.e0);
            String f3 = dVar.f(WebController.f0);
            JSONObject jSONObject = new JSONObject();
            if (WebController.this.R != null) {
                jSONObject = WebController.this.R.e(WebController.this.getContext());
            }
            if (jSONObject.length() > 0) {
                l1 = WebController.this.l1(f2, jSONObject.toString());
            } else {
                l1 = WebController.this.l1(f3, WebController.this.S1("errMsg", "failed to retrieve connection info", null, null, null, null, null, null, null, false));
            }
            WebController.this.K1(l1);
        }

        @JavascriptInterface
        public void getControllerConfig(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "getControllerConfig(" + str + ")");
            String f2 = new com.ironsource.sdk.data.d(str).f(WebController.e0);
            if (TextUtils.isEmpty(f2)) {
                return;
            }
            JSONObject l2 = com.ironsource.sdk.utils.f.l();
            f(l2);
            WebController.this.K1(WebController.this.l1(f2, l2.toString()));
        }

        @JavascriptInterface
        public void getDemandSourceState(String str) {
            String h1;
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "getMediationState(" + str + ")");
            com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(str);
            String f2 = dVar.f("demandSourceName");
            String d2 = com.ironsource.sdk.utils.f.d(dVar);
            String f3 = dVar.f("productType");
            if (f3 == null || f2 == null) {
                return;
            }
            try {
                ISNEnums$ProductType s2 = com.ironsource.sdk.utils.f.s(f3);
                if (s2 != null) {
                    com.ironsource.sdk.data.b d3 = WebController.this.H.d(s2, d2);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("productType", f3);
                    jSONObject.put("demandSourceName", f2);
                    jSONObject.put("demandSourceId", d2);
                    if (d3 == null || d3.i(-1)) {
                        h1 = WebController.this.h1(str);
                    } else {
                        h1 = WebController.this.i1(str);
                        jSONObject.put("state", d3.h());
                    }
                    e(h1, jSONObject.toString());
                }
            } catch (Exception e2) {
                WebController.this.W1(str, false, e2.getMessage(), null);
                e2.printStackTrace();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0051, code lost:
            if (android.text.TextUtils.isEmpty(r0) == false) goto L6;
         */
        @android.webkit.JavascriptInterface
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void getDeviceStatus(java.lang.String r5) {
            /*
                r4 = this;
                com.ironsource.sdk.controller.WebController r0 = com.ironsource.sdk.controller.WebController.this
                java.lang.String r0 = com.ironsource.sdk.controller.WebController.C0(r0)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getDeviceStatus("
                r1.append(r2)
                r1.append(r5)
                java.lang.String r2 = ")"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.ironsource.sdk.utils.d.d(r0, r1)
                com.ironsource.sdk.controller.WebController r0 = com.ironsource.sdk.controller.WebController.this
                java.lang.String r0 = com.ironsource.sdk.controller.WebController.H(r0, r5)
                com.ironsource.sdk.controller.WebController r1 = com.ironsource.sdk.controller.WebController.this
                java.lang.String r5 = com.ironsource.sdk.controller.WebController.I(r1, r5)
                com.ironsource.sdk.controller.WebController r1 = com.ironsource.sdk.controller.WebController.this
                android.content.Context r2 = r1.getContext()
                java.lang.Object[] r1 = com.ironsource.sdk.controller.WebController.J(r1, r2)
                r2 = 0
                r2 = r1[r2]
                java.lang.String r2 = (java.lang.String) r2
                r3 = 1
                r1 = r1[r3]
                java.lang.Boolean r1 = (java.lang.Boolean) r1
                boolean r1 = r1.booleanValue()
                if (r1 == 0) goto L4d
                boolean r0 = android.text.TextUtils.isEmpty(r5)
                if (r0 != 0) goto L54
                r0 = r5
                goto L55
            L4d:
                boolean r5 = android.text.TextUtils.isEmpty(r0)
                if (r5 != 0) goto L54
                goto L55
            L54:
                r0 = 0
            L55:
                boolean r5 = android.text.TextUtils.isEmpty(r0)
                if (r5 != 0) goto L6a
                com.ironsource.sdk.controller.WebController r5 = com.ironsource.sdk.controller.WebController.this
                java.lang.String r1 = "onGetDeviceStatusSuccess"
                java.lang.String r3 = "onGetDeviceStatusFail"
                java.lang.String r5 = com.ironsource.sdk.controller.WebController.K(r5, r0, r2, r1, r3)
                com.ironsource.sdk.controller.WebController r0 = com.ironsource.sdk.controller.WebController.this
                com.ironsource.sdk.controller.WebController.r0(r0, r5)
            L6a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.WebController.r.getDeviceStatus(java.lang.String):void");
        }

        @JavascriptInterface
        public void getDeviceVolume(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "getDeviceVolume(" + str + ")");
            try {
                float g2 = com.ironsource.sdk.utils.a.h(WebController.this.r1()).g(WebController.this.r1());
                com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(str);
                dVar.h("deviceVolume", String.valueOf(g2));
                WebController.this.W1(dVar.toString(), true, null, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @JavascriptInterface
        public void getOrientation(String str) {
            Context r1 = WebController.this.r1();
            if (r1 != null) {
                String i1 = WebController.this.i1(str);
                String jSONObject = com.ironsource.sdk.utils.f.r(r1).toString();
                if (TextUtils.isEmpty(i1)) {
                    return;
                }
                WebController.this.K1(WebController.this.n1(i1, jSONObject, "onGetOrientationSuccess", "onGetOrientationFail"));
            }
        }

        @JavascriptInterface
        public void getUserData(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "getUserData(" + str + ")");
            com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(str);
            if (!dVar.a("key")) {
                WebController.this.W1(str, false, "key does not exist", null);
                return;
            }
            String i1 = WebController.this.i1(str);
            String f2 = dVar.f("key");
            WebController.this.K1(WebController.this.l1(i1, WebController.this.S1(f2, com.ironsource.sdk.utils.b.e().g(f2), null, null, null, null, null, null, null, false)));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void h(String str) {
            WebController.this.K1(WebController.this.n1("unauthorizedMessage", str, null, null));
        }

        @JavascriptInterface
        public void iabTokenAPI(String str) {
            try {
                String str2 = WebController.this.a;
                com.ironsource.sdk.utils.d.d(str2, "iabTokenAPI(" + str + ")");
                WebController.this.L.a(new com.ironsource.sdk.data.d(str).toString(), new b0());
            } catch (Exception e2) {
                e2.printStackTrace();
                String str3 = WebController.this.a;
                com.ironsource.sdk.utils.d.d(str3, "iabTokenAPI failed with exception " + e2.getMessage());
            }
        }

        @JavascriptInterface
        public void initController(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "initController(" + str + ")");
            com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(str);
            CountDownTimer countDownTimer = WebController.this.f5733k;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                WebController.this.f5733k = null;
            }
            if (dVar.a("stage")) {
                String f2 = dVar.f("stage");
                if ("ready".equalsIgnoreCase(f2)) {
                    WebController.this.f5729g = true;
                    WebController.this.Q.g();
                } else if ("loaded".equalsIgnoreCase(f2)) {
                    WebController.this.Q.s();
                } else if (!"failed".equalsIgnoreCase(f2)) {
                    com.ironsource.sdk.utils.d.d(WebController.this.a, "No STAGE mentioned! should not get here!");
                } else {
                    String f3 = dVar.f("errMsg");
                    com.ironsource.sdk.controller.e eVar = WebController.this.Q;
                    eVar.l("controller js failed to initialize : " + f3);
                }
            }
        }

        @JavascriptInterface
        public void omidAPI(String str) {
            WebController.this.Z1(new s(str));
        }

        @JavascriptInterface
        public void onAdWindowsClosed(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "onAdWindowsClosed(" + str + ")");
            WebController.this.D.a();
            WebController.this.D.o(null);
            WebController.this.f5730h = null;
            com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(str);
            String f2 = dVar.f("productType");
            String d2 = com.ironsource.sdk.utils.f.d(dVar);
            ISNEnums$ProductType B1 = WebController.this.B1(f2);
            String str3 = WebController.this.b;
            Log.d(str3, "onAdClosed() with type " + B1);
            if (WebController.this.j2(f2)) {
                WebController.this.P1(B1, d2);
            }
        }

        @JavascriptInterface
        public void onGetApplicationInfoFail(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "onGetApplicationInfoFail(" + str + ")");
            WebController.this.W1(str, true, null, null);
            WebController.this.k2("onGetApplicationInfoFail", str);
        }

        @JavascriptInterface
        public void onGetApplicationInfoSuccess(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "onGetApplicationInfoSuccess(" + str + ")");
            WebController.this.W1(str, true, null, null);
            WebController.this.k2("onGetApplicationInfoSuccess", str);
        }

        @JavascriptInterface
        public void onGetCachedFilesMapFail(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "onGetCachedFilesMapFail(" + str + ")");
            WebController.this.W1(str, true, null, null);
            WebController.this.k2("onGetCachedFilesMapFail", str);
        }

        @JavascriptInterface
        public void onGetCachedFilesMapSuccess(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "onGetCachedFilesMapSuccess(" + str + ")");
            WebController.this.W1(str, true, null, null);
            WebController.this.k2("onGetCachedFilesMapSuccess", str);
        }

        @JavascriptInterface
        public void onGetDeviceStatusFail(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "onGetDeviceStatusFail(" + str + ")");
            WebController.this.W1(str, true, null, null);
            WebController.this.k2("onGetDeviceStatusFail", str);
        }

        @JavascriptInterface
        public void onGetDeviceStatusSuccess(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "onGetDeviceStatusSuccess(" + str + ")");
            WebController.this.W1(str, true, null, null);
            WebController.this.k2("onGetDeviceStatusSuccess", str);
        }

        @JavascriptInterface
        public void onGetUserCreditsFail(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "onGetUserCreditsFail(" + str + ")");
            String f2 = new com.ironsource.sdk.data.d(str).f("errMsg");
            if (WebController.this.j2(ISNEnums$ProductType.OfferWall.toString())) {
                WebController.this.Z1(new q(f2));
            }
            WebController.this.W1(str, true, null, null);
            WebController.this.k2("onGetUserCreditsFail", str);
        }

        @JavascriptInterface
        public void onInitBannerFail(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "onInitBannerFail(" + str + ")");
            com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(str);
            String f2 = dVar.f("errMsg");
            String d2 = com.ironsource.sdk.utils.f.d(dVar);
            if (TextUtils.isEmpty(d2)) {
                com.ironsource.sdk.utils.d.d(WebController.this.a, "onInitBannerFail failed with no demand source");
                return;
            }
            com.ironsource.sdk.controller.h hVar = WebController.this.H;
            ISNEnums$ProductType iSNEnums$ProductType = ISNEnums$ProductType.Banner;
            com.ironsource.sdk.data.b d3 = hVar.d(iSNEnums$ProductType, d2);
            if (d3 != null) {
                d3.l(3);
            }
            if (WebController.this.j2(iSNEnums$ProductType.toString())) {
                WebController.this.Z1(new n(f2, d2));
            }
            WebController.this.W1(str, true, null, null);
            WebController.this.k2("onInitBannerFail", str);
        }

        @JavascriptInterface
        public void onInitBannerSuccess(String str) {
            com.ironsource.sdk.utils.d.d(WebController.this.a, "onInitBannerSuccess()");
            WebController.this.k2("onInitBannerSuccess", "true");
            String d2 = com.ironsource.sdk.utils.f.d(new com.ironsource.sdk.data.d(str));
            if (TextUtils.isEmpty(d2)) {
                com.ironsource.sdk.utils.d.d(WebController.this.a, "onInitBannerSuccess failed with no demand source");
            } else if (WebController.this.j2(ISNEnums$ProductType.Banner.toString())) {
                WebController.this.Z1(new m(d2));
            }
        }

        @JavascriptInterface
        public void onInitInterstitialFail(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "onInitInterstitialFail(" + str + ")");
            com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(str);
            String f2 = dVar.f("errMsg");
            String d2 = com.ironsource.sdk.utils.f.d(dVar);
            if (TextUtils.isEmpty(d2)) {
                com.ironsource.sdk.utils.d.d(WebController.this.a, "onInitInterstitialSuccess failed with no demand source");
                return;
            }
            com.ironsource.sdk.controller.h hVar = WebController.this.H;
            ISNEnums$ProductType iSNEnums$ProductType = ISNEnums$ProductType.Interstitial;
            com.ironsource.sdk.data.b d3 = hVar.d(iSNEnums$ProductType, d2);
            if (d3 != null) {
                d3.l(3);
            }
            if (WebController.this.j2(iSNEnums$ProductType.toString())) {
                WebController.this.Z1(new d(f2, d2));
            }
            WebController.this.W1(str, true, null, null);
            WebController.this.k2("onInitInterstitialFail", str);
        }

        @JavascriptInterface
        public void onInitInterstitialSuccess(String str) {
            com.ironsource.sdk.utils.d.d(WebController.this.a, "onInitInterstitialSuccess()");
            WebController.this.k2("onInitInterstitialSuccess", "true");
            String d2 = com.ironsource.sdk.utils.f.d(new com.ironsource.sdk.data.d(str));
            if (TextUtils.isEmpty(d2)) {
                com.ironsource.sdk.utils.d.d(WebController.this.a, "onInitInterstitialSuccess failed with no demand source");
            } else if (WebController.this.j2(ISNEnums$ProductType.Interstitial.toString())) {
                WebController.this.Z1(new c(d2));
            }
        }

        @JavascriptInterface
        public void onInitOfferWallFail(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "onInitOfferWallFail(" + str + ")");
            WebController.this.D.s(false);
            String f2 = new com.ironsource.sdk.data.d(str).f("errMsg");
            if (WebController.this.D.n()) {
                WebController.this.D.t(false);
                if (WebController.this.j2(ISNEnums$ProductType.OfferWall.toString())) {
                    WebController.this.Z1(new h(f2));
                }
            }
            WebController.this.W1(str, true, null, null);
            WebController.this.k2("onInitOfferWallFail", str);
        }

        @JavascriptInterface
        public void onInitOfferWallSuccess(String str) {
            WebController.this.k2("onInitOfferWallSuccess", "true");
            WebController.this.D.s(true);
            if (WebController.this.D.n()) {
                WebController.this.D.t(false);
                if (WebController.this.j2(ISNEnums$ProductType.OfferWall.toString())) {
                    WebController.this.Z1(new g());
                }
            }
        }

        @JavascriptInterface
        public void onInitRewardedVideoFail(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "onInitRewardedVideoFail(" + str + ")");
            com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(str);
            String f2 = dVar.f("errMsg");
            String d2 = com.ironsource.sdk.utils.f.d(dVar);
            com.ironsource.sdk.controller.h hVar = WebController.this.H;
            ISNEnums$ProductType iSNEnums$ProductType = ISNEnums$ProductType.RewardedVideo;
            com.ironsource.sdk.data.b d3 = hVar.d(iSNEnums$ProductType, d2);
            if (d3 != null) {
                d3.l(3);
            }
            if (WebController.this.j2(iSNEnums$ProductType.toString())) {
                WebController.this.Z1(new z(f2, d2));
            }
            WebController.this.W1(str, true, null, null);
            WebController.this.k2("onInitRewardedVideoFail", str);
        }

        @JavascriptInterface
        public void onLoadBannerFail(String str) {
            com.ironsource.sdk.utils.d.d(WebController.this.a, "onLoadBannerFail()");
            com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(str);
            String f2 = dVar.f("errMsg");
            String d2 = com.ironsource.sdk.utils.f.d(dVar);
            WebController.this.W1(str, true, null, null);
            if (!TextUtils.isEmpty(d2) && WebController.this.j2(ISNEnums$ProductType.Banner.toString())) {
                WebController.this.Z1(new p(f2, d2));
            }
        }

        @JavascriptInterface
        public void onLoadBannerSuccess(String str) {
            com.ironsource.sdk.utils.d.d(WebController.this.a, "onLoadBannerSuccess()");
            String d2 = com.ironsource.sdk.utils.f.d(new com.ironsource.sdk.data.d(str));
            WebController.this.W1(str, true, null, null);
            if (WebController.this.j2(ISNEnums$ProductType.Banner.toString())) {
                WebController.this.Z1(new o(d2));
            }
        }

        @JavascriptInterface
        public void onLoadInterstitialFail(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "onLoadInterstitialFail(" + str + ")");
            com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(str);
            String f2 = dVar.f("errMsg");
            String d2 = com.ironsource.sdk.utils.f.d(dVar);
            WebController.this.W1(str, true, null, null);
            if (TextUtils.isEmpty(d2)) {
                return;
            }
            i(d2, false);
            if (WebController.this.j2(ISNEnums$ProductType.Interstitial.toString())) {
                WebController.this.Z1(new j(f2, d2));
            }
            WebController.this.k2("onLoadInterstitialFail", "true");
        }

        @JavascriptInterface
        public void onLoadInterstitialSuccess(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "onLoadInterstitialSuccess(" + str + ")");
            String d2 = com.ironsource.sdk.utils.f.d(new com.ironsource.sdk.data.d(str));
            i(d2, true);
            WebController.this.W1(str, true, null, null);
            if (WebController.this.j2(ISNEnums$ProductType.Interstitial.toString())) {
                WebController.this.Z1(new i(d2));
            }
            WebController.this.k2("onLoadInterstitialSuccess", "true");
        }

        @JavascriptInterface
        public void onOfferWallGeneric(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "onOfferWallGeneric(" + str + ")");
        }

        @JavascriptInterface
        public void onShowInterstitialFail(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "onShowInterstitialFail(" + str + ")");
            com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(str);
            String f2 = dVar.f("errMsg");
            String d2 = com.ironsource.sdk.utils.f.d(dVar);
            WebController.this.W1(str, true, null, null);
            if (TextUtils.isEmpty(d2)) {
                return;
            }
            i(d2, false);
            if (WebController.this.j2(ISNEnums$ProductType.Interstitial.toString())) {
                WebController.this.Z1(new l(f2, d2));
            }
            WebController.this.k2("onShowInterstitialFail", str);
        }

        @JavascriptInterface
        public void onShowInterstitialSuccess(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "onShowInterstitialSuccess(" + str + ")");
            WebController.this.W1(str, true, null, null);
            String d2 = com.ironsource.sdk.utils.f.d(new com.ironsource.sdk.data.d(str));
            if (TextUtils.isEmpty(d2)) {
                com.ironsource.sdk.utils.d.d(WebController.this.a, "onShowInterstitialSuccess called with no demand");
                return;
            }
            AdUnitsState adUnitsState = WebController.this.D;
            ISNEnums$ProductType iSNEnums$ProductType = ISNEnums$ProductType.Interstitial;
            adUnitsState.b(iSNEnums$ProductType.ordinal());
            WebController.this.D.o(d2);
            if (WebController.this.j2(iSNEnums$ProductType.toString())) {
                WebController.this.Z1(new f(d2));
                WebController.this.k2("onShowInterstitialSuccess", str);
            }
            i(d2, false);
        }

        @JavascriptInterface
        public void onShowOfferWallFail(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "onShowOfferWallFail(" + str + ")");
            String f2 = new com.ironsource.sdk.data.d(str).f("errMsg");
            if (WebController.this.j2(ISNEnums$ProductType.OfferWall.toString())) {
                WebController.this.Z1(new b(f2));
            }
            WebController.this.W1(str, true, null, null);
            WebController.this.k2("onShowOfferWallFail", str);
        }

        @JavascriptInterface
        public void onShowOfferWallSuccess(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "onShowOfferWallSuccess(" + str + ")");
            AdUnitsState adUnitsState = WebController.this.D;
            ISNEnums$ProductType iSNEnums$ProductType = ISNEnums$ProductType.OfferWall;
            adUnitsState.b(iSNEnums$ProductType.ordinal());
            String v2 = com.ironsource.sdk.utils.f.v(str, "placementId");
            if (WebController.this.j2(iSNEnums$ProductType.toString())) {
                WebController.this.Z1(new a(v2));
            }
            WebController.this.W1(str, true, null, null);
            WebController.this.k2("onShowOfferWallSuccess", str);
        }

        @JavascriptInterface
        public void onShowRewardedVideoFail(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "onShowRewardedVideoFail(" + str + ")");
            com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(str);
            String f2 = dVar.f("errMsg");
            String d2 = com.ironsource.sdk.utils.f.d(dVar);
            if (WebController.this.j2(ISNEnums$ProductType.RewardedVideo.toString())) {
                WebController.this.Z1(new a0(f2, d2));
            }
            WebController.this.W1(str, true, null, null);
            WebController.this.k2("onShowRewardedVideoFail", str);
        }

        @JavascriptInterface
        public void onShowRewardedVideoSuccess(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "onShowRewardedVideoSuccess(" + str + ")");
            WebController.this.W1(str, true, null, null);
            WebController.this.k2("onShowRewardedVideoSuccess", str);
        }

        @JavascriptInterface
        public void onVideoStatusChanged(String str) {
            String str2 = WebController.this.a;
            Log.d(str2, "onVideoStatusChanged(" + str + ")");
            com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(str);
            String f2 = dVar.f("productType");
            if (WebController.this.C == null || TextUtils.isEmpty(f2)) {
                return;
            }
            String f3 = dVar.f("status");
            if ("started".equalsIgnoreCase(f3)) {
                WebController.this.C.a();
            } else if (TJAdUnitConstants.String.VIDEO_PAUSED.equalsIgnoreCase(f3)) {
                WebController.this.C.d();
            } else if (TJAdUnitConstants.String.VIDEO_PLAYING.equalsIgnoreCase(f3)) {
                WebController.this.C.h();
            } else if ("ended".equalsIgnoreCase(f3)) {
                WebController.this.C.e();
            } else if (TJAdUnitConstants.String.VIDEO_STOPPED.equalsIgnoreCase(f3)) {
                WebController.this.C.g();
            } else {
                String str3 = WebController.this.a;
                com.ironsource.sdk.utils.d.d(str3, "onVideoStatusChanged: unknown status: " + f3);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0077, code lost:
            if (r5 == 1) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0079, code lost:
            if (r5 == 2) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x007c, code lost:
            r0 = new android.content.Intent(r3, com.ironsource.sdk.controller.OpenUrlActivity.class);
            r0.putExtra(com.ironsource.sdk.controller.WebController.W, r1);
            r0.putExtra(com.ironsource.sdk.controller.WebController.V, true);
            r0.putExtra(com.ironsource.sdk.controller.WebController.d0, true);
            r3.startActivity(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0096, code lost:
            r0 = new android.content.Intent(r3, com.ironsource.sdk.controller.OpenUrlActivity.class);
            r0.putExtra(com.ironsource.sdk.controller.WebController.W, r1);
            r0.putExtra(com.ironsource.sdk.controller.WebController.d0, true);
            r0.putExtra("immersive", r10.a.G);
            r3.startActivity(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        @android.webkit.JavascriptInterface
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void openUrl(java.lang.String r11) {
            /*
                r10 = this;
                com.ironsource.sdk.controller.WebController r0 = com.ironsource.sdk.controller.WebController.this
                java.lang.String r0 = com.ironsource.sdk.controller.WebController.C0(r0)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "openUrl("
                r1.append(r2)
                r1.append(r11)
                java.lang.String r2 = ")"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.ironsource.sdk.utils.d.d(r0, r1)
                com.ironsource.sdk.data.d r0 = new com.ironsource.sdk.data.d
                r0.<init>(r11)
                java.lang.String r1 = "url"
                java.lang.String r1 = r0.f(r1)
                java.lang.String r2 = "method"
                java.lang.String r2 = r0.f(r2)
                java.lang.String r3 = "package_name"
                java.lang.String r0 = r0.f(r3)
                com.ironsource.sdk.controller.WebController r3 = com.ironsource.sdk.controller.WebController.this
                android.content.Context r3 = r3.r1()
                r4 = 0
                java.lang.String r2 = r2.toLowerCase()     // Catch: java.lang.Exception -> Lba
                r5 = -1
                int r6 = r2.hashCode()     // Catch: java.lang.Exception -> Lba
                r7 = -1455867212(0xffffffffa9393ab4, float:-4.112917E-14)
                r8 = 2
                r9 = 1
                if (r6 == r7) goto L6c
                r7 = 109770977(0x68af8e1, float:5.2275525E-35)
                if (r6 == r7) goto L62
                r7 = 1224424441(0x48fb3bf9, float:514527.78)
                if (r6 == r7) goto L58
                goto L75
            L58:
                java.lang.String r6 = "webview"
                boolean r2 = r2.equals(r6)     // Catch: java.lang.Exception -> Lba
                if (r2 == 0) goto L75
                r5 = 1
                goto L75
            L62:
                java.lang.String r6 = "store"
                boolean r2 = r2.equals(r6)     // Catch: java.lang.Exception -> Lba
                if (r2 == 0) goto L75
                r5 = 2
                goto L75
            L6c:
                java.lang.String r6 = "external_browser"
                boolean r2 = r2.equals(r6)     // Catch: java.lang.Exception -> Lba
                if (r2 == 0) goto L75
                r5 = 0
            L75:
                if (r5 == 0) goto Lb6
                if (r5 == r9) goto L96
                if (r5 == r8) goto L7c
                goto Lc8
            L7c:
                android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Exception -> Lba
                java.lang.Class<com.ironsource.sdk.controller.OpenUrlActivity> r2 = com.ironsource.sdk.controller.OpenUrlActivity.class
                r0.<init>(r3, r2)     // Catch: java.lang.Exception -> Lba
                java.lang.String r2 = com.ironsource.sdk.controller.WebController.W     // Catch: java.lang.Exception -> Lba
                r0.putExtra(r2, r1)     // Catch: java.lang.Exception -> Lba
                java.lang.String r1 = com.ironsource.sdk.controller.WebController.V     // Catch: java.lang.Exception -> Lba
                r0.putExtra(r1, r9)     // Catch: java.lang.Exception -> Lba
                java.lang.String r1 = com.ironsource.sdk.controller.WebController.d0     // Catch: java.lang.Exception -> Lba
                r0.putExtra(r1, r9)     // Catch: java.lang.Exception -> Lba
                r3.startActivity(r0)     // Catch: java.lang.Exception -> Lba
                goto Lc8
            L96:
                android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Exception -> Lba
                java.lang.Class<com.ironsource.sdk.controller.OpenUrlActivity> r2 = com.ironsource.sdk.controller.OpenUrlActivity.class
                r0.<init>(r3, r2)     // Catch: java.lang.Exception -> Lba
                java.lang.String r2 = com.ironsource.sdk.controller.WebController.W     // Catch: java.lang.Exception -> Lba
                r0.putExtra(r2, r1)     // Catch: java.lang.Exception -> Lba
                java.lang.String r1 = com.ironsource.sdk.controller.WebController.d0     // Catch: java.lang.Exception -> Lba
                r0.putExtra(r1, r9)     // Catch: java.lang.Exception -> Lba
                java.lang.String r1 = "immersive"
                com.ironsource.sdk.controller.WebController r2 = com.ironsource.sdk.controller.WebController.this     // Catch: java.lang.Exception -> Lba
                boolean r2 = com.ironsource.sdk.controller.WebController.Z(r2)     // Catch: java.lang.Exception -> Lba
                r0.putExtra(r1, r2)     // Catch: java.lang.Exception -> Lba
                r3.startActivity(r0)     // Catch: java.lang.Exception -> Lba
                goto Lc8
            Lb6:
                com.ironsource.environment.k.b(r3, r1, r0)     // Catch: java.lang.Exception -> Lba
                goto Lc8
            Lba:
                r0 = move-exception
                com.ironsource.sdk.controller.WebController r1 = com.ironsource.sdk.controller.WebController.this
                java.lang.String r2 = r0.getMessage()
                r3 = 0
                com.ironsource.sdk.controller.WebController.R(r1, r11, r4, r2, r3)
                r0.printStackTrace()
            Lc8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.WebController.r.openUrl(java.lang.String):void");
        }

        @JavascriptInterface
        public void pauseControllerWebview() {
            WebController.this.Z1(new t());
        }

        @JavascriptInterface
        public void permissionsAPI(String str) {
            try {
                String str2 = WebController.this.a;
                com.ironsource.sdk.utils.d.d(str2, "permissionsAPI(" + str + ")");
                WebController.this.J.a(new com.ironsource.sdk.data.d(str).toString(), new b0());
            } catch (Exception e2) {
                e2.printStackTrace();
                String str3 = WebController.this.a;
                com.ironsource.sdk.utils.d.d(str3, "permissionsAPI failed with exception " + e2.getMessage());
            }
        }

        @JavascriptInterface
        public void postAdEventNotification(String str) {
            try {
                String str2 = WebController.this.a;
                com.ironsource.sdk.utils.d.d(str2, "postAdEventNotification(" + str + ")");
                com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(str);
                String f2 = dVar.f("eventName");
                if (TextUtils.isEmpty(f2)) {
                    WebController.this.W1(str, false, "eventName does not exist", null);
                    return;
                }
                String f3 = dVar.f("dsName");
                String d2 = com.ironsource.sdk.utils.f.d(dVar);
                String str3 = !TextUtils.isEmpty(d2) ? d2 : f3;
                JSONObject jSONObject = (JSONObject) dVar.c("extData");
                String f4 = dVar.f("productType");
                ISNEnums$ProductType B1 = WebController.this.B1(f4);
                if (WebController.this.j2(f4)) {
                    String i1 = WebController.this.i1(str);
                    if (!TextUtils.isEmpty(i1)) {
                        WebController.this.K1(WebController.this.n1(i1, WebController.this.S1("productType", f4, "eventName", f2, "demandSourceName", f3, "demandSourceId", str3, null, false), "postAdEventNotificationSuccess", "postAdEventNotificationFail"));
                    }
                    WebController.this.Z1(new RunnableC0213r(B1, str3, f2, jSONObject));
                    return;
                }
                WebController.this.W1(str, false, "productType does not exist", null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @JavascriptInterface
        public void removeCloseEventHandler(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "removeCloseEventHandler(" + str + ")");
            if (WebController.this.f5732j != null) {
                WebController.this.f5732j.cancel();
            }
            WebController.this.f5731i = true;
        }

        @JavascriptInterface
        public void removeMessagingInterface(String str) {
            WebController.this.Z1(new u());
        }

        @JavascriptInterface
        public void resumeControllerWebview() {
            WebController.this.Z1(new k());
        }

        @JavascriptInterface
        public void saveFile(String str) {
            try {
                String str2 = WebController.this.a;
                com.ironsource.sdk.utils.d.d(str2, "saveFile(" + str + ")");
                com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(str);
                String f2 = dVar.f(PGEditResultActivity2.PATH);
                String f3 = dVar.f("file");
                if (TextUtils.isEmpty(f3)) {
                    WebController.this.W1(str, false, "Missing parameters for file", "1");
                    return;
                }
                ISNFile iSNFile = new ISNFile(com.ironsource.sdk.utils.c.a(WebController.this.A, f2), com.ironsource.sdk.utils.f.n(f3));
                if (com.ironsource.environment.e.j(WebController.this.A) <= 0) {
                    WebController.this.W1(str, false, "no_disk_space", null);
                } else if (!com.ironsource.sdk.utils.f.w()) {
                    WebController.this.W1(str, false, "sotrage_unavailable", null);
                } else if (iSNFile.exists()) {
                    WebController.this.W1(str, false, "file_already_exist", null);
                } else if (!d.e.c.a.f(WebController.this.getContext())) {
                    WebController.this.W1(str, false, "no_network_connection", null);
                } else {
                    WebController.this.W1(str, true, null, null);
                    WebController.this.f5728f.b(iSNFile, f3);
                }
            } catch (Exception e2) {
                WebController.this.W1(str, false, e2.getMessage(), null);
                e2.printStackTrace();
            }
        }

        @JavascriptInterface
        public void setBackButtonState(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "setBackButtonState(" + str + ")");
            com.ironsource.sdk.utils.b.e().i(new com.ironsource.sdk.data.d(str).f("state"));
        }

        @JavascriptInterface
        public void setForceClose(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "setForceClose(" + str + ")");
            com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(str);
            String f2 = dVar.f("width");
            String f3 = dVar.f("height");
            WebController.this.f5734l = Integer.parseInt(f2);
            WebController.this.m = Integer.parseInt(f3);
            WebController.this.n = dVar.f("position");
        }

        @JavascriptInterface
        public void setMixedContentAlwaysAllow(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "setMixedContentAlwaysAllow(" + str + ")");
            WebController.this.Z1(new v());
        }

        @JavascriptInterface
        public void setOrientation(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "setOrientation(" + str + ")");
            String f2 = new com.ironsource.sdk.data.d(str).f("orientation");
            WebController.this.setOrientationState(f2);
            if (WebController.this.T != null) {
                WebController.this.T.f(f2, com.ironsource.environment.e.h(WebController.this.getContext()));
            }
        }

        @JavascriptInterface
        public void setStoreSearchKeys(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "setStoreSearchKeys(" + str + ")");
            com.ironsource.sdk.utils.b.e().l(str);
        }

        @JavascriptInterface
        public void setUserData(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "setUserData(" + str + ")");
            com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(str);
            if (!dVar.a("key")) {
                WebController.this.W1(str, false, "key does not exist", null);
            } else if (!dVar.a(FirebaseAnalytics.Param.VALUE)) {
                WebController.this.W1(str, false, "value does not exist", null);
            } else {
                String f2 = dVar.f("key");
                String f3 = dVar.f(FirebaseAnalytics.Param.VALUE);
                if (com.ironsource.sdk.utils.b.e().m(f2, f3)) {
                    WebController.this.K1(WebController.this.l1(WebController.this.i1(str), WebController.this.S1(f2, f3, null, null, null, null, null, null, null, false)));
                    return;
                }
                WebController.this.W1(str, false, "SetUserData failed writing to shared preferences", null);
            }
        }

        @JavascriptInterface
        public void setWebviewBackgroundColor(String str) {
            String str2 = WebController.this.a;
            com.ironsource.sdk.utils.d.d(str2, "setWebviewBackgroundColor(" + str + ")");
            WebController.this.h2(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface s {
        void a(String str, ISNEnums$ProductType iSNEnums$ProductType, com.ironsource.sdk.data.b bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class t {
        String a;

        t() {
        }
    }

    /* loaded from: classes2.dex */
    private class u implements View.OnTouchListener {

        /* loaded from: classes2.dex */
        class a extends CountDownTimer {
            a(long j2, long j3) {
                super(j2, j3);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                com.ironsource.sdk.utils.d.d(WebController.this.a, "Close Event Timer Finish");
                if (WebController.this.f5731i) {
                    WebController.this.f5731i = false;
                } else {
                    WebController.this.f1(TJAdUnitConstants.String.FORCE_CLOSE);
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                String str = WebController.this.a;
                com.ironsource.sdk.utils.d.d(str, "Close Event Timer Tick " + j2);
            }
        }

        private u() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                String str = WebController.this.a;
                StringBuilder sb = new StringBuilder();
                sb.append("X:");
                int i2 = (int) x;
                sb.append(i2);
                sb.append(" Y:");
                int i3 = (int) y;
                sb.append(i3);
                com.ironsource.sdk.utils.d.d(str, sb.toString());
                int w = com.ironsource.environment.e.w();
                int m = com.ironsource.environment.e.m();
                String str2 = WebController.this.a;
                com.ironsource.sdk.utils.d.d(str2, "Width:" + w + " Height:" + m);
                int b = com.ironsource.sdk.utils.f.b((long) WebController.this.f5734l);
                int b2 = com.ironsource.sdk.utils.f.b((long) WebController.this.m);
                if ("top-right".equalsIgnoreCase(WebController.this.n)) {
                    i2 = w - i2;
                } else if (!"top-left".equalsIgnoreCase(WebController.this.n)) {
                    if ("bottom-right".equalsIgnoreCase(WebController.this.n)) {
                        i2 = w - i2;
                    } else if (!"bottom-left".equalsIgnoreCase(WebController.this.n)) {
                        i2 = 0;
                        i3 = 0;
                    }
                    i3 = m - i3;
                }
                if (i2 <= b && i3 <= b2) {
                    WebController.this.f5731i = false;
                    if (WebController.this.f5732j != null) {
                        WebController.this.f5732j.cancel();
                    }
                    WebController.this.f5732j = new a(2000L, 500L).start();
                }
            }
            return false;
        }

        /* synthetic */ u(WebController webController, g gVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    private class v extends WebViewClient {
        private v() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            com.ironsource.sdk.utils.d.d("onPageFinished", str);
            if (str.contains("adUnit") || str.contains("index.html")) {
                WebController.this.R1();
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            com.ironsource.sdk.utils.d.d("onPageStarted", str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            com.ironsource.sdk.utils.d.d("onReceivedError", str2 + " " + str);
            if (str2.contains("mobileController.html") && WebController.this.Q != null) {
                com.ironsource.sdk.controller.e eVar = WebController.this.Q;
                eVar.l("controller html - web-view receivedError on loading - " + str + " (errorCode: " + i2 + ")");
            }
            super.onReceivedError(webView, i2, str, str2);
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(26)
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            String str = WebController.this.a;
            Log.e(str, "Chromium process crashed - detail.didCrash(): " + renderProcessGoneDetail.didCrash());
            String str2 = renderProcessGoneDetail.didCrash() ? "Render process was observed to crash" : "Render process was killed by the system";
            if (WebController.this.Q != null) {
                WebController.this.Q.w(str2);
            }
            WebController.this.F1();
            return true;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            boolean z;
            com.ironsource.sdk.utils.d.d("shouldInterceptRequest", str);
            try {
                z = new URL(str).getFile().contains("mraid.js");
            } catch (MalformedURLException unused) {
                z = false;
            }
            if (z) {
                String str2 = InspirePublishFragment.FILE_HEADER + WebController.this.A + File.separator + "mraid.js";
                try {
                    new FileInputStream(new File(str2));
                    return new WebResourceResponse("text/javascript", "UTF-8", getClass().getResourceAsStream(str2));
                } catch (FileNotFoundException unused2) {
                }
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            com.ironsource.sdk.utils.d.d("shouldOverrideUrlLoading", str);
            try {
                if (WebController.this.E1(str)) {
                    WebController.this.L1();
                    return true;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        /* synthetic */ v(WebController webController, g gVar) {
            this();
        }
    }

    public WebController(Context context, com.ironsource.sdk.controller.h hVar, com.ironsource.sdk.controller.c cVar, com.ironsource.sdk.controller.e eVar) {
        super(context);
        this.a = WebController.class.getSimpleName();
        this.b = "IronSource";
        this.f5734l = 50;
        this.m = 50;
        this.n = "top-right";
        this.z = null;
        this.E = new Object();
        this.G = false;
        com.ironsource.sdk.utils.d.d(this.a, "C'tor");
        this.S = cVar;
        this.Q = eVar;
        this.A = com.ironsource.sdk.utils.c.p(context);
        this.H = hVar;
        I1(context);
        this.D = new AdUnitsState();
        d.e.d.o.b u1 = u1();
        this.f5728f = u1;
        u1.k(this);
        this.B = new ControllerHtmlFile(com.ironsource.sdk.utils.f.q(), this.A, com.ironsource.sdk.utils.f.m(), this.f5728f);
        this.o = new ChromeClient(this, null);
        setWebViewClient(new v(this, null));
        ChromeClient chromeClient = this.o;
        setWebChromeClient(chromeClient);
        VdsAgent.setWebChromeClient(this, chromeClient);
        com.ironsource.sdk.utils.h.d(this);
        g2();
        d1();
        setDownloadListener(this);
        setOnTouchListener(new u(this, null));
        this.F = b1();
        this.R = Y0(context);
        o(context);
        setDebugMode(FeaturesManager.getInstance().a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ISNEnums$ProductType B1(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ISNEnums$ProductType iSNEnums$ProductType = ISNEnums$ProductType.Interstitial;
        if (str.equalsIgnoreCase(iSNEnums$ProductType.toString())) {
            return iSNEnums$ProductType;
        }
        ISNEnums$ProductType iSNEnums$ProductType2 = ISNEnums$ProductType.RewardedVideo;
        if (str.equalsIgnoreCase(iSNEnums$ProductType2.toString())) {
            return iSNEnums$ProductType2;
        }
        ISNEnums$ProductType iSNEnums$ProductType3 = ISNEnums$ProductType.OfferWall;
        if (str.equalsIgnoreCase(iSNEnums$ProductType3.toString())) {
            return iSNEnums$ProductType3;
        }
        ISNEnums$ProductType iSNEnums$ProductType4 = ISNEnums$ProductType.Banner;
        if (str.equalsIgnoreCase(iSNEnums$ProductType4.toString())) {
            return iSNEnums$ProductType4;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebView C1() {
        return this;
    }

    private void D1(com.ironsource.sdk.data.b bVar, Map<String, String> map) {
        Map<String, String> A = com.ironsource.sdk.utils.f.A(new Map[]{map, bVar.a()});
        this.D.y(bVar.f(), true);
        K1(n1("loadInterstitial", com.ironsource.sdk.utils.f.f(A), "onLoadInterstitialSuccess", "onLoadInterstitialFail"));
    }

    private void I1(Context context) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.s = new FrameLayout(context);
        this.q = new FrameLayout(context);
        this.q.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout = this.q;
        frameLayout.setVisibility(8);
        VdsAgent.onSetViewVisibility(frameLayout, 8);
        FrameLayout frameLayout2 = new FrameLayout(context);
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout2.addView(this);
        this.s.addView(this.q, layoutParams);
        this.s.addView(frameLayout2);
    }

    private void J1(String str, String str2, ISNEnums$ProductType iSNEnums$ProductType, com.ironsource.sdk.data.b bVar, s sVar) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            K1(a1(iSNEnums$ProductType, bVar).a);
        } else {
            sVar.a("User id or Application key are missing", iSNEnums$ProductType, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K1(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = "console.log(\"JS exeption: \" + JSON.stringify(e));";
        if (s1() != ISNEnums$DebugMode.MODE_0.getValue() && (s1() < ISNEnums$DebugMode.MODE_1.getValue() || s1() > ISNEnums$DebugMode.MODE_3.getValue())) {
            str2 = "empty";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("try{");
        sb.append(str);
        sb.append("}catch(e){");
        sb.append(str2);
        sb.append("}");
        Z1(new a("javascript:" + sb.toString(), sb));
    }

    private void Q0(JSONObject jSONObject) throws JSONException {
        jSONObject.put(com.ironsource.sdk.utils.f.c("gpi"), PackagesInstallationService.e(getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String S1(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                jSONObject.put(str, com.ironsource.sdk.utils.f.c(str2));
            }
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                jSONObject.put(str3, com.ironsource.sdk.utils.f.c(str4));
            }
            if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                jSONObject.put(str5, com.ironsource.sdk.utils.f.c(str6));
            }
            if (!TextUtils.isEmpty(str7) && !TextUtils.isEmpty(str8)) {
                jSONObject.put(str7, com.ironsource.sdk.utils.f.c(str8));
            }
            if (!TextUtils.isEmpty(str9)) {
                jSONObject.put(str9, z);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0() {
        d.e.d.n.g gVar = this.T;
        if (gVar != null) {
            gVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
        if (android.text.TextUtils.isEmpty(r1) == false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void W1(java.lang.String r4, boolean r5, java.lang.String r6, java.lang.String r7) {
        /*
            r3 = this;
            com.ironsource.sdk.data.d r0 = new com.ironsource.sdk.data.d
            r0.<init>(r4)
            java.lang.String r1 = com.ironsource.sdk.controller.WebController.e0
            java.lang.String r1 = r0.f(r1)
            java.lang.String r2 = com.ironsource.sdk.controller.WebController.f0
            java.lang.String r0 = r0.f(r2)
            if (r5 == 0) goto L1a
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 != 0) goto L22
            goto L23
        L1a:
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 != 0) goto L22
            r1 = r0
            goto L23
        L22:
            r1 = 0
        L23:
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 != 0) goto L5c
            boolean r5 = android.text.TextUtils.isEmpty(r6)
            if (r5 != 0) goto L40
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: org.json.JSONException -> L3f
            r5.<init>(r4)     // Catch: org.json.JSONException -> L3f
            java.lang.String r0 = "errMsg"
            org.json.JSONObject r5 = r5.put(r0, r6)     // Catch: org.json.JSONException -> L3f
            java.lang.String r4 = r5.toString()     // Catch: org.json.JSONException -> L3f
            goto L40
        L3f:
        L40:
            boolean r5 = android.text.TextUtils.isEmpty(r7)
            if (r5 != 0) goto L55
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: org.json.JSONException -> L55
            r5.<init>(r4)     // Catch: org.json.JSONException -> L55
            java.lang.String r6 = "errCode"
            org.json.JSONObject r5 = r5.put(r6, r7)     // Catch: org.json.JSONException -> L55
            java.lang.String r4 = r5.toString()     // Catch: org.json.JSONException -> L55
        L55:
            java.lang.String r4 = r3.l1(r1, r4)
            r3.K1(r4)
        L5c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.WebController.W1(java.lang.String, boolean, java.lang.String, java.lang.String):void");
    }

    private String X0(String str) {
        String str2 = this.A + File.separator;
        return str.contains(str2) ? str.substring(str2.length()) : str;
    }

    private com.ironsource.sdk.service.b.b Y0(Context context) {
        return new g(com.ironsource.sdk.utils.f.l(), context);
    }

    private t a1(ISNEnums$ProductType iSNEnums$ProductType, com.ironsource.sdk.data.b bVar) {
        t tVar = new t();
        if (iSNEnums$ProductType != ISNEnums$ProductType.RewardedVideo && iSNEnums$ProductType != ISNEnums$ProductType.Interstitial && iSNEnums$ProductType != ISNEnums$ProductType.OfferWall && iSNEnums$ProductType != ISNEnums$ProductType.Banner) {
            if (iSNEnums$ProductType == ISNEnums$ProductType.OfferWallCredits) {
                tVar.a = n1("getUserCredits", S1("productType", "OfferWall", "applicationKey", this.c, "applicationUserId", this.f5726d, null, null, null, false), "null", "onGetUserCreditsFail");
            }
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("applicationKey", this.c);
            hashMap.put("applicationUserId", this.f5726d);
            if (bVar != null) {
                if (bVar.e() != null) {
                    hashMap.putAll(bVar.e());
                    hashMap.put("loadStartTime", String.valueOf(com.ironsource.sdk.service.a.b.d(bVar.f())));
                }
                hashMap.put("demandSourceName", bVar.d());
                hashMap.put("demandSourceId", bVar.f());
            }
            Map<String, String> v1 = v1(iSNEnums$ProductType);
            if (v1 != null) {
                hashMap.putAll(v1);
            }
            String f2 = com.ironsource.sdk.utils.f.f(hashMap);
            d.e.d.m.a a2 = d.e.d.m.a.a(iSNEnums$ProductType);
            String n1 = n1(a2.a, f2, a2.b, a2.c);
            String str = a2.a;
            tVar.a = n1;
        }
        return tVar;
    }

    private void c2(WebSettings webSettings) {
        if (Build.VERSION.SDK_INT > 11) {
            webSettings.setDisplayZoomControls(false);
        }
    }

    private void d1() {
        com.ironsource.sdk.controller.o oVar = new com.ironsource.sdk.controller.o(com.ironsource.sdk.controller.o.b());
        addJavascriptInterface(Z0(oVar), Constants.PLATFORM_ANDROID);
        addJavascriptInterface(c1(oVar), "GenerateTokenForMessaging");
    }

    @SuppressLint({"NewApi"})
    private void d2(WebSettings webSettings) {
        if (Build.VERSION.SDK_INT >= 17) {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        }
    }

    private String e1(ISNEnums$ProductType iSNEnums$ProductType, JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        hashMap.put("sessionDepth", Integer.toString(jSONObject.optInt("sessionDepth")));
        String optString = jSONObject.optString("demandSourceName");
        String e2 = com.ironsource.sdk.utils.f.e(jSONObject);
        com.ironsource.sdk.data.b d2 = this.H.d(iSNEnums$ProductType, e2);
        if (d2 != null) {
            if (d2.e() != null) {
                hashMap.putAll(d2.e());
            }
            if (!TextUtils.isEmpty(optString)) {
                hashMap.put("demandSourceName", optString);
            }
            if (!TextUtils.isEmpty(e2)) {
                hashMap.put("demandSourceId", e2);
            }
        }
        Map<String, String> v1 = v1(iSNEnums$ProductType);
        if (v1 != null) {
            hashMap.putAll(v1);
        }
        String f2 = com.ironsource.sdk.utils.f.f(hashMap);
        d.e.d.m.a b2 = d.e.d.m.a.b(iSNEnums$ProductType);
        return n1(b2.a, f2, b2.b, b2.c);
    }

    @SuppressLint({"NewApi"})
    private void e2() {
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }

    private void f2(JSONObject jSONObject) {
        if (jSONObject.optBoolean("inspectWebview")) {
            e2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void g1(String str) {
        evaluateJavascript(str, null);
    }

    private void g2() {
        WebSettings settings = getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        settings.setAllowFileAccess(true);
        settings.setBuiltInZoomControls(false);
        settings.setJavaScriptEnabled(true);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath("/data/data/org.itri.html5webview/databases/");
        settings.setDomStorageEnabled(true);
        try {
            c2(settings);
            d2(settings);
        } catch (Throwable th) {
            String str = this.a;
            com.ironsource.sdk.utils.d.b(str, "setWebSettings - " + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h1(String str) {
        return new com.ironsource.sdk.data.d(str).f(f0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h2(String str) {
        com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(str);
        String f2 = dVar.f(TypedValues.Custom.S_COLOR);
        String f3 = dVar.f("adViewId");
        int parseColor = !TJAdUnitConstants.String.TRANSPARENT.equalsIgnoreCase(f2) ? Color.parseColor(f2) : 0;
        if (f3 != null) {
            WebView a2 = AdViewsManager.getInstance().a(f3);
            if (a2 != null) {
                a2.setBackgroundColor(parseColor);
                return;
            }
            return;
        }
        setBackgroundColor(parseColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i1(String str) {
        return new com.ironsource.sdk.data.d(str).f(e0);
    }

    private void i2(String str) {
        if (str.equalsIgnoreCase("0")) {
            getSettings().setCacheMode(2);
        } else {
            getSettings().setCacheMode(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j2(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            com.ironsource.sdk.utils.d.a(this.a, "Trying to trigger a listener - no product was found");
            return false;
        }
        if (!str.equalsIgnoreCase(ISNEnums$ProductType.Interstitial.toString()) ? !str.equalsIgnoreCase(ISNEnums$ProductType.RewardedVideo.toString()) ? !str.equalsIgnoreCase(ISNEnums$ProductType.Banner.toString()) ? (str.equalsIgnoreCase(ISNEnums$ProductType.OfferWall.toString()) || str.equalsIgnoreCase(ISNEnums$ProductType.OfferWallCredits.toString())) && this.x != null : this.y != null : this.v != null : this.w != null) {
            z = true;
        }
        if (!z) {
            String str2 = this.a;
            com.ironsource.sdk.utils.d.a(str2, "Trying to trigger a listener - no listener was found for product " + str);
        }
        return z;
    }

    private String k1(String str) {
        return "SSA_CORE.SDKController.runFunction('" + str + "');";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k2(String str, String str2) {
        String f2 = new com.ironsource.sdk.data.d(str2).f("errMsg");
        if (TextUtils.isEmpty(f2)) {
            return;
        }
        Z1(new e(str, f2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l1(String str, String str2) {
        return "SSA_CORE.SDKController.runFunction('" + str + "?parameters=" + str2 + "');";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l2(String str, ISNEnums$ProductType iSNEnums$ProductType, com.ironsource.sdk.data.b bVar) {
        if (j2(iSNEnums$ProductType.toString())) {
            Z1(new o(iSNEnums$ProductType, bVar, str));
        }
    }

    private String m1(String str, String str2, String str3) {
        return "SSA_CORE.SDKController.runFunction('" + str + "','" + str2 + "','" + str3 + "');";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String n1(String str, String str2, String str3, String str4) {
        return "SSA_CORE.SDKController.runFunction('" + str + "?parameters=" + str2 + "','" + str3 + "','" + str4 + "');";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d.e.d.n.h.a o1(ISNEnums$ProductType iSNEnums$ProductType) {
        if (iSNEnums$ProductType == ISNEnums$ProductType.Interstitial) {
            return this.w;
        }
        if (iSNEnums$ProductType == ISNEnums$ProductType.RewardedVideo) {
            return this.v;
        }
        if (iSNEnums$ProductType == ISNEnums$ProductType.Banner) {
            return this.y;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] p1(String str, String str2) {
        boolean z;
        JSONObject jSONObject = new JSONObject();
        Map<String, String> map = null;
        if (TextUtils.isEmpty(str)) {
            z = true;
        } else {
            ISNEnums$ProductType B1 = B1(str);
            if (B1 == ISNEnums$ProductType.OfferWall) {
                map = this.f5727e;
            } else {
                com.ironsource.sdk.data.b d2 = this.H.d(B1, str2);
                if (d2 != null) {
                    Map<String, String> e2 = d2.e();
                    e2.put("demandSourceName", d2.d());
                    e2.put("demandSourceId", d2.f());
                    map = e2;
                }
            }
            try {
                jSONObject.put("productType", str);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            try {
                Map<String, String> o2 = com.ironsource.sdk.utils.f.o();
                if (o2 != null) {
                    jSONObject = com.ironsource.sdk.utils.f.B(jSONObject, new JSONObject(o2));
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            z = false;
        }
        if (TextUtils.isEmpty(this.f5726d)) {
            z = true;
        } else {
            try {
                jSONObject.put(com.ironsource.sdk.utils.f.c("applicationUserId"), com.ironsource.sdk.utils.f.c(this.f5726d));
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(this.c)) {
            z = true;
        } else {
            try {
                jSONObject.put(com.ironsource.sdk.utils.f.c("applicationKey"), com.ironsource.sdk.utils.f.c(this.c));
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
        }
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey().equalsIgnoreCase("sdkWebViewCache")) {
                    i2(entry.getValue());
                }
                try {
                    jSONObject.put(com.ironsource.sdk.utils.f.c(entry.getKey()), com.ironsource.sdk.utils.f.c(entry.getValue()));
                } catch (JSONException e7) {
                    e7.printStackTrace();
                }
            }
        }
        return new Object[]{jSONObject.toString(), Boolean.valueOf(z)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] t1(Context context) {
        boolean z;
        com.ironsource.sdk.utils.a h2 = com.ironsource.sdk.utils.a.h(context);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appOrientation", PortalFollowFeeds.TYPE_NONE);
            jSONObject.put("deviceOrientation", com.ironsource.sdk.utils.f.I(com.ironsource.environment.e.s(context)));
            String d2 = h2.d();
            if (d2 != null) {
                jSONObject.put(com.ironsource.sdk.utils.f.c("deviceOEM"), com.ironsource.sdk.utils.f.c(d2));
            }
            String c2 = h2.c();
            if (c2 != null) {
                jSONObject.put(com.ironsource.sdk.utils.f.c("deviceModel"), com.ironsource.sdk.utils.f.c(c2));
                z = false;
            } else {
                z = true;
            }
            try {
                com.ironsource.sdk.utils.f.z(context);
                String j2 = com.ironsource.sdk.utils.f.j();
                Boolean valueOf = Boolean.valueOf(com.ironsource.sdk.utils.f.y());
                if (!TextUtils.isEmpty(j2)) {
                    com.ironsource.sdk.utils.d.d(this.a, "add AID and LAT");
                    jSONObject.put("isLimitAdTrackingEnabled", valueOf);
                    jSONObject.put("deviceIds[AID]", com.ironsource.sdk.utils.f.c(j2));
                }
                String e2 = h2.e();
                if (e2 != null) {
                    jSONObject.put(com.ironsource.sdk.utils.f.c("deviceOs"), com.ironsource.sdk.utils.f.c(e2));
                } else {
                    z = true;
                }
                String f2 = h2.f();
                if (f2 != null) {
                    jSONObject.put(com.ironsource.sdk.utils.f.c("deviceOSVersion"), f2.replaceAll("[^0-9/.]", ""));
                } else {
                    z = true;
                }
                String f3 = h2.f();
                if (f3 != null) {
                    jSONObject.put(com.ironsource.sdk.utils.f.c("deviceOSVersionFull"), com.ironsource.sdk.utils.f.c(f3));
                }
                String valueOf2 = String.valueOf(h2.a());
                if (valueOf2 != null) {
                    jSONObject.put(com.ironsource.sdk.utils.f.c("deviceApiLevel"), valueOf2);
                } else {
                    z = true;
                }
                String i2 = com.ironsource.sdk.utils.a.i();
                if (i2 != null) {
                    jSONObject.put(com.ironsource.sdk.utils.f.c("SDKVersion"), com.ironsource.sdk.utils.f.c(i2));
                }
                if (h2.b() != null && h2.b().length() > 0) {
                    jSONObject.put(com.ironsource.sdk.utils.f.c("mobileCarrier"), com.ironsource.sdk.utils.f.c(h2.b()));
                }
                String b2 = d.e.c.b.b(context);
                if (b2.equals(PortalFollowFeeds.TYPE_NONE)) {
                    z = true;
                } else {
                    jSONObject.put(com.ironsource.sdk.utils.f.c("connectionType"), com.ironsource.sdk.utils.f.c(b2));
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    jSONObject.put(com.ironsource.sdk.utils.f.c("hasVPN"), d.e.c.b.g(context));
                }
                String language = context.getResources().getConfiguration().locale.getLanguage();
                if (!TextUtils.isEmpty(language)) {
                    jSONObject.put(com.ironsource.sdk.utils.f.c("deviceLanguage"), com.ironsource.sdk.utils.f.c(language.toUpperCase()));
                }
                if (com.ironsource.sdk.utils.f.w()) {
                    jSONObject.put(com.ironsource.sdk.utils.f.c("diskFreeSize"), com.ironsource.sdk.utils.f.c(String.valueOf(com.ironsource.environment.e.j(this.A))));
                } else {
                    z = true;
                }
                String valueOf3 = String.valueOf(com.ironsource.environment.e.w());
                if (TextUtils.isEmpty(valueOf3)) {
                    z = true;
                } else {
                    jSONObject.put(com.ironsource.sdk.utils.f.c("deviceScreenSize") + "[" + com.ironsource.sdk.utils.f.c("width") + "]", com.ironsource.sdk.utils.f.c(valueOf3));
                }
                String valueOf4 = String.valueOf(com.ironsource.environment.e.m());
                jSONObject.put(com.ironsource.sdk.utils.f.c("deviceScreenSize") + "[" + com.ironsource.sdk.utils.f.c("height") + "]", com.ironsource.sdk.utils.f.c(valueOf4));
                String f4 = com.ironsource.environment.c.f(getContext());
                if (!TextUtils.isEmpty(f4)) {
                    jSONObject.put(com.ironsource.sdk.utils.f.c("bundleId"), com.ironsource.sdk.utils.f.c(f4));
                }
                String valueOf5 = String.valueOf(com.ironsource.environment.e.l());
                if (!TextUtils.isEmpty(valueOf5)) {
                    jSONObject.put(com.ironsource.sdk.utils.f.c("deviceScreenScale"), com.ironsource.sdk.utils.f.c(valueOf5));
                }
                String valueOf6 = String.valueOf(com.ironsource.environment.e.S());
                if (!TextUtils.isEmpty(valueOf6)) {
                    jSONObject.put(com.ironsource.sdk.utils.f.c("unLocked"), com.ironsource.sdk.utils.f.c(valueOf6));
                }
                jSONObject.put(com.ironsource.sdk.utils.f.c("deviceVolume"), com.ironsource.sdk.utils.a.h(context).g(context));
                jSONObject.put(com.ironsource.sdk.utils.f.c("batteryLevel"), com.ironsource.environment.e.k(context));
                jSONObject.put(com.ironsource.sdk.utils.f.c("mcc"), d.e.c.a.b(context));
                jSONObject.put(com.ironsource.sdk.utils.f.c("mnc"), d.e.c.a.c(context));
                jSONObject.put(com.ironsource.sdk.utils.f.c("phoneType"), d.e.c.a.d(context));
                jSONObject.put(com.ironsource.sdk.utils.f.c("simOperator"), com.ironsource.sdk.utils.f.c(d.e.c.a.e(context)));
                jSONObject.put(com.ironsource.sdk.utils.f.c("lastUpdateTime"), com.ironsource.environment.c.e(context));
                jSONObject.put(com.ironsource.sdk.utils.f.c("firstInstallTime"), com.ironsource.environment.c.c(context));
                jSONObject.put(com.ironsource.sdk.utils.f.c(RemoteConfigConstants.RequestFieldKey.APP_VERSION), com.ironsource.sdk.utils.f.c(com.ironsource.environment.c.b(context)));
                String d3 = com.ironsource.environment.c.d(context);
                if (!TextUtils.isEmpty(d3)) {
                    jSONObject.put(com.ironsource.sdk.utils.f.c("installerPackageName"), com.ironsource.sdk.utils.f.c(d3));
                }
                Q0(jSONObject);
                jSONObject.put(com.ironsource.sdk.utils.f.c("screenBrightness"), com.ironsource.environment.e.J(context));
            } catch (JSONException e3) {
                e = e3;
                e.printStackTrace();
                return new Object[]{jSONObject.toString(), Boolean.valueOf(z)};
            }
        } catch (JSONException e4) {
            e = e4;
            z = false;
        }
        return new Object[]{jSONObject.toString(), Boolean.valueOf(z)};
    }

    private Map<String, String> v1(ISNEnums$ProductType iSNEnums$ProductType) {
        if (iSNEnums$ProductType == ISNEnums$ProductType.OfferWall) {
            return this.f5727e;
        }
        return null;
    }

    private String y1(JSONObject jSONObject) {
        com.ironsource.sdk.utils.a h2 = com.ironsource.sdk.utils.a.h(getContext());
        StringBuilder sb = new StringBuilder();
        String i2 = com.ironsource.sdk.utils.a.i();
        if (!TextUtils.isEmpty(i2)) {
            sb.append("SDKVersion");
            sb.append("=");
            sb.append(i2);
            sb.append("&");
        }
        String e2 = h2.e();
        if (!TextUtils.isEmpty(e2)) {
            sb.append("deviceOs");
            sb.append("=");
            sb.append(e2);
        }
        Uri parse = Uri.parse(com.ironsource.sdk.utils.f.m());
        if (parse != null) {
            String str = parse.getScheme() + ":";
            String host = parse.getHost();
            int port = parse.getPort();
            if (port != -1) {
                host = host + ":" + port;
            }
            sb.append("&");
            sb.append("protocol");
            sb.append("=");
            sb.append(str);
            sb.append("&");
            sb.append("domain");
            sb.append("=");
            sb.append(host);
            if (jSONObject.keys().hasNext()) {
                try {
                    String jSONObject2 = new JSONObject(jSONObject, new String[]{"isSecured", "applicationKey"}).toString();
                    if (!TextUtils.isEmpty(jSONObject2)) {
                        sb.append("&");
                        sb.append("controllerConfig");
                        sb.append("=");
                        sb.append(jSONObject2);
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            sb.append("&");
            sb.append("debug");
            sb.append("=");
            sb.append(s1());
        }
        return sb.toString();
    }

    public State A1() {
        return this.t;
    }

    public boolean E1(String str) {
        List<String> d2 = com.ironsource.sdk.utils.b.e().d();
        if (d2 != null) {
            try {
                if (d2.isEmpty()) {
                    return false;
                }
                for (String str2 : d2) {
                    if (str.contains(str2)) {
                        com.ironsource.environment.k.a(r1(), str);
                        return true;
                    }
                }
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public void F1() {
        if (this.f5730h == null) {
            return;
        }
        W0();
        ISNEnums$ProductType b2 = this.f5730h.b();
        String a2 = this.f5730h.a();
        if (j2(b2.toString())) {
            P1(b2, a2);
        }
    }

    public void G1() {
        this.o.onHideCustomView();
    }

    public boolean H1() {
        return this.p != null;
    }

    public void L1() {
        K1(k1("interceptedUrlToStore"));
    }

    public void M0(com.ironsource.sdk.controller.a aVar) {
        this.N = aVar;
        aVar.e(q1());
    }

    public void M1(int i2) {
        try {
            loadUrl("about:blank");
            VdsAgent.loadUrl(this, "about:blank");
        } catch (Throwable th) {
            com.ironsource.sdk.utils.d.b(this.a, "WebViewController:: load: " + th.toString());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(InspirePublishFragment.FILE_HEADER);
        sb.append(this.A);
        String str = File.separator;
        sb.append(str);
        sb.append("mobileController.html");
        String sb2 = sb.toString();
        if (new File(this.A + str + "mobileController.html").exists()) {
            JSONObject l2 = com.ironsource.sdk.utils.f.l();
            f2(l2);
            String y1 = y1(l2);
            Map<String, String> o2 = com.ironsource.sdk.utils.f.o();
            if (o2 != null && o2.containsKey("sessionid")) {
                y1 = String.format("%s&sessionid=%s", y1, o2.get("sessionid"));
            }
            String str2 = sb2 + "?" + y1;
            this.f5733k = new i(50000L, 1000L, i2).start();
            try {
                loadUrl(str2);
                VdsAgent.loadUrl(this, str2);
            } catch (Throwable th2) {
                com.ironsource.sdk.utils.d.b(this.a, "WebViewController:: load: " + th2.toString());
            }
            com.ironsource.sdk.utils.d.d(this.a, "load(): " + str2);
            return;
        }
        com.ironsource.sdk.utils.d.d(this.a, "load(): Mobile Controller HTML Does not exist");
    }

    public void N0(com.ironsource.sdk.controller.b bVar) {
        this.K = bVar;
        bVar.e(q1());
    }

    public void N1() {
        this.B.t();
        if (this.B.q()) {
            M1(1);
        }
    }

    public void O0(DeviceDataJSAdapter deviceDataJSAdapter) {
        this.M = deviceDataJSAdapter;
    }

    public void O1(String str) {
        K1(l1("nativeNavigationPressed", S1(AuthActivity.ACTION_KEY, str, null, null, null, null, null, null, null, false)));
    }

    public void P0(com.ironsource.sdk.controller.i iVar) {
        this.O = iVar;
    }

    void P1(ISNEnums$ProductType iSNEnums$ProductType, String str) {
        Z1(new f(iSNEnums$ProductType, str));
    }

    public void Q1(String str, String str2) {
        K1(l1("onNativeLifeCycleEvent", S1("lifeCycleEvent", str2, "productType", str, null, null, null, null, null, false)));
    }

    public void R0(OMIDJSAdapter oMIDJSAdapter) {
        this.I = oMIDJSAdapter;
    }

    public void R1() {
        K1(k1("pageFinished"));
    }

    public void S0(PermissionsJSAdapter permissionsJSAdapter) {
        this.J = permissionsJSAdapter;
    }

    public void T0(com.ironsource.sdk.controller.p pVar) {
        this.L = pVar;
    }

    public void T1() {
        try {
            onPause();
        } catch (Throwable th) {
            String str = this.a;
            com.ironsource.sdk.utils.d.d(str, "WebViewController: onPause() - " + th);
        }
    }

    public void U0(String str, String str2) {
        try {
            K1(l1("assetCached", S1("file", str, PGEditResultActivity2.PATH, X0(str2), null, null, null, null, null, false)));
        } catch (Exception e2) {
            V0(str, str2, e2.getMessage());
        }
    }

    public void U1() {
        this.C = null;
    }

    public void V0(String str, String str2, String str3) {
        try {
            K1(l1("assetCachedFailed", S1("file", str, PGEditResultActivity2.PATH, X0(str2), "errMsg", str3, null, null, null, false)));
        } catch (Exception unused) {
        }
    }

    public void V1() {
        this.T = null;
    }

    public void X1(AdUnitsState adUnitsState) {
        synchronized (this.E) {
            if (adUnitsState.C() && this.f5729g) {
                String str = this.a;
                Log.d(str, "restoreState(state:" + adUnitsState + ")");
                int f2 = adUnitsState.f();
                if (f2 != -1) {
                    ISNEnums$ProductType iSNEnums$ProductType = ISNEnums$ProductType.RewardedVideo;
                    if (f2 == iSNEnums$ProductType.ordinal()) {
                        Log.d(this.a, "onRVAdClosed()");
                        String c2 = adUnitsState.c();
                        d.e.d.n.h.a o1 = o1(iSNEnums$ProductType);
                        if (o1 != null && !TextUtils.isEmpty(c2)) {
                            o1.B(iSNEnums$ProductType, c2);
                        }
                    } else {
                        ISNEnums$ProductType iSNEnums$ProductType2 = ISNEnums$ProductType.Interstitial;
                        if (f2 == iSNEnums$ProductType2.ordinal()) {
                            Log.d(this.a, "onInterstitialAdClosed()");
                            String c3 = adUnitsState.c();
                            d.e.d.n.h.a o12 = o1(iSNEnums$ProductType2);
                            if (o12 != null && !TextUtils.isEmpty(c3)) {
                                o12.B(iSNEnums$ProductType2, c3);
                            }
                        } else if (f2 == ISNEnums$ProductType.OfferWall.ordinal()) {
                            Log.d(this.a, "onOWAdClosed()");
                            d.e.d.n.e eVar = this.x;
                            if (eVar != null) {
                                eVar.onOWAdClosed();
                            }
                        }
                    }
                    adUnitsState.b(-1);
                    adUnitsState.o(null);
                } else {
                    Log.d(this.a, "No ad was opened");
                }
                String g2 = adUnitsState.g();
                String h2 = adUnitsState.h();
                for (com.ironsource.sdk.data.b bVar : this.H.e(ISNEnums$ProductType.Interstitial)) {
                    if (bVar.c() == 2) {
                        String str2 = this.a;
                        Log.d(str2, "initInterstitial(appKey:" + g2 + ", userId:" + h2 + ", demandSource:" + bVar.d() + ")");
                        f(g2, h2, bVar, this.w);
                    }
                }
                String k2 = adUnitsState.k();
                String l2 = adUnitsState.l();
                for (com.ironsource.sdk.data.b bVar2 : this.H.e(ISNEnums$ProductType.RewardedVideo)) {
                    if (bVar2.c() == 2) {
                        String d2 = bVar2.d();
                        Log.d(this.a, "onRVNoMoreOffers()");
                        this.v.u(d2);
                        String str3 = this.a;
                        Log.d(str3, "initRewardedVideo(appKey:" + k2 + ", userId:" + l2 + ", demandSource:" + d2 + ")");
                        x(k2, l2, bVar2, this.v);
                    }
                }
                adUnitsState.B(false);
            }
            this.D = adUnitsState;
        }
    }

    public void Y1() {
        try {
            onResume();
        } catch (Throwable th) {
            String str = this.a;
            com.ironsource.sdk.utils.d.d(str, "WebViewController: onResume() - " + th);
        }
    }

    com.ironsource.sdk.controller.g Z0(com.ironsource.sdk.controller.o oVar) {
        return new com.ironsource.sdk.controller.g(new com.ironsource.sdk.controller.d(new r()), oVar);
    }

    void Z1(Runnable runnable) {
        Handler handler = this.F;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    @Override // com.ironsource.sdk.controller.j
    public void a() {
        K1(k1("enterBackground"));
    }

    public void a2(JSONObject jSONObject) {
        String str = this.a;
        com.ironsource.sdk.utils.d.d(str, "device connection info changed: " + jSONObject.toString());
        K1(l1("connectionInfoChanged", S1("connectionInfo", jSONObject.toString(), null, null, null, null, null, null, null, false)));
    }

    @Override // com.ironsource.sdk.controller.j
    public void b(JSONObject jSONObject) {
        K1(l1("updateConsentInfo", jSONObject != null ? jSONObject.toString() : null));
    }

    Handler b1() {
        return new Handler(Looper.getMainLooper());
    }

    public void b2(String str) {
        String str2 = this.a;
        com.ironsource.sdk.utils.d.d(str2, "device status changed, connection type " + str);
        d.e.d.a.b.d(str);
        K1(l1("deviceStatusChanged", S1("connectionType", str, null, null, null, null, null, null, null, false)));
    }

    @Override // com.ironsource.sdk.controller.j
    public void c(String str, d.e.d.n.h.c cVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("demandSourceName", str);
        String f2 = com.ironsource.sdk.utils.f.f(hashMap);
        this.D.y(str, true);
        K1(n1("loadInterstitial", f2, "onLoadInterstitialSuccess", "onLoadInterstitialFail"));
    }

    com.ironsource.sdk.controller.n c1(com.ironsource.sdk.controller.o oVar) {
        return new com.ironsource.sdk.controller.n(oVar);
    }

    @Override // com.ironsource.sdk.controller.j
    public void d(String str, String str2, Map<String, String> map, d.e.d.n.e eVar) {
        this.c = str;
        this.f5726d = str2;
        this.f5727e = map;
        this.x = eVar;
        this.D.r(map);
        this.D.t(true);
        J1(this.c, this.f5726d, ISNEnums$ProductType.OfferWall, null, new l());
    }

    @Override // android.webkit.WebView, com.ironsource.sdk.controller.j
    public void destroy() {
        super.destroy();
        d.e.d.o.b bVar = this.f5728f;
        if (bVar != null) {
            bVar.j();
        }
        com.ironsource.sdk.service.b.b bVar2 = this.R;
        if (bVar2 != null) {
            bVar2.f();
        }
        CountDownTimer countDownTimer = this.f5733k;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.F = null;
    }

    @Override // com.ironsource.sdk.controller.j
    public void e(String str, String str2, d.e.d.n.e eVar) {
        this.c = str;
        this.f5726d = str2;
        this.x = eVar;
        J1(str, str2, ISNEnums$ProductType.OfferWallCredits, null, new m());
    }

    @Override // com.ironsource.sdk.controller.j
    public void f(String str, String str2, com.ironsource.sdk.data.b bVar, d.e.d.n.h.c cVar) {
        this.c = str;
        this.f5726d = str2;
        this.w = cVar;
        this.D.p(str);
        this.D.q(this.f5726d);
        J1(this.c, this.f5726d, ISNEnums$ProductType.Interstitial, bVar, new k());
    }

    public void f1(String str) {
        if (str.equals(TJAdUnitConstants.String.FORCE_CLOSE)) {
            W0();
        }
        K1(l1("engageEnd", S1(AuthActivity.ACTION_KEY, str, null, null, null, null, null, null, null, false)));
    }

    @Override // d.e.d.o.c
    public void g(ISNFile iSNFile) {
        if (iSNFile.getName().contains("mobileController.html")) {
            this.B.o(new b());
        } else {
            U0(iSNFile.getName(), iSNFile.getParent());
        }
    }

    @Override // com.ironsource.sdk.controller.j
    public ISNEnums$ControllerType getType() {
        return ISNEnums$ControllerType.Web;
    }

    @Override // com.ironsource.sdk.controller.j
    public boolean h(String str) {
        com.ironsource.sdk.data.b d2 = this.H.d(ISNEnums$ProductType.Interstitial, str);
        return d2 != null && d2.b();
    }

    @Override // com.ironsource.sdk.controller.j
    public void i(String str, String str2, com.ironsource.sdk.data.b bVar, d.e.d.n.h.b bVar2) {
        this.c = str;
        this.f5726d = str2;
        this.y = bVar2;
        J1(str, str2, ISNEnums$ProductType.Banner, bVar, new n());
    }

    @Override // com.ironsource.sdk.controller.j
    public void j(JSONObject jSONObject, d.e.d.n.h.d dVar) {
        K1(e1(ISNEnums$ProductType.RewardedVideo, jSONObject));
    }

    public void j1(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "unknown url";
        }
        String str3 = str2;
        if (TextUtils.isEmpty(str)) {
            str = "activity failed to open with unspecified reason";
        }
        K1(l1("failedToStartStoreActivity", S1("errMsg", str, "url", str3, null, null, null, null, null, false)));
    }

    @Override // com.ironsource.sdk.controller.j
    public void k(Context context) {
        com.ironsource.sdk.service.b.b bVar = this.R;
        if (bVar == null) {
            return;
        }
        bVar.h(context);
    }

    @Override // d.e.d.o.c
    public void l(ISNFile iSNFile, com.ironsource.sdk.data.c cVar) {
        if (iSNFile.getName().contains("mobileController.html")) {
            this.B.n(new c(), new d(cVar));
        } else {
            V0(iSNFile.getName(), iSNFile.getParent(), cVar.b());
        }
    }

    @Override // com.ironsource.sdk.controller.j
    public void m(com.ironsource.sdk.data.b bVar, Map<String, String> map, d.e.d.n.h.c cVar) {
        K1(e1(ISNEnums$ProductType.Interstitial, new JSONObject(com.ironsource.sdk.utils.f.A(new Map[]{map, bVar.a()}))));
    }

    public void m2(boolean z, String str) {
        K1(l1("viewableChange", S1("webview", str, null, null, null, null, null, null, "isViewable", z)));
    }

    @Override // com.ironsource.sdk.controller.j
    public void n(Map<String, String> map, d.e.d.n.h.b bVar) {
        if (map != null) {
            K1(n1("loadBanner", com.ironsource.sdk.utils.f.f(map), "onLoadBannerSuccess", "onLoadBannerFail"));
        }
    }

    @Override // com.ironsource.sdk.controller.j
    public void o(Context context) {
        com.ironsource.sdk.service.b.b bVar = this.R;
        if (bVar == null) {
            return;
        }
        bVar.g(context);
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
        String str5 = this.a;
        com.ironsource.sdk.utils.d.d(str5, str + " " + str4);
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        d.e.d.n.g gVar;
        if (i2 == 4 && (gVar = this.T) != null && gVar.b()) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.ironsource.sdk.controller.j
    public void p(JSONObject jSONObject, d.e.d.n.h.b bVar) {
        K1(n1("loadBanner", jSONObject.toString(), "onLoadBannerSuccess", "onLoadBannerFail"));
    }

    @Override // com.ironsource.sdk.controller.j
    public void q(Map<String, String> map, d.e.d.n.e eVar) {
        this.f5727e = map;
        K1(m1("showOfferWall", "onShowOfferWallSuccess", "onShowOfferWallFail"));
    }

    public com.ironsource.sdk.controller.r q1() {
        if (this.P == null) {
            this.P = new h();
        }
        return this.P;
    }

    @Override // com.ironsource.sdk.controller.j
    public void r(JSONObject jSONObject, d.e.d.n.h.c cVar) {
        K1(e1(ISNEnums$ProductType.Interstitial, jSONObject));
    }

    public Context r1() {
        return this.S.a();
    }

    public int s1() {
        return U;
    }

    @Override // android.webkit.WebView
    public WebBackForwardList saveState(Bundle bundle) {
        return super.saveState(bundle);
    }

    @Override // com.ironsource.sdk.controller.j
    public void setCommunicationWithAdView(ISNAdView iSNAdView) {
        com.ironsource.sdk.controller.b bVar = this.K;
        if (bVar != null) {
            bVar.d(iSNAdView);
        }
    }

    public void setDebugMode(int i2) {
        U = i2;
    }

    public void setOnWebViewControllerChangeListener(d.e.d.n.g gVar) {
        this.T = gVar;
    }

    public void setOrientationState(String str) {
        this.u = str;
    }

    public void setState(State state) {
        this.t = state;
    }

    public void setVideoEventsListener(com.ironsource.sdk.controller.q qVar) {
        this.C = qVar;
    }

    @Override // com.ironsource.sdk.controller.j
    public void t(com.ironsource.sdk.data.b bVar, Map<String, String> map, d.e.d.n.h.c cVar) {
        D1(bVar, map);
    }

    @Override // com.ironsource.sdk.controller.j
    public void u() {
        X1(this.D);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d.e.d.o.b u1() {
        return d.e.d.o.b.g(this.A);
    }

    @Override // com.ironsource.sdk.controller.j
    public void v() {
        K1(k1("enterForeground"));
    }

    public FrameLayout w1() {
        return this.s;
    }

    @Override // com.ironsource.sdk.controller.j
    public void x(String str, String str2, com.ironsource.sdk.data.b bVar, d.e.d.n.h.d dVar) {
        this.c = str;
        this.f5726d = str2;
        this.v = dVar;
        this.D.u(str);
        this.D.x(str2);
        J1(str, str2, ISNEnums$ProductType.RewardedVideo, bVar, new j());
    }

    public String x1() {
        return this.u;
    }

    public AdUnitsState z1() {
        return this.D;
    }
}
