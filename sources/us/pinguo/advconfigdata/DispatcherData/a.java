package us.pinguo.advconfigdata.DispatcherData;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.Utils.AdvConstants;
import us.pinguo.advconfigdata.Utils.AdvLog;
import us.pinguo.advconfigdata.Utils.AdvUtils;
/* compiled from: AdvDecodeErrorReportTask.java */
/* loaded from: classes3.dex */
public class a extends b {
    String a;
    Map<String, String> b;

    public a(String str) {
        this.a = str;
    }

    private void a() {
        try {
            Map<String, String> commonHttpParams = AdvConfigManager.getInstance().getCommonHttpParams();
            if (commonHttpParams == null) {
                commonHttpParams = new HashMap<>();
            }
            if (!TextUtils.isEmpty(this.a)) {
                commonHttpParams.put(AdvConstants.key_report_decode_error, this.a);
            }
            Map<String, String> map = this.b;
            if (map != null) {
                commonHttpParams.putAll(map);
            }
            String sigByParamMap = AdvUtils.getSigByParamMap(commonHttpParams, AdvConfigManager.getInstance().getAdvConfig().getHttpRequestMD5Secret());
            String str = AdvUtils.getUrl(AdvConfigManager.AD_REPORT_DECODE_ERROR, commonHttpParams) + "&sig=" + sigByParamMap;
            AdvLog.Log("send request : " + str);
            AdvUtils.get(str);
        } catch (Exception e2) {
            AdvLog.Log(e2.getMessage());
        }
    }

    @Override // us.pinguo.advconfigdata.DispatcherData.b
    protected void doInBackground() {
        a();
    }

    public a(Map<String, String> map) {
        this.b = map;
    }
}
