package com.pinguo.camera360.request;

import android.content.Context;
import com.android.volley.AuthFailureError;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pinguo.camera360.vip.VipReemCodeInfo;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.json.JSONException;
import us.pinguo.foundation.statistics.i;
import us.pinguo.repository2020.network.HttpBaseResponse;
import us.pinguo.user.LoginConfig;
import us.pinguo.user.u0;
/* compiled from: ApiVerifyVipRedeemCode.kt */
/* loaded from: classes3.dex */
public final class ApiVerifyVipRedeemCode extends j.a.c.a.a<HttpBaseResponse<VipReemCodeInfo>> {
    private final String couponCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApiVerifyVipRedeemCode(Context context, String couponCode) {
        super(context);
        s.h(couponCode, "couponCode");
        this.couponCode = couponCode;
    }

    @Override // j.a.c.a.a, j.a.c.b.b
    public void get(final j.a.c.b.d<HttpBaseResponse<VipReemCodeInfo>> result) {
        s.h(result, "result");
        us.pinguo.foundation.statistics.h.b.n("", "/api/iap/coupon-bind", SocialConstants.TYPE_REQUEST);
        final long currentTimeMillis = System.currentTimeMillis();
        final String str = u0.f12386h;
        execute(new us.pinguo.repository2020.network.c<HttpBaseResponse<VipReemCodeInfo>>(currentTimeMillis, result, str) { // from class: com.pinguo.camera360.request.ApiVerifyVipRedeemCode$get$1
            final /* synthetic */ long $requestStartTime;
            final /* synthetic */ j.a.c.b.d<HttpBaseResponse<VipReemCodeInfo>> $result;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1, str);
                s.g(str, "HOST_COUPON_BIND");
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // us.pinguo.repository2020.network.c, com.android.volley.Request
            public Map<String, String> getParams() throws AuthFailureError {
                Context context;
                HashMap hashMap = new HashMap();
                hashMap.put("couponCode", ApiVerifyVipRedeemCode.this.getCouponCode());
                context = ((j.a.c.a.a) ApiVerifyVipRedeemCode.this).mContext;
                LoginConfig.c(context, hashMap);
                us.pinguo.foundation.m.d.c(hashMap, "Nh02nt\\\":;-9/-`^$3bf0Nhf893>,/{1|");
                return hashMap;
            }

            @Override // us.pinguo.common.network.HttpRequestBase
            protected void onErrorResponse(Exception e2) {
                s.h(e2, "e");
                i iVar = us.pinguo.foundation.statistics.h.b;
                iVar.n((System.currentTimeMillis() - this.$requestStartTime) + "", "/api/iap/coupon-bind", "failed");
                us.pinguo.common.log.a.k(s.q("验证兑换码 error:", e2), new Object[0]);
                ApiVerifyVipRedeemCode.this.postError(this.$result, e2);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // us.pinguo.common.network.HttpRequestBase
            public void onResponse(HttpBaseResponse<VipReemCodeInfo> p0) {
                s.h(p0, "p0");
                i iVar = us.pinguo.foundation.statistics.h.b;
                iVar.n((System.currentTimeMillis() - this.$requestStartTime) + "", "/api/iap/coupon-bind", FirebaseAnalytics.Param.SUCCESS);
                try {
                    ApiVerifyVipRedeemCode.this.postResponse(this.$result, p0);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    ApiVerifyVipRedeemCode.this.postError(this.$result, e2);
                }
            }
        });
    }

    public final String getCouponCode() {
        return this.couponCode;
    }
}
