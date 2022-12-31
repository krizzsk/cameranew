package com.tencent.connect.auth;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.work.WorkRequest;
import com.facebook.ads.AdError;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.tapjoy.TJAdUnitConstants;
import com.tencent.connect.auth.b;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.l;
import com.tencent.open.web.security.JniInterface;
import com.tencent.open.web.security.SecureJsInterface;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.androidsdk.PGImageSDK;
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public class a extends Dialog {
    private String a;
    private f b;
    private IUiListener c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f8046d;

    /* renamed from: e  reason: collision with root package name */
    private FrameLayout f8047e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f8048f;

    /* renamed from: g  reason: collision with root package name */
    private FrameLayout f8049g;

    /* renamed from: h  reason: collision with root package name */
    private ProgressBar f8050h;

    /* renamed from: i  reason: collision with root package name */
    private Button f8051i;

    /* renamed from: j  reason: collision with root package name */
    private String f8052j;

    /* renamed from: k  reason: collision with root package name */
    private com.tencent.open.b.c f8053k;

    /* renamed from: l  reason: collision with root package name */
    private Context f8054l;
    private com.tencent.open.web.security.b m;
    private boolean n;
    private int o;
    private String p;
    private String q;
    private long r;
    private long s;
    private HashMap<String, Runnable> t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProGuard */
    /* renamed from: com.tencent.connect.auth.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0268a implements View.OnClickListener {
        View$OnClickListenerC0268a() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            a.this.dismiss();
            if (a.this.n || a.this.b == null) {
                return;
            }
            a.this.b.onCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public class b implements View.OnLongClickListener {
        b(a aVar) {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public class c implements View.OnTouchListener {
        c(a aVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if ((action == 0 || action == 1) && !view.hasFocus()) {
                view.requestFocus();
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnDismissListener {
        d(a aVar) {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            try {
                if (JniInterface.isJniOk) {
                    JniInterface.clearAllPWD();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public class e extends WebViewClient {

        /* compiled from: ProGuard */
        /* renamed from: com.tencent.connect.auth.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class RunnableC0269a implements Runnable {
            RunnableC0269a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.tencent.open.b.c cVar = a.this.f8053k;
                String str = a.this.p;
                cVar.loadUrl(str);
                VdsAgent.loadUrl(cVar, str);
            }
        }

        /* compiled from: ProGuard */
        /* loaded from: classes3.dex */
        class b implements DialogInterface.OnClickListener {
            final /* synthetic */ SslErrorHandler a;

            b(e eVar, SslErrorHandler sslErrorHandler) {
                this.a = sslErrorHandler;
            }

            @Override // android.content.DialogInterface.OnClickListener
            @Instrumented
            public void onClick(DialogInterface dialogInterface, int i2) {
                VdsAgent.onClick(this, dialogInterface, i2);
                this.a.proceed();
            }
        }

        /* compiled from: ProGuard */
        /* loaded from: classes3.dex */
        class c implements DialogInterface.OnClickListener {
            final /* synthetic */ SslErrorHandler a;

            c(SslErrorHandler sslErrorHandler) {
                this.a = sslErrorHandler;
            }

            @Override // android.content.DialogInterface.OnClickListener
            @Instrumented
            public void onClick(DialogInterface dialogInterface, int i2) {
                VdsAgent.onClick(this, dialogInterface, i2);
                this.a.cancel();
                a.this.dismiss();
            }
        }

        private e() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            SLog.v("openSDK_LOG.AuthDialog", "-->onPageFinished, url: " + str);
            FrameLayout frameLayout = a.this.f8049g;
            frameLayout.setVisibility(8);
            VdsAgent.onSetViewVisibility(frameLayout, 8);
            if (a.this.f8053k != null) {
                com.tencent.open.b.c cVar = a.this.f8053k;
                cVar.setVisibility(0);
                VdsAgent.onSetViewVisibility(cVar, 0);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a.this.f8046d.removeCallbacks((Runnable) a.this.t.remove(str));
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.AuthDialog", "-->onPageStarted, url: " + str);
            super.onPageStarted(webView, str, bitmap);
            FrameLayout frameLayout = a.this.f8049g;
            frameLayout.setVisibility(0);
            VdsAgent.onSetViewVisibility(frameLayout, 0);
            a.this.r = SystemClock.elapsedRealtime();
            if (!TextUtils.isEmpty(a.this.p)) {
                a.this.f8046d.removeCallbacks((Runnable) a.this.t.remove(a.this.p));
            }
            a.this.p = str;
            a aVar = a.this;
            h hVar = new h(aVar.p);
            a.this.t.put(str, hVar);
            a.this.f8046d.postDelayed(hVar, 120000L);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            SLog.i("openSDK_LOG.AuthDialog", "-->onReceivedError, errorCode: " + i2 + " | description: " + str);
            if (!l.b(a.this.f8054l)) {
                a.this.b.onError(new UiError(AdError.AD_PRESENTATION_ERROR_CODE, "当前网络不可用，请稍后重试！", str2));
                a.this.dismiss();
            } else if (!a.this.p.startsWith("https://login.imgcache.qq.com/ptlogin/static/qzsjump.html?")) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.r;
                if (a.this.o >= 1 || elapsedRealtime >= a.this.s) {
                    com.tencent.open.b.c cVar = a.this.f8053k;
                    String a = a.this.a();
                    cVar.loadUrl(a);
                    VdsAgent.loadUrl(cVar, a);
                    return;
                }
                a.m(a.this);
                a.this.f8046d.postDelayed(new RunnableC0269a(), 500L);
            } else {
                a.this.b.onError(new UiError(i2, str, str2));
                a.this.dismiss();
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String str;
            String str2;
            String str3;
            SLog.e("openSDK_LOG.AuthDialog", "-->onReceivedSslError " + sslError.getPrimaryError() + "请求不合法，请检查手机安全设置，如系统时间、代理等");
            if (Locale.getDefault().getLanguage().equals("zh")) {
                str = "ssl证书无效，是否继续访问？";
                str2 = "是";
                str3 = "否";
            } else {
                str = "The SSL certificate is invalid,do you countinue?";
                str2 = "yes";
                str3 = "no";
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(a.this.f8054l);
            builder.setMessage(str);
            builder.setPositiveButton(str2, new b(this, sslErrorHandler));
            builder.setNegativeButton(str3, new c(sslErrorHandler));
            AlertDialog create = builder.create();
            create.show();
            VdsAgent.showDialog(create);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri parse;
            List<String> pathSegments;
            SLog.v("openSDK_LOG.AuthDialog", "-->Redirect URL: " + str);
            if (str.startsWith("auth://browser")) {
                JSONObject c2 = l.c(str);
                a aVar = a.this;
                aVar.n = aVar.f();
                if (!a.this.n) {
                    if (c2.optString("fail_cb", null) != null) {
                        a.this.a(c2.optString("fail_cb"), "");
                    } else if (c2.optInt("fall_to_wv") == 1) {
                        a aVar2 = a.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append(a.this.a);
                        sb.append(a.this.a.indexOf("?") > -1 ? "&" : "?");
                        aVar2.a = sb.toString();
                        a aVar3 = a.this;
                        aVar3.a = a.this.a + "browser_error=1";
                        com.tencent.open.b.c cVar = a.this.f8053k;
                        String str2 = a.this.a;
                        cVar.loadUrl(str2);
                        VdsAgent.loadUrl(cVar, str2);
                    } else {
                        String optString = c2.optString("redir", null);
                        if (optString != null) {
                            com.tencent.open.b.c cVar2 = a.this.f8053k;
                            cVar2.loadUrl(optString);
                            VdsAgent.loadUrl(cVar2, optString);
                        }
                    }
                }
                return true;
            } else if (str.startsWith("auth://tauth.qq.com/")) {
                a.this.b.onComplete(l.c(str));
                a.this.dismiss();
                return true;
            } else if (str.startsWith(Constants.CANCEL_URI)) {
                a.this.b.onCancel();
                a.this.dismiss();
                return true;
            } else if (str.startsWith(Constants.CLOSE_URI)) {
                a.this.dismiss();
                return true;
            } else if (!str.startsWith(Constants.DOWNLOAD_URI) && !str.endsWith(".apk")) {
                if (str.startsWith("auth://progress")) {
                    try {
                        pathSegments = Uri.parse(str).getPathSegments();
                    } catch (Exception unused) {
                    }
                    if (pathSegments.isEmpty()) {
                        return true;
                    }
                    int intValue = Integer.valueOf(pathSegments.get(0)).intValue();
                    if (intValue == 0) {
                        FrameLayout frameLayout = a.this.f8049g;
                        frameLayout.setVisibility(8);
                        VdsAgent.onSetViewVisibility(frameLayout, 8);
                        com.tencent.open.b.c cVar3 = a.this.f8053k;
                        cVar3.setVisibility(0);
                        VdsAgent.onSetViewVisibility(cVar3, 0);
                    } else if (intValue == 1) {
                        FrameLayout frameLayout2 = a.this.f8049g;
                        frameLayout2.setVisibility(0);
                        VdsAgent.onSetViewVisibility(frameLayout2, 0);
                    }
                    return true;
                } else if (!str.startsWith("auth://onLoginSubmit")) {
                    if (a.this.m.a(a.this.f8053k, str)) {
                        return true;
                    }
                    SLog.i("openSDK_LOG.AuthDialog", "-->Redirect URL: return false");
                    return false;
                } else {
                    try {
                        List<String> pathSegments2 = Uri.parse(str).getPathSegments();
                        if (!pathSegments2.isEmpty()) {
                            a.this.q = pathSegments2.get(0);
                        }
                    } catch (Exception unused2) {
                    }
                    return true;
                }
            } else {
                try {
                    if (str.startsWith(Constants.DOWNLOAD_URI)) {
                        parse = Uri.parse(Uri.decode(str.substring(11)));
                    } else {
                        parse = Uri.parse(Uri.decode(str));
                    }
                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                    intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
                    a.this.f8054l.startActivity(intent);
                } catch (Exception e2) {
                    SLog.e("openSDK_LOG.AuthDialog", "-->start download activity exception, e: ", e2);
                }
                return true;
            }
        }

        /* synthetic */ e(a aVar, View$OnClickListenerC0268a view$OnClickListenerC0268a) {
            this();
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    private class f extends DefaultUiListener {
        private String a;
        String b;
        private IUiListener c;

        public f(String str, String str2, String str3, IUiListener iUiListener) {
            this.a = str;
            this.b = str2;
            this.c = iUiListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
            try {
                onComplete(l.d(str));
            } catch (JSONException e2) {
                e2.printStackTrace();
                onError(new UiError(-4, Constants.MSG_JSON_ERROR, str));
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.c;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.c = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            com.tencent.open.a.g a = com.tencent.open.a.g.a();
            a.a(this.a + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.b, false);
            IUiListener iUiListener = this.c;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.c = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.b;
            } else {
                str = this.b;
            }
            com.tencent.open.a.g.a().a(this.a + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            a.this.a(str);
            IUiListener iUiListener = this.c;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.c = null;
            }
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    private class g extends Handler {
        private f a;

        public g(f fVar, Looper looper) {
            super(looper);
            this.a = fVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                this.a.b((String) message.obj);
            } else if (i2 == 2) {
                this.a.onCancel();
            } else if (i2 != 3) {
            } else {
                a.b(a.this.f8054l, (String) message.obj);
            }
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    class h implements Runnable {
        String a;

        public h(String str) {
            this.a = "";
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SLog.v("openSDK_LOG.AuthDialog", "-->timeoutUrl: " + this.a + " | mRetryUrl: " + a.this.p);
            if (this.a.equals(a.this.p)) {
                a.this.b.onError(new UiError(9002, "请求页面超时，请稍后重试！", a.this.p));
                a.this.dismiss();
            }
        }
    }

    public a(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.n = false;
        this.r = 0L;
        this.s = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        this.f8054l = context;
        this.a = str2;
        this.b = new f(str, str2, qQToken.getAppId(), iUiListener);
        this.f8046d = new g(this.b, context.getMainLooper());
        this.c = iUiListener;
        this.f8052j = str;
        this.m = new com.tencent.open.web.security.b();
        getWindow().setSoftInputMode(32);
    }

    static /* synthetic */ int m(a aVar) {
        int i2 = aVar.o;
        aVar.o = i2 + 1;
        return i2;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.t.clear();
        this.f8046d.removeCallbacksAndMessages(null);
        try {
            Context context = this.f8054l;
            if ((context instanceof Activity) && !((Activity) context).isFinishing() && isShowing()) {
                super.dismiss();
                SLog.i("openSDK_LOG.AuthDialog", "-->dismiss dialog");
            }
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.AuthDialog", "-->dismiss dialog exception:", e2);
        }
        com.tencent.open.b.c cVar = this.f8053k;
        if (cVar != null) {
            cVar.destroy();
            this.f8053k = null;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (!this.n) {
            this.b.onCancel();
        }
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        Window window = getWindow();
        if (window != null) {
            window.setFlags(1024, 1024);
        }
        super.onCreate(bundle);
        if (window != null) {
            View decorView = window.getDecorView();
            if (Build.VERSION.SDK_INT >= 16) {
                decorView.setSystemUiVisibility(1280);
            }
        }
        b();
        e();
        this.t = new HashMap<>();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void e() {
        this.f8053k.setVerticalScrollBarEnabled(false);
        this.f8053k.setHorizontalScrollBarEnabled(false);
        this.f8053k.setWebViewClient(new e(this, null));
        com.tencent.open.b.c cVar = this.f8053k;
        WebChromeClient webChromeClient = new WebChromeClient();
        cVar.setWebChromeClient(webChromeClient);
        VdsAgent.setWebChromeClient(cVar, webChromeClient);
        this.f8053k.clearFormData();
        this.f8053k.clearSslPreferences();
        this.f8053k.setOnLongClickListener(new b(this));
        this.f8053k.setOnTouchListener(new c(this));
        WebSettings settings = this.f8053k.getSettings();
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.f8054l.getDir("databases", 0).getPath());
        settings.setDomStorageEnabled(true);
        SLog.v("openSDK_LOG.AuthDialog", "-->mUrl : " + this.a);
        String str = this.a;
        this.p = str;
        com.tencent.open.b.c cVar2 = this.f8053k;
        cVar2.loadUrl(str);
        VdsAgent.loadUrl(cVar2, str);
        com.tencent.open.b.c cVar3 = this.f8053k;
        cVar3.setVisibility(4);
        VdsAgent.onSetViewVisibility(cVar3, 4);
        this.f8053k.getSettings().setSavePassword(false);
        this.m.a(new SecureJsInterface(), "SecureJsInterface");
        SecureJsInterface.isPWDEdit = false;
        super.setOnDismissListener(new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        com.tencent.connect.auth.b a = com.tencent.connect.auth.b.a();
        String c2 = a.c();
        b.a aVar = new b.a();
        aVar.a = this.c;
        aVar.b = this;
        aVar.c = c2;
        String a2 = a.a(aVar);
        String str = this.a;
        String substring = str.substring(0, str.indexOf("?"));
        Bundle b2 = l.b(this.a);
        b2.putString("token_key", c2);
        b2.putString("serial", a2);
        b2.putString("browser", "1");
        String str2 = substring + "?" + HttpUtils.encodeUrl(b2);
        this.a = str2;
        return l.a(this.f8054l, str2);
    }

    private void b() {
        d();
        c();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        com.tencent.open.b.c cVar = new com.tencent.open.b.c(this.f8054l);
        this.f8053k = cVar;
        if (Build.VERSION.SDK_INT >= 11) {
            cVar.setLayerType(1, null);
        }
        this.f8053k.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(this.f8054l);
        this.f8047e = frameLayout;
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
        this.f8047e.addView(this.f8053k);
        this.f8047e.addView(this.f8049g);
        String string = l.b(this.a).getString(TJAdUnitConstants.String.STYLE);
        if (string != null && "qr".equals(string)) {
            this.f8047e.addView(this.f8051i);
        }
        setContentView(this.f8047e);
    }

    private void c() {
        Button button = new Button(this.f8054l);
        this.f8051i = button;
        button.setBackgroundDrawable(l.a("h5_qr_back.png", this.f8054l));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = com.tencent.connect.avatar.a.a(this.f8054l, 20.0f);
        layoutParams.topMargin = com.tencent.connect.avatar.a.a(this.f8054l, 10.0f);
        this.f8051i.setLayoutParams(layoutParams);
        this.f8051i.setOnClickListener(new View$OnClickListenerC0268a());
    }

    private void d() {
        TextView textView;
        this.f8050h = new ProgressBar(this.f8054l);
        this.f8050h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f8048f = new LinearLayout(this.f8054l);
        if (this.f8052j.equals("action_login")) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            layoutParams.leftMargin = 5;
            textView = new TextView(this.f8054l);
            if (Locale.getDefault().getLanguage().equals("zh")) {
                textView.setText("登录中...");
            } else {
                textView.setText("Logging in...");
            }
            textView.setTextColor(Color.rgb(255, 255, 255));
            textView.setTextSize(18.0f);
            textView.setLayoutParams(layoutParams);
        } else {
            textView = null;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.f8048f.setLayoutParams(layoutParams2);
        this.f8048f.addView(this.f8050h);
        if (textView != null) {
            this.f8048f.addView(textView);
        }
        this.f8049g = new FrameLayout(this.f8054l);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams3.gravity = 17;
        this.f8049g.setLayoutParams(layoutParams3);
        this.f8049g.setBackgroundColor(Color.parseColor("#B3000000"));
        this.f8049g.addView(this.f8048f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.q) && this.q.length() >= 4) {
            String str2 = this.q;
            String substring = str2.substring(str2.length() - 4);
            sb.append("_u_");
            sb.append(substring);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a() {
        String str = this.a;
        String str2 = "https://login.imgcache.qq.com/ptlogin/static/qzsjump.html?" + str.substring(str.indexOf("?") + 1);
        SLog.i("openSDK_LOG.AuthDialog", "-->generateDownloadUrl, url: https://login.imgcache.qq.com/ptlogin/static/qzsjump.html?");
        return str2;
    }

    public void a(String str, String str2) {
        String str3 = "javascript:" + str + "(" + str2 + ");void(" + System.currentTimeMillis() + ");";
        com.tencent.open.b.c cVar = this.f8053k;
        cVar.loadUrl(str3);
        VdsAgent.loadUrl(cVar, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str) {
        try {
            JSONObject d2 = l.d(str);
            int i2 = d2.getInt("type");
            Toast makeText = Toast.makeText(context.getApplicationContext(), d2.getString("msg"), i2);
            makeText.show();
            VdsAgent.showToast(makeText);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
