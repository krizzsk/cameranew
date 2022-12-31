package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;
/* compiled from: JsonObject.java */
/* loaded from: classes2.dex */
public final class m extends k {
    private final LinkedTreeMap<String, k> a = new LinkedTreeMap<>();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof m) && ((m) obj).a.equals(this.a));
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public void i(String str, k kVar) {
        LinkedTreeMap<String, k> linkedTreeMap = this.a;
        if (kVar == null) {
            kVar = l.a;
        }
        linkedTreeMap.put(str, kVar);
    }

    public Set<Map.Entry<String, k>> j() {
        return this.a.entrySet();
    }

    public k k(String str) {
        return this.a.get(str);
    }
}
