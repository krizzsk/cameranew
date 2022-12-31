package us.pinguo.inspire.module.attention;

import android.app.Activity;
import android.content.Intent;
/* loaded from: classes9.dex */
public class IntentAttention {
    public static void intentToAttentionOrFans(Activity activity, String str, String str2, int i2) {
        Intent intent = new Intent();
        intent.setClassName(activity, "us.pinguo.inspire.module.attention.AttentionActivity");
        intent.putExtra(InsprieAttentionFragment.MASTER_ID_KEY, str);
        intent.putExtra(AttentionActivity.FROM_KEY, str2);
        activity.startActivityForResult(intent, i2);
    }
}
