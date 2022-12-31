package us.pinguo.hawkeye.g;

import kotlin.jvm.internal.s;
import us.pinguo.hawkeye.model.HawkeyeModel;
/* compiled from: AbstractReporter.kt */
/* loaded from: classes4.dex */
public abstract class a {
    protected abstract void a(String str);

    protected abstract String b(HawkeyeModel hawkeyeModel);

    public void c(HawkeyeModel model) {
        s.i(model, "model");
        a(b(model));
    }
}
