package us.pinguo.inspire.module.comment;

import rx.functions.Func1;
import us.pinguo.common.network.BaseResponse;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class b implements Func1 {
    public static final /* synthetic */ b a = new b();

    private /* synthetic */ b() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        Object valueOf;
        BaseResponse baseResponse = (BaseResponse) obj;
        valueOf = Boolean.valueOf(r1.status == 200);
        return valueOf;
    }
}
