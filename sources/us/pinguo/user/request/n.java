package us.pinguo.user.request;

import android.content.Context;
import android.widget.Toast;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tencent.matrix.report.Issue;
import java.util.HashMap;
import org.json.JSONException;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import us.pinguo.common.network.RxVolley;
import us.pinguo.common.network.request.VolleyRequest;
import us.pinguo.foundation.network.Fault;
import us.pinguo.foundation.utils.p;
import us.pinguo.user.LoginConfig;
import us.pinguo.user.R;
import us.pinguo.user.User;
import us.pinguo.user.api.UserInfoResponse;
import us.pinguo.user.t0;
/* compiled from: SsoLogin.java */
/* loaded from: classes6.dex */
public class n {
    private static VolleyRequest<String> a(String str, String str2, boolean z) {
        HashMap hashMap = new HashMap();
        LoginConfig.b(us.pinguo.foundation.e.b(), hashMap);
        hashMap.put("tokenData", str);
        hashMap.put("siteCode", p.a(str2));
        hashMap.put(Issue.ISSUE_REPORT_TIME, String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("withVipInfo", "1");
        hashMap.put("isNeedBind", z ? "0" : "1");
        us.pinguo.foundation.m.d.b(hashMap);
        return new VolleyRequest.Builder(String.class).withUrl(t0.A).withMethod(1).withEncrypt(true ^ us.pinguo.foundation.d.f10985d).addParams(hashMap).build();
    }

    public static Observable<Void> b(String str, final String str2, boolean z) {
        return RxVolley.create(a(str, str2, z)).map(new Func1() { // from class: us.pinguo.user.request.c
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return n.c(str2, (String) obj);
            }
        }).map(d.a).observeOn(AndroidSchedulers.mainThread());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ UserInfoResponse c(String str, String str2) {
        try {
            return new UserInfoResponse(str2, str);
        } catch (JSONException e2) {
            us.pinguo.foundation.e.e(e2);
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Void d(UserInfoResponse userInfoResponse) {
        Context b = us.pinguo.foundation.e.b();
        int i2 = userInfoResponse.status;
        if (i2 == 420) {
            User.E();
            throw null;
        } else if (i2 == 10548) {
            if (b != null) {
                Toast makeText = Toast.makeText(b, b.getString(R.string.error_tips_10548), 0);
                makeText.show();
                VdsAgent.showToast(makeText);
            }
            return null;
        } else if (i2 == 10549) {
            if (b != null) {
                Toast makeText2 = Toast.makeText(b, b.getString(R.string.error_tips_10549), 0);
                makeText2.show();
                VdsAgent.showToast(makeText2);
            }
            return null;
        } else if (i2 == 10547) {
            if (b != null) {
                Toast makeText3 = Toast.makeText(b, b.getString(R.string.error_tips_10547), 0);
                makeText3.show();
                VdsAgent.showToast(makeText3);
            }
            return null;
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
