package us.pinguo.inspire.module.profile;

import rx.functions.Func1;
import us.pinguo.inspire.module.profile.FlowerLoader;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class h implements Func1 {
    public static final /* synthetic */ h a = new h();

    private /* synthetic */ h() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        Integer m196sendFlower$lambda0;
        m196sendFlower$lambda0 = FlowerLoader.m196sendFlower$lambda0((FlowerLoader.SendFlowerResp) obj);
        return m196sendFlower$lambda0;
    }
}
