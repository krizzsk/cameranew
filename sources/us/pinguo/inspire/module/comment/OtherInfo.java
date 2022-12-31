package us.pinguo.inspire.module.comment;
/* compiled from: RecLoader.kt */
/* loaded from: classes9.dex */
public final class OtherInfo {
    private final String bucketName;

    public OtherInfo(String bucketName) {
        kotlin.jvm.internal.s.h(bucketName, "bucketName");
        this.bucketName = bucketName;
    }

    public static /* synthetic */ OtherInfo copy$default(OtherInfo otherInfo, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = otherInfo.bucketName;
        }
        return otherInfo.copy(str);
    }

    public final String component1() {
        return this.bucketName;
    }

    public final OtherInfo copy(String bucketName) {
        kotlin.jvm.internal.s.h(bucketName, "bucketName");
        return new OtherInfo(bucketName);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OtherInfo) && kotlin.jvm.internal.s.c(this.bucketName, ((OtherInfo) obj).bucketName);
    }

    public final String getBucketName() {
        return this.bucketName;
    }

    public int hashCode() {
        return this.bucketName.hashCode();
    }

    public String toString() {
        return "OtherInfo(bucketName=" + this.bucketName + ')';
    }
}
