package us.pinguo.user.api;

import android.content.Context;
import com.android.volley.AuthFailureError;
import com.tencent.matrix.report.Issue;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.common.network.HttpStringRequest;
import us.pinguo.user.LoginConfig;
import us.pinguo.user.t0;
/* loaded from: classes6.dex */
public class ApiRefreshToken extends j.a.c.a.a<NewTokenResponse> {

    /* loaded from: classes6.dex */
    public static class NewTokenResponse extends BaseResponse<b> {
        /* JADX WARN: Type inference failed for: r0v1, types: [T, us.pinguo.user.api.ApiRefreshToken$b] */
        public NewTokenResponse(String str) throws JSONException {
            JSONObject jSONObject = new JSONObject(str);
            this.status = jSONObject.getInt("status");
            if (jSONObject.has("message")) {
                this.message = jSONObject.getString("message");
            }
            if (jSONObject.has("data")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                this.data = new b();
                if (jSONObject2.has("token")) {
                    ((b) this.data).a = jSONObject2.getString("token");
                }
                if (jSONObject2.has("tokenExpire")) {
                    ((b) this.data).b = jSONObject2.getLong("tokenExpire");
                }
                if (jSONObject2.has("tokenEnd")) {
                    ((b) this.data).c = jSONObject2.getLong("tokenEnd");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends HttpStringRequest {
        final /* synthetic */ j.a.c.b.d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i2, String str, j.a.c.b.d dVar) {
            super(i2, str);
            this.a = dVar;
        }

        @Override // com.android.volley.Request
        protected Map<String, String> getParams() throws AuthFailureError {
            HashMap hashMap = new HashMap();
            LoginConfig.b(((j.a.c.a.a) ApiRefreshToken.this).mContext, hashMap);
            hashMap.put(Issue.ISSUE_REPORT_TIME, String.valueOf(System.currentTimeMillis() / 1000));
            us.pinguo.foundation.m.d.b(hashMap);
            return hashMap;
        }

        @Override // us.pinguo.common.network.HttpRequestBase
        protected void onErrorResponse(Exception exc) {
            ApiRefreshToken.this.postError(this.a, exc);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.common.network.HttpRequestBase
        public void onResponse(String str) {
            try {
                ApiRefreshToken.this.postResponse(this.a, new NewTokenResponse(str));
            } catch (Exception e2) {
                ApiRefreshToken.this.postError(this.a, e2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public String a;
        public long b;
        public long c;
    }

    public ApiRefreshToken(Context context) {
        super(context);
    }

    @Override // j.a.c.a.a, j.a.c.b.b
    public void get(j.a.c.b.d<NewTokenResponse> dVar) {
        execute(new a(1, t0.t, dVar));
    }
}
