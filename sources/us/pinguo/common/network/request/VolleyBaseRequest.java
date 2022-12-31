package us.pinguo.common.network.request;

import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import us.pinguo.common.network.HttpRequest;
import us.pinguo.common.network.pgrequest.BaseRequest;
import us.pinguo.common.network.request.strategy.GsonParser;
import us.pinguo.common.network.request.strategy.IAcceptParser;
import us.pinguo.common.network.request.strategy.StringParser;
/* loaded from: classes4.dex */
public abstract class VolleyBaseRequest<T> extends BaseRequest<T> {
    public static final String DEFAULT_PARAMS_ENCODING = "UTF-8";
    private static final int SOCKET_TIMEOUT = 15000;
    String mCacheKey;
    Map<String, String> mHeaders;
    IAcceptParser mParser;
    Class mResponseType;

    public VolleyBaseRequest(int i2, String str, Map<String, String> map, String str2, Class cls) {
        super(i2, str, null);
        setRetryPolicy(new DefaultRetryPolicy(15000, 0, 1.0f));
        this.mResponseType = cls;
        createParser(cls);
        HashMap hashMap = new HashMap();
        this.mHeaders = hashMap;
        hashMap.put(HttpRequest.HEADER_ACCEPT, this.mParser.getAcceptType());
        if (map != null) {
            this.mHeaders.putAll(map);
        }
        this.mCacheKey = str2;
    }

    private void createParser(Class cls) {
        if (cls == String.class) {
            this.mParser = new StringParser();
        } else {
            this.mParser = new GsonParser();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public void deliverResponse(T t) {
    }

    @Override // com.android.volley.Request
    public String getCacheKey() {
        return TextUtils.isEmpty(this.mCacheKey) ? "" : this.mCacheKey;
    }

    public long getContentLength() {
        byte[] bArr;
        try {
            bArr = getBody();
        } catch (AuthFailureError e2) {
            e2.printStackTrace();
            bArr = null;
        }
        if (bArr == null) {
            return 0L;
        }
        return bArr.length;
    }

    protected Type getEntityType() {
        return this.mResponseType;
    }

    @Override // com.android.volley.Request
    public Map<String, String> getHeaders() throws AuthFailureError {
        return this.mHeaders;
    }

    @Override // com.android.volley.Request
    protected String getParamsEncoding() {
        return "UTF-8";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.common.network.pgrequest.BaseRequest, com.android.volley.Request
    public Response<T> parseNetworkResponse(NetworkResponse networkResponse) {
        super.parseNetworkResponse(networkResponse);
        return this.mParser.parseNetworkResponse(networkResponse, this.mResponseType);
    }

    public Response<T> parseVolleyResponse(NetworkResponse networkResponse) {
        return parseNetworkResponse(networkResponse);
    }
}
