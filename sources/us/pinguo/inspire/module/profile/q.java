package us.pinguo.inspire.module.profile;

import rx.functions.Func1;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class q implements Func1 {
    public static final /* synthetic */ q a = new q();

    private /* synthetic */ q() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        return ProfileLoader.i((String) obj);
    }
}
