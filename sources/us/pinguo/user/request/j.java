package us.pinguo.user.request;

import com.tapjoy.TapjoyConstants;
import com.tencent.matrix.report.Issue;
import java.util.HashMap;
import org.json.JSONException;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import us.pinguo.common.network.RxVolley;
import us.pinguo.common.network.request.VolleyRequest;
import us.pinguo.foundation.network.Fault;
import us.pinguo.user.LoginConfig;
import us.pinguo.user.User;
import us.pinguo.user.api.UserInfoResponse;
import us.pinguo.user.t0;
/* compiled from: PhoneLogin.java */
/* loaded from: classes6.dex */
public class j {
    private static VolleyRequest<String> a(String str, String str2) {
        HashMap hashMap = new HashMap();
        LoginConfig.b(us.pinguo.foundation.e.b(), hashMap);
        String g2 = us.pinguo.util.i.g(str2);
        hashMap.put(TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE, str);
        hashMap.put("password", g2);
        hashMap.put(Issue.ISSUE_REPORT_TIME, String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("withVipInfo", "1");
        us.pinguo.foundation.m.d.b(hashMap);
        return new VolleyRequest.Builder(String.class).withUrl(t0.p).withMethod(1).withEncrypt(true ^ us.pinguo.foundation.d.f10985d).addParams(hashMap).build();
    }

    public static Observable<Void> b(String str, String str2) {
        return RxVolley.create(a(str, str2)).observeOn(AndroidSchedulers.mainThread()).map(a.a).map(b.a).observeOn(AndroidSchedulers.mainThread());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ UserInfoResponse c(String str) {
        try {
            return new UserInfoResponse(str, TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE);
        } catch (JSONException e2) {
            us.pinguo.foundation.e.e(e2);
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Void d(UserInfoResponse userInfoResponse) {
        int i2 = userInfoResponse.status;
        if (i2 == 420) {
            User.E();
            throw null;
        } else if (i2 == 200) {
            User.v((User.Info) userInfoResponse.data);
            long j2 = userInfoResponse.tokenExpire;
            if (j2 > 0) {
                long j3 = userInfoResponse.tokenEnd;
                if (j3 > 0) {
                    User.x(j2, j3 - j2);
                }
            }
            User.D(false);
            return null;
        } else {
            throw new Fault(userInfoResponse.status, userInfoResponse.message);
        }
    }
}
