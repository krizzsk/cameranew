package us.pinguo.advconfigdata.AdvDex;

import android.content.Context;
import android.text.TextUtils;
import com.pinguo.camera360.effect.model.entity.Effect;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import us.pinguo.advconfigdata.Utils.AdvLog;
import us.pinguo.advconfigdata.database.GroupStaticsItem;
import us.pinguo.advconfigdata.database.StaticsBaseItem;
import us.pinguo.advconfigdata.database.StaticsItem;
/* loaded from: classes3.dex */
public class DexFunction {
    private Method ReportBDHSSM;
    private Method ReportBDNoKeyS;
    private Method ReportBDNoKeySM;
    private Method ReportBDNoKeySS;
    private Method ReportBDNoKeySSS;
    private Method ReportBDSS;
    private Method ReportBDSSS;
    private Method ReportBDSSSS;
    private Method ReportUS;
    private Method ReportUSM;
    private Method ReportUSMT;
    private Method ReportUSS;
    private Method ReportUT;
    private Context mContext;
    private Object mStaticManager;
    private final String STATIC_CLASS_NAME = "us.pinguo.inspire.adv.InpireAdvInterface";
    private final String METHOD_UMENG_HELPER = "ReportUHelper";
    private final String METHOD_BD_HELPER = "ReportBDHelper";
    private final String METHOD_BDNOKEY_HELPER = "ReportBDNoKeyHelper";
    private final String METHOD_BD = "ReportBD";
    private final String METHOD_BDNOKEY = "ReportBDNoKey";
    private final String METHOD_UMENG = "ReportU";
    private int mTotalCount = 0;
    private Map<String, String> mDataMap = new HashMap();

    public DexFunction(Context context) {
        this.mContext = context;
        InitMethod();
    }

    private void AddReport(Map<String, Integer> map, String str) {
        if (map == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (map.containsKey(str)) {
            map.remove(str);
            map.put(str, Integer.valueOf(map.get(str).intValue() + 1));
            return;
        }
        map.put(str, 1);
    }

    private int GetRandom(int i2) {
        return (int) ((Math.random() * 1000.0d) % i2);
    }

    private void InitMethod() {
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("us.pinguo.inspire.adv.InpireAdvInterface");
            this.mStaticManager = loadClass.newInstance();
            this.ReportBDSS = loadClass.getMethod("ReportBD", String.class, String.class);
            this.ReportBDSSS = loadClass.getMethod("ReportBD", String.class, String.class, String.class);
            this.ReportBDSSSS = loadClass.getMethod("ReportBD", String.class, String.class, String.class, String.class);
            this.ReportBDHSSM = loadClass.getMethod("ReportBDHelper", String.class, String.class, String.class, String.class, String.class, String.class);
            this.ReportBDNoKeyS = loadClass.getMethod("ReportBDNoKey", String.class);
            this.ReportBDNoKeySS = loadClass.getMethod("ReportBDNoKey", String.class, String.class);
            this.ReportBDNoKeySSS = loadClass.getMethod("ReportBDNoKey", String.class, String.class, String.class);
            this.ReportBDNoKeySM = loadClass.getMethod("ReportBDNoKeyHelper", String.class, String.class, String.class, String.class, String.class);
            this.ReportUS = loadClass.getMethod("ReportU", String.class);
            this.ReportUSS = loadClass.getMethod("ReportU", String.class, String.class);
            this.ReportUT = loadClass.getMethod("ReportUHelpler", String.class, String.class);
            this.ReportUSM = loadClass.getMethod("ReportUHelper", String.class, String.class, String.class, String.class, String.class);
            this.ReportUSMT = loadClass.getMethod("ReportUHelper", String.class, String.class, String.class, String.class, String.class, String.class);
        } catch (Exception e2) {
            MyLog("test", "Failed" + e2.getMessage());
        }
    }

