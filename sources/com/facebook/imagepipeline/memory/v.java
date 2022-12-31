package com.facebook.imagepipeline.memory;
/* compiled from: MemoryChunkUtil.java */
/* loaded from: classes.dex */
public class v {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i2, int i3, int i4) {
        return Math.min(Math.max(0, i4 - i2), i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(int i2, int i3, int i4, int i5, int i6) {
        com.facebook.common.internal.h.b(Boolean.valueOf(i5 >= 0));
        com.facebook.common.internal.h.b(Boolean.valueOf(i2 >= 0));
        com.facebook.common.internal.h.b(Boolean.valueOf(i4 >= 0));
        com.facebook.common.internal.h.b(Boolean.valueOf(i2 + i5 <= i6));
        com.facebook.common.internal.h.b(Boolean.valueOf(i4 + i5 <= i3));
    }
}
