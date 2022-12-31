package us.pinguo.user.request;

import android.content.Context;
import us.pinguo.foundation.network.Fault;
import us.pinguo.user.User;
import us.pinguo.user.api.b0;
/* compiled from: PhoneRegister.java */
/* loaded from: classes6.dex */
public class k extends j.a.c.b.c<Void, b0.a> {
    public k(Context context, String str, String str2) {
        super(new b0(context, str, str2));
    }

    @Override // j.a.c.b.c
    /* renamed from: a */
    public Void adapte(b0.a aVar) throws Exception {
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