    private boolean IsPercentSuit(StaticsItem staticsItem) {
        if (staticsItem == null) {
            return false;
        }
        int i2 = staticsItem.percent;
        return i2 <= 0 || i2 >= 100 || GetRandom(100) < staticsItem.percent;
    }

    private void MyLog(String str, String str2) {
        AdvLog.Log(str, str2);
    }

    private void PutToJosn(String str, String str2) {
        Map<String, String> map = this.mDataMap;
        if (map == null || map.containsKey(str)) {
            return;
        }
        this.mDataMap.put(str, str2);
    }

    private void ReportBD(String str, String str2) {
        Method method = this.ReportBDSS;
        if (method == null) {
            MyLog("test", "ReportBDSS: is null");
            return;
        }
        try {
            method.invoke(this.mStaticManager, str, str2);
        } catch (Exception unused) {
            MyLog("test", "ReportBDSS invoke failed");
        }
    }

    private void ReportBDNoKey(String str) {
        Method method = this.ReportBDNoKeyS;
        if (method == null) {
            MyLog("test", "ReportBDNoKeyS: is null");
            return;
        }
        try {
            method.invoke(this.mStaticManager, str);
        } catch (Exception unused) {
            MyLog("test", "ReportBDNoKeyS invoke failed");
        }
    }

    private void ReportManager(StaticsBaseItem staticsBaseItem) {
        if (staticsBaseItem == null) {
            return;
        }
        int i2 = staticsBaseItem.type;
        if (i2 != 20) {
            switch (i2) {
                case 1:
                    if (!TextUtils.isEmpty(staticsBaseItem.area) && !TextUtils.isEmpty(staticsBaseItem.eventid)) {
                        ReportBD(staticsBaseItem.area, staticsBaseItem.eventid);
                        break;
                    } else {
                        return;
                    }
                case 2:
                    if (!TextUtils.isEmpty(staticsBaseItem.area) && !TextUtils.isEmpty(staticsBaseItem.eventid)) {
                        ReportBD(staticsBaseItem.area, staticsBaseItem.eventid, staticsBaseItem.value1);
                        break;
                    } else {
                        return;
                    }
                case 3:
                    if (!TextUtils.isEmpty(staticsBaseItem.area) && !TextUtils.isEmpty(staticsBaseItem.eventid)) {
                        ReportBD(staticsBaseItem.area, staticsBaseItem.eventid, staticsBaseItem.value1, staticsBaseItem.item1);
                        break;
                    } else {
                        return;
                    }
                case 4:
                    if (!TextUtils.isEmpty(staticsBaseItem.area) && !TextUtils.isEmpty(staticsBaseItem.eventid)) {
                        ReportBD(staticsBaseItem.area, staticsBaseItem.eventid, staticsBaseItem.item1, staticsBaseItem.value1, staticsBaseItem.item2, staticsBaseItem.value2);
                        break;
                    } else {
                        return;
                    }
                case 5:
                    if (!TextUtils.isEmpty(staticsBaseItem.eventid)) {
                        ReportBDNoKey(staticsBaseItem.eventid);
                        break;
                    } else {
                        return;
                    }
                case 6:
                    if (!TextUtils.isEmpty(staticsBaseItem.eventid)) {
                        ReportBDNoKey(staticsBaseItem.eventid, staticsBaseItem.value1);
                        break;
                    } else {
                        return;
                    }
                case 7:
                    if (!TextUtils.isEmpty(staticsBaseItem.eventid)) {
                        ReportBDNoKey(staticsBaseItem.eventid, staticsBaseItem.value1, staticsBaseItem.value2);
                        break;
                    } else {
                        return;
                    }
                case 8:
                    if (!TextUtils.isEmpty(staticsBaseItem.eventid)) {
                        ReportBDNoKey(staticsBaseItem.eventid, staticsBaseItem.item1, staticsBaseItem.value1, staticsBaseItem.item2, staticsBaseItem.value2);
                        break;
                    } else {
                        return;
                    }
                case 9:
                    if (!TextUtils.isEmpty(staticsBaseItem.eventid)) {
                        ReportU(staticsBaseItem.eventid);
                        break;
                    } else {
                        return;
                    }
                case 10:
                    if (!TextUtils.isEmpty(staticsBaseItem.eventid)) {
                        ReportU(staticsBaseItem.eventid, staticsBaseItem.value1);
                        break;
                    } else {
                        return;
                    }
                case 11:
                    if (!TextUtils.isEmpty(staticsBaseItem.eventid)) {
                        ReportUT(staticsBaseItem.eventid, staticsBaseItem.duration);
                        break;
                    } else {
                        return;
                    }
                case 12:
                    if (!TextUtils.isEmpty(staticsBaseItem.eventid)) {
                        ReportU(staticsBaseItem.eventid, staticsBaseItem.item1, staticsBaseItem.value1, staticsBaseItem.item2, staticsBaseItem.value2);
                        break;
                    } else {
                        return;
                    }
                case 13:
                    if (!TextUtils.isEmpty(staticsBaseItem.eventid)) {
                        ReportU(staticsBaseItem.eventid, staticsBaseItem.item1, staticsBaseItem.value1, staticsBaseItem.item2, staticsBaseItem.value2, staticsBaseItem.duration);
                        break;
                    } else {
                        return;
                    }
            }
        } else {
            PutToJosn(staticsBaseItem.eventid, staticsBaseItem.value1);
        }
        this.mTotalCount++;
    }

