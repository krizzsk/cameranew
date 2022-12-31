package us.pinguo.inspire.module.profile;

import rx.functions.Func1;
import us.pinguo.inspire.module.profile.InspireFollowFeedLoader;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class k implements Func1 {
    public static final /* synthetic */ k a = new k();

    private /* synthetic */ k() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        Integer valueOf;
        valueOf = Integer.valueOf(((InspireFollowFeedLoader.UnReadCountData) obj).unReadCount);
        return valueOf;
    }
}
