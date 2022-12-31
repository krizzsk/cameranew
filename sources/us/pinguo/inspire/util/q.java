package us.pinguo.inspire.util;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import us.pinguo.inspire.Inspire;
/* compiled from: KeyboadUtils.java */
/* loaded from: classes9.dex */
public class q {
    public static void a(Context context, EditText editText) {
        editText.requestFocus();
        try {
            ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(editText, 2);
        } catch (Exception e2) {
            Inspire.f(e2);
        }
    }
}
