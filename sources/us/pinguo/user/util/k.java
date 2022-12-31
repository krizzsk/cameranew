package us.pinguo.user.util;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import us.pinguo.inspire.Inspire;
/* compiled from: SoftwareKeyboardUtils.java */
/* loaded from: classes6.dex */
public class k {
    public static void a(EditText editText, Context context) {
        try {
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
        } catch (Exception e2) {
            Inspire.f(e2);
        }
    }
}
