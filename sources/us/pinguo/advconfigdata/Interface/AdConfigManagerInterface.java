package us.pinguo.advconfigdata.Interface;

import android.content.Context;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import us.pinguo.advconfigdata.AdvLoadDataType;
import us.pinguo.advconfigdata.AdvThird.AdvThirdItem;
import us.pinguo.advconfigdata.database.AdvItem;
/* loaded from: classes3.dex */
public abstract class AdConfigManagerInterface {
    public abstract void addGuidDisplayCount(String str, String str2);

    public abstract void forceUpdate(boolean z);

    public abstract boolean getAdvControlFlag(String str, boolean z);

    public abstract int getAdvControlInt(String str, int i2);

    public abstract int getAdvDataVersion();

    public abstract int getGuidDisplayCount(String str, String str2);

    public abstract String getInitStamp();

    public abstract AdvItem getItem(String str);

    public abstract List<AdvItem> getItems(String str);

    public abstract List<AdvItem> getItems(String str, AdvLoadDataType advLoadDataType);

    public abstract List<AdvItem> getItemsNotForUI(String str);

    public abstract AdvItem getNextItem(String str, String str2, boolean z);

    public abstract void init(Context context, AdvConfig advConfig, AdvStaticsticInterface advStaticsticInterface);

    public abstract boolean isAdvIdExists(List<String> list, String str);

    public abstract AdvThirdItem loadDownloadedImage(AdvThirdItem advThirdItem);

    public abstract AdvItem loadDownloadedImage(String str);

    public abstract AdvItem loadDownloadedImage(AdvItem advItem);

    public abstract boolean loadImage(String str, AdvDownLoadLisenter advDownLoadLisenter);

    public abstract AdvItem loadPopupAdvItem(String str, String str2);

    public abstract void minusGuidDisplayCount(String str, String str2);

    public abstract String requestUrl(String str) throws IOException, GeneralSecurityException;

    public abstract void resetAdvVersion();

    public abstract void scheduleUpdate();

    public abstract void setAdvChangeListener(AdvDataChangeListener advDataChangeListener);
}
