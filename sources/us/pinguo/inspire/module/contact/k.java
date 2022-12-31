package us.pinguo.inspire.module.contact;

import java.util.List;
import rx.functions.Func1;
import us.pinguo.inspire.module.contact.ContactLoader;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class k implements Func1 {
    public static final /* synthetic */ k a = new k();

    private /* synthetic */ k() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        List list;
        list = ((ContactLoader.ThirdFriendResp) obj).list;
        return list;
    }
}
