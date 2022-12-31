package us.pinguo.inspire.module.contact;

import rx.functions.Func1;
import us.pinguo.inspire.module.profile.UserInfoLoader;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class e0 implements Func1 {
    public static final /* synthetic */ e0 a = new e0();

    private /* synthetic */ e0() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        return PhoneBindLoader.c((UserInfoLoader.TempUserInfo) obj);
    }
}
