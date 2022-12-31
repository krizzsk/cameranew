package us.pinguo.performance.entity;

import java.util.List;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: GpuLadderInfo.kt */
/* loaded from: classes5.dex */
public final class GpuLadderInfo implements NoProguard {
    private final List<GpuLadderItem> gpuLadders;
    private final Long updateTime;
    private final Long version;

    public GpuLadderInfo(Long l2, Long l3, List<GpuLadderItem> list) {
        this.version = l2;
        this.updateTime = l3;
        this.gpuLadders = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GpuLadderInfo copy$default(GpuLadderInfo gpuLadderInfo, Long l2, Long l3, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            l2 = gpuLadderInfo.version;
        }
        if ((i2 & 2) != 0) {
            l3 = gpuLadderInfo.updateTime;
        }
        if ((i2 & 4) != 0) {
            list = gpuLadderInfo.gpuLadders;
        }
        return gpuLadderInfo.copy(l2, l3, list);
    }

    public final Long component1() {
        return this.version;
    }

    public final Long component2() {
        return this.updateTime;
    }

    public final List<GpuLadderItem> component3() {
        return this.gpuLadders;
    }

    public final GpuLadderInfo copy(Long l2, Long l3, List<GpuLadderItem> list) {
        return new GpuLadderInfo(l2, l3, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GpuLadderInfo) {
            GpuLadderInfo gpuLadderInfo = (GpuLadderInfo) obj;
            return s.c(this.version, gpuLadderInfo.version) && s.c(this.updateTime, gpuLadderInfo.updateTime) && s.c(this.gpuLadders, gpuLadderInfo.gpuLadders);
        }
        return false;
    }

    public final List<GpuLadderItem> getGpuLadders() {
        return this.gpuLadders;
    }

    public final Long getUpdateTime() {
        return this.updateTime;
    }

    public final Long getVersion() {
        return this.version;
    }

    public int hashCode() {
        Long l2 = this.version;
        int hashCode = (l2 == null ? 0 : l2.hashCode()) * 31;
        Long l3 = this.updateTime;
        int hashCode2 = (hashCode + (l3 == null ? 0 : l3.hashCode())) * 31;
        List<GpuLadderItem> list = this.gpuLadders;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "GpuLadderInfo(version=" + this.version + ", updateTime=" + this.updateTime + ", gpuLadders=" + this.gpuLadders + ')';
    }
}
