package cn.sharesdk.sina.weibo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.WBAPIFactory;
/* compiled from: SinaWeiboOfficialAuth.java */
/* loaded from: classes.dex */
public class d extends FakeActivity {
    private IWBAPI a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f226d;

    /* renamed from: e  reason: collision with root package name */
    private AuthorizeListener f227e;

    public d(String str, String str2, String str3, AuthorizeListener authorizeListener) {
        this.b = str;
        this.c = str2;
        this.f226d = str3;
        this.f227e = authorizeListener;
    }

    @Override // com.mob.tools.FakeActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.a.authorizeCallback(i2, i3, intent);
        super.onActivityResult(i2, i3, intent);
        SSDKLog.b().w("SinaWeiboOfficialAuth onActivityResult");
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        SSDKLog.b().w("SinaWeiboOfficialAuth onCreate ");
        try {
            LinearLayout linearLayout = new LinearLayout(this.activity);
            linearLayout.setOrientation(1);
            this.activity.setContentView(linearLayout);
        } catch (Exception e2) {
            SSDKLog.b().d(e2);
            NLog b = SSDKLog.b();
            b.w("SinaWeiboOfficialAuth onCreate exception " + e2.getMessage());
            AuthorizeListener authorizeListener = this.f227e;
            if (authorizeListener != null && authorizeListener != null) {
                authorizeListener.onError(new Throwable("SinaWeibo SDK init failed"));
            }
            finish();
        }
        try {
            AuthInfo authInfo = new AuthInfo(this.activity, this.b, this.c, this.f226d);
            IWBAPI createWBAPI = WBAPIFactory.createWBAPI(this.activity);
            this.a = createWBAPI;
            createWBAPI.registerApp(this.activity, authInfo);
        } catch (Throwable th) {
            NLog b2 = SSDKLog.b();
            b2.d("SinaWeiboOfficialAuth", "onCreate AuthInfo " + th);
        }
        try {
            a();
            SSDKLog.b().w("SinaWeiboOfficialAuth onCreate loginManager() ");
        } catch (Throwable th2) {
            if (this.f227e != null) {
                this.f227e.onError(new Throwable("Authorize catch: " + th2));
            }
            NLog b3 = SSDKLog.b();
            b3.w("SinaWeiboOfficialAuth onCreate catch: " + th2);
            finish();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        super.onDestroy();
        SSDKLog.b().w("SinaWeiboOfficialAuth onDestroy");
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        super.onPause();
        SSDKLog.b().w("SinaWeiboOfficialAuth onPause");
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        super.onResume();
        SSDKLog.b().w("SinaWeiboOfficialAuth onResume");
    }

    @Override // com.mob.tools.FakeActivity
    public void onStop() {
        super.onStop();
        SSDKLog.b().w("SinaWeiboOfficialAuth onStop");
    }

    private void a() {
        SSDKLog.b().w("SinaWeiboOfficialAuth loginManager");
        IWBAPI iwbapi = this.a;
        if (iwbapi != null) {
            iwbapi.authorizeClient(new WbAuthListener() { // from class: cn.sharesdk.sina.weibo.d.1
                @Override // com.sina.weibo.sdk.auth.WbAuthListener
                public void onCancel() {
                    b.a().a(1);
                    d.this.f227e.onCancel();
                    d.this.finish();
                }

                @Override // com.sina.weibo.sdk.auth.WbAuthListener
                public void onComplete(Oauth2AccessToken oauth2AccessToken) {
                    b.a().a(1);
                    Bundle bundle = new Bundle();
                    bundle.putString("access_token", oauth2AccessToken.getAccessToken());
                    bundle.putString("expires_in", String.valueOf(oauth2AccessToken.getExpiresTime()));
                    bundle.putString("refresh_token", oauth2AccessToken.getRefreshToken());
                    bundle.putString("username", oauth2AccessToken.getScreenName());
                    bundle.putString("uid", oauth2AccessToken.getUid());
                    d.this.f227e.onComplete(bundle);
                    d.this.finish();
                }

                @Override // com.sina.weibo.sdk.auth.WbAuthListener
                public void onError(UiError uiError) {
                    d dVar = d.this;
                    dVar.a(dVar.f227e);
                    d.this.finish();
                }
            });
            return;
        }
        AuthorizeListener authorizeListener = this.f227e;
        if (authorizeListener != null) {
            authorizeListener.onError(new Throwable("SinaWeibo SDK init failed"));
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AuthorizeListener authorizeListener) {
        new g(this.b, this.c, this.f226d, authorizeListener).show(MobSDK.getContext(), null);
        SSDKLog.b().w("SinaWeibo SDK Web showWebAuthActivity ");
    }
}
