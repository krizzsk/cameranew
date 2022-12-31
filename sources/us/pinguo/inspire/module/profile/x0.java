package us.pinguo.inspire.module.profile;

import rx.functions.Func1;
import us.pinguo.inspire.module.profile.UserInfoLoader;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class x0 implements Func1 {
    public static final /* synthetic */ x0 a = new x0();

    private /* synthetic */ x0() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        String str;
        str = ((UserInfoLoader.TempUserInfo) obj).avatar;
        return str;
    }
}
