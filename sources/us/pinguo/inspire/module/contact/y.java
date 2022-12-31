package us.pinguo.inspire.module.contact;

import java.util.List;
import rx.functions.Action1;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class y implements Action1 {
    public static final /* synthetic */ y a = new y();

    private /* synthetic */ y() {
    }

    @Override // rx.functions.Action1
    public final void call(Object obj) {
        List list = (List) obj;
        us.pinguo.common.log.a.m(ContactPresenter.TAG, "friend size:" + list.size(), new Object[0]);
    }
}
