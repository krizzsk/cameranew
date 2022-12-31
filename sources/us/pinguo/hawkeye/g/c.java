package us.pinguo.hawkeye.g;

import kotlin.jvm.internal.s;
import us.pinguo.hawkeye.model.HawkeyeModel;
/* compiled from: DefaultReporter.kt */
/* loaded from: classes4.dex */
public final class c extends b {
    @Override // us.pinguo.hawkeye.g.b
    protected String d(HawkeyeModel model) {
        s.i(model, "model");
        return model.toString();
    }

    @Override // us.pinguo.hawkeye.g.b
    protected String e() {
        return "----------HawkeyeReport----------";
    }
}
