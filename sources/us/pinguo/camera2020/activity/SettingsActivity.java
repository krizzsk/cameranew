package us.pinguo.camera2020.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.camera2020.R;
import us.pinguo.common.utils.g;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.user.User;
import us.pinguo.user.v0;
import us.pinguo.user.w0;
/* compiled from: SettingsActivity.kt */
/* loaded from: classes2.dex */
public final class SettingsActivity extends BaseActivity {
    public Map<Integer, View> a = new LinkedHashMap();
    private int b = us.pinguo.foundation.j.e().i("hairCut", 0);
    private final kotlin.f c = new ViewModelLazy(kotlin.jvm.internal.v.b(us.pinguo.camera2020.viewmodel.b.class), new SettingsActivity$special$$inlined$viewModels$default$2(this), new SettingsActivity$special$$inlined$viewModels$default$1(this));

    /* compiled from: SettingsActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a implements g.a {
        a() {
        }

        @Override // us.pinguo.common.utils.g.a
        public void a(int i2) {
            if (i2 == 0) {
                SettingsActivity.this.r0().f().setValue(Boolean.TRUE);
            } else if (i2 != 1) {
            } else {
                SettingsActivity.this.r0().f().setValue(Boolean.FALSE);
            }
        }
    }

    private final void I0(View view) {
        String string = getString(R.string.txt_home_page);
        kotlin.jvm.internal.s.g(string, "getString(R.string.txt_home_page)");
        String string2 = getString(R.string.txt_launch_camera);
        kotlin.jvm.internal.s.g(string2, "getString(R.string.txt_launch_camera)");
        us.pinguo.common.utils.g.a.e(this, new CharSequence[]{string, string2}, view, new a(), !kotlin.jvm.internal.s.c(r0().f().getValue(), Boolean.TRUE) ? 1 : 0);
    }

    private final void initView() {
        ((ConstraintLayout) _$_findCachedViewById(R.id.root)).setPadding(0, this.b, 0, 0);
        ((Toolbar) _$_findCachedViewById(R.id.tbTitle)).setNavigationOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.activity.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsActivity.s0(SettingsActivity.this, view);
            }
        });
        ((ConstraintLayout) _$_findCachedViewById(R.id.clCaptureConfig)).setOnClickListener(i.a);
        int i2 = R.id.clAccountManager;
        ConstraintLayout clAccountManager = (ConstraintLayout) _$_findCachedViewById(i2);
        kotlin.jvm.internal.s.g(clAccountManager, "clAccountManager");
        int i3 = User.d().n() ? 0 : 8;
        clAccountManager.setVisibility(i3);
        VdsAgent.onSetViewVisibility(clAccountManager, i3);
        ((ConstraintLayout) _$_findCachedViewById(i2)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.activity.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsActivity.u0(SettingsActivity.this, view);
            }
        });
        ((ConstraintLayout) _$_findCachedViewById(R.id.clNotification)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.activity.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsActivity.v0(SettingsActivity.this, view);
            }
        });
        ((ConstraintLayout) _$_findCachedViewById(R.id.clSaveConfig)).setOnClickListener(c.a);
        ((ConstraintLayout) _$_findCachedViewById(R.id.clPrivacySetting)).setOnClickListener(d.a);
        ((ConstraintLayout) _$_findCachedViewById(R.id.clLaunchPage)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.activity.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsActivity.y0(SettingsActivity.this, view);
            }
        });
        r0().f().observe(this, new Observer() { // from class: us.pinguo.camera2020.activity.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SettingsActivity.z0(SettingsActivity.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final us.pinguo.camera2020.viewmodel.b r0() {
        return (us.pinguo.camera2020.viewmodel.b) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(SettingsActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        us.pinguo.common.utils.g gVar = us.pinguo.common.utils.g.a;
        if (us.pinguo.edit2020.utils.d.d(gVar.a())) {
            PopupWindow a2 = gVar.a();
            kotlin.jvm.internal.s.e(a2);
            if (a2.isShowing()) {
                PopupWindow a3 = gVar.a();
                kotlin.jvm.internal.s.e(a3);
                a3.dismiss();
                gVar.d(null);
                return;
            }
        }
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(View view) {
        VdsAgent.lambdaOnClick(view);
        Intent intent = new Intent();
        intent.setClassName(view.getContext(), "us.pinguo.camera2020.activity.ViewFinderSettingsActivity");
        view.getContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(SettingsActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (User.d().n()) {
            Intent intent = new Intent();
            intent.setClassName(view.getContext(), "com.pinguo.camera360.ui.PersonalInformation");
            this$0.startActivityForResult(intent, 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(SettingsActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (User.d().n()) {
            Intent intent = new Intent();
            intent.setClassName(view.getContext(), "com.pinguo.camera360.camera.options.OptionsNotificationSettings");
            view.getContext().startActivity(intent);
            return;
        }
        w0.j(0);
        v0.h(this$0, 7070, -999, "personal_center");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(View view) {
        VdsAgent.lambdaOnClick(view);
        Intent intent = new Intent();
        intent.setClassName(view.getContext(), "com.pinguo.camera360.camera.options.OptionsPictures");
        view.getContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(View view) {
        VdsAgent.lambdaOnClick(view);
        Intent intent = new Intent();
        intent.setClassName(view.getContext(), "com.pinguo.camera360.camera.options.OptionsPrivacySettings");
        view.getContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(SettingsActivity this$0, View v) {
        VdsAgent.lambdaOnClick(v);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.g(v, "v");
        this$0.I0(v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(SettingsActivity this$0, Boolean it) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.g(it, "it");
        if (it.booleanValue()) {
            ((TextView) this$0._$_findCachedViewById(R.id.txtChooseLaunchPage)).setText(this$0.getString(R.string.txt_home_page));
        } else {
            ((TextView) this$0._$_findCachedViewById(R.id.txtChooseLaunchPage)).setText(this$0.getString(R.string.txt_launch_camera));
        }
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

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        us.pinguo.common.utils.g gVar = us.pinguo.common.utils.g.a;
        if (us.pinguo.edit2020.utils.d.d(gVar.a())) {
            PopupWindow a2 = gVar.a();
            kotlin.jvm.internal.s.e(a2);
            if (a2.isShowing()) {
                PopupWindow a3 = gVar.a();
                kotlin.jvm.internal.s.e(a3);
                a3.dismiss();
                gVar.d(null);
                return;
            }
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.setting_layout);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ConstraintLayout clAccountManager = (ConstraintLayout) _$_findCachedViewById(R.id.clAccountManager);
        kotlin.jvm.internal.s.g(clAccountManager, "clAccountManager");
        int i2 = User.d().n() ? 0 : 8;
        clAccountManager.setVisibility(i2);
        VdsAgent.onSetViewVisibility(clAccountManager, i2);
    }
}
