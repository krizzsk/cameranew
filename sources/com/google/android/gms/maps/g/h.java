package com.google.android.gms.maps.g;
/* loaded from: classes2.dex */
public final class h {
    public static byte a(Boolean bool) {
        if (bool != null) {
            return bool.booleanValue() ? (byte) 1 : (byte) 0;
        }
        return (byte) -1;
    }

    public static Boolean b(byte b) {
        if (b != 0) {
            if (b != 1) {
                return null;
            }
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
