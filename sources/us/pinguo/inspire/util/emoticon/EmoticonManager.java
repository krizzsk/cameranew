package us.pinguo.inspire.util.emoticon;

import android.text.TextUtils;
import com.rockerhieu.emoji.model.Emoticon;
import com.rockerhieu.emoji.model.EmoticonFactory;
import com.rockerhieu.emoji.model.EmoticonPkg;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import us.pinguo.foundation.utils.u;
import us.pinguo.inspire.Inspire;
/* loaded from: classes9.dex */
public class EmoticonManager {
    private List<EmoticonPkg> a;

    /* loaded from: classes9.dex */
    private static final class b {
        private static final EmoticonManager a = new EmoticonManager();
    }

    private EmoticonPkg a(EmoticonPkg emoticonPkg) {
        File c;
        if (emoticonPkg.isOnline != 0 && (c = g.c(emoticonPkg.pkgId)) != null && c.exists() && c.isDirectory() && g.d(c)) {
            try {
                return EmoticonFactory.decodeEmoticonPkg(c, new h());
            } catch (IOException e2) {
                d.f.a.b.d.c(e2);
            }
        }
        return null;
    }

    private void b() {
        if (this.a == null) {
            return;
        }
        c();
    }

    private void c() {
        if (u.b()) {
            return;
        }
        for (EmoticonPkg emoticonPkg : this.a) {
            if ("5844c12a08fadd0ba6b54df2".equals(emoticonPkg.pkgId)) {
                this.a.remove(emoticonPkg);
                return;
            }
        }
    }

    public static EmoticonManager getInstance() {
        return b.a;
    }

    public Emoticon d(String str) {
        List<EmoticonPkg> list = this.a;
        if (list == null) {
            return null;
        }
        for (EmoticonPkg emoticonPkg : list) {
            List<Emoticon> list2 = emoticonPkg.emoticons;
            if (list2 != null) {
                for (Emoticon emoticon : list2) {
                    if (str != null && str.equals(emoticon.emoticonId)) {
                        return emoticon;
                    }
                }
                continue;
            }
        }
        return null;
    }

    public Emoticon e(String str) {
        List<Emoticon> list;
        EmoticonPkg.EmoticonName emoticonName;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<EmoticonPkg> it = this.a.iterator();
        while (it.hasNext() && (list = it.next().emoticons) != null) {
            for (Emoticon emoticon : list) {
                if (str != null && (emoticonName = emoticon.name) != null && (str.equals(emoticonName.zh_cn) || str.equals(emoticon.name.zh_tw) || str.equalsIgnoreCase(emoticon.name.en_us))) {
                    return emoticon;
                }
            }
        }
        return null;
    }

    public EmoticonPkg f() {
        return g("emoj");
    }

    public EmoticonPkg g(String str) {
        if (str == null) {
            return null;
        }
        for (EmoticonPkg emoticonPkg : this.a) {
            if (str.equals(emoticonPkg.pkgId)) {
                return emoticonPkg;
            }
        }
        return null;
    }

    public List<EmoticonPkg> h() {
        return new ArrayList(this.a);
    }

    public void i(EmoticonPkg emoticonPkg) {
        if (this.a != null) {
            int i2 = 0;
            while (true) {
                if (i2 < this.a.size()) {
                    String str = emoticonPkg.pkgId;
                    if (str != null && str.equals(this.a.get(i2).pkgId)) {
                        this.a.set(i2, emoticonPkg);
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
        } else {
            LinkedList linkedList = new LinkedList();
            this.a = linkedList;
            linkedList.add(emoticonPkg);
        }
        Collections.sort(this.a);
    }

    private EmoticonManager() {
        this.a = EmoticonFactory.decodePkgs(Inspire.a(), new h());
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            EmoticonPkg a2 = a(this.a.get(i2));
            if (a2 != null) {
                this.a.set(i2, a2);
            }
        }
        b();
    }
}
