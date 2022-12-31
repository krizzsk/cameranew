package com.pinguo.camera360.lib.ui;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import com.facebook.ads.AdError;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.growingio.android.sdk.models.PageEvent;
import com.pinguo.camera360.adv.interaction.Interaction;
import com.pinguo.camera360.lib.ui.PickPhotoDialog;
import com.pinguo.camera360.lib.ui.WebViewActivity;
import com.pinguo.camera360.lib.ui.js.RespJsData;
import com.pinguo.camera360.lib.ui.s;
import com.pinguo.camera360.lib.ui.v;
import com.pinguo.camera360.vip.VipManager;
import com.tapjoy.TapjoyConstants;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.tauth.AuthActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import us.pinguo.advconfigdata.Statictis.AdvStaticsticManager;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.camera360.shop.data.show.ShowPkg;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.foundation.utils.AsyncTask;
import us.pinguo.foundation.utils.k0;
import us.pinguo.foundation.utils.z;
import us.pinguo.inspire.module.contact.cell.FindFriendHeaderCell;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.paylibcenter.PayCallback;
import us.pinguo.paylibcenter.PayHelp;
import us.pinguo.paylibcenter.bean.PayResult;
import us.pinguo.paylibcenter.bean.WxReqBean;
import us.pinguo.pgshare.commons.f;
import us.pinguo.share.core.PGShareInfo;
import us.pinguo.share.core.PGShareListener;
import us.pinguo.share.core.PGShareManager;
import us.pinguo.share.core.ShareSite;
import us.pinguo.share.exception.AppNotExistException;
import us.pinguo.user.User;
import us.pinguo.user.ui.PGLoginMainActivity;
import us.pinguo.webview.PGJsWebView;
import us.pinguo.webview.f.g;
import us.pinguo.webview.f.h.b0;
import us.pinguo.webview.f.h.f0;
import us.pinguo.webview.f.h.h0;
import us.pinguo.webview.f.h.t;
import us.pinguo.webview.f.h.x;
import vStudio.Android.Camera360.Conditions;
import vStudio.Android.Camera360.R;
import vStudio.Android.Camera360.wxapi.WXPayEntryActivity;
/* loaded from: classes3.dex */
public class WebViewActivity extends BaseActivity implements PickPhotoDialog.a, s.b, View.OnClickListener, v.b, us.pinguo.webview.g.a, DownloadListener, View.OnLongClickListener {
    private static final boolean T = Conditions.d();
    private f.b A;
    private ShareSite B;
    private ValueCallback<Uri[]> E;
    private ValueCallback F;
    private String H;
    private v J;
    private String[] a = {"https://printshop.in66.com"};
    private s b = null;
    private us.pinguo.webview.f.h.d c = null;

    /* renamed from: d  reason: collision with root package name */
    private com.pinguo.camera360.lib.ui.js.b f6839d = null;

    /* renamed from: e  reason: collision with root package name */
    private com.pinguo.camera360.lib.ui.js.c f6840e = null;

    /* renamed from: f  reason: collision with root package name */
    private us.pinguo.webview.f.h.b f6841f = null;

    /* renamed from: g  reason: collision with root package name */
    private us.pinguo.webview.f.h.o f6842g = null;

    /* renamed from: h  reason: collision with root package name */
    private com.pinguo.camera360.lib.ui.js.a f6843h = null;

    /* renamed from: i  reason: collision with root package name */
    private Map<String, String> f6844i = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    private String f6845j = null;

    /* renamed from: k  reason: collision with root package name */
    private String f6846k = null;

    /* renamed from: l  reason: collision with root package name */
    private String f6847l = null;
    private String m = null;
    private String n = null;
    private PickPhotoDialog o = null;
    private Intent p = null;
    private PGJsWebView q = null;
    private View r = null;
    private TextView s = null;
    private TextView t = null;
    private SimpleDraweeView u = null;
    private EditText v = null;
    private String w = null;
    private String x = null;
    private String y = null;
    private String z = null;
    private boolean C = false;
    private boolean D = false;
    private boolean G = false;
    private PGShareListener I = new d();
    private AlertDialog K = null;
    private boolean L = false;
    private String M = "";
    private String N = "app://camera360/publish";
    private boolean O = true;
    private boolean P = true;
    private int Q = 0;
    private int R = 0;
    private String S = "";

    /* loaded from: classes3.dex */
    class JsOperation {
        JsOperation() {
        }

