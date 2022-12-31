package us.pinguo.repository2020.database.sticker;

import us.pinguo.foundation.utils.NoProguard;
/* compiled from: StickerDetail.kt */
/* loaded from: classes6.dex */
public final class DetailTypeCountInfo implements NoProguard {
    private final int ust;

    public DetailTypeCountInfo(int i2) {
        this.ust = i2;
    }

    public static /* synthetic */ DetailTypeCountInfo copy$default(DetailTypeCountInfo detailTypeCountInfo, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = detailTypeCountInfo.ust;
        }
        return detailTypeCountInfo.copy(i2);
    }

    public final int component1() {
        return this.ust;
    }

    public final DetailTypeCountInfo copy(int i2) {
        return new DetailTypeCountInfo(i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DetailTypeCountInfo) && this.ust == ((DetailTypeCountInfo) obj).ust;
    }

    public final int getUst() {
        return this.ust;
    }

    public int hashCode() {
        return this.ust;
    }

    public String toString() {
        return "DetailTypeCountInfo(ust=" + this.ust + ')';
    }
}
