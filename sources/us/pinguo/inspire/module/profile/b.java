package us.pinguo.inspire.module.profile;

import rx.functions.Action1;
import us.pinguo.inspire.module.profile.FlowerLoader;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class b implements Action1 {
    public static final /* synthetic */ b a = new b();

    private /* synthetic */ b() {
    }

    @Override // rx.functions.Action1
    public final void call(Object obj) {
        FlowerLoader.m191refreshGiftList$lambda6((FlowerLoader.GiftResp) obj);
    }
}
