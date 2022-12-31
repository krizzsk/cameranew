package us.pinguo.inspire.cell.recycler;

import rx.Subscription;
import us.pinguo.foundation.utils.h;
import us.pinguo.widget.common.cell.recycler.c;
/* compiled from: SubscriptionRecyclerCell.java */
/* loaded from: classes9.dex */
public abstract class e<T, VH extends us.pinguo.widget.common.cell.recycler.c> extends us.pinguo.widget.common.cell.recycler.b<T, VH> implements us.pinguo.foundation.base.c {
    public e(T t) {
        super(t);
    }

    @Override // us.pinguo.foundation.base.c
    public void addSubscription(Subscription subscription) {
        h.a(subscription);
    }
}
