package cn.sharesdk.tencent.qzone;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.TitleLayout;
import cn.sharesdk.framework.authorize.RegisterView;
import cn.sharesdk.framework.g;
import cn.sharesdk.framework.utils.SSDKLog;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.tapjoy.TJAdUnitConstants;
import com.tencent.tauth.AuthActivity;
import java.util.List;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* compiled from: ShareActivity.java */
/* loaded from: classes.dex */
public class d extends FakeActivity {
    private String a;
    private boolean b;
    private PlatformActionListener c;

    /* renamed from: d  reason: collision with root package name */
    private RegisterView f285d;

    /* renamed from: e  reason: collision with root package name */
    private WebView f286e;

    /* renamed from: f  reason: collision with root package name */
    private String f287f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f288g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f289h;

    /* renamed from: i  reason: collision with root package name */
    private QZoneWebShareAdapter f290i;

    private void c() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(this.a));
            intent.putExtra("pkg_name", this.activity.getPackageName());
            if (Build.VERSION.SDK_INT >= 11) {
                intent.setFlags(335544320);
            }
            this.activity.startActivityForResult(intent, 100);
        } catch (Throwable th) {
            PlatformActionListener platformActionListener = this.c;
            if (platformActionListener != null) {
                platformActionListener.onError(null, 0, th);
            }
        }
    }

    private void d() {
        this.f285d = a();
        try {
            int stringRes = ResHelper.getStringRes(getContext(), "ssdk_share_to_qzone");
            if (stringRes > 0) {
                this.f285d.c().getTvTitle().setText(stringRes);
            }
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            TitleLayout c = this.f285d.c();
            c.setVisibility(8);
            VdsAgent.onSetViewVisibility(c, 8);
        }
        this.f290i.setBodyView(this.f285d.d());
        this.f290i.setWebView(this.f285d.b());
        this.f290i.setTitleView(this.f285d.c());
        this.f290i.onCreate();
        this.activity.setContentView(this.f285d);
        if (PortalFollowFeeds.TYPE_NONE.equals(DeviceHelper.getInstance(this.activity).getDetailNetworkTypeForStatic())) {
            this.f289h = true;
            finish();
            this.c.onError(null, 0, new Throwable("failed to load webpage, network disconnected."));
            return;
        }
        WebView b = this.f285d.b();
        String str = this.a;
        b.loadUrl(str);
        VdsAgent.loadUrl(b, str);
    }

    @Override // com.mob.tools.FakeActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        finish();
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        try {
            try {
                Class<?> cls = Class.forName("cn.sharesdk.tencent.qq.ReceiveActivity");
                cls.getMethod("setUriScheme", String.class).invoke(null, this.f287f);
                cls.getMethod("setPlatformActionListener", PlatformActionListener.class).invoke(null, this.c);
                if (this.b) {
                    c();
                } else {
                    d();
                }
            } catch (Throwable th) {
                this.activity.finish();
                PlatformActionListener platformActionListener = this.c;
                if (platformActionListener != null) {
                    platformActionListener.onError(null, 9, th);
                }
            }
        } catch (Throwable unused) {
            ReceiveActivity.a(this.f287f);
            ReceiveActivity.a(this.c);
            if (this.b) {
                c();
            } else {
                d();
            }
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        if (!this.b && !this.f289h && !this.f288g) {
            this.c.onCancel(null, 0);
        }
        WebView webView = this.f286e;
        if (webView != null) {
            webView.setFocusable(false);
        }
        QZoneWebShareAdapter qZoneWebShareAdapter = this.f290i;
        if (qZoneWebShareAdapter != null) {
            qZoneWebShareAdapter.onDestroy();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public boolean onFinish() {
        QZoneWebShareAdapter qZoneWebShareAdapter = this.f290i;
        if (qZoneWebShareAdapter != null) {
            return qZoneWebShareAdapter.onFinish();
        }
        return super.onFinish();
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        QZoneWebShareAdapter qZoneWebShareAdapter = this.f290i;
        if (qZoneWebShareAdapter != null) {
            qZoneWebShareAdapter.onPause();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onRestart() {
        QZoneWebShareAdapter qZoneWebShareAdapter = this.f290i;
        if (qZoneWebShareAdapter != null) {
            qZoneWebShareAdapter.onRestart();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        QZoneWebShareAdapter qZoneWebShareAdapter = this.f290i;
        if (qZoneWebShareAdapter != null) {
            qZoneWebShareAdapter.onResume();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onStart() {
        QZoneWebShareAdapter qZoneWebShareAdapter = this.f290i;
        if (qZoneWebShareAdapter != null) {
            qZoneWebShareAdapter.onStart();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onStop() {
        QZoneWebShareAdapter qZoneWebShareAdapter = this.f290i;
        if (qZoneWebShareAdapter != null) {
            qZoneWebShareAdapter.onStop();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void setActivity(Activity activity) {
        super.setActivity(activity);
        if (this.f290i == null) {
            QZoneWebShareAdapter b = b();
            this.f290i = b;
            if (b == null) {
                this.f290i = new QZoneWebShareAdapter();
            }
        }
        this.f290i.setActivity(activity);
    }

    private QZoneWebShareAdapter b() {
        try {
            String string = this.activity.getPackageManager().getActivityInfo(this.activity.getComponentName(), 128).metaData.getString("QZoneWebShareAdapter");
            if (string != null && string.length() > 0) {
                Object newInstance = Class.forName(string).newInstance();
                if (newInstance instanceof QZoneWebShareAdapter) {
                    return (QZoneWebShareAdapter) newInstance;
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            return null;
        }
    }

    public void a(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public void a(PlatformActionListener platformActionListener) {
        this.c = platformActionListener;
    }

    public void a(String str) {
        this.f287f = "tencent" + str;
    }

    protected RegisterView a() {
        RegisterView registerView = new RegisterView(this.activity);
        View childAt = registerView.c().getChildAt(registerView.c().getChildCount() - 1);
        childAt.setVisibility(8);
        VdsAgent.onSetViewVisibility(childAt, 8);
        registerView.a().setOnClickListener(new View.OnClickListener() { // from class: cn.sharesdk.tencent.qzone.d.1
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                new Thread() { // from class: cn.sharesdk.tencent.qzone.d.1.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Throwable th) {
                            SSDKLog.b().d(th);
                            d.this.finish();
                            d.this.c.onCancel(null, 0);
                        }
                    }
                }.start();
            }
        });
        WebView b = registerView.b();
        this.f286e = b;
        WebSettings settings = b.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(1);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.activity.getDir("database", 0).getPath());
        settings.setSavePassword(false);
        this.f286e.setVerticalScrollBarEnabled(false);
        this.f286e.setHorizontalScrollBarEnabled(false);
        this.f286e.setWebViewClient(new g() { // from class: cn.sharesdk.tencent.qzone.d.2
            @Override // cn.sharesdk.framework.g, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str != null && str.startsWith(d.this.f287f)) {
                    d.this.b(str);
                } else if (str != null && str.startsWith("mqzone://")) {
                    d.this.c(str);
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
        });
        return registerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        List<ResolveInfo> list;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        try {
            list = this.activity.getPackageManager().queryIntentActivities(intent, 1);
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            list = null;
        }
        if (list == null || list.size() <= 0) {
            return;
        }
        try {
            startActivity(intent);
        } catch (Throwable th2) {
            SSDKLog.b().d(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        String str2 = str == null ? "" : new String(str);
        Bundle urlToBundle = ResHelper.urlToBundle(str);
        if (urlToBundle == null) {
            this.f289h = true;
            finish();
            PlatformActionListener platformActionListener = this.c;
            platformActionListener.onError(null, 0, new Throwable("failed to parse callback uri: " + str2));
            return;
        }
        String string = urlToBundle.getString(AuthActivity.ACTION_KEY);
        if (!FirebaseAnalytics.Event.SHARE.equals(string) && !"shareToQzone".equals(string)) {
            this.f289h = true;
            finish();
            PlatformActionListener platformActionListener2 = this.c;
            platformActionListener2.onError(null, 0, new Throwable("action error: " + str2));
            return;
        }
        String string2 = urlToBundle.getString("result");
        if ("cancel".equals(string2)) {
            finish();
            this.c.onCancel(null, 0);
        } else if (!TJAdUnitConstants.String.VIDEO_COMPLETE.equals(string2)) {
            this.f289h = true;
            finish();
            PlatformActionListener platformActionListener3 = this.c;
            platformActionListener3.onError(null, 0, new Throwable("operation failed: " + str2));
        } else {
            String string3 = urlToBundle.getString("response");
            if (TextUtils.isEmpty(string3)) {
                this.f289h = true;
                finish();
                PlatformActionListener platformActionListener4 = this.c;
                platformActionListener4.onError(null, 0, new Throwable("response empty" + str2));
                return;
            }
            this.f288g = true;
            finish();
            this.c.onComplete(null, 0, new Hashon().fromJson(string3));
        }
    }
}
