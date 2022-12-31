package us.pinguo.inspire.model;

import rx.Observable;
import rx.functions.Func1;
import us.pinguo.inspire.model.EmoticonLoader;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class a implements Func1 {
    public static final /* synthetic */ a a = new a();

    private /* synthetic */ a() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        Observable just;
        just = Observable.just(r0 == null ? null : ((EmoticonLoader.EmoticonData) obj).list);
        return just;
    }
}
