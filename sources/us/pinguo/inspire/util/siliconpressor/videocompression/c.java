package us.pinguo.inspire.util.siliconpressor.videocompression;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import com.googlecode.mp4parser.util.Matrix;
import java.io.File;
import java.util.ArrayList;
/* compiled from: Mp4Movie.java */
@TargetApi(16)
/* loaded from: classes9.dex */
public class c {
    private Matrix a = Matrix.ROTATE_0;
    private ArrayList<g> b = new ArrayList<>();
    private File c;

    public void a(int i2, long j2, MediaCodec.BufferInfo bufferInfo) throws Exception {
        if (i2 < 0 || i2 >= this.b.size()) {
            return;
        }
        this.b.get(i2).a(j2, bufferInfo);
    }

    public int b(MediaFormat mediaFormat, boolean z) throws Exception {
        this.b.add(new g(this.b.size(), mediaFormat, z));
        return this.b.size() - 1;
    }

    public File c() {
        return this.c;
    }

    public Matrix d() {
        return this.a;
    }

    public ArrayList<g> e() {
        return this.b;
    }

    public void f(File file) {
        this.c = file;
    }

    public void g(int i2) {
        if (i2 == 0) {
            this.a = Matrix.ROTATE_0;
        } else if (i2 == 90) {
            this.a = Matrix.ROTATE_90;
        } else if (i2 == 180) {
            this.a = Matrix.ROTATE_180;
        } else if (i2 == 270) {
            this.a = Matrix.ROTATE_270;
        }
    }

    public void h(int i2, int i3) {
    }
}
