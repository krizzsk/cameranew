package us.pinguo.common.widget.sample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.common.widget.R;
/* compiled from: SimpleActivity.kt */
/* loaded from: classes4.dex */
public final class SimpleActivity extends AppCompatActivity implements View.OnClickListener {
    public Map<Integer, View> a = new LinkedHashMap();

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i2 = R.id.btTabLayout;
        if (valueOf != null && valueOf.intValue() == i2) {
            startActivity(new Intent(this, PGBottomTabLayoutTestActivity.class));
            return;
        }
        int i3 = R.id.btDecoration;
        if (valueOf != null && valueOf.intValue() == i3) {
            startActivity(new Intent(this, DecorationTestActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_simple);
        ((Button) _$_findCachedViewById(R.id.btTabLayout)).setOnClickListener(this);
        ((Button) _$_findCachedViewById(R.id.btDecoration)).setOnClickListener(this);
    }
}
