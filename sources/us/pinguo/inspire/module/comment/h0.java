package us.pinguo.inspire.module.comment;

import rx.functions.Action1;
import us.pinguo.common.network.BaseResponse;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class h0 implements Action1 {
    public static final /* synthetic */ h0 a = new h0();

    private /* synthetic */ h0() {
    }

    @Override // rx.functions.Action1
    public final void call(Object obj) {
        FeedsInfoPresenter.a((BaseResponse) obj);
    }
}
