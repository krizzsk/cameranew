package us.pinguo.user.request;

import android.content.Context;
import us.pinguo.foundation.network.Fault;
import us.pinguo.user.User;
import us.pinguo.user.api.UserInfoResponse;
import us.pinguo.user.api.y;
/* compiled from: EmailLogin.java */
/* loaded from: classes6.dex */
public class e extends j.a.c.b.c<Void, UserInfoResponse> {
    private Context a;

    public e(Context context, String str, String str2) {
        super(new y(str, str2, context));
        this.a = context;
    }

    @Override // j.a.c.b.c
    public Void adapte(UserInfoResponse userInfoResponse) throws Exception {
        us.pinguo.common.log.a.k("user->adapte->statusCode->" + userInfoResponse.status, new Object[0]);
        int i2 = userInfoResponse.status;
        if (i2 == 420) {
            User.E();
            throw null;
        } else if (i2 == 200) {
            us.pinguo.common.log.a.k("user->adapte->info->" + userInfoResponse.data, new Object[0]);
            User.v((User.Info) userInfoResponse.data);
            long j2 = userInfoResponse.tokenExpire;
            if (j2 > 0) {
                long j3 = userInfoResponse.tokenEnd;
                if (j3 > 0) {
                    User.x(j2, j3 - j2);
                }
            }
            User.D(false);
            return null;
        } else {
            throw new Fault(userInfoResponse.status, userInfoResponse.message);
        }
    }
}
