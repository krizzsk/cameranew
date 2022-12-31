package us.pinguo.inspire.module.comment;
/* compiled from: RoseLoader.kt */
/* loaded from: classes9.dex */
public final class RoseResp {
    private final int roseNum;

    public RoseResp(int i2) {
        this.roseNum = i2;
    }

    public static /* synthetic */ RoseResp copy$default(RoseResp roseResp, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = roseResp.roseNum;
        }
        return roseResp.copy(i2);
    }

    public final int component1() {
        return this.roseNum;
    }

    public final RoseResp copy(int i2) {
        return new RoseResp(i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RoseResp) && this.roseNum == ((RoseResp) obj).roseNum;
    }

    public final int getRoseNum() {
        return this.roseNum;
    }

    public int hashCode() {
        return this.roseNum;
    }

    public String toString() {
        return "RoseResp(roseNum=" + this.roseNum + ')';
    }
}
