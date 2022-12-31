package us.pinguo.paylibcenter;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import us.pinguo.paylibcenter.order.RestoreOrderReq;
/* loaded from: classes5.dex */
public class OrderHelp {
    private List<String> a;
    private String b;
    ExecutorService c = Executors.newSingleThreadExecutor();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ int b;
        final /* synthetic */ Context c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ c f11560d;

        a(String str, int i2, Context context, c cVar) {
            this.a = str;
            this.b = i2;
            this.c = context;
            this.f11560d = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String str = new us.pinguo.paylibcenter.order.d(this.c, new RestoreOrderReq(this.a, this.b)).get();
                us.pinguo.common.log.a.q("resotorproduct result:" + str, new Object[0]);
                if (OrderHelp.g(str)) {
                    OrderHelp.this.b = str;
                    OrderHelp orderHelp = OrderHelp.this;
                    orderHelp.a = OrderHelp.i(orderHelp.b);
                } else {
                    OrderHelp.this.a = null;
                    OrderHelp.this.b = "";
                }
            } catch (Exception e2) {
                us.pinguo.common.log.a.q("resotorproduct exception:" + e2.toString(), new Object[0]);
            }
            c cVar = this.f11560d;
            if (cVar != null) {
                cVar.a(OrderHelp.this.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b {
        private static OrderHelp a = new OrderHelp();
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(String str);
    }

    public static boolean f(String str, String str2) {
        boolean z;
        Matcher matcher;
        try {
            matcher = Pattern.compile("\\bproductId\\b(.*?),").matcher(str);
        } catch (Exception unused) {
        }
        do {
            z = true;
            if (!matcher.find()) {
                z = false;
                break;
            }
        } while (!matcher.group(1).contains(str2));
        us.pinguo.common.log.a.q("isMatcherProduct:" + z, new Object[0]);
        return z;
    }

    public static boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Matcher matcher = Pattern.compile("\\bstatus\\b(.*?),").matcher(str);
            while (matcher.find()) {
                if (matcher.group(1).contains("200")) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static synchronized OrderHelp getInstance() {
        OrderHelp orderHelp;
        synchronized (OrderHelp.class) {
            orderHelp = b.a;
        }
        return orderHelp;
    }

    private void h(i iVar, String str) {
        if (iVar != null) {
            PayHelp.getInstance().a0(iVar);
            PayHelp.getInstance().c0(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<String> i(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            Matcher matcher = Pattern.compile("\\bproductId\\b.*?:(.*?),").matcher(str);
            while (matcher.find()) {
                arrayList.add(matcher.group(1).replace("\"", "").trim());
            }
        } catch (Exception e2) {
            us.pinguo.common.log.a.q("parseProduct:" + e2.toString(), new Object[0]);
        }
        return arrayList;
    }

    private void j(Context context, String str, int i2, c cVar) {
        this.c.execute(new a(str, i2, context, cVar));
    }

    public void e(Context context, String str, int i2, c cVar, i iVar, String str2, Object... objArr) {
        if ((objArr == null || objArr.length <= 0) && !TextUtils.isEmpty(this.b)) {
            if (cVar != null) {
                cVar.a(this.b);
                return;
            }
            return;
        }
        if (iVar != null) {
            h(iVar, str2);
        }
        j(context, str, i2, cVar);
    }
}
