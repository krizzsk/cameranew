package com.tapjoy;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.internal.jq;
import com.tencent.open.SocialConstants;
import java.util.Arrays;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;
import us.pinguo.androidsdk.PGImageSDK;
/* loaded from: classes3.dex */
public class TJSplitWebView extends RelativeLayout {
    private TJWebView a;
    @Nullable
    private a b;
    @Nullable
    private a c;

    /* renamed from: d  reason: collision with root package name */
    private String f7247d;

    /* renamed from: e  reason: collision with root package name */
    private String f7248e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private String f7249f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private Uri f7250g;

    /* renamed from: h  reason: collision with root package name */
    private HashSet f7251h;

    /* renamed from: i  reason: collision with root package name */
    private JSONObject f7252i;

    /* renamed from: j  reason: collision with root package name */
    private TJAdUnitJSBridge f7253j;

    /* renamed from: k  reason: collision with root package name */
    private Context f7254k;

    /* renamed from: l  reason: collision with root package name */
    private Boolean f7255l;
    private RelativeLayout m;
    private FrameLayout n;
    private ProgressBar o;
    private TextView p;
    private TJImageButton q;
    private TJImageButton r;
    private String s;
    private boolean t;
    private String u;
    private String v;
    private String w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        final double a;
        final double b;
        final double c;

        /* renamed from: d  reason: collision with root package name */
        final double f7256d;

        /* renamed from: e  reason: collision with root package name */
        final float f7257e;

