package com.facebook.internal;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.facebook.AccessToken;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.common.R;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.tapjoy.TapjoyConstants;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class WebDialog extends Dialog {
    private static final int m = R.style.com_facebook_activity_theme;
    private static volatile int n;
    private static f o;
    private String a;
    private String b;
    private g c;

    /* renamed from: d  reason: collision with root package name */
    private WebView f3030d;

    /* renamed from: e  reason: collision with root package name */
    private ProgressDialog f3031e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f3032f;

    /* renamed from: g  reason: collision with root package name */
    private FrameLayout f3033g;

    /* renamed from: h  reason: collision with root package name */
    private h f3034h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f3035i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f3036j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f3037k;

    /* renamed from: l  reason: collision with root package name */
    private WindowManager.LayoutParams f3038l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements DialogInterface.OnCancelListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            WebDialog.this.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                WebDialog.this.cancel();
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements View.OnTouchListener {
        c(WebDialog webDialog) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (view.hasFocus()) {
                return false;
            }
            view.requestFocus();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends WebViewClient {
        private e() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (!WebDialog.this.f3036j) {
                WebDialog.this.f3031e.dismiss();
            }
            WebDialog.this.f3033g.setBackgroundColor(0);
            WebView webView2 = WebDialog.this.f3030d;
            webView2.setVisibility(0);
            VdsAgent.onSetViewVisibility(webView2, 0);
            WebDialog.this.f3032f.setVisibility(0);
            WebDialog.this.f3037k = true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            x.Y("FacebookSDK.WebDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
            if (WebDialog.this.f3036j) {
                return;
            }
            ProgressDialog progressDialog = WebDialog.this.f3031e;
            progressDialog.show();
            VdsAgent.showDialog(progressDialog);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            WebDialog.this.t(new FacebookDialogException(str, i2, str2));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            sslErrorHandler.cancel();
            WebDialog.this.t(new FacebookDialogException(null, -11, null));
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0096  */
        @Override // android.webkit.WebViewClient
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean shouldOverrideUrlLoading(android.webkit.WebView r6, java.lang.String r7) {
            /*
                r5 = this;
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r0 = "Redirect URL: "
                r6.append(r0)
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                java.lang.String r0 = "FacebookSDK.WebDialog"
                com.facebook.internal.x.Y(r0, r6)
                com.facebook.internal.WebDialog r6 = com.facebook.internal.WebDialog.this
                java.lang.String r6 = com.facebook.internal.WebDialog.a(r6)
                boolean r6 = r7.startsWith(r6)
                r0 = 1
                if (r6 == 0) goto La6
                com.facebook.internal.WebDialog r6 = com.facebook.internal.WebDialog.this
                android.os.Bundle r6 = r6.r(r7)
                java.lang.String r7 = "error"
                java.lang.String r7 = r6.getString(r7)
                if (r7 != 0) goto L37
                java.lang.String r7 = "error_type"
                java.lang.String r7 = r6.getString(r7)
            L37:
                java.lang.String r1 = "error_msg"
                java.lang.String r1 = r6.getString(r1)
                if (r1 != 0) goto L45
                java.lang.String r1 = "error_message"
                java.lang.String r1 = r6.getString(r1)
            L45:
                if (r1 != 0) goto L4d
                java.lang.String r1 = "error_description"
                java.lang.String r1 = r6.getString(r1)
            L4d:
                java.lang.String r2 = "error_code"
                java.lang.String r2 = r6.getString(r2)
                boolean r3 = com.facebook.internal.x.S(r2)
                r4 = -1
                if (r3 != 0) goto L5f
                int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.NumberFormatException -> L5f
                goto L60
            L5f:
                r2 = -1
            L60:
                boolean r3 = com.facebook.internal.x.S(r7)
                if (r3 == 0) goto L74
                boolean r3 = com.facebook.internal.x.S(r1)
                if (r3 == 0) goto L74
                if (r2 != r4) goto L74
                com.facebook.internal.WebDialog r7 = com.facebook.internal.WebDialog.this
                r7.u(r6)
                goto La5
            L74:
                if (r7 == 0) goto L8c
                java.lang.String r6 = "access_denied"
                boolean r6 = r7.equals(r6)
                if (r6 != 0) goto L86
                java.lang.String r6 = "OAuthAccessDeniedException"
                boolean r6 = r7.equals(r6)
                if (r6 == 0) goto L8c
            L86:
                com.facebook.internal.WebDialog r6 = com.facebook.internal.WebDialog.this
                r6.cancel()
                goto La5
            L8c:
                r6 = 4201(0x1069, float:5.887E-42)
                if (r2 != r6) goto L96
                com.facebook.internal.WebDialog r6 = com.facebook.internal.WebDialog.this
                r6.cancel()
                goto La5
            L96:
                com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
                r6.<init>(r2, r7, r1)
                com.facebook.internal.WebDialog r7 = com.facebook.internal.WebDialog.this
                com.facebook.FacebookServiceException r2 = new com.facebook.FacebookServiceException
                r2.<init>(r6, r1)
                r7.t(r2)
            La5:
                return r0
            La6:
                java.lang.String r6 = "fbconnect://cancel"
                boolean r6 = r7.startsWith(r6)
                if (r6 == 0) goto Lb4
                com.facebook.internal.WebDialog r6 = com.facebook.internal.WebDialog.this
                r6.cancel()
                return r0
            Lb4:
                java.lang.String r6 = "touch"
                boolean r6 = r7.contains(r6)
                r1 = 0
                if (r6 == 0) goto Lbf
                return r1
            Lbf:
                com.facebook.internal.WebDialog r6 = com.facebook.internal.WebDialog.this     // Catch: android.content.ActivityNotFoundException -> Ld4
                android.content.Context r6 = r6.getContext()     // Catch: android.content.ActivityNotFoundException -> Ld4
                android.content.Intent r2 = new android.content.Intent     // Catch: android.content.ActivityNotFoundException -> Ld4
                java.lang.String r3 = "android.intent.action.VIEW"
                android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch: android.content.ActivityNotFoundException -> Ld4
                r2.<init>(r3, r7)     // Catch: android.content.ActivityNotFoundException -> Ld4
                r6.startActivity(r2)     // Catch: android.content.ActivityNotFoundException -> Ld4
                return r0
            Ld4:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.WebDialog.e.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
        }

        /* synthetic */ e(WebDialog webDialog, a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(WebView webView);
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(Bundle bundle, FacebookException facebookException);
    }

    /* loaded from: classes.dex */
    private class h extends AsyncTask<Void, Void, String[]> {
        private String a;
        private Bundle b;
        private Exception[] c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements GraphRequest.e {
            final /* synthetic */ String[] a;
            final /* synthetic */ int b;
            final /* synthetic */ CountDownLatch c;

            a(String[] strArr, int i2, CountDownLatch countDownLatch) {
                this.a = strArr;
                this.b = i2;
                this.c = countDownLatch;
            }

            @Override // com.facebook.GraphRequest.e
            public void a(GraphResponse graphResponse) {
                FacebookRequestError g2;
                String str;
                try {
                    g2 = graphResponse.g();
                    str = "Error staging photo.";
                } catch (Exception e2) {
                    h.this.c[this.b] = e2;
                }
                if (g2 != null) {
                    String f2 = g2.f();
                    if (f2 != null) {
                        str = f2;
                    }
                    throw new FacebookGraphResponseException(graphResponse, str);
                }
                JSONObject h2 = graphResponse.h();
                if (h2 != null) {
                    String optString = h2.optString("uri");
                    if (optString != null) {
                        this.a[this.b] = optString;
                        this.c.countDown();
                        return;
                    }
                    throw new FacebookException("Error staging photo.");
                }
                throw new FacebookException("Error staging photo.");
            }
        }

        h(String str, Bundle bundle) {
            this.a = str;
            this.b = bundle;
        }

        protected String[] b(Void... voidArr) {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return null;
            }
            try {
                String[] stringArray = this.b.getStringArray("media");
                String[] strArr = new String[stringArray.length];
                this.c = new Exception[stringArray.length];
                CountDownLatch countDownLatch = new CountDownLatch(stringArray.length);
                ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
                AccessToken j2 = AccessToken.j();
                for (int i2 = 0; i2 < stringArray.length; i2++) {
                    try {
                        if (isCancelled()) {
                            Iterator it = concurrentLinkedQueue.iterator();
                            while (it.hasNext()) {
                                ((AsyncTask) it.next()).cancel(true);
                            }
                            return null;
                        }
                        Uri parse = Uri.parse(stringArray[i2]);
                        if (x.U(parse)) {
                            strArr[i2] = parse.toString();
                            countDownLatch.countDown();
                        } else {
                            concurrentLinkedQueue.add(com.facebook.share.internal.k.v(j2, parse, new a(strArr, i2, countDownLatch)).i());
                        }
                    } catch (Exception unused) {
                        Iterator it2 = concurrentLinkedQueue.iterator();
                        while (it2.hasNext()) {
                            ((AsyncTask) it2.next()).cancel(true);
                        }
                        return null;
                    }
                }
                countDownLatch.await();
                return strArr;
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
                return null;
            }
        }

        protected void c(String[] strArr) {
            Exception[] excArr;
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                WebDialog.this.f3031e.dismiss();
                for (Exception exc : this.c) {
                    if (exc != null) {
                        WebDialog.this.t(exc);
                        return;
                    }
                }
                if (strArr == null) {
                    WebDialog.this.t(new FacebookException("Failed to stage photos for web dialog"));
                    return;
                }
                List asList = Arrays.asList(strArr);
                if (asList.contains(null)) {
                    WebDialog.this.t(new FacebookException("Failed to stage photos for web dialog"));
                    return;
                }
                x.f0(this.b, "media", new JSONArray((Collection) asList));
                WebDialog.this.a = x.e(w.b(), com.facebook.f.r() + "/dialog/" + this.a, this.b).toString();
                WebDialog.this.x((WebDialog.this.f3032f.getDrawable().getIntrinsicWidth() / 2) + 1);
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ String[] doInBackground(Void[] voidArr) {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return null;
            }
            try {
                return b(voidArr);
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
                return null;
            }
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(String[] strArr) {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                c(strArr);
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WebDialog(Context context, String str) {
        this(context, str, l());
    }

    private void j() {
        ImageView imageView = new ImageView(getContext());
        this.f3032f = imageView;
        imageView.setOnClickListener(new b());
        this.f3032f.setImageDrawable(getContext().getResources().getDrawable(R.drawable.com_facebook_close));
        this.f3032f.setVisibility(4);
    }

    private int k(int i2, float f2, int i3, int i4) {
        int i5 = (int) (i2 / f2);
        double d2 = 0.5d;
        if (i5 <= i3) {
            d2 = 1.0d;
        } else if (i5 < i4) {
            d2 = 0.5d + (((i4 - i5) / (i4 - i3)) * 0.5d);
        }
        return (int) (i2 * d2);
    }

    public static int l() {
        y.n();
        return n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void n(Context context) {
        if (context == null) {
            return;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null || n != 0) {
                return;
            }
            y(applicationInfo.metaData.getInt("com.facebook.sdk.WebDialogTheme"));
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static WebDialog q(Context context, String str, Bundle bundle, int i2, g gVar) {
        n(context);
        return new WebDialog(context, str, bundle, i2, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetJavaScriptEnabled"})
    public void x(int i2) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        WebView webView = new WebView(this, getContext()) { // from class: com.facebook.internal.WebDialog.3
            @Override // android.webkit.WebView, android.view.View
            public void onWindowFocusChanged(boolean z) {
                try {
                    super.onWindowFocusChanged(z);
                } catch (NullPointerException unused) {
                }
            }
        };
        this.f3030d = webView;
        f fVar = o;
        if (fVar != null) {
            fVar.a(webView);
        }
        this.f3030d.setVerticalScrollBarEnabled(false);
        this.f3030d.setHorizontalScrollBarEnabled(false);
        this.f3030d.setWebViewClient(new e(this, null));
        this.f3030d.getSettings().setJavaScriptEnabled(true);
        WebView webView2 = this.f3030d;
        String str = this.a;
        webView2.loadUrl(str);
        VdsAgent.loadUrl(webView2, str);
        this.f3030d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        WebView webView3 = this.f3030d;
        webView3.setVisibility(4);
        VdsAgent.onSetViewVisibility(webView3, 4);
        this.f3030d.getSettings().setSavePassword(false);
        this.f3030d.getSettings().setSaveFormData(false);
        this.f3030d.setFocusable(true);
        this.f3030d.setFocusableInTouchMode(true);
        this.f3030d.setOnTouchListener(new c(this));
        linearLayout.setPadding(i2, i2, i2, i2);
        linearLayout.addView(this.f3030d);
        linearLayout.setBackgroundColor(-872415232);
        this.f3033g.addView(linearLayout);
    }

    public static void y(int i2) {
        if (i2 == 0) {
            i2 = m;
        }
        n = i2;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        if (this.c == null || this.f3035i) {
            return;
        }
        t(new FacebookOperationCanceledException());
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        ProgressDialog progressDialog;
        WebView webView = this.f3030d;
        if (webView != null) {
            webView.stopLoading();
        }
        if (!this.f3036j && (progressDialog = this.f3031e) != null && progressDialog.isShowing()) {
            this.f3031e.dismiss();
        }
        super.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WebView m() {
        return this.f3030d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean o() {
        return this.f3035i;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        WindowManager.LayoutParams layoutParams;
        this.f3036j = false;
        if (x.d0(getContext()) && (layoutParams = this.f3038l) != null && layoutParams.token == null) {
            layoutParams.token = getOwnerActivity().getWindow().getAttributes().token;
            x.Y("FacebookSDK.WebDialog", "Set token on onAttachedToWindow(): " + this.f3038l.token);
        }
        super.onAttachedToWindow();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        this.f3031e = progressDialog;
        progressDialog.requestWindowFeature(1);
        this.f3031e.setMessage(getContext().getString(R.string.com_facebook_loading));
        this.f3031e.setCanceledOnTouchOutside(false);
        this.f3031e.setOnCancelListener(new a());
        requestWindowFeature(1);
        this.f3033g = new FrameLayout(getContext());
        s();
        getWindow().setGravity(17);
        getWindow().setSoftInputMode(16);
        j();
        if (this.a != null) {
            x((this.f3032f.getDrawable().getIntrinsicWidth() / 2) + 1);
        }
        this.f3033g.addView(this.f3032f, new ViewGroup.LayoutParams(-2, -2));
        setContentView(this.f3033g);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f3036j = true;
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            WebView webView = this.f3030d;
            if (webView != null && webView.canGoBack()) {
                this.f3030d.goBack();
                return true;
            }
            cancel();
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        h hVar = this.f3034h;
        if (hVar != null && hVar.getStatus() == AsyncTask.Status.PENDING) {
            this.f3034h.execute(new Void[0]);
            ProgressDialog progressDialog = this.f3031e;
            progressDialog.show();
            VdsAgent.showDialog(progressDialog);
            return;
        }
        s();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        h hVar = this.f3034h;
        if (hVar != null) {
            hVar.cancel(true);
            this.f3031e.dismiss();
        }
        super.onStop();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        if (layoutParams.token == null) {
            this.f3038l = layoutParams;
        }
        super.onWindowAttributesChanged(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean p() {
        return this.f3037k;
    }

    protected Bundle r(String str) {
        Uri parse = Uri.parse(str);
        Bundle e0 = x.e0(parse.getQuery());
        e0.putAll(x.e0(parse.getFragment()));
        return e0;
    }

    public void s() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        int i4 = i2 < i3 ? i2 : i3;
        if (i2 < i3) {
            i2 = i3;
        }
        getWindow().setLayout(Math.min(k(i4, displayMetrics.density, 480, 800), displayMetrics.widthPixels), Math.min(k(i2, displayMetrics.density, 800, 1280), displayMetrics.heightPixels));
    }

    protected void t(Throwable th) {
        FacebookException facebookException;
        if (this.c == null || this.f3035i) {
            return;
        }
        this.f3035i = true;
        if (th instanceof FacebookException) {
            facebookException = (FacebookException) th;
        } else {
            facebookException = new FacebookException(th);
        }
        this.c.a(null, facebookException);
        dismiss();
    }

    protected void u(Bundle bundle) {
        g gVar = this.c;
        if (gVar == null || this.f3035i) {
            return;
        }
        this.f3035i = true;
        gVar.a(bundle, null);
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(String str) {
        this.b = str;
    }

    public void w(g gVar) {
        this.c = gVar;
    }

    private WebDialog(Context context, String str, int i2) {
        super(context, i2 == 0 ? l() : i2);
        this.b = "fbconnect://success";
        this.f3035i = false;
        this.f3036j = false;
        this.f3037k = false;
        this.a = str;
    }

    /* loaded from: classes.dex */
    public static class d {
        private Context a;
        private String b;
        private String c;

        /* renamed from: d  reason: collision with root package name */
        private int f3039d;

        /* renamed from: e  reason: collision with root package name */
        private g f3040e;

        /* renamed from: f  reason: collision with root package name */
        private Bundle f3041f;

        /* renamed from: g  reason: collision with root package name */
        private AccessToken f3042g;

        public d(Context context, String str, Bundle bundle) {
            this.f3042g = AccessToken.j();
            if (!AccessToken.x()) {
                String A = x.A(context);
                if (A != null) {
                    this.b = A;
                } else {
                    throw new FacebookException("Attempted to create a builder without a valid access token or a valid default Application ID.");
                }
            }
            b(context, str, bundle);
        }

        private void b(Context context, String str, Bundle bundle) {
            this.a = context;
            this.c = str;
            if (bundle != null) {
                this.f3041f = bundle;
            } else {
                this.f3041f = new Bundle();
            }
        }

        public WebDialog a() {
            AccessToken accessToken = this.f3042g;
            if (accessToken != null) {
                this.f3041f.putString(TapjoyConstants.TJC_APP_ID, accessToken.h());
                this.f3041f.putString("access_token", this.f3042g.t());
            } else {
                this.f3041f.putString(TapjoyConstants.TJC_APP_ID, this.b);
            }
            return WebDialog.q(this.a, this.c, this.f3041f, this.f3039d, this.f3040e);
        }

        public String c() {
            return this.b;
        }

        public Context d() {
            return this.a;
        }

        public g e() {
            return this.f3040e;
        }

        public Bundle f() {
            return this.f3041f;
        }

        public int g() {
            return this.f3039d;
        }

        public d h(g gVar) {
            this.f3040e = gVar;
            return this;
        }

        public d(Context context, String str, String str2, Bundle bundle) {
            str = str == null ? x.A(context) : str;
            y.m(str, "applicationId");
            this.b = str;
            b(context, str2, bundle);
        }
    }

    private WebDialog(Context context, String str, Bundle bundle, int i2, g gVar) {
        super(context, i2 == 0 ? l() : i2);
        this.b = "fbconnect://success";
        this.f3035i = false;
        this.f3036j = false;
        this.f3037k = false;
        bundle = bundle == null ? new Bundle() : bundle;
        String str2 = x.N(context) ? "fbconnect://chrome_os_success" : "fbconnect://success";
        this.b = str2;
        bundle.putString(ParamKeyConstants.WebViewConstants.QUERY_REDIRECT_URI, str2);
        bundle.putString("display", "touch");
        bundle.putString("client_id", com.facebook.f.g());
        bundle.putString("sdk", String.format(Locale.ROOT, "android-%s", com.facebook.f.w()));
        this.c = gVar;
        if (str.equals(FirebaseAnalytics.Event.SHARE) && bundle.containsKey("media")) {
            this.f3034h = new h(str, bundle);
            return;
        }
        String b2 = w.b();
        this.a = x.e(b2, com.facebook.f.r() + "/dialog/" + str, bundle).toString();
    }
}
