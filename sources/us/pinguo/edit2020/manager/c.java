package us.pinguo.edit2020.manager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.s;
import us.pinguo.edit2020.bean.o;
import us.pinguo.edit2020.bean.x;
/* compiled from: EditHistoryRecordManager.kt */
/* loaded from: classes4.dex */
public final class c {
    private final LinkedList<HistoryRecord> a;
    private int b;

    public c(String historyFilePath, List<HistoryRecord> list, int i2) {
        s.h(historyFilePath, "historyFilePath");
        this.a = new LinkedList<>();
        this.b = -1;
        l(list, i2);
    }

    private final void l(List<HistoryRecord> list, int i2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m();
        for (HistoryRecord historyRecord : list) {
            e().add(historyRecord);
        }
        this.b = i2;
    }

    public final boolean a() {
        return this.b < this.a.size() - 1;
    }

    public final boolean b() {
        return this.b > 0;
    }

    public final HistoryRecord c() {
        int i2;
        if (this.a.size() <= 0 || (i2 = this.b) < 0 || i2 >= this.a.size()) {
            return null;
        }
        return this.a.get(this.b);
    }

    public final HistoryRecord d() {
        if (this.a.size() > 0) {
            return this.a.get(0);
        }
        return null;
    }

    public final LinkedList<HistoryRecord> e() {
        return this.a;
    }

    public final HistoryRecord f() {
        int i2 = this.b;
        if (i2 > 0) {
            LinkedList<HistoryRecord> linkedList = this.a;
            int i3 = i2 - 1;
            this.b = i3;
            return linkedList.get(i3);
        }
        return null;
    }

    public final HistoryRecord g() {
        if (this.b < this.a.size() - 1) {
            LinkedList<HistoryRecord> linkedList = this.a;
            int i2 = this.b + 1;
            this.b = i2;
            return linkedList.get(i2);
        }
        return null;
    }

    public final int h() {
        return this.b;
    }

    public final List<x> i() {
        int i2;
        ArrayList arrayList = new ArrayList();
        LinkedList<HistoryRecord> linkedList = this.a;
        if (!(linkedList == null || linkedList.isEmpty()) && (i2 = this.b) >= 1) {
            if (1 <= i2) {
                int i3 = 1;
                while (true) {
                    int i4 = i3 + 1;
                    List<x> usedFunItems = this.a.get(i3).getUsedFunItems();
                    if (!(usedFunItems == null || usedFunItems.isEmpty())) {
                        List<x> usedFunItems2 = this.a.get(i3).getUsedFunItems();
                        s.e(usedFunItems2);
                        arrayList.addAll(usedFunItems2);
                    }
                    if (i3 == i2) {
                        break;
                    }
                    i3 = i4;
                }
            }
            return arrayList;
        }
        return null;
    }

    public final List<x> j() {
        ArrayList arrayList = new ArrayList();
        LinkedList<HistoryRecord> linkedList = this.a;
        if (!(linkedList == null || linkedList.isEmpty()) && this.b >= 1) {
            int size = this.a.size();
            int i2 = 1;
            while (i2 < size) {
                int i3 = i2 + 1;
                List<x> usedFunItems = this.a.get(i2).getUsedFunItems();
                if (!(usedFunItems == null || usedFunItems.isEmpty())) {
                    List<x> usedFunItems2 = this.a.get(i2).getUsedFunItems();
                    s.e(usedFunItems2);
                    arrayList.addAll(usedFunItems2);
                }
                i2 = i3;
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                x xVar = (x) obj;
                if (xVar.a() || (xVar instanceof o)) {
                    arrayList2.add(obj);
                }
            }
            return arrayList2;
        }
        return null;
    }

    public final boolean k() {
        int i2;
        ArrayList arrayList;
        LinkedList<HistoryRecord> linkedList = this.a;
        if (!(linkedList == null || linkedList.isEmpty()) && (i2 = this.b) >= 1 && i2 >= 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                List<x> usedFunItems = this.a.get(i3).getUsedFunItems();
                if (usedFunItems == null) {
                    arrayList = null;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : usedFunItems) {
                        x xVar = (x) obj;
                        if (xVar.a() || (xVar instanceof o)) {
                            arrayList2.add(obj);
                        }
                    }
                    arrayList = arrayList2;
                }
                if (!(arrayList == null || arrayList.isEmpty())) {
                    return true;
                }
                if (i3 == i2) {
                    break;
                }
                i3 = i4;
            }
        }
        return false;
    }

    public final void m() {
        this.a.clear();
        this.b = -1;
    }

    public final void n(HistoryRecord historyRecord) {
        s.h(historyRecord, "historyRecord");
        int size = (this.a.size() - 1) - this.b;
        int i2 = 0;
        while (i2 < size) {
            i2++;
            this.a.removeLast();
        }
        this.a.add(historyRecord);
        this.b++;
    }
}
