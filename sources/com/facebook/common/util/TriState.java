package com.facebook.common.util;

import javax.annotation.Nullable;
/* loaded from: classes.dex */
public enum TriState {
    YES,
    NO,
    UNSET;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[TriState.values().length];
            a = iArr;
            try {
                iArr[TriState.YES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[TriState.NO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[TriState.UNSET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static TriState fromDbValue(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                return UNSET;
            }
            return NO;
        }
        return YES;
    }

    public boolean asBoolean() {
        int i2 = a.a[ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    throw new IllegalStateException("Unrecognized TriState value: " + this);
                }
                throw new IllegalStateException("No boolean equivalent for UNSET");
            }
            return false;
        }
        return true;
    }

    @Nullable
    public Boolean asBooleanObject() {
        int i2 = a.a[ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return null;
                }
                throw new IllegalStateException("Unrecognized TriState value: " + this);
            }
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public int getDbValue() {
        int i2 = a.a[ordinal()];
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2) {
                return 3;
            }
        }
        return i3;
    }

    public boolean isSet() {
        return this != UNSET;
    }

    public static TriState valueOf(boolean z) {
        return z ? YES : NO;
    }

    public static TriState valueOf(@Nullable Boolean bool) {
        return bool != null ? valueOf(bool.booleanValue()) : UNSET;
    }

    public boolean asBoolean(boolean z) {
        int i2 = a.a[ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return z;
                }
                throw new IllegalStateException("Unrecognized TriState value: " + this);
            }
            return false;
        }
        return true;
    }
}
