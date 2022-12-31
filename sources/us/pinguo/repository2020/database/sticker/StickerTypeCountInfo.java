package us.pinguo.repository2020.database.sticker;

import us.pinguo.foundation.utils.NoProguard;
/* compiled from: Sticker.kt */
/* loaded from: classes6.dex */
public final class StickerTypeCountInfo implements NoProguard {
    private final int gif;
    private final int st;

    public StickerTypeCountInfo(int i2, int i3) {
        this.st = i2;
        this.gif = i3;
    }

    public static /* synthetic */ StickerTypeCountInfo copy$default(StickerTypeCountInfo stickerTypeCountInfo, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = stickerTypeCountInfo.st;
        }
        if ((i4 & 2) != 0) {
            i3 = stickerTypeCountInfo.gif;
        }
        return stickerTypeCountInfo.copy(i2, i3);
    }

    public final int component1() {
        return this.st;
    }

    public final int component2() {
        return this.gif;
    }

    public final StickerTypeCountInfo copy(int i2, int i3) {
        return new StickerTypeCountInfo(i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StickerTypeCountInfo) {
            StickerTypeCountInfo stickerTypeCountInfo = (StickerTypeCountInfo) obj;
            return this.st == stickerTypeCountInfo.st && this.gif == stickerTypeCountInfo.gif;
        }
        return false;
    }

    public final int getGif() {
        return this.gif;
    }

    public final int getSt() {
        return this.st;
    }

    public int hashCode() {
        return (this.st * 31) + this.gif;
    }

    public String toString() {
        return "StickerTypeCountInfo(st=" + this.st + ", gif=" + this.gif + ')';
    }
}
