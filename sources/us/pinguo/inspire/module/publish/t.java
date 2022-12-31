package us.pinguo.inspire.module.publish;

import rx.Observable;
import rx.Subscriber;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class t implements Observable.OnSubscribe {
    public static final /* synthetic */ t a = new t();

    private /* synthetic */ t() {
    }

    @Override // rx.functions.Action1
    public final void call(Object obj) {
        ((Subscriber) obj).onError(new UploadFileException());
    }
}
