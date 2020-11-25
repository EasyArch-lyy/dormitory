package com.data.dormitory.common;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.LoggingEvent;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
/**
 * 日志记录
 *
 */
public class MaxDailyRollingFileAppender extends DailyRollingFileAppender {

    protected int maxBackupIndex = 1;

    private Long nextCheckFieldValue = 0L;
    private static Field nextCheckField = null;

    static {
        try {
            nextCheckField = DailyRollingFileAppender.class.getDeclaredField("nextCheck");
            nextCheckField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            LogLog.error("can not get nextCheck field", e);
        }
    }

    public int getMaxBackupIndex() {
        return maxBackupIndex;
    }

    public void setMaxBackupIndex(int maxBackupIndex) {
        if (maxBackupIndex >= 1) {
            this.maxBackupIndex = maxBackupIndex;
        }
    }

    /**
     * The default constructor does nothing.
     */
    public MaxDailyRollingFileAppender() {
        super();
        checkRollOver();
    }

    public MaxDailyRollingFileAppender(Layout layout, String filename,
                                       String datePattern) throws IOException {
        super(layout, filename, datePattern);
        checkRollOver();
    }

    private boolean checkRollOver() {
        if (nextCheckField == null) {
            return false;
        }
        try {
            Object o = nextCheckField.get(this);
            if (!(o instanceof Long)) {
                return false;
            }
            Long newValue = (Long) o;
            if (!nextCheckFieldValue.equals(newValue)) {
                nextCheckFieldValue = newValue;
                return true;
            }
        } catch (IllegalAccessException e) {
            LogLog.error("checkRollOver failed", e);
        }
        return false;
    }

    protected void subAppend(LoggingEvent event) {
        super.subAppend(event);
        if (getDatePattern() != null && checkRollOver()) {
            removeMaxBackupFile();
        }
    }

    /**
     * Rollover the current file to a new file.
     */
    void removeMaxBackupFile() {
        List<ModifiedTimeSortableFile> files = getAllFiles();
        Collections.sort(files);
        if (files.size() >= (maxBackupIndex + 1)) {
            int index = 0;
            // 已经新增一个
            int diff = files.size() - maxBackupIndex;
            for (ModifiedTimeSortableFile file : files) {
                if (index >= diff)
                    break;

                file.delete();
                index++;
            }
        }
        LogLog.debug("maxBackupIndex=" + maxBackupIndex);
        // call super datapatten
    }

    /**
     * This method searches list of log files
     * based on the pattern given in the log4j configuration file
     * and returns a collection
     *
     * @return List&lt;ModifiedTimeSortableFile&gt;
     */
    private List<ModifiedTimeSortableFile> getAllFiles() {
        List<ModifiedTimeSortableFile> files = new ArrayList<ModifiedTimeSortableFile>();
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                String directoryName = dir.getPath();
                LogLog.debug("directory name: " + directoryName);
                File file = new File(fileName);
                String perentDirectory = file.getParent();
                if (perentDirectory != null) {
                    // String localFile = fileName.substring(directoryName.length());
                    String localFile = file.getName();
                    return name.startsWith(localFile);
                }
                return name.startsWith(fileName);
            }
        };
        File file = new File(fileName);
        String perentDirectory = file.getParent();
        if (file.exists() && file.getParent() == null) {
            String absolutePath = file.getAbsolutePath();
            perentDirectory = absolutePath.substring(0, absolutePath.lastIndexOf(fileName));
        }
        File dir = new File(perentDirectory);
        String[] names = dir.list(filter);

        for (int i = 0; i < Objects.requireNonNull(names).length; i++) {
            files.add(new ModifiedTimeSortableFile(dir + File.separator + names[i]));
        }
        return files;
    }
}

class ModifiedTimeSortableFile extends File implements Serializable, Comparable<File> {
    private static final long serialVersionUID = 1373373728209668895L;

    public ModifiedTimeSortableFile(String parent, String child) {
        super(parent, child);
    }

    public ModifiedTimeSortableFile(URI uri) {
        super(uri);
    }

    public ModifiedTimeSortableFile(File parent, String child) {
        super(parent, child);
    }

    public ModifiedTimeSortableFile(String string) {
        super(string);
    }

    @Override
    public int compareTo(File anotherPathName) {
        long thisVal = this.lastModified();
        long anotherVal = anotherPathName.lastModified();
        return (Long.compare(thisVal, anotherVal));
    }
}
