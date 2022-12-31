package cn.sharesdk.douyin;

import android.os.Bundle;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.AuthorizeHelper;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.authorize.d;
import cn.sharesdk.framework.authorize.e;
import cn.sharesdk.framework.authorize.g;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.common.model.BaseResp;
import com.bytedance.sdk.open.aweme.share.Share;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.HashMap;
/* compiled from: DouyinImpl.java */
/* loaded from: classes.dex */
public class c implements AuthorizeHelper {
    private static volatile c a;
    private b b;
    private Platform c;

    /* renamed from: d  reason: collision with root package name */
    private AuthorizeListener f30d;

    /* renamed from: e  reason: collision with root package name */
    private PlatformActionListener f31e;

    /* renamed from: f  reason: collision with root package name */
    private Platform.ShareParams f32f;

    /* renamed from: g  reason: collision with root package name */
    private String f33g = "com.ss.android.ugc.aweme";

    /* renamed from: h  reason: collision with root package name */
    private DouYinOpenApi f34h;

    /* renamed from: i  reason: collision with root package name */
    private cn.sharesdk.framework.a.b f35i;

    /* renamed from: j  reason: collision with root package name */
    private String f36j;

    /* renamed from: k  reason: collision with root package name */
    private String f37k;

    /* renamed from: l  reason: collision with root package name */
    private String f38l;

    private c() {
        cn.sharesdk.framework.a.b a2 = cn.sharesdk.framework.a.b.a();
        this.f35i = a2;
        a(a2);
    }

    public String d() {
        return this.f37k;
    }

