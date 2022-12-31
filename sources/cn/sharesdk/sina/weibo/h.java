package cn.sharesdk.sina.weibo;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.tools.FakeActivity;
import com.mob.tools.RxMob;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
/* compiled from: WebSharePage.java */
/* loaded from: classes.dex */
public class h extends FakeActivity implements View.OnClickListener {
    private String a;
    private String b;
    private Platform.ShareParams c;

    /* renamed from: d  reason: collision with root package name */
    private AuthorizeListener f237d;

    /* renamed from: e  reason: collision with root package name */
    private cn.sharesdk.sina.weibo.sdk.a.a f238e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f239f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f240g;

    /* renamed from: h  reason: collision with root package name */
    private WebView f241h;

    /* renamed from: i  reason: collision with root package name */
    private Button f242i;

    /* renamed from: j  reason: collision with root package name */
    private int f243j;

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        if (view == this.f240g) {
            AuthorizeListener authorizeListener = this.f237d;
            if (authorizeListener != null) {
                authorizeListener.onCancel();
            }
            finish();
        } else if (view == this.f242i) {
            LinearLayout linearLayout = this.f239f;
            linearLayout.setVisibility(8);
            VdsAgent.onSetViewVisibility(linearLayout, 8);
            WebView webView = this.f241h;
            webView.setVisibility(0);
            VdsAgent.onSetViewVisibility(webView, 0);
            b();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        this.f238e = new cn.sharesdk.sina.weibo.sdk.a.a(getContext());
        this.activity.setContentView(this.f238e.a(ResHelper.getStringRes(getContext(), "ssdk_sina_web_title")));
        a();
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        WebView webView = this.f241h;
        if (webView != null) {
            webView.setFocusable(false);
        }
    }

    @Override // com.mob.tools.FakeActivity
    public boolean onFinish() {
        if (this.f237d != null) {
            this.f237d = null;
        }
        return super.onFinish();
    }

