package us.pinguo.loc;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;
import us.pinguo.foundation.utils.j0;
import us.pinguo.poker.R;
/* loaded from: classes5.dex */
public class EffectLocManager {
    private Subscription a;
    private CompositeSubscription b;
    private v c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f11539d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, Boolean> f11540e;

    /* loaded from: classes5.dex */
    public static class EmptyException extends RuntimeException {
    }

    /* loaded from: classes5.dex */
    public static class NoFaceDetectedException extends RuntimeException {
        public NoFaceDetectedException() {
        }

        public NoFaceDetectedException(String str) {
            super(str);
        }
    }

    /* loaded from: classes5.dex */
    public static class PokerException extends RuntimeException {
    }

    /* loaded from: classes5.dex */
    public static class TaskCancelException extends RuntimeException {
        public TaskCancelException() {
        }

        public TaskCancelException(String str) {
            super(str);
        }

        public TaskCancelException(Throwable th) {
            super(th);
        }
    }

    /* loaded from: classes5.dex */
    class a implements Runnable {
        final /* synthetic */ m a;

        /* renamed from: us.pinguo.loc.EffectLocManager$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class C0420a implements us.pinguo.poker.n {
            String a = null;

            /* renamed from: us.pinguo.loc.EffectLocManager$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            class RunnableC0421a implements Runnable {
                final /* synthetic */ String a;

                RunnableC0421a(String str) {
                    this.a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    byte[] j2 = us.pinguo.poker.o.j(C0420a.this.a, this.a, 65);
                    if (EffectLocManager.this.f11539d) {
                        us.pinguo.foundation.r.d.a().b(new n());
                        a.this.a.e(new TaskCancelException());
                        return;
                    }
                    us.pinguo.util.k.i(a.this.a.a, j2);
                    a aVar = a.this;
                    EffectLocManager.this.h(aVar.a);
                }
            }

            C0420a() {
            }

            @Override // us.pinguo.poker.n
            public void a(byte[] bArr, String str) {
                if (EffectLocManager.this.f11539d) {
                    us.pinguo.foundation.r.d.a().b(new n());
                    a.this.a.e(new TaskCancelException());
                    return;
                }
                us.pinguo.foundation.utils.f.b(new RunnableC0421a(str));
            }

            @Override // us.pinguo.poker.n
            public void b(int i2, String str) {
                us.pinguo.foundation.r.d.a().b(new n());
                a.this.a.e(new PokerException());
            }

