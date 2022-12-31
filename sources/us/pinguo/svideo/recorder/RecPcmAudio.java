package us.pinguo.svideo.recorder;

import android.os.Environment;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class RecPcmAudio {
    private static RecPcmAudio a = new RecPcmAudio();

    /* loaded from: classes6.dex */
    private enum FadeMode {
        FadeIn,
        FadeOut
    }

    /* loaded from: classes6.dex */
    public interface a {
    }

    static {
        String str = Environment.getExternalStorageDirectory().toString() + "/AudioFiles";
    }

    private RecPcmAudio() {
        new LinkedList();
        new LinkedList();
    }

    public static RecPcmAudio getInstance() {
        return a;
    }

    public void a(a aVar) {
    }
}
