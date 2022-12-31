package com.coremedia.iso.boxes;

import com.adjust.sdk.Constants;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import org.aspectj.lang.a;
/* loaded from: classes.dex */
public class SampleSizeBox extends AbstractFullBox {
    public static final String TYPE = "stsz";
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_6 = null;
    int sampleCount;
    private long sampleSize;
    private long[] sampleSizes;

    static {
        ajc$preClinit();
    }

    public SampleSizeBox() {
        super(TYPE);
        this.sampleSizes = new long[0];
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("SampleSizeBox.java", SampleSizeBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getSampleSize", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", Constants.LONG), 50);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "setSampleSize", "com.coremedia.iso.boxes.SampleSizeBox", Constants.LONG, "sampleSize", "", "void"), 54);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "getSampleSizeAtIndex", "com.coremedia.iso.boxes.SampleSizeBox", "int", FirebaseAnalytics.Param.INDEX, "", Constants.LONG), 59);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "getSampleCount", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", Constants.LONG), 67);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "getSampleSizes", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "[J"), 76);
        ajc$tjp_5 = bVar.h("method-execution", bVar.g("1", "setSampleSizes", "com.coremedia.iso.boxes.SampleSizeBox", "[J", "sampleSizes", "", "void"), 80);
        ajc$tjp_6 = bVar.h("method-execution", bVar.g("1", "toString", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "java.lang.String"), 119);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.sampleSize = IsoTypeReader.readUInt32(byteBuffer);
        int l2i = CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer));
        this.sampleCount = l2i;
        if (this.sampleSize == 0) {
            this.sampleSizes = new long[l2i];
            for (int i2 = 0; i2 < this.sampleCount; i2++) {
                this.sampleSizes[i2] = IsoTypeReader.readUInt32(byteBuffer);
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt32(byteBuffer, this.sampleSize);
        if (this.sampleSize == 0) {
            IsoTypeWriter.writeUInt32(byteBuffer, this.sampleSizes.length);
            for (long j2 : this.sampleSizes) {
                IsoTypeWriter.writeUInt32(byteBuffer, j2);
            }
            return;
        }
        IsoTypeWriter.writeUInt32(byteBuffer, this.sampleCount);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return (this.sampleSize == 0 ? this.sampleSizes.length * 4 : 0) + 12;
    }

    public long getSampleCount() {
        int length;
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_3, this, this));
        if (this.sampleSize > 0) {
            length = this.sampleCount;
        } else {
            length = this.sampleSizes.length;
        }
        return length;
    }

    public long getSampleSize() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.sampleSize;
    }

    public long getSampleSizeAtIndex(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_2, this, this, h.a.a.a.a.e(i2)));
        long j2 = this.sampleSize;
        return j2 > 0 ? j2 : this.sampleSizes[i2];
    }

    public long[] getSampleSizes() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.sampleSizes;
    }

    public void setSampleSize(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, h.a.a.a.a.f(j2)));
        this.sampleSize = j2;
    }

    public void setSampleSizes(long[] jArr) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_5, this, this, jArr));
        this.sampleSizes = jArr;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_6, this, this));
        return "SampleSizeBox[sampleSize=" + getSampleSize() + ";sampleCount=" + getSampleCount() + "]";
    }
}
