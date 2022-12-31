package us.pinguo.inspire.module.masterlist;

import rx.functions.Func1;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class a implements Func1 {
    public static final /* synthetic */ a a = new a();

    private /* synthetic */ a() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        MasterCheckData masterCheckData = (MasterCheckData) obj;
        MasterBindLoader.a(masterCheckData);
        return masterCheckData;
    }
}
