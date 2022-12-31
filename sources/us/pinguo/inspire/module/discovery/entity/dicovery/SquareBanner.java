package us.pinguo.inspire.module.discovery.entity.dicovery;

import us.pinguo.inspire.model.InspireTask;
/* loaded from: classes9.dex */
public class SquareBanner {
    public static final String TYPE_TASK = "task";
    public InspireTask task;
    public String type;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SquareBanner squareBanner = (SquareBanner) obj;
        String str = this.type;
        if (str == null ? squareBanner.type == null : str.equals(squareBanner.type)) {
            InspireTask inspireTask = this.task;
            InspireTask inspireTask2 = squareBanner.task;
            return inspireTask != null ? inspireTask.equals(inspireTask2) : inspireTask2 == null;
        }
        return false;
    }

    public int hashCode() {
        String str = this.type;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        InspireTask inspireTask = this.task;
        return hashCode + (inspireTask != null ? inspireTask.hashCode() : 0);
    }
}
