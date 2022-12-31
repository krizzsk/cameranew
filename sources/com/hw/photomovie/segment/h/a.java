package com.hw.photomovie.segment.h;

import com.hw.photomovie.segment.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* compiled from: ReallocStrategy.java */
/* loaded from: classes2.dex */
public class a implements b {
    @Override // com.hw.photomovie.segment.h.b
    public List<com.hw.photomovie.b.b> a(com.hw.photomovie.a aVar, e eVar) {
        if (eVar == null) {
            return null;
        }
        if (aVar != null && aVar.f() != null) {
            int m = eVar.m();
            LinkedList linkedList = new LinkedList(eVar.j());
            int size = linkedList.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                } else if (((com.hw.photomovie.b.b) linkedList.get(size)).getState() < 2) {
                    linkedList.remove(size);
                }
            }
            int size2 = m - linkedList.size();
            List<com.hw.photomovie.b.b> g2 = aVar.f().g();
            ArrayList arrayList = new ArrayList();
            for (com.hw.photomovie.b.b bVar : g2) {
                if (bVar.getState() >= 2 && !linkedList.contains(bVar)) {
                    if (size2 <= 0) {
                        return linkedList;
                    }
                    arrayList.add(bVar);
                }
            }
            while (size2 > 0 && arrayList.size() > 0) {
                linkedList.add(arrayList.get((int) (Math.random() * arrayList.size())));
                size2--;
            }
            int size3 = linkedList.size();
            for (int i2 = 0; i2 < size3 && size2 > 0; i2++) {
                linkedList.add((com.hw.photomovie.b.b) linkedList.get(i2));
                size2--;
            }
            return linkedList;
        }
        return eVar.j();
    }
}
