package us.pinguo.advconfigdata.AdvAddition;

import android.text.TextUtils;
import java.util.List;
import us.pinguo.advconfigdata.DispatcherData.b;
import us.pinguo.advconfigdata.Utils.AdvUtils;
/* loaded from: classes3.dex */
public class AdvPVTask extends b {
    private List<String> mPVUrls;

    @Override // us.pinguo.advconfigdata.DispatcherData.b
    protected void doInBackground() {
        List<String> list = this.mPVUrls;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.mPVUrls.size(); i2++) {
            String str = this.mPVUrls.get(i2);
            if (!TextUtils.isEmpty(str)) {
                try {
                    AdvUtils.get(str);
                } catch (Exception unused) {
                }
            }
        }
    }

    public void execute(List<String> list) {
        this.mPVUrls = list;
        super.execute();
    }
}
