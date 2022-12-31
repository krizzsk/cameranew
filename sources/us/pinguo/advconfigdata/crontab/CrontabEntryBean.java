package us.pinguo.advconfigdata.crontab;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import org.slf4j.Marker;
import us.pinguo.common.network.common.header.PGTransHeader;
/* loaded from: classes3.dex */
public class CrontabEntryBean {
    boolean[] bDaysOfMonth;
    boolean[] bDaysOfWeek;
    boolean[] bHours;
    boolean[] bMinutes;
    boolean[] bMonths;
    Map<Integer, List<Integer>> beginMinutesMap;
    Map<Integer, List<Integer>> endMinutesMap;
    String minutes = Marker.ANY_MARKER;
    String hours = Marker.ANY_MARKER;
    String daysOfMonth = Marker.ANY_MARKER;
    String months = Marker.ANY_MARKER;
    String daysOfWeek = Marker.ANY_MARKER;

    public boolean equalsCalendar(Calendar calendar) {
        boolean z = this.bMonths[calendar.get(2)] && this.bDaysOfWeek[calendar.get(7) - 1] && this.bDaysOfMonth[calendar.get(5) - 1];
        if (z) {
            int i2 = calendar.get(11);
            int i3 = calendar.get(12);
            boolean z2 = this.bHours[i2] && this.bMinutes[i3];
            if (z2) {
                List<Integer> list = this.beginMinutesMap.get(Integer.valueOf(i2));
                List<Integer> list2 = this.endMinutesMap.get(Integer.valueOf(i2));
                if (list != null && list.size() > 0) {
                    boolean z3 = i3 >= list.get(0).intValue();
                    for (int i4 = 1; i4 < list.size(); i4++) {
                        z3 |= i3 >= list.get(i4).intValue();
                        if (z3) {
                            break;
                        }
                    }
                    if (!z3) {
                        return false;
                    }
                } else if (list2 != null && list2.size() > 0) {
                    boolean z4 = i3 <= list2.get(0).intValue();
                    for (int i5 = 1; i5 < list2.size(); i5++) {
                        z4 |= i3 <= list2.get(i5).intValue();
                        if (z4) {
                            break;
                        }
                    }
                    if (!z4) {
                        return false;
                    }
                }
            }
            return z2;
        }
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ minutes:");
        sb.append(this.minutes);
        sb.append("\n");
        boolean[] zArr = this.bMinutes;
        if (zArr != null) {
            for (boolean z : zArr) {
                sb.append(PGTransHeader.CONNECTOR + z);
            }
        }
        sb.append("\n");
        sb.append("{ hours:");
        sb.append(this.hours);
        sb.append("\n");
        boolean[] zArr2 = this.bHours;
        if (zArr2 != null) {
            for (boolean z2 : zArr2) {
                sb.append(PGTransHeader.CONNECTOR + z2);
            }
        }
        sb.append("\n");
        sb.append("beginMinutesMap：");
        sb.append(this.beginMinutesMap.toString());
        sb.append("endMinutesMap：");
        sb.append(this.endMinutesMap.toString());
        sb.append("\n");
        sb.append("{ daysOfMonth:");
        sb.append(this.daysOfMonth);
        sb.append("\n");
        boolean[] zArr3 = this.bDaysOfMonth;
        if (zArr3 != null) {
            for (boolean z3 : zArr3) {
                sb.append(PGTransHeader.CONNECTOR + z3);
            }
        }
        sb.append("\n");
        sb.append("{ months:");
        sb.append(this.months);
        sb.append("\n");
        boolean[] zArr4 = this.bMonths;
        if (zArr4 != null) {
            for (boolean z4 : zArr4) {
                sb.append(PGTransHeader.CONNECTOR + z4);
            }
        }
        sb.append("\n");
        sb.append("{ daysOfWeek:");
        sb.append(this.daysOfWeek);
        sb.append("\n");
        boolean[] zArr5 = this.bDaysOfWeek;
        if (zArr5 != null) {
            for (boolean z5 : zArr5) {
                sb.append(PGTransHeader.CONNECTOR + z5);
            }
        }
        sb.append("\n");
        return sb.toString();
    }
}
