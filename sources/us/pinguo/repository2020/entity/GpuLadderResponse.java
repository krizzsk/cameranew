package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
import us.pinguo.performance.entity.GpuLadderInfo;
/* compiled from: GpuLadderResponse.kt */
/* loaded from: classes6.dex */
public final class GpuLadderResponse implements NoProguard {
    private final GpuLadderInfo gpuLadderData;

    public GpuLadderResponse(GpuLadderInfo gpuLadderInfo) {
        this.gpuLadderData = gpuLadderInfo;
    }

    public static /* synthetic */ GpuLadderResponse copy$default(GpuLadderResponse gpuLadderResponse, GpuLadderInfo gpuLadderInfo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            gpuLadderInfo = gpuLadderResponse.gpuLadderData;
        }
        return gpuLadderResponse.copy(gpuLadderInfo);
    }

    public final GpuLadderInfo component1() {
        return this.gpuLadderData;
    }

    public final GpuLadderResponse copy(GpuLadderInfo gpuLadderInfo) {
        return new GpuLadderResponse(gpuLadderInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GpuLadderResponse) && s.c(this.gpuLadderData, ((GpuLadderResponse) obj).gpuLadderData);
    }

    public final GpuLadderInfo getGpuLadderData() {
        return this.gpuLadderData;
    }

    public int hashCode() {
        GpuLadderInfo gpuLadderInfo = this.gpuLadderData;
        if (gpuLadderInfo == null) {
            return 0;
        }
        return gpuLadderInfo.hashCode();
    }

    public String toString() {
        return "GpuLadderResponse(gpuLadderData=" + this.gpuLadderData + ')';
    }
}
