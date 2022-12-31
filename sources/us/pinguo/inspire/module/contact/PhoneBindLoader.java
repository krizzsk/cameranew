package us.pinguo.inspire.module.contact;

import com.tapjoy.TapjoyConstants;
import com.tencent.matrix.report.Issue;
import java.util.HashMap;
import rx.Observable;
import rx.functions.Func1;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.common.network.RxVolley;
import us.pinguo.common.network.request.VolleyRequest;
import us.pinguo.inspire.api.Payload;
import us.pinguo.inspire.module.profile.UserInfoLoader;
import us.pinguo.user.LoginConfig;
import us.pinguo.user.User;
import us.pinguo.user.t0;
import us.pinguo.user.y0;
/* loaded from: classes4.dex */
public class PhoneBindLoader {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ BaseResponse b(String str) {
        return (BaseResponse) new com.google.gson.e().k(str, new com.google.gson.t.a<BaseResponse<UserInfoLoader.TempUserInfo>>() { // from class: us.pinguo.inspire.module.contact.PhoneBindLoader.5
        }.getType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String c(UserInfoLoader.TempUserInfo tempUserInfo) {
        if (tempUserInfo != null) {
            User.Info h2 = User.d().h();
            h2.mobile = tempUserInfo.mobile;
            h2.setPass = tempUserInfo.setPass;
            y0.c cVar = tempUserInfo.vipInfo;
            if (cVar != null) {
                h2.vipInfo = cVar;
            }
            User.v(h2);
            return tempUserInfo.mobile;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ BaseResponse e(String str) {
        return (BaseResponse) new com.google.gson.e().k(str, new com.google.gson.t.a<BaseResponse<Boolean>>() { // from class: us.pinguo.inspire.module.contact.PhoneBindLoader.4
        }.getType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ BaseResponse g(String str) {
        return (BaseResponse) new com.google.gson.e().k(str, new com.google.gson.t.a<BaseResponse<Boolean>>() { // from class: us.pinguo.inspire.module.contact.PhoneBindLoader.1
        }.getType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ BaseResponse i(String str) {
        return (BaseResponse) new com.google.gson.e().k(str, new com.google.gson.t.a<BaseResponse<Boolean>>() { // from class: us.pinguo.inspire.module.contact.PhoneBindLoader.2
        }.getType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ BaseResponse k(String str) {
        return (BaseResponse) new com.google.gson.e().k(str, new com.google.gson.t.a<BaseResponse<UserInfoLoader.TempUserInfo>>() { // from class: us.pinguo.inspire.module.contact.PhoneBindLoader.3
        }.getType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String l(UserInfoLoader.TempUserInfo tempUserInfo) {
        if (tempUserInfo != null) {
            User.Info h2 = User.d().h();
            h2.mobile = tempUserInfo.mobile;
            h2.setPass = tempUserInfo.setPass;
            y0.c cVar = tempUserInfo.vipInfo;
            if (cVar != null) {
                h2.vipInfo = cVar;
            }
            User.v(h2);
            return tempUserInfo.mobile;
        }
        return "";
    }

    public Observable<String> changePhone(String str, String str2, int i2) {
        HashMap hashMap = new HashMap();
        LoginConfig.b(us.pinguo.util.v.a(), hashMap);
        hashMap.put(TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE, str);
        hashMap.put("verifyCode", str2);
        hashMap.put("cc", String.valueOf(i2));
        us.pinguo.foundation.m.d.b(hashMap);
        return RxVolley.observe(new VolleyRequest.Builder(String.class).withEncrypt(!us.pinguo.foundation.d.f10985d).withMethod(1).withUrl(t0.y).addParams(hashMap).build()).map(new Func1() { // from class: us.pinguo.inspire.module.contact.b0
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return PhoneBindLoader.this.b((String) obj);
            }
        }).map(new Payload()).map(e0.a);
    }

    public Observable<Boolean> getChangePhoneVerifyCode(String str, String str2, int i2) {
        HashMap hashMap = new HashMap();
        LoginConfig.b(us.pinguo.util.v.a(), hashMap);
        hashMap.put(TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE, str2);
        hashMap.put("oldMobile", str);
        hashMap.put("type", "rebind");
        hashMap.put("cc", String.valueOf(i2));
        hashMap.put("isVoice", "0");
        us.pinguo.foundation.m.d.b(hashMap);
        return RxVolley.observe(new VolleyRequest.Builder(String.class).withEncrypt(!us.pinguo.foundation.d.f10985d).withMethod(1).withUrl(t0.u).addParams(hashMap).build()).map(new Func1() { // from class: us.pinguo.inspire.module.contact.f0
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return PhoneBindLoader.this.e((String) obj);
            }
        }).map(new Payload());
    }

    public Observable<Boolean> getVerifyCode(String str, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put(TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE, str);
        hashMap.put("cc", String.valueOf(i2));
        LoginConfig.b(us.pinguo.util.v.a(), hashMap);
        us.pinguo.foundation.m.d.b(hashMap);
        return RxVolley.observe(new VolleyRequest.Builder(String.class).withEncrypt(!us.pinguo.foundation.d.f10985d).withMethod(1).withUrl(t0.x).addParams(hashMap).build()).map(new Func1() { // from class: us.pinguo.inspire.module.contact.g0
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return PhoneBindLoader.this.g((String) obj);
            }
        }).map(new Payload());
    }

    public Observable<String> phoneBind(String str, String str2, int i2, boolean z) {
        HashMap hashMap = new HashMap();
        LoginConfig.b(us.pinguo.util.v.a(), hashMap);
        hashMap.put(TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE, str);
        hashMap.put("verifyCode", str2);
        hashMap.put(Issue.ISSUE_REPORT_TIME, String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("cc", String.valueOf(i2));
        hashMap.put("isNeedBind", z ? "0" : "1");
        hashMap.put("withVipInfo", "1");
        us.pinguo.foundation.m.d.b(hashMap);
        return RxVolley.observe(new VolleyRequest.Builder(String.class).withEncrypt(!us.pinguo.foundation.d.f10985d).withMethod(1).withUrl(t0.s).addParams(hashMap).build()).map(new Func1() { // from class: us.pinguo.inspire.module.contact.d0
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return PhoneBindLoader.this.k((String) obj);
            }
        }).map(new Payload()).map(c0.a);
    }

    public Observable<Boolean> getVerifyCode(String str, int i2, String str2) {
        String g2 = us.pinguo.util.i.g(str2);
        HashMap hashMap = new HashMap();
        hashMap.put(TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE, str);
        hashMap.put("cc", String.valueOf(i2));
        hashMap.put("password", g2);
        LoginConfig.b(us.pinguo.util.v.a(), hashMap);
        us.pinguo.foundation.m.d.b(hashMap);
        return RxVolley.observe(new VolleyRequest.Builder(String.class).withEncrypt(!us.pinguo.foundation.d.f10985d).withMethod(1).withUrl(t0.x).addParams(hashMap).build()).map(new Func1() { // from class: us.pinguo.inspire.module.contact.a0
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return PhoneBindLoader.this.i((String) obj);
            }
        }).map(new Payload());
    }
}
