package com.tencent.open;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.a;
import com.tencent.open.a.g;
import com.tencent.open.b.a;
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
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public class c extends com.tencent.open.b implements a.InterfaceC0280a {
    static Toast c;

    /* renamed from: d  reason: collision with root package name */
    private String f8168d;

    /* renamed from: e  reason: collision with root package name */
    private IUiListener f8169e;

    /* renamed from: f  reason: collision with root package name */
    private d f8170f;

    /* renamed from: g  reason: collision with root package name */
    private Handler f8171g;

    /* renamed from: h  reason: collision with root package name */
    private com.tencent.open.b.a f8172h;

    /* renamed from: i  reason: collision with root package name */
    private com.tencent.open.b.b f8173i;

    /* renamed from: j  reason: collision with root package name */
    private WeakReference<Context> f8174j;

    /* renamed from: k  reason: collision with root package name */
    private int f8175k;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public class b extends WebViewClient {
        private b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            com.tencent.open.b.b bVar = c.this.f8173i;
            bVar.setVisibility(0);
            VdsAgent.onSetViewVisibility(bVar, 0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.PKDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            c.this.f8170f.onError(new UiError(i2, str, str2));
            if (c.this.f8174j != null && c.this.f8174j.get() != null) {
                Toast makeText = Toast.makeText((Context) c.this.f8174j.get(), "网络连接异常或系统错误", 0);
                makeText.show();
                VdsAgent.showToast(makeText);
            }
            c.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            SLog.v("openSDK_LOG.PKDialog", "Redirect URL: " + str);
            if (str.startsWith(h.a().a((Context) c.this.f8174j.get(), "auth://tauth.qq.com/"))) {
                c.this.f8170f.onComplete(l.c(str));
                c.this.dismiss();
                return true;
            } else if (str.startsWith(Constants.CANCEL_URI)) {
                c.this.f8170f.onCancel();
                c.this.dismiss();
                return true;
            } else if (str.startsWith(Constants.CLOSE_URI)) {
                c.this.dismiss();
                return true;
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0281c extends a.b {
        private C0281c(c cVar) {
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
            SLog.d("openSDK_LOG.PKDialog", "msg = " + message.what);
            int i2 = message.what;
            if (i2 == 1) {
                this.a.b((String) message.obj);
            } else if (i2 == 2) {
                this.a.onCancel();
            } else if (i2 != 3) {
                if (i2 != 5 || c.this.f8174j == null || c.this.f8174j.get() == null) {
                    return;
                }
                c.d((Context) c.this.f8174j.get(), (String) message.obj);
            } else if (c.this.f8174j == null || c.this.f8174j.get() == null) {
            } else {
                c.c((Context) c.this.f8174j.get(), (String) message.obj);
            }
        }
    }

    public c(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.f8174j = new WeakReference<>(context);
        this.f8168d = str2;
        this.f8170f = new d(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f8171g = new e(this.f8170f, context.getMainLooper());
        this.f8169e = iUiListener;
        this.f8175k = Math.round(context.getResources().getDisplayMetrics().density * 185.0f);
        SLog.e("openSDK_LOG.PKDialog", "density=" + context.getResources().getDisplayMetrics().density + "; webviewHeight=" + this.f8175k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject d2 = l.d(str);
            d2.getInt(AuthActivity.ACTION_KEY);
            d2.getString("msg");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.tencent.open.b, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setSoftInputMode(16);
        getWindow().setSoftInputMode(1);
        b();
        c();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void c() {
        this.f8173i.setVerticalScrollBarEnabled(false);
        this.f8173i.setHorizontalScrollBarEnabled(false);
        this.f8173i.setWebViewClient(new b());
        com.tencent.open.b.b bVar = this.f8173i;
        WebChromeClient webChromeClient = this.b;
        bVar.setWebChromeClient(webChromeClient);
        VdsAgent.setWebChromeClient(bVar, webChromeClient);
        this.f8173i.clearFormData();
        WebSettings settings = this.f8173i.getSettings();
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
        WeakReference<Context> weakReference = this.f8174j;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.f8174j.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.a.a(new C0281c(), "sdk_js_if");
        this.f8173i.clearView();
        com.tencent.open.b.b bVar2 = this.f8173i;
        String str = this.f8168d;
        bVar2.loadUrl(str);
        VdsAgent.loadUrl(bVar2, str);
        this.f8173i.getSettings().setSavePassword(false);
    }

    private void b() {
        com.tencent.open.b.a aVar = new com.tencent.open.b.a(this.f8174j.get());
        this.f8172h = aVar;
        aVar.setBackgroundColor(1711276032);
        this.f8172h.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        com.tencent.open.b.b bVar = new com.tencent.open.b.b(this.f8174j.get());
        this.f8173i = bVar;
        bVar.setBackgroundColor(0);
        this.f8173i.setBackgroundDrawable(null);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                View.class.getMethod("setLayerType", Integer.TYPE, Paint.class).invoke(this.f8173i, 1, new Paint());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f8175k);
        layoutParams.addRule(13, -1);
        this.f8173i.setLayoutParams(layoutParams);
        this.f8172h.addView(this.f8173i);
        this.f8172h.a(this);
        setContentView(this.f8172h);
    }

    @Override // com.tencent.open.b.a.InterfaceC0280a
    public void a(int i2) {
        WeakReference<Context> weakReference = this.f8174j;
        if (weakReference != null && weakReference.get() != null) {
            if (i2 < this.f8175k && 2 == this.f8174j.get().getResources().getConfiguration().orientation) {
                this.f8173i.getLayoutParams().height = i2;
            } else {
                this.f8173i.getLayoutParams().height = this.f8175k;
            }
        }
        SLog.e("openSDK_LOG.PKDialog", "onKeyboardShown keyboard show");
    }

    @Override // com.tencent.open.b.a.InterfaceC0280a
    public void a() {
        this.f8173i.getLayoutParams().height = this.f8175k;
        SLog.e("openSDK_LOG.PKDialog", "onKeyboardHidden keyboard hide");
    }

    @Override // com.tencent.open.b
    protected void a(String str) {
        SLog.d("openSDK_LOG.PKDialog", "--onConsoleMessage--");
        try {
            this.a.a(this.f8173i, str);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str) {
        try {
            JSONObject d2 = l.d(str);
            int i2 = d2.getInt("type");
            String string = d2.getString("msg");
            if (i2 == 0) {
                Toast toast = c;
                if (toast == null) {
                    c = Toast.makeText(context, string, 0);
                } else {
                    toast.setView(toast.getView());
                    c.setText(string);
                    c.setDuration(0);
                }
                Toast toast2 = c;
                toast2.show();
                VdsAgent.showToast(toast2);
            } else if (i2 == 1) {
                Toast toast3 = c;
                if (toast3 == null) {
                    c = Toast.makeText(context, string, 1);
                } else {
                    toast3.setView(toast3.getView());
                    c.setText(string);
                    c.setDuration(1);
                }
                Toast toast4 = c;
                toast4.show();
                VdsAgent.showToast(toast4);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
