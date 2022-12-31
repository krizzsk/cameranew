package us.pinguo.hawkeye.debug;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import kotlin.jvm.internal.s;
import us.pinguo.hawkeye.R;
/* compiled from: DebugSettingsActivity.kt */
/* loaded from: classes4.dex */
public final class DebugSettingsActivity extends Activity {

    /* compiled from: DebugSettingsActivity.kt */
    /* loaded from: classes4.dex */
    static final class a implements CompoundButton.OnCheckedChangeListener {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        @Instrumented
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            VdsAgent.onCheckedChanged(this, compoundButton, z);
            us.pinguo.hawkeye.debug.b.a.g(this.a, z);
        }
    }

    /* compiled from: DebugSettingsActivity.kt */
    /* loaded from: classes4.dex */
    static final class b implements CompoundButton.OnCheckedChangeListener {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        @Instrumented
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            VdsAgent.onCheckedChanged(this, compoundButton, z);
            us.pinguo.hawkeye.debug.b.a.f(this.a, z);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.hawkeye_settings_activity);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.settings_container);
        for (String str : us.pinguo.hawkeye.debug.b.a.a()) {
            View inflate = View.inflate(this, R.layout.view_block, null);
            TextView title = (TextView) inflate.findViewById(R.id.title);
            s.d(title, "title");
            title.setText(str);
            CheckBox methodTracingCheck = (CheckBox) inflate.findViewById(R.id.method_trace_check);
            s.d(methodTracingCheck, "methodTracingCheck");
            us.pinguo.hawkeye.debug.b bVar = us.pinguo.hawkeye.debug.b.a;
            methodTracingCheck.setChecked(bVar.c(str));
            methodTracingCheck.setOnCheckedChangeListener(new a(str));
            CheckBox debugHelperCheck = (CheckBox) inflate.findViewById(R.id.debug_helper_check);
            s.d(debugHelperCheck, "debugHelperCheck");
            debugHelperCheck.setChecked(bVar.b(str));
            debugHelperCheck.setOnCheckedChangeListener(new b(str));
            linearLayout.addView(inflate);
        }
    }
}
