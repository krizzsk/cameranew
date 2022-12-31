package cn.sharesdk.onekeyshare;

import cn.sharesdk.onekeyshare.themes.classic.ClassicTheme;
/* loaded from: classes.dex */
public enum OnekeyShareTheme {
    CLASSIC(0, new ClassicTheme());
    
    private final OnekeyShareThemeImpl impl;
    private final int value;

    OnekeyShareTheme(int i2, OnekeyShareThemeImpl onekeyShareThemeImpl) {
        this.value = i2;
        this.impl = onekeyShareThemeImpl;
    }

    public static OnekeyShareTheme fromValue(int i2) {
        OnekeyShareTheme[] values;
        for (OnekeyShareTheme onekeyShareTheme : values()) {
            if (onekeyShareTheme.value == i2) {
                return onekeyShareTheme;
            }
        }
        return CLASSIC;
    }

    public OnekeyShareThemeImpl getImpl() {
        return this.impl;
    }

    public int getValue() {
        return this.value;
    }
}
