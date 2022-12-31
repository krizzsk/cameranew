package us.pinguo.common.filter;
/* compiled from: ChangeStatus.kt */
/* loaded from: classes4.dex */
public enum ChangeStatus {
    INIT(false, false),
    CLICK_LEFT(true, true),
    CLICK_RIGHT(true, false),
    CLICK_SKIP_PACKAGE(true, false),
    SLIDE_LEFT(true, true),
    SLIDE_RIGHT(true, false),
    GOTO(true, true),
    RECOVER(true, true),
    STICKER_ON(false, false),
    STICKER_OFF(false, false);
    
    private final boolean moveLeft;
    private final boolean showTips;

    ChangeStatus(boolean z, boolean z2) {
        this.showTips = z;
        this.moveLeft = z2;
    }

    public final boolean getMoveLeft() {
        return this.moveLeft;
    }

    public final boolean getShowTips() {
        return this.showTips;
    }
}