    private void ReportToatal() {
        Map<String, String> map = this.mDataMap;
        if (map == null || map.size() == 0) {
            return;
        }
        String str = "";
        for (Map.Entry<String, String> entry : this.mDataMap.entrySet()) {
            str = (str + (entry.getKey() + entry.getValue())) + Effect.DIVIDER;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ReportBDNoKey("meta_data_report", str);
        } catch (Exception unused) {
        }
    }

    private void ReportU(String str) {
        Method method = this.ReportUS;
        if (method == null) {
            MyLog("test", "ReportUS: is null");
            return;
        }
        try {
            method.invoke(this.mStaticManager, str);
        } catch (Exception unused) {
            MyLog("test", "ReportUS invoke failed");
        }
    }

    private void ReportUT(String str, String str2) {
        Method method = this.ReportUT;
        if (method == null) {
            MyLog("test", "ReportUT: is null");
            return;
        }
        try {
            method.invoke(this.mStaticManager, str, str2);
            MyLog("test", "");
        } catch (Exception unused) {
            MyLog("test", "ReportUT invoke failed");
        }
    }

    public void ExeCuteTask(GroupStaticsItem groupStaticsItem) {
        if (groupStaticsItem == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        int size = groupStaticsItem.items.size();
        StaticsItem staticsItem = groupStaticsItem.items.get(0);
        if (staticsItem.min <= 0) {
            staticsItem.min = 1;
        }
        int i2 = staticsItem.max;
        int i3 = staticsItem.min;
        int i4 = (i2 - i3) + 1;
        int GetRandom = i3 + (i4 > 0 ? GetRandom(i4) : 0);
        for (int i5 = 0; i5 < GetRandom; i5++) {
            for (int i6 = 0; i6 < size; i6++) {
                StaticsItem staticsItem2 = groupStaticsItem.items.get(i6);
                if (!IsPercentSuit(staticsItem2)) {
                    break;
                }
                if (!TextUtils.isEmpty(staticsItem2.reportkey)) {
                    AddReport(hashMap, staticsItem2.reportkey);
                }
                List<StaticsBaseItem> list = staticsItem2.items;
                int size2 = list.size();
                for (int i7 = 0; i7 < size2; i7++) {
                    ReportManager(list.get(i7));
                }
            }
        }
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            PutToJosn(entry.getKey(), String.valueOf(entry.getValue()));
        }
    }

