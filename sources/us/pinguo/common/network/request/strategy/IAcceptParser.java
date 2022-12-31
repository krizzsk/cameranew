package us.pinguo.common.network.request.strategy;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import java.lang.reflect.Type;
/* loaded from: classes4.dex */
public interface IAcceptParser<T> {
    String getAcceptType();

    Response<T> parseNetworkResponse(NetworkResponse networkResponse, Type type);
}
