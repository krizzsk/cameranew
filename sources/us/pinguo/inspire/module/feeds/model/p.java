package us.pinguo.inspire.module.feeds.model;

import java.util.List;
import rx.functions.Func1;
import us.pinguo.inspire.module.feeds.model.InspireFeedLoader;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class p implements Func1 {
    public static final /* synthetic */ p a = new p();

    private /* synthetic */ p() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        List list;
        list = ((InspireFeedLoader.InspireFollowAndLikeDetailData) obj).list;
        return list;
    }
}
