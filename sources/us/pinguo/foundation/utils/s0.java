package us.pinguo.foundation.utils;

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import rx.Subscription;
/* compiled from: WeakCompositeSubscription.java */
/* loaded from: classes4.dex */
public class s0 implements Subscription {
    private Set<WeakReference<Subscription>> a;
    private volatile boolean b;

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0046 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0009 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void b(java.util.Collection<java.lang.ref.WeakReference<rx.Subscription>> r5) {
        /*
            if (r5 != 0) goto L3
            return
        L3:
            java.util.Iterator r5 = r5.iterator()
            r0 = 0
            r1 = r0
        L9:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L55
            java.lang.Object r2 = r5.next()
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2
            if (r2 == 0) goto L26
            java.lang.Object r3 = r2.get()     // Catch: java.lang.Throwable -> L24
            if (r3 == 0) goto L26
            java.lang.Object r2 = r2.get()     // Catch: java.lang.Throwable -> L24
            rx.Subscription r2 = (rx.Subscription) r2     // Catch: java.lang.Throwable -> L24
            goto L27
        L24:
            r2 = move-exception
            goto L4a
        L26:
            r2 = r0
        L27:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L24
            r3.<init>()     // Catch: java.lang.Throwable -> L24
            java.lang.String r4 = "unsubscribe:"
            r3.append(r4)     // Catch: java.lang.Throwable -> L24
            if (r2 != 0) goto L36
            java.lang.String r4 = "null"
            goto L37
        L36:
            r4 = r2
        L37:
            r3.append(r4)     // Catch: java.lang.Throwable -> L24
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L24
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L24
            us.pinguo.common.log.a.k(r3, r4)     // Catch: java.lang.Throwable -> L24
            if (r2 == 0) goto L9
            r2.unsubscribe()     // Catch: java.lang.Throwable -> L24
            goto L9
        L4a:
            if (r1 != 0) goto L51
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
        L51:
            r1.add(r2)
            goto L9
        L55:
            rx.exceptions.Exceptions.throwIfAny(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.foundation.utils.s0.b(java.util.Collection):void");
    }

    public void a(Subscription subscription) {
        if (subscription.isUnsubscribed()) {
            return;
        }
        if (!this.b) {
            synchronized (this) {
                if (!this.b) {
                    if (this.a == null) {
                        this.a = new HashSet(4);
                    }
                    this.a.add(new WeakReference<>(subscription));
                    return;
                }
            }
        }
        subscription.unsubscribe();
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.b;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        if (this.b) {
            return;
        }
        synchronized (this) {
            if (this.b) {
                return;
            }
            this.b = true;
            Set<WeakReference<Subscription>> set = this.a;
            this.a = null;
            b(set);
        }
    }
}
