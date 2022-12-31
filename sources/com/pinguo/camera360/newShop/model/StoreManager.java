package com.pinguo.camera360.newShop.model;

import com.android.volley.AuthFailureError;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import us.pinguo.common.network.HttpStringRequest;
import us.pinguo.foundation.m.d;
import us.pinguo.foundation.statistics.h;
import us.pinguo.foundation.statistics.i;
import us.pinguo.foundation.utils.f;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.user.User;
import us.pinguo.user.u0;
/* loaded from: classes3.dex */
public class StoreManager {
    private static final String b = "StoreManager";
    public static StoreManager c = new StoreManager();
    private HttpStringRequest a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: com.pinguo.camera360.newShop.model.StoreManager$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0247a extends HttpStringRequest {
            final /* synthetic */ long a;
            final /* synthetic */ User b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0247a(int i2, String str, long j2, User user) {
                super(i2, str);
                this.a = j2;
                this.b = user;
            }

            @Override // com.android.volley.Request
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap hashMap = new HashMap();
                u0.e(BaseApplication.d(), hashMap);
                hashMap.put(GuestProfileFragment.USER_ID, this.b.h().userId);
                hashMap.put("token", this.b.h().token);
                d.c(hashMap, "Nh02nt\\\":;-9/-`^$3bf0Nhf893>,/{1|");
                return hashMap;
            }

            @Override // us.pinguo.common.network.HttpRequestBase
            protected void onErrorResponse(Exception exc) {
                i iVar = h.b;
                iVar.n((System.currentTimeMillis() - this.a) + "", "/bmall/user/bind-order", "failed");
                String str = StoreManager.b;
                us.pinguo.common.log.a.g(str, "onErrorResponse error: " + exc, new Object[0]);
                StoreManager.this.a = null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // us.pinguo.common.network.HttpRequestBase
            public void onResponse(String str) {
                try {
                    i iVar = h.b;
                    iVar.n((System.currentTimeMillis() - this.a) + "", "/bmall/user/bind-order", FirebaseAnalytics.Param.SUCCESS);
                    JSONObject jSONObject = new JSONObject(str);
                    if (str == null || !jSONObject.getBoolean("data")) {
                        us.pinguo.common.log.a.m(StoreManager.b, "store_bind_user finish 该设备已跟其他帐号绑定", new Object[0]);
                    } else {
                        us.pinguo.common.log.a.m(StoreManager.b, "store_bind_user 绑定成功 ", new Object[0]);
                    }
                    StoreManager.this.a = null;
                } catch (Exception e2) {
                    String str2 = StoreManager.b;
                    us.pinguo.common.log.a.g(str2, "onResponse error: " + e2, new Object[0]);
                    StoreManager.this.a = null;
                }
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            User d2 = User.d();
            if (d2.n() && StoreManager.this.a == null) {
                h.b.n("", "/bmall/user/bind-order", SocialConstants.TYPE_REQUEST);
                long currentTimeMillis = System.currentTimeMillis();
                StoreManager.this.a = new C0247a(1, u0.f12383e, currentTimeMillis, d2);
                StoreManager.this.a.setRetryPolicy(u0.a());
                StoreManager.this.a.execute();
            }
        }
    }

    public static synchronized StoreManager getInstance() {
        StoreManager storeManager;
        synchronized (StoreManager.class) {
            if (c == null) {
                c = new StoreManager();
            }
            storeManager = c;
        }
        return storeManager;
    }

    public void d() {
        f.b(new a());
    }
}
