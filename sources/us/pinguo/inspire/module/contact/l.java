package us.pinguo.inspire.module.contact;

import rx.functions.Func1;
import us.pinguo.inspire.module.contact.ContactLoader;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class l implements Func1 {
    public static final /* synthetic */ l a = new l();

    private /* synthetic */ l() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        Integer valueOf;
        valueOf = Integer.valueOf(r0 != null ? ((ContactLoader.AddressRedCount) obj).count : 0);
        return valueOf;
    }
}
