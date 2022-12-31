package us.pinguo.user.util;

import android.text.TextUtils;
import com.android.volley.VolleyError;
import com.google.gson.JsonSyntaxException;
import rx.functions.Func1;
import us.pinguo.foundation.network.BaseResponseHeader;
import us.pinguo.foundation.network.Fault;
import us.pinguo.user.User;
/* compiled from: TokenTimeOutHandler.java */
/* loaded from: classes6.dex */
public class l implements Func1<VolleyError, Throwable> {
    @Override // rx.functions.Func1
    /* renamed from: a */
    public Throwable call(VolleyError volleyError) {
        if (volleyError != null && volleyError.getCause() != null && (volleyError.getCause() instanceof JsonSyntaxException) && !TextUtils.isEmpty(volleyError.getMessage())) {
            try {
                BaseResponseHeader baseResponseHeader = (BaseResponseHeader) new com.google.gson.e().j(volleyError.getMessage(), BaseResponseHeader.class);
                int i2 = baseResponseHeader.status;
                if (i2 == 420) {
                    User.E();
                } else if (i2 != 200) {
                    return new Fault(baseResponseHeader.status, baseResponseHeader.message);
                }
            } catch (JsonSyntaxException unused) {
            }
        }
        return volleyError;
    }
}
