package us.pinguo.u3dengine.edit;

import java.util.ArrayList;
import kotlin.jvm.internal.s;
/* compiled from: UnityEditData.kt */
/* loaded from: classes6.dex */
public final class AdjustRenderData {
    private final ArrayList<NativeAdjustEntity> adjust;

    public AdjustRenderData(ArrayList<NativeAdjustEntity> adjust) {
        s.h(adjust, "adjust");
        this.adjust = adjust;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdjustRenderData copy$default(AdjustRenderData adjustRenderData, ArrayList arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = adjustRenderData.adjust;
        }
        return adjustRenderData.copy(arrayList);
    }

    public final ArrayList<NativeAdjustEntity> component1() {
        return this.adjust;
    }

    public final AdjustRenderData copy(ArrayList<NativeAdjustEntity> adjust) {
        s.h(adjust, "adjust");
        return new AdjustRenderData(adjust);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AdjustRenderData) && s.c(this.adjust, ((AdjustRenderData) obj).adjust);
    }

    public final ArrayList<NativeAdjustEntity> getAdjust() {
        return this.adjust;
    }

    public int hashCode() {
        return this.adjust.hashCode();
    }

    public String toString() {
        return "AdjustRenderData(adjust=" + this.adjust + ')';
    }
}
