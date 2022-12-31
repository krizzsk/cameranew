package us.pinguo.inspire.module.profile;

import rx.functions.Func1;
import us.pinguo.inspire.module.profile.UserInfoLoader;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class c1 implements Func1 {
    public static final /* synthetic */ c1 a = new c1();

    private /* synthetic */ c1() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        return UserInfoLoader.v((UserInfoLoader.TempUserInfo) obj);
    }
}
