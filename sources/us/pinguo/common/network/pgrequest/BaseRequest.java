package us.pinguo.common.network.pgrequest;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.e;
import j.a.g.c;
import java.io.UnsupportedEncodingException;
import us.pinguo.common.network.BaseResponse;
/* loaded from: classes4.dex */
public abstract class BaseRequest<T> extends Request<T> {
    private long startTime;

    public BaseRequest(String str, Response.ErrorListener errorListener) {
        super(str, errorListener);
        this.startTime = System.currentTimeMillis();
    }

    private void networkStat(NetworkResponse networkResponse) {
        String str;
        String str2 = "GET";
        switch (getMethod()) {
            case 1:
                str2 = "POST";
                break;
            case 2:
                str2 = "PUT";
                break;
            case 3:
                str2 = "DELETE";
                break;
            case 4:
                str2 = "HEAD";
                break;
            case 5:
                str2 = "OPTIONS";
                break;
            case 6:
                str2 = "TRACE";
                break;
            case 7:
                str2 = "PATCH";
                break;
        }
        String str3 = str2;
        String str4 = null;
        try {
            str4 = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        String str5 = "";
        if (networkResponse.statusCode == 200) {
            str = String.valueOf(System.currentTimeMillis() - this.startTime);
        } else {
            try {
                if (!TextUtils.isEmpty(str4)) {
                    str5 = ((BaseResponse) new e().j(str4, BaseResponse.class)).message;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            str = str5;
        }
        int i2 = networkResponse.statusCode;
        if (i2 >= 200 && i2 <= 299) {
            c.a.network_health_tracking_cost(getUrl(), "api", str3, String.valueOf(networkResponse.statusCode), str);
        } else {
            c.a.network_health_tracking_error(getUrl(), "api", str3, String.valueOf(networkResponse.statusCode), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public Response<T> parseNetworkResponse(NetworkResponse networkResponse) {
        networkStat(networkResponse);
        return null;
    }

    public BaseRequest(int i2, String str, @Nullable Response.ErrorListener errorListener) {
        super(i2, str, errorListener);
        this.startTime = System.currentTimeMillis();
    }
}
