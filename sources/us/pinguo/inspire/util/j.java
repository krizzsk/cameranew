package us.pinguo.inspire.util;

import rx.functions.Action1;
import us.pinguo.inspire.module.attention.InspireAtentionLoader;
import us.pinguo.inspire.module.attention.InspireAttention;
import us.pinguo.inspire.util.j;
/* compiled from: AttentionUtils.java */
/* loaded from: classes9.dex */
public class j {
    private static InspireAtentionLoader a = new InspireAtentionLoader();

    /* compiled from: AttentionUtils.java */
    /* loaded from: classes9.dex */
    public interface a {
        void a(Throwable th);

        void b(InspireAttention inspireAttention);
    }

    /* compiled from: AttentionUtils.java */
    /* loaded from: classes9.dex */
    public interface b {
        void a(InspireAttention inspireAttention);

        void b(Throwable th);
    }

    public static void a(String str, String str2, us.pinguo.foundation.base.c cVar, final a aVar) {
        cVar.addSubscription(a.addAttention(str, str2).subscribe(new Action1() { // from class: us.pinguo.inspire.util.d
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                j.a.this.b((InspireAttention) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.util.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                j.d(j.a.this, (Throwable) obj);
            }
        }));
    }

    public static void b(String str, String str2, us.pinguo.foundation.base.c cVar, final b bVar) {
        cVar.addSubscription(a.cancelAttention(str, str2).subscribe(new Action1() { // from class: us.pinguo.inspire.util.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                j.b.this.a((InspireAttention) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.util.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                j.f(j.b.this, (Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(a aVar, Throwable th) {
        d.f.a.b.d.c(th);
        us.pinguo.foundation.e.e(th);
        aVar.a(th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(b bVar, Throwable th) {
        d.f.a.b.d.c(th);
        us.pinguo.foundation.e.e(th);
        bVar.b(th);
    }
}
