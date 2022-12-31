package cn.sharesdk.framework.authorize;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.TitleLayout;
import cn.sharesdk.framework.authorize.ResizeLayout;
import cn.sharesdk.framework.utils.SSDKLog;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.UIHandler;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* compiled from: WebAuthorizeActivity.java */
/* loaded from: classes.dex */
public class g extends cn.sharesdk.framework.authorize.a implements Handler.Callback, ResizeLayout.OnResizeListener {
    protected AuthorizeListener b;
    private AuthorizeAdapter c;

    /* renamed from: d  reason: collision with root package name */
    private RegisterView f80d;

    /* renamed from: e  reason: collision with root package name */
    private WebView f81e;

    /* compiled from: WebAuthorizeActivity.java */
    /* loaded from: classes.dex */
    private static class a implements Interpolator {
        private float[] a;

        private a() {
            this.a = new float[]{0.0f, 0.02692683f, 0.053847015f, 0.080753915f, 0.10764089f, 0.13450131f, 0.16132854f, 0.18811597f, 0.21485697f, 0.24154496f, 0.26817337f, 0.2947356f, 0.3212251f, 0.34763536f, 0.37395984f, 0.40019205f, 0.42632553f, 0.4523538f, 0.47827047f, 0.50406915f, 0.52974343f, 0.555287f, 0.5806936f, 0.60595685f, 0.6310707f, 0.65602875f, 0.68082494f, 0.70545316f, 0.72990733f, 0.75418144f, 0.7782694f, 0.8021654f, 0.8258634f, 0.8493577f, 0.8726424f, 0.89571184f, 0.9185602f, 0.94118196f, 0.9635715f, 0.9857233f, 1.0076319f, 1.0292919f, 1.0506978f, 1.0718446f, 1.0927268f, 1.1133395f, 1.1336775f, 1.1537358f, 1.1735094f, 1.1929934f, 1.1893399f, 1.1728106f, 1.1565471f, 1.1405534f, 1.1248333f, 1.1093911f, 1.0942302f, 1.0793544f, 1.0647675f, 1.050473f, 1.0364745f, 1.0227754f, 1.0093791f, 0.99628896f, 0.9835081f, 0.9710398f, 0.958887f, 0.9470527f, 0.93553996f, 0.9243516f, 0.91349024f, 0.90295863f, 0.90482706f, 0.9114033f, 0.91775465f, 0.9238795f, 0.9297765f, 0.93544406f, 0.9408808f, 0.94608533f, 0.95105654f, 0.955793f, 0.9602937f, 0.9645574f, 0.96858317f, 0.9723699f, 0.97591674f, 0.97922283f, 0.9822872f, 0.9851093f, 0.98768836f, 0.9900237f, 0.9921147f, 0.993961f, 0.99556196f, 0.9969173f, 0.9980267f, 0.99888986f, 0.99950653f, 0.9998766f, 1.0f};
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            int i2 = (int) (f2 * 100.0f);
            if (i2 < 0) {
                i2 = 0;
            }
            if (i2 > 100) {
                i2 = 100;
            }
            return this.a[i2];
        }
    }

