package com.tapjoy.internal;

import java.util.List;
/* loaded from: classes3.dex */
public final class aw {
    public static void a(List list, int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 <= 0) {
            return;
        }
        int size = list.size();
        if (i2 > size) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == size) {
            list.clear();
            return;
        }
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                return;
            }
            list.remove(0);
            i2 = i3;
        }
    }
}
