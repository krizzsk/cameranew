package us.pinguo.inspire.module.masterlist;

import rx.functions.Func1;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class b implements Func1 {
    public static final /* synthetic */ b a = new b();

    private /* synthetic */ b() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        MasterListData masterListData = (MasterListData) obj;
        MasterBindLoader.b(masterListData);
        return masterListData;
    }
}
