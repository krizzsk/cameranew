package us.pinguo.advconfigdata.AdvAddition;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;
import us.pinguo.advconfigdata.Utils.AdvPrefUtil;
import us.pinguo.advconfigdata.Utils.AdvUtils;
/* loaded from: classes3.dex */
public class AdvAdditionController {
    private static final String ADDITION_KEY = "addition_key";
    private static final int MAX_SIZE = 30;
    private Runnable mSavePrefsRunnable = new a();
    private Handler mUiHandler = new Handler(Looper.getMainLooper());
    private final HashMap<String, Integer> mAdvIdAdditionMap = new LinkedHashMap<String, Integer>(10, 0.75f, true) { // from class: us.pinguo.advconfigdata.AdvAddition.AdvAdditionController.2
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, Integer> entry) {
            return size() > 30;
        }
    };

    /* loaded from: classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AdvAdditionController.this.save();
        }
    }

    public AdvAdditionController() {
        load();
    }

    public static void exeAdvAddition(String str, String str2) {
        if (TextUtils.isEmpty(str) || str.length() < 8 || TextUtils.isEmpty(str2)) {
            return;
        }
        new AdvAdditionController().execute(str, str2);
    }

    private void load() {
        this.mAdvIdAdditionMap.clear();
        String string = AdvPrefUtil.getInstance().getString(ADDITION_KEY);
        if (string.length() > 0) {
            String[] split = string.split(";");
            if (split.length > 0) {
                for (String str : split) {
                    try {
                        String[] split2 = str.split(",");
                        if (split2.length == 2) {
                            this.mAdvIdAdditionMap.put(split2[0], Integer.valueOf(Integer.parseInt(split2[1])));
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    private void postSavePrefs() {
        this.mUiHandler.removeCallbacks(this.mSavePrefsRunnable);
        this.mUiHandler.post(this.mSavePrefsRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void save() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : this.mAdvIdAdditionMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value != null) {
                sb.append(key);
                sb.append(',');
                sb.append(value);
                sb.append(';');
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ';') {
            sb.deleteCharAt(sb.length() - 1);
        }
        AdvPrefUtil.getInstance().putString(ADDITION_KEY, sb.toString());
    }

    void execute(String str, String str2) {
        if (TextUtils.isEmpty(str) || str.length() < 8 || TextUtils.isEmpty(str2) || hasUseAdditionData(str)) {
            return;
        }
        String advDecrypt = AdvUtils.advDecrypt(str2, str.substring(str.length() - 8));
        if (TextUtils.isEmpty(advDecrypt)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(advDecrypt);
            AdvAdditionData advAdditionData = new AdvAdditionData();
            advAdditionData.advId = str;
            advAdditionData.clkUrl1 = jSONObject.getString("clkUrl1");
            advAdditionData.clkUrl2 = jSONObject.optString("clkUrl2");
            advAdditionData.clkUrl1CallBack = jSONObject.optString("clkUrl1CallBack");
            advAdditionData.clkUrl2CallBack = jSONObject.optString("clkUrl2CallBack");
            advAdditionData.clkInterval1 = jSONObject.optInt("clkInterval1");
            advAdditionData.clkInterval2 = jSONObject.optInt("clkInterval2");
            new us.pinguo.advconfigdata.AdvAddition.a().a(advAdditionData);
            this.mAdvIdAdditionMap.put(advAdditionData.advId, 1);
            postSavePrefs();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    boolean hasUseAdditionData(String str) {
        Integer num = this.mAdvIdAdditionMap.get(str);
        return num != null && num.intValue() > 0;
    }
}
