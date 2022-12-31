package us.pinguo.performance.entity;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: GpuLadderInfo.kt */
/* loaded from: classes5.dex */
public final class GpuLadderItem implements NoProguard {
    private final Integer centurionMark;
    private final String gpuName;
    private final String gpuRegex;
    private final String socName;
    private final String socRegex;

    public GpuLadderItem(String str, String str2, String str3, String str4, Integer num) {
        this.gpuName = str;
        this.gpuRegex = str2;
        this.socName = str3;
        this.socRegex = str4;
        this.centurionMark = num;
    }

    public static /* synthetic */ GpuLadderItem copy$default(GpuLadderItem gpuLadderItem, String str, String str2, String str3, String str4, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = gpuLadderItem.gpuName;
        }
        if ((i2 & 2) != 0) {
            str2 = gpuLadderItem.gpuRegex;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = gpuLadderItem.socName;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = gpuLadderItem.socRegex;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            num = gpuLadderItem.centurionMark;
        }
        return gpuLadderItem.copy(str, str5, str6, str7, num);
    }

    public final String component1() {
        return this.gpuName;
    }

    public final String component2() {
        return this.gpuRegex;
    }

    public final String component3() {
        return this.socName;
    }

    public final String component4() {
        return this.socRegex;
    }

    public final Integer component5() {
        return this.centurionMark;
    }

    public final GpuLadderItem copy(String str, String str2, String str3, String str4, Integer num) {
        return new GpuLadderItem(str, str2, str3, str4, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GpuLadderItem) {
            GpuLadderItem gpuLadderItem = (GpuLadderItem) obj;
            return s.c(this.gpuName, gpuLadderItem.gpuName) && s.c(this.gpuRegex, gpuLadderItem.gpuRegex) && s.c(this.socName, gpuLadderItem.socName) && s.c(this.socRegex, gpuLadderItem.socRegex) && s.c(this.centurionMark, gpuLadderItem.centurionMark);
        }
        return false;
    }

    public final Integer getCenturionMark() {
        return this.centurionMark;
    }

    public final String getGpuName() {
        return this.gpuName;
    }

    public final String getGpuRegex() {
        return this.gpuRegex;
    }

    public final String getSocName() {
        return this.socName;
    }

    public final String getSocRegex() {
        return this.socRegex;
    }

    public int hashCode() {
        String str = this.gpuName;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.gpuRegex;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.socName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.socRegex;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.centurionMark;
        return hashCode4 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "GpuLadderItem(gpuName=" + ((Object) this.gpuName) + ", gpuRegex=" + ((Object) this.gpuRegex) + ", socName=" + ((Object) this.socName) + ", socRegex=" + ((Object) this.socRegex) + ", centurionMark=" + this.centurionMark + ')';
    }
}
