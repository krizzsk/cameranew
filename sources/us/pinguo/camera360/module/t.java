package us.pinguo.camera360.module;

import java.util.HashMap;
import java.util.Map;
import us.pinguo.advconfigdata.Interface.AdvStaticsticInterface;
import us.pinguo.advconfigdata.Utils.AdvLog;
import us.pinguo.common.network.common.header.PGTransHeader;
/* compiled from: InpireAdvInterface.java */
/* loaded from: classes3.dex */
public class t implements AdvStaticsticInterface {
    @Override // us.pinguo.advconfigdata.Interface.AdvStaticsticInterface
    public void ReportBD(String str, String str2) {
        j.a.f.f.onEvent(str2);
        us.pinguo.foundation.statistics.g.b(str + PGTransHeader.CONNECTOR + str2);
        AdvLog.Log(str + "_" + str2);
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvStaticsticInterface
    public void ReportBDNoKey(String str) {
        j.a.f.f.onEvent(str);
        us.pinguo.foundation.statistics.g.b(str);
        AdvLog.Log(str);
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvStaticsticInterface
    public void ReportU(String str) {
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvStaticsticInterface
    public void ReportU(String str, int i2) {
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvStaticsticInterface
    public void ReportU(String str, String str2) {
        us.pinguo.foundation.statistics.g.b(str + "_" + str2);
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvStaticsticInterface
    public void ReportU(String str, Map<String, String> map) {
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvStaticsticInterface
    public void ReportU(String str, Map<String, String> map, int i2) {
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvStaticsticInterface
    public void ReportBD(String str, String str2, String str3) {
        j.a.f.f.onEvent(str2, str3);
        us.pinguo.foundation.statistics.g.b(str2 + PGTransHeader.CONNECTOR + str3);
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvStaticsticInterface
    public void ReportBDNoKey(String str, String str2) {
        j.a.f.f.onEvent(str, str2);
        us.pinguo.foundation.statistics.g.b(str + "_" + str2);
        AdvLog.Log(str + "_" + str2);
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvStaticsticInterface
    public void ReportBD(String str, String str2, String str3, String str4) {
        j.a.f.f.onEvent(str2, str3, str4);
        us.pinguo.foundation.statistics.g.b(str2 + PGTransHeader.CONNECTOR + str3 + "_" + str4);
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvStaticsticInterface
    public void ReportBDNoKey(String str, String str2, String str3) {
        j.a.f.f.onEvent(str, str2, str3);
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvStaticsticInterface
    public void ReportBD(String str, String str2, HashMap<String, String> hashMap) {
        j.a.f.f.onEvent(str2, hashMap);
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvStaticsticInterface
    public void ReportBDNoKey(String str, HashMap<String, String> hashMap) {
        j.a.f.f.onEvent(str, hashMap);
    }
}
