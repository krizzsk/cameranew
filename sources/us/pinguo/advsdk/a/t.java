package us.pinguo.advsdk.a;

import java.util.Map;
import us.pinguo.advstrategy.strategybean.StrategyItem;
/* compiled from: IStrategyKeeper.java */
/* loaded from: classes3.dex */
public abstract class t {
    public abstract String getAppHost();

    public abstract String getCountryCode();

    public abstract boolean getGlobleOpenKey(String str, String str2);

    public abstract int getStrategyDataInterval();

    public abstract String getStrategyDataVersion();

    public abstract String getStrategyEtag();

    public abstract StrategyItem getStrategyItem(String str);

    public abstract Map<String, StrategyItem> getStrategyItems();

    public abstract String getUpdateInfo(String str);

    public abstract boolean saveAdvData(byte[] bArr);
}
