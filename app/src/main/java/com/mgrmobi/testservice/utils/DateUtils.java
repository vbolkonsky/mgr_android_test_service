package com.mgrmobi.testservice.utils;

import android.content.Context;
import android.support.annotation.StringRes;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Valentin S. Bolkonsky.
 *         Proud to Code for Magora Systems/magora-systems.com/magora-systems.ru
 */
public class DateUtils {

    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);

    private DateUtils() {

    }

    public static Date getDateFromString(final Context context, final String formatted, final @StringRes int template) {
        if (StringUtils.isBlank(formatted)) {
            return null;
        }
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(context.getString(template), Locale.getDefault());
        try {
            return simpleDateFormat.parse(formatted);
        } catch (ParseException e) {
            logger.error("parse error", e);
            return null;
        }
    }

    public static String getStringFromDate(final Context context, final Date date, final @StringRes int template) {
        if (date == null) {
            return null;
        }
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(context.getString(template), Locale.getDefault());
        return simpleDateFormat.format(date);
    }
}
