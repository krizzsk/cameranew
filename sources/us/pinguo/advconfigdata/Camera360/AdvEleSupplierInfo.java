package us.pinguo.advconfigdata.Camera360;

import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.Utils.AdvConstants;
/* loaded from: classes3.dex */
public class AdvEleSupplierInfo {
    public long activeTime;
    public String advId;
    public long expireTime;
    public String taskAction;
    public String taskId;
    public int taskTimes;
    public String taskType;

    public void addGuidDisplayCount() {
        AdvConfigManager.getInstance().addGuidDisplayCount(AdvConstants.GUID_EleSupplier, this.advId);
        AdvConfigManager.getInstance().postSavePrefs();
    }

    public int getGuidDisplayCount() {
        return AdvConfigManager.getInstance().getGuidDisplayCount(AdvConstants.GUID_EleSupplier, this.advId);
    }

    public void minusGuidDisplayCount() {
        AdvConfigManager.getInstance().minusGuidDisplayCount(AdvConstants.GUID_EleSupplier, this.advId);
        AdvConfigManager.getInstance().postSavePrefs();
    }
}
