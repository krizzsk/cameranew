package com.mp4parser.iso14496.part12;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.aspectj.lang.a;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* loaded from: classes3.dex */
public class SampleAuxiliaryInformationSizesBox extends AbstractFullBox {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TYPE = "saiz";
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_10 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_11 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_9 = null;
    private String auxInfoType;
    private String auxInfoTypeParameter;
    private short defaultSampleInfoSize;
    private int sampleCount;
    private short[] sampleInfoSizes;

    static {
        ajc$preClinit();
    }

    public SampleAuxiliaryInformationSizesBox() {
        super(TYPE);
        this.sampleInfoSizes = new short[0];
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("SampleAuxiliaryInformationSizesBox.java", SampleAuxiliaryInformationSizesBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getSize", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "int", FirebaseAnalytics.Param.INDEX, "", "short"), 57);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "getAuxInfoType", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "java.lang.String"), 107);
        ajc$tjp_10 = bVar.h("method-execution", bVar.g("1", "setSampleCount", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "int", "sampleCount", "", "void"), IjkMediaMeta.FF_PROFILE_H264_HIGH_444);
        ajc$tjp_11 = bVar.h("method-execution", bVar.g("1", "toString", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "java.lang.String"), 149);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "setAuxInfoType", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "java.lang.String", "auxInfoType", "", "void"), 111);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "getAuxInfoTypeParameter", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "java.lang.String"), 115);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "setAuxInfoTypeParameter", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "java.lang.String", "auxInfoTypeParameter", "", "void"), 119);
        ajc$tjp_5 = bVar.h("method-execution", bVar.g("1", "getDefaultSampleInfoSize", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "int"), 123);
        ajc$tjp_6 = bVar.h("method-execution", bVar.g("1", "setDefaultSampleInfoSize", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "int", "defaultSampleInfoSize", "", "void"), 127);
        ajc$tjp_7 = bVar.h("method-execution", bVar.g("1", "getSampleInfoSizes", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "[S"), 132);
        ajc$tjp_8 = bVar.h("method-execution", bVar.g("1", "setSampleInfoSizes", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "[S", "sampleInfoSizes", "", "void"), 136);
        ajc$tjp_9 = bVar.h("method-execution", bVar.g("1", "getSampleCount", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "int"), InspirePublishFragment.MAX_DESC_COUNT);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if ((getFlags() & 1) == 1) {
            this.auxInfoType = IsoTypeReader.read4cc(byteBuffer);
            this.auxInfoTypeParameter = IsoTypeReader.read4cc(byteBuffer);
        }
        this.defaultSampleInfoSize = (short) IsoTypeReader.readUInt8(byteBuffer);
        int l2i = CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer));
        this.sampleCount = l2i;
        if (this.defaultSampleInfoSize == 0) {
            this.sampleInfoSizes = new short[l2i];
            for (int i2 = 0; i2 < this.sampleCount; i2++) {
                this.sampleInfoSizes[i2] = (short) IsoTypeReader.readUInt8(byteBuffer);
            }
        }
    }

    public String getAuxInfoType() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_1, this, this));
        return this.auxInfoType;
    }

    public String getAuxInfoTypeParameter() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_3, this, this));
        return this.auxInfoTypeParameter;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        if ((getFlags() & 1) == 1) {
            byteBuffer.put(IsoFile.fourCCtoBytes(this.auxInfoType));
            byteBuffer.put(IsoFile.fourCCtoBytes(this.auxInfoTypeParameter));
        }
        IsoTypeWriter.writeUInt8(byteBuffer, this.defaultSampleInfoSize);
        if (this.defaultSampleInfoSize == 0) {
            IsoTypeWriter.writeUInt32(byteBuffer, this.sampleInfoSizes.length);
            for (short s : this.sampleInfoSizes) {
                IsoTypeWriter.writeUInt8(byteBuffer, s);
            }
            return;
        }
        IsoTypeWriter.writeUInt32(byteBuffer, this.sampleCount);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return ((getFlags() & 1) == 1 ? 12 : 4) + 5 + (this.defaultSampleInfoSize == 0 ? this.sampleInfoSizes.length : 0);
    }

    public int getDefaultSampleInfoSize() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_5, this, this));
        return this.defaultSampleInfoSize;
    }

    public int getSampleCount() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_9, this, this));
        return this.sampleCount;
    }

    public short[] getSampleInfoSizes() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_7, this, this));
        short[] sArr = this.sampleInfoSizes;
        return Arrays.copyOf(sArr, sArr.length);
    }

    public short getSize(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_0, this, this, h.a.a.a.a.e(i2)));
        if (getDefaultSampleInfoSize() == 0) {
            return this.sampleInfoSizes[i2];
        }
        return this.defaultSampleInfoSize;
    }

    public void setAuxInfoType(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_2, this, this, str));
        this.auxInfoType = str;
    }

    public void setAuxInfoTypeParameter(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_4, this, this, str));
        this.auxInfoTypeParameter = str;
    }

    public void setDefaultSampleInfoSize(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_6, this, this, h.a.a.a.a.e(i2)));
        this.defaultSampleInfoSize = (short) i2;
    }

    public void setSampleCount(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_10, this, this, h.a.a.a.a.e(i2)));
        this.sampleCount = i2;
    }

    public void setSampleInfoSizes(short[] sArr) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_8, this, this, sArr));
        this.sampleInfoSizes = Arrays.copyOf(sArr, sArr.length);
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_11, this, this));
        return "SampleAuxiliaryInformationSizesBox{defaultSampleInfoSize=" + ((int) this.defaultSampleInfoSize) + ", sampleCount=" + this.sampleCount + ", auxInfoType='" + this.auxInfoType + "', auxInfoTypeParameter='" + this.auxInfoTypeParameter + "'}";
    }
}
