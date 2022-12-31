package us.pinguo.inspire.model;

import java.util.List;
import us.pinguo.inspire.model.InspireWork;
/* compiled from: StickerWorksLoader.kt */
/* loaded from: classes9.dex */
public final class StickerWorks {
    private final List<InspireWork> items;
    private final int picSum;
    private final InspireWork.TaskInfo taskInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public StickerWorks(List<? extends InspireWork> items, int i2, InspireWork.TaskInfo taskInfo) {
        kotlin.jvm.internal.s.h(items, "items");
        kotlin.jvm.internal.s.h(taskInfo, "taskInfo");
        this.items = items;
        this.picSum = i2;
        this.taskInfo = taskInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StickerWorks copy$default(StickerWorks stickerWorks, List list, int i2, InspireWork.TaskInfo taskInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = stickerWorks.items;
        }
        if ((i3 & 2) != 0) {
            i2 = stickerWorks.picSum;
        }
        if ((i3 & 4) != 0) {
            taskInfo = stickerWorks.taskInfo;
        }
        return stickerWorks.copy(list, i2, taskInfo);
    }

    public final List<InspireWork> component1() {
        return this.items;
    }

    public final int component2() {
        return this.picSum;
    }

    public final InspireWork.TaskInfo component3() {
        return this.taskInfo;
    }

    public final StickerWorks copy(List<? extends InspireWork> items, int i2, InspireWork.TaskInfo taskInfo) {
        kotlin.jvm.internal.s.h(items, "items");
        kotlin.jvm.internal.s.h(taskInfo, "taskInfo");
        return new StickerWorks(items, i2, taskInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StickerWorks) {
            StickerWorks stickerWorks = (StickerWorks) obj;
            return kotlin.jvm.internal.s.c(this.items, stickerWorks.items) && this.picSum == stickerWorks.picSum && kotlin.jvm.internal.s.c(this.taskInfo, stickerWorks.taskInfo);
        }
        return false;
    }

    public final List<InspireWork> getItems() {
        return this.items;
    }

    public final int getPicSum() {
        return this.picSum;
    }

    public final InspireWork.TaskInfo getTaskInfo() {
        return this.taskInfo;
    }

    public int hashCode() {
        return (((this.items.hashCode() * 31) + this.picSum) * 31) + this.taskInfo.hashCode();
    }

    public String toString() {
        return "StickerWorks(items=" + this.items + ", picSum=" + this.picSum + ", taskInfo=" + this.taskInfo + ')';
    }
}
