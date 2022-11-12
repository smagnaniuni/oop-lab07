package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    private enum Month {
        JANUARY("january", 31),
        FEBRUARY("february", 28),
        MARCH("march", 31),
        APRIL("april", 30),
        MAY("may", 31),
        JUNE("june", 30),
        JULY("july", 31),
        AUGUST("august", 31),
        SEPTEMBER("september", 30),
        OCTOBER("october", 31),
        NOVEMBER("november", 30),
        DECEMBER("december", 31);

        private final String monthName;
        private final int monthDays;

        private Month(final String monthName, final int monthDays) {
            this.monthName = monthName;
            this.monthDays = monthDays;
        }

        public static Month fromString(final String name) {
            Month res = null;
            for (final Month month : Month.values()) {
                if (month.monthName.contains(name.toLowerCase())) {
                    if (res != null) {
                        throw new IllegalArgumentException("Ambiguos: " + name + " matches both " + res + " and " + month);
                    }
                    res = month;
                }
            }
            if(res == null) {
                throw new IllegalArgumentException("Not found: " + name);
            }
            return res;
        }

        public int getDays() {
            return this.monthDays;
        }
    }

    @Override
    public Comparator<String> sortByDays() {
        return null;
    }

    @Override
    public Comparator<String> sortByOrder() {
        return null;
    }
}