    private AuthorizeAdapter c() {
        String string;
        try {
            ActivityInfo activityInfo = this.activity.getPackageManager().getActivityInfo(this.activity.getComponentName(), 128);
            Bundle bundle = activityInfo.metaData;
            if (bundle != null && !bundle.isEmpty() && (((string = activityInfo.metaData.getString("AuthorizeAdapter")) != null && string.length() > 0) || ((string = activityInfo.metaData.getString("Adapter")) != null && string.length() > 0))) {
                Object newInstance = Class.forName(string).newInstance();
                if (newInstance instanceof AuthorizeAdapter) {
                    return (AuthorizeAdapter) newInstance;
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            SSDKLog.b().w(th);
            return null;
        }
    }

    @Override // cn.sharesdk.framework.authorize.ResizeLayout.OnResizeListener
    public void OnResize(int i2, int i3, int i4, int i5) {
        AuthorizeAdapter authorizeAdapter = this.c;
        if (authorizeAdapter != null) {
            authorizeAdapter.onResize(i2, i3, i4, i5);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 2) {
            return false;
        }
        if (message.arg1 == 1) {
            AuthorizeListener authorizeListener = this.a.getAuthorizeListener();
            if (authorizeListener != null) {
                authorizeListener.onError(new Throwable("Network error (platform: " + this.a.getPlatform().getName() + ")"));
                return false;
            }
            return false;
        }
        String str = (String) message.obj;
        if (TextUtils.isEmpty(str)) {
            finish();
            AuthorizeListener authorizeListener2 = this.a.getAuthorizeListener();
            if (authorizeListener2 != null) {
                authorizeListener2.onError(new Throwable("Authorize URL is empty (platform: " + this.a.getPlatform().getName() + ")"));
                return false;
            }
            return false;
        }
        WebView webView = this.f81e;
        webView.loadUrl(str);
        VdsAgent.loadUrl(webView, str);
        return false;
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        if (this.f80d == null) {
            RegisterView b = b();
            this.f80d = b;
            b.a(this);
            this.f80d.a(this.c.isNotitle());
            this.c.setBodyView(this.f80d.d());
            this.c.setWebView(this.f80d.b());
            TitleLayout c = this.f80d.c();
            this.c.setTitleView(c);
            String name = this.a.getPlatform().getName();
            this.c.setPlatformName(this.a.getPlatform().getName());
            try {
                Context context = getContext();
                c.getTvTitle().setText(ResHelper.getStringRes(context, "ssdk_" + name.toLowerCase()));
            } catch (Throwable th) {
                try {
                    c.getTvTitle().setText(ResHelper.getStringRes(getContext(), "ssdk_weibo_oauth_regiseter"));
                } catch (Throwable unused) {
                    SSDKLog.b().w(th);
                }
            }
        }
        this.c.onCreate();
        AuthorizeAdapter authorizeAdapter = this.c;
        if (authorizeAdapter != null && !authorizeAdapter.isPopUpAnimationDisable()) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(550L);
            scaleAnimation.setInterpolator(new a());
            this.f80d.setAnimation(scaleAnimation);
        }
        disableScreenCapture();
        this.activity.setContentView(this.f80d);
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        AuthorizeAdapter authorizeAdapter = this.c;
        if (authorizeAdapter != null) {
            authorizeAdapter.onDestroy();
        }
        WebView webView = this.f81e;
        if (webView != null) {
            webView.setFocusable(false);
        }
    }

    @Override // com.mob.tools.FakeActivity
    public boolean onFinish() {
        AuthorizeAdapter authorizeAdapter = this.c;
        if (authorizeAdapter != null) {
            return authorizeAdapter.onFinish();
        }
        WebView webView = this.f81e;
        if (webView != null) {
            webView.destroy();
            this.f81e.removeAllViews();
        }
        Activity activity = this.activity;
        if (activity != null) {
            ((ViewGroup) activity.getWindow().getDecorView()).removeAllViews();
        }
        return super.onFinish();
    }

    @Override // com.mob.tools.FakeActivity
    public boolean onKeyEvent(int i2, KeyEvent keyEvent) {
        AuthorizeListener authorizeListener;
        AuthorizeAdapter authorizeAdapter = this.c;
        boolean onKeyEvent = authorizeAdapter != null ? authorizeAdapter.onKeyEvent(i2, keyEvent) : false;
        if (!onKeyEvent && i2 == 4 && keyEvent.getAction() == 0 && (authorizeListener = this.a.getAuthorizeListener()) != null) {
            authorizeListener.onCancel();
        }
        if (onKeyEvent) {
            return true;
        }
        return super.onKeyEvent(i2, keyEvent);
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        AuthorizeAdapter authorizeAdapter = this.c;
        if (authorizeAdapter != null) {
            authorizeAdapter.onPause();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onRestart() {
        AuthorizeAdapter authorizeAdapter = this.c;
        if (authorizeAdapter != null) {
            authorizeAdapter.onRestart();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        AuthorizeAdapter authorizeAdapter = this.c;
        if (authorizeAdapter != null) {
            authorizeAdapter.onResume();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onStart() {
        AuthorizeAdapter authorizeAdapter = this.c;
        if (authorizeAdapter != null) {
            authorizeAdapter.onStart();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onStop() {
        AuthorizeAdapter authorizeAdapter = this.c;
        if (authorizeAdapter != null) {
            authorizeAdapter.onStop();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void setActivity(Activity activity) {
        super.setActivity(activity);
        if (this.c == null) {
            AuthorizeAdapter c = c();
            this.c = c;
            if (c == null) {
                this.c = new AuthorizeAdapter();
            }
        }
        this.c.setActivity(activity);
    }

    public void a(AuthorizeListener authorizeListener) {
        this.b = authorizeListener;
    }

    protected RegisterView b() {
        RegisterView registerView = new RegisterView(this.activity);
        registerView.a().setOnClickListener(new View.OnClickListener() { // from class: cn.sharesdk.framework.authorize.g.1
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                new Thread() { // from class: cn.sharesdk.framework.authorize.g.1.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Throwable th) {
                            SSDKLog.b().w(th);
                            AuthorizeListener authorizeListener = g.this.a.getAuthorizeListener();
                            if (authorizeListener != null) {
                                authorizeListener.onCancel();
                            }
                            g.this.finish();
                        }
                    }
                }.start();
            }
        });
        WebView b = registerView.b();
        this.f81e = b;
        WebSettings settings = b.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(false);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        settings.setSavePassword(false);
        this.f81e.setVerticalScrollBarEnabled(false);
        this.f81e.setHorizontalScrollBarEnabled(false);
        c authorizeWebviewClient = this.a.getAuthorizeWebviewClient(this);
        String simpleName = authorizeWebviewClient != null ? authorizeWebviewClient.getClass().getSimpleName() : "";
        if ((!TextUtils.isEmpty(simpleName) && simpleName.equals("GooglePlusAuthorizeWebviewClient")) || ((!TextUtils.isEmpty(simpleName) && simpleName.contains("GooglePlus")) || simpleName.equals("YoutubeAuthorizeWebviewClient"))) {
            this.f81e.getSettings().setUserAgentString(((("Mozilla/5.0 (Linux; Android 5.1; m2 note Build/LMY47D) AppleWebKit/537.36 (KHTML, like Gecko) ") + "Version/4.0 ") + "Chrome/40.0.2214.127 ") + "Mobile Safari/537.36");
        }
        this.f81e.setWebViewClient(authorizeWebviewClient);
        new Thread() { // from class: cn.sharesdk.framework.authorize.g.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    Message message = new Message();
                    message.what = 2;
                    if (PortalFollowFeeds.TYPE_NONE.equals(DeviceHelper.getInstance(((FakeActivity) g.this).activity).getDetailNetworkTypeForStatic())) {
                        message.arg1 = 1;
                        UIHandler.sendMessage(message, g.this);
                        return;
                    }
                    if (ShareSDK.isRemoveCookieOnAuthorize()) {
                        CookieSyncManager.createInstance(((FakeActivity) g.this).activity);
                        CookieManager.getInstance().removeAllCookie();
                    }
                    message.obj = g.this.a.getAuthorizeUrl();
                    UIHandler.sendMessage(message, g.this);
                } catch (Throwable th) {
                    SSDKLog.b().w(th);
                }
            }
        }.start();
        return registerView;
    }
}
