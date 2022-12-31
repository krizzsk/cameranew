package androidx.work;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.List;
/* loaded from: classes.dex */
public abstract class InputMerger {
    private static final String TAG = Logger.tagWithPrefix("InputMerger");

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static InputMerger fromClassName(String str) {
        try {
            return (InputMerger) Class.forName(str).newInstance();
        } catch (Exception e2) {
            Logger logger = Logger.get();
            String str2 = TAG;
            logger.error(str2, "Trouble instantiating + " + str, e2);
            return null;
        }
    }

    @NonNull
    public abstract Data merge(@NonNull List<Data> list);
}
