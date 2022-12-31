package us.pinguo.u3dengine.edit;

import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* compiled from: UnityEditData.kt */
/* loaded from: classes6.dex */
public enum HSLAdjustColor {
    None(0, PortalFollowFeeds.TYPE_NONE),
    Red(1, "hsl_red"),
    Orange(2, "hsl_orange"),
    Yellow(3, "hsl_yellow"),
    Green(4, "hsl_green"),
    Cyan(5, "hsl_cyan"),
    Blue(6, "hsl_blue"),
    Purple(7, "hsl_purple"),
    Magenta(8, "hsl_magenta");
    
    private final String colorKey;
    private final int colorType;

    HSLAdjustColor(int i2, String str) {
        this.colorType = i2;
        this.colorKey = str;
    }

    public final String getColorKey() {
        return this.colorKey;
    }

    public final int getColorType() {
        return this.colorType;
    }
}
