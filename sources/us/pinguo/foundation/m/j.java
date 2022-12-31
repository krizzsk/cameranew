package us.pinguo.foundation.m;

import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: VolleyRequest.java */
/* loaded from: classes4.dex */
public abstract class j<T> extends Request<T> {

    /* renamed from: d  reason: collision with root package name */
    private static final int f11032d;
    private Map<String, String> a;
    private List<k> b;
    private String c;

    static {
        f11032d = us.pinguo.foundation.d.f10985d ? 60000 : 15000;
    }

    public j(int i2, String str) {
        super(i2, str, null);
        this.a = new HashMap();
        this.b = new ArrayList();
        setRetryPolicy(new DefaultRetryPolicy(f11032d, 0, 1.0f));
    }

    public j<T> a(String str, String str2) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            this.a.put(str, str2);
        }
        return this;
    }

    public j<T> b(k kVar) {
        if (kVar != null) {
            this.b.add(kVar);
        }
        return this;
    }

    public j<T> c(String str) {
        this.c = getUrl() + "_" + getMethod() + "_" + str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public void deliverResponse(T t) {
    }

    @Override // com.android.volley.Request
    public String getCacheKey() {
        return TextUtils.isEmpty(this.c) ? super.getCacheKey() : this.c;
    }

    public long getContentLength() {
        return 0L;
    }

    @Override // com.android.volley.Request
    public Map<String, String> getParams() throws AuthFailureError {
        List<k> list = this.b;
        if (list != null) {
            for (k kVar : list) {
                kVar.append(this.a);
            }
        }
        return this.a;
    }

    public Response<T> parseVolleyResponse(NetworkResponse networkResponse) {
        return parseNetworkResponse(networkResponse);
    }
}