    public void Finish() {
        PutToJosn("total", String.valueOf(this.mTotalCount));
        ReportToatal();
    }

    public void ReportError(String str) {
        ReportU("camera_1_96", str);
    }

    private void ReportBD(String str, String str2, String str3) {
        Method method = this.ReportBDSSS;
        if (method == null) {
            MyLog("test", "ReportBDSSS: is null");
            return;
        }
        try {
            method.invoke(this.mStaticManager, str, str2, str3);
        } catch (Exception unused) {
            MyLog("test", "ReportBDSSS invoke failed");
        }
    }

    private void ReportBDNoKey(String str, String str2) {
        Method method = this.ReportBDNoKeySS;
        if (method == null) {
            MyLog("test", "ReportBDNoKeySS: is null");
            return;
        }
        try {
            method.invoke(this.mStaticManager, str, str2);
        } catch (Exception unused) {
            MyLog("test", "ReportBDNoKeySS invoke failed");
        }
    }

    private void ReportU(String str, String str2) {
        Method method = this.ReportUSS;
        if (method == null) {
            MyLog("test", "ReportUSS: is null");
            return;
        }
        try {
            method.invoke(this.mStaticManager, str, str2);
        } catch (Exception unused) {
            MyLog("test", "ReportUSS invoke failed");
        }
    }

    private void ReportBD(String str, String str2, String str3, String str4) {
        Method method = this.ReportBDSSSS;
        if (method == null) {
            MyLog("test", "ReportBDSSSS: is null");
            return;
        }
        try {
            method.invoke(this.mStaticManager, str, str2, str3, str4);
        } catch (Exception unused) {
            MyLog("test", "ReportBDSSSS invoke failed");
        }
    }

    private void ReportBDNoKey(String str, String str2, String str3) {
        Method method = this.ReportBDNoKeySSS;
        if (method == null) {
            MyLog("test", "ReportBDNoKeySSS: is null");
            return;
        }
        try {
            method.invoke(this.mStaticManager, str, str2, str3);
        } catch (Exception unused) {
            MyLog("test", "ReportBDNoKeySSS invoke failed");
        }
    }

    private void ReportU(String str, String str2, String str3, String str4, String str5) {
        Method method = this.ReportUSM;
        if (method == null) {
            MyLog("test", "ReportUSM: is null");
            return;
        }
        try {
            method.invoke(this.mStaticManager, str, str2, str3, str4, str5);
        } catch (Exception unused) {
            MyLog("test", "ReportUSM invoke failed");
        }
    }

    private void ReportBD(String str, String str2, String str3, String str4, String str5, String str6) {
        Method method = this.ReportBDHSSM;
        if (method == null) {
            MyLog("test", "ReportBDHSSM: is null");
            return;
        }
        try {
            method.invoke(this.mStaticManager, str, str2, str3, str4, str5, str6);
        } catch (Exception unused) {
            MyLog("test", "ReportBDHSSM invoke failed");
        }
    }

    private void ReportBDNoKey(String str, String str2, String str3, String str4, String str5) {
        Method method = this.ReportBDNoKeySM;
        if (method == null) {
            MyLog("test", "ReportBDNoKeySM: is null");
            return;
        }
        try {
            method.invoke(this.mStaticManager, str, str2, str3, str4, str5);
        } catch (Exception unused) {
            MyLog("test", "ReportBDNoKeySM invoke failed");
        }
    }

    private void ReportU(String str, String str2, String str3, String str4, String str5, String str6) {
        Method method = this.ReportUSMT;
        if (method == null) {
            MyLog("test", "ReportUSMT: is null");
            return;
        }
        try {
            method.invoke(this.mStaticManager, str, str2, str3, str4, str5, str6);
        } catch (Exception unused) {
            MyLog("test", "ReportUSMT invoke failed");
        }
    }
}