        @JavascriptInterface
        public void finishActivity(boolean z) {
            us.pinguo.common.log.a.k("WebViewActivity.openMigu.isDone:" + z, new Object[0]);
            if (z) {
                WebViewActivity.this.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    class a extends us.pinguo.pgshare.commons.b {
        final /* synthetic */ PGShareInfo a;
        final /* synthetic */ String b;

        a(PGShareInfo pGShareInfo, String str) {
            this.a = pGShareInfo;
            this.b = str;
        }

        @Override // us.pinguo.pgshare.commons.b
        public void b(us.pinguo.pgshare.commons.c cVar, ResolveInfo resolveInfo) {
            PGShareManager pGShareManager = PGShareManager.getInstance();
            WebViewActivity webViewActivity = WebViewActivity.this;
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            pGShareManager.intentShare(webViewActivity, activityInfo.packageName, activityInfo.name, this.a, null);
        }

        @Override // us.pinguo.pgshare.commons.b
        public void c(us.pinguo.pgshare.commons.c cVar, ShareSite shareSite) {
            int i2 = c.a[shareSite.ordinal()];
            if (i2 == 1) {
                PGShareInfo pGShareInfo = this.a;
                pGShareInfo.setText(us.pinguo.share.util.n.b(WebViewActivity.this.getApplicationContext()) + this.b);
            } else if (i2 != 2) {
                if (i2 == 3 && TextUtils.isEmpty(this.b)) {
                    this.a.setText(WebViewActivity.this.getApplicationContext().getString(R.string.share_default_message));
                }
            } else {
                PGShareInfo pGShareInfo2 = this.a;
                pGShareInfo2.setText(us.pinguo.share.util.n.a(WebViewActivity.this.getApplicationContext()) + this.b);
            }
            if (WebViewActivity.this.B != ShareSite.FACEBOOK) {
                if (WebViewActivity.this.B != ShareSite.QQ && WebViewActivity.this.B != ShareSite.SINAWEIBO && WebViewActivity.this.B != ShareSite.WECHAT_FRIENDS && WebViewActivity.this.B != ShareSite.WECHAT_MOMENTS) {
                    PGShareManager pGShareManager = PGShareManager.getInstance();
                    WebViewActivity webViewActivity = WebViewActivity.this;
                    pGShareManager.intentShare(webViewActivity, webViewActivity.B.getPackageName(), null, this.a, WebViewActivity.this.I);
                    return;
                }
                PGShareManager pGShareManager2 = PGShareManager.getInstance();
                WebViewActivity webViewActivity2 = WebViewActivity.this;
                pGShareManager2.siteShare(webViewActivity2, webViewActivity2.B, this.a, WebViewActivity.this.I);
            } else if (!us.pinguo.util.s.h("com.facebook.katana", WebViewActivity.this)) {
                k0.a.a(R.string.not_install_app);
            } else {
                WebViewActivity webViewActivity3 = WebViewActivity.this;
                us.pinguo.share.b.d(webViewActivity3, this.a, webViewActivity3.I);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends us.pinguo.pgshare.commons.b {
        b() {
        }

        @Override // us.pinguo.pgshare.commons.b
        public void b(us.pinguo.pgshare.commons.c cVar, ResolveInfo resolveInfo) {
        }

        @Override // us.pinguo.pgshare.commons.b
        public void c(us.pinguo.pgshare.commons.c cVar, ShareSite shareSite) {
            WebViewActivity.this.q.e(t.c(shareSite));
            WebViewActivity.this.B = shareSite;
            cVar.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ShareSite.values().length];
            a = iArr;
            try {
                iArr[ShareSite.SINAWEIBO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ShareSite.TWITTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ShareSite.QZONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements PGShareListener {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void b() {
            Toast makeText = Toast.makeText(WebViewActivity.this, (int) R.string.share_callback_msg_success, 0);
            makeText.show();
            VdsAgent.showToast(makeText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void d() {
            Toast makeText = Toast.makeText(WebViewActivity.this, (int) R.string.share_not_install_app, 0);
            makeText.show();
            VdsAgent.showToast(makeText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public /* synthetic */ void f() {
            Toast makeText = Toast.makeText(WebViewActivity.this, (int) R.string.share_callback_msg_error, 0);
            makeText.show();
            VdsAgent.showToast(makeText);
        }

        @Override // us.pinguo.share.core.PGShareListener
        public void onShareCancel(ShareSite shareSite) {
            us.pinguo.common.log.a.c("onShareCancel:" + shareSite, new Object[0]);
        }

        @Override // us.pinguo.share.core.PGShareListener
        public void onShareComplete(ShareSite shareSite, boolean z) {
            us.pinguo.common.log.a.c("onShareComplete:" + shareSite + ", fakeComplete" + z, new Object[0]);
            if (z) {
                return;
            }
            WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.pinguo.camera360.lib.ui.e
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.d.this.b();
                }
            });
        }

        @Override // us.pinguo.share.core.PGShareListener
        public void onShareError(ShareSite shareSite, Throwable th) {
            us.pinguo.common.log.a.e("onShareError:" + shareSite + ":" + th.toString(), new Object[0]);
            if (th instanceof AppNotExistException) {
                WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.pinguo.camera360.lib.ui.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        WebViewActivity.d.this.d();
                    }
                });
            } else {
                WebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.pinguo.camera360.lib.ui.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        WebViewActivity.d.this.f();
                    }
                });
            }
        }
    }

    /* loaded from: classes3.dex */
    class e extends us.pinguo.webview.d {
        e(PGJsWebView pGJsWebView) {
            super(pGJsWebView);
        }

        @Override // us.pinguo.webview.d, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            String str2;
            super.onPageFinished(webView, str);
            if (WebViewActivity.this.v != null) {
                WebViewActivity.this.v.setText(str);
            }
            if (str == null || (str2 = (String) WebViewActivity.this.f6844i.get(str)) == null || !TextUtils.isEmpty(WebViewActivity.this.y)) {
                return;
            }
            WebViewActivity.this.s.setText(str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            if (WebViewActivity.this.N.equals(str2)) {
                WebViewActivity webViewActivity = WebViewActivity.this;
                webViewActivity.A1(webViewActivity.M);
                return;
            }
            u.b(webView);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (WebViewActivity.this.L) {
                return;
            }
            us.pinguo.foundation.ui.f.d(WebViewActivity.this, webView.getUrl(), sslErrorHandler);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str == null) {
                return false;
            }
            if (!str.startsWith(Constants.HTTP_PROTOCOL_PREFIX) && !str.startsWith(Constants.HTTPS_PROTOCOL_PREFIX)) {
                WebViewActivity.this.A1(str);
                return true;
            }
            if (!str.contains("http://wm.10086.cn/view/html5/download.do")) {
                WebViewActivity.this.A1(str);
            } else {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                WebViewActivity.this.startActivity(intent);
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    class f implements Runnable {
        final /* synthetic */ String a;

        /* loaded from: classes3.dex */
        class a implements PayCallback {
            a() {
            }

            @Override // us.pinguo.paylibcenter.PayCallback
            public void H(PayResult payResult) {
                WebViewActivity.this.Y0(payResult.getStatus(), payResult.getMessage());
                WebViewActivity.this.W0("pay_fail", payResult.getMessage());
            }

            @Override // us.pinguo.paylibcenter.PayCallback
            public void W() {
            }

            @Override // us.pinguo.paylibcenter.PayCallback
            public void d(PayResult payResult) {
                WebViewActivity.this.Y0(200, "");
                WebViewActivity.this.W0("pay_success", "");
            }

            @Override // us.pinguo.paylibcenter.PayCallback
            public void e(PayResult payResult) {
                WebViewActivity.this.Y0(10999, payResult.getMessage());
                WebViewActivity.this.W0("pay_cancel", "");
            }

            @Override // us.pinguo.paylibcenter.PayCallback
            public void s() {
            }
        }

        f(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!us.pinguo.util.s.i("com.eg.android.AlipayGphone", 50, BaseApplication.d())) {
                WebViewActivity.this.f6841f.d(WebViewActivity.this.q, new us.pinguo.webview.f.e(10990, "未安装"));
                WebViewActivity.this.f6841f = null;
                return;
            }
            PayHelp.getInstance().C(WebViewActivity.this, this.a, new a());
        }
    }

    /* loaded from: classes3.dex */
    class g implements Runnable {

        /* loaded from: classes3.dex */
        class a implements PayCallback {
            a() {
            }

            @Override // us.pinguo.paylibcenter.PayCallback
            public void H(PayResult payResult) {
                WebViewActivity.this.f6842g.d(WebViewActivity.this.q, new us.pinguo.webview.f.e(10999, payResult.getMessage()));
                WebViewActivity.this.X0("pay_fail", payResult.getMessage());
            }

            @Override // us.pinguo.paylibcenter.PayCallback
            public void W() {
            }

            @Override // us.pinguo.paylibcenter.PayCallback
            public void d(PayResult payResult) {
                WebViewActivity.this.f6842g.d(WebViewActivity.this.q, new us.pinguo.webview.f.e());
                WebViewActivity.this.X0("pay_success", "");
            }

            @Override // us.pinguo.paylibcenter.PayCallback
            public void e(PayResult payResult) {
                WebViewActivity.this.f6842g.d(WebViewActivity.this.q, new us.pinguo.webview.f.e(10999, payResult.getMessage()));
                WebViewActivity.this.X0("pay_cancel", "");
            }

            @Override // us.pinguo.paylibcenter.PayCallback
            public void s() {
            }
        }

        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WebViewActivity.this.p != null) {
                PayHelp payHelp = PayHelp.getInstance();
                WebViewActivity webViewActivity = WebViewActivity.this;
                payHelp.I(webViewActivity, webViewActivity.c1(webViewActivity.f6842g), new a());
            }
        }
    }

    /* loaded from: classes3.dex */
    class h extends AsyncTask<Void, Void, String> {
        final /* synthetic */ Intent a;

        h(Intent intent) {
            this.a = intent;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.foundation.utils.AsyncTask
        /* renamed from: a */
        public String doInBackground(Void... voidArr) {
            WebViewActivity webViewActivity = WebViewActivity.this;
            return us.pinguo.webview.b.i(w.a(webViewActivity, 1003, this.a, webViewActivity.x, WebViewActivity.this.f6839d == null ? "1280" : WebViewActivity.this.f6839d.b().a()));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.foundation.utils.AsyncTask
        /* renamed from: b */
        public void onPostExecute(String str) {
            us.pinguo.common.log.a.c("get picture,localId is:" + str, new Object[0]);
            if (TextUtils.isEmpty(str)) {
                WebViewActivity.this.f6839d.d(WebViewActivity.this.q, new com.pinguo.camera360.lib.ui.js.g(10502, "Save file failed"));
                WebViewActivity.this.f6839d = null;
                return;
            }
            com.pinguo.camera360.lib.ui.js.g gVar = new com.pinguo.camera360.lib.ui.js.g();
            gVar.b(str);
            WebViewActivity.this.f6839d.d(WebViewActivity.this.q, gVar);
            WebViewActivity.this.f6839d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class i extends AsyncTask<Object, Object, String> {
        final /* synthetic */ int a;
        final /* synthetic */ Intent b;

        i(int i2, Intent intent) {
            this.a = i2;
            this.b = intent;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.foundation.utils.AsyncTask
        /* renamed from: a */
        public String doInBackground(Object... objArr) {
            WebViewActivity webViewActivity = WebViewActivity.this;
            return w.a(webViewActivity, this.a, this.b, webViewActivity.x, "2048");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.foundation.utils.AsyncTask
        /* renamed from: b */
        public void onPostExecute(String str) {
            View view = WebViewActivity.this.r;
            view.setVisibility(8);
            VdsAgent.onSetViewVisibility(view, 8);
            if (TextUtils.isEmpty(str)) {
                WebViewActivity.this.k();
            } else if ("ERROR_TYPE".equals(str)) {
                Toast makeText = Toast.makeText(WebViewActivity.this, (int) R.string.photo_pick_video_msg_not_support, 0);
                makeText.show();
                VdsAgent.showToast(makeText);
                WebViewActivity.this.k();
            } else {
                Uri uriForFile = FileProvider.getUriForFile(WebViewActivity.this, "vStudio.Android.Camera360.fileProvider", new File(str));
                if (WebViewActivity.this.E != null) {
                    if (uriForFile == null) {
                        WebViewActivity.this.E.onReceiveValue(null);
                    } else {
                        WebViewActivity.this.E.onReceiveValue(new Uri[]{uriForFile});
                    }
                    WebViewActivity.this.E = null;
                }
                if (WebViewActivity.this.F != null) {
                    WebViewActivity.this.F.onReceiveValue(uriForFile);
                    WebViewActivity.this.F = null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class j extends AsyncTask<Object, Object, String> {
        final /* synthetic */ int a;
        final /* synthetic */ Intent b;

        j(int i2, Intent intent) {
            this.a = i2;
            this.b = intent;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.foundation.utils.AsyncTask
        /* renamed from: a */
        public String doInBackground(Object... objArr) {
            WebViewActivity webViewActivity = WebViewActivity.this;
            return w.a(webViewActivity, this.a, this.b, webViewActivity.x, WebViewActivity.this.c.b().a());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.foundation.utils.AsyncTask
        /* renamed from: b */
        public void onPostExecute(String str) {
            View view = WebViewActivity.this.r;
            view.setVisibility(8);
            VdsAgent.onSetViewVisibility(view, 8);
            String i2 = us.pinguo.webview.b.i(str);
            if (i2 == null) {
                WebViewActivity.this.c.d(WebViewActivity.this.q, new f0(10502, "Save file failed"));
                WebViewActivity.this.c = null;
            } else if ("ERROR_TYPE".equals(str)) {
                Toast makeText = Toast.makeText(BaseApplication.d(), (int) R.string.only_need_jpeg, 0);
                makeText.show();
                VdsAgent.showToast(makeText);
                WebViewActivity.this.c.d(WebViewActivity.this.q, new f0(10500, "图片格式不符"));
                WebViewActivity.this.c = null;
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(i2);
                f0 f0Var = new f0();
                f0Var.b(arrayList);
                WebViewActivity.this.c.d(WebViewActivity.this.q, f0Var);
                WebViewActivity.this.c = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class k extends us.pinguo.pgshare.commons.b {
        k() {
        }

        @Override // us.pinguo.pgshare.commons.b
        public void b(us.pinguo.pgshare.commons.c cVar, ResolveInfo resolveInfo) {
        }

        @Override // us.pinguo.pgshare.commons.b
        public void c(us.pinguo.pgshare.commons.c cVar, ShareSite shareSite) {
            WebViewActivity.this.q.e(t.c(shareSite));
            WebViewActivity.this.B = shareSite;
            cVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    private class l {
        private l() {
        }

        @JavascriptInterface
        public void exit() {
            WebViewActivity.this.finish();
        }

        @JavascriptInterface
        public int needBuyFilter(String str) {
            if (VipManager.a.e(true)) {
                return 0;
            }
            ShowPkg h2 = us.pinguo.camera360.shop.data.show.u.b().h(str);
            return (h2 == null || us.pinguo.camera360.shop.data.show.u.b().j(h2)) ? 1 : 0;
        }

        @JavascriptInterface
        public void reportBaseEvent(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("element_id");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                us.pinguo.foundation.statistics.h.a.G(optString, jSONObject.optString("sub_element_id", ""), jSONObject.optString(PageEvent.TYPE_NAME, ""), jSONObject.optString(AuthActivity.ACTION_KEY, ""));
                if (us.pinguo.foundation.d.f10987f) {
                    Log.e("Frisky", "reportEvent msg:" + str);
                }
            } catch (Exception unused) {
                if (us.pinguo.foundation.d.f10987f) {
                    Log.e("Frisky", "reportEvent error, msg:" + str);
                }
            }
        }

        @JavascriptInterface
        public void reportEvent(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("element_id");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                us.pinguo.foundation.statistics.h.a.v0(optString, jSONObject.optString("sub_element_id", ""), jSONObject.optString(PageEvent.TYPE_NAME, ""), jSONObject.optString("content_id", ""), jSONObject.optString(AuthActivity.ACTION_KEY, ""), String.valueOf(jSONObject.optInt(TapjoyConstants.TJC_AMOUNT, 1)));
                if (us.pinguo.foundation.d.f10987f) {
                    Log.e("Frisky", "reportEvent msg:" + str);
                }
            } catch (Exception unused) {
                if (us.pinguo.foundation.d.f10987f) {
                    Log.e("Frisky", "reportEvent error, msg:" + str);
                }
            }
        }

        @JavascriptInterface
        public void setH5Info(String str) {
            try {
                String optString = new JSONObject(str).optString("h5StatUrl");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                WebViewActivity.this.H = optString;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /* synthetic */ l(WebViewActivity webViewActivity, d dVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A1(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        us.pinguo.common.log.a.g("WebviewActivity", "url:" + str, new Object[0]);
        boolean startsWith = str.startsWith("market://");
        boolean startsWith2 = str.startsWith("https://play.google.com");
        if (!startsWith && !startsWith2) {
            if (!str.startsWith("app://") && !str.startsWith("component://")) {
                if (str.startsWith("scheme://")) {
                    a1(str);
                } else if (!str.startsWith(Constants.HTTP_PROTOCOL_PREFIX) && !str.startsWith(Constants.HTTPS_PROTOCOL_PREFIX)) {
                    if (str.startsWith(InspirePublishFragment.FILE_HEADER)) {
                        this.q.loadUrl(str);
                    } else {
                        String str2 = this.z;
                        if (str2 != null && str2.contains("printshop.in66.com")) {
                            if (str.startsWith("weixin://wap/pay?")) {
                                us.pinguo.foundation.statistics.h.a.a0("in", "wxpay_click");
                            } else if (str.startsWith("alipays://")) {
                                us.pinguo.foundation.statistics.h.a.a0("in", "alipay_click");
                            }
                        }
                        try {
                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        } catch (Throwable th) {
                            Log.e("Web", "uri:" + str, th);
                        }
                    }
                } else {
                    if (str.contains("printshop.in66.com") && str.contains("paysucc.html")) {
                        us.pinguo.foundation.statistics.h.a.a0("in", "pay_success");
                    }
                    TextView textView = this.t;
                    textView.setVisibility(8);
                    VdsAgent.onSetViewVisibility(textView, 8);
                    this.u.setVisibility(8);
                    this.f6847l = null;
                    if (getIntent() != null && getIntent().hasExtra("web_view_data")) {
                        this.q.postUrl(str, getIntent().getStringExtra("web_view_data").getBytes());
                    } else if (TextUtils.isEmpty(this.w)) {
                        this.q.loadUrl(str);
                    } else {
                        HashMap hashMap = new HashMap();
                        hashMap.put("Referer", this.w);
                        this.q.loadUrl(str, hashMap);
                    }
                }
            } else {
                int asyncValidAndUpdate = Interaction.asyncValidAndUpdate(str, new Interaction.InteractionListener() { // from class: com.pinguo.camera360.lib.ui.i
                    @Override // com.pinguo.camera360.adv.interaction.Interaction.InteractionListener
                    public final void valid(boolean z) {
                        WebViewActivity.this.n1(str, z);
                    }
                });
                if (asyncValidAndUpdate == 0) {
                    this.S = str;
                    AppGoto.getInstance().c(str).b(this);
                    if (!Interaction.isInspireGoTo(str)) {
                        finish();
                    }
                } else if (asyncValidAndUpdate == 1) {
                    runOnUiThread(new Runnable() { // from class: com.pinguo.camera360.lib.ui.q
                        @Override // java.lang.Runnable
                        public final void run() {
                            WebViewActivity.this.p1();
                        }
                    });
                }
            }
        } else if (us.pinguo.util.p.d()) {
            d1(startsWith, str);
        } else if (us.pinguo.util.s.h("com.android.vending", BaseApplication.d())) {
            try {
                Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage("com.android.vending");
                launchIntentForPackage.setAction("android.intent.action.VIEW");
                launchIntentForPackage.setData(Uri.parse(str));
                this.q.getContext().startActivity(launchIntentForPackage);
            } catch (Exception unused) {
                d1(startsWith, str);
            }
        } else {
            d1(startsWith, str);
        }
        us.pinguo.common.log.a.m("WebviewActivity", "web view load url:" + str, new Object[0]);
    }

    private void B1() {
        User d2 = User.d();
        if (d2.n()) {
            C1(d2.h());
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this, PGLoginMainActivity.class);
        startActivityForResult(intent, AdError.INTERNAL_ERROR_CODE);
    }

    private void C1(User.Info info) {
        RespJsData respJsData;
        if (TextUtils.isEmpty(this.m)) {
            return;
        }
        String queryParameter = Uri.parse(this.m).getQueryParameter("blockRes");
        if (!TextUtils.isEmpty(queryParameter)) {
            if (info != null) {
                respJsData = new RespJsData(200, "", info);
            } else {
                respJsData = new RespJsData(99, "登录失败或取消", null);
            }
            String t = new com.google.gson.e().t(respJsData, RespJsData.class);
            this.q.j(queryParameter + "('" + t + "')");
        }
        this.m = null;
    }

    private void D1(int i2, int i3, Intent intent) {
        if (this.E != null || this.F != null) {
            if (i3 != -1) {
                k();
                return;
            }
            View view = this.r;
            view.setVisibility(0);
            VdsAgent.onSetViewVisibility(view, 0);
            new i(i2, intent).execute(new Object[0]);
            return;
        }
        us.pinguo.webview.f.h.d dVar = this.c;
        if (dVar == null) {
            return;
        }
        if (i3 != -1) {
            dVar.d(this.q, new f0(10400, "cancel"));
            this.c = null;
            return;
        }
        View view2 = this.r;
        view2.setVisibility(0);
        VdsAgent.onSetViewVisibility(view2, 0);
        new j(i2, intent).execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E1() {
        runOnUiThread(new Runnable() { // from class: com.pinguo.camera360.lib.ui.k
            @Override // java.lang.Runnable
            public final void run() {
                WebViewActivity.this.y1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F1 */
    public void l1(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String queryParameter = Uri.parse(str).getQueryParameter("chinnel");
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        String[] a2 = us.pinguo.foundation.utils.f0.a(queryParameter, ",");
        if (a2.length == 0) {
            return;
        }
        this.A = new f.b();
        for (String str2 : a2) {
            if (ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE.equals(str2)) {
                this.A.g(ShareSite.WECHAT_FRIENDS);
            } else if ("wechatMoments".equals(str2)) {
                this.A.g(ShareSite.WECHAT_MOMENTS);
            } else if ("qq".equals(str2)) {
                this.A.g(ShareSite.QQ);
            } else if ("qqzone".equals(str2)) {
                this.A.g(ShareSite.QZONE);
            } else if ("facebook".equals(str2)) {
                this.A.g(ShareSite.FACEBOOK);
            } else if (FindFriendHeaderCell.TWITTER.equals(str2)) {
                this.A.g(ShareSite.TWITTER);
            } else if ("weibo".equals(str2)) {
                this.A.g(ShareSite.SINAWEIBO);
            }
        }
        if (this.A.j()) {
            return;
        }
        us.pinguo.pgshare.commons.d.b(this.A.h(), this, new b());
    }

    private void G1(String str, int i2) {
        Uri uri;
        try {
            uri = Uri.parse(str);
        } catch (NullPointerException e2) {
            us.pinguo.common.log.a.e("解析 uri 失败==>" + e2.getMessage(), new Object[0]);
            uri = null;
        }
        if (uri == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("blockRes");
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        this.q.j(queryParameter + "(" + i2 + ")");
    }

    private void H1(String str, String str2) {
        String queryParameter = Uri.parse(str).getQueryParameter("blockRes");
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        this.q.j(queryParameter + "('" + str2 + "')");
    }

    private void I1(String str, User.Info info) {
        RespJsData respJsData;
        String queryParameter = Uri.parse(str).getQueryParameter("blockRes");
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        if (info != null) {
            respJsData = new RespJsData(200, "", info);
        } else {
            respJsData = new RespJsData(99, "用户未登录", null);
        }
        String t = new com.google.gson.e().t(respJsData, RespJsData.class);
        this.q.j(queryParameter + "('" + t + "')");
    }

    private void W() {
        if (this.C) {
            us.pinguo.webview.f.f.a(this.q, "pinguoJSShare", new g.b[0]);
        } else if (a1(this.f6845j)) {
            this.f6846k = this.f6845j;
            this.f6845j = null;
        } else {
            f.b bVar = this.A;
            if (bVar != null) {
                us.pinguo.pgshare.commons.d.b(bVar.h(), this, new k());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0(String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("element_id", "zhuawawa_zhifubao_pay");
        hashMap.put(AuthActivity.ACTION_KEY, str);
        hashMap.put("content_id", str2);
        hashMap.put(TapjoyConstants.TJC_AMOUNT, "1");
        AdvStaticsticManager.GetInstance().GetStaticInterface().ReportBDNoKey("advance_element_action", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0(String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("element_id", "zhuawawa_wechat_pay");
        hashMap.put(AuthActivity.ACTION_KEY, str);
        hashMap.put("content_id", str2);
        hashMap.put(TapjoyConstants.TJC_AMOUNT, "1");
        AdvStaticsticManager.GetInstance().GetStaticInterface().ReportBDNoKey("advance_element_action", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0(int i2, String str) {
        us.pinguo.webview.f.h.b bVar = this.f6841f;
        if (bVar != null) {
            bVar.d(this.q, new us.pinguo.webview.f.e(i2, str));
            this.f6841f = null;
        }
    }

    private void Z0(String str, String str2) {
        if (str2 == null) {
            str2 = "error_id";
        }
        String queryParameter = Uri.parse(str).getQueryParameter("blockRes");
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        this.q.j(queryParameter + "('" + str2 + "')");
    }

    private boolean a1(final String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (!"http".equals(scheme) && !"https".equals(scheme) && !"app".equals(scheme) && !"market".equals(scheme) && !"component".equals(scheme)) {
            if ("js".equals(scheme)) {
                this.q.j(str.replace("js://", ""));
                return true;
            }
            if ("scheme".equals(scheme)) {
                String authority = parse.getAuthority();
                if (FirebaseAnalytics.Event.LOGIN.equals(authority)) {
                    this.m = str;
                    B1();
                    return true;
                } else if ("showShareDialog".equals(authority)) {
                    us.pinguo.user.util.j.a.b(this, new Runnable() { // from class: com.pinguo.camera360.lib.ui.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            WebViewActivity.this.l1(str);
                        }
                    }, null, null);
                    return true;
                } else if ("exit".equals(authority)) {
                    finish();
                    return true;
                } else if ("getUserId".equals(authority)) {
                    User d2 = User.d();
                    if (d2.n()) {
                        H1(str, d2.h().userId);
                    } else {
                        H1(str, "");
                    }
                } else if ("getUserInfo".equals(authority)) {
                    User d3 = User.d();
                    if (d3.n()) {
                        I1(str, d3.h());
                    } else {
                        I1(str, null);
                    }
                } else if ("subscribe".equals(authority)) {
                    if (VipManager.a.I()) {
                        G1(str, 1);
                    } else {
                        this.n = str;
                        e1();
                    }
                } else if ("getDeviceId".equals(authority) || "getDeviceID".equals(authority)) {
                    Z0(str, us.pinguo.bigdata.a.e());
                }
            }
            return false;
        }
        A1(str);
        return true;
    }

    private String b1() {
        if (!TextUtils.isEmpty(this.H)) {
            return this.H;
        }
        String str = this.z;
        if (str != null) {
            if (str.startsWith(Constants.HTTP_PROTOCOL_PREFIX)) {
                return this.z.substring(7);
            }
            if (this.z.startsWith(Constants.HTTPS_PROTOCOL_PREFIX)) {
                return this.z.substring(8);
            }
            return this.z;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WxReqBean c1(us.pinguo.webview.f.h.o oVar) {
        WxReqBean wxReqBean = new WxReqBean();
        b0 b2 = oVar.b();
        wxReqBean.setAppId(WXPayEntryActivity.b);
        wxReqBean.setPartnerId("1265888101");
        wxReqBean.setPrepayId(b2.c());
        wxReqBean.setNonceStr(b2.a());
        wxReqBean.setPackageValue(b2.b());
        wxReqBean.setSign(b2.d());
        wxReqBean.setTimeStamp(b2.e());
        return wxReqBean;
    }

    private void d1(boolean z, String str) {
        if (z) {
            this.q.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return;
        }
        TextView textView = this.t;
        textView.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView, 8);
        this.u.setVisibility(8);
        this.f6847l = null;
        this.q.loadUrl(str);
    }

    private void e1() {
        VipManager vipManager = VipManager.a;
        vipManager.S(null);
        Intent intent = new Intent();
        if (!vipManager.G() && !vipManager.H()) {
            intent.setClassName(this, "com.pinguo.camera360.member.MemberRightsActivity");
        } else {
            intent.setClassName(this, "com.pinguo.camera360.member.SubscriptionMemberActivity");
        }
        startActivityForResult(intent, 1015);
    }

    private void f1() {
        setSupportActionBar((Toolbar) findViewById(R.id.app_webview_title_bar));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayUseLogoEnabled(false);
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g1 */
    public /* synthetic */ void h1() {
        this.u.setVisibility(8);
        TextView textView = this.t;
        textView.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i1 */
    public /* synthetic */ void j1(t.b bVar) {
        if (!TextUtils.isEmpty(bVar.a())) {
            this.u.setVisibility(0);
            this.u.setImageURI(Uri.parse(bVar.a()));
            TextView textView = this.t;
            textView.setVisibility(8);
            VdsAgent.onSetViewVisibility(textView, 8);
            return;
        }
        TextView textView2 = this.t;
        textView2.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView2, 0);
        this.t.setText(bVar.b());
        this.u.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m1 */
    public /* synthetic */ void n1(String str, boolean z) {
        if (this.L) {
            return;
        }
        AlertDialog alertDialog = this.K;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.K = null;
        }
        if (Interaction.isValid(str)) {
            AppGoto.getInstance().c(str).b(this);
            finish();
            return;
        }
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        if ("effect".equals(lastPathSegment) || "effectopen".equals(lastPathSegment)) {
            Toast makeText = Toast.makeText(this, (int) R.string.no_effect_resource_url, 1);
            makeText.show();
            VdsAgent.showToast(makeText);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o1 */
    public /* synthetic */ void p1() {
        if (this.L) {
            return;
        }
        this.K = us.pinguo.foundation.utils.w.r(this, R.string.downloading, R.string.downloading);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean q1(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r1 */
    public /* synthetic */ void s1(String str) {
        d.h.a.a.d(str, getWindow().getDecorView(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t1 */
    public /* synthetic */ void u1(us.pinguo.webview.f.h.k kVar) {
        f.b bVar = this.A;
        if (bVar == null || bVar.j()) {
            return;
        }
        x b2 = kVar.b();
        String d2 = b2.d();
        String c2 = b2.c();
        String a2 = b2.a();
        String b3 = b2.b();
        PGShareInfo pGShareInfo = new PGShareInfo();
        pGShareInfo.setTitle(d2);
        pGShareInfo.setText(a2);
        pGShareInfo.setWebUrl(c2);
        pGShareInfo.setThumbnailUri(b3);
        int i2 = c.a[this.B.ordinal()];
        if (i2 == 1) {
            pGShareInfo.setText(us.pinguo.share.util.n.b(getApplicationContext()) + a2);
        } else if (i2 != 2) {
            if (i2 == 3 && TextUtils.isEmpty(a2)) {
                pGShareInfo.setText(getString(R.string.share_default_message));
            }
        } else {
            pGShareInfo.setText(us.pinguo.share.util.n.a(getApplicationContext()) + a2);
        }
        ShareSite shareSite = this.B;
        if (shareSite == ShareSite.FACEBOOK) {
            if (!us.pinguo.util.s.h("com.facebook.katana", this)) {
                k0.a.a(R.string.not_install_app);
            } else {
                us.pinguo.share.b.d(this, pGShareInfo, this.I);
            }
        } else if (shareSite != ShareSite.QQ && shareSite != ShareSite.SINAWEIBO && shareSite != ShareSite.WECHAT_FRIENDS && shareSite != ShareSite.WECHAT_MOMENTS) {
            if (!TextUtils.isEmpty(pGShareInfo.getWebUrl())) {
                pGShareInfo.setText(pGShareInfo.getText() + "  " + pGShareInfo.getWebUrl());
                pGShareInfo.setWebUrl("");
            }
            PGShareManager.getInstance().intentShare(this, this.B.getPackageName(), null, pGShareInfo, this.I);
        } else {
            PGShareManager.getInstance().siteShare(this, this.B, pGShareInfo, this.I);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v1 */
    public /* synthetic */ void w1() {
        TextView textView = this.t;
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x1 */
    public /* synthetic */ void y1() {
        if (this.o == null) {
            PickPhotoDialog pickPhotoDialog = new PickPhotoDialog(this);
            this.o = pickPhotoDialog;
            pickPhotoDialog.b(this);
        }
        this.o.setCanceledOnTouchOutside(true);
        this.o.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void z1(int i2) {
        Toast makeText = Toast.makeText(BaseApplication.d(), i2, 1);
        makeText.show();
        VdsAgent.showToast(makeText);
    }

    @Override // com.pinguo.camera360.lib.ui.s.b
    public void B(com.pinguo.camera360.lib.ui.js.c cVar) {
        this.f6840e = cVar;
        Intent intent = new Intent();
        intent.setClass(this, PGLoginMainActivity.class);
        startActivityForResult(intent, AdError.INTERNAL_ERROR_CODE);
    }

    @Override // com.pinguo.camera360.lib.ui.s.b
    public void I(us.pinguo.webview.f.h.j jVar) {
        final String g2 = us.pinguo.webview.b.g(jVar.b().a());
        if (g2 == null) {
            jVar.d(this.q, new h0(10300, "arg error"));
        } else if (new File(g2).exists()) {
            runOnUiThread(new Runnable() { // from class: com.pinguo.camera360.lib.ui.h
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.this.s1(g2);
                }
            });
        } else {
            jVar.d(this.q, new h0(10300, "arg error"));
        }
    }

    @Override // us.pinguo.webview.g.a
    public void J(boolean z) {
        this.C = z;
        if (z) {
            TextView textView = this.t;
            textView.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView, 0);
            this.t.setText(R.string.pgcommon_share);
            this.u.setVisibility(8);
        }
    }

    @Override // com.pinguo.camera360.lib.ui.s.b
    public void K(final int i2) {
        runOnUiThread(new Runnable() { // from class: com.pinguo.camera360.lib.ui.m
            @Override // java.lang.Runnable
            public final void run() {
                WebViewActivity.z1(i2);
            }
        });
    }

    @Override // com.pinguo.camera360.lib.ui.s.b
    public void U(us.pinguo.webview.f.h.d dVar) {
        this.c = dVar;
        String b2 = dVar.b().b();
        if (!TextUtils.isEmpty(b2) && !PortalFollowFeeds.TYPE_ALL.equals(b2)) {
            if ("camera".equals(b2)) {
                f0();
                return;
            } else if (BigAlbumStore.TABLE_GALLERY.equals(b2)) {
                r();
                return;
            } else {
                this.c.d(this.q, new f0(10300, "arg error"));
                this.c = null;
                return;
            }
        }
        E1();
    }

    @Override // com.pinguo.camera360.lib.ui.s.b
    public boolean Z(List<String> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        this.A = new f.b();
        for (String str : list) {
            if (ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE.equals(str)) {
                this.A.g(ShareSite.WECHAT_FRIENDS);
            } else if ("wechatMoments".equals(str)) {
                this.A.g(ShareSite.WECHAT_MOMENTS);
            } else if ("qq".equals(str)) {
                this.A.g(ShareSite.QQ);
            } else if ("qqzone".equals(str)) {
                this.A.g(ShareSite.QZONE);
            } else if ("facebook".equals(str)) {
                this.A.g(ShareSite.FACEBOOK);
            } else if (FindFriendHeaderCell.TWITTER.equals(str)) {
                this.A.g(ShareSite.TWITTER);
            } else if ("weibo".equals(str)) {
                this.A.g(ShareSite.SINAWEIBO);
            }
        }
        if (this.A.j()) {
            return true;
        }
        runOnUiThread(new Runnable() { // from class: com.pinguo.camera360.lib.ui.o
            @Override // java.lang.Runnable
            public final void run() {
                WebViewActivity.this.w1();
            }
        });
        return true;
    }

    @Override // com.pinguo.camera360.lib.ui.s.b
    public void a0(com.pinguo.camera360.lib.ui.js.b bVar) {
        this.f6839d = bVar;
        String b2 = bVar.b().b();
        us.pinguo.common.log.a.c("chooseC360Img url:" + b2, new Object[0]);
        if (TextUtils.isEmpty(b2)) {
            this.f6839d.d(this.q, new com.pinguo.camera360.lib.ui.js.g(10300, "arg error"));
            this.f6839d = null;
            return;
        }
        v vVar = this.J;
        if (vVar != null) {
            vVar.f();
        }
        this.J = new v(this, this.f6839d, this.q, this);
        try {
            if (this.J.q(Uri.parse(b2))) {
                return;
            }
            this.f6839d.d(this.q, new com.pinguo.camera360.lib.ui.js.g(10300, "arg error"));
            this.f6839d = null;
        } catch (Exception unused) {
            this.f6839d.d(this.q, new com.pinguo.camera360.lib.ui.js.g(10300, "arg error"));
            this.f6839d = null;
        }
    }

    @Override // com.pinguo.camera360.lib.ui.s.b
    public void c(us.pinguo.webview.f.h.e eVar) {
        this.f6847l = eVar.b().a();
        eVar.d(this.q, new us.pinguo.webview.f.e());
    }

    @Override // com.pinguo.camera360.lib.ui.s.b
    public void d(com.pinguo.camera360.lib.ui.js.a aVar) {
        this.f6843h = aVar;
        Intent intent = new Intent();
        intent.setClassName(this, "us.pinguo.inspire.PhoneBindActivity");
        startActivityForResult(intent, 1004);
    }

    @Override // com.pinguo.camera360.lib.ui.s.b
    public void d0(final us.pinguo.webview.f.h.k kVar) {
        runOnUiThread(new Runnable() { // from class: com.pinguo.camera360.lib.ui.p
            @Override // java.lang.Runnable
            public final void run() {
                WebViewActivity.this.u1(kVar);
            }
        });
    }

    @Override // com.pinguo.camera360.lib.ui.PickPhotoDialog.a
    public void f0() {
        String f2 = us.pinguo.webview.b.f("IMG_" + System.currentTimeMillis() + ".jpg");
        this.x = f2;
        if (f2 == null) {
            us.pinguo.webview.f.h.d dVar = this.c;
            if (dVar != null) {
                dVar.d(this.q, new f0(10300, "can not get android path"));
                this.c = null;
                return;
            }
            return;
        }
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", FileProvider.getUriForFile(this, "vStudio.Android.Camera360.fileProvider", new File(this.x)));
        startActivityForResult(intent, 1001);
    }

    @Override // com.pinguo.camera360.lib.ui.s.b
    public void g0(us.pinguo.webview.f.h.f fVar) {
        List<t.c> b2 = fVar.b().b();
        if (b2 != null && !b2.isEmpty()) {
            t.c cVar = b2.get(0);
            String a2 = cVar.a();
            final t.b b3 = cVar.b();
            if (!TextUtils.isEmpty(a2) && b3 != null) {
                this.f6845j = a2;
                this.f6846k = a2;
                runOnUiThread(new Runnable() { // from class: com.pinguo.camera360.lib.ui.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        WebViewActivity.this.j1(b3);
                    }
                });
                fVar.d(this.q, new us.pinguo.webview.f.e());
                return;
            }
            fVar.d(this.q, new us.pinguo.webview.f.e(200, "hide menu bar!"));
            return;
        }
        this.f6845j = null;
        runOnUiThread(new Runnable() { // from class: com.pinguo.camera360.lib.ui.r
            @Override // java.lang.Runnable
            public final void run() {
                WebViewActivity.this.h1();
            }
        });
        fVar.d(this.q, new us.pinguo.webview.f.e(200, "hide menu bar!"));
    }

    @Override // com.pinguo.camera360.lib.ui.PickPhotoDialog.a
    public void k() {
        ValueCallback<Uri[]> valueCallback = this.E;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
            this.E = null;
        }
        ValueCallback valueCallback2 = this.F;
        if (valueCallback2 != null) {
            valueCallback2.onReceiveValue(null);
            this.F = null;
        }
        us.pinguo.webview.f.h.d dVar = this.c;
        if (dVar != null) {
            dVar.d(this.q, new f0(10400, "cancel"));
            this.c = null;
        }
        com.pinguo.camera360.lib.ui.js.b bVar = this.f6839d;
        if (bVar != null) {
            bVar.d(this.q, new com.pinguo.camera360.lib.ui.js.g(10400, "cancel"));
            this.f6839d = null;
        }
    }

    @Override // com.pinguo.camera360.lib.ui.s.b
    public void o(us.pinguo.webview.f.h.o oVar) {
        X0("pay_request", "");
        this.f6842g = oVar;
        runOnUiThread(new g());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 205 || i2 == 1005) {
            if (i3 == -1) {
                k1(this.f6846k);
            } else {
                this.f6846k = this.f6845j;
            }
        } else if (i2 == 1001 || i2 == 1002) {
            D1(i2, i3, intent);
        } else if (i2 == 2001) {
            com.pinguo.camera360.lib.ui.js.c cVar = this.f6840e;
            if (cVar == null) {
                User d2 = User.d();
                if (d2.n()) {
                    C1(d2.h());
                } else {
                    C1(null);
                }
            } else if (i3 != -1) {
                cVar.d(this.q, new com.pinguo.camera360.lib.ui.js.h(10400, "cancel"));
                this.f6840e = null;
            } else {
                User.Info h2 = User.d().h();
                if (h2 != null && !TextUtils.isEmpty(h2.userId) && !TextUtils.isEmpty(h2.token)) {
                    com.pinguo.camera360.lib.ui.js.h hVar = new com.pinguo.camera360.lib.ui.js.h();
                    hVar.b(new RespJsData(200, "", h2));
                    this.f6840e.d(this.q, hVar);
                    this.f6840e = null;
                    return;
                }
                this.f6840e.d(this.q, new com.pinguo.camera360.lib.ui.js.h(10999, "登录失败"));
                this.f6840e = null;
            }
        } else if (i2 == 1003) {
            if (i3 != -1) {
                k();
            } else {
                new h(intent).execute(new Void[0]);
            }
        } else if (i2 == 1004) {
            if (i3 != -1) {
                this.f6843h.d(this.q, new com.pinguo.camera360.lib.ui.js.f(10400, "cancel"));
                this.f6843h = null;
                return;
            }
            String stringExtra = intent.getStringExtra("bind_mobile");
            if (TextUtils.isEmpty(stringExtra)) {
                this.f6843h.d(this.q, new com.pinguo.camera360.lib.ui.js.f(10300, "mobile number error"));
                this.f6843h = null;
                return;
            }
            com.pinguo.camera360.lib.ui.js.f fVar = new com.pinguo.camera360.lib.ui.js.f();
            fVar.b(stringExtra);
            this.f6843h.d(this.q, fVar);
            this.f6843h = null;
        } else if (i2 == 1015) {
            String str = this.n;
            this.n = null;
            VipManager vipManager = VipManager.a;
            String y = vipManager.y();
            if (i3 == -1) {
                if (y == null) {
                    y = "unknown";
                }
                us.pinguo.foundation.statistics.h.a.v0("vip_sub_success_action", y, "h5", b1(), "sub_success", "1");
                G1(str, 1);
            } else if (y != null) {
                us.pinguo.foundation.statistics.h.a.v0("vip_sub_success_action", y, "h5", b1(), "false", "1");
                G1(str, 0);
            }
            vipManager.S(null);
        }
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        int id = view.getId();
        if (id != R.id.btn_input_url) {
            switch (id) {
                case R.id.title_finish_all_btn /* 2131298179 */:
                    finish();
                    return;
                case R.id.title_finish_btn /* 2131298180 */:
                    if (!T && this.q.canGoBack() && this.O) {
                        this.q.goBack();
                        return;
                    } else {
                        finish();
                        return;
                    }
                case R.id.title_right_btn_res_0x7f090785 /* 2131298181 */:
                case R.id.title_right_img_btn /* 2131298182 */:
                    W();
                    return;
                default:
                    return;
            }
        }
        A1(this.v.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02ee  */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r14) {
        /*
            Method dump skipped, instructions count: 843
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.lib.ui.WebViewActivity.onCreate(android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.L = true;
        this.q.destroy();
        this.f6844i.clear();
        super.onDestroy();
        this.q = null;
        this.b = null;
        this.p = null;
        WXPayEntryActivity.a(null);
        v vVar = this.J;
        if (vVar != null) {
            vVar.f();
        }
        AlertDialog alertDialog = this.K;
        if (alertDialog != null) {
            alertDialog.cancel();
        }
        this.K = null;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
        t.a(this, str);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.N.equals(this.S)) {
            finish();
        }
        if (i2 == 4) {
            if (this.G) {
                finish();
            }
            if (a1(this.f6847l)) {
                this.f6847l = null;
                return true;
            }
            this.f6847l = null;
            if (this.O && this.q.canGoBack()) {
                this.q.goBack();
                return true;
            } else if (this.D) {
                vStudio.Android.Camera360.activity.g.c(this);
                finish();
                return true;
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        return view instanceof WebView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.q.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        int i2 = this.Q;
        if (i2 == 2 || i2 == 3) {
            requestCheckIsFullDisplay(-1);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        int i2 = this.Q;
        if (i2 == 2 || i2 == 3) {
            requestCheckIsFullDisplay(-1);
        }
    }

    @Override // com.pinguo.camera360.lib.ui.PickPhotoDialog.a
    public void r() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/jpeg");
        for (ResolveInfo resolveInfo : getPackageManager().queryIntentActivities(intent, 0)) {
            if (resolveInfo.activityInfo.packageName.contains("com.vivo.gallery")) {
                intent.setPackage("com.vivo.gallery");
            }
        }
        startActivityForResult(Intent.createChooser(intent, null), 1002);
    }

    @Override // com.pinguo.camera360.lib.ui.v.b
    public void x(String str) {
        this.x = str;
    }

    @Override // us.pinguo.webview.g.a
    public void y(String str, String str2, String str3, String str4) {
        f.b bVar = new f.b();
        boolean b2 = z.b(us.pinguo.foundation.utils.v.a());
        if (!b2) {
            bVar.g(ShareSite.FACEBOOK);
            bVar.g(ShareSite.TWITTER);
        }
        bVar.g(ShareSite.WECHAT_FRIENDS);
        bVar.g(ShareSite.WECHAT_MOMENTS);
        if (b2) {
            bVar.g(ShareSite.QQ);
            bVar.g(ShareSite.QZONE);
        }
        PGShareInfo pGShareInfo = new PGShareInfo();
        if (TextUtils.isEmpty(str)) {
            pGShareInfo.setTitle(this.y);
        } else {
            pGShareInfo.setTitle(str);
        }
        if (!TextUtils.isEmpty(str4) && !TextUtils.equals(str4, com.google.android.gms.ads.AdError.UNDEFINED_DOMAIN)) {
            pGShareInfo.setWebUrl(str4);
        } else {
            pGShareInfo.setWebUrl(this.z);
        }
        pGShareInfo.setText(str2);
        pGShareInfo.setThumbnailUri(str3);
        us.pinguo.pgshare.commons.d.a(this, new a(pGShareInfo, str2));
    }

    @Override // com.pinguo.camera360.lib.ui.s.b
    public void z(us.pinguo.webview.f.h.b bVar) {
        W0("pay_request", "");
        this.f6841f = bVar;
        runOnUiThread(new f(bVar.b().a()));
    }
}
