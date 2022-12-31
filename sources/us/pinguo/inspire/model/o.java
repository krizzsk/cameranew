package us.pinguo.inspire.model;

import rx.functions.Func1;
import us.pinguo.inspire.api.EmptyResponse;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class o implements Func1 {
    public static final /* synthetic */ o a = new o();

    private /* synthetic */ o() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        Boolean valueOf;
        EmptyResponse emptyResponse = (EmptyResponse) obj;
        valueOf = Boolean.valueOf(r1.status == 200);
        return valueOf;
    }
}
