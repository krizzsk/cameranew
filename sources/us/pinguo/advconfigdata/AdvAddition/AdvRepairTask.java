package us.pinguo.advconfigdata.AdvAddition;

import java.util.List;
import java.util.Map;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.DispatcherData.b;
import us.pinguo.advconfigdata.Utils.AdvUtils;
import us.pinguo.advconfigdata.database.AdvRepairInfoItem;
import us.pinguo.advconfigdata.database.AdvRepairItem;
/* loaded from: classes3.dex */
public class AdvRepairTask extends b {
    private AdvRepairItem mRepairData;

    @Override // us.pinguo.advconfigdata.DispatcherData.b
    protected void doInBackground() {
        AdvRepairInfoItem advRepairInfoItem;
        List<String> list;
        AdvRepairItem advRepairItem = this.mRepairData;
        if (advRepairItem == null || (advRepairInfoItem = advRepairItem.info) == null || (list = advRepairInfoItem.urls) == null || list.size() <= 0) {
            return;
        }
        int size = this.mRepairData.info.urls.size();
        AdvRepairInfoItem advRepairInfoItem2 = this.mRepairData.info;
        int i2 = advRepairInfoItem2.procInterval;
        boolean z = advRepairInfoItem2.procSeq == 0;
        boolean z2 = true;
        for (int i3 = 0; i3 < size && (!z || z2); i3++) {
            String str = this.mRepairData.info.urls.get(i3);
            if (i2 > 0) {
                try {
                    Thread.sleep(i2);
                } catch (Exception unused) {
                }
            }
            try {
                AdvUtils.get(str);
                z2 = true;
            } catch (Exception unused2) {
                z2 = false;
            }
        }
        try {
            Map<String, String> commonHttpParams = AdvConfigManager.getInstance().getCommonHttpParams();
            commonHttpParams.put("taskId", this.mRepairData.info.taskId);
            String sigByParamMap = AdvUtils.getSigByParamMap(commonHttpParams, AdvConfigManager.getInstance().getAdvConfig().getHttpRequestMD5Secret());
            String url = AdvUtils.getUrl(AdvConfigManager.AD_CALLBACK_REPAIR, commonHttpParams);
            AdvUtils.get(url + "&sig=" + sigByParamMap);
        } catch (Exception unused3) {
        }
    }

    public void execute(AdvRepairItem advRepairItem) {
        this.mRepairData = advRepairItem;
        super.execute();
    }
}
