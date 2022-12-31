package us.pinguo.hawkeye.g;

import kotlin.jvm.internal.s;
import us.pinguo.hawkeye.model.HawkeyeModel;
/* compiled from: BaseInfoLogReporter.kt */
/* loaded from: classes4.dex */
public abstract class b extends d {
    @Override // us.pinguo.hawkeye.g.a
    protected String b(HawkeyeModel model) {
        s.i(model, "model");
        return "Hawkeye\n" + e() + "\n" + d(model) + "\n" + e();
    }

    protected abstract String d(HawkeyeModel hawkeyeModel);

    protected abstract String e();
}
