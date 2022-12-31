package us.pinguo.advconfigdata.crontab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.slf4j.Marker;
import us.pinguo.common.network.common.header.PGTransHeader;
/* loaded from: classes3.dex */
public class CrontabParser {
    public CrontabEntryBean parse(String str) throws CrontabEntryException {
        boolean[] zArr = new boolean[60];
        boolean[] zArr2 = new boolean[24];
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        boolean[] zArr3 = new boolean[12];
        boolean[] zArr4 = new boolean[7];
        boolean[] zArr5 = new boolean[31];
        CrontabEntryBean crontabEntryBean = new CrontabEntryBean();
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        int countTokens = stringTokenizer.countTokens();
        int i2 = 0;
        while (stringTokenizer.hasMoreElements()) {
            String nextToken = stringTokenizer.nextToken();
            if (i2 == 0) {
                parseToken(nextToken, zArr, false);
                crontabEntryBean.bMinutes = zArr;
                crontabEntryBean.minutes = nextToken;
            } else if (i2 == 1) {
                parseHoursToken(nextToken, zArr2, hashMap, hashMap2);
                crontabEntryBean.bHours = zArr2;
                crontabEntryBean.beginMinutesMap = hashMap;
                crontabEntryBean.endMinutesMap = hashMap2;
                crontabEntryBean.hours = nextToken;
            } else if (i2 == 2) {
                parseToken(nextToken, zArr5, true);
                crontabEntryBean.bDaysOfMonth = zArr5;
                crontabEntryBean.daysOfMonth = nextToken;
            } else if (i2 == 3) {
                parseToken(nextToken, zArr3, true);
                crontabEntryBean.bMonths = zArr3;
                crontabEntryBean.months = nextToken;
            } else if (i2 == 4) {
                parseToken(nextToken, zArr4, false);
                crontabEntryBean.bDaysOfWeek = zArr4;
                crontabEntryBean.daysOfWeek = nextToken;
            }
            i2++;
        }
        if (countTokens >= 5) {
            return crontabEntryBean;
        }
        throw new CrontabEntryException("The number of items is < 5 at " + str);
    }

    public void parseHoursToken(String str, boolean[] zArr, Map<Integer, List<Integer>> map, Map<Integer, List<Integer>> map2) throws CrontabEntryException {
        int i2;
        int parseInt;
        int parseInt2;
        int parseInt3;
        try {
            int indexOf = str.indexOf("/");
            if (indexOf > 0) {
                i2 = Integer.parseInt(str.substring(indexOf + 1));
                str = str.substring(0, indexOf);
            } else {
                i2 = 1;
            }
            if (str.equals(Marker.ANY_MARKER)) {
                for (int i3 = 0; i3 < zArr.length; i3 += i2) {
                    zArr[i3] = true;
                }
            } else if (str.indexOf(",") > 0) {
                StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
                while (stringTokenizer.hasMoreTokens()) {
                    parseHoursToken(stringTokenizer.nextToken(), zArr, map, map2);
                }
            } else {
                int indexOf2 = str.indexOf(PGTransHeader.CONNECTOR);
                if (indexOf2 > 0) {
                    String substring = str.substring(0, indexOf2);
                    String substring2 = str.substring(indexOf2 + 1);
                    int indexOf3 = substring.indexOf(":");
                    int indexOf4 = substring2.indexOf(":");
                    if (indexOf3 > 0) {
                        parseInt2 = Integer.parseInt(substring.substring(0, indexOf3));
                        if (map.get(Integer.valueOf(parseInt2)) != null) {
                            map.get(Integer.valueOf(parseInt2)).add(Integer.valueOf(Integer.parseInt(substring.substring(indexOf3 + 1))));
                        } else {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(Integer.valueOf(Integer.parseInt(substring.substring(indexOf3 + 1))));
                            map.put(Integer.valueOf(parseInt2), arrayList);
                        }
                    } else {
                        parseInt2 = Integer.parseInt(substring);
                    }
                    if (indexOf4 > 0) {
                        parseInt3 = Integer.parseInt(substring2.substring(0, indexOf4));
                        if (map2.get(Integer.valueOf(parseInt3)) != null) {
                            map2.get(Integer.valueOf(parseInt3)).add(Integer.valueOf(Integer.parseInt(substring2.substring(indexOf4 + 1))));
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(Integer.valueOf(Integer.parseInt(substring2.substring(indexOf4 + 1))));
                            map2.put(Integer.valueOf(parseInt3), arrayList2);
                        }
                    } else {
                        parseInt3 = Integer.parseInt(substring2);
                    }
                    while (parseInt2 <= parseInt3) {
                        zArr[parseInt2] = true;
                        parseInt2 += i2;
                    }
                    return;
                }
                int indexOf5 = str.indexOf(":");
                if (indexOf5 > 0) {
                    parseInt = Integer.parseInt(str.substring(0, indexOf5));
                    int parseInt4 = Integer.parseInt(str.substring(indexOf5 + 1));
                    if (map.get(Integer.valueOf(parseInt)) != null) {
                        map.get(Integer.valueOf(parseInt)).add(Integer.valueOf(parseInt4));
                    } else {
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(Integer.valueOf(parseInt4));
                        map.put(Integer.valueOf(parseInt), arrayList3);
                    }
                    if (map2.get(Integer.valueOf(parseInt)) != null) {
                        map2.get(Integer.valueOf(parseInt)).add(Integer.valueOf(parseInt4));
                    } else {
                        ArrayList arrayList4 = new ArrayList();
                        arrayList4.add(Integer.valueOf(parseInt4));
                        map2.put(Integer.valueOf(parseInt), arrayList4);
                    }
                } else {
                    parseInt = Integer.parseInt(str);
                }
                zArr[parseInt] = true;
            }
        } catch (Exception unused) {
            throw new CrontabEntryException("Smth was wrong with " + str);
        }
    }

    public void parseToken(String str, boolean[] zArr, boolean z) throws CrontabEntryException {
        int i2;
        try {
            int indexOf = str.indexOf("/");
            if (indexOf > 0) {
                i2 = Integer.parseInt(str.substring(indexOf + 1));
                str = str.substring(0, indexOf);
            } else {
                i2 = 1;
            }
            if (str.equals(Marker.ANY_MARKER)) {
                for (int i3 = 0; i3 < zArr.length; i3 += i2) {
                    zArr[i3] = true;
                }
            } else if (str.indexOf(",") > 0) {
                StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
                while (stringTokenizer.hasMoreTokens()) {
                    parseToken(stringTokenizer.nextToken(), zArr, z);
                }
            } else {
                int indexOf2 = str.indexOf(PGTransHeader.CONNECTOR);
                if (indexOf2 > 0) {
                    int parseInt = Integer.parseInt(str.substring(0, indexOf2));
                    int parseInt2 = Integer.parseInt(str.substring(indexOf2 + 1));
                    if (z) {
                        parseInt--;
                        parseInt2--;
                    }
                    while (parseInt <= parseInt2) {
                        zArr[parseInt] = true;
                        parseInt += i2;
                    }
                    return;
                }
                int parseInt3 = Integer.parseInt(str);
                if (z) {
                    parseInt3--;
                }
                zArr[parseInt3] = true;
            }
        } catch (Exception unused) {
            throw new CrontabEntryException("Smth was wrong with " + str);
        }
    }
}
