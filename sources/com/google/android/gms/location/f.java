package com.google.android.gms.location;

import com.google.android.gms.common.api.Status;
@Deprecated
/* loaded from: classes2.dex */
public final class f {
    public static int a(int i2) {
        if ((i2 < 0 || i2 > 1) && (1000 > i2 || i2 > 1002)) {
            return 1;
        }
        return i2;
    }

    public static Status b(int i2) {
        if (i2 == 1) {
            i2 = 13;
        }
        return new Status(i2);
    }
}
