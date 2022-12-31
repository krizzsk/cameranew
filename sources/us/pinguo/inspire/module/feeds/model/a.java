package us.pinguo.inspire.module.feeds.model;

import rx.functions.Func1;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class a implements Func1 {
    public static final /* synthetic */ a a = new a();

    private /* synthetic */ a() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        return FeedsFollowManager.sSp = ((PortalFollowFeeds) obj).sp;
    }
}
