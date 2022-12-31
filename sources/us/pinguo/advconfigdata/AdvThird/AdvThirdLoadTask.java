package us.pinguo.advconfigdata.AdvThird;

import android.os.Handler;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.DispatcherData.b;
import us.pinguo.advconfigdata.Utils.AdvLog;
import us.pinguo.advconfigdata.Utils.AdvUtils;
/* loaded from: classes3.dex */
public class AdvThirdLoadTask extends b {
    private AdvThirdItemListener mListener;
    private Runnable mNotifyRunnable = new a();
    private String mOriginUrl;
    private AdvThirdItem mResult;

    /* loaded from: classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AdvThirdLoadTask.this.mListener != null) {
                if (AdvThirdLoadTask.this.mResult != null) {
                    AdvThirdLoadTask.this.mListener.onAdvLoaded(AdvThirdLoadTask.this.mResult);
                } else {
                    AdvThirdLoadTask.this.mListener.onAdvFailed();
                }
            }
            AdvThirdLoadTask.this.mListener = null;
        }
    }

    @Override // us.pinguo.advconfigdata.DispatcherData.b
    protected void doInBackground() {
        String str;
        Map<String, String> thirdLoadHttpParams = AdvThirdManager.getThirdManager().getThirdLoadHttpParams();
        String str2 = this.mOriginUrl;
        try {
            int indexOf = str2.indexOf(63);
            if (indexOf > 0) {
                str2 = this.mOriginUrl.substring(0, indexOf);
                String substring = this.mOriginUrl.substring(indexOf + 1);
                int length = substring.length();
                int i2 = 0;
                while (true) {
                    int indexOf2 = substring.indexOf(38, i2);
                    int i3 = indexOf2 != -1 ? indexOf2 : length;
                    int indexOf3 = substring.indexOf(61, i2);
                    if (indexOf3 > i3 || indexOf3 == -1) {
                        indexOf3 = i3;
                    }
                    thirdLoadHttpParams.put(substring.substring(i2, indexOf3), substring.substring(indexOf3 + 1, i3));
                    if (indexOf2 == -1) {
                        break;
                    }
                    i2 = indexOf2 + 1;
                }
            }
        } catch (Exception unused) {
            str2 = this.mOriginUrl;
        }
        String sigByParamMap = AdvUtils.getSigByParamMap(thirdLoadHttpParams, AdvConfigManager.getInstance().getAdvConfig().getHttpRequestMD5Secret());
        try {
            str = AdvUtils.getUrl(str2, thirdLoadHttpParams) + "&sig=" + sigByParamMap;
        } catch (UnsupportedEncodingException unused2) {
            str = null;
        }
        AdvLog.Log("AdvThirdLoadTask request : " + str);
        try {
            JSONObject jSONObject = new JSONObject(AdvUtils.get(str)).getJSONObject("data");
            AdvThirdItem advThirdItem = new AdvThirdItem();
            this.mResult = advThirdItem;
            advThirdItem.icon = jSONObject.optString("icon", "");
            this.mResult.thirdJumpUrl = jSONObject.optString("thirdJumpUrl", "");
            this.mResult.from = jSONObject.optString("from", "");
            this.mResult.adTitle = jSONObject.optString("adTitle", "");
            this.mResult.headurl = jSONObject.optString("headUrl", "");
            this.mResult.clickUrl = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("clickUrl");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    String optString = optJSONArray.optString(i4);
                    if (optString != null) {
                        this.mResult.clickUrl.add(optString);
                    }
                }
            }
            this.mResult.impressionUrl = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("impressionUrl");
            if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                return;
            }
            for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                String optString2 = optJSONArray2.optString(i5);
                if (optString2 != null) {
                    this.mResult.impressionUrl.add(optString2);
                }
            }
        } catch (Exception e2) {
            AdvLog.Log(e2.getMessage());
            this.mResult = null;
        }
    }

    public void execute(String str) {
        this.mOriginUrl = str;
        super.execute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.advconfigdata.DispatcherData.b
    public void onCancelled() {
        super.onCancelled();
        AdvThirdItemListener advThirdItemListener = this.mListener;
        if (advThirdItemListener != null) {
            advThirdItemListener.onAdvCanceled();
        }
        this.mListener = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.advconfigdata.DispatcherData.b
    public void onPostExecute() {
        super.onPostExecute();
        Handler uIHandler = AdvConfigManager.getInstance().getUIHandler();
        if (uIHandler != null) {
            uIHandler.post(this.mNotifyRunnable);
        }
    }

    public void setListener(AdvThirdItemListener advThirdItemListener) {
        this.mListener = advThirdItemListener;
    }
}
