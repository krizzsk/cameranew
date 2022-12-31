package kotlin.text;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
public final class j {
    /* JADX INFO: Access modifiers changed from: private */
    public static final h e(Matcher matcher, int i2, CharSequence charSequence) {
        if (matcher.find(i2)) {
            return new i(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h f(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new i(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.z.d g(MatchResult matchResult) {
        kotlin.z.d h2;
        h2 = kotlin.z.j.h(matchResult.start(), matchResult.end());
        return h2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int h(Iterable<? extends f> iterable) {
        int i2 = 0;
        for (f fVar : iterable) {
            i2 |= fVar.getValue();
        }
        return i2;
    }
}
