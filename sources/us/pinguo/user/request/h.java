package us.pinguo.user.request;

import android.content.Context;
import us.pinguo.foundation.network.Fault;
import us.pinguo.user.User;
import us.pinguo.user.api.ApiModifyPassword;
/* compiled from: ModifyPassword.java */
/* loaded from: classes6.dex */
public class h extends j.a.c.b.c<String, ApiModifyPassword.Response> {
    public h(Context context, String str, String str2, String str3) {
        super(new ApiModifyPassword(context, str, str2, str3));
    }

    @Override // j.a.c.b.c
    /* renamed from: a */
    public String adapte(ApiModifyPassword.Response response) throws Exception {
        int i2 = response.status;
        if (i2 == 420) {
            User.E();
            throw null;
        } else if (i2 == 200) {
            ApiModifyPassword.Response.Data data = (ApiModifyPassword.Response.Data) response.data;
            String str = data.token;
            long j2 = data.tokenExpire;
            if (j2 > 0) {
                long j3 = data.tokenEnd;
                if (j3 > 0) {
                    User.x(j2, j3 - j2);
                }
            }
            User.D(false);
            return str;
        } else {
            throw new Fault(response.status, response.message);
        }
    }
}
