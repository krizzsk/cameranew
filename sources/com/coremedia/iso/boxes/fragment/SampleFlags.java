package com.coremedia.iso.boxes.fragment;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class SampleFlags {
    private byte is_leading;
    private byte reserved;
    private int sampleDegradationPriority;
    private byte sampleDependsOn;
    private byte sampleHasRedundancy;
    private byte sampleIsDependedOn;
    private boolean sampleIsDifferenceSample;
    private byte samplePaddingValue;

    public SampleFlags() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SampleFlags sampleFlags = (SampleFlags) obj;
        return this.is_leading == sampleFlags.is_leading && this.reserved == sampleFlags.reserved && this.sampleDegradationPriority == sampleFlags.sampleDegradationPriority && this.sampleDependsOn == sampleFlags.sampleDependsOn && this.sampleHasRedundancy == sampleFlags.sampleHasRedundancy && this.sampleIsDependedOn == sampleFlags.sampleIsDependedOn && this.sampleIsDifferenceSample == sampleFlags.sampleIsDifferenceSample && this.samplePaddingValue == sampleFlags.samplePaddingValue;
    }

    public void getContent(ByteBuffer byteBuffer) {
        IsoTypeWriter.writeUInt32(byteBuffer, (this.reserved << 28) | 0 | (this.is_leading << 26) | (this.sampleDependsOn << 24) | (this.sampleIsDependedOn << 22) | (this.sampleHasRedundancy << 20) | (this.samplePaddingValue << 17) | ((this.sampleIsDifferenceSample ? 1 : 0) << 16) | this.sampleDegradationPriority);
    }

    public int getReserved() {
        return this.reserved;
    }

    public int getSampleDegradationPriority() {
        return this.sampleDegradationPriority;
    }

    public int getSampleDependsOn() {
        return this.sampleDependsOn;
    }

    public int getSampleHasRedundancy() {
        return this.sampleHasRedundancy;
    }

    public int getSampleIsDependedOn() {
        return this.sampleIsDependedOn;
    }

    public int getSamplePaddingValue() {
        return this.samplePaddingValue;
    }

    public int hashCode() {
        return (((((((((((((this.reserved * 31) + this.is_leading) * 31) + this.sampleDependsOn) * 31) + this.sampleIsDependedOn) * 31) + this.sampleHasRedundancy) * 31) + this.samplePaddingValue) * 31) + (this.sampleIsDifferenceSample ? 1 : 0)) * 31) + this.sampleDegradationPriority;
    }

    public boolean isSampleIsDifferenceSample() {
        return this.sampleIsDifferenceSample;
    }

    public void setReserved(int i2) {
        this.reserved = (byte) i2;
    }

    public void setSampleDegradationPriority(int i2) {
        this.sampleDegradationPriority = i2;
    }

    public void setSampleDependsOn(int i2) {
        this.sampleDependsOn = (byte) i2;
    }

    public void setSampleHasRedundancy(int i2) {
        this.sampleHasRedundancy = (byte) i2;
    }

    public void setSampleIsDependedOn(int i2) {
        this.sampleIsDependedOn = (byte) i2;
    }

    public void setSampleIsDifferenceSample(boolean z) {
        this.sampleIsDifferenceSample = z;
    }

    public void setSamplePaddingValue(int i2) {
        this.samplePaddingValue = (byte) i2;
    }

    public String toString() {
        return "SampleFlags{reserved=" + ((int) this.reserved) + ", isLeading=" + ((int) this.is_leading) + ", depOn=" + ((int) this.sampleDependsOn) + ", isDepOn=" + ((int) this.sampleIsDependedOn) + ", hasRedundancy=" + ((int) this.sampleHasRedundancy) + ", padValue=" + ((int) this.samplePaddingValue) + ", isDiffSample=" + this.sampleIsDifferenceSample + ", degradPrio=" + this.sampleDegradationPriority + '}';
    }

    public SampleFlags(ByteBuffer byteBuffer) {
        long readUInt32 = IsoTypeReader.readUInt32(byteBuffer);
        this.reserved = (byte) (((-268435456) & readUInt32) >> 28);
        this.is_leading = (byte) ((201326592 & readUInt32) >> 26);
        this.sampleDependsOn = (byte) ((50331648 & readUInt32) >> 24);
        this.sampleIsDependedOn = (byte) ((12582912 & readUInt32) >> 22);
        this.sampleHasRedundancy = (byte) ((3145728 & readUInt32) >> 20);
        this.samplePaddingValue = (byte) ((917504 & readUInt32) >> 17);
        this.sampleIsDifferenceSample = ((65536 & readUInt32) >> 16) > 0;
        this.sampleDegradationPriority = (int) (readUInt32 & 65535);
    }
}
