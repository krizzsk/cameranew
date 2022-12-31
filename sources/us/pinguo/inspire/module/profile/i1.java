package us.pinguo.inspire.module.profile;

import rx.functions.Func1;
import us.pinguo.inspire.module.profile.UserInfoLoader;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class i1 implements Func1 {
    public static final /* synthetic */ i1 a = new i1();

    private /* synthetic */ i1() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        return UserInfoLoader.m((UserInfoLoader.TempUserInfo) obj);
    }
}
