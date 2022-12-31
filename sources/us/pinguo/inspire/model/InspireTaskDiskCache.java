package us.pinguo.inspire.model;

import java.util.List;
import us.pinguo.inspire.Inspire;
/* loaded from: classes9.dex */
public class InspireTaskDiskCache extends us.pinguo.inspire.a0.c<List<InspireTask>> {
    private static final String FILE_NAME = "inspire_task_list.json";

    public InspireTaskDiskCache() {
        super(new us.pinguo.inspire.a0.d(Inspire.b(), FILE_NAME));
    }
}
