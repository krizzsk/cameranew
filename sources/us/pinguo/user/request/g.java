package us.pinguo.user.request;

import android.content.Context;
import us.pinguo.foundation.network.Fault;
import us.pinguo.user.User;
import us.pinguo.user.api.ApiFindPassword;
/* compiled from: FindPassword.java */
/* loaded from: classes6.dex */
public class g extends j.a.c.b.c<Void, ApiFindPassword.Response> {
    public g(Context context, String str) {
        super(new ApiFindPassword(context, str));
    }

    @Override // j.a.c.b.c
    /* renamed from: a */
    public Void adapte(ApiFindPassword.Response response) throws Exception {
        int i2 = response.status;
        if (i2 == 420) {
            User.E();
            throw null;
        } else if (i2 == 200) {
            return null;
        } else {
            throw new Fault(response.status, response.message);
        }
    }
}
