package us.pinguo.share.c;

import android.app.Activity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import us.pinguo.share.R;
import us.pinguo.share.core.PGShareInfo;
import us.pinguo.share.core.ShareSite;
import us.pinguo.share.util.ExpandShareSite;
import us.pinguo.share.util.ShareDataType;
import us.pinguo.share.util.j;
import us.pinguo.share.util.l;
import us.pinguo.ui.b.a;
/* compiled from: ShareContentProcessor.java */
/* loaded from: classes6.dex */
public abstract class e<T> {
    protected T a;
    private Map<ShareSite, l> b = new HashMap();

    /* compiled from: ShareContentProcessor.java */
    /* loaded from: classes6.dex */
    public interface a {
        void a(l lVar);

        void onError(Throwable th);
    }

    public e(T t) {
        this.a = t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void h(a.C0454a c0454a, ShareSite shareSite, a aVar, l lVar) {
        if (c0454a != null && c0454a.b()) {
            c0454a.a();
        }
        if (lVar != null && lVar.a() != null) {
            this.b.put(shareSite, lVar);
            aVar.a(lVar);
            return;
        }
        aVar.onError(new RuntimeException("process return null"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void i(a.C0454a c0454a, a aVar, Throwable th) {
        if (c0454a != null && c0454a.b()) {
            c0454a.a();
        }
        aVar.onError(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public l d(ShareSite shareSite) {
        l lVar = this.b.get(shareSite);
        return lVar != null ? lVar : a(new l(new PGShareInfo(), shareSite));
    }

    protected abstract l a(l lVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ShareDataType b();

    public abstract boolean j(ShareSite shareSite);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k */
    public Observable<l> f(l lVar, ShareSite shareSite) {
        return Observable.just(lVar);
    }

    public void l(Activity activity, final ShareSite shareSite, final a aVar) {
        if (aVar != null && j.a(shareSite)) {
            final a.C0454a b = j(shareSite) ? us.pinguo.ui.b.a.b(activity, activity.getResources().getString(R.string.please_wait)) : null;
            if (b != null) {
                b.e();
            }
            Observable.just(shareSite).map(new Func1() { // from class: us.pinguo.share.c.d
                @Override // rx.functions.Func1
                public final Object call(Object obj) {
                    return e.this.d((ShareSite) obj);
                }
            }).flatMap(new Func1() { // from class: us.pinguo.share.c.b
                @Override // rx.functions.Func1
                public final Object call(Object obj) {
                    return e.this.f(shareSite, (l) obj);
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: us.pinguo.share.c.c
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    e.this.h(b, shareSite, aVar, (l) obj);
                }
            }, new Action1() { // from class: us.pinguo.share.c.a
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    e.i(a.C0454a.this, aVar, (Throwable) obj);
                }
            });
        }
    }

    public List<ExpandShareSite> n(List<ExpandShareSite> list) {
        return list;
    }
}
