package com.growingio.android.sdk.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class CollectionsUtil {
    private CollectionsUtil() {
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }

    public static <T> List<T> nonEmptyList(List<T> list) {
        return list == null ? Collections.emptyList() : list;
    }
}
