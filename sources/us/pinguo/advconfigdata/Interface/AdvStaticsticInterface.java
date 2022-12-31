package us.pinguo.advconfigdata.Interface;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public interface AdvStaticsticInterface {
    void ReportBD(String str, String str2);

    void ReportBD(String str, String str2, String str3);

    void ReportBD(String str, String str2, String str3, String str4);

    void ReportBD(String str, String str2, HashMap<String, String> hashMap);

    void ReportBDNoKey(String str);

    void ReportBDNoKey(String str, String str2);

    void ReportBDNoKey(String str, String str2, String str3);

    void ReportBDNoKey(String str, HashMap<String, String> hashMap);

    void ReportU(String str);

    void ReportU(String str, int i2);

    void ReportU(String str, String str2);

    void ReportU(String str, Map<String, String> map);

    void ReportU(String str, Map<String, String> map, int i2);
}
