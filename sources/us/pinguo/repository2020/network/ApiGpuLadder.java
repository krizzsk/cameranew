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
import us.pinguo.repository2020.entity.GpuLadderResponse;
import us.pinguo.repository2020.utils.n;
import us.pinguo.user.u0;
/* compiled from: ApiGpuLadder.kt */
/* loaded from: classes6.dex */
public final class ApiGpuLadder extends j.a.c.a.a<GpuLadderResponse> {

    /* compiled from: ApiGpuLadder.kt */
    /* loaded from: classes6.dex */
    public static final class a extends c<GpuLadderResponse> {
        final /* synthetic */ long b;
        final /* synthetic */ d<GpuLadderResponse> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j2, d<GpuLadderResponse> dVar, String str) {
            super(0, str);
            this.b = j2;
            this.c = dVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.common.network.HttpRequestBase
        /* renamed from: a */
        public void onResponse(GpuLadderResponse gpuLadderResponse) {
            i iVar = h.b;
            iVar.n((System.currentTimeMillis() - this.b) + "", "/v1/json-config-show?code=gpuLadder", FirebaseAnalytics.Param.SUCCESS);
            try {
                ApiGpuLadder.this.postResponse(this.c, gpuLadderResponse);
            } catch (JSONException e2) {
                e2.printStackTrace();
                ApiGpuLadder.this.postError(this.c, e2);
            }
        }

        @Override // com.android.volley.Request
        public Map<String, String> getHeaders() throws AuthFailureError {
            HashMap hashMap = new HashMap();
            boolean z = us.pinguo.foundation.d.f10985d;
            if (z) {
                hashMap.put("PG-Debug", "1");
            }
            u0.f(((j.a.c.a.a) ApiGpuLadder.this).mContext, hashMap);
            us.pinguo.foundation.m.d.d(s.q(n.a.e(), "/v1/json-config-show?code=gpuLadder"), 0, hashMap, z ? "49BC34172930E4AAAFA65C3C7ACGCEC2" : "59BC34172930E4AAAFA65C3C7ACGCEC3");
            return hashMap;
        }

        @Override // us.pinguo.common.network.HttpRequestBase
        protected void onErrorResponse(Exception e2) {
            s.h(e2, "e");
            i iVar = h.b;
            iVar.n((System.currentTimeMillis() - this.b) + "", "/v1/json-config-show?code=gpuLadder", "failed");
            us.pinguo.common.log.a.k(s.q("获取GPU天梯数据失败 error:", e2), new Object[0]);
            ApiGpuLadder.this.postError(this.c, e2);
        }
    }

    public ApiGpuLadder(Context context) {
        super(context);
    }

    @Override // j.a.c.a.a, j.a.c.b.b
    public void get(d<GpuLadderResponse> result) {
        s.h(result, "result");
        h.b.n("", "/v1/json-config-show?code=gpuLadder", SocialConstants.TYPE_REQUEST);
        execute(new a(System.currentTimeMillis(), result, s.q(n.a.e(), "/v1/json-config-show?code=gpuLadder")));
    }
}
