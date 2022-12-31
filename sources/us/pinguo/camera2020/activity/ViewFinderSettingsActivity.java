package us.pinguo.camera2020.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.camera2020.R;
import us.pinguo.common.utils.g;
/* compiled from: ViewFinderSettingsActivity.kt */
/* loaded from: classes2.dex */
public final class ViewFinderSettingsActivity extends AppCompatActivity {
    public Map<Integer, View> a = new LinkedHashMap();
    private int b = us.pinguo.foundation.j.e().i("hairCut", 0);
    private final kotlin.f c = new ViewModelLazy(kotlin.jvm.internal.v.b(us.pinguo.camera2020.viewmodel.b.class), new ViewFinderSettingsActivity$special$$inlined$viewModels$default$2(this), new ViewFinderSettingsActivity$special$$inlined$viewModels$default$1(this));

    /* compiled from: ViewFinderSettingsActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a implements g.a {
        a() {
        }

        @Override // us.pinguo.common.utils.g.a
        public void a(int i2) {
            if (i2 == 0) {
                ViewFinderSettingsActivity.this.n0().b().setValue(1);
            } else if (i2 == 1) {
                ViewFinderSettingsActivity.this.n0().b().setValue(2);
            } else if (i2 != 2) {
            } else {
                ViewFinderSettingsActivity.this.n0().b().setValue(3);
            }
        }
    }

    /* compiled from: ViewFinderSettingsActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b implements g.a {
        b() {
        }

        @Override // us.pinguo.common.utils.g.a
        public void a(int i2) {
            if (i2 == 0) {
                ViewFinderSettingsActivity.this.n0().d().setValue(1);
            } else if (i2 == 1) {
                ViewFinderSettingsActivity.this.n0().d().setValue(2);
            } else if (i2 != 2) {
            } else {
                ViewFinderSettingsActivity.this.n0().d().setValue(3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(ViewFinderSettingsActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        int i2 = R.id.switchSilentCapture;
        boolean z = !((SwitchCompat) this$0._$_findCachedViewById(i2)).isChecked();
        ((SwitchCompat) this$0._$_findCachedViewById(i2)).setChecked(z);
        this$0.n0().c().setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(ViewFinderSettingsActivity this$0, View v) {
        VdsAgent.lambdaOnClick(v);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.g(v, "v");
        this$0.R0(v);
    }

    private final void Q0(View view) {
        String string = getString(R.string.pref_picture_resolutionratio_entry_high);
        kotlin.jvm.internal.s.g(string, "getString(R.string.pref_…solutionratio_entry_high)");
        String string2 = getString(R.string.pref_picture_resolutionratio_entry_middle);
        kotlin.jvm.internal.s.g(string2, "getString(R.string.pref_…lutionratio_entry_middle)");
        String string3 = getString(R.string.pref_picture_resolutionratio_entry_low);
        kotlin.jvm.internal.s.g(string3, "getString(R.string.pref_…esolutionratio_entry_low)");
        CharSequence[] charSequenceArr = {string, string2, string3};
        us.pinguo.common.utils.g gVar = us.pinguo.common.utils.g.a;
        a aVar = new a();
        Integer value = n0().b().getValue();
        if (value == null) {
            value = 1;
        }
        gVar.e(this, charSequenceArr, view, aVar, value.intValue() - 1);
    }

    private final void R0(View view) {
        String string = getString(R.string.voice_key_adjust_voice);
        kotlin.jvm.internal.s.g(string, "getString(R.string.voice_key_adjust_voice)");
        String string2 = getString(R.string.txt_capture);
        kotlin.jvm.internal.s.g(string2, "getString(R.string.txt_capture)");
        String string3 = getString(R.string.voice_key_adjust_focus);
        kotlin.jvm.internal.s.g(string3, "getString(R.string.voice_key_adjust_focus)");
        CharSequence[] charSequenceArr = {string, string2, string3};
        us.pinguo.common.utils.g gVar = us.pinguo.common.utils.g.a;
        b bVar = new b();
        Integer value = n0().d().getValue();
        if (value == null) {
            value = 1;
        }
        gVar.e(this, charSequenceArr, view, bVar, value.intValue() - 1);
    }

    private final void initView() {
        ((ConstraintLayout) _$_findCachedViewById(R.id.root)).setPadding(0, this.b, 0, 0);
        ((Toolbar) _$_findCachedViewById(R.id.tbTitle)).setNavigationOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.activity.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewFinderSettingsActivity.o0(ViewFinderSettingsActivity.this, view);
            }
        });
        int i2 = R.id.switchGrid;
        Boolean value = n0().e().getValue();
        Boolean bool = Boolean.TRUE;
        ((SwitchCompat) _$_findCachedViewById(i2)).setChecked(kotlin.jvm.internal.s.c(value, bool));
        ((SwitchCompat) _$_findCachedViewById(i2)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: us.pinguo.camera2020.activity.l
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ViewFinderSettingsActivity.p0(ViewFinderSettingsActivity.this, compoundButton, z);
            }
        });
        ((ConstraintLayout) _$_findCachedViewById(R.id.clGrid)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.activity.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewFinderSettingsActivity.u0(ViewFinderSettingsActivity.this, view);
            }
        });
        int i3 = R.id.switchFrontMirror;
        ((SwitchCompat) _$_findCachedViewById(i3)).setChecked(kotlin.jvm.internal.s.c(n0().a().getValue(), bool));
        ((SwitchCompat) _$_findCachedViewById(i3)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: us.pinguo.camera2020.activity.u
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ViewFinderSettingsActivity.v0(ViewFinderSettingsActivity.this, compoundButton, z);
            }
        });
        ((ConstraintLayout) _$_findCachedViewById(R.id.clFrontMirror)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.activity.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewFinderSettingsActivity.w0(ViewFinderSettingsActivity.this, view);
            }
        });
        int i4 = R.id.switchAdvance;
        ((SwitchCompat) _$_findCachedViewById(i4)).setChecked(kotlin.jvm.internal.s.c(n0().g().getValue(), bool));
        ((SwitchCompat) _$_findCachedViewById(i4)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: us.pinguo.camera2020.activity.o
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ViewFinderSettingsActivity.x0(ViewFinderSettingsActivity.this, compoundButton, z);
            }
        });
        ((ConstraintLayout) _$_findCachedViewById(R.id.clAdvance)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.activity.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewFinderSettingsActivity.y0(ViewFinderSettingsActivity.this, view);
            }
        });
        int i5 = R.id.switchSilentCapture;
        ((SwitchCompat) _$_findCachedViewById(i5)).setChecked(kotlin.jvm.internal.s.c(n0().c().getValue(), bool));
        ((SwitchCompat) _$_findCachedViewById(i5)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: us.pinguo.camera2020.activity.w
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ViewFinderSettingsActivity.z0(ViewFinderSettingsActivity.this, compoundButton, z);
            }
        });
        ((ConstraintLayout) _$_findCachedViewById(R.id.clSilentCapture)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.activity.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewFinderSettingsActivity.A0(ViewFinderSettingsActivity.this, view);
            }
        });
        ((ConstraintLayout) _$_findCachedViewById(R.id.clVolumeFunc)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.activity.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewFinderSettingsActivity.B0(ViewFinderSettingsActivity.this, view);
            }
        });
        ((ConstraintLayout) _$_findCachedViewById(R.id.clResolutionFunc)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.activity.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewFinderSettingsActivity.q0(ViewFinderSettingsActivity.this, view);
            }
        });
        ((ConstraintLayout) _$_findCachedViewById(R.id.clWaterMark)).setOnClickListener(k.a);
        n0().d().observe(this, new Observer() { // from class: us.pinguo.camera2020.activity.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ViewFinderSettingsActivity.s0(ViewFinderSettingsActivity.this, (Integer) obj);
            }
        });
        n0().b().observe(this, new Observer() { // from class: us.pinguo.camera2020.activity.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ViewFinderSettingsActivity.t0(ViewFinderSettingsActivity.this, (Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final us.pinguo.camera2020.viewmodel.b n0() {
        return (us.pinguo.camera2020.viewmodel.b) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(ViewFinderSettingsActivity this$0, View view) {
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
    public static final void p0(ViewFinderSettingsActivity this$0, CompoundButton compoundButton, boolean z) {
        VdsAgent.lambdaOnCheckedChangedCompoundButton(compoundButton, z);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.n0().e().setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(ViewFinderSettingsActivity this$0, View v) {
        VdsAgent.lambdaOnClick(v);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.g(v, "v");
        this$0.Q0(v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(View view) {
        VdsAgent.lambdaOnClick(view);
        Intent intent = new Intent();
        intent.setClassName(view.getContext(), "com.pinguo.camera360.camera.options.OptionsWatermarkActivity");
        view.getContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(ViewFinderSettingsActivity this$0, Integer num) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (num != null && num.intValue() == 1) {
            ((TextView) this$0._$_findCachedViewById(R.id.txtChooseVolumeFunc)).setText(this$0.getResources().getString(R.string.voice_key_adjust_voice));
        } else if (num != null && num.intValue() == 2) {
            ((TextView) this$0._$_findCachedViewById(R.id.txtChooseVolumeFunc)).setText(this$0.getResources().getString(R.string.txt_capture));
        } else if (num != null && num.intValue() == 3) {
            ((TextView) this$0._$_findCachedViewById(R.id.txtChooseVolumeFunc)).setText(this$0.getResources().getString(R.string.voice_key_adjust_focus));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(ViewFinderSettingsActivity this$0, Integer num) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (num != null && num.intValue() == 1) {
            ((TextView) this$0._$_findCachedViewById(R.id.txtChooseResolutionFunc)).setText(this$0.getResources().getString(R.string.pref_picture_resolutionratio_entry_high));
        } else if (num != null && num.intValue() == 2) {
            ((TextView) this$0._$_findCachedViewById(R.id.txtChooseResolutionFunc)).setText(this$0.getResources().getString(R.string.pref_picture_resolutionratio_entry_middle));
        } else if (num != null && num.intValue() == 3) {
            ((TextView) this$0._$_findCachedViewById(R.id.txtChooseResolutionFunc)).setText(this$0.getResources().getString(R.string.pref_picture_resolutionratio_entry_low));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(ViewFinderSettingsActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        int i2 = R.id.switchGrid;
        boolean z = !((SwitchCompat) this$0._$_findCachedViewById(i2)).isChecked();
        ((SwitchCompat) this$0._$_findCachedViewById(i2)).setChecked(z);
        this$0.n0().e().setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(ViewFinderSettingsActivity this$0, CompoundButton compoundButton, boolean z) {
        VdsAgent.lambdaOnCheckedChangedCompoundButton(compoundButton, z);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.n0().a().setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(ViewFinderSettingsActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        int i2 = R.id.switchFrontMirror;
        boolean z = !((SwitchCompat) this$0._$_findCachedViewById(i2)).isChecked();
        ((SwitchCompat) this$0._$_findCachedViewById(i2)).setChecked(z);
        this$0.n0().a().setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(ViewFinderSettingsActivity this$0, CompoundButton compoundButton, boolean z) {
        VdsAgent.lambdaOnCheckedChangedCompoundButton(compoundButton, z);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.n0().g().setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(ViewFinderSettingsActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        int i2 = R.id.switchAdvance;
        boolean z = !((SwitchCompat) this$0._$_findCachedViewById(i2)).isChecked();
        ((SwitchCompat) this$0._$_findCachedViewById(i2)).setChecked(z);
        this$0.n0().g().setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(ViewFinderSettingsActivity this$0, CompoundButton compoundButton, boolean z) {
        VdsAgent.lambdaOnCheckedChangedCompoundButton(compoundButton, z);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.n0().c().setValue(Boolean.valueOf(z));
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
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.camera_setting_layout);
        initView();
    }
}
