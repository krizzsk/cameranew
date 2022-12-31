package com.google.android.play.core.splitinstall;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public final class z {
    private final Map<String, Map<String, String>> a;

    public final Map<String, Set<String>> a(Collection<String> collection) {
        Set unmodifiableSet;
        HashMap hashMap = new HashMap();
        for (String str : this.a.keySet()) {
            if (this.a.containsKey(str)) {
                HashSet hashSet = new HashSet();
                for (Map.Entry<String, String> entry : this.a.get(str).entrySet()) {
                    if (collection.contains(entry.getKey())) {
                        hashSet.add(entry.getValue());
                    }
                }
                unmodifiableSet = Collections.unmodifiableSet(hashSet);
            } else {
                unmodifiableSet = Collections.emptySet();
            }
            hashMap.put(str, unmodifiableSet);
        }
        return hashMap;
    }
}
