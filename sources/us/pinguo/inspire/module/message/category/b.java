package us.pinguo.inspire.module.message.category;

import rx.functions.Func1;
import us.pinguo.inspire.model.InspireMsgCountResp;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class b implements Func1 {
    public static final /* synthetic */ b a = new b();

    private /* synthetic */ b() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        InspireMsgCountResp inspireMsgCountResp = (InspireMsgCountResp) obj;
        InspireMsgLoader.c(inspireMsgCountResp);
        return inspireMsgCountResp;
    }
}