        a(JSONObject jSONObject) {
            this.a = jSONObject.optDouble("width", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            this.b = jSONObject.optDouble("height", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            this.c = jSONObject.optDouble(TJAdUnitConstants.String.LEFT, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            this.f7256d = jSONObject.optDouble(TJAdUnitConstants.String.TOP, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            this.f7257e = (float) jSONObject.optDouble("cornerRadius", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        }
    }

    /* loaded from: classes3.dex */
    class b extends WebViewClient {
        private b() {
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (TJSplitWebView.this.f7255l.booleanValue()) {
                if (TJSplitWebView.this.o != null) {
                    TJSplitWebView.this.o.setProgress(0);
                    ProgressBar progressBar = TJSplitWebView.this.o;
                    progressBar.setVisibility(8);
                    VdsAgent.onSetViewVisibility(progressBar, 8);
                }
                TJSplitWebView.this.isFirstOrLastPage();
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (TJSplitWebView.this.f7255l.booleanValue()) {
                TJSplitWebView.this.p.setText(TapjoyUrlFormatter.getDomain(str));
                ProgressBar progressBar = TJSplitWebView.this.o;
                progressBar.setVisibility(0);
                VdsAgent.onSetViewVisibility(progressBar, 0);
            }
            TapjoyLog.d("TJSplitWebView", "onPageStarted: " + str);
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView webView, int i2, String str, String str2) {
            TapjoyLog.d("TJSplitWebView", "onReceivedError: " + str2 + " firstUrl:" + TJSplitWebView.this.f7247d);
            if (!TJSplitWebView.this.t) {
                if (str2.equals(TJSplitWebView.this.f7247d)) {
                    TJSplitWebView.this.a();
                    return;
                }
                return;
            }
            TJSplitWebView.this.showErrorDialog();
        }

        @Override // android.webkit.WebViewClient
        @Nullable
        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            String str2 = TJSplitWebView.this.f7249f;
            Uri uri = TJSplitWebView.this.f7250g;
            if (str2 != null && uri != null && str != null && str.startsWith(str2)) {
                TJSplitWebView.this.f7254k.startActivity(new Intent("android.intent.action.VIEW", uri));
                TJSplitWebView.this.a();
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            TapjoyLog.d("TJSplitWebView", "shouldOverrideUrlLoading: " + str);
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String host = parse.getHost();
                String scheme = parse.getScheme();
                if (scheme != null && host != null && ((scheme.equals("http") || scheme.equals("https")) && (TJSplitWebView.this.f7251h == null || !TJSplitWebView.this.f7251h.contains(host)))) {
                    TJSplitWebView.this.f7248e = str;
                    return false;
                }
            }
            try {
                TJSplitWebView.this.f7254k.startActivity(new Intent("android.intent.action.VIEW", parse));
                if (TJSplitWebView.this.f7255l.booleanValue()) {
                    return true;
                }
                TJSplitWebView.this.a();
                return true;
            } catch (Exception e2) {
                TapjoyLog.e("TJSplitWebView", e2.getMessage());
                return true;
            }
        }

        /* synthetic */ b(TJSplitWebView tJSplitWebView, byte b) {
            this();
        }
    }

    @TargetApi(21)
    public TJSplitWebView(Context context, JSONObject jSONObject, TJAdUnitJSBridge tJAdUnitJSBridge) {
        super(context);
        this.f7253j = tJAdUnitJSBridge;
        this.f7254k = context;
        JSONObject optJSONObject = jSONObject.optJSONObject(TJAdUnitConstants.String.SPLIT_VIEW_LAYOUT);
        JSONArray optJSONArray = jSONObject.optJSONArray(TJAdUnitConstants.String.SPLIT_VIEW_EXIT_HOSTS);
        JSONObject optJSONObject2 = jSONObject.optJSONObject(TJAdUnitConstants.String.SPLIT_VIEW_ERROR_DIALOG_STRINGS);
        this.s = jSONObject.optString(TJAdUnitConstants.String.SPLIT_VIEW_URL_FOR_EXTERNAL_OPEN);
        this.f7252i = jSONObject.optJSONObject(TJAdUnitConstants.String.SPLIT_VIEW_ANIMATION);
        setLayoutOption(optJSONObject);
        setExitHosts(optJSONArray);
        setErrorDialog(optJSONObject2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        TJWebView tJWebView = new TJWebView(this.f7254k);
        this.a = tJWebView;
        tJWebView.setId(TapjoyUtil.generateViewId());
        this.a.setBackgroundColor(-1);
        WebSettings settings = this.a.getSettings();
        if (settings != null) {
            settings.setUseWideViewPort(true);
        }
        this.a.setWebViewClient(new b(this, (byte) 0));
        Boolean valueOf = Boolean.valueOf(jSONObject.optBoolean(TJAdUnitConstants.String.SPLIT_VIEW_SHOW_TOOLBAR));
        this.f7255l = valueOf;
        if (valueOf.booleanValue()) {
            addToolbar();
            addLineBreak();
            addProgressBar();
            TJWebView tJWebView2 = this.a;
            WebChromeClient webChromeClient = new WebChromeClient() { // from class: com.tapjoy.TJSplitWebView.1
                @Override // android.webkit.WebChromeClient
                public final void onProgressChanged(WebView webView, int i2) {
                    VdsAgent.onProgressChangedStart(webView, i2);
                    super.onProgressChanged(webView, i2);
                    TJSplitWebView.this.o.setProgress(i2);
                    TJSplitWebView.this.isFirstOrLastPage();
                    VdsAgent.onProgressChangedEnd(webView, i2);
                }
            };
            tJWebView2.setWebChromeClient(webChromeClient);
            VdsAgent.setWebChromeClient(tJWebView2, webChromeClient);
        }
        addView(this.a, layoutParams);
    }

    @TargetApi(21)
    public void addLineBreak() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.n = frameLayout;
        frameLayout.setBackgroundColor(Color.parseColor("#dddddd"));
        addView(this.n);
    }

    @TargetApi(21)
    public void addProgressBar() {
        ProgressBar progressBar = new ProgressBar(this.f7254k, null, 16842872);
        this.o = progressBar;
        progressBar.setMax(100);
        this.o.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#5d95ff")));
        this.o.setProgressBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#dddddd")));
        addView(this.o);
    }

    @TargetApi(21)
    public void addToolbar() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f7254k);
        this.m = relativeLayout;
        relativeLayout.setId(TapjoyUtil.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) (new TapjoyDisplayMetricsUtil(getContext()).getScreenDensityScale() * 40.0f));
        layoutParams.addRule(6);
        this.m.setBackgroundColor(-1);
        RelativeLayout relativeLayout2 = this.m;
        relativeLayout2.setVisibility(0);
        VdsAgent.onSetViewVisibility(relativeLayout2, 0);
        setupToolbarUI();
        addView(this.m, layoutParams);
    }

    public void animateOpen(ViewGroup viewGroup) {
        JSONObject jSONObject = this.f7252i;
        if (jSONObject != null && jSONObject.has(TJAdUnitConstants.String.ANIMATION_EVENT_ON_OPEN) && this.f7252i.optString(TJAdUnitConstants.String.ANIMATION_EVENT_ON_OPEN).equalsIgnoreCase(TJAdUnitConstants.String.ANIMATION_TYPE_SLIDE_UP)) {
            setY(viewGroup.getHeight());
            animate().translationY(0.0f);
        }
    }

    public void applyLayoutOption(JSONObject jSONObject) {
        setLayoutOption(jSONObject);
        a(getWidth(), getHeight());
    }

    public String getLastUrl() {
        return this.f7248e;
    }

    public boolean goBack() {
        if (this.a.canGoBack()) {
            this.a.goBack();
            return true;
        }
        return false;
    }

    public void isFirstOrLastPage() {
        this.q.setEnabled(this.a.canGoBack());
        this.r.setEnabled(this.a.canGoForward());
    }

    public void loadUrl(String str) {
        TJWebView tJWebView = this.a;
        if (tJWebView != null) {
            this.f7247d = str;
            this.f7248e = str;
            tJWebView.loadUrl(str);
            VdsAgent.loadUrl(tJWebView, str);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        a(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
        super.onMeasure(i2, i3);
    }

    public void openInExternalBrowser() {
        Uri parse;
        if (jq.c(this.s)) {
            parse = Uri.parse(this.a.getUrl());
            if (parse == null) {
                parse = Uri.parse(getLastUrl());
            }
        } else {
            parse = Uri.parse(this.s);
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(parse);
        intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
        if (this.a.getContext() != null) {
            try {
                this.a.getContext().startActivity(intent);
            } catch (Exception e2) {
                TapjoyLog.d("TJSplitWebView", e2.getMessage());
            }
        }
    }

    public void setErrorDialog(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.t = true;
            this.u = jSONObject.optString(SocialConstants.PARAM_COMMENT);
            this.v = jSONObject.optString(TJAdUnitConstants.String.CLOSE);
            this.w = jSONObject.optString("reload");
        }
    }

    public void setExitHosts(JSONArray jSONArray) {
        if (jSONArray == null) {
            this.f7251h = null;
            return;
        }
        this.f7251h = new HashSet();
        for (int i2 = 0; i2 <= jSONArray.length(); i2++) {
            String optString = jSONArray.optString(i2);
            if (optString != null) {
                this.f7251h.add(optString);
            }
        }
    }

    protected void setLayoutOption(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(TJAdUnitConstants.String.LANDSCAPE);
            this.c = optJSONObject != null ? new a(optJSONObject) : null;
            JSONObject optJSONObject2 = jSONObject.optJSONObject(TJAdUnitConstants.String.PORTRAIT);
            this.b = optJSONObject2 != null ? new a(optJSONObject2) : null;
        }
    }

    public void setTrigger(@Nullable String str, @Nullable String str2) {
        this.f7249f = jq.b(str);
        this.f7250g = str2 != null ? Uri.parse(str2) : null;
    }

    public void setUserAgent(String str) {
        this.a.getSettings().setUserAgentString(str);
    }

    @TargetApi(21)
    public void setupToolbarUI() {
        float screenDensityScale = new TapjoyDisplayMetricsUtil(getContext()).getScreenDensityScale();
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        TJImageButton tJImageButton = new TJImageButton(this.f7254k);
        this.q = tJImageButton;
        tJImageButton.setId(TapjoyUtil.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        int i2 = (int) (10.0f * screenDensityScale);
        layoutParams.setMargins(i2, i2, i2, i2);
        int i3 = (int) (5.0f * screenDensityScale);
        this.q.setPadding(i3, i2, i2, i2);
        this.q.setEnabledImageBitmap(TapjoyIcons.getBackEnabledImage(screenDensityScale));
        this.q.setDisableImageBitmap(TapjoyIcons.getBackDisabledImage(screenDensityScale));
        this.q.setBackgroundColor(0);
        this.q.setOnClickListener(new View.OnClickListener() { // from class: com.tapjoy.TJSplitWebView.2
            @Override // android.view.View.OnClickListener
            @Instrumented
            public final void onClick(View view) {
                VdsAgent.onClick(this, view);
                if (TJSplitWebView.this.a.canGoBack()) {
                    TJSplitWebView.this.a.goBack();
                }
            }
        });
        relativeLayout.addView(this.q, layoutParams);
        this.r = new TJImageButton(this.f7254k);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(1, this.q.getId());
        layoutParams2.setMargins(i2, i2, i2, i2);
        this.r.setPadding(i2, i2, i3, i2);
        this.r.setEnabledImageBitmap(TapjoyIcons.getForwardEnabledImage(screenDensityScale));
        this.r.setDisableImageBitmap(TapjoyIcons.getForwardDisabledImage(screenDensityScale));
        this.r.setBackgroundColor(0);
        this.r.setOnClickListener(new View.OnClickListener() { // from class: com.tapjoy.TJSplitWebView.3
            @Override // android.view.View.OnClickListener
            @Instrumented
            public final void onClick(View view) {
                VdsAgent.onClick(this, view);
                TJSplitWebView.this.a.goForward();
            }
        });
        relativeLayout.addView(this.r, layoutParams2);
        ImageButton imageButton = new ImageButton(this.f7254k);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(15);
        layoutParams3.addRule(11);
        layoutParams3.setMargins(i2, i2, i2, i2);
        imageButton.setPadding(i3, i3, i3, i3);
        imageButton.setImageBitmap(TapjoyIcons.getCloseImage(screenDensityScale));
        imageButton.setBackgroundColor(0);
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.tapjoy.TJSplitWebView.4
            @Override // android.view.View.OnClickListener
            @Instrumented
            public final void onClick(View view) {
                VdsAgent.onClick(this, view);
                TJSplitWebView.this.a();
            }
        });
        relativeLayout.addView(imageButton, layoutParams3);
        TextView textView = new TextView(this.f7254k);
        this.p = textView;
        textView.setId(TapjoyUtil.generateViewId());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(13);
        this.p.setMaxLines(1);
        this.p.setMaxEms(200);
        this.p.setTextAlignment(4);
        this.p.setTextColor(Color.parseColor("#5d95ff"));
        this.p.setBackgroundColor(0);
        this.p.setEnabled(false);
        this.p.setTypeface(Typeface.create("sans-serif-medium", 0));
        relativeLayout.addView(this.p, layoutParams4);
        ImageButton imageButton2 = new ImageButton(this.f7254k);
        imageButton2.setId(TapjoyUtil.generateViewId());
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(1, this.p.getId());
        layoutParams5.addRule(15);
        imageButton2.setPadding(i3, i3, i3, i3);
        imageButton2.setImageBitmap(TapjoyIcons.getOpenBrowserImage(screenDensityScale));
        imageButton2.setBackgroundColor(0);
        imageButton2.setOnClickListener(new View.OnClickListener() { // from class: com.tapjoy.TJSplitWebView.5
            @Override // android.view.View.OnClickListener
            @Instrumented
            public final void onClick(View view) {
                VdsAgent.onClick(this, view);
                TJSplitWebView.this.openInExternalBrowser();
            }
        });
        relativeLayout.addView(imageButton2, layoutParams5);
        this.m.addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -2));
    }

    @TargetApi(21)
    public void showErrorDialog() {
        AlertDialog create = new AlertDialog.Builder(this.f7254k, 16974394).setMessage(this.u).setPositiveButton(this.v, new DialogInterface.OnClickListener() { // from class: com.tapjoy.TJSplitWebView.7
            @Override // android.content.DialogInterface.OnClickListener
            @Instrumented
            public final void onClick(DialogInterface dialogInterface, int i2) {
                VdsAgent.onClick(this, dialogInterface, i2);
                dialogInterface.cancel();
            }
        }).setNegativeButton(this.w, new DialogInterface.OnClickListener() { // from class: com.tapjoy.TJSplitWebView.6
            @Override // android.content.DialogInterface.OnClickListener
            @Instrumented
            public final void onClick(DialogInterface dialogInterface, int i2) {
                VdsAgent.onClick(this, dialogInterface, i2);
                if (jq.c(TJSplitWebView.this.getLastUrl())) {
                    TJSplitWebView tJSplitWebView = TJSplitWebView.this;
                    tJSplitWebView.loadUrl(tJSplitWebView.f7247d);
                } else {
                    TJSplitWebView tJSplitWebView2 = TJSplitWebView.this;
                    tJSplitWebView2.loadUrl(tJSplitWebView2.getLastUrl());
                }
                dialogInterface.cancel();
            }
        }).create();
        create.show();
        VdsAgent.showDialog(create);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        this.f7253j.dismissSplitView(null, null);
    }

    private void a(int i2, int i3) {
        a aVar = i2 <= i3 ? this.b : this.c;
        if (aVar == null) {
            TJWebView tJWebView = this.a;
            tJWebView.setVisibility(4);
            VdsAgent.onSetViewVisibility(tJWebView, 4);
            return;
        }
        double d2 = i2;
        int i4 = (int) (aVar.a * d2);
        double d3 = i3;
        int i5 = (int) (aVar.b * d3);
        if (i4 != 0 && i5 != 0) {
            int i6 = (int) (d2 * aVar.c);
            int i7 = (int) (d3 * aVar.f7256d);
            int i8 = (i2 - i4) - i6;
            int i9 = (i3 - i5) - i7;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i5;
            Boolean bool = this.f7255l;
            if (bool != null && bool.booleanValue()) {
                float screenDensityScale = new TapjoyDisplayMetricsUtil(getContext()).getScreenDensityScale();
                int height = ((int) (40.0f * screenDensityScale)) + this.n.getHeight();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams2.setMargins(i6, i7, i8, i9);
                this.m.setLayoutParams(layoutParams2);
                layoutParams.setMargins(i6, i7 + height, i8, i9);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i4, (int) screenDensityScale);
                layoutParams3.setMargins(i6, layoutParams.topMargin - this.o.getHeight(), i8, i9);
                this.o.setLayoutParams(layoutParams3);
                this.n.setLayoutParams(layoutParams3);
            } else {
                layoutParams.setMargins(i6, i7, i8, i9);
            }
            this.a.setLayoutParams(layoutParams);
            TJWebView tJWebView2 = this.a;
            tJWebView2.setVisibility(0);
            VdsAgent.onSetViewVisibility(tJWebView2, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                float f2 = aVar.f7257e;
                if (f2 > 0.0f) {
                    float[] fArr = new float[8];
                    final float f3 = f2 * getResources().getDisplayMetrics().density;
                    Boolean bool2 = this.f7255l;
                    if (bool2 != null && bool2.booleanValue()) {
                        this.m.setOutlineProvider(new ViewOutlineProvider() { // from class: com.tapjoy.TJSplitWebView.8
                            @Override // android.view.ViewOutlineProvider
                            public final void getOutline(View view, Outline outline) {
                                int width = view.getWidth();
                                float f4 = f3;
                                outline.setRoundRect(0, 0, width, (int) (view.getHeight() + f4), f4);
                            }
                        });
                        this.m.setClipToOutline(true);
                        return;
                    }
                    Arrays.fill(fArr, f3);
                    ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, null, null));
                    shapeDrawable.getPaint().setColor(-1);
                    this.a.setBackground(shapeDrawable);
                    this.a.setClipToOutline(true);
                    return;
                }
                this.a.setBackground(null);
                this.a.setClipToOutline(false);
                Boolean bool3 = this.f7255l;
                if (bool3 == null || !bool3.booleanValue()) {
                    return;
                }
                this.m.setClipToOutline(false);
                return;
            }
            return;
        }
        TJWebView tJWebView3 = this.a;
        tJWebView3.setVisibility(4);
        VdsAgent.onSetViewVisibility(tJWebView3, 4);
    }
}
