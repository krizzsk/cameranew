package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.shape.h;
import com.google.android.material.timepicker.TimePickerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public final class MaterialTimePicker extends DialogFragment {

    /* renamed from: e  reason: collision with root package name */
    private TimePickerView f4657e;

    /* renamed from: f  reason: collision with root package name */
    private ViewStub f4658f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private com.google.android.material.timepicker.c f4659g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private f f4660h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private com.google.android.material.timepicker.d f4661i;
    @DrawableRes

    /* renamed from: j  reason: collision with root package name */
    private int f4662j;
    @DrawableRes

    /* renamed from: k  reason: collision with root package name */
    private int f4663k;
    private String m;
    private MaterialButton n;
    private TimeModel p;
    private final Set<View.OnClickListener> a = new LinkedHashSet();
    private final Set<View.OnClickListener> b = new LinkedHashSet();
    private final Set<DialogInterface.OnCancelListener> c = new LinkedHashSet();

    /* renamed from: d  reason: collision with root package name */
    private final Set<DialogInterface.OnDismissListener> f4656d = new LinkedHashSet();

    /* renamed from: l  reason: collision with root package name */
    private int f4664l = 0;
    private int o = 0;
    private int q = 0;

    /* loaded from: classes2.dex */
    class a implements TimePickerView.e {
        a() {
        }

        @Override // com.google.android.material.timepicker.TimePickerView.e
        public void a() {
            MaterialTimePicker.this.o = 1;
            MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
            materialTimePicker.l0(materialTimePicker.n);
            MaterialTimePicker.this.f4660h.i();
        }
    }

    /* loaded from: classes2.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            for (View.OnClickListener onClickListener : MaterialTimePicker.this.a) {
                onClickListener.onClick(view);
            }
            MaterialTimePicker.this.dismiss();
        }
    }

    /* loaded from: classes2.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            for (View.OnClickListener onClickListener : MaterialTimePicker.this.b) {
                onClickListener.onClick(view);
            }
            MaterialTimePicker.this.dismiss();
        }
    }

    /* loaded from: classes2.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
            materialTimePicker.o = materialTimePicker.o == 0 ? 1 : 0;
            MaterialTimePicker materialTimePicker2 = MaterialTimePicker.this;
            materialTimePicker2.l0(materialTimePicker2.n);
        }
    }

    private Pair<Integer, Integer> h0(int i2) {
        if (i2 != 0) {
            if (i2 == 1) {
                return new Pair<>(Integer.valueOf(this.f4663k), Integer.valueOf(R.string.material_timepicker_clock_mode_description));
            }
            throw new IllegalArgumentException("no icon for mode: " + i2);
        }
        return new Pair<>(Integer.valueOf(this.f4662j), Integer.valueOf(R.string.material_timepicker_text_input_mode_description));
    }

    private int i0() {
        int i2 = this.q;
        if (i2 != 0) {
            return i2;
        }
        TypedValue a2 = com.google.android.material.f.b.a(requireContext(), R.attr.materialTimePickerTheme);
        if (a2 == null) {
            return 0;
        }
        return a2.data;
    }

    private com.google.android.material.timepicker.d j0(int i2) {
        if (i2 == 0) {
            com.google.android.material.timepicker.c cVar = this.f4659g;
            if (cVar == null) {
                cVar = new com.google.android.material.timepicker.c(this.f4657e, this.p);
            }
            this.f4659g = cVar;
            return cVar;
        }
        if (this.f4660h == null) {
            this.f4660h = new f((LinearLayout) this.f4658f.inflate(), this.p);
        }
        this.f4660h.f();
        return this.f4660h;
    }

    private void k0(@Nullable Bundle bundle) {
        if (bundle == null) {
            return;
        }
        TimeModel timeModel = (TimeModel) bundle.getParcelable("TIME_PICKER_TIME_MODEL");
        this.p = timeModel;
        if (timeModel == null) {
            this.p = new TimeModel();
        }
        this.o = bundle.getInt("TIME_PICKER_INPUT_MODE", 0);
        this.f4664l = bundle.getInt("TIME_PICKER_TITLE_RES", 0);
        this.m = bundle.getString("TIME_PICKER_TITLE_TEXT");
        this.q = bundle.getInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(MaterialButton materialButton) {
        com.google.android.material.timepicker.d dVar = this.f4661i;
        if (dVar != null) {
            dVar.a();
        }
        com.google.android.material.timepicker.d j0 = j0(this.o);
        this.f4661i = j0;
        j0.show();
        this.f4661i.b();
        Pair<Integer, Integer> h0 = h0(this.o);
        materialButton.setIconResource(((Integer) h0.first).intValue());
        materialButton.setContentDescription(getResources().getString(((Integer) h0.second).intValue()));
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        for (DialogInterface.OnCancelListener onCancelListener : this.c) {
            onCancelListener.onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        k0(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), i0());
        Context context = dialog.getContext();
        int c2 = com.google.android.material.f.b.c(context, R.attr.colorSurface, MaterialTimePicker.class.getCanonicalName());
        int i2 = R.attr.materialTimePickerStyle;
        int i3 = R.style.Widget_MaterialComponents_TimePicker;
        h hVar = new h(context, null, i2, i3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.MaterialTimePicker, i2, i3);
        this.f4663k = obtainStyledAttributes.getResourceId(R.styleable.MaterialTimePicker_clockIcon, 0);
        this.f4662j = obtainStyledAttributes.getResourceId(R.styleable.MaterialTimePicker_keyboardIcon, 0);
        obtainStyledAttributes.recycle();
        hVar.L(context);
        hVar.W(ColorStateList.valueOf(c2));
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(hVar);
        window.requestFeature(1);
        window.setLayout(-2, -2);
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.material_timepicker_dialog, viewGroup);
        TimePickerView timePickerView = (TimePickerView) viewGroup2.findViewById(R.id.material_timepicker_view);
        this.f4657e = timePickerView;
        timePickerView.q(new a());
        this.f4658f = (ViewStub) viewGroup2.findViewById(R.id.material_textinput_timepicker);
        this.n = (MaterialButton) viewGroup2.findViewById(R.id.material_timepicker_mode_button);
        TextView textView = (TextView) viewGroup2.findViewById(R.id.header_title);
        if (!TextUtils.isEmpty(this.m)) {
            textView.setText(this.m);
        }
        int i2 = this.f4664l;
        if (i2 != 0) {
            textView.setText(i2);
        }
        l0(this.n);
        ((Button) viewGroup2.findViewById(R.id.material_timepicker_ok_button)).setOnClickListener(new b());
        ((Button) viewGroup2.findViewById(R.id.material_timepicker_cancel_button)).setOnClickListener(new c());
        this.n.setOnClickListener(new d());
        return viewGroup2;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        for (DialogInterface.OnDismissListener onDismissListener : this.f4656d) {
            onDismissListener.onDismiss(dialogInterface);
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("TIME_PICKER_TIME_MODEL", this.p);
        bundle.putInt("TIME_PICKER_INPUT_MODE", this.o);
        bundle.putInt("TIME_PICKER_TITLE_RES", this.f4664l);
        bundle.putString("TIME_PICKER_TITLE_TEXT", this.m);
        bundle.putInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", this.q);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f4661i = null;
        this.f4659g = null;
        this.f4660h = null;
        this.f4657e = null;
    }
}
