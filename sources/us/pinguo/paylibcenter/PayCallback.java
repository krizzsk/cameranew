package us.pinguo.paylibcenter;

import us.pinguo.inspire.module.MissionDetail.TaskDetailBasePresenter;
import us.pinguo.paylibcenter.bean.PayResult;
/* loaded from: classes5.dex */
public interface PayCallback {

    /* loaded from: classes5.dex */
    public enum PAYSTATUS {
        SUCCESS("1"),
        CANCEL("2"),
        FAIL("0"),
        EXCEPTION(TaskDetailBasePresenter.SCENE_LIST);
        
        public String value;

        PAYSTATUS(String str) {
            this.value = str;
        }
    }

    void H(PayResult payResult);

    void W();

    void d(PayResult payResult);

    void e(PayResult payResult);

    void s();
}
