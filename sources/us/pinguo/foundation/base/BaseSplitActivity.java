package us.pinguo.foundation.base;

import android.content.Context;
import us.pinguo.foundation.Conditions;
/* compiled from: BaseSplitActivity.kt */
/* loaded from: classes4.dex */
public abstract class BaseSplitActivity extends SubscriptionActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        if (Conditions.c() || Conditions.d()) {
            com.google.android.play.core.splitcompat.a.j(this);
        }
    }
}
