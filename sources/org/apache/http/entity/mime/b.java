package org.apache.http.entity.mime;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* compiled from: Header.java */
/* loaded from: classes3.dex */
public class b implements Iterable<e> {
    private final List<e> a = new LinkedList();
    private final Map<String, List<e>> b = new HashMap();

    public void a(e eVar) {
        if (eVar == null) {
            return;
        }
        String lowerCase = eVar.b().toLowerCase(Locale.US);
        List<e> list = this.b.get(lowerCase);
        if (list == null) {
            list = new LinkedList<>();
            this.b.put(lowerCase, list);
        }
        list.add(eVar);
        this.a.add(eVar);
    }

    public e b(String str) {
        if (str == null) {
            return null;
        }
        List<e> list = this.b.get(str.toLowerCase(Locale.US));
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override // java.lang.Iterable
    public Iterator<e> iterator() {
        return Collections.unmodifiableList(this.a).iterator();
    }

    public String toString() {
        return this.a.toString();
    }
}
