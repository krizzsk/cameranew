package vStudio.Android.Camera360.guide.pageview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.u;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.v;
import vStudio.Android.Camera360.Conditions;
import vStudio.Android.Camera360.R;
/* compiled from: GuideImageControl.kt */
/* loaded from: classes7.dex */
public final class c {
    private final ArrayList<String> a;
    private final Locale b;

    public c() {
        ArrayList<String> f2;
        f2 = u.f("vi", "th", "zh", "ja", "ko");
        this.a = f2;
        this.b = v.a();
    }

    private final List<Integer> b() {
        ArrayList f2;
        ArrayList f3;
        ArrayList f4;
        ArrayList f5;
        ArrayList f6;
        ArrayList f7;
        ArrayList f8;
        ArrayList f9;
        ArrayList f10;
        ArrayList f11;
        String language = this.b.getLanguage();
        if (language != null) {
            int hashCode = language.hashCode();
            if (hashCode != 3246) {
                if (hashCode != 3365) {
                    if (hashCode != 3383) {
                        if (hashCode != 3428) {
                            if (hashCode != 3588) {
                                if (hashCode != 3700) {
                                    if (hashCode != 3763) {
                                        if (hashCode == 3886 && language.equals("zh")) {
                                            if (s.c("CN", this.b.getCountry())) {
                                                f11 = u.f(Integer.valueOf((int) R.drawable.ic_welcome_text_cn_1), Integer.valueOf((int) R.drawable.ic_welcome_text_cn_2));
                                                return f11;
                                            }
                                            f10 = u.f(Integer.valueOf((int) R.drawable.ic_welcome_text_t_cn_1), Integer.valueOf((int) R.drawable.ic_welcome_text_t_cn_2));
                                            return f10;
                                        }
                                    } else if (language.equals("vi")) {
                                        f9 = u.f(Integer.valueOf((int) R.drawable.ic_welcome_text_vi_1), Integer.valueOf((int) R.drawable.ic_welcome_text_vi_2));
                                        return f9;
                                    }
                                } else if (language.equals("th")) {
                                    f8 = u.f(Integer.valueOf((int) R.drawable.ic_welcome_text_th_1), Integer.valueOf((int) R.drawable.ic_welcome_text_th_2));
                                    return f8;
                                }
                            } else if (language.equals("pt")) {
                                f7 = u.f(Integer.valueOf((int) R.drawable.ic_welcome_text_pt_1), Integer.valueOf((int) R.drawable.ic_welcome_text_pt_2));
                                return f7;
                            }
                        } else if (language.equals("ko")) {
                            f6 = u.f(Integer.valueOf((int) R.drawable.ic_welcome_text_ko_1), Integer.valueOf((int) R.drawable.ic_welcome_text_ko_2));
                            return f6;
                        }
                    } else if (language.equals("ja")) {
                        f5 = u.f(Integer.valueOf((int) R.drawable.ic_welcome_text_ja_1), Integer.valueOf((int) R.drawable.ic_welcome_text_ja_2));
                        return f5;
                    }
                } else if (language.equals("in")) {
                    f4 = u.f(Integer.valueOf((int) R.drawable.ic_welcome_text_in_1), Integer.valueOf((int) R.drawable.ic_welcome_text_in_2));
                    return f4;
                }
            } else if (language.equals("es")) {
                f3 = u.f(Integer.valueOf((int) R.drawable.ic_welcome_text_es_1), Integer.valueOf((int) R.drawable.ic_welcome_text_es_2));
                return f3;
            }
        }
        f2 = u.f(Integer.valueOf((int) R.drawable.ic_welcome_text_en_1), Integer.valueOf((int) R.drawable.ic_welcome_text_en_2));
        return f2;
    }

    private final boolean c() {
        return this.a.contains(this.b.getLanguage());
    }

    public final List<d> a() {
        ArrayList f2;
        int i2 = 0;
        if (c()) {
            f2 = (Conditions.d() || Conditions.e()) ? u.f(Integer.valueOf((int) R.drawable.ic_welcome_bg_cn_1_gp), Integer.valueOf((int) R.drawable.ic_welcome_bg_cn_2_gp)) : u.f(Integer.valueOf((int) R.drawable.ic_welcome_bg_cn_1), Integer.valueOf((int) R.drawable.ic_welcome_bg_cn_2));
        } else {
            f2 = u.f(Integer.valueOf((int) R.drawable.ic_welcome_bg_en_1), Integer.valueOf((int) R.drawable.ic_welcome_bg_en_2));
        }
        List<Integer> b = b();
        ArrayList arrayList = new ArrayList();
        Iterator it = f2.iterator();
        while (it.hasNext()) {
            arrayList.add(new d(((Number) it.next()).intValue(), b.get(i2).intValue()));
            i2++;
        }
        return arrayList;
    }
}
