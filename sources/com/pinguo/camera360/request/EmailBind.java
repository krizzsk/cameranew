package com.pinguo.camera360.request;

import android.content.Context;
import android.text.TextUtils;
import us.pinguo.foundation.network.Fault;
import us.pinguo.user.User;
import us.pinguo.user.api.UserInfoResponse;
/* loaded from: classes3.dex */
public class EmailBind extends j.a.c.b.c<Void, UserInfoResponse> {
    private Context mContext;

    public EmailBind(Context context, String str, String str2) {
        super(new ApiEmailBind(context, str, str2));
        this.mContext = context;
    }

    @Override // j.a.c.b.c
    public Void adapte(UserInfoResponse userInfoResponse) throws Exception {
        int i2 = userInfoResponse.status;
        if (i2 == 420) {
            User.E();
            throw null;
        } else if (i2 == 200) {
            if (!TextUtils.isEmpty(((User.Info) userInfoResponse.data).email)) {
                User.Info h2 = User.d().h();
                T t = userInfoResponse.data;
                h2.email = ((User.Info) t).email;
                h2.setPass = ((User.Info) t).setPass;
                User.v(h2);
            }
            return null;
        } else {
            throw new Fault(userInfoResponse.status, userInfoResponse.message);
        }
    }

    public EmailBind(Context context, String str) {
        this(context, str, "");
    }
}
