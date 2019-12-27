package com.cmb.file.updatefile.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

    public DateUtils() {
    }

    public static final Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }

    public static final String getCurrentDateAsString() {
        return getCurrentDateAsString("yyyy-MM-dd");
    }

    public static final String getCurrentDateAsString(String formatPattern) {
        Date date = getCurrentDate();
        return format(date, formatPattern);
    }

    public static final String format(Date date, String formatPattern) {
        return date == null ? "" : (new SimpleDateFormat(formatPattern)).format(date);
    }

    public static final String format(Date date) {
        return format(date, "yyyy-MM-dd");
    }

    public static final String formatDateTime(Date date) {
        return date == null ? "" : format(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static final Date parse(String dateStr) {
        return parse(dateStr, "yyyy-MM-dd");
    }

    public static final Date parse(String stringValue, String formatPattern) {
        SimpleDateFormat format = new SimpleDateFormat(formatPattern);

        try {
            return format.parse(stringValue);
        } catch (ParseException var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public static final Date parseTimestamp(String date) {
        return date == null ? null : parse(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static Timestamp parseTimestamp(Date d) {
        return new Timestamp(d.getTime());
    }

    public static Timestamp parseTimestamp(String stringValue, String formatPattern) {
        return new Timestamp(parse(stringValue, formatPattern).getTime());
    }

    public static final Date tryParse(String stringValue) {
        Date date = parse(stringValue, "yyyy-MM-dd");
        if (date != null) {
            return date;
        } else {
            date = parse(stringValue, "yyyyMMdd");
            if (date != null) {
                return date;
            } else {
                date = parse(stringValue, "yyyyMMddHHmmss");
                if (date != null) {
                    return date;
                } else {
                    date = parse(stringValue, "yyyy-MM-dd HH:mm:ss");
                    if (date != null) {
                        return date;
                    } else {
                        date = parse(stringValue, "yyyy-MM-dd HHmm");
                        if (date != null) {
                            return date;
                        } else {
                            date = parse(stringValue, "yyyy/MM/dd");
                            if (date != null) {
                                return date;
                            } else {
                                date = parse(stringValue, "yyyy/M/dd");
                                if (date != null) {
                                    return date;
                                } else {
                                    date = parse(stringValue, "yyyy/MM/d");
                                    if (date != null) {
                                        return date;
                                    } else {
                                        date = parse(stringValue, "yyyy/M/d");
                                        return date != null ? date : date;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static final int compareDate(String stringValue1, String stringValue2) throws ParseException {
        Date date1 = tryParse(stringValue1);
        if (date1 == null) {
            throw new ParseException("Can not parse " + stringValue1 + " to Date.", 0);
        } else {
            Date date2 = tryParse(stringValue2);
            if (date2 == null) {
                throw new ParseException("Can not parse " + stringValue1 + " to Date.", 0);
            } else {
                return date1.compareTo(date2);
            }
        }
    }

    public static final long compareDateToMin(String stringValue1) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = Calendar.getInstance().getTime();
        Date date = df.parse(stringValue1);
        long l = now.getTime() - date.getTime();
        return l / 60000L;
    }

    public static int getDayOfWeek(int sunFstDayOfWeek) {
        if (sunFstDayOfWeek <= 7 && sunFstDayOfWeek >= 1) {
            return sunFstDayOfWeek == 1 ? 7 : sunFstDayOfWeek - 1;
        } else {
            return 0;
        }
    }

    public static boolean isSameDay(Date date1, Date date2) {
        if (date1 != null && date2 != null) {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);
            return isSameDay(cal1, cal2);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }

    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 != null && cal2 != null) {
            return cal1.get(0) == cal2.get(0) && cal1.get(1) == cal2.get(1) && cal1.get(6) == cal2.get(6);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }

    public static boolean isSameMonth(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        boolean isSameYear = cal1.get(1) == cal2.get(1);
        boolean isSameMonth = isSameYear && cal1.get(2) == cal2.get(2);
        return isSameYear && isSameMonth;
    }

    public static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(calendarField, amount);
            return c.getTime();
        }
    }

    public static Date addMinutes(Date date, int amount) {
        return add(date, 12, amount);
    }

    public static Date addMilliseconds(Date date, long amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else {
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(date.getTime() + amount);
            return c.getTime();
        }
    }

    public static Date getFirstDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(2);
        c.setTime(date);
        c.set(7, c.getFirstDayOfWeek());
        return c.getTime();
    }

    public static Date getLastDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(1);
        calendar.setTime(date);
        calendar.set(7, calendar.getFirstDayOfWeek() + 6);
        return calendar.getTime();
    }

    public static Date addWeekDayOfWeek(Date currentDate, int week) {
        Calendar c = new GregorianCalendar();
        c.setTime(currentDate);
        c.add(3, week);
        return c.getTime();
    }

    public static Date getDateBefore(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(5, now.get(5) - day);
        return now.getTime();
    }

    public static Date getDateAfter(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(5, now.get(5) + day);
        return now.getTime();
    }

    public static Date getNextDate(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        cd.add(5, 1);
        return cd.getTime();
    }

    public static Date getStartOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date getEndOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }
}
