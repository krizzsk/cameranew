package us.pinguo.inspire.module.profile;

import rx.functions.Func1;
import us.pinguo.inspire.model.InspireMsgCountResp;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class l implements Func1 {
    public static final /* synthetic */ l a = new l();

    private /* synthetic */ l() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        InspireMsgCountResp inspireMsgCountResp = (InspireMsgCountResp) obj;
        InspireMsgLoader.a(inspireMsgCountResp);
        return inspireMsgCountResp;
    }
}
