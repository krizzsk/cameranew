package us.pinguo.poker;

import android.text.TextUtils;
import com.tapjoy.TJAdUnitConstants;
import org.json.JSONObject;
/* compiled from: PokerResult.java */
/* loaded from: classes5.dex */
public class q {
    String a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q b(JSONObject jSONObject) {
        q qVar = new q();
        jSONObject.optString("url");
        jSONObject.optString(TJAdUnitConstants.String.STYLE);
        qVar.a = jSONObject.optString("pic_art");
        if (qVar.a()) {
            return qVar;
        }
        throw new IllegalArgumentException("error arg:" + jSONObject);
    }

    boolean a() {
        return !TextUtils.isEmpty(this.a);
    }
}
