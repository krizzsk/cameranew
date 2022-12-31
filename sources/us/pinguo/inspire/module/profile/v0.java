package us.pinguo.inspire.module.profile;

import rx.functions.Func1;
import us.pinguo.inspire.module.profile.UserInfoLoader;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class v0 implements Func1 {
    public static final /* synthetic */ v0 a = new v0();

    private /* synthetic */ v0() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        return UserInfoLoader.s((UserInfoLoader.TempUserInfo) obj);
    }
}
