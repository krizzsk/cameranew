package us.pinguo.repository2020.network;

import android.content.Context;
import com.android.volley.AuthFailureError;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.open.SocialConstants;
import j.a.c.b.d;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.json.JSONException;
import us.pinguo.foundation.statistics.h;
import us.pinguo.foundation.statistics.i;
import us.pinguo.repository2020.entity.ServiceControlSwitch;
import us.pinguo.user.LoginConfig;
import us.pinguo.user.u0;
/* compiled from: ApiVipRedeemCodeSwitch.kt */
/* loaded from: classes6.dex */
public final class ApiServiceControlSwitch extends j.a.c.a.a<HttpBaseResponse<ServiceControlSwitch>> {

    /* compiled from: ApiVipRedeemCodeSwitch.kt */
    /* loaded from: classes6.dex */
    public static final class a extends c<HttpBaseResponse<ServiceControlSwitch>> {
        final /* synthetic */ long b;
        final /* synthetic */ d<HttpBaseResponse<ServiceControlSwitch>> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j2, d<HttpBaseResponse<ServiceControlSwitch>> dVar, String HOST_COUPON_SWITCH) {
            super(1, HOST_COUPON_SWITCH);
            this.b = j2;
            this.c = dVar;
            s.g(HOST_COUPON_SWITCH, "HOST_COUPON_SWITCH");
        }

        @Override // us.pinguo.repository2020.network.c, com.android.volley.Request
        protected Map<String, String> getParams() throws AuthFailureError {
            HashMap hashMap = new HashMap();
            LoginConfig.c(((j.a.c.a.a) ApiServiceControlSwitch.this).mContext, hashMap);
            us.pinguo.foundation.m.d.c(hashMap, "Nh02nt\\\":;-9/-`^$3bf0Nhf893>,/{1|");
            return hashMap;
        }

        @Override // us.pinguo.common.network.HttpRequestBase
        protected void onErrorResponse(Exception e2) {
            s.h(e2, "e");
            i iVar = h.b;
            iVar.n((System.currentTimeMillis() - this.b) + "", "/api/setting/load-json-conf", "failed");
            us.pinguo.common.log.a.k(s.q("获取服务端控制开关失败 error:", e2), new Object[0]);
            ApiServiceControlSwitch.this.postError(this.c, e2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.common.network.HttpRequestBase
        public void onResponse(HttpBaseResponse<ServiceControlSwitch> p0) {
            s.h(p0, "p0");
            i iVar = h.b;
            iVar.n((System.currentTimeMillis() - this.b) + "", "/api/setting/load-json-conf", FirebaseAnalytics.Param.SUCCESS);
            try {
                ApiServiceControlSwitch.this.postResponse(this.c, p0);
            } catch (JSONException e2) {
                e2.printStackTrace();
                ApiServiceControlSwitch.this.postError(this.c, e2);
            }
        }
    }

    public ApiServiceControlSwitch(Context context) {
        super(context);
    }

    @Override // j.a.c.a.a, j.a.c.b.b
    public void get(d<HttpBaseResponse<ServiceControlSwitch>> result) {
        s.h(result, "result");
        h.b.n("", "/api/setting/load-json-conf", SocialConstants.TYPE_REQUEST);
        execute(new a(System.currentTimeMillis(), result, u0.f12387i));
    }
}
