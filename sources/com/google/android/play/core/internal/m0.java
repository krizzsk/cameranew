package com.google.android.play.core.internal;

import java.io.File;
import java.io.IOException;
import java.util.List;
/* loaded from: classes2.dex */
final class m0 implements i0 {
    @Override // com.google.android.play.core.internal.i0
    public final Object[] a(Object obj, List<File> list, List<IOException> list2) {
        return (Object[]) t0.d(obj, "makePathElements", Object[].class, List.class, list);
    }
}
