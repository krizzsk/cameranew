package us.pinguo.inspire.util;

import rx.functions.Func1;
import us.pinguo.inspire.module.publish.vo.SelectLocResp;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class e implements Func1 {
    public static final /* synthetic */ e a = new e();

    private /* synthetic */ e() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        SelectLocResp selectLocResp = (SelectLocResp) obj;
        InspireLocationManager.b(selectLocResp);
        return selectLocResp;
    }
}
