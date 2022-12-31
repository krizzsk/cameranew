package cn.sharesdk.facebook;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.mob.MobSDK;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* compiled from: FbHelper.java */
/* loaded from: classes.dex */
public class h extends cn.sharesdk.framework.e {
    private static final String[] b = {NotificationCompat.CATEGORY_EMAIL, "public_profile"};
    private static h c;

    /* renamed from: d  reason: collision with root package name */
    private String f52d;

    /* renamed from: e  reason: collision with root package name */
    private String f53e;

    /* renamed from: f  reason: collision with root package name */
    private long f54f;

    /* renamed from: g  reason: collision with root package name */
    private String f55g;

    /* renamed from: h  reason: collision with root package name */
    private cn.sharesdk.framework.a.b f56h;

    /* renamed from: i  reason: collision with root package name */
    private String[] f57i;

    /* renamed from: j  reason: collision with root package name */
    private String f58j;

    private h(Platform platform) {
        super(platform);
        this.f56h = cn.sharesdk.framework.a.b.a();
    }

    public boolean b() {
        Intent intent = new Intent();
        intent.setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth");
        intent.putExtra("client_id", this.f55g);
        String[] strArr = this.f57i;
        if (strArr != null && strArr.length > 0) {
            intent.putExtra("scope", TextUtils.join(",", strArr));
        }
        ResolveInfo resolveActivity = MobSDK.getContext().getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity == null) {
            return false;
        }
        try {
            for (Signature signature : MobSDK.getContext().getPackageManager().getPackageInfo(resolveActivity.activityInfo.packageName, 64).signatures) {
                if ("30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2".equals(signature.toCharsString())) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getAuthorizeUrl() {
        Bundle bundle = new Bundle();
        bundle.putString(TapjoyConstants.TJC_APP_ID, this.f55g);
        bundle.putString("client_id", this.f55g);
        bundle.putString("auth_type", "rerequest");
        bundle.putString("default_audience", "friends");
        bundle.putString("display", "touch");
        bundle.putString("fbapp_pres", "1");
        bundle.putString(ParamKeyConstants.WebViewConstants.QUERY_REDIRECT_URI, this.f58j);
        bundle.putString(ParamKeyConstants.WebViewConstants.QUERY_RESPONSE_TYPE, "token,signed_request");
        bundle.putString("return_scopes", "true");
        bundle.putString("sdk", TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE);
        bundle.putString("sdk_version", "5.4.0");
        bundle.putString("state", "{\"challenge\":\"G/I5SknMfRmyvIr/q5bFJNwIqI8=\"}");
        bundle.putString("title", "Log In");
        bundle.putString("type", "user_agent");
        String[] strArr = this.f57i;
        if (strArr == null) {
            strArr = b;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (String str : strArr) {
            if (i2 > 0) {
                sb.append(',');
            }
            sb.append(str);
            i2++;
        }
        this.f52d = "https://m.facebook.com/v4.0/dialog/oauth?" + ResHelper.encodeUrl(bundle);
        ShareSDK.logApiEvent("/dialog/oauth", c());
        SSDKLog.b().w("FbHelper===> " + this.f52d);
        return this.f52d;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public cn.sharesdk.framework.authorize.c getAuthorizeWebviewClient(cn.sharesdk.framework.authorize.g gVar) {
        return new g(gVar);
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getRedirectUri() {
        return this.f58j;
    }

    @Override // cn.sharesdk.framework.e, cn.sharesdk.framework.authorize.AuthorizeHelper
    public cn.sharesdk.framework.authorize.e getSSOProcessor(cn.sharesdk.framework.authorize.d dVar) {
        f fVar = new f(dVar);
        fVar.a(32525);
        String str = this.f55g;
        String[] strArr = this.f57i;
        if (strArr == null) {
            strArr = b;
        }
        fVar.a(str, strArr);
        return fVar;
    }

    public static h a(Platform platform) {
        if (c == null) {
            c = new h(platform);
        }
        return c;
    }

    public void a(String str) {
        this.f55g = str;
    }

    public void a(String str, String str2) {
        this.f53e = str;
        if (str2 == null || str2.equals("0")) {
            return;
        }
        try {
            this.f54f = System.currentTimeMillis() + (Long.valueOf(str2).longValue() * 1000);
        } catch (Throwable th) {
            SSDKLog.b().d(th);
        }
    }

    public boolean a() {
        return this.f53e != null && (this.f54f == 0 || System.currentTimeMillis() < this.f54f);
    }

    public void a(String[] strArr) {
        this.f57i = strArr;
    }

    public void b(String str) {
        this.f58j = str;
    }

    public void a(final AuthorizeListener authorizeListener, boolean z) {
        if (z) {
            b(authorizeListener);
        } else {
            a(new SSOListener() { // from class: cn.sharesdk.facebook.h.1
                @Override // cn.sharesdk.framework.authorize.SSOListener
                public void onCancel() {
                    authorizeListener.onCancel();
                }

                @Override // cn.sharesdk.framework.authorize.SSOListener
                public void onComplete(Bundle bundle) {
                    authorizeListener.onComplete(bundle);
                }

                @Override // cn.sharesdk.framework.authorize.SSOListener
                public void onFailed(Throwable th) {
                    SSDKLog.b().d(th);
                    h.this.b(authorizeListener);
                }
            });
        }
    }

    public void a(Platform.ShareParams shareParams, PlatformActionListener platformActionListener) throws Throwable {
        String imageUrl = shareParams.getImageUrl();
        String title = shareParams.getTitle();
        String text = shareParams.getText();
        String musicUrl = shareParams.getMusicUrl();
        String url = shareParams.getUrl();
        String titleUrl = shareParams.getTitleUrl();
        if (!TextUtils.isEmpty(titleUrl)) {
            titleUrl = this.a.getShortLintk(titleUrl, false);
            shareParams.setTitleUrl(titleUrl);
        } else if (!TextUtils.isEmpty(url)) {
            titleUrl = this.a.getShortLintk(url, false);
            shareParams.setUrl(titleUrl);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("https://www.facebook.com/dialog/feed?");
        sb.append("app_id=");
        sb.append(this.f55g);
        sb.append("&redirect_uri=fbconnect://success");
        sb.append("&link=");
        sb.append(Data.urlEncode(titleUrl, "utf-8"));
        if (!TextUtils.isEmpty(shareParams.getQuote())) {
            sb.append("&quote=");
            sb.append(Data.urlEncode(shareParams.getQuote(), "utf-8"));
        }
        if (!TextUtils.isEmpty(imageUrl)) {
            sb.append("&picture=");
            sb.append(Data.urlEncode(imageUrl, "utf-8"));
        }
        if (!TextUtils.isEmpty(title)) {
            sb.append("&caption=");
            sb.append(Data.urlEncode(title, "utf-8"));
        }
        if (!TextUtils.isEmpty(text)) {
            sb.append("&description=");
            sb.append(Data.urlEncode(text, "utf-8"));
        }
        if (!TextUtils.isEmpty(musicUrl)) {
            sb.append("&source=");
            sb.append(Data.urlEncode(musicUrl, "utf-8"));
            if (!TextUtils.isEmpty(text)) {
                sb.append("&name=");
                sb.append(Data.urlEncode(text, "utf-8"));
            }
        }
        k kVar = new k();
        kVar.a(sb.toString());
        kVar.a(platformActionListener);
        kVar.show(MobSDK.getContext(), null);
    }

    public HashMap<String, Object> a(String str, Boolean bool) throws Throwable {
        String str2;
        if (str != null) {
            str2 = "/" + str;
        } else {
            str2 = "/me";
        }
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("access_token", this.f53e));
        arrayList.add(new KVPair<>(IjkMediaMeta.IJKM_KEY_FORMAT, "json"));
        if (bool.booleanValue()) {
            arrayList.add(new KVPair<>("fields", "id,name,first_name,middle_name,last_name,gender,locale,link,age_range,birthday,currency,email,picture.type(large)"));
        } else {
            arrayList.add(new KVPair<>("fields", "id,name,first_name,middle_name,last_name,gender,locale,languages,link,age_range,third_party_id,installed,timezone,updated_time,verified,birthday,currency,devices,education,email,hometown,interested_in,location,political,payment_pricepoints,favorite_athletes,favorite_teams,picture.type(large),quotes,relationship_status,religion,significant_other,video_upload_limits,website,work"));
        }
        String a = this.f56h.a("https://graph.facebook.com/v7.0" + str2, arrayList, "get_user_info", c());
        SSDKLog.b().i("facebook helper getUser", new Object[0]);
        if (a == null || a.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(a);
    }

    public HashMap<String, Object> a(int i2, int i3, String str) throws Throwable {
        String str2 = str != null ? str : "me";
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("access_token", this.f53e));
        arrayList.add(new KVPair<>(IjkMediaMeta.IJKM_KEY_FORMAT, "json"));
        arrayList.add(new KVPair<>("limit", String.valueOf(i2)));
        arrayList.add(new KVPair<>("offset", String.valueOf(i3)));
        arrayList.add(new KVPair<>("fields", "id,name,first_name,middle_name,last_name,gender,locale,languages,link,age_range,third_party_id,installed,timezone,updated_time,verified,birthday,cover,currency,devices,education,email,hometown,interested_in,location,political,payment_pricepoints,favorite_athletes,favorite_teams,picture,quotes,relationship_status,religion,significant_other,video_upload_limits,website,work"));
        String str3 = !TextUtils.isEmpty(str) ? "/taggable_friends" : "/friends";
        String a = this.f56h.a("https://graph.facebook.com/v7.0/" + str2 + str3, arrayList, "friends", c());
        if (a == null || a.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HashMap<String, Object> a(String str, String str2, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) throws Throwable {
        KVPair kVPair;
        String httpPost;
        if (str2 == null) {
            return null;
        }
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                arrayList.add(new KVPair<>(entry.getKey(), String.valueOf(entry.getValue())));
            }
        }
        arrayList.add(new KVPair<>("access_token", this.f53e));
        arrayList.add(new KVPair<>(IjkMediaMeta.IJKM_KEY_FORMAT, "json"));
        if (hashMap2 == null || hashMap2.size() <= 0) {
            kVPair = null;
        } else {
            KVPair kVPair2 = null;
            for (Map.Entry<String, String> entry2 : hashMap2.entrySet()) {
                kVPair2 = new KVPair(entry2.getKey(), entry2.getValue());
            }
            kVPair = kVPair2;
        }
        if ("GET".equals(str2.toUpperCase())) {
            httpPost = this.f56h.httpGet(str, arrayList, null, null);
        } else {
            httpPost = "POST".equals(str2.toUpperCase()) ? this.f56h.httpPost(str, arrayList, kVPair, (ArrayList<KVPair<String>>) null, (NetworkHelper.NetworkTimeOut) null) : null;
        }
        if (httpPost == null || httpPost.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(httpPost);
    }

    public void a(PlatformActionListener platformActionListener, Platform.ShareParams shareParams) {
        SSDKLog.b().d("Facebook share by primordial appClientShare", new Object[0]);
        Intent intent = new Intent();
        intent.putExtra("TITLE", shareParams.getTitle());
        j jVar = new j();
        jVar.a(platformActionListener, this.a, shareParams, this.f55g);
        jVar.show(MobSDK.getContext(), intent);
    }
}