            @Override // us.pinguo.poker.n
            public void c(us.pinguo.poker.s sVar) {
                this.a = sVar.b;
            }
        }

        a(m mVar) {
            this.a = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.g();
                SystemClock.sleep(1000L);
                m mVar = this.a;
                us.pinguo.poker.o.e().d(new us.pinguo.poker.m(mVar.a, mVar.f11543f, 0), new C0420a());
            } catch (Exception e2) {
                us.pinguo.foundation.r.d.a().b(new n());
                this.a.e(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Observable.OnSubscribe<Bitmap[]> {
        final /* synthetic */ m a;

        b(m mVar) {
            this.a = mVar;
        }

        @Override // rx.functions.Action1
        /* renamed from: a */
        public void call(Subscriber<? super Bitmap[]> subscriber) {
            try {
                this.a.g();
                us.pinguo.foundation.r.d.a().b(new o(10));
                if (!EffectLocManager.this.f(0)) {
                    EffectLocManager effectLocManager = EffectLocManager.this;
                    String b = this.a.b();
                    String d2 = this.a.d();
                    String c = this.a.c();
                    final m mVar = this.a;
                    String str = mVar.f11541d;
                    long j2 = mVar.f11542e;
                    Objects.requireNonNull(mVar);
                    effectLocManager.c = new v(b, d2, c, str, j2, new p() { // from class: us.pinguo.loc.a
                        @Override // us.pinguo.loc.p
                        public final us.pinguo.facedetector.c a(Bitmap bitmap) {
                            return m.this.a(bitmap);
                        }
                    });
                    EffectLocManager.this.c.a(false);
                    EffectLocManager.this.c.f(subscriber);
                    return;
                }
                throw new TaskCancelException();
            } catch (Throwable th) {
                subscriber.onError(th);
            }
        }
    }

    /* loaded from: classes5.dex */
    private static class c {
        private static EffectLocManager a = new EffectLocManager(null);
    }

    /* synthetic */ EffectLocManager(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(int i2) {
        if (this.f11539d) {
            us.pinguo.common.log.a.k("取消作图任务,当前步骤：" + i2, new Object[0]);
            return true;
        }
        return false;
    }

    public static EffectLocManager getInstance() {
        return c.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final m mVar) {
        if (this.f11539d) {
            this.f11539d = false;
            mVar.e(new TaskCancelException());
            us.pinguo.foundation.r.d.a().b(new n());
            return;
        }
        try {
            t.l(us.pinguo.foundation.e.b());
            Subscription subscription = this.a;
            if (subscription != null && !subscription.isUnsubscribed()) {
                this.a.unsubscribe();
                CompositeSubscription compositeSubscription = this.b;
                if (compositeSubscription != null) {
                    compositeSubscription.remove(this.a);
                }
            }
            us.pinguo.foundation.r.d.a().b(new o(0));
            this.a = Observable.create(new b(mVar)).subscribeOn(u.b).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: us.pinguo.loc.c
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    EffectLocManager.this.k(mVar, (Bitmap[]) obj);
                }
            }, new Action1() { // from class: us.pinguo.loc.b
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    EffectLocManager.this.m(mVar, (Throwable) obj);
                }
            });
            if (this.b == null) {
                this.b = new CompositeSubscription();
            }
            this.b.add(this.a);
        } catch (UnsatisfiedLinkError e2) {
            t.u(us.pinguo.foundation.e.b(), false);
            mVar.e(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void k(m mVar, Bitmap[] bitmapArr) {
        v vVar = this.c;
        if (vVar != null) {
            vVar.a(false);
            this.c = null;
        }
        if (f(4)) {
            this.f11539d = false;
            mVar.e(new TaskCancelException());
            us.pinguo.foundation.r.d.a().b(new n());
            return;
        }
        us.pinguo.foundation.r.d.a().b(new o(100));
        mVar.f(bitmapArr[1], bitmapArr[0]);
        Boolean bool = this.f11540e.get(mVar.d());
        if (bool == null || !bool.booleanValue()) {
            return;
        }
        j0.d(us.pinguo.foundation.e.b().getString(R.string.loc_face_too_more));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void m(m mVar, Throwable th) {
        v vVar = this.c;
        if (vVar != null) {
            vVar.a(false);
            this.c = null;
        }
        us.pinguo.common.log.a.m("EffectLocManager", "doEffectLocAsyncImpl-ERROR", new Object[0]);
        us.pinguo.foundation.r.d.a().b(new n());
        us.pinguo.common.log.a.f(th);
        mVar.e(th);
    }

    public void g(m mVar) {
        if (this.f11539d) {
            us.pinguo.common.log.a.m("EffectLocManager", "doEffectLocAsync", new Object[0]);
            this.f11539d = false;
            mVar.e(new TaskCancelException());
            us.pinguo.foundation.r.d.a().b(new n());
        } else if (TextUtils.isEmpty(mVar.f11543f)) {
            h(mVar);
        } else {
            us.pinguo.poker.o.e();
            us.pinguo.foundation.r.d.a().b(new o(0, LocLoadingState.NET_MAKING));
            us.pinguo.foundation.utils.f.b(new a(mVar));
        }
    }

    public Map<String, Boolean> i() {
        return this.f11540e;
    }

    public void n(boolean z) {
        this.f11539d = z;
    }

    private EffectLocManager() {
        this.b = null;
        this.c = null;
        this.f11539d = false;
        this.f11540e = new ConcurrentHashMap();
    }
}
