package us.pinguo.inspire.module.profile;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.open.SocialConstants;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.common.network.RxVolley;
import us.pinguo.common.network.request.VolleyRequest;
import us.pinguo.inspire.api.Payload;
import us.pinguo.inspire.module.profile.entry.LocationGroup;
import us.pinguo.user.LoginConfig;
import us.pinguo.user.User;
import us.pinguo.user.y0;
/* loaded from: classes4.dex */
public class UserInfoLoader {
    private ProfileLocationResourceCache mLocationResourseCache;

    /* loaded from: classes4.dex */
    public static class TempUserInfo {
        public String avatar;
        public String backgroundPic;
        public String birthday;
        public int certificated;
        public String city;
        public String country;
        public String description;
        public String email;
        public int forgetPass;
        public String gender;
        public String language;
        public long lastLoginTime;
        public String loginmode;
        public String mobile;
        public String nickname;
        public String province;
        public long regDateTime;
        public int setPass;
        public String token;
        public String userId;
        public y0.c vipInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(String str, Context context, Subscriber subscriber) {
        InputStream open;
        try {
            subscriber.onStart();
            String object = this.mLocationResourseCache.getObject();
            if (TextUtils.isEmpty(object)) {
                us.pinguo.common.log.a.m("FK", "从内置文件中读取国家列表", new Object[0]);
                if (str.equals(InspireLocationManager.ZH_CN)) {
                    open = context.getAssets().open("zh_cn_location.json");
                } else if (str.equals(InspireLocationManager.ZH_TW)) {
                    open = context.getAssets().open("zh_tw_location.json");
                } else {
                    open = context.getAssets().open("en_us_location.json");
                }
                byte[] bArr = new byte[open.available()];
                open.read(bArr);
                open.close();
                object = new String(bArr, "UTF-8");
            }
            us.pinguo.common.log.a.k("FK", "hhhhhhhhhhhhhh");
            subscriber.onNext((List) new com.google.gson.e().k(object, new com.google.gson.t.a<List<LocationGroup>>() { // from class: us.pinguo.inspire.module.profile.UserInfoLoader.8
            }.getType()));
            subscriber.onCompleted();
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
            subscriber.onError(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ BaseResponse d(String str) {
        return (BaseResponse) new com.google.gson.e().k(str, new com.google.gson.t.a<BaseResponse<GeoResp>>() { // from class: us.pinguo.inspire.module.profile.UserInfoLoader.7
        }.getType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ BaseResponse f(String str) {
        return (BaseResponse) new com.google.gson.e().k(str, new com.google.gson.t.a<BaseResponse<TempUserInfo>>() { // from class: us.pinguo.inspire.module.profile.UserInfoLoader.2
        }.getType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ BaseResponse i(String str) {
        return (BaseResponse) new com.google.gson.e().k(str, new com.google.gson.t.a<BaseResponse<TempUserInfo>>() { // from class: us.pinguo.inspire.module.profile.UserInfoLoader.1
        }.getType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ BaseResponse l(String str) {
        return (BaseResponse) new com.google.gson.e().k(str, new com.google.gson.t.a<BaseResponse<TempUserInfo>>() { // from class: us.pinguo.inspire.module.profile.UserInfoLoader.5
        }.getType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String m(TempUserInfo tempUserInfo) {
        User.Info h2 = User.d().h();
        h2.description = tempUserInfo.description;
        us.pinguo.common.log.a.m(SocialConstants.PARAM_COMMENT, "description：" + tempUserInfo.nickname, new Object[0]);
        User.v(h2);
        return h2.description;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ BaseResponse o(String str) {
        return (BaseResponse) new com.google.gson.e().k(str, new com.google.gson.t.a<BaseResponse<TempUserInfo>>() { // from class: us.pinguo.inspire.module.profile.UserInfoLoader.4
        }.getType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String p(TempUserInfo tempUserInfo) {
        us.pinguo.common.log.a.m("gender", "gender：" + tempUserInfo.gender, new Object[0]);
        User.Info h2 = User.d().h();
        h2.gender = tempUserInfo.gender;
        User.v(h2);
        return h2.gender;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public /* synthetic */ BaseResponse r(String str) {
        return (BaseResponse) new com.google.gson.e().k(str, new com.google.gson.t.a<BaseResponse<TempUserInfo>>() { // from class: us.pinguo.inspire.module.profile.UserInfoLoader.6
        }.getType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String s(TempUserInfo tempUserInfo) {
        User.Info h2 = User.d().h();
        h2.country = tempUserInfo.country;
        h2.province = tempUserInfo.province;
        h2.city = tempUserInfo.city;
        us.pinguo.common.log.a.m(BigAlbumStore.PhotoAddressColumns.COUNTRY, "country：" + tempUserInfo.country, new Object[0]);
        User.v(h2);
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public /* synthetic */ BaseResponse u(String str) {
        return (BaseResponse) new com.google.gson.e().k(str, new com.google.gson.t.a<BaseResponse<TempUserInfo>>() { // from class: us.pinguo.inspire.module.profile.UserInfoLoader.3
        }.getType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String v(TempUserInfo tempUserInfo) {
        us.pinguo.common.log.a.m("nickName", "nickName：" + tempUserInfo.nickname, new Object[0]);
        User.Info h2 = User.d().h();
        h2.nickname = tempUserInfo.nickname;
        User.v(h2);
        return h2.nickname;
    }

    public Observable<List<LocationGroup>> getCountryListInfo(final Context context) {
        final String a = us.pinguo.inspire.util.r.a(context);
        if (this.mLocationResourseCache == null) {
            this.mLocationResourseCache = new ProfileLocationResourceCache(a);
        }
        return Observable.create(new Observable.OnSubscribe() { // from class: us.pinguo.inspire.module.profile.b1
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                UserInfoLoader.this.b(a, context, (Subscriber) obj);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<GeoResp> getCurrentLocation(String str, String str2) {
        HashMap hashMap = new HashMap();
        LoginConfig.b(us.pinguo.util.v.a(), hashMap);
        hashMap.put(BigAlbumStore.PhotoColumns.LATITUDE, str);
        hashMap.put(BigAlbumStore.PhotoColumns.LONGITUDE, str2);
        us.pinguo.foundation.m.d.b(hashMap);
        return RxVolley.observe(new VolleyRequest.Builder(String.class).withEncrypt(!us.pinguo.foundation.d.f10985d).withMethod(1).withUrl(us.pinguo.user.t0.G).addParams(hashMap).build()).map(new Func1() { // from class: us.pinguo.inspire.module.profile.z0
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return UserInfoLoader.this.d((String) obj);
            }
        }).map(new Payload());
    }

    public Observable<String> updateAvatar(String str) {
        HashMap hashMap = new HashMap();
        LoginConfig.b(us.pinguo.util.v.a(), hashMap);
        hashMap.put("avatar", str);
        us.pinguo.foundation.m.d.b(hashMap);
        return RxVolley.observe(new VolleyRequest.Builder(String.class).withEncrypt(!us.pinguo.foundation.d.f10985d).withMethod(1).withUrl(us.pinguo.user.t0.C).addParams(hashMap).build()).map(new Func1() { // from class: us.pinguo.inspire.module.profile.a1
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return UserInfoLoader.this.f((String) obj);
            }
        }).map(new Payload()).map(x0.a);
    }

    public Observable<String> updateCover(String str) {
        HashMap hashMap = new HashMap();
        LoginConfig.b(us.pinguo.util.v.a(), hashMap);
        hashMap.put("backgroundPic", str);
        us.pinguo.foundation.m.d.b(hashMap);
        return RxVolley.observe(new VolleyRequest.Builder(String.class).withEncrypt(!us.pinguo.foundation.d.f10985d).withMethod(1).withUrl(us.pinguo.user.t0.C).addParams(hashMap).build()).map(new Func1() { // from class: us.pinguo.inspire.module.profile.w0
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return UserInfoLoader.this.i((String) obj);
            }
        }).map(new Payload()).map(e1.a);
    }

    public Observable<String> updateDescription(String str) {
        HashMap hashMap = new HashMap();
        LoginConfig.b(us.pinguo.util.v.a(), hashMap);
        hashMap.put(SocialConstants.PARAM_COMMENT, str);
        us.pinguo.foundation.m.d.b(hashMap);
        return RxVolley.observe(new VolleyRequest.Builder(String.class).withEncrypt(!us.pinguo.foundation.d.f10985d).withMethod(1).withUrl(us.pinguo.user.t0.C).addParams(hashMap).build()).map(new Func1() { // from class: us.pinguo.inspire.module.profile.y0
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return UserInfoLoader.this.l((String) obj);
            }
        }).map(new Payload()).map(i1.a);
    }

    public Observable<String> updateGender(int i2) {
        HashMap hashMap = new HashMap();
        LoginConfig.b(us.pinguo.util.v.a(), hashMap);
        hashMap.put("gender", "" + i2);
        us.pinguo.foundation.m.d.b(hashMap);
        return RxVolley.observe(new VolleyRequest.Builder(String.class).withEncrypt(!us.pinguo.foundation.d.f10985d).withMethod(1).withUrl(us.pinguo.user.t0.C).addParams(hashMap).build()).map(new Func1() { // from class: us.pinguo.inspire.module.profile.d1
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return UserInfoLoader.this.o((String) obj);
            }
        }).map(new Payload()).map(f1.a);
    }

    public Observable<String> updateLocation(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        LoginConfig.b(us.pinguo.util.v.a(), hashMap);
        hashMap.put(BigAlbumStore.PhotoAddressColumns.COUNTRY, str);
        hashMap.put(BigAlbumStore.PhotoAddressColumns.PROVINCE, str2);
        hashMap.put(BigAlbumStore.PhotoAddressColumns.CITY, str3);
        us.pinguo.foundation.m.d.b(hashMap);
        return RxVolley.observe(new VolleyRequest.Builder(String.class).withEncrypt(!us.pinguo.foundation.d.f10985d).withMethod(1).withUrl(us.pinguo.user.t0.C).addParams(hashMap).build()).map(new Func1() { // from class: us.pinguo.inspire.module.profile.h1
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return UserInfoLoader.this.r((String) obj);
            }
        }).map(new Payload()).map(v0.a);
    }

    public Observable<String> updateNickName(String str) {
        HashMap hashMap = new HashMap();
        LoginConfig.b(us.pinguo.util.v.a(), hashMap);
        hashMap.put("nickname", str);
        us.pinguo.foundation.m.d.b(hashMap);
        return RxVolley.observe(new VolleyRequest.Builder(String.class).withEncrypt(!us.pinguo.foundation.d.f10985d).withMethod(1).withUrl(us.pinguo.user.t0.C).addParams(hashMap).build()).map(new Func1() { // from class: us.pinguo.inspire.module.profile.g1
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return UserInfoLoader.this.u((String) obj);
            }
        }).map(new Payload()).map(c1.a);
    }
}
