package us.pinguo.inspire.module.publish;

import rx.Observable;
import rx.Subscriber;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class q0 implements Observable.OnSubscribe {
    public static final /* synthetic */ q0 a = new q0();

    private /* synthetic */ q0() {
    }

    @Override // rx.functions.Action1
    public final void call(Object obj) {
        ((Subscriber) obj).onError(new UploadFileException());
    }
}
