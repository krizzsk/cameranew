package us.pinguo.foundation.statistics;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
/* loaded from: classes4.dex */
public class PageStack {

    /* renamed from: d  reason: collision with root package name */
    private static final String f11041d = "PageStack";
    private Stack<String> a = new Stack<>();
    private List<List<String>> b = new ArrayList();
    private List<String> c = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {
        private static final PageStack a = new PageStack();
    }

    private boolean a(String str, String str2) {
        Iterator<List<String>> it = this.b.iterator();
        if (it.hasNext()) {
            List<String> next = it.next();
            return next.contains(str) && next.contains(str2);
        }
        return false;
    }

    public static PageStack getInstance() {
        return a.a;
    }

    public void b(String str) {
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.a.isEmpty()) {
            if (this.c.contains(str)) {
                this.a.clear();
            } else {
                if (a(str, this.a.peek())) {
                    this.a.pop();
                }
                if (this.a.search(str) != -1) {
                    while (!this.a.isEmpty() && !str.equals(this.a.pop())) {
                    }
                }
            }
        }
        this.a.push(str);
    }

    public int d() {
        return this.a.size();
    }

    public String e() {
        if (this.a.isEmpty()) {
            return "";
        }
        boolean z = true;
        if (this.a.size() == 1) {
            us.pinguo.common.log.a.m(f11041d, this.a.peek(), new Object[0]);
            return this.a.peek();
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.a.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (z) {
                sb.append(next);
                z = false;
            } else {
                sb.append("/" + next);
            }
        }
        us.pinguo.common.log.a.m(f11041d, sb.toString(), new Object[0]);
        return sb.toString();
    }
}
