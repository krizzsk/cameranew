package us.pinguo.repository2020.database.staticsticker;

import kotlin.jvm.internal.s;
import us.pinguo.common.pgdownloader.download.IDownloadTask;
/* compiled from: MultiFileDownloadTask.kt */
/* loaded from: classes6.dex */
public final class l {
    private final String a;
    private final IDownloadTask b;

    public l(String id, IDownloadTask task) {
        s.h(id, "id");
        s.h(task, "task");
        this.a = id;
        this.b = task;
    }

    public final String a() {
        return this.a;
    }

    public final IDownloadTask b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            return s.c(this.a, lVar.a) && s.c(this.b, lVar.b);
        }
        return false;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "TaskWrapper(id=" + this.a + ", task=" + this.b + ')';
    }
}
