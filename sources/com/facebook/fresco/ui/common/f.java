package com.facebook.fresco.ui.common;

import android.net.Uri;
import javax.annotation.Nullable;
/* compiled from: MultiUriHelper.java */
/* loaded from: classes.dex */
public abstract class f {
    @Nullable
    public static <T> Uri a(@Nullable T t, @Nullable T t2, @Nullable T[] tArr, com.facebook.common.internal.e<T, Uri> eVar) {
        Uri apply;
        Uri apply2;
        if (t == null || (apply2 = eVar.apply(t)) == null) {
            if (tArr == null || tArr.length <= 0 || tArr[0] == null || (apply = eVar.apply(tArr[0])) == null) {
                if (t2 != null) {
                    return eVar.apply(t2);
                }
                return null;
            }
            return apply;
        }
        return apply2;
    }
}
