package us.pinguo.pgshare.commons;

import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import java.util.Set;
/* compiled from: ActionFilter.java */
/* loaded from: classes5.dex */
public class a {
    private Set<String> a;
    private Set<String> b;
    private Set<String> c;

    /* renamed from: d  reason: collision with root package name */
    private Set<String> f11629d;

    public boolean a(ResolveInfo resolveInfo) {
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        String str = activityInfo.packageName;
        String str2 = activityInfo.name;
        Set<String> set = this.a;
        if (set == null || !set.contains(str)) {
            if (this.a == null || !this.b.contains(str2)) {
                Set<String> set2 = this.c;
                if (set2 != null) {
                    for (String str3 : set2) {
                        if (str.startsWith(str3.substring(0, str3.length() - 2))) {
                            return true;
                        }
                    }
                }
                Set<String> set3 = this.f11629d;
                if (set3 != null) {
                    for (String str4 : set3) {
                        if (str2.startsWith(str4.substring(0, str4.length() - 2))) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }
}
