package cn.sharesdk.facebook;

import android.app.Activity;
import android.app.Instrumentation;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.TitleLayout;
import cn.sharesdk.framework.authorize.RegisterView;
import cn.sharesdk.framework.utils.SSDKLog;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import java.util.HashMap;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* compiled from: WebShareActivity.java */
/* loaded from: classes.dex */
public class k extends FakeActivity {
    private String a;
    private PlatformActionListener b;
    private a c;

    /* renamed from: d  reason: collision with root package name */
    private RegisterView f61d;

    /* renamed from: e  reason: collision with root package name */
    private WebView f62e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f63f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f64g;

    private a b() {
        try {
            String string = this.activity.getPackageManager().getActivityInfo(this.activity.getComponentName(), 128).metaData.getString("FBWebShareAdapter");
            if (string != null && string.length() > 0) {
                Object newInstance = Class.forName(string).newInstance();
                if (newInstance instanceof a) {
                    return (a) newInstance;
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            return null;
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        this.f61d = a();
        try {
            int stringRes = ResHelper.getStringRes(getContext(), "ssdk_share_to_facebook");
            if (stringRes > 0) {
                this.f61d.c().getTvTitle().setText(stringRes);
            }
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            TitleLayout c = this.f61d.c();
            c.setVisibility(8);
            VdsAgent.onSetViewVisibility(c, 8);
        }
        this.c.a(this.f61d.d());
        this.c.a(this.f61d.b());
        this.c.a(this.f61d.c());
        this.c.a();
        disableScreenCapture();
        this.activity.setContentView(this.f61d);
        if (PortalFollowFeeds.TYPE_NONE.equals(DeviceHelper.getInstance(this.activity).getDetailNetworkTypeForStatic())) {
            this.f63f = true;
            finish();
            this.b.onError(null, 0, new Throwable("failed to load webpage, network disconnected."));
            return;
        }
        WebView b = this.f61d.b();
        String str = this.a;
        b.loadUrl(str);
        VdsAgent.loadUrl(b, str);
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        if (!this.f63f && !this.f64g) {
            this.b.onCancel(null, 0);
        }
        WebView webView = this.f62e;
        if (webView != null) {
            webView.setFocusable(false);
        }
        a aVar = this.c;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public boolean onFinish() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.h();
        }
        return super.onFinish();
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onRestart() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.g();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onStart() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onStop() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void setActivity(Activity activity) {
        super.setActivity(activity);
        if (this.c == null) {
            a b = b();
            this.c = b;
            if (b == null) {
                this.c = new a();
            }
        }
        this.c.a(activity);
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(PlatformActionListener platformActionListener) {
        this.b = platformActionListener;
    }

    protected RegisterView a() {
        RegisterView registerView = new RegisterView(this.activity);
        View childAt = registerView.c().getChildAt(registerView.c().getChildCount() - 1);
        childAt.setVisibility(8);
        VdsAgent.onSetViewVisibility(childAt, 8);
        registerView.a().setOnClickListener(new View.OnClickListener() { // from class: cn.sharesdk.facebook.k.1
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                new Thread() { // from class: cn.sharesdk.facebook.k.1.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Throwable th) {
                            SSDKLog.b().d(th);
                            k.this.finish();
                            k.this.b.onCancel(null, 0);
                        }
                    }
                }.start();
            }
        });
        WebView b = registerView.b();
        this.f62e = b;
        WebSettings settings = b.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(1);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setSavePassword(false);
        settings.setDatabasePath(this.activity.getDir("database", 0).getPath());
        this.f62e.setVerticalScrollBarEnabled(false);
        this.f62e.setHorizontalScrollBarEnabled(false);
        this.f62e.setWebViewClient(new cn.sharesdk.framework.g() { // from class: cn.sharesdk.facebook.k.2
            @Override // cn.sharesdk.framework.g, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str != null) {
                    try {
                        if (str.startsWith("fbconnect://success")) {
                            k.this.b(str);
                        }
                    } catch (Exception e2) {
                        SSDKLog.b().d(e2.getMessage(), new Object[0]);
                    }
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
        });
        return registerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        String str2 = str == null ? "" : new String(str);
        Bundle urlToBundle = ResHelper.urlToBundle(str);
        if (urlToBundle == null) {
            this.f63f = true;
            finish();
            PlatformActionListener platformActionListener = this.b;
            platformActionListener.onError(null, 0, new Throwable("failed to parse callback uri: " + str2));
            return;
        }
        String string = urlToBundle.getString("post_id");
        HashMap<String, Object> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(string)) {
            hashMap.put("post_id", string);
        }
        if (!urlToBundle.containsKey("error_code") && !urlToBundle.containsKey("error")) {
            this.f64g = true;
            finish();
            this.b.onComplete(null, 0, hashMap);
            return;
        }
        if (this.b != null) {
            String string2 = urlToBundle.getString("error_code");
            if (urlToBundle.containsKey("error_code") && string2.equals("4201")) {
                this.b.onCancel(null, 9);
            } else {
                this.b.onError(null, 9, new Throwable(ResHelper.encodeUrl(urlToBundle)));
            }
        }
        this.f63f = true;
        finish();
    }
}
