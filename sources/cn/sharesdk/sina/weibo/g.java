package cn.sharesdk.sina.weibo;

import android.os.Bundle;
import android.widget.LinearLayout;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.WBAPIFactory;
/* compiled from: SinaWeiboWebAuthOfficial.java */
/* loaded from: classes.dex */
public class g extends FakeActivity {
    private IWBAPI a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f235d;

    /* renamed from: e  reason: collision with root package name */
    private AuthorizeListener f236e;

    public g(String str, String str2, String str3, AuthorizeListener authorizeListener) {
        this.b = str;
        this.c = str2;
        this.f235d = str3;
        this.f236e = authorizeListener;
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        super.onCreate();
        SSDKLog.b().w("SinaWeiboWebAuthOfficial onCreate ");
        try {
            LinearLayout linearLayout = new LinearLayout(this.activity);
            linearLayout.setOrientation(1);
            this.activity.setContentView(linearLayout);
        } catch (Exception e2) {
            SSDKLog.b().d(e2);
            NLog b = SSDKLog.b();
            b.w("SinaWeiboOfficialAuth onCreate exception " + e2.getMessage());
        }
        try {
            AuthInfo authInfo = new AuthInfo(this.activity, this.b, this.c, this.f235d);
            IWBAPI createWBAPI = WBAPIFactory.createWBAPI(this.activity);
            this.a = createWBAPI;
            createWBAPI.registerApp(this.activity, authInfo);
        } catch (Throwable th) {
            NLog b2 = SSDKLog.b();
            b2.d("SinaWeiboWebAuthOfficial", "onCreate AuthInfo " + th);
            AuthorizeListener authorizeListener = this.f236e;
            if (authorizeListener != null && authorizeListener != null) {
                authorizeListener.onError(new Throwable("SinaWeibo SDK init failed"));
            }
            finish();
        }
        try {
            a();
            SSDKLog.b().w("SinaWeiboWebAuthOfficial onCreate loginManager() ");
        } catch (Throwable th2) {
            if (this.f236e != null) {
                this.f236e.onError(new Throwable("Authorize catch: " + th2));
            }
            NLog b3 = SSDKLog.b();
            b3.w("SinaWeiboWebAuthOfficial onCreate catch: " + th2);
            finish();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        super.onDestroy();
        SSDKLog.b().w("SinaWeiboWebAuthOfficial onDestroy");
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        super.onPause();
        SSDKLog.b().w("SinaWeiboWebAuthOfficial onPause");
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        super.onResume();
        SSDKLog.b().w("SinaWeiboWebAuthOfficial onResume");
    }

    @Override // com.mob.tools.FakeActivity
    public void onStop() {
        super.onStop();
        SSDKLog.b().w("SinaWeiboWebAuthOfficial onStop");
    }

    private void a() {
        SSDKLog.b().w("SinaWeiboWebAuthOfficial onCreate ");
        IWBAPI iwbapi = this.a;
        if (iwbapi != null) {
            iwbapi.authorizeWeb(new WbAuthListener() { // from class: cn.sharesdk.sina.weibo.g.1
                @Override // com.sina.weibo.sdk.auth.WbAuthListener
                public void onCancel() {
                    g.this.f236e.onCancel();
                    g.this.finish();
                }

                @Override // com.sina.weibo.sdk.auth.WbAuthListener
                public void onComplete(Oauth2AccessToken oauth2AccessToken) {
                    Bundle bundle = new Bundle();
                    bundle.putString("access_token", oauth2AccessToken.getAccessToken());
                    bundle.putString("expires_in", String.valueOf(oauth2AccessToken.getExpiresTime()));
                    bundle.putString("refresh_token", oauth2AccessToken.getRefreshToken());
                    bundle.putString("username", oauth2AccessToken.getScreenName());
                    bundle.putString("uid", oauth2AccessToken.getUid());
                    g.this.f236e.onComplete(bundle);
                    g.this.finish();
                }

                @Override // com.sina.weibo.sdk.auth.WbAuthListener
                public void onError(UiError uiError) {
                    g.this.f236e.onError(new Throwable("errorCode: " + uiError.errorCode + " errorMessage: " + uiError.errorMessage + " errorDetail: " + uiError.errorDetail));
                    g.this.finish();
                }
            });
            return;
        }
        AuthorizeListener authorizeListener = this.f236e;
        if (authorizeListener != null) {
            authorizeListener.onError(new Throwable("SinaWeibo SDK init failed"));
        }
        finish();
    }
}
