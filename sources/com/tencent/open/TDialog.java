package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.a;
import com.tencent.open.a.g;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.h;
import com.tencent.open.utils.l;
import com.tencent.tauth.AuthActivity;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.androidsdk.PGImageSDK;
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public class TDialog extends com.tencent.open.b {
    static final FrameLayout.LayoutParams c = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: d  reason: collision with root package name */
    static Toast f8147d = null;

    /* renamed from: f  reason: collision with root package name */
    private static WeakReference<ProgressDialog> f8148f;

    /* renamed from: e  reason: collision with root package name */
    private WeakReference<Context> f8149e;

    /* renamed from: g  reason: collision with root package name */
    private String f8150g;

    /* renamed from: h  reason: collision with root package name */
    private d f8151h;

    /* renamed from: i  reason: collision with root package name */
    private IUiListener f8152i;

    /* renamed from: j  reason: collision with root package name */
    private FrameLayout f8153j;

    /* renamed from: k  reason: collision with root package name */
    private com.tencent.open.b.b f8154k;

    /* renamed from: l  reason: collision with root package name */
    private Handler f8155l;
    private boolean m;
    private QQToken n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View decorView;
            View childAt;
            Window window = TDialog.this.getWindow();
            if (window == null || (decorView = window.getDecorView()) == null || (childAt = ((ViewGroup) decorView).getChildAt(0)) == null) {
                return;
            }
            childAt.setPadding(0, 0, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public class b extends WebViewClient {
        private b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            com.tencent.open.b.b bVar = TDialog.this.f8154k;
            bVar.setVisibility(0);
            VdsAgent.onSetViewVisibility(bVar, 0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.TDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            TDialog.this.f8151h.onError(new UiError(i2, str, str2));
            if (TDialog.this.f8149e != null && TDialog.this.f8149e.get() != null) {
                Toast makeText = Toast.makeText((Context) TDialog.this.f8149e.get(), "网络连接异常或系统错误", 0);
                makeText.show();
                VdsAgent.showToast(makeText);
            }
            TDialog.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri parse;
            SLog.v("openSDK_LOG.TDialog", "Redirect URL: " + str);
            if (str.startsWith(h.a().a((Context) TDialog.this.f8149e.get(), "auth://tauth.qq.com/"))) {
                TDialog.this.f8151h.onComplete(l.c(str));
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            } else if (str.startsWith(Constants.CANCEL_URI)) {
                TDialog.this.f8151h.onCancel();
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            } else if (str.startsWith(Constants.CLOSE_URI)) {
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            } else if (!str.startsWith(Constants.DOWNLOAD_URI) && !str.endsWith(".apk")) {
                return str.startsWith("auth://progress");
            } else {
                try {
                    if (str.startsWith(Constants.DOWNLOAD_URI)) {
                        parse = Uri.parse(Uri.decode(str.substring(11)));
                    } else {
                        parse = Uri.parse(Uri.decode(str));
                    }
                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                    intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
                    if (TDialog.this.f8149e != null && TDialog.this.f8149e.get() != null) {
                        ((Context) TDialog.this.f8149e.get()).startActivity(intent);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return true;
            }
        }

        /* synthetic */ b(TDialog tDialog, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public class c extends a.b {
        private c(TDialog tDialog) {
        }

        /* synthetic */ c(TDialog tDialog, a aVar) {
            this(tDialog);
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    private static class d extends DefaultUiListener {
        private String a;
        String b;
        private IUiListener c;

        public d(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            new WeakReference(context);
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
            g a = g.a();
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
            g a = g.a();
            a.a(this.a + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            IUiListener iUiListener = this.c;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.c = null;
            }
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    private class e extends Handler {
        private d a;

        public e(d dVar, Looper looper) {
            super(looper);
            this.a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SLog.d("openSDK_LOG.TDialog", "--handleMessage--msg.WHAT = " + message.what);
            int i2 = message.what;
            if (i2 == 1) {
                this.a.b((String) message.obj);
            } else if (i2 == 2) {
                this.a.onCancel();
            } else if (i2 != 3) {
                if (i2 != 5 || TDialog.this.f8149e == null || TDialog.this.f8149e.get() == null) {
                    return;
                }
                TDialog.d((Context) TDialog.this.f8149e.get(), (String) message.obj);
            } else if (TDialog.this.f8149e == null || TDialog.this.f8149e.get() == null) {
            } else {
                TDialog.c((Context) TDialog.this.f8149e.get(), (String) message.obj);
            }
        }
    }

    public TDialog(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.m = false;
        this.n = null;
        this.f8149e = new WeakReference<>(context);
        this.f8150g = str2;
        this.f8151h = new d(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f8155l = new e(this.f8151h, context.getMainLooper());
        this.f8152i = iUiListener;
        this.n = qQToken;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        d dVar = this.f8151h;
        if (dVar != null) {
            dVar.onCancel();
        }
        super.onBackPressed();
    }

    @Override // com.tencent.open.b, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        a();
        new Handler(Looper.getMainLooper()).post(new a());
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str) {
        try {
            JSONObject d2 = l.d(str);
            int i2 = d2.getInt("type");
            String string = d2.getString("msg");
            if (i2 == 0) {
                Toast toast = f8147d;
                if (toast == null) {
                    f8147d = Toast.makeText(context, string, 0);
                } else {
                    toast.setView(toast.getView());
                    f8147d.setText(string);
                    f8147d.setDuration(0);
                }
                Toast toast2 = f8147d;
                toast2.show();
                VdsAgent.showToast(toast2);
            } else if (i2 == 1) {
                Toast toast3 = f8147d;
                if (toast3 == null) {
                    f8147d = Toast.makeText(context, string, 1);
                } else {
                    toast3.setView(toast3.getView());
                    f8147d.setText(string);
                    f8147d.setDuration(1);
                }
                Toast toast4 = f8147d;
                toast4.show();
                VdsAgent.showToast(toast4);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject d2 = l.d(str);
            int i2 = d2.getInt(AuthActivity.ACTION_KEY);
            String string = d2.getString("msg");
            if (i2 == 1) {
                WeakReference<ProgressDialog> weakReference = f8148f;
                if (weakReference != null && weakReference.get() != null) {
                    f8148f.get().setMessage(string);
                    if (!f8148f.get().isShowing()) {
                        ProgressDialog progressDialog = f8148f.get();
                        progressDialog.show();
                        VdsAgent.showDialog(progressDialog);
                    }
                }
                ProgressDialog progressDialog2 = new ProgressDialog(context);
                progressDialog2.setMessage(string);
                f8148f = new WeakReference<>(progressDialog2);
                progressDialog2.show();
                VdsAgent.showDialog(progressDialog2);
            } else if (i2 == 0) {
                WeakReference<ProgressDialog> weakReference2 = f8148f;
                if (weakReference2 == null) {
                    return;
                }
                if (weakReference2.get() != null && f8148f.get().isShowing()) {
                    f8148f.get().dismiss();
                    f8148f = null;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void a() {
        new TextView(this.f8149e.get()).setText("test");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        com.tencent.open.b.b bVar = new com.tencent.open.b.b(this.f8149e.get());
        this.f8154k = bVar;
        bVar.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(this.f8149e.get());
        this.f8153j = frameLayout;
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
        this.f8153j.addView(this.f8154k);
        setContentView(this.f8153j);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void b() {
        this.f8154k.setVerticalScrollBarEnabled(false);
        this.f8154k.setHorizontalScrollBarEnabled(false);
        this.f8154k.setWebViewClient(new b(this, null));
        com.tencent.open.b.b bVar = this.f8154k;
        WebChromeClient webChromeClient = this.b;
        bVar.setWebChromeClient(webChromeClient);
        VdsAgent.setWebChromeClient(bVar, webChromeClient);
        this.f8154k.clearFormData();
        WebSettings settings = this.f8154k.getSettings();
        if (settings == null) {
            return;
        }
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setJavaScriptEnabled(true);
        WeakReference<Context> weakReference = this.f8149e;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.f8149e.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.a.a(new c(this, null), "sdk_js_if");
        com.tencent.open.b.b bVar2 = this.f8154k;
        String str = this.f8150g;
        bVar2.loadUrl(str);
        VdsAgent.loadUrl(bVar2, str);
        this.f8154k.setLayoutParams(c);
        com.tencent.open.b.b bVar3 = this.f8154k;
        bVar3.setVisibility(4);
        VdsAgent.onSetViewVisibility(bVar3, 4);
        this.f8154k.getSettings().setSavePassword(false);
    }

    @Override // com.tencent.open.b
    protected void a(String str) {
        SLog.d("openSDK_LOG.TDialog", "--onConsoleMessage--");
        try {
            this.a.a(this.f8154k, str);
        } catch (Exception unused) {
        }
    }
}
