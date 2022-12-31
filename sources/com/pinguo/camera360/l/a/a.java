package com.pinguo.camera360.l.a;

import android.content.Context;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.constants.Constants;
import com.tencent.open.SocialConstants;
import j.a.c.b.d;
import java.util.HashMap;
import java.util.Map;
import us.pinguo.camera360.shop.manager.ExceptionStatManager;
import us.pinguo.common.network.HttpStringRequest;
import us.pinguo.foundation.statistics.h;
import us.pinguo.foundation.statistics.i;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.user.User;
import us.pinguo.user.u0;
/* compiled from: OrderTask.java */
/* loaded from: classes3.dex */
public class a extends j.a.c.a.a<String> {
    private static final String c = a.class.getSimpleName();
    private String a;
    HttpStringRequest b;

    /* compiled from: OrderTask.java */
    /* renamed from: com.pinguo.camera360.l.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0244a extends HttpStringRequest {
        final /* synthetic */ long a;
        final /* synthetic */ d b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0244a(int i2, String str, long j2, d dVar) {
            super(i2, str);
            this.a = j2;
            this.b = dVar;
        }

        @Override // com.android.volley.Request
        protected Map<String, String> getParams() throws AuthFailureError {
            HashMap hashMap = new HashMap();
            u0.e(BaseApplication.d(), hashMap);
            hashMap.put("productIdList", "");
            String str = a.c;
            us.pinguo.common.log.a.m(str, "version: " + a.this.a, new Object[0]);
            hashMap.put(GuestProfileFragment.USER_ID, a.this.f());
            hashMap.put("version", a.this.a);
            us.pinguo.foundation.m.d.c(hashMap, "Nh02nt\\\":;-9/-`^$3bf0Nhf893>,/{1|");
            return hashMap;
        }

        @Override // us.pinguo.common.network.HttpRequestBase
        protected void onErrorResponse(Exception exc) {
            a.this.postError(this.b, exc);
            i iVar = h.b;
            iVar.n((System.currentTimeMillis() - this.a) + "", "/api/user/order", "failed");
            ExceptionStatManager.getInstance().h(a.this.b, exc);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.common.network.HttpRequestBase
        public void onResponse(String str) {
            i iVar = h.b;
            iVar.n((System.currentTimeMillis() - this.a) + "", "/api/user/order", FirebaseAnalytics.Param.SUCCESS);
            a.this.postResponse(this.b, str);
        }
    }

    public a(Context context, int i2) {
        super(context);
        this.a = "0";
        this.b = null;
        this.a = String.valueOf(i2);
    }

    public Request e() {
        return this.b;
    }

    public String f() {
        try {
            return (!User.d().n() || User.d().h() == null) ? "" : User.d().h().userId;
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
            return "";
        }
    }

    @Override // j.a.c.a.a, j.a.c.b.b
    public void get(d<String> dVar) {
        h.b.n("", "/api/user/order", SocialConstants.TYPE_REQUEST);
        C0244a c0244a = new C0244a(1, u0.f12384f, System.currentTimeMillis(), dVar);
        this.b = c0244a;
        c0244a.setRetryPolicy(new DefaultRetryPolicy(Constants.DEFAULT_STARTUP_THRESHOLD_MS_WARM, 1, 1.0f));
        execute(this.b);
    }
}
