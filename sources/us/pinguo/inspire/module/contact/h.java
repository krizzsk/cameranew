package us.pinguo.inspire.module.contact;

import rx.functions.Func1;
import us.pinguo.inspire.module.contact.ContactLoader;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class h implements Func1 {
    public static final /* synthetic */ h a = new h();

    private /* synthetic */ h() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        return ContactLoader.e((ContactLoader.AddBookResp) obj);
    }
}
