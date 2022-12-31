package us.pinguo.advstrategy;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.net.URLDecoder;
import java.util.HashMap;
import org.json.JSONObject;
import us.pinguo.advsdk.network.AbsAdvBaseTask;
import us.pinguo.advsdk.network.g;
import us.pinguo.advsdk.utils.b;
/* loaded from: classes3.dex */
class AdvLinkReportTask extends AbsAdvBaseTask {
    private String mFilePath;
    private String mLinkDestUrl;
    private String mServerUrl;
    private int mStatus;

    public AdvLinkReportTask(Context context, int i2, String str, String str2, String str3) {
        super(context);
        this.mServerUrl = str;
        this.mStatus = i2;
        this.mLinkDestUrl = str2;
        this.mFilePath = str3;
    }

    private void statReport() throws Exception {
        File file;
        if (TextUtils.isEmpty(this.mServerUrl)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", 2);
        jSONObject.put("checkStatus", this.mStatus);
        jSONObject.put("landingUrl", TextUtils.isEmpty(this.mLinkDestUrl) ? "" : this.mLinkDestUrl);
        String str = new String(jSONObject.toString().getBytes(), "UTF-8");
        b.a("statReport data: " + str);
        String entryData = getEntryData(URLDecoder.decode(str, "UTF-8"), false);
        HashMap hashMap = new HashMap();
        hashMap.put("data", entryData);
        if (this.mStatus != 3 || TextUtils.isEmpty(this.mFilePath)) {
            file = null;
        } else {
            file = new File(this.mFilePath);
            if (!file.exists()) {
                file = null;
            }
            b.a("file exists:" + file.exists());
        }
        g.k().s(this.mServerUrl, hashMap, file, null);
    }

    @Override // us.pinguo.advsdk.network.AbsAdvBaseTask
    protected void doInBackground() {
        try {
            statReport();
        } catch (Exception e2) {
            b.a(e2.getMessage());
        }
    }
}
