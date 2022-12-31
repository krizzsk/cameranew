package us.pinguo.inspire.module.contact;

import java.util.List;
import rx.functions.Func1;
import us.pinguo.inspire.module.contact.ContactLoader;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class m implements Func1 {
    public static final /* synthetic */ m a = new m();

    private /* synthetic */ m() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        List list;
        list = ((ContactLoader.AddBookResp) obj).list;
        return list;
    }
}
