package us.pinguo.advconfigdata.AdvAddition;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.e;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.Utils.AdvPrefUtil;
import us.pinguo.advconfigdata.database.AdvRepairItem;
/* loaded from: classes3.dex */
public class ExecuteAdvRepair {
    private final String KEY_HISTORY_TASK_ID = "history_task_id";
    private e mGson = new e();
    private List<String> mTaskIds;

    /* loaded from: classes3.dex */
    class a extends com.google.gson.t.a<ArrayList<String>> {
        a(ExecuteAdvRepair executeAdvRepair) {
        }
    }

    public ExecuteAdvRepair(Context context) {
        String string = AdvPrefUtil.getInstance().getString("history_task_id");
        if (!TextUtils.isEmpty(string)) {
            this.mTaskIds = (List) this.mGson.k(string, new a(this).getType());
        }
        if (this.mTaskIds == null) {
            this.mTaskIds = new ArrayList();
        }
    }

    public void StartThread() {
        List<AdvRepairItem> q = AdvConfigManager.getInstance().getAdvDataKeeper().q();
        if (q == null) {
            return;
        }
        for (int i2 = 0; i2 < q.size(); i2++) {
            String str = q.get(i2).info.taskId;
            if (!this.mTaskIds.contains(str)) {
                new AdvRepairTask().execute(q.get(i2));
                this.mTaskIds.add(str);
            }
        }
        AdvPrefUtil.getInstance().putString("history_task_id", this.mGson.s(this.mTaskIds));
    }
}
