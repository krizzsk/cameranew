package com.pinguo.camera360.request;

import android.content.Context;
import android.text.TextUtils;
import us.pinguo.foundation.network.Fault;
import us.pinguo.user.User;
import us.pinguo.user.api.UserInfoResponse;
/* loaded from: classes3.dex */
public class PhoneBindEmail extends j.a.c.b.c<Void, UserInfoResponse> {
    private Context mContext;

    public PhoneBindEmail(Context context, String str) {
        super(new ApiPhoneBindEmail(context, str));
        this.mContext = context;
    }

    @Override // j.a.c.b.c
    public Void adapte(UserInfoResponse userInfoResponse) throws Exception {
        int i2 = userInfoResponse.status;
        if (i2 == 420) {
            User.E();
            throw null;
        } else if (i2 == 200) {
            User.Info h2 = User.d().h();
            User.Info info = (User.Info) userInfoResponse.data;
            if (TextUtils.isEmpty(info.token)) {
                info.token = h2.token;
            }
            if (TextUtils.isEmpty(info.userId)) {
                info.userId = h2.userId;
            }
            User.v(info);
            return null;
        } else {
            throw new Fault(userInfoResponse.status, userInfoResponse.message);
        }
    }
}
