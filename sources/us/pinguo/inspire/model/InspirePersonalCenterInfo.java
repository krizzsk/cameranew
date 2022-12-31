package us.pinguo.inspire.model;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class InspirePersonalCenterInfo extends HomePageHeaderInfo {
    public static final us.pinguo.inspire.a0.i<InspirePersonalCenterInfo> CREATOR = new us.pinguo.inspire.a0.i<InspirePersonalCenterInfo>() { // from class: us.pinguo.inspire.model.InspirePersonalCenterInfo.1
        @Override // us.pinguo.inspire.a0.i
        public Type getType() {
            return new com.google.gson.t.a<InspirePersonalCenterInfo>() { // from class: us.pinguo.inspire.model.InspirePersonalCenterInfo.1.1
            }.getType();
        }

        @Override // us.pinguo.inspire.a0.i
        public InspirePersonalCenterInfo newInstance() {
            return new InspirePersonalCenterInfo();
        }
    };
    public List<InspireWork> items = new ArrayList();

    public static int getLevelExp(int i2, Map<Integer, Integer> map) {
        if (i2 <= 0 || map == null || map.size() == 0 || !map.containsKey(Integer.valueOf(i2))) {
            return 0;
        }
        int i3 = i2 + 1;
        if (map.containsKey(Integer.valueOf(i3))) {
            return map.get(Integer.valueOf(i3)).intValue() - map.get(Integer.valueOf(i2)).intValue();
        }
        return 0;
    }

    public static int getLocalExp(int i2, int i3, int i4, Map<Integer, Integer> map) {
        if (map == null) {
            return i3;
        }
        int i5 = i3 + i4;
        int i6 = 1;
        while (i5 > 0) {
            if (!map.containsKey(Integer.valueOf(i6))) {
                return 0;
            }
            int levelExp = getLevelExp(i6, map);
            if (i5 < levelExp) {
                return i5;
            }
            i5 -= levelExp;
            i6++;
        }
        return i5;
    }

    public static int getLocalLevel(int i2, int i3, int i4, Map<Integer, Integer> map) {
        if (map == null) {
            return i2;
        }
        int i5 = i3 + i4;
        int i6 = 1;
        while (i5 > 0) {
            if (!map.containsKey(Integer.valueOf(i6))) {
                return i6 - 1;
            }
            int levelExp = getLevelExp(i6, map);
            if (i5 < levelExp) {
                return i6;
            }
            i5 -= levelExp;
            i6++;
        }
        return i6;
    }

    public static int getMaxLevelExp(Map<Integer, Integer> map) {
        if (map == null || map.size() == 0) {
            return 0;
        }
        int i2 = 0;
        for (Integer num : map.keySet()) {
            int intValue = num.intValue();
            if (intValue > i2) {
                i2 = intValue;
            }
        }
        if (map.containsKey(Integer.valueOf(i2))) {
            int i3 = i2 - 1;
            if (map.containsKey(Integer.valueOf(i3))) {
                return map.get(Integer.valueOf(i2)).intValue() - map.get(Integer.valueOf(i3)).intValue();
            }
        }
        if (map.containsKey(Integer.valueOf(i2))) {
            return map.get(Integer.valueOf(i2)).intValue();
        }
        return 0;
    }
}
