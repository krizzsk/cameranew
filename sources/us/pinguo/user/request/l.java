package us.pinguo.user.request;

import android.content.Context;
import us.pinguo.foundation.network.Fault;
import us.pinguo.user.User;
import us.pinguo.user.api.c0;
/* compiled from: PhoneSendVerifyCode.java */
/* loaded from: classes6.dex */
public class l extends j.a.c.b.c<Void, c0.a> {
    public l(Context context, String str) {
        super(new c0(context, str));
    }

    @Override // j.a.c.b.c
    /* renamed from: a */
    public Void adapte(c0.a aVar) throws Exception {
        int i2 = aVar.a;
        if (i2 == 420) {
            User.E();
            throw null;
        } else if (i2 == 200) {
            return null;
        } else {
            throw new Fault(aVar.a, aVar.b);
        }
    }
}
