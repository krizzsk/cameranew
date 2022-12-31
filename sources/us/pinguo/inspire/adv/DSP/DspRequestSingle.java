package us.pinguo.inspire.adv.DSP;

import us.pinguo.admobvista.DataBean.InputAdvItem;
import us.pinguo.advconfigdata.AdvThird.AdvThirdItem;
import us.pinguo.advconfigdata.AdvThird.AdvThirdItemListener;
import us.pinguo.advconfigdata.database.AdvItem;
/* loaded from: classes9.dex */
public class DspRequestSingle {
    private InputAdvItem mInputItem;
    private DspListener mListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a implements AdvThirdItemListener {
        a() {
        }

        @Override // us.pinguo.advconfigdata.AdvThird.AdvThirdItemListener
        public void onAdvCanceled() {
            DspRequestSingle.this.mListener.onFailed("", DspManager.GetDspKey(DspRequestSingle.this.mInputItem));
        }

        @Override // us.pinguo.advconfigdata.AdvThird.AdvThirdItemListener
        public void onAdvFailed() {
            DspRequestSingle.this.mListener.onFailed("", DspManager.GetDspKey(DspRequestSingle.this.mInputItem));
        }

        @Override // us.pinguo.advconfigdata.AdvThird.AdvThirdItemListener
        public void onAdvLoaded(AdvThirdItem advThirdItem) {
            if (advThirdItem == null || DspRequestSingle.this.mListener == null) {
                return;
            }
            DspRequestSingle.this.mListener.onSuccess(advThirdItem, DspManager.GetDspKey(DspRequestSingle.this.mInputItem));
        }
    }

    public DspRequestSingle(InputAdvItem inputAdvItem, DspListener dspListener) {
        this.mInputItem = inputAdvItem;
        this.mListener = dspListener;
        RequestData();
    }

    private AdvItem ConstructAdvItem(InputAdvItem inputAdvItem) {
        AdvItem advItem = new AdvItem();
        InputAdvItem inputAdvItem2 = this.mInputItem;
        String str = inputAdvItem2.advId;
        advItem.advId = str;
        advItem.interactionUri = inputAdvItem2.advData.dspCallUrl;
        advItem.guid = str;
        return advItem;
    }

    private void RequestData() {
        AdvItem ConstructAdvItem = ConstructAdvItem(this.mInputItem);
        if (ConstructAdvItem != null && ConstructAdvItem.needLoadThirdAdv()) {
            ConstructAdvItem.loadThirdAdv(new a());
        }
    }
}
