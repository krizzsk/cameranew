package us.pinguo.common.network;

import android.text.TextUtils;
import com.android.volley.Network;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BaseHttpStack;
import com.android.volley.toolbox.BasicNetwork;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import us.pinguo.common.network.request.VolleyBaseRequest;
/* loaded from: classes4.dex */
public class RxVolley {
    private static Network mNetworkExecutor;
    private static Map<String, WeakReference<Observable<?>>> mWaitingRequests;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(VolleyBaseRequest volleyBaseRequest, Subscriber subscriber) {
        if (mNetworkExecutor == null) {
            mNetworkExecutor = createNetworkExecutor();
        }
        try {
            Response execute = execute(volleyBaseRequest);
            if (execute.isSuccess()) {
                subscriber.onNext(execute.result);
                subscriber.onCompleted();
            } else {
                volleyBaseRequest.parseVolleyResponse(execute.error.networkResponse);
                subscriber.onError(execute.error);
            }
        } catch (Exception e2) {
            subscriber.onError(e2);
        }
        mWaitingRequests.remove(volleyBaseRequest.getCacheKey());
    }

    public static <T> Observable<T> create(VolleyBaseRequest<T> volleyBaseRequest) {
        return createSync(volleyBaseRequest).subscribeOn(Schedulers.io());
    }

    private static Network createNetworkExecutor() {
        return new BasicNetwork((BaseHttpStack) new DirectOutputHurlStack());
    }

    public static <T> Observable<T> createSync(final VolleyBaseRequest<T> volleyBaseRequest) {
        Observable<T> observable;
        if (mWaitingRequests == null) {
            mWaitingRequests = new HashMap();
        }
        if (TextUtils.isEmpty(volleyBaseRequest.getCacheKey()) || !mWaitingRequests.containsKey(volleyBaseRequest.getCacheKey()) || (observable = (Observable<T>) mWaitingRequests.get(volleyBaseRequest.getCacheKey()).get()) == null) {
            Observable<T> create = Observable.create(new Observable.OnSubscribe() { // from class: us.pinguo.common.network.a
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    RxVolley.a(VolleyBaseRequest.this, (Subscriber) obj);
                }
            });
            mWaitingRequests.put(volleyBaseRequest.getCacheKey(), new WeakReference<>(create));
            return create;
        }
        return observable;
    }

    @Deprecated
    public static <T> Response<T> execute(VolleyBaseRequest<T> volleyBaseRequest) {
        if (mNetworkExecutor == null) {
            mNetworkExecutor = createNetworkExecutor();
        }
        try {
            return volleyBaseRequest.parseVolleyResponse(mNetworkExecutor.performRequest(volleyBaseRequest));
        } catch (VolleyError e2) {
            return Response.error(e2);
        }
    }

    public static <T> Observable<T> observe(VolleyBaseRequest<T> volleyBaseRequest) {
        return create(volleyBaseRequest).observeOn(AndroidSchedulers.mainThread());
    }

    @Deprecated
    public static <T> Response<T> execute(VolleyBaseRequest<T> volleyBaseRequest, Network network) {
        try {
            return volleyBaseRequest.parseVolleyResponse(network.performRequest(volleyBaseRequest));
        } catch (VolleyError e2) {
            return Response.error(e2);
        }
    }
}
