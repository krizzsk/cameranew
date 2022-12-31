package us.pinguo.repository2020.api;

import java.util.Map;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import us.pinguo.common.network.RxVolley;
import us.pinguo.common.network.pgrequest.PGRequest;
import us.pinguo.repository2020.utils.h;
/* compiled from: C360CommonRequest.kt */
/* loaded from: classes6.dex */
public final class c<T> {
    private final PGRequest.Builder<T> a;

    public c(String url, Class<T> resType) {
        s.h(url, "url");
        s.h(resType, "resType");
        PGRequest.Builder<T> builder = new PGRequest.Builder<>(resType);
        this.a = builder;
        builder.withMethod(1).withDomain(h.c()).withUriPath(url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(p pVar, Object obj) {
        if (pVar == null) {
            return;
        }
        pVar.invoke(obj, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(p pVar, Throwable th) {
        if (pVar == null) {
            return;
        }
        pVar.invoke(null, th);
    }

    public final void a(String key, String value) {
        s.h(key, "key");
        s.h(value, "value");
        this.a.addParam(key, value);
    }

    public final void b(Map<String, String> params) {
        s.h(params, "params");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            this.a.addParam(entry.getKey(), entry.getValue());
        }
    }

    public final void c(final p<? super T, ? super Throwable, u> pVar) {
        RxVolley.createSync(this.a.build()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: us.pinguo.repository2020.api.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                c.d(p.this, obj);
            }
        }, new Action1() { // from class: us.pinguo.repository2020.api.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                c.e(p.this, (Throwable) obj);
            }
        });
    }
}
