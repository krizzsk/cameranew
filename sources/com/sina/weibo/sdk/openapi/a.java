package com.sina.weibo.sdk.openapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.StoryMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.c.a;
import com.sina.weibo.sdk.c.b;
import com.sina.weibo.sdk.c.c;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.share.ShareStoryActivity;
import com.sina.weibo.sdk.share.ShareTransActivity;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.sina.weibo.sdk.share.f;
import com.sina.weibo.sdk.web.b.d;
/* loaded from: classes3.dex */
public final class a implements IWBAPI {
    private Context mContext;
    private com.sina.weibo.sdk.auth.a s;
    private f t;

    public a(Context context) {
        this.mContext = context;
        this.s = new com.sina.weibo.sdk.auth.a((Activity) context);
        this.t = new f((Activity) this.mContext);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorize(WbAuthListener wbAuthListener) {
        com.sina.weibo.sdk.auth.a aVar = this.s;
        c.a("WBSsoTag", "authorize()");
        if (wbAuthListener != null) {
            aVar.f7172h = wbAuthListener;
            Activity activity = aVar.f7171g.get();
            if (com.sina.weibo.sdk.a.a(activity)) {
                if (com.sina.weibo.sdk.c.a.c(activity) != null) {
                    aVar.d();
                    return;
                }
            }
            aVar.e();
            return;
        }
        throw new RuntimeException("listener can not be null.");
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorizeCallback(int i2, int i3, Intent intent) {
        com.sina.weibo.sdk.auth.a aVar = this.s;
        c.a("WBSsoTag", "authorizeCallback()");
        WbAuthListener wbAuthListener = aVar.f7172h;
        if (wbAuthListener != null) {
            if (32973 != i2) {
                wbAuthListener.onError(new UiError(-7, "request code is error", "requestCode is error"));
            } else if (i3 != -1) {
                if (i3 == 0) {
                    wbAuthListener.onCancel();
                } else {
                    wbAuthListener.onError(new UiError(-6, "result code is error", "result code is error"));
                }
            } else if (intent != null) {
                String stringExtra = intent.getStringExtra("error");
                String stringExtra2 = intent.getStringExtra("error_type");
                String stringExtra3 = intent.getStringExtra("error_description");
                if (TextUtils.isEmpty(stringExtra) && TextUtils.isEmpty(stringExtra2) && TextUtils.isEmpty(stringExtra3)) {
                    Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(intent.getExtras());
                    if (parseAccessToken != null) {
                        AccessTokenHelper.writeAccessToken(aVar.f7171g.get(), parseAccessToken);
                        aVar.f7172h.onComplete(parseAccessToken);
                        return;
                    }
                    aVar.f7172h.onError(new UiError(-4, "oauth2AccessToken is null", "oauth2AccessToken is null"));
                } else if (!"access_denied".equals(stringExtra) && !"OAuthAccessDeniedException".equals(stringExtra)) {
                    aVar.f7172h.onError(new UiError(-5, stringExtra2, stringExtra3));
                } else {
                    aVar.f7172h.onCancel();
                }
            }
        }
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorizeClient(WbAuthListener wbAuthListener) {
        com.sina.weibo.sdk.auth.a aVar = this.s;
        c.a("WBSsoTag", "authorizeClient()");
        if (wbAuthListener != null) {
            aVar.f7172h = wbAuthListener;
            aVar.d();
            return;
        }
        throw new RuntimeException("listener can not be null.");
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorizeWeb(WbAuthListener wbAuthListener) {
        com.sina.weibo.sdk.auth.a aVar = this.s;
        c.a("WBSsoTag", "authorizeWeb()");
        if (wbAuthListener != null) {
            aVar.f7172h = wbAuthListener;
            aVar.e();
            return;
        }
        throw new RuntimeException("listener can not be null.");
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void doResultIntent(Intent intent, WbShareCallback wbShareCallback) {
        Bundle extras;
        if (intent == null || wbShareCallback == null || (extras = intent.getExtras()) == null) {
            return;
        }
        try {
            int i2 = extras.getInt("_weibo_resp_errcode", -1);
            if (i2 == 0) {
                wbShareCallback.onComplete();
            } else if (i2 == 1) {
                wbShareCallback.onCancel();
            } else if (i2 != 2) {
            } else {
                wbShareCallback.onError(new UiError(i2, extras.getString("_weibo_resp_errstr"), "error from weibo client!"));
            }
        } catch (Exception e2) {
            wbShareCallback.onError(new UiError(-1, e2.getMessage(), e2.getMessage()));
        }
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final boolean isWBAppInstalled() {
        return com.sina.weibo.sdk.a.a(this.mContext);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final boolean isWBAppSupportMultipleImage() {
        return com.sina.weibo.sdk.a.b(this.mContext);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void registerApp(Context context, AuthInfo authInfo) {
        com.sina.weibo.sdk.a.a(context, authInfo);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void setLoggerEnable(boolean z) {
        c.setLoggerEnable(z);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void shareMessage(WeiboMultiMessage weiboMultiMessage, boolean z) {
        AuthInfo a;
        f fVar = this.t;
        Activity activity = fVar.f7179g.get();
        if (activity != null) {
            if (com.sina.weibo.sdk.a.a(activity) || !z) {
                if (z) {
                    fVar.b(weiboMultiMessage);
                    return;
                }
                a.C0256a c = com.sina.weibo.sdk.c.a.c(activity);
                if (com.sina.weibo.sdk.a.a(activity) && c != null) {
                    a.C0256a c2 = com.sina.weibo.sdk.c.a.c(activity);
                    if (c2 != null && c2.am > 10000) {
                        fVar.b(weiboMultiMessage);
                        return;
                    }
                }
                Activity activity2 = fVar.f7179g.get();
                if (activity2 == null || (a = com.sina.weibo.sdk.a.a()) == null) {
                    return;
                }
                d dVar = new d(a);
                dVar.setContext(activity2);
                dVar.aJ = weiboMultiMessage;
                dVar.packageName = activity2.getPackageName();
                Oauth2AccessToken readAccessToken = AccessTokenHelper.readAccessToken(activity2);
                if (readAccessToken != null) {
                    String accessToken = readAccessToken.getAccessToken();
                    if (!TextUtils.isEmpty(readAccessToken.getAccessToken())) {
                        dVar.aj = accessToken;
                    }
                }
                Bundle bundle = new Bundle();
                dVar.writeToBundle(bundle);
                Intent intent = new Intent(activity2, ShareTransActivity.class);
                intent.putExtra("start_flag", 0);
                intent.putExtra("start_web_activity", "com.sina.weibo.sdk.web.WebActivity");
                intent.putExtras(bundle);
                activity2.startActivityForResult(intent, 10001);
            }
        }
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void shareStory(StoryMessage storyMessage) {
        Activity activity = this.t.f7179g.get();
        if (activity != null) {
            Uri imageUri = storyMessage.getImageUri();
            Uri videoUri = storyMessage.getVideoUri();
            if (imageUri != null) {
                try {
                    if (!b.a(activity, imageUri)) {
                    }
                    Intent intent = new Intent();
                    intent.putExtra("_weibo_message_stroy", storyMessage);
                    intent.putExtra("start_flag", 0);
                    intent.setClass(activity, ShareStoryActivity.class);
                    activity.startActivityForResult(intent, 10001);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (videoUri == null || !b.b(activity, videoUri)) {
                throw new IllegalStateException("File only can be Image or Video. ");
            }
            Intent intent2 = new Intent();
            intent2.putExtra("_weibo_message_stroy", storyMessage);
            intent2.putExtra("start_flag", 0);
            intent2.setClass(activity, ShareStoryActivity.class);
            activity.startActivityForResult(intent2, 10001);
        }
    }
}
