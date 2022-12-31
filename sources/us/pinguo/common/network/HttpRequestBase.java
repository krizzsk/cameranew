package us.pinguo.common.network;

import android.util.Log;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.VolleyError;
import java.util.Locale;
import us.pinguo.common.network.pgrequest.BaseRequest;
@Deprecated
/* loaded from: classes4.dex */
public abstract class HttpRequestBase<T> extends BaseRequest<T> {
    private static final String TAG = "HttpRequestBase";

    public HttpRequestBase(String str) {
        super(0, str, null);
        setRetryPolicy(new DefaultRetryPolicy(15000, 0, 1.0f));
    }

    private void checkInterval(long j2) {
        if (j2 > 100) {
            throw new RuntimeException(String.format(Locale.ENGLISH, "Network Response execution time exceeded 100 millisecond in the %s thread. Interval=%d,Url=%s", Thread.currentThread().getName(), Long.valueOf(j2), getUrl()));
        }
        if (j2 > 10) {
            Log.e(TAG, String.format(Locale.ENGLISH, "Network Response execution time exceeded 10 millisecond in the %s thread. Interval=%d,Url=%s", Thread.currentThread().getName(), Long.valueOf(j2), getUrl()));
        }
    }

    @Override // com.android.volley.Request
    public void deliverError(VolleyError volleyError) {
        if (HttpRequestQueue.isCheckMainThreadTime) {
            long currentTimeMillis = System.currentTimeMillis();
            onErrorResponse(volleyError);
            checkInterval(System.currentTimeMillis() - currentTimeMillis);
            return;
        }
        onErrorResponse(volleyError);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public void deliverResponse(T t) {
        if (HttpRequestQueue.isCheckMainThreadTime) {
            long currentTimeMillis = System.currentTimeMillis();
            onResponse(t);
            checkInterval(System.currentTimeMillis() - currentTimeMillis);
            return;
        }
        onResponse(t);
    }

    public void execute() {
        HttpRequestQueue.getInstance().add(this);
    }

    protected abstract void onErrorResponse(Exception exc);

    protected abstract void onResponse(T t);

    public HttpRequestBase(int i2, String str) {
        super(i2, str, null);
        setRetryPolicy(new DefaultRetryPolicy(15000, 0, 1.0f));
    }
}
