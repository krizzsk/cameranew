package us.pinguo.inspire.base.easyload;

import android.text.TextUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.Payload;
import us.pinguo.user.s0;
/* compiled from: InspireCommonLoader.java */
/* loaded from: classes9.dex */
public class l<T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InspireCommonLoader.java */
    /* loaded from: classes9.dex */
    public class a implements Observable.OnSubscribe<T> {
        final /* synthetic */ String a;
        final /* synthetic */ Type b;

        a(l lVar, String str, Type type) {
            this.a = str;
            this.b = type;
        }

        @Override // rx.functions.Action1
        /* renamed from: a */
        public void call(Subscriber<? super T> subscriber) {
            T t = (Object) null;
            try {
                BaseResponse baseResponse = (BaseResponse) new k(s0.getInstance().getUserId(), this.a, this.b).getObject();
                if (baseResponse != null) {
                    t = baseResponse.data;
                }
            } catch (IOException e2) {
                Inspire.f(e2);
            }
            subscriber.onNext(t);
            subscriber.onCompleted();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InspireCommonLoader.java */
    /* loaded from: classes9.dex */
    public class b extends Inspire.d<BaseResponse<T>> {
        b(l lVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object c(String str, Type type, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                BaseResponse baseResponse = new BaseResponse();
                baseResponse.data = obj;
                new k(s0.getInstance().getUserId(), str, type).putObject(baseResponse);
            } catch (Exception e2) {
                Inspire.f(e2);
            }
        }
        return obj;
    }

    public Observable<T> a(String str, Type type) {
        return Observable.create(new a(this, str, type)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<T> b(String str, HashMap<String, String> hashMap, final String str2, final Type type) {
        return us.pinguo.foundation.m.f.a(new b(this).url(str).type(type).put(hashMap).build()).map(new Payload()).map(new Func1() { // from class: us.pinguo.inspire.base.easyload.i
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                l.c(str2, type, obj);
                return obj;
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }
}
