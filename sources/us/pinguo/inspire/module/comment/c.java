package us.pinguo.inspire.module.comment;

import rx.functions.Func1;
import us.pinguo.common.network.BaseResponse;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class c implements Func1 {
    public static final /* synthetic */ c a = new c();

    private /* synthetic */ c() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        Boolean valueOf;
        BaseResponse baseResponse = (BaseResponse) obj;
        valueOf = Boolean.valueOf(r1.status == 200);
        return valueOf;
    }
}
