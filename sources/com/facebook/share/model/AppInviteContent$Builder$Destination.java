package com.facebook.share.model;
@Deprecated
/* loaded from: classes.dex */
public enum AppInviteContent$Builder$Destination {
    FACEBOOK("facebook"),
    MESSENGER("messenger");
    
    private final String name;

    AppInviteContent$Builder$Destination(String str) {
        this.name = str;
    }

    public boolean equalsName(String str) {
        if (str == null) {
            return false;
        }
        return this.name.equals(str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
