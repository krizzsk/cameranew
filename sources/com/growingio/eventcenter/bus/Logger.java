package com.growingio.eventcenter.bus;

import java.io.PrintStream;
import java.util.logging.Level;
/* loaded from: classes2.dex */
interface Logger {

    /* loaded from: classes2.dex */
    public static class JavaLogger implements Logger {
        protected final java.util.logging.Logger logger;

        public JavaLogger(String str) {
            this.logger = java.util.logging.Logger.getLogger(str);
        }

        @Override // com.growingio.eventcenter.bus.Logger
        public void log(Level level, String str) {
            this.logger.log(level, str);
        }

        @Override // com.growingio.eventcenter.bus.Logger
        public void log(Level level, String str, Throwable th) {
            this.logger.log(level, str, th);
        }
    }

    /* loaded from: classes2.dex */
    public static class SystemOutLogger implements Logger {
        @Override // com.growingio.eventcenter.bus.Logger
        public void log(Level level, String str) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
        }

        @Override // com.growingio.eventcenter.bus.Logger
        public void log(Level level, String str, Throwable th) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
            th.printStackTrace(System.out);
        }
    }

    void log(Level level, String str);

    void log(Level level, String str, Throwable th);
}
