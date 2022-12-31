package us.pinguo.advconfigdata.AdvCacheInterface;

import android.util.Log;
import java.util.List;
/* loaded from: classes3.dex */
public class AdvCtrlCondition<T> {
    private AdvParams mConditionConfig;
    private T mLastData;
    private List<T> mListData;
    private int mMaxNum = 1;
    private int mCurIndex = -1;
    private int mCurShowTimes = 0;
    private long mActiveTime = 0;

    public AdvCtrlCondition(AdvParams advParams) {
        this.mConditionConfig = advParams;
    }

    private void RestCount() {
        this.mCurIndex = -1;
        this.mCurShowTimes = 0;
        this.mActiveTime = System.currentTimeMillis();
    }

    public void Clear() {
        this.mListData.clear();
        RestCount();
    }

    public T GetLastData() {
        return this.mLastData;
    }

    public T GetNewAd() {
        if (this.mListData == null || IsNeedLoad()) {
            return null;
        }
        if (this.mCurIndex == -1) {
            this.mCurIndex = 0;
        }
        if (this.mCurShowTimes >= this.mConditionConfig.GetTapCount()) {
            this.mCurIndex++;
        }
        this.mCurShowTimes++;
        T t = this.mListData.get(this.mCurIndex);
        this.mLastData = t;
        return t;
    }

    public T GetNextAdNotIncreaseIndex() {
        if (this.mListData == null || IsNeedLoad()) {
            return null;
        }
        int i2 = this.mCurIndex;
        if (i2 == -1) {
            i2 = 0;
        }
        if (this.mCurShowTimes < this.mConditionConfig.GetTapCount()) {
            return this.mListData.get(i2);
        }
        return this.mListData.get(i2 + 1);
    }

    public boolean IsNeedLoad() {
        List<T> list = this.mListData;
        if (list != null && !list.isEmpty()) {
            if (this.mCurShowTimes >= this.mMaxNum && this.mCurIndex + 1 >= this.mListData.size()) {
                Log.e("test", "需要加载mCurIndex:" + this.mCurIndex + "  mListData.size():" + this.mListData.size());
                return true;
            } else if (Math.abs(System.currentTimeMillis() - this.mActiveTime) >= this.mConditionConfig.GetCacheTime()) {
                Log.e("test", "需要加载过期了");
                return true;
            } else if (this.mCurShowTimes < this.mConditionConfig.GetTapCount() && this.mCurIndex + 1 >= this.mListData.size()) {
                Log.e("test", "需要加载:mCurIndex");
                return true;
            } else {
                Log.e("test", "不需要加载");
                return false;
            }
        }
        Log.e("test", "mCampaignListNew为空");
        return true;
    }

    public void SetNewData(List<T> list) {
        this.mListData = list;
        RestCount();
    }

    public int getCurIndex() {
        return this.mCurIndex;
    }

    public int getListSize() {
        if (this.mLastData == null) {
            return 0;
        }
        return this.mListData.size();
    }

    public AdvParams getParams() {
        return this.mConditionConfig;
    }
}
