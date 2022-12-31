package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import java.util.Iterator;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class MaterialTextInputPicker<S> extends PickerFragment<S> {
    @StyleRes
    private int b;
    @Nullable
    private DateSelector<S> c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private CalendarConstraints f4221d;

    /* loaded from: classes2.dex */
    class a extends i<S> {
        a() {
        }

        @Override // com.google.android.material.datepicker.i
        public void a() {
            Iterator<i<S>> it = MaterialTextInputPicker.this.a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }

        @Override // com.google.android.material.datepicker.i
        public void b(S s) {
            Iterator<i<S>> it = MaterialTextInputPicker.this.a.iterator();
            while (it.hasNext()) {
                it.next().b(s);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static <T> MaterialTextInputPicker<T> c0(DateSelector<T> dateSelector, @StyleRes int i2, @NonNull CalendarConstraints calendarConstraints) {
        MaterialTextInputPicker<T> materialTextInputPicker = new MaterialTextInputPicker<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i2);
        bundle.putParcelable("DATE_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        materialTextInputPicker.setArguments(bundle);
        return materialTextInputPicker;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.b = bundle.getInt("THEME_RES_ID_KEY");
        this.c = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f4221d = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return this.c.w(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.b)), viewGroup, bundle, this.f4221d, new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.b);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f4221d);
    }
}
