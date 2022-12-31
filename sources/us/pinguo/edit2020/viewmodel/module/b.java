package us.pinguo.edit2020.viewmodel.module;

import java.util.List;
import us.pinguo.edit2020.bean.x;
import us.pinguo.edit2020.viewmodel.FunctionType;
/* compiled from: AIEditModule.kt */
/* loaded from: classes4.dex */
public final class b {
    private final us.pinguo.edit2020.viewmodel.module.a a = new us.pinguo.edit2020.viewmodel.module.a();
    private FunctionType b;

    /* compiled from: AIEditModule.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[FunctionType.values().length];
            iArr[FunctionType.IMAGE_RESTORATION.ordinal()] = 1;
            a = iArr;
        }
    }

    public final FunctionType a() {
        return this.b;
    }

    public final us.pinguo.edit2020.viewmodel.module.a b() {
        return this.a;
    }

    public final boolean c(FunctionType functionType) {
        if ((functionType == null ? -1 : a.a[functionType.ordinal()]) == 1) {
            List<x> h2 = this.a.h();
            return !(h2 == null || h2.isEmpty());
        }
        return false;
    }
}