    protected int e() {
        return 59;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public AuthorizeListener getAuthorizeListener() {
        return this.f30d;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getAuthorizeUrl() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair(ParamKeyConstants.WebViewConstants.QUERY_RESPONSE_TYPE, "code"));
        arrayList.add(new KVPair("scope", "user_info"));
        arrayList.add(new KVPair("from", ParamKeyConstants.WebViewConstants.VALUE_FROM_OPENSDK));
        arrayList.add(new KVPair(ParamKeyConstants.WebViewConstants.QUERY_CLIENT_KEY, c()));
        arrayList.add(new KVPair("state", "test"));
        arrayList.add(new KVPair(ParamKeyConstants.WebViewConstants.QUERY_REDIRECT_URI, "https://open.douyin.com/oauth/authorize/callback/"));
        return "https://open.douyin.com/platform/oauth/connect/?" + ResHelper.encodeUrl(arrayList);
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public cn.sharesdk.framework.authorize.c getAuthorizeWebviewClient(g gVar) {
        return new a(gVar);
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public Platform getPlatform() {
        Platform a2 = this.b.a();
        this.c = a2;
        return a2;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getRedirectUri() {
        return null;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public SSOListener getSSOListener() {
        return null;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public e getSSOProcessor(d dVar) {
        return null;
    }

    private void d(final String str) {
        new Thread() { // from class: cn.sharesdk.douyin.c.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    c cVar = c.this;
                    String a2 = cVar.a(str, cVar.f36j, c.this.f37k);
                    if (a2 == null && c.this.f30d != null) {
                        c.this.f30d.onError(new Throwable("Authorize token is empty"));
                        return;
                    }
                    HashMap fromJson = new Hashon().fromJson(a2);
                    HashMap hashMap = (HashMap) fromJson.get("data");
                    String valueOf = String.valueOf(fromJson.get("message"));
                    if (valueOf.equals(FirebaseAnalytics.Param.SUCCESS)) {
                        Bundle bundle = new Bundle();
                        bundle.putString("access_token", String.valueOf(hashMap.get("access_token")));
                        bundle.putString("expires_in", String.valueOf(hashMap.get("expires_in")));
                        bundle.putString("refresh_token", String.valueOf(hashMap.get("refresh_token")));
                        bundle.putString("open_id", String.valueOf(hashMap.get("open_id")));
                        bundle.putString("scope", String.valueOf(hashMap.get("scope")));
                        bundle.putString("error_code", String.valueOf(hashMap.get("error_code")));
                        c.this.f30d.onComplete(bundle);
                    } else if (valueOf.equals("error")) {
                        String valueOf2 = String.valueOf(hashMap.get(SocialConstants.PARAM_COMMENT));
                        String valueOf3 = String.valueOf(hashMap.get("error_code"));
                        AuthorizeListener authorizeListener = c.this.f30d;
                        authorizeListener.onError(new Throwable("error_code" + valueOf3 + " errorDesc " + valueOf2));
                    }
                }
            }
        }.start();
    }

    public void a(b bVar) {
        this.b = bVar;
    }

    public boolean b() {
        return cn.sharesdk.framework.utils.a.a(this.f33g);
    }

    public String c() {
        return this.f36j;
    }

    public void a(PlatformActionListener platformActionListener) {
        this.f31e = platformActionListener;
    }

    public void b(String str) {
        this.f37k = str;
    }

    public void c(String str) {
        this.f38l = str;
    }

    public static c a() {
        synchronized (c.class) {
            if (a == null) {
                synchronized (c.class) {
                    if (a == null) {
                        a = new c();
                    }
                }
            }
        }
        return a;
    }

    public void a(String str) {
        this.f36j = str;
    }

    public void a(cn.sharesdk.framework.a.b bVar) {
        this.f35i = bVar;
    }

    public void a(DouYinOpenApi douYinOpenApi) {
        this.f34h = douYinOpenApi;
    }

    public void a(AuthorizeListener authorizeListener, boolean z) {
        this.f30d = authorizeListener;
        if (!z && b()) {
            Authorization.Request request = new Authorization.Request();
            request.scope = "user_info";
            request.state = "ww";
            request.callerLocalEntry = "cn.sharesdk.douyin.bdopen.DouYinHandlerActivity";
            this.f34h.authorize(request);
            return;
        }
        a(authorizeListener);
    }

    public HashMap<String, Object> a(String str, String str2) throws Throwable {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("access_token", str));
        arrayList.add(new KVPair<>("open_id", str2));
        String a2 = this.f35i.a("https://open.douyin.com/oauth/userinfo/", arrayList, "/oauth/userinfo/", e());
        if (a2 != null) {
            return new Hashon().fromJson(a2);
        }
        return null;
    }

    public void a(BaseResp baseResp) {
        this.c = this.b.a();
        if (this.f31e != null) {
            if (baseResp == null) {
                this.f31e.onError(this.c, 9, new Throwable("Illegal redirection from external application."));
            } else if (baseResp.isSuccess()) {
                if (baseResp.getType() == 2) {
                    d(((Authorization.Response) baseResp).authCode);
                } else if (baseResp.getType() == 4) {
                    if (this.f32f != null) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("ShareParams", this.f32f);
                        this.f31e.onComplete(this.c, 9, hashMap);
                        return;
                    }
                    this.f31e.onComplete(this.c, 9, null);
                }
            } else if (baseResp.isCancel()) {
                this.f31e.onCancel(this.c, 9);
            } else {
                Share.Response response = (Share.Response) baseResp;
                this.f31e.onError(this.c, 9, new Throwable(" errorCode: " + response.errorCode + " subErrorCode: " + response.subErrorCode + " errorMsg: " + response.errorMsg));
            }
        }
    }

    public String a(String str, String str2, String str3) throws Throwable {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>(ParamKeyConstants.WebViewConstants.QUERY_CLIENT_KEY, str2));
        arrayList.add(new KVPair<>("client_secret", str3));
        arrayList.add(new KVPair<>("code", str));
        arrayList.add(new KVPair<>("grant_type", "authorization_code"));
        try {
            return this.f35i.b("https://open.douyin.com/oauth/access_token/", arrayList, "/oauth/access_token/", e());
        } catch (Throwable unused) {
            return null;
        }
    }

    protected void a(AuthorizeListener authorizeListener) {
        this.f30d = authorizeListener;
        g gVar = new g();
        gVar.a(this.f30d);
        gVar.a(this);
    }
}
