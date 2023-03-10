package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.f;
import com.tencent.open.utils.g;
import com.tencent.open.utils.h;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public class SocialApiIml extends BaseApi {
    private Activity a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public class a extends DefaultUiListener {
        private IUiListener a;
        private String b;
        private String c;

        /* renamed from: d  reason: collision with root package name */
        private Bundle f8142d;

        /* renamed from: e  reason: collision with root package name */
        private Activity f8143e;

        a(Activity activity, IUiListener iUiListener, String str, String str2, Bundle bundle) {
            this.a = iUiListener;
            this.b = str;
            this.c = str2;
            this.f8142d = bundle;
            this.f8143e = activity;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            this.a.onCancel();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            String str;
            try {
                str = ((JSONObject) obj).getString(SocialConstants.PARAM_ENCRY_EOKEN);
            } catch (JSONException e2) {
                e2.printStackTrace();
                SLog.e("openSDK_LOG.SocialApiIml", "OpenApi, EncrytokenListener() onComplete error", e2);
                str = null;
            }
            this.f8142d.putString("encrytoken", str);
            SocialApiIml socialApiIml = SocialApiIml.this;
            socialApiIml.a((Context) socialApiIml.a, this.b, this.f8142d, this.c, this.a);
            if (TextUtils.isEmpty(str)) {
                SLog.d("openSDK_LOG.SocialApiIml", "The token get from qq or qzone is empty. Write temp token to localstorage.");
                SocialApiIml.this.writeEncryToken(this.f8143e);
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            SLog.d("openSDK_LOG.SocialApiIml", "OpenApi, EncryptTokenListener() onError" + uiError.errorMessage);
            this.a.onError(uiError);
        }
    }

    public SocialApiIml(QQToken qQToken) {
        super(qQToken);
    }

    public void ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        a(activity, SocialConstants.ACTION_ASK, bundle, iUiListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.connect.common.BaseApi
    public Intent b(String str) {
        Intent intent = new Intent();
        intent.setClassName(Constants.PACKAGE_QZONE, str);
        Intent intent2 = new Intent();
        intent2.setClassName("com.tencent.mobileqq", str);
        Intent intent3 = new Intent();
        intent3.setClassName(Constants.PACKAGE_QQ_PAD, str);
        if (l.c(f.a()) && i.a(f.a(), intent3)) {
            return intent3;
        }
        if (!i.a(f.a(), intent2) || i.c(f.a(), "4.7") < 0) {
            if (i.a(f.a(), intent) && i.a(i.a(f.a(), Constants.PACKAGE_QZONE), "4.2") >= 0 && i.a(f.a(), intent.getComponent().getPackageName(), Constants.SIGNATRUE_QZONE)) {
                return intent;
            }
            return null;
        }
        return intent2;
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        a(activity, SocialConstants.ACTION_GIFT, bundle, iUiListener);
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.a = activity;
        Intent c = c(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        if (c == null) {
            SLog.i("openSDK_LOG.SocialApiIml", "--invite--friend chooser not found");
            c = c(SocialConstants.ACTIVITY_INVITE);
        }
        bundle.putAll(b());
        a(activity, c, SocialConstants.ACTION_INVITE, bundle, h.a().a(f.a(), "https://login.imgcache.qq.com/open/mobile/invite/sdk_invite.html?"), iUiListener, false);
    }

    public void story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.a = activity;
        Intent c = c(SocialConstants.ACTIVITY_STORY);
        bundle.putAll(b());
        a(activity, c, SocialConstants.ACTION_STORY, bundle, h.a().a(f.a(), "https://login.imgcache.qq.com/open/mobile/sendstory/sdk_sendstory_v1.3.html?"), iUiListener, false);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void writeEncryToken(Context context) {
        String str;
        String accessToken = this.c.getAccessToken();
        String appId = this.c.getAppId();
        String openId = this.c.getOpenId();
        if (accessToken == null || accessToken.length() <= 0 || appId == null || appId.length() <= 0 || openId == null || openId.length() <= 0) {
            str = null;
        } else {
            str = l.f("tencent&sdk&qazxc***14969%%" + accessToken + appId + openId + "qzone3.4");
        }
        com.tencent.open.b.b bVar = new com.tencent.open.b.b(context);
        WebSettings settings = bVar.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setSavePassword(false);
        String str2 = "<!DOCTYPE HTML><html lang=\"en-US\"><head><meta charset=\"UTF-8\"><title>localStorage Test</title><script type=\"text/javascript\">document.domain = 'qq.com';localStorage[\"" + this.c.getOpenId() + "_" + this.c.getAppId() + "\"]=\"" + str + "\";</script></head><body></body></html>";
        String a2 = h.a().a(context, "https://login.imgcache.qq.com");
        bVar.loadDataWithBaseURL(a2, str2, "text/html", "utf-8", a2);
        VdsAgent.loadDataWithBaseURL(bVar, a2, str2, "text/html", "utf-8", a2);
    }

    public SocialApiIml(com.tencent.connect.auth.c cVar, QQToken qQToken) {
        super(cVar, qQToken);
    }

    private void a(Activity activity, String str, Bundle bundle, IUiListener iUiListener) {
        this.a = activity;
        Intent c = c(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        if (c == null) {
            SLog.i("openSDK_LOG.SocialApiIml", "--askgift--friend chooser not found");
            c = c(SocialConstants.ACTIVITY_ASK_GIFT);
        }
        Intent intent = c;
        bundle.putAll(b());
        if (SocialConstants.ACTION_ASK.equals(str)) {
            bundle.putString("type", SocialConstants.TYPE_REQUEST);
        } else if (SocialConstants.ACTION_GIFT.equals(str)) {
            bundle.putString("type", SocialConstants.TYPE_FREEGIFT);
        }
        a(activity, intent, str, bundle, h.a().a(f.a(), "https://login.imgcache.qq.com/open/mobile/request/sdk_request.html?"), iUiListener, false);
    }

    private void a(Activity activity, Intent intent, String str, Bundle bundle, String str2, IUiListener iUiListener, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("-->handleIntent action = ");
        sb.append(str);
        sb.append(", activityIntent = null ? ");
        boolean z2 = true;
        sb.append(intent == null);
        SLog.i("openSDK_LOG.SocialApiIml", sb.toString());
        if (intent != null) {
            a(activity, intent, str, bundle, iUiListener);
            return;
        }
        g a2 = g.a(f.a(), this.c.getAppId());
        if (!z && !a2.b("C_LoginH5")) {
            z2 = false;
        }
        if (z2) {
            a(activity, str, bundle, str2, iUiListener);
        } else {
            a(activity, bundle, iUiListener);
        }
    }

    private void a(Activity activity, Intent intent, String str, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithAgent action = " + str);
        intent.putExtra(Constants.KEY_ACTION, str);
        intent.putExtra(Constants.KEY_PARAMS, bundle);
        UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_SOCIAL_API, iUiListener);
        a(activity, intent, Constants.REQUEST_SOCIAL_API);
    }

    private void a(Activity activity, String str, Bundle bundle, String str2, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5 action = " + str);
        Intent b = b("com.tencent.open.agent.AgentActivity");
        IUiListener aVar = new a(activity, iUiListener, str, str2, bundle);
        Intent b2 = b("com.tencent.open.agent.EncryTokenActivity");
        if (b2 != null && b != null && b.getComponent() != null && b2.getComponent() != null && b.getComponent().getPackageName().equals(b2.getComponent().getPackageName())) {
            b2.putExtra("oauth_consumer_key", this.c.getAppId());
            b2.putExtra("openid", this.c.getOpenId());
            b2.putExtra("access_token", this.c.getAccessToken());
            b2.putExtra(Constants.KEY_ACTION, SocialConstants.ACTION_CHECK_TOKEN);
            if (a(b2)) {
                SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--found token activity");
                UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_SOCIAL_H5, aVar);
                a(activity, b2, Constants.REQUEST_SOCIAL_H5);
                return;
            }
            return;
        }
        SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--token activity not found");
        String f2 = l.f("tencent&sdk&qazxc***14969%%" + this.c.getAccessToken() + this.c.getAppId() + this.c.getOpenId() + "qzone3.4");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SocialConstants.PARAM_ENCRY_EOKEN, f2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aVar.onComplete(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, Bundle bundle, String str2, IUiListener iUiListener) {
        SLog.v("openSDK_LOG.SocialApiIml", "OpenUi, showDialog --start");
        CookieSyncManager.createInstance(context);
        bundle.putString("oauth_consumer_key", this.c.getAppId());
        if (this.c.isSessionValid()) {
            bundle.putString("access_token", this.c.getAccessToken());
        }
        String openId = this.c.getOpenId();
        if (openId != null) {
            bundle.putString("openid", openId);
        }
        try {
            bundle.putString(Constants.PARAM_PLATFORM_ID, f.a().getSharedPreferences(Constants.PREFERENCE_PF, 0).getString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF));
        } catch (Exception e2) {
            e2.printStackTrace();
            bundle.putString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF);
        }
        String str3 = str2 + HttpUtils.encodeUrl(bundle);
        SLog.d("openSDK_LOG.SocialApiIml", "OpenUi, showDialog TDialog");
        if (!SocialConstants.ACTION_CHALLENGE.equals(str) && !SocialConstants.ACTION_BRAG.equals(str)) {
            TDialog tDialog = new TDialog(this.a, str, str3, iUiListener, this.c);
            tDialog.show();
            VdsAgent.showDialog(tDialog);
            return;
        }
        SLog.d("openSDK_LOG.SocialApiIml", "OpenUi, showDialog PKDialog");
        c cVar = new c(this.a, str, str3, iUiListener, this.c);
        cVar.show();
        VdsAgent.showDialog(cVar);
    }
}
