package us.pinguo.foundation.utils;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
/* compiled from: SubscriptionUtils.java */
/* loaded from: classes4.dex */
public class g0 {
    private static CompositeSubscription a;

    public static void a(Subscription subscription) {
        if (a == null) {
            a = new CompositeSubscription();
        }
        a.add(subscription);
    }

    public static void b() {
        us.pinguo.common.log.a.m("FK", "SubscriptionUtils unSubscrible", new Object[0]);
        CompositeSubscription compositeSubscription = a;
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe();
        }
        a = null;
    }
}
