package us.pinguo.bigdata.d;

import android.text.TextUtils;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import us.pinguo.bigdata.network.basic.NetworkException;
import us.pinguo.bigdata.network.model.BDNetworkResult;
/* compiled from: BDNetwork.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    private static volatile a f9118d;
    private final us.pinguo.bigdata.d.b.a a = new us.pinguo.bigdata.d.b.a();
    private final ExecutorService b = Executors.newCachedThreadPool();
    private CopyOnWriteArrayList<String> c = new CopyOnWriteArrayList<>();

    private a() {
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.c.add(str);
    }

    private boolean b(String str) {
        return TextUtils.isEmpty(str) || !this.c.contains(str);
    }

    private void e(BDNetworkResult bDNetworkResult, int i2, String str) {
        bDNetworkResult.setErrorCode(i2);
        bDNetworkResult.setErrorMsg(str);
        bDNetworkResult.setSuccess(false);
    }

    private void f(BDNetworkResult bDNetworkResult, String str) {
        bDNetworkResult.setSuccess(true);
        bDNetworkResult.setResult(str);
    }

    public static a g() {
        if (f9118d == null) {
            synchronized (a.class) {
                if (f9118d == null) {
                    f9118d = new a();
                }
            }
        }
        return f9118d;
    }

    private void i(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.c.remove(str);
    }

    public BDNetworkResult c(String str) {
        return d(null, str);
    }

    public BDNetworkResult d(String str, String str2) {
        if (b(str)) {
            a(str);
            BDNetworkResult bDNetworkResult = new BDNetworkResult();
            try {
                try {
                    f(bDNetworkResult, this.a.b(str2));
                } catch (IOException e2) {
                    e(bDNetworkResult, -1, e2.getLocalizedMessage());
                } catch (NetworkException e3) {
                    e(bDNetworkResult, e3.getStatusCode(), e3.getLocalizedMessage());
                } catch (Exception e4) {
                    e(bDNetworkResult, -2, e4.getLocalizedMessage());
                }
                return bDNetworkResult;
            } finally {
                i(str);
            }
        }
        return null;
    }

    public BDNetworkResult h(String str, SequenceInputStream sequenceInputStream) {
        BDNetworkResult bDNetworkResult = new BDNetworkResult();
        try {
            f(bDNetworkResult, this.a.c(str, sequenceInputStream));
        } catch (IOException e2) {
            e(bDNetworkResult, -1, e2.getLocalizedMessage());
        } catch (NetworkException e3) {
            e(bDNetworkResult, e3.getStatusCode(), e3.getLocalizedMessage());
        } catch (Exception e4) {
            e(bDNetworkResult, -2, e4.getLocalizedMessage());
        }
        return bDNetworkResult;
    }
}
