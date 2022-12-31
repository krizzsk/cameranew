package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.tencent.open.SocialOperation;
import java.util.ArrayList;
import java.util.HashMap;
import us.pinguo.bigalbum.db.BigAlbumStore;
/* compiled from: WXAuthHelper.java */
/* loaded from: classes.dex */
public class h {
    private String a;
    private String b;
    private cn.sharesdk.framework.a.b c = cn.sharesdk.framework.a.b.a();

    /* renamed from: d  reason: collision with root package name */
    private Platform f313d;

    /* renamed from: e  reason: collision with root package name */
    private int f314e;

    public h(Platform platform, int i2) {
        this.f313d = platform;
        this.f314e = i2;
    }

    public void a(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public void a(Bundle bundle, AuthorizeListener authorizeListener) {
        String string = bundle.getString("_wxapi_sendauth_resp_url");
        if (TextUtils.isEmpty(string)) {
            if (authorizeListener != null) {
                authorizeListener.onError(null);
                return;
            }
            return;
        }
        int indexOf = string.indexOf("://oauth?");
        if (indexOf >= 0) {
            string = string.substring(indexOf + 1);
        }
        try {
            a(ResHelper.urlToBundle(string).getString("code"), authorizeListener);
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            if (authorizeListener != null) {
                authorizeListener.onError(th);
            }
        }
    }

    private void a(final String str, final AuthorizeListener authorizeListener) throws Throwable {
        NLog b = SSDKLog.b();
        b.d("getAuthorizeToken ==>> " + str, new Object[0]);
        new Thread() { // from class: cn.sharesdk.wechat.utils.h.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    ArrayList<KVPair<String>> arrayList = new ArrayList<>();
                    arrayList.add(new KVPair<>("appid", h.this.a));
                    arrayList.add(new KVPair<>("secret", h.this.b));
                    arrayList.add(new KVPair<>("code", str));
                    arrayList.add(new KVPair<>("grant_type", "authorization_code"));
                    String a = h.this.c.a("https://api.weixin.qq.com/sns/oauth2/access_token", arrayList, "/sns/oauth2/access_token", h.this.f314e);
                    if (TextUtils.isEmpty(a)) {
                        authorizeListener.onError(new Throwable("Authorize token is empty"));
                    } else if (!a.contains("errcode")) {
                        h.this.a(a);
                        authorizeListener.onComplete(null);
                    } else {
                        AuthorizeListener authorizeListener2 = authorizeListener;
                        if (authorizeListener2 != null) {
                            authorizeListener2.onError(new Throwable(a));
                        }
                    }
                } catch (Throwable th) {
                    SSDKLog.b().d(th);
                }
            }
        }.start();
    }

    public boolean a() {
        String str = this.f313d.getDb().get("refresh_token");
        if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(str)) {
            ArrayList<KVPair<String>> arrayList = new ArrayList<>();
            arrayList.add(new KVPair<>("appid", this.a));
            arrayList.add(new KVPair<>("refresh_token", str));
            arrayList.add(new KVPair<>("grant_type", "refresh_token"));
            try {
                String a = this.c.a("https://api.weixin.qq.com/sns/oauth2/refresh_token", arrayList, "/sns/oauth2/refresh_token", this.f314e);
                if (TextUtils.isEmpty(a) || a.contains("errcode")) {
                    return false;
                }
                a(a);
                return true;
            } catch (Throwable th) {
                SSDKLog.b().d(th);
            }
        }
        return false;
    }

    public void a(final PlatformActionListener platformActionListener) throws Throwable {
        new Thread() { // from class: cn.sharesdk.wechat.utils.h.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                HashMap<String, Object> hashMap;
                try {
                    ArrayList<KVPair<String>> arrayList = new ArrayList<>();
                    arrayList.add(new KVPair<>("access_token", h.this.f313d.getDb().getToken()));
                    arrayList.add(new KVPair<>("openid", h.this.f313d.getDb().get("openid")));
                    arrayList.add(new KVPair<>("lang", "zh_CN"));
                    String a = h.this.c.a("https://api.weixin.qq.com/sns/userinfo", arrayList, "/sns/userinfo", h.this.f314e);
                    if (TextUtils.isEmpty(a)) {
                        PlatformActionListener platformActionListener2 = platformActionListener;
                        if (platformActionListener2 != null) {
                            platformActionListener2.onError(h.this.f313d, 8, new Throwable());
                            return;
                        }
                        return;
                    }
                    NLog b = SSDKLog.b();
                    b.d("getUserInfo ==>>" + a, new Object[0]);
                    HashMap<String, Object> fromJson = new Hashon().fromJson(a);
                    if (fromJson.containsKey("errcode") && ((Integer) fromJson.get("errcode")).intValue() != 0) {
                        if (platformActionListener != null) {
                            platformActionListener.onError(h.this.f313d, 8, new Throwable(new Hashon().fromHashMap(fromJson)));
                            return;
                        }
                        return;
                    }
                    String valueOf = String.valueOf(fromJson.get("openid"));
                    String valueOf2 = String.valueOf(fromJson.get("nickname"));
                    int parseInt = ResHelper.parseInt(String.valueOf(fromJson.get("sex")));
                    String valueOf3 = String.valueOf(fromJson.get(BigAlbumStore.PhotoAddressColumns.PROVINCE));
                    String valueOf4 = String.valueOf(fromJson.get(BigAlbumStore.PhotoAddressColumns.CITY));
                    String valueOf5 = String.valueOf(fromJson.get(BigAlbumStore.PhotoAddressColumns.COUNTRY));
                    String valueOf6 = String.valueOf(fromJson.get("headimgurl"));
                    String valueOf7 = String.valueOf(fromJson.get(SocialOperation.GAME_UNION_ID));
                    h.this.f313d.getDb().put("nickname", valueOf2);
                    if (parseInt == 1) {
                        h.this.f313d.getDb().put("gender", "0");
                    } else if (parseInt == 2) {
                        h.this.f313d.getDb().put("gender", "1");
                    } else {
                        h.this.f313d.getDb().put("gender", "2");
                    }
                    h.this.f313d.getDb().putUserId(valueOf);
                    h.this.f313d.getDb().put("icon", valueOf6);
                    h.this.f313d.getDb().put(BigAlbumStore.PhotoAddressColumns.PROVINCE, valueOf3);
                    h.this.f313d.getDb().put(BigAlbumStore.PhotoAddressColumns.CITY, valueOf4);
                    h.this.f313d.getDb().put(BigAlbumStore.PhotoAddressColumns.COUNTRY, valueOf5);
                    h.this.f313d.getDb().put("openid", valueOf);
                    h.this.f313d.getDb().put(SocialOperation.GAME_UNION_ID, valueOf7);
                    if (h.this.f313d.getDb().get("userTags") != null) {
                        hashMap = fromJson;
                        hashMap.put("userTags", h.this.f313d.getDb().get("userTags"));
                    } else {
                        hashMap = fromJson;
                    }
                    platformActionListener.onComplete(h.this.f313d, 8, hashMap);
                } catch (Throwable th) {
                    SSDKLog.b().d(th);
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        NLog b = SSDKLog.b();
        b.d("wechat getAuthorizeToken ==>>" + str, new Object[0]);
        HashMap fromJson = new Hashon().fromJson(str);
        String valueOf = String.valueOf(fromJson.get("access_token"));
        String valueOf2 = String.valueOf(fromJson.get("refresh_token"));
        String valueOf3 = String.valueOf(fromJson.get("expires_in"));
        this.f313d.getDb().put("openid", String.valueOf(fromJson.get("openid")));
        this.f313d.getDb().putExpiresIn(Long.valueOf(valueOf3).longValue());
        this.f313d.getDb().putToken(valueOf);
        this.f313d.getDb().put("refresh_token", valueOf2);
    }
}
