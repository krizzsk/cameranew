package us.pinguo.user.util;

import android.text.TextUtils;
import com.android.volley.TimeoutError;
import us.pinguo.foundation.network.Fault;
import us.pinguo.foundation.utils.j0;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.Payload;
import us.pinguo.ui.R;
import us.pinguo.util.q;
/* compiled from: RequestErrorToastUtils.java */
/* loaded from: classes6.dex */
public class i {
    public static String a(Throwable th) {
        if (!q.f(us.pinguo.foundation.e.b())) {
            return Inspire.a().getString(R.string.network_not_available);
        }
        if (th instanceof TimeoutError) {
            return Inspire.a().getString(us.pinguo.user.R.string.network_error);
        }
        boolean z = th instanceof Fault;
        if (z && Payload.FAULT_CODES.contains(Integer.valueOf(((Fault) th).getStatus()))) {
            if (TextUtils.isEmpty(th.getMessage())) {
                return null;
            }
            String message = th.getMessage();
            return (message == null || !message.startsWith(";") || message.length() <= 1) ? message : message.substring(1);
        }
        if (z) {
            Fault fault = (Fault) th;
            if (Payload.CLIENT_FAULT_CODES.get(fault.getStatus()) != null) {
                int intValue = Payload.CLIENT_FAULT_CODES.get(fault.getStatus()).intValue();
                if (intValue != 0) {
                    String string = us.pinguo.foundation.e.b().getString(intValue);
                    if (TextUtils.isEmpty(string)) {
                        return null;
                    }
                    return string;
                }
                return null;
            }
        }
        return us.pinguo.foundation.e.b().getString(us.pinguo.user.R.string.network_error);
    }

    public static void b(Throwable th) {
        String a = a(th);
        if (TextUtils.isEmpty(a)) {
            return;
        }
        j0.d(a);
    }
}
