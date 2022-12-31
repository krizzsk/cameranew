package com.pinguo.camera360.request;

import android.content.Context;
import us.pinguo.foundation.network.Fault;
import us.pinguo.user.User;
import us.pinguo.user.api.UserInfoResponse;
/* loaded from: classes3.dex */
public class GetUserInfo extends j.a.c.b.c<Void, UserInfoResponse> {
    private Context mContext;

    public GetUserInfo(Context context) {
        super(new ApiUserInfo(context));
        this.mContext = context;
    }

    @Override // j.a.c.b.c
    public Void adapte(UserInfoResponse userInfoResponse) throws Exception {
        int i2 = userInfoResponse.status;
        if (i2 == 420) {
            User.E();
            throw null;
        } else if (i2 == 200) {
            User d2 = User.d();
            if (d2.q()) {
                User.Info h2 = d2.h();
                User.Info info = (User.Info) userInfoResponse.data;
                info.loginmode = h2.loginmode;
                info.token = h2.token;
                User.v(info);
                return null;
            }
            throw new IllegalArgumentException("用户不合法");
        } else {
            throw new Fault(userInfoResponse.status, userInfoResponse.message);
        }
    }
}
