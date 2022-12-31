package us.pinguo.common.db;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import us.pinguo.common.db.f;
/* compiled from: DbQueryBuilder.java */
/* loaded from: classes4.dex */
public class d {
    private final HashMap<String, List<String>> a = new HashMap<>();
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f9781d;

    /* renamed from: e  reason: collision with root package name */
    private String f9782e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9783f;

    private static void a(StringBuilder sb, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        sb.append(str);
        sb.append(str2);
    }

    public static void b(StringBuilder sb, Collection<String> collection) {
        int i2 = 0;
        for (String str : collection) {
            if (str != null) {
                if (i2 > 0) {
                    sb.append(", ");
                }
                sb.append(str);
            }
            i2++;
        }
        sb.append(' ');
    }

    public String c() {
        if (TextUtils.isEmpty(this.f9781d) && !TextUtils.isEmpty(this.f9782e)) {
            throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
        }
        if (this.a.size() != 0) {
            StringBuilder sb = new StringBuilder(120);
            sb.append("SELECT ");
            if (this.f9783f) {
                sb.append("DISTINCT ");
            }
            StringBuilder sb2 = new StringBuilder();
            Set<String> keySet = this.a.keySet();
            Iterator<String> it = keySet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                List<String> list = this.a.get(it.next());
                if (list.size() == 0) {
                    sb2 = new StringBuilder();
                    sb2.append("* ");
                    break;
                }
                b(sb2, list);
            }
            sb.append(sb2.toString());
            sb.append("FROM ");
            b(sb, keySet);
            sb.append(keySet);
            a(sb, " WHERE ", this.b);
            a(sb, " GROUP BY ", this.f9781d);
            a(sb, " HAVING ", this.f9782e);
            a(sb, " ORDER BY ", this.c);
            return sb.toString();
        }
        throw new IllegalArgumentException("tableColumns not be called");
    }

    public d d(String str) {
        this.a.put(str, new ArrayList());
        return this;
    }

    public d e(String str, List<f.c> list) {
        f(str, list, "");
        return this;
    }

    public d f(String str, List<f.c> list, String str2) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(".");
            sb.append(list.get(i2).a);
            if (!TextUtils.isEmpty(str2)) {
                sb.append(" as ");
                sb.append(str2);
                sb.append(list.get(i2).a);
            }
            arrayList.set(i2, sb.toString());
        }
        this.a.put(str, arrayList);
        return this;
    }

    public d g(String str) {
        this.b = str;
        return this;
    }
}
