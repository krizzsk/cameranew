package us.pinguo.edit2020.manager;

import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.edit2020.bean.x;
/* compiled from: EditHistoryRecordManager.kt */
/* loaded from: classes4.dex */
public final class HistoryRecord implements Serializable {
    public static final a Companion = new a(null);
    public static final long serialVersionUID = -399093396896L;
    private final String picturePath;
    private final List<x> usedFunItems;

    /* compiled from: EditHistoryRecordManager.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HistoryRecord(String picturePath, List<? extends x> list) {
        s.h(picturePath, "picturePath");
        this.picturePath = picturePath;
        this.usedFunItems = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HistoryRecord copy$default(HistoryRecord historyRecord, String str, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = historyRecord.picturePath;
        }
        if ((i2 & 2) != 0) {
            list = historyRecord.usedFunItems;
        }
        return historyRecord.copy(str, list);
    }

    public final String component1() {
        return this.picturePath;
    }

    public final List<x> component2() {
        return this.usedFunItems;
    }

    public final HistoryRecord copy(String picturePath, List<? extends x> list) {
        s.h(picturePath, "picturePath");
        return new HistoryRecord(picturePath, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HistoryRecord) {
            HistoryRecord historyRecord = (HistoryRecord) obj;
            return s.c(this.picturePath, historyRecord.picturePath) && s.c(this.usedFunItems, historyRecord.usedFunItems);
        }
        return false;
    }

    public final String getPicturePath() {
        return this.picturePath;
    }

    public final List<x> getUsedFunItems() {
        return this.usedFunItems;
    }

    public int hashCode() {
        int hashCode = this.picturePath.hashCode() * 31;
        List<x> list = this.usedFunItems;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "HistoryRecord(picturePath=" + this.picturePath + ", usedFunItems=" + this.usedFunItems + ')';
    }
}
