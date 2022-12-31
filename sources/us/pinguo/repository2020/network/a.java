package us.pinguo.repository2020.network;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pinguo.lib.GsonUtilKt;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.json.JSONArray;
import us.pinguo.common.network.HttpStringRequest;
import us.pinguo.common.network.common.header.PGUidHeader;
import us.pinguo.foundation.e;
import us.pinguo.foundation.m.d;
import us.pinguo.foundation.statistics.h;
import us.pinguo.foundation.statistics.i;
import us.pinguo.repository2020.entity.FilterDetailResponse;
import us.pinguo.repository2020.entity.ShopResponse;
import us.pinguo.user.User;
import us.pinguo.user.u0;
/* compiled from: FilterNetworkApi.kt */
/* loaded from: classes6.dex */
public final class a {
    public static final a a = new a();

    /* compiled from: FilterNetworkApi.kt */
    /* renamed from: us.pinguo.repository2020.network.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0442a extends HttpStringRequest {
        final /* synthetic */ long a;
        final /* synthetic */ us.pinguo.repository2020.network.b<FilterDetailResponse> b;
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0442a(long j2, us.pinguo.repository2020.network.b<FilterDetailResponse> bVar, String str, String str2) {
            super(1, str2);
            this.a = j2;
            this.b = bVar;
            this.c = str;
        }

        @Override // com.android.volley.Request
        protected Map<String, String> getParams() {
            HashMap hashMap = new HashMap();
            u0.e(e.b(), hashMap);
            String jSONArray = new JSONArray().put(this.c).toString();
            s.g(jSONArray, "JSONArray().put(packageId).toString()");
            hashMap.put("ids", jSONArray);
            d.c(hashMap, "Nh02nt\\\":;-9/-`^$3bf0Nhf893>,/{1|");
            return hashMap;
        }

        @Override // us.pinguo.common.network.HttpRequestBase
        protected void onErrorResponse(Exception exc) {
            i iVar = h.b;
            iVar.n((System.currentTimeMillis() - this.a) + "", "/api/product/detail", "failed");
            this.b.onError(-1, "NETWORK ERROR");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.common.network.HttpRequestBase
        public void onResponse(String str) {
            i iVar = h.b;
            iVar.n((System.currentTimeMillis() - this.a) + "", "/api/product/detail", FirebaseAnalytics.Param.SUCCESS);
            if (str == null) {
                this.b.onError(-1, "NETWORK ERROR");
                return;
            }
            try {
                FilterDetailResponse filterDetailResponse = (FilterDetailResponse) GsonUtilKt.getCachedGson().j(str, FilterDetailResponse.class);
                Integer status = filterDetailResponse.getStatus();
                if (status != null && status.intValue() == 420) {
                    this.b.onError(TypedValues.CycleType.TYPE_EASING, "USER TOKEN ERROR");
                }
                if (status.intValue() == 10220) {
                    this.b.onError(10220, "DATA IS LATEST");
                }
                if (status != null && status.intValue() == 200) {
                    us.pinguo.repository2020.network.b<FilterDetailResponse> bVar = this.b;
                    s.g(filterDetailResponse, "filterDetailResponse");
                    bVar.onSuccess(filterDetailResponse);
                }
                this.b.onError(0, "UNKNOWN ERROR");
            } catch (Exception e2) {
                e2.printStackTrace();
                this.b.onError(1001, "JSON PARSE ERROR");
            }
        }
    }

    /* compiled from: FilterNetworkApi.kt */
    /* loaded from: classes6.dex */
    public static final class b extends HttpStringRequest {
        final /* synthetic */ long a;
        final /* synthetic */ us.pinguo.repository2020.network.b<ShopResponse> b;
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j2, us.pinguo.repository2020.network.b<ShopResponse> bVar, String str, String str2) {
            super(1, str2);
            this.a = j2;
            this.b = bVar;
            this.c = str;
        }

        @Override // com.android.volley.Request
        public Map<String, String> getHeaders() {
            if (User.d().n()) {
                HashMap hashMap = new HashMap();
                User.Info h2 = User.d().h();
                s.e(h2);
                String str = h2.userId;
                s.g(str, "create().info!!.userId");
                hashMap.put(PGUidHeader.HEADER_NAME, str);
                return hashMap;
            }
            Map<String, String> headers = super.getHeaders();
            s.g(headers, "super.getHeaders()");
            return headers;
        }

        @Override // com.android.volley.Request
        protected Map<String, String> getParams() {
            HashMap hashMap = new HashMap();
            u0.e(e.b(), hashMap);
            hashMap.put("version", this.c);
            d.c(hashMap, "Nh02nt\\\":;-9/-`^$3bf0Nhf893>,/{1|");
            return hashMap;
        }

        @Override // us.pinguo.common.network.HttpRequestBase
        protected void onErrorResponse(Exception exc) {
            i iVar = h.b;
            iVar.n((System.currentTimeMillis() - this.a) + "", "/api/product/query", "failed");
            this.b.onError(-1, "NETWORK ERROR");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.common.network.HttpRequestBase
        public void onResponse(String str) {
            i iVar = h.b;
            iVar.n((System.currentTimeMillis() - this.a) + "", "/api/product/query", FirebaseAnalytics.Param.SUCCESS);
            if (str == null) {
                this.b.onError(-1, "NETWORK ERROR");
                return;
            }
            ShopResponse shopResponse = null;
            try {
                shopResponse = (ShopResponse) GsonUtilKt.getCachedGson().j(str, ShopResponse.class);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (shopResponse == null) {
                this.b.onError(1001, "JSON PARSE ERROR");
                return;
            }
            Integer status = shopResponse.getStatus();
            if (status != null && status.intValue() == 420) {
                this.b.onError(TypedValues.CycleType.TYPE_EASING, "USER TOKEN ERROR");
            } else if (status != null && status.intValue() == 10220) {
                this.b.onError(10220, "DATA IS LATEST");
            } else if (status != null && status.intValue() == 200) {
                this.b.onSuccess(shopResponse);
            } else {
                this.b.onError(0, "UNKNOWN ERROR");
            }
        }
    }

    private a() {
    }

    public final void a(String packageId, us.pinguo.repository2020.network.b<FilterDetailResponse> callback) {
        s.h(packageId, "packageId");
        s.h(callback, "callback");
        h.b.n("", "/api/product/detail", SocialConstants.TYPE_REQUEST);
        C0442a c0442a = new C0442a(System.currentTimeMillis(), callback, packageId, s.q(us.pinguo.repository2020.utils.h.c(), "/api/product/detail"));
        c0442a.setRetryPolicy(u0.b());
        c0442a.execute();
    }

    public final void b(us.pinguo.repository2020.network.b<ShopResponse> callback, String currentDataversion) {
        s.h(callback, "callback");
        s.h(currentDataversion, "currentDataversion");
        h.b.n("", "/api/product/query", SocialConstants.TYPE_REQUEST);
        b bVar = new b(System.currentTimeMillis(), callback, currentDataversion, s.q(us.pinguo.repository2020.utils.h.c(), "/api/product/query"));
        bVar.setRetryPolicy(u0.b());
        bVar.execute();
    }
}
