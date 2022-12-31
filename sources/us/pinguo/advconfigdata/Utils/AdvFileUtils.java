package us.pinguo.advconfigdata.Utils;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public final class AdvFileUtils {
    private static final int BUFFER_SIZE = 8192;
    private static final String TAG = "AdvFileUtils";

    private AdvFileUtils() {
    }

    public static boolean checkFolder(String str) {
        if (str == null) {
            return false;
        }
        return checkFolder(new File(str));
    }

    public static void close(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public static void copyFolder(File file, File file2) throws IOException {
        String str = TAG;
        AdvLog.Log(str, "Copy from: " + file.getAbsolutePath() + " to: " + file2.getAbsolutePath());
        if (file.isDirectory()) {
            checkFolder(file2);
            String[] list = file.list();
            if (list != null && list.length != 0) {
                for (String str2 : list) {
                    copyFolder(new File(file, str2), new File(file2, str2));
                }
                return;
            }
            AdvLog.Log(str, "files is empty and can't do copy");
            return;
        }
        AdvLog.Log(str, "Copy file from: " + file.getAbsolutePath() + " to: " + file2.getAbsolutePath());
        copySingleFile(file, file2);
    }

    public static void copySingleFile(String str, String str2) throws IOException {
        if (str != null && str2 != null) {
            copySingleFile(new File(str), new File(str2));
            return;
        }
        throw new IOException("path is Null, srcPath=" + str + ",destPath=" + str2);
    }

    public static boolean copyToFile(InputStream inputStream, File file) {
        FileDescriptor fd;
        try {
            if (file.exists() && !file.delete()) {
                AdvLog.Log(TAG, "Delete file failed!");
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read < 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    fd = fileOutputStream.getFD();
                } catch (IOException unused) {
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                fileOutputStream.flush();
                fd = fileOutputStream.getFD();
            }
            fd.sync();
            fileOutputStream.close();
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static void deleteFile(String str) {
        if (str != null && !"".equals(str)) {
            deleteFile(new File(str));
        } else {
            AdvLog.Log(TAG, "File path is null or not exist, delete file fail!");
        }
    }

    public static String getFileContent(File file) throws IOException {
        long length = file.length();
        if (length > 32767) {
            length = 32767;
        }
        StringBuilder sb = new StringBuilder((int) length);
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                        sb.append('\n');
                    } else {
                        bufferedReader2.close();
                        return sb.toString();
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] getFileData(String str) throws IOException {
        return getFileData(new File(str));
    }

    public static byte[] getPkgFileData(Context context, String str) throws IOException {
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(context.openFileInput(str));
            try {
                byte[] streamData = getStreamData(bufferedInputStream2);
                close(bufferedInputStream2);
                return streamData;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                close(bufferedInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] getStreamData(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream2.write(bArr, 0, read);
                    } else {
                        byteArrayOutputStream2.flush();
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        close(byteArrayOutputStream2);
                        return byteArray;
                    }
                }
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                close(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void saveFile(byte[] bArr, String str) throws IOException {
        if (bArr == null) {
            throw new IOException("data is null");
        }
        if (str != null) {
            File parentFile = new File(str).getParentFile();
            if (checkFolder(parentFile)) {
                BufferedOutputStream bufferedOutputStream = null;
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str));
                    try {
                        bufferedOutputStream2.write(bArr);
                        close(bufferedOutputStream2);
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        close(bufferedOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                throw new IOException("Create Folder(" + parentFile.getAbsolutePath() + ") Failed!");
            }
        } else {
            throw new IOException("path is null");
        }
    }

    public static void writeFileContent(File file, String str) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(str.getBytes("utf-8"));
            fileOutputStream.flush();
        } finally {
            fileOutputStream.close();
        }
    }

    public static boolean checkFolder(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            return true;
        }
        return file.mkdirs();
    }

    public static void close(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            outputStream.close();
        }
    }

    public static byte[] getFileData(File file) throws IOException {
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                byte[] streamData = getStreamData(bufferedInputStream2);
                close(bufferedInputStream2);
                return streamData;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                close(bufferedInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    public static void copySingleFile(File file, File file2) throws IOException {
        File parentFile = file2.getParentFile();
        ?? checkFolder = checkFolder(parentFile);
        if (checkFolder != 0) {
            InputStream inputStream = null;
            BufferedOutputStream bufferedOutputStream = null;
            try {
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file2));
                        try {
                            byte[] bArr = new byte[8192];
                            while (true) {
                                int read = bufferedInputStream.read(bArr);
                                if (read != -1) {
                                    bufferedOutputStream2.write(bArr, 0, read);
                                } else {
                                    bufferedOutputStream2.flush();
                                    bufferedOutputStream2.close();
                                    close(bufferedInputStream);
                                    return;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            bufferedOutputStream = bufferedOutputStream2;
                            bufferedOutputStream.close();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = checkFolder;
                    close(inputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                close(inputStream);
                throw th;
            }
        } else {
            throw new IOException("Create Folder(" + parentFile.getAbsolutePath() + ") Failed!");
        }
    }

    public static void deleteFile(File file) {
        if (file != null && file.exists()) {
            if (file.isDirectory()) {
                deleteFile(file.listFiles());
            }
            if (file.delete()) {
                return;
            }
            String str = TAG;
            AdvLog.Log(str, "delete (" + file.getPath() + ") failed!");
            return;
        }
        AdvLog.Log(TAG, "File is null or not exist, delete file fail!");
    }

    public static void deleteFile(File[] fileArr) {
        if (fileArr != null && fileArr.length != 0) {
            for (File file : fileArr) {
                deleteFile(file);
            }
            return;
        }
        AdvLog.Log(TAG, "Files is null or empty, delete fail!");
    }
}
