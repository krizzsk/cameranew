package us.pinguo.repository2020.database.staticsticker;
/* compiled from: StaticStickerDetail.kt */
/* loaded from: classes6.dex */
public enum StickerLocationType {
    Center(-1),
    Relative(0),
    Face(1),
    Frame(2);
    
    private final int value;

    StickerLocationType(int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }
}
