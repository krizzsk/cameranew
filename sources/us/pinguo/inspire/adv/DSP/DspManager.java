package us.pinguo.inspire.adv.DSP;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import us.pinguo.admobvista.DataBean.InputAdvItem;
import us.pinguo.advconfigdata.AdvThird.AdvThirdItem;
/* loaded from: classes9.dex */
public class DspManager implements DspListener {
    private static DspManager mInstance;
    private Map<String, AdvThirdItem> mDataAdv = new HashMap();
    private Map<String, InputAdvItem> mDataSrc = new HashMap();
    private Map<String, Boolean> mDataReqesting = new HashMap();
    private Map<String, DspListener> mDataCallbacks = new HashMap();

    public static String GetDspKey(InputAdvItem inputAdvItem) {
        if (inputAdvItem == null || TextUtils.isEmpty(inputAdvItem.advId)) {
            return null;
        }
        return inputAdvItem.advId;
    }

    public static DspManager GetInstance() {
        if (mInstance == null) {
            mInstance = new DspManager();
        }
        return mInstance;
    }

    public void AddCallback(InputAdvItem inputAdvItem, DspListener dspListener) {
        if (dspListener == null) {
            return;
        }
        String GetDspKey = GetDspKey(inputAdvItem);
        if (TextUtils.isEmpty(GetDspKey)) {
            return;
        }
        if (this.mDataCallbacks.containsKey(GetDspKey)) {
            this.mDataCallbacks.remove(GetDspKey);
        }
        this.mDataCallbacks.put(GetDspKey, dspListener);
    }

    public AdvThirdItem GetDspCache(InputAdvItem inputAdvItem) {
        String GetDspKey = GetDspKey(inputAdvItem);
        if (TextUtils.isEmpty(GetDspKey)) {
            return null;
        }
        if (!this.mDataAdv.containsKey(GetDspKey)) {
            StartRequestDsp(inputAdvItem);
            return null;
        }
        return this.mDataAdv.get(GetDspKey);
    }

    public void NotifyOuter(String str) {
        if (this.mDataAdv.containsKey(str) && this.mDataCallbacks.containsKey(str)) {
            this.mDataCallbacks.get(str).onSuccess(this.mDataAdv.get(str), str);
        }
    }

    public void RefreshDsp(InputAdvItem inputAdvItem, DspListener dspListener) {
        if (dspListener == null) {
            return;
        }
        String GetDspKey = GetDspKey(inputAdvItem);
        if (TextUtils.isEmpty(GetDspKey)) {
            return;
        }
        if (!this.mDataCallbacks.containsKey(GetDspKey)) {
            this.mDataCallbacks.put(GetDspKey, dspListener);
        }
        StartRequestDsp(inputAdvItem);
    }

    public void ResetDsp() {
    }

    public void StartRequestDsp(InputAdvItem inputAdvItem) {
        String GetDspKey = GetDspKey(inputAdvItem);
        if (TextUtils.isEmpty(GetDspKey)) {
            return;
        }
        if (this.mDataReqesting.containsKey(GetDspKey) && this.mDataReqesting.get(GetDspKey).booleanValue()) {
            return;
        }
        this.mDataReqesting.put(GetDspKey, Boolean.TRUE);
        new DspRequestSingle(inputAdvItem, this);
    }

    @Override // us.pinguo.inspire.adv.DSP.DspListener
    public void onFailed(String str, String str2) {
        this.mDataReqesting.remove(str2);
    }

    @Override // us.pinguo.inspire.adv.DSP.DspListener
    public void onSuccess(AdvThirdItem advThirdItem, String str) {
        this.mDataReqesting.remove(str);
        if (advThirdItem == null) {
            return;
        }
        if (this.mDataAdv.containsKey(str)) {
            this.mDataAdv.remove(str);
        }
        this.mDataAdv.put(str, advThirdItem);
        NotifyOuter(str);
    }
}
