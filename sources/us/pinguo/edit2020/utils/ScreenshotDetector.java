package us.pinguo.edit2020.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.provider.MediaStore;
import java.util.Locale;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import kotlin.u;
/* compiled from: ScreenshotObserver.kt */
/* loaded from: classes4.dex */
public final class ScreenshotDetector {
    public static final a b = new a(null);
    private static final String[] c = {"_display_name", "_data", "date_added"};
    private ContentObserver a;

    /* compiled from: ScreenshotObserver.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public static final /* synthetic */ boolean a(a aVar, String str) {
            return aVar.b(str);
        }

        public final boolean b(String str) {
            boolean C;
            boolean C2;
            boolean C3;
            if (str == null) {
                return false;
            }
            Locale locale = Locale.getDefault();
            s.g(locale, "getDefault()");
            String lowerCase = str.toLowerCase(locale);
            s.g(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            C = StringsKt__StringsKt.C(lowerCase, "screenshot", false, 2, null);
            if (!C) {
                C2 = StringsKt__StringsKt.C(str, "截屏", false, 2, null);
                if (!C2) {
                    C3 = StringsKt__StringsKt.C(str, "截图", false, 2, null);
                    if (!C3) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static final /* synthetic */ String[] a() {
        return c;
    }

    public final void b(Context context, l<? super String, u> lVar) {
        s.h(context, "context");
        ContentResolver contentResolver = context.getContentResolver();
        ScreenshotDetector$start$observer$1 screenshotDetector$start$observer$1 = new ScreenshotDetector$start$observer$1(contentResolver);
        screenshotDetector$start$observer$1.d(lVar);
        contentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, screenshotDetector$start$observer$1);
        this.a = screenshotDetector$start$observer$1;
    }

    public final void c(Context context) {
        s.h(context, "context");
        ContentObserver contentObserver = this.a;
        if (contentObserver == null) {
            return;
        }
        context.getContentResolver().unregisterContentObserver(contentObserver);
    }
}
