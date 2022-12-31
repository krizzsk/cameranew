package com.googlecode.mp4parser.authoring.builder;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.OriginalFormatBox;
import com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.util.Math;
import com.googlecode.mp4parser.util.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
/* loaded from: classes2.dex */
public class SyncSampleIntersectFinderImpl implements FragmentIntersectionFinder {
    private static Logger LOG = Logger.getLogger(SyncSampleIntersectFinderImpl.class.getName());
    private final int minFragmentDurationSeconds;
    private Movie movie;
    private Track referenceTrack;

    public SyncSampleIntersectFinderImpl(Movie movie, Track track, int i2) {
        this.movie = movie;
        this.referenceTrack = track;
        this.minFragmentDurationSeconds = i2;
    }

    private static long calculateTracktimesScalingFactor(Movie movie, Track track) {
        long j2 = 1;
        for (Track track2 : movie.getTracks()) {
            if (track2.getHandler().equals(track.getHandler()) && track2.getTrackMetaData().getTimescale() != track.getTrackMetaData().getTimescale()) {
                j2 = Math.lcm(j2, track2.getTrackMetaData().getTimescale());
            }
        }
        return j2;
    }

    static String getFormat(Track track) {
        AbstractSampleEntry sampleEntry = track.getSampleDescriptionBox().getSampleEntry();
        String type = sampleEntry.getType();
        return (type.equals(VisualSampleEntry.TYPE_ENCRYPTED) || type.equals(AudioSampleEntry.TYPE_ENCRYPTED) || type.equals(VisualSampleEntry.TYPE_ENCRYPTED)) ? ((OriginalFormatBox) Path.getPath((Box) sampleEntry, "sinf/frma")).getDataFormat() : type;
    }

    public static List<long[]> getSyncSamplesTimestamps(Movie movie, Track track) {
        long[] syncSamples;
        LinkedList linkedList = new LinkedList();
        for (Track track2 : movie.getTracks()) {
            if (track2.getHandler().equals(track.getHandler()) && (syncSamples = track2.getSyncSamples()) != null && syncSamples.length > 0) {
                linkedList.add(getTimes(track2, movie));
            }
        }
        return linkedList;
    }

    private static long[] getTimes(Track track, Movie movie) {
        long[] syncSamples = track.getSyncSamples();
        long[] jArr = new long[syncSamples.length];
        long calculateTracktimesScalingFactor = calculateTracktimesScalingFactor(movie, track);
        long j2 = 0;
        int i2 = 0;
        int i3 = 1;
        while (true) {
            long j3 = i3;
            if (j3 > syncSamples[syncSamples.length - 1]) {
                return jArr;
            }
            if (j3 == syncSamples[i2]) {
                jArr[i2] = j2 * calculateTracktimesScalingFactor;
                i2++;
            }
            j2 += track.getSampleDurations()[i3 - 1];
            i3++;
        }
    }

    public long[] getCommonIndices(long[] jArr, long[] jArr2, long j2, long[]... jArr3) {
        LinkedList linkedList;
        LinkedList<Long> linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        for (int i2 = 0; i2 < jArr2.length; i2++) {
            boolean z = true;
            for (long[] jArr4 : jArr3) {
                z &= Arrays.binarySearch(jArr4, jArr2[i2]) >= 0;
            }
            if (z) {
                linkedList2.add(Long.valueOf(jArr[i2]));
                linkedList3.add(Long.valueOf(jArr2[i2]));
            }
        }
        if (linkedList2.size() < jArr.length * 0.25d) {
            String str = "" + String.format("%5d - Common:  [", Integer.valueOf(linkedList2.size()));
            for (Long l2 : linkedList2) {
                long longValue = l2.longValue();
                str = String.valueOf(str) + String.format("%10d,", Long.valueOf(longValue));
            }
            LOG.warning(String.valueOf(str) + "]");
            String str2 = "" + String.format("%5d - In    :  [", Integer.valueOf(jArr.length));
            for (long j3 : jArr) {
                str2 = String.valueOf(str2) + String.format("%10d,", Long.valueOf(j3));
            }
            LOG.warning(String.valueOf(str2) + "]");
            LOG.warning("There are less than 25% of common sync samples in the given track.");
            throw new RuntimeException("There are less than 25% of common sync samples in the given track.");
        }
        if (linkedList2.size() < jArr.length * 0.5d) {
            LOG.fine("There are less than 50% of common sync samples in the given track. This is implausible but I'm ok to continue.");
        } else if (linkedList2.size() < jArr.length) {
            LOG.finest("Common SyncSample positions vs. this tracks SyncSample positions: " + linkedList2.size() + " vs. " + jArr.length);
        }
        LinkedList linkedList4 = new LinkedList();
        if (this.minFragmentDurationSeconds > 0) {
            Iterator it = linkedList2.iterator();
            Iterator it2 = linkedList3.iterator();
            long j4 = -1;
            long j5 = -1;
            while (it.hasNext() && it2.hasNext()) {
                long longValue2 = ((Long) it.next()).longValue();
                long longValue3 = ((Long) it2.next()).longValue();
                if (j5 == j4 || (longValue3 - j5) / j2 >= this.minFragmentDurationSeconds) {
                    linkedList4.add(Long.valueOf(longValue2));
                    j5 = longValue3;
                }
                j4 = -1;
            }
            linkedList = linkedList4;
        } else {
            linkedList = linkedList2;
        }
        int size = linkedList.size();
        long[] jArr5 = new long[size];
        for (int i3 = 0; i3 < size; i3++) {
            jArr5[i3] = ((Long) linkedList.get(i3)).longValue();
        }
        return jArr5;
    }

