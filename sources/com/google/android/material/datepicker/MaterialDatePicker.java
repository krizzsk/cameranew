package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.R;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.internal.CheckableImageButton;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.Iterator;
import java.util.LinkedHashSet;
/* loaded from: classes2.dex */
public final class MaterialDatePicker<S> extends DialogFragment {
    static final Object r = "CONFIRM_BUTTON_TAG";
    static final Object s = "CANCEL_BUTTON_TAG";
    static final Object t = "TOGGLE_BUTTON_TAG";
    private final LinkedHashSet<f<? super S>> a = new LinkedHashSet<>();
    private final LinkedHashSet<View.OnClickListener> b = new LinkedHashSet<>();
    private final LinkedHashSet<DialogInterface.OnCancelListener> c = new LinkedHashSet<>();

    /* renamed from: d  reason: collision with root package name */
    private final LinkedHashSet<DialogInterface.OnDismissListener> f4212d = new LinkedHashSet<>();
    @StyleRes

    /* renamed from: e  reason: collision with root package name */
    private int f4213e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private DateSelector<S> f4214f;

    /* renamed from: g  reason: collision with root package name */
    private PickerFragment<S> f4215g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private CalendarConstraints f4216h;

    /* renamed from: i  reason: collision with root package name */
    private MaterialCalendar<S> f4217i;
    @StringRes

    /* renamed from: j  reason: collision with root package name */
    private int f4218j;

    /* renamed from: k  reason: collision with root package name */
    private CharSequence f4219k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f4220l;
    private int m;
    private TextView n;
    private CheckableImageButton o;
    @Nullable
    private com.google.android.material.shape.h p;
    private Button q;

    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            Iterator it = MaterialDatePicker.this.a.iterator();
            while (it.hasNext()) {
                ((f) it.next()).a(MaterialDatePicker.this.m0());
            }
            MaterialDatePicker.this.dismiss();
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
            Iterator it = MaterialDatePicker.this.b.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            MaterialDatePicker.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends i<S> {
        c() {
        }

        @Override // com.google.android.material.datepicker.i
        public void a() {
            MaterialDatePicker.this.q.setEnabled(false);
        }

        @Override // com.google.android.material.datepicker.i
        public void b(S s) {
            MaterialDatePicker.this.t0();
            MaterialDatePicker.this.q.setEnabled(MaterialDatePicker.this.f4214f.z());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            MaterialDatePicker.this.q.setEnabled(MaterialDatePicker.this.f4214f.z());
            MaterialDatePicker.this.o.toggle();
            MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
            materialDatePicker.u0(materialDatePicker.o);
            MaterialDatePicker.this.s0();
        }
    }

    @NonNull
    private static Drawable i0(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, AppCompatResources.getDrawable(context, R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], AppCompatResources.getDrawable(context, R.drawable.material_ic_edit_black_24dp));
        return stateListDrawable;
    }

    private static int j0(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height);
        int i2 = g.f4246f;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * i2) + ((i2 - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding);
    }

    private static int l0(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        int i2 = Month.f().c;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * i2) + ((i2 - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding));
    }

    private int n0(Context context) {
        int i2 = this.f4213e;
        return i2 != 0 ? i2 : this.f4214f.d(context);
    }

    private void o0(Context context) {
        this.o.setTag(t);
        this.o.setImageDrawable(i0(context));
        this.o.setChecked(this.m != 0);
        ViewCompat.setAccessibilityDelegate(this.o, null);
        u0(this.o);
        this.o.setOnClickListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean p0(@NonNull Context context) {
        return r0(context, 16843277);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean q0(@NonNull Context context) {
        return r0(context, R.attr.nestedScrollable);
    }

    static boolean r0(@NonNull Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(com.google.android.material.f.b.c(context, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{i2});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        int n0 = n0(requireContext());
        this.f4217i = MaterialCalendar.r0(this.f4214f, n0, this.f4216h);
        this.f4215g = this.o.isChecked() ? MaterialTextInputPicker.c0(this.f4214f, n0, this.f4216h) : this.f4217i;
        t0();
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        int i2 = R.id.mtrl_calendar_frame;
        PickerFragment<S> pickerFragment = this.f4215g;
        VdsAgent.onFragmentTransactionReplace(beginTransaction, i2, pickerFragment, beginTransaction.replace(i2, pickerFragment));
        beginTransaction.commitNow();
        this.f4215g.a0(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        String k0 = k0();
        this.n.setContentDescription(String.format(getString(R.string.mtrl_picker_announce_current_selection), k0));
        this.n.setText(k0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(@NonNull CheckableImageButton checkableImageButton) {
        String string;
        if (this.o.isChecked()) {
            string = checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode);
        } else {
            string = checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode);
        }
        this.o.setContentDescription(string);
    }

    public String k0() {
        return this.f4214f.e(getContext());
    }

    @Nullable
    public final S m0() {
        return this.f4214f.N();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f4213e = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f4214f = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f4216h = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f4218j = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f4219k = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.m = bundle.getInt("INPUT_MODE_KEY");
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), n0(requireContext()));
        Context context = dialog.getContext();
        this.f4220l = p0(context);
        int c2 = com.google.android.material.f.b.c(context, R.attr.colorSurface, MaterialDatePicker.class.getCanonicalName());
        com.google.android.material.shape.h hVar = new com.google.android.material.shape.h(context, null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        this.p = hVar;
        hVar.L(context);
        this.p.W(ColorStateList.valueOf(c2));
        this.p.V(ViewCompat.getElevation(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(this.f4220l ? R.layout.mtrl_picker_fullscreen : R.layout.mtrl_picker_dialog, viewGroup);
        Context context = inflate.getContext();
        if (this.f4220l) {
            inflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(l0(context), -2));
        } else {
            View findViewById = inflate.findViewById(R.id.mtrl_calendar_main_pane);
            View findViewById2 = inflate.findViewById(R.id.mtrl_calendar_frame);
            findViewById.setLayoutParams(new LinearLayout.LayoutParams(l0(context), -1));
            findViewById2.setMinimumHeight(j0(requireContext()));
        }
        TextView textView = (TextView) inflate.findViewById(R.id.mtrl_picker_header_selection_text);
        this.n = textView;
        ViewCompat.setAccessibilityLiveRegion(textView, 1);
        this.o = (CheckableImageButton) inflate.findViewById(R.id.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) inflate.findViewById(R.id.mtrl_picker_title_text);
        CharSequence charSequence = this.f4219k;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.f4218j);
        }
        o0(context);
        this.q = (Button) inflate.findViewById(R.id.confirm_button);
        if (this.f4214f.z()) {
            this.q.setEnabled(true);
        } else {
            this.q.setEnabled(false);
        }
        this.q.setTag(r);
        this.q.setOnClickListener(new a());
        Button button = (Button) inflate.findViewById(R.id.cancel_button);
        button.setTag(s);
        button.setOnClickListener(new b());
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.f4212d.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f4213e);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f4214f);
        CalendarConstraints.b bVar = new CalendarConstraints.b(this.f4216h);
        if (this.f4217i.n0() != null) {
            bVar.b(this.f4217i.n0().f4223e);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f4218j);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f4219k);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.f4220l) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.p);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.p, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new com.google.android.material.dialog.a(requireDialog(), rect));
        }
        s0();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.f4215g.b0();
        super.onStop();
    }
}
