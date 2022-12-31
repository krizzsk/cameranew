package us.pinguo.inspire.model;

import rx.functions.Func1;
import us.pinguo.inspire.model.InspireWorkBulkLoader;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class s implements Func1 {
    public static final /* synthetic */ s a = new s();

    private /* synthetic */ s() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        Integer valueOf;
        valueOf = Integer.valueOf(((InspireWorkBulkLoader.ShareFlowerResp) obj).flower);
        return valueOf;
    }
}
