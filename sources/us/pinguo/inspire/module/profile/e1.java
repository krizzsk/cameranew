package us.pinguo.inspire.module.profile;

import rx.functions.Func1;
import us.pinguo.inspire.module.profile.UserInfoLoader;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class e1 implements Func1 {
    public static final /* synthetic */ e1 a = new e1();

    private /* synthetic */ e1() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        String str;
        str = ((UserInfoLoader.TempUserInfo) obj).backgroundPic;
        return str;
    }
}