    @Override // com.mob.tools.FakeActivity
    public boolean onKeyEvent(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && keyEvent.getAction() == 0) {
            AuthorizeListener authorizeListener = this.f237d;
            if (authorizeListener != null) {
                authorizeListener.onCancel();
            }
            finish();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0065 A[Catch: all -> 0x00f5, TryCatch #0 {all -> 0x00f5, blocks: (B:3:0x0005, B:5:0x000d, B:7:0x0019, B:13:0x0042, B:15:0x004e, B:17:0x0051, B:19:0x005e, B:22:0x0065, B:24:0x009b, B:25:0x00a0, B:27:0x00a8, B:28:0x00ad, B:31:0x00bd, B:33:0x00c8, B:35:0x00ce, B:38:0x00d5, B:40:0x00ed, B:9:0x0026, B:11:0x0032), top: B:47:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String c() {
        /*
            r11 = this;
            java.lang.String r0 = "data"
            java.lang.String r1 = "code"
            r2 = 0
            cn.sharesdk.framework.Platform$ShareParams r3 = r11.c     // Catch: java.lang.Throwable -> Lf5
            android.graphics.Bitmap r3 = r3.getImageData()     // Catch: java.lang.Throwable -> Lf5
            if (r3 != 0) goto L24
            cn.sharesdk.framework.Platform$ShareParams r4 = r11.c     // Catch: java.lang.Throwable -> Lf5
            java.lang.String r4 = r4.getImagePath()     // Catch: java.lang.Throwable -> Lf5
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> Lf5
            if (r4 != 0) goto L24
            cn.sharesdk.framework.Platform$ShareParams r3 = r11.c     // Catch: java.lang.Throwable -> Lf5
            java.lang.String r3 = r3.getImagePath()     // Catch: java.lang.Throwable -> Lf5
            android.graphics.Bitmap r3 = com.mob.tools.utils.BitmapHelper.getBitmap(r3)     // Catch: java.lang.Throwable -> Lf5
            goto L40
        L24:
            if (r3 != 0) goto L40
            cn.sharesdk.framework.Platform$ShareParams r4 = r11.c     // Catch: java.lang.Throwable -> Lf5
            java.lang.String r4 = r4.getImageUrl()     // Catch: java.lang.Throwable -> Lf5
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> Lf5
            if (r4 != 0) goto L40
            android.content.Context r3 = r11.getContext()     // Catch: java.lang.Throwable -> Lf5
            cn.sharesdk.framework.Platform$ShareParams r4 = r11.c     // Catch: java.lang.Throwable -> Lf5
            java.lang.String r4 = r4.getImageUrl()     // Catch: java.lang.Throwable -> Lf5
            android.graphics.Bitmap r3 = com.mob.tools.utils.BitmapHelper.getBitmap(r3, r4)     // Catch: java.lang.Throwable -> Lf5
        L40:
            if (r3 == 0) goto L5d
            com.sina.weibo.sdk.api.ImageObject r4 = new com.sina.weibo.sdk.api.ImageObject     // Catch: java.lang.Throwable -> Lf5
            r4.<init>()     // Catch: java.lang.Throwable -> Lf5
            r4.setImageData(r3)     // Catch: java.lang.Throwable -> Lf5
            byte[] r3 = r4.imageData     // Catch: java.lang.Throwable -> Lf5
            if (r3 == 0) goto L5d
            int r3 = r3.length     // Catch: java.lang.Throwable -> Lf5
            if (r3 <= 0) goto L5d
            java.lang.String r3 = new java.lang.String     // Catch: java.lang.Throwable -> Lf5
            byte[] r4 = r4.imageData     // Catch: java.lang.Throwable -> Lf5
            byte[] r4 = cn.sharesdk.sina.weibo.sdk.a.a(r4)     // Catch: java.lang.Throwable -> Lf5
            r3.<init>(r4)     // Catch: java.lang.Throwable -> Lf5
            goto L5e
        L5d:
            r3 = r2
        L5e:
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> Lf5
            if (r4 == 0) goto L65
            return r2
        L65:
            com.mob.tools.network.NetworkHelper r5 = new com.mob.tools.network.NetworkHelper     // Catch: java.lang.Throwable -> Lf5
            r5.<init>()     // Catch: java.lang.Throwable -> Lf5
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lf5
            r7.<init>()     // Catch: java.lang.Throwable -> Lf5
            com.mob.tools.network.KVPair r4 = new com.mob.tools.network.KVPair     // Catch: java.lang.Throwable -> Lf5
            java.lang.String r6 = "img"
            r4.<init>(r6, r3)     // Catch: java.lang.Throwable -> Lf5
            r7.add(r4)     // Catch: java.lang.Throwable -> Lf5
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lf5
            r8 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 / r8
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> Lf5
            com.mob.tools.network.KVPair r4 = new com.mob.tools.network.KVPair     // Catch: java.lang.Throwable -> Lf5
            java.lang.String r6 = "oauth_timestamp"
            r4.<init>(r6, r3)     // Catch: java.lang.Throwable -> Lf5
            r7.add(r4)     // Catch: java.lang.Throwable -> Lf5
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf5
            r3.<init>()     // Catch: java.lang.Throwable -> Lf5
            java.lang.String r4 = r11.b     // Catch: java.lang.Throwable -> Lf5
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> Lf5
            if (r4 != 0) goto La0
            java.lang.String r4 = r11.b     // Catch: java.lang.Throwable -> Lf5
            r3.append(r4)     // Catch: java.lang.Throwable -> Lf5
        La0:
            java.lang.String r4 = r11.a     // Catch: java.lang.Throwable -> Lf5
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> Lf5
            if (r4 != 0) goto Lad
            java.lang.String r4 = r11.a     // Catch: java.lang.Throwable -> Lf5
            r3.append(r4)     // Catch: java.lang.Throwable -> Lf5
        Lad:
            java.lang.String r6 = "http://service.weibo.com/share/mobilesdk_uppic.php"
            r8 = 0
            r9 = 0
            r10 = 0
            java.lang.String r3 = r5.httpPost(r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> Lf5
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> Lf5
            if (r4 == 0) goto Lbd
            return r2
        Lbd:
            com.mob.tools.utils.Hashon r4 = new com.mob.tools.utils.Hashon     // Catch: java.lang.Throwable -> Lf5
            r4.<init>()     // Catch: java.lang.Throwable -> Lf5
            java.util.HashMap r3 = r4.fromJson(r3)     // Catch: java.lang.Throwable -> Lf5
            if (r3 == 0) goto Lf4
            boolean r4 = r3.containsKey(r1)     // Catch: java.lang.Throwable -> Lf5
            if (r4 == 0) goto Lf4
            boolean r4 = r3.containsKey(r0)     // Catch: java.lang.Throwable -> Lf5
            if (r4 != 0) goto Ld5
            goto Lf4
        Ld5:
            java.lang.Object r1 = r3.get(r1)     // Catch: java.lang.Throwable -> Lf5
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> Lf5
            java.lang.Object r0 = r3.get(r0)     // Catch: java.lang.Throwable -> Lf5
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> Lf5
            java.lang.String r3 = "1"
            boolean r1 = r3.equals(r1)     // Catch: java.lang.Throwable -> Lf5
            if (r1 == 0) goto Lf4
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Lf5
            if (r1 != 0) goto Lf4
            return r0
        Lf4:
            return r2
        Lf5:
            r0 = move-exception
            com.mob.tools.log.NLog r1 = cn.sharesdk.framework.utils.SSDKLog.b()
            r1.d(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.sina.weibo.h.c():java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair("title", this.c.getText()));
        arrayList.add(new KVPair("source", this.a));
        arrayList.add(new KVPair("access_token", this.b));
        arrayList.add(new KVPair("packagename", this.activity.getPackageName()));
        arrayList.add(new KVPair("picinfo", str));
        arrayList.add(new KVPair("luicode", "10000360"));
        arrayList.add(new KVPair("key_hash", cn.sharesdk.sina.weibo.sdk.a.a(getContext(), this.activity.getPackageName())));
        arrayList.add(new KVPair("lfid", "OP_" + this.a));
        arrayList.add(new KVPair("version", "0041005000"));
        return "http://service.weibo.com/share/mobilesdk.php?" + ResHelper.encodeUrl(arrayList);
    }

    public void a(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public void a(Platform.ShareParams shareParams) {
        this.c = shareParams;
    }

    public void a(AuthorizeListener authorizeListener) {
        this.f237d = authorizeListener;
    }

    private void a() {
        this.f240g = this.f238e.b();
        this.f241h = this.f238e.c();
        this.f239f = this.f238e.d();
        this.f242i = this.f238e.a();
        this.f240g.setOnClickListener(this);
        this.f242i.setOnClickListener(this);
        if (ShareSDK.isRemoveCookieOnAuthorize()) {
            CookieSyncManager.createInstance(this.activity);
            CookieManager.getInstance().removeAllCookie();
        }
        this.f241h.setWebViewClient(new WebViewClient() { // from class: cn.sharesdk.sina.weibo.h.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (h.this.f243j == -1) {
                    LinearLayout linearLayout = h.this.f239f;
                    linearLayout.setVisibility(0);
                    VdsAgent.onSetViewVisibility(linearLayout, 0);
                    WebView webView2 = h.this.f241h;
                    webView2.setVisibility(8);
                    VdsAgent.onSetViewVisibility(webView2, 8);
                }
                h.this.f243j = 0;
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i2, String str, String str2) {
                super.onReceivedError(webView, i2, str, str2);
                String url = webView.getUrl();
                if (TextUtils.isEmpty(url) || TextUtils.isEmpty(str2)) {
                    return;
                }
                Uri parse = Uri.parse(url);
                Uri parse2 = Uri.parse(str2);
                if (parse.getHost().equals(parse2.getHost()) && parse.getScheme().equals(parse2.getScheme())) {
                    h.this.f243j = -1;
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str.startsWith("sinaweibo://browser/close")) {
                    if (h.this.f237d != null) {
                        h.this.a(str);
                        return true;
                    }
                    return true;
                }
                return false;
            }
        });
        b();
    }

    private String b() {
        RxMob.Subscribable create = RxMob.create(new RxMob.OnSubscribe<String>() { // from class: cn.sharesdk.sina.weibo.h.2
            @Override // com.mob.tools.RxMob.OnSubscribe
            public void call(RxMob.Subscriber<String> subscriber) {
                subscriber.onNext(h.this.c());
            }
        });
        create.subscribeOn(RxMob.Thread.NEW_THREAD);
        create.observeOn(RxMob.Thread.UI_THREAD);
        create.subscribe(new RxMob.Subscriber<String>() { // from class: cn.sharesdk.sina.weibo.h.3
            @Override // com.mob.tools.RxMob.Subscriber
            /* renamed from: a */
            public void onNext(String str) {
                WebView webView = h.this.f241h;
                String b = h.this.b(str);
                webView.loadUrl(b);
                VdsAgent.loadUrl(webView, b);
            }

            @Override // com.mob.tools.RxMob.Subscriber
            public void onCompleted() {
                super.onCompleted();
            }

            @Override // com.mob.tools.RxMob.Subscriber
            public void onError(Throwable th) {
                SSDKLog.b().w(th);
                WebView webView = h.this.f241h;
                String b = h.this.b((String) null);
                webView.loadUrl(b);
                VdsAgent.loadUrl(webView, b);
            }

            @Override // com.mob.tools.RxMob.Subscriber
            public void onStart() {
                super.onStart();
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Bundle urlToBundle = ResHelper.urlToBundle(str);
        String string = urlToBundle.getString("code");
        String string2 = urlToBundle.getString("msg");
        if (this.f237d != null) {
            if (TextUtils.isEmpty(string)) {
                this.f237d.onCancel();
            } else if ("0".equals(string)) {
                this.f237d.onComplete(urlToBundle);
            } else {
                this.f237d.onError(new Throwable(string2));
            }
        }
        finish();
    }
}
