package us.pinguo.inspire.module.profile;

import java.util.List;
import rx.functions.Func1;
import us.pinguo.inspire.module.profile.FlowerLoader;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class c implements Func1 {
    public static final /* synthetic */ c a = new c();

    private /* synthetic */ c() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        FlowerLoader.GiftResp m190refreshGiftList$lambda5;
        m190refreshGiftList$lambda5 = FlowerLoader.m190refreshGiftList$lambda5((List) obj);
        return m190refreshGiftList$lambda5;
    }
}