    @Override // com.googlecode.mp4parser.authoring.builder.FragmentIntersectionFinder
    public long[] sampleNumbers(Track track) {
        if ("vide".equals(track.getHandler())) {
            if (track.getSyncSamples() != null && track.getSyncSamples().length > 0) {
                List<long[]> syncSamplesTimestamps = getSyncSamplesTimestamps(this.movie, track);
                return getCommonIndices(track.getSyncSamples(), getTimes(track, this.movie), track.getTrackMetaData().getTimescale(), (long[][]) syncSamplesTimestamps.toArray(new long[syncSamplesTimestamps.size()]));
            }
            throw new RuntimeException("Video Tracks need sync samples. Only tracks other than video may have no sync samples.");
        }
        int i2 = 0;
        if ("soun".equals(track.getHandler())) {
            if (this.referenceTrack == null) {
                for (Track track2 : this.movie.getTracks()) {
                    if (track2.getSyncSamples() != null && "vide".equals(track2.getHandler()) && track2.getSyncSamples().length > 0) {
                        this.referenceTrack = track2;
                    }
                }
            }
            Track track3 = this.referenceTrack;
            if (track3 != null) {
                long[] sampleNumbers = sampleNumbers(track3);
                int size = this.referenceTrack.getSamples().size();
                int length = sampleNumbers.length;
                long[] jArr = new long[length];
                long j2 = 192000;
                Iterator<Track> it = this.movie.getTracks().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Track next = it.next();
                    if (getFormat(track).equals(getFormat(next))) {
                        AudioSampleEntry audioSampleEntry = (AudioSampleEntry) next.getSampleDescriptionBox().getSampleEntry();
                        if (audioSampleEntry.getSampleRate() < 192000) {
                            long sampleRate = audioSampleEntry.getSampleRate();
                            double size2 = next.getSamples().size() / size;
                            long j3 = next.getSampleDurations()[0];
                            int i3 = 0;
                            while (i3 < length) {
                                jArr[i3] = (long) Math.ceil((sampleNumbers[i3] - 1) * size2 * j3);
                                i3++;
                                sampleNumbers = sampleNumbers;
                                length = length;
                                i2 = 0;
                            }
                            j2 = sampleRate;
                        }
                    }
                }
                long j4 = track.getSampleDurations()[i2];
                double sampleRate2 = ((AudioSampleEntry) track.getSampleDescriptionBox().getSampleEntry()).getSampleRate() / j2;
                if (sampleRate2 == Math.rint(sampleRate2)) {
                    while (i2 < length) {
                        jArr[i2] = (long) (((jArr[i2] * sampleRate2) / j4) + 1.0d);
                        i2++;
                    }
                    return jArr;
                }
                throw new RuntimeException("Sample rates must be a multiple of the lowest sample rate to create a correct file!");
            }
            throw new RuntimeException("There was absolutely no Track with sync samples. I can't work with that!");
        }
        for (Track track4 : this.movie.getTracks()) {
            if (track4.getSyncSamples() != null && track4.getSyncSamples().length > 0) {
                long[] sampleNumbers2 = sampleNumbers(track4);
                int size3 = track4.getSamples().size();
                int length2 = sampleNumbers2.length;
                long[] jArr2 = new long[length2];
                double size4 = track.getSamples().size() / size3;
                for (int i4 = 0; i4 < length2; i4++) {
                    jArr2[i4] = ((long) Math.ceil((sampleNumbers2[i4] - 1) * size4)) + 1;
                }
                return jArr2;
            }
        }
        throw new RuntimeException("There was absolutely no Track with sync samples. I can't work with that!");
    }
}
