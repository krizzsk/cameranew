package us.pinguo.camera360.shop.data.show;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import us.pinguo.repository2020.t;
/* compiled from: RedPointManager2.java */
/* loaded from: classes4.dex */
public class t implements t.a {

    /* renamed from: h  reason: collision with root package name */
    private static final t f9640h = new t();
    private Set<String> a = null;
    private Set<String> b = null;
    private Set<String> c = null;

    /* renamed from: d  reason: collision with root package name */
    private List<String> f9641d = null;

    /* renamed from: e  reason: collision with root package name */
    private List<String> f9642e = null;

    /* renamed from: f  reason: collision with root package name */
    private List<String> f9643f = null;

    /* renamed from: g  reason: collision with root package name */
    private Context f9644g = us.pinguo.util.v.a();

    private t() {
        us.pinguo.repository2020.t.a.a(this);
    }

    public static t f() {
        return f9640h;
    }

    private List<String> g(String str) {
        String d2 = us.pinguo.foundation.base.e.d(this.f9644g, str);
        if (TextUtils.isEmpty(d2)) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, d2.split(";"));
        return arrayList;
    }

    private Set<String> h(String str) {
        String d2 = us.pinguo.foundation.base.e.d(this.f9644g, str);
        if (TextUtils.isEmpty(d2)) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, d2.split(";"));
        return hashSet;
    }

    private void l() {
        if (this.f9641d == null) {
            this.f9641d = g("key_effect_old_id_of_pkg");
        }
        if (this.a == null) {
            this.a = h("key_effect_last_pkg_ids");
        }
        if (this.f9642e == null) {
            this.f9642e = g("key_effect_old_id_of_topic");
        }
        if (this.b == null) {
            this.b = h("key_effect_last_topic_ids");
        }
        if (this.f9643f == null) {
            this.f9643f = g("key_effect_old_id_of_scene");
        }
        if (this.c == null) {
            this.c = h("key_effect_last_scene_ids");
        }
    }

    private void m() {
        while (this.f9641d.size() > 256) {
            this.f9641d.remove(0);
        }
        n(this.f9641d, "key_effect_old_id_of_pkg");
        n(this.a, "key_effect_last_pkg_ids");
    }

    private void n(Collection<String> collection, String str) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : collection) {
            sb.append(str2);
            sb.append(";");
        }
        int length = sb.length();
        if (length > 0) {
            sb.deleteCharAt(length - 1);
            us.pinguo.foundation.base.e.g(this.f9644g, str, sb.toString());
        }
    }

    private void o() {
        while (this.f9643f.size() > 32) {
            this.f9643f.remove(0);
        }
        n(this.f9643f, "key_effect_old_id_of_scene");
        n(this.c, "key_effect_last_scene_ids");
    }

    private void p() {
        while (this.f9642e.size() > 64) {
            this.f9642e.remove(0);
        }
        n(this.f9642e, "key_effect_old_id_of_topic");
        n(this.b, "key_effect_last_topic_ids");
    }

    @Override // us.pinguo.repository2020.t.a
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        l();
        if (!this.f9643f.contains(str)) {
            this.f9643f.add(str);
        }
        o();
    }

    @Override // us.pinguo.repository2020.t.a
    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        l();
        this.f9641d.add(str);
        m();
    }

    public void c(String str) {
        b(str);
        us.pinguo.repository2020.t.a.c(this, str);
    }

    public void d(String str) {
        a(str);
        us.pinguo.repository2020.t.a.b(this, str);
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        l();
        this.f9642e.add(str);
        p();
    }

    public boolean i(ShowPkg showPkg) {
        l();
        return !this.f9641d.contains(showPkg.getId());
    }

    public boolean j(ShowScene showScene) {
        l();
        return !this.f9643f.contains(showScene.getId());
    }

    public boolean k(ShowTopic showTopic) {
        l();
        return !this.f9642e.contains(showTopic.getId());
    }

    public void q(Collection<ShowPkg> collection, Collection<ShowTopic> collection2, Collection<ShowScene> collection3, boolean z) {
        l();
        for (ShowPkg showPkg : collection) {
            this.f9641d.add(showPkg.getId());
            if (z) {
                this.a.add(showPkg.getId());
            }
        }
        for (ShowTopic showTopic : collection2) {
            this.f9642e.add(showTopic.getId());
            if (z) {
                this.b.add(showTopic.getId());
            }
        }
        for (ShowScene showScene : collection3) {
            this.f9643f.add(showScene.getId());
            if (z) {
                this.c.add(showScene.getId());
            }
        }
        m();
        p();
        o();
    }

    public boolean r(Collection<ShowPkg> collection, Collection<ShowTopic> collection2, Collection<ShowScene> collection3) {
        boolean z;
        l();
        if (this.a.isEmpty()) {
            q(collection, collection2, collection3, true);
            return false;
        }
        HashSet hashSet = new HashSet();
        for (ShowPkg showPkg : collection) {
            if (!this.a.contains(showPkg.getId())) {
                hashSet.add(showPkg.getId());
            }
        }
        HashSet<String> hashSet2 = new HashSet();
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
        HashSet<String> hashSet3 = new HashSet();
        for (ShowScene showScene : collection3) {
            if (!this.c.contains(showScene.getId())) {
                hashSet3.add(showScene.getId());
                z = true;
            } else {
                List<ShowTopic> topicList = showScene.getTopicList();
                if (topicList != null && topicList.size() > 0 && hashSet2.contains(topicList.get(0).getId())) {
                    hashSet3.add(showScene.getId());
                    z = true;
                }
                for (ShowPkg showPkg3 : showScene.getShowPkgs()) {
                    if (hashSet.contains(showPkg3.getId())) {
                        hashSet3.add(showScene.getId());
                        z = true;
                    }
                }
            }
        }
        if (z) {
            for (ShowPkg showPkg4 : collection) {
                this.a.add(showPkg4.getId());
            }
            for (ShowTopic showTopic2 : collection2) {
                this.b.add(showTopic2.getId());
            }
            for (String str : hashSet2) {
                this.f9642e.remove(str);
            }
            for (ShowScene showScene2 : collection3) {
                this.c.add(showScene2.getId());
            }
            for (String str2 : hashSet3) {
                this.f9643f.remove(str2);
            }
            m();
            p();
            o();
            return true;
        }
        return false;
    }
}
