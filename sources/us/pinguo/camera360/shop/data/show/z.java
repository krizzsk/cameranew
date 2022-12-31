package us.pinguo.camera360.shop.data.show;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import us.pinguo.librouter.application.BaseApplication;
/* compiled from: UnityRedPointManager.java */
/* loaded from: classes4.dex */
public class z {

    /* renamed from: f  reason: collision with root package name */
    private static final z f9666f = new z();
    private Set<String> a = null;
    private Set<String> b = null;
    private LinkedHashSet<String> c = null;

    /* renamed from: d  reason: collision with root package name */
    private LinkedHashSet<String> f9667d = null;

    /* renamed from: e  reason: collision with root package name */
    private Context f9668e = BaseApplication.d();

    private z() {
    }

    public static z b() {
        return f9666f;
    }

    private LinkedHashSet<String> c(String str) {
        String d2 = us.pinguo.foundation.base.e.d(this.f9668e, str);
        if (TextUtils.isEmpty(d2)) {
            return new LinkedHashSet<>();
        }
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        Collections.addAll(linkedHashSet, d2.split(";"));
        return linkedHashSet;
    }

    private Set<String> d(String str) {
        String d2 = us.pinguo.foundation.base.e.d(this.f9668e, str);
        if (TextUtils.isEmpty(d2)) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, d2.split(";"));
        return hashSet;
    }

    private void e() {
        if (this.c == null) {
            this.c = c("key_sticker_old_id_of_pkg");
        }
        if (this.a == null) {
            this.a = d("key_sticker_last_pkg_ids");
        }
        if (this.f9667d == null) {
            this.f9667d = c("key_sticker_old_id_of_topic");
        }
        if (this.b == null) {
            this.b = d("key_sticker_last_topic_ids");
        }
    }

    private void f() {
        Iterator<String> it = this.c.iterator();
        for (int size = this.c.size() + InputDeviceCompat.SOURCE_ANY; size > 0 && it.hasNext(); size--) {
            it.next();
            it.remove();
        }
        g(this.c, "key_sticker_old_id_of_pkg");
        g(this.a, "key_sticker_last_pkg_ids");
    }

    private void g(Collection<String> collection, String str) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : collection) {
            sb.append(str2);
            sb.append(";");
        }
        int length = sb.length();
        if (length > 0) {
            sb.deleteCharAt(length - 1);
            us.pinguo.foundation.base.e.g(this.f9668e, str, sb.toString());
        }
    }

    private void h() {
        Iterator<String> it = this.f9667d.iterator();
        for (int size = this.f9667d.size() - 64; size > 0 && it.hasNext(); size--) {
            it.next();
            it.remove();
        }
        g(this.f9667d, "key_sticker_old_id_of_topic");
        g(this.b, "key_sticker_last_topic_ids");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        us.pinguo.foundation.base.e.g(this.f9668e, "key_sticker_old_id_of_pkg", "");
        us.pinguo.foundation.base.e.g(this.f9668e, "key_sticker_last_pkg_ids", "");
        us.pinguo.foundation.base.e.g(this.f9668e, "key_sticker_old_id_of_pkg", "");
        us.pinguo.foundation.base.e.g(this.f9668e, "key_sticker_last_pkg_ids", "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(Collection<ShowPkg> collection, Collection<ShowTopic> collection2, boolean z) {
        e();
        for (ShowPkg showPkg : collection) {
            this.c.add(showPkg.getId());
        }
        if (z) {
            this.a.addAll(this.c);
        }
        for (ShowTopic showTopic : collection2) {
            this.f9667d.add(showTopic.getId());
            this.b.add(showTopic.getId());
        }
        f();
        h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j(Collection<ShowPkg> collection, Collection<ShowTopic> collection2) {
        boolean z;
        e();
        if (this.a.isEmpty()) {
            i(collection, collection2, true);
            return false;
        }
        HashSet hashSet = new HashSet();
        for (ShowPkg showPkg : collection) {
            if (!this.a.contains(showPkg.getId())) {
                hashSet.add(showPkg.getId());
            }
        }
        HashSet hashSet2 = new HashSet();
        if (collection2 != null) {
            z = false;
            for (ShowTopic showTopic : collection2) {
                if (!this.b.contains(showTopic.getId())) {
                    hashSet2.add(showTopic.getId());
                    z = true;
                } else {
                    for (ShowPkg showPkg2 : showTopic.getPkgs()) {
                        if (hashSet.contains(showPkg2.getId())) {
                            hashSet2.add(showTopic.getId());
                            z = true;
                        }
                    }
                }
            }
        } else {
            z = false;
        }
        if (z) {
            for (ShowPkg showPkg3 : collection) {
                this.a.add(showPkg3.getId());
            }
            for (ShowTopic showTopic2 : collection2) {
                this.b.add(showTopic2.getId());
            }
            this.f9667d.removeAll(hashSet2);
            f();
            h();
            return true;
        }
        return false;
    }
}
