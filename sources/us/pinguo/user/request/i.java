package us.pinguo.user.request;

import android.content.Context;
import us.pinguo.foundation.network.Fault;
import us.pinguo.user.User;
import us.pinguo.user.api.UserInfoResponse;
import us.pinguo.user.api.a0;
/* compiled from: PhoneFindPassword.java */
/* loaded from: classes6.dex */
public class i extends j.a.c.b.c<Void, UserInfoResponse> {
    public i(Context context, String str) {
        super(new a0(context, str));
    }

    @Override // j.a.c.b.c
    public Void adapte(UserInfoResponse userInfoResponse) throws Exception {
        int i2 = userInfoResponse.status;
        if (i2 == 420) {
            User.E();
            throw null;
        } else if (i2 == 200) {
            return null;
        } else {
            throw new Fault(userInfoResponse.status, userInfoResponse.message);
        }
    }
}
