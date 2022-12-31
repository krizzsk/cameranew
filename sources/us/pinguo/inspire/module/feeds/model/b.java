package us.pinguo.inspire.module.feeds.model;

import rx.functions.Func1;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class b implements Func1 {
    public static final /* synthetic */ b a = new b();

    private /* synthetic */ b() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        return FeedsFollowManager.b((PortalFollowFeeds) obj);
    }
}
