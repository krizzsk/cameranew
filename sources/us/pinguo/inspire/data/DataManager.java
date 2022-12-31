package us.pinguo.inspire.data;

import java.util.ArrayList;
import java.util.List;
import us.pinguo.inspire.model.InspireTask;
/* loaded from: classes9.dex */
public class DataManager {
    private static DataManager b;
    private List<InspireTask> a = new ArrayList();

    private DataManager() {
    }

    public static DataManager getInstance() {
        if (b == null) {
            b = new DataManager();
        }
        return b;
    }

    public void a(List<InspireTask> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (InspireTask inspireTask : list) {
            if (!this.a.contains(inspireTask)) {
                this.a.add(inspireTask);
            }
        }
    }

    public void b(List<InspireTask> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.a.clear();
        this.a.addAll(list);
    }
}
