package com.pinguo.lib;

import us.pinguo.foundation.utils.n0;
/* loaded from: classes3.dex */
public final class PGDisplayUtils {
    public static int getAbsoluteWidth() {
        int i2 = n0.i();
        int h2 = n0.h();
        if (i2 >= h2) {
            i2 = h2;
        }
        if (i2 <= 240 || i2 >= 4000) {
            us.pinguo.common.log.a.u("", "Error get absolute width, set to:480", new Object[0]);
            return 480;
        }
        return i2;
    }

    public static com.pinguo.camera360.k.a.a.a.b getDisplaySize() {
        return new com.pinguo.camera360.k.a.a.a.b(n0.i(), n0.h());
    }

    public static int getPreviewLength() {
        int i2 = n0.i();
        int h2 = n0.h();
        if (i2 <= h2) {
            i2 = h2;
        }
        if (i2 < 400) {
            return 400;
        }
        return i2 > 1920 ? (int) ((i2 * 0.75f) + 0.5f) : i2;
    }
}
