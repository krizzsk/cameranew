package us.pinguo.inspire.module.profile;

import rx.functions.Func1;
import us.pinguo.inspire.module.profile.UserInfoLoader;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class f1 implements Func1 {
    public static final /* synthetic */ f1 a = new f1();

    private /* synthetic */ f1() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        return UserInfoLoader.p((UserInfoLoader.TempUserInfo) obj);
    }
}
