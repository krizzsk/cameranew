package com.pinguo.camera360.member;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.foundation.base.BaseActivity;
import vStudio.Android.Camera360.R;
/* compiled from: BaseToolbarActivity.kt */
/* loaded from: classes3.dex */
public abstract class BaseToolbarActivity extends BaseActivity {

    /* renamed from: e  reason: collision with root package name */
    private static final String f6872e = BaseToolbarActivity.class.getSimpleName();
    public Map<Integer, View> a = new LinkedHashMap();
    private TextView b;
    private TextView c;

    /* renamed from: d  reason: collision with root package name */
    private Toolbar f6873d;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(BaseToolbarActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.onBackPressed();
    }

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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(q0());
        this.f6873d = (FitsSystemToolbar) _$_findCachedViewById(R.id.pg_toolbar);
        this.b = (TextView) _$_findCachedViewById(R.id.toolbar_title);
        this.c = (TextView) _$_findCachedViewById(R.id.toolbar_subtitle);
        Toolbar toolbar = this.f6873d;
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        TextView textView = this.b;
        if (textView != null) {
            kotlin.jvm.internal.s.e(textView);
            textView.setText(getTitle());
            ActionBar supportActionBar = getSupportActionBar();
            kotlin.jvm.internal.s.e(supportActionBar);
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Log.v(f6872e, "onDestroy...");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.f6873d == null || !u0()) {
            return;
        }
        w0();
    }

    protected abstract int q0();

    /* JADX INFO: Access modifiers changed from: protected */
    public final Toolbar r0() {
        return this.f6873d;
    }

    public final TextView s0() {
        return this.c;
    }

    public final TextView t0() {
        return this.b;
    }

    protected final boolean u0() {
        return true;
    }

    public void w0() {
        Toolbar toolbar = this.f6873d;
        kotlin.jvm.internal.s.e(toolbar);
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_material);
        Toolbar toolbar2 = this.f6873d;
        kotlin.jvm.internal.s.e(toolbar2);
        toolbar2.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.member.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseToolbarActivity.x0(BaseToolbarActivity.this, view);
            }
        });
    }
}
