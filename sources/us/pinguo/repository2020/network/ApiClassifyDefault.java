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
import us.pinguo.repository2020.entity.ClassifyDefaultResponse;
import us.pinguo.user.LoginConfig;
import us.pinguo.user.u0;
/* compiled from: ApiClassifyDefault.kt */
/* loaded from: classes6.dex */
public final class ApiClassifyDefault extends j.a.c.a.a<HttpBaseResponse<ClassifyDefaultResponse>> {

    /* compiled from: ApiClassifyDefault.kt */
    /* loaded from: classes6.dex */
    public static final class a extends c<HttpBaseResponse<ClassifyDefaultResponse>> {
        final /* synthetic */ long b;
        final /* synthetic */ d<HttpBaseResponse<ClassifyDefaultResponse>> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j2, d<HttpBaseResponse<ClassifyDefaultResponse>> dVar, String HOST_CLASSIFY_DEFAULT) {
            super(1, HOST_CLASSIFY_DEFAULT);
            this.b = j2;
            this.c = dVar;
            s.g(HOST_CLASSIFY_DEFAULT, "HOST_CLASSIFY_DEFAULT");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.repository2020.network.c, com.android.volley.Request
        public Map<String, String> getParams() throws AuthFailureError {
            HashMap hashMap = new HashMap();
            LoginConfig.c(((j.a.c.a.a) ApiClassifyDefault.this).mContext, hashMap);
            us.pinguo.foundation.m.d.c(hashMap, "Nh02nt\\\":;-9/-`^$3bf0Nhf893>,/{1|");
            return hashMap;
        }

        @Override // us.pinguo.common.network.HttpRequestBase
        protected void onErrorResponse(Exception e2) {
            s.h(e2, "e");
            i iVar = h.b;
            iVar.n((System.currentTimeMillis() - this.b) + "", "/api/product/classifyDefault", "failed");
            us.pinguo.common.log.a.k(s.q("滤镜贴纸默认分类 error:", e2), new Object[0]);
            ApiClassifyDefault.this.postError(this.c, e2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.common.network.HttpRequestBase
        public void onResponse(HttpBaseResponse<ClassifyDefaultResponse> p0) {
            s.h(p0, "p0");
            i iVar = h.b;
            iVar.n((System.currentTimeMillis() - this.b) + "", "/api/product/classifyDefault", FirebaseAnalytics.Param.SUCCESS);
            try {
                ApiClassifyDefault.this.postResponse(this.c, p0);
            } catch (JSONException e2) {
                e2.printStackTrace();
                ApiClassifyDefault.this.postError(this.c, e2);
            }
        }
    }

    public ApiClassifyDefault(Context context) {
        super(context);
    }

    @Override // j.a.c.a.a, j.a.c.b.b
    public void get(d<HttpBaseResponse<ClassifyDefaultResponse>> result) {
        s.h(result, "result");
        h.b.n("", "/api/product/classifyDefault", SocialConstants.TYPE_REQUEST);
        execute(new a(System.currentTimeMillis(), result, u0.f12388j));
    }
}
