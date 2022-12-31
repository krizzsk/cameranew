package us.pinguo.inspire.router;

import us.pinguo.inspire.model.InspireTask;
import us.pinguo.librouter.module.inspire.f;
/* compiled from: TaskInterfaceImpl.java */
/* loaded from: classes9.dex */
public class c implements f {
    @Override // us.pinguo.librouter.module.inspire.f
    public int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return ((InspireTask) obj).picSum;
    }

    @Override // us.pinguo.librouter.module.inspire.f
    public String b(Object obj) {
        return obj == null ? "" : ((InspireTask) obj).taskCover;
    }

    @Override // us.pinguo.librouter.module.inspire.f
    public String c(Object obj) {
        return obj == null ? "" : ((InspireTask) obj).shortDesc;
    }
}
