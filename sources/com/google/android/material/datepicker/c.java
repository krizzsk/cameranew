package com.google.android.material.datepicker;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
/* compiled from: DateFormatTextWatcher.java */
/* loaded from: classes2.dex */
abstract class c extends com.google.android.material.internal.j {
    @NonNull
    private final TextInputLayout a;
    private final DateFormat b;
    private final CalendarConstraints c;

    /* renamed from: d  reason: collision with root package name */
    private final String f4242d;

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f4243e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f4244f;

    /* compiled from: DateFormatTextWatcher.java */
    /* loaded from: classes2.dex */
    class a implements Runnable {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout textInputLayout = c.this.a;
            DateFormat dateFormat = c.this.b;
            Context context = textInputLayout.getContext();
            String string = context.getString(R.string.mtrl_picker_invalid_format);
            String format = String.format(context.getString(R.string.mtrl_picker_invalid_format_use), this.a);
            String format2 = String.format(context.getString(R.string.mtrl_picker_invalid_format_example), dateFormat.format(new Date(l.o().getTimeInMillis())));
            textInputLayout.setError(string + "\n" + format + "\n" + format2);
            c.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DateFormatTextWatcher.java */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        final /* synthetic */ long a;

        b(long j2) {
            this.a = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a.setError(String.format(c.this.f4242d, d.c(this.a)));
            c.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, DateFormat dateFormat, @NonNull TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.b = dateFormat;
        this.a = textInputLayout;
        this.c = calendarConstraints;
        this.f4242d = textInputLayout.getContext().getString(R.string.mtrl_picker_out_of_range);
        this.f4243e = new a(str);
    }

    private Runnable d(long j2) {
        return new b(j2);
    }

    abstract void e();

    abstract void f(@Nullable Long l2);

    public void g(View view, Runnable runnable) {
        view.postDelayed(runnable, 1000L);
    }

    @Override // com.google.android.material.internal.j, android.text.TextWatcher
    public void onTextChanged(@NonNull CharSequence charSequence, int i2, int i3, int i4) {
        this.a.removeCallbacks(this.f4243e);
        this.a.removeCallbacks(this.f4244f);
        this.a.setError(null);
        f(null);
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        try {
            Date parse = this.b.parse(charSequence.toString());
            this.a.setError(null);
            long time = parse.getTime();
            if (this.c.h().i(time) && this.c.o(time)) {
                f(Long.valueOf(parse.getTime()));
                return;
            }
            Runnable d2 = d(time);
            this.f4244f = d2;
            g(this.a, d2);
        } catch (ParseException unused) {
            g(this.a, this.f4243e);
        }
    }
}
