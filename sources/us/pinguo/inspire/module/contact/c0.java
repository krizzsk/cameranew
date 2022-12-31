package us.pinguo.inspire.module.contact;

import rx.functions.Func1;
import us.pinguo.inspire.module.profile.UserInfoLoader;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class c0 implements Func1 {
    public static final /* synthetic */ c0 a = new c0();

    private /* synthetic */ c0() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        return PhoneBindLoader.l((UserInfoLoader.TempUserInfo) obj);
    }
}
