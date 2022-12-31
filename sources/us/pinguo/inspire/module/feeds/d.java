package us.pinguo.inspire.module.feeds;

import rx.functions.Func1;
import us.pinguo.inspire.module.feeds.InspireFollowFeedLoader;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class d implements Func1 {
    public static final /* synthetic */ d a = new d();

    private /* synthetic */ d() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        Integer valueOf;
        valueOf = Integer.valueOf(((InspireFollowFeedLoader.UnReadCountData) obj).unReadCount);
        return valueOf;
    }
}
