package us.pinguo.repository2020.manager;

import java.io.File;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.s;
import us.pinguo.u3dengine.edit.AdjustRenderData;
import us.pinguo.u3dengine.edit.NativeAdjustEntity;
/* compiled from: AdjustRepository.kt */
/* loaded from: classes6.dex */
public final class AdjustRepository {
    public static final AdjustRepository a = new AdjustRepository();
    private static final kotlin.f b;
    private static final kotlin.f c;

    static {
        kotlin.f a2;
        kotlin.f a3;
        s.q(us.pinguo.foundation.e.b().getFilesDir().getAbsolutePath(), File.separator);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        a2 = kotlin.h.a(lazyThreadSafetyMode, AdjustRepository$adjustment$2.INSTANCE);
        b = a2;
        a3 = kotlin.h.a(lazyThreadSafetyMode, AdjustRepository$adjustRenderData$2.INSTANCE);
        c = a3;
    }

    private AdjustRepository() {
    }

    public final AdjustRenderData a() {
        return (AdjustRenderData) c.getValue();
    }

    public final NativeAdjustEntity[] b() {
        return (NativeAdjustEntity[]) b.getValue();
    }
}
