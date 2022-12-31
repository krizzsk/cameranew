package com.google.android.material.datepicker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.TESTS})
/* loaded from: classes2.dex */
public class MaterialStyledDatePickerDialog extends DatePickerDialog {
    @StyleRes
    private static final int c = R.style.MaterialAlertDialog_MaterialComponents_Picker_Date_Spinner;
    @NonNull
    private final Drawable a;
    @NonNull
    private final Rect b;

    public MaterialStyledDatePickerDialog(@NonNull Context context) {
        this(context, 0);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(this.a);
        getWindow().getDecorView().setOnTouchListener(new com.google.android.material.dialog.a(this, this.b));
    }

    public MaterialStyledDatePickerDialog(@NonNull Context context, int i2) {
        this(context, i2, null, -1, -1, -1);
    }

    public MaterialStyledDatePickerDialog(@NonNull Context context, int i2, @Nullable DatePickerDialog.OnDateSetListener onDateSetListener, int i3, int i4, int i5) {
        super(context, i2, onDateSetListener, i3, i4, i5);
        Context context2 = getContext();
        int c2 = com.google.android.material.f.b.c(getContext(), R.attr.colorSurface, getClass().getCanonicalName());
        int i6 = c;
        com.google.android.material.shape.h hVar = new com.google.android.material.shape.h(context2, null, 16843612, i6);
        if (Build.VERSION.SDK_INT >= 21) {
            hVar.W(ColorStateList.valueOf(c2));
        } else {
            hVar.W(ColorStateList.valueOf(0));
        }
        Rect a = com.google.android.material.dialog.b.a(context2, 16843612, i6);
        this.b = a;
        this.a = com.google.android.material.dialog.b.b(hVar, a);
    }
}
