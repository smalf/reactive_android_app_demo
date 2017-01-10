package com.demo.smalf.reactiveandroidappdemo.logging;

/**
 * Provides API to append messages to log output.
 *
 * @author Serhiy Malofeev
 */
public interface Logger {

    /**
     * Logs given message with debug level of logging.
     *
     * @param tag
     * @param msg
     * @return
     */
    int d(String tag, String msg);

    /**
     * Logs given message and throwable with debug level of logging.
     *
     * @param tag
     * @param msg
     * @param tr
     * @return
     */
    int d(String tag, String msg, Throwable tr);

    /**
     * Logs given message with error level of logging.
     *
     * @param tag
     * @param msg
     * @return
     */
    int e(String tag, String msg);

    /**
     * Logs given message and throwable with error level of logging.
     *
     * @param tag
     * @param msg
     * @param tr
     * @return
     */
    int e(String tag, String msg, Throwable tr);

    /**
     * Logs given message with info level of logging.
     *
     * @param tag
     * @param msg
     * @return
     */
    int i(String tag, String msg);

    /**
     * Logs given message and throwable with info level of logging.
     *
     * @param tag
     * @param msg
     * @param tr
     * @return
     */
    int i(String tag, String msg, Throwable tr);

    /**
     * Logs given message with verbose level of logging.
     *
     * @param tag
     * @param msg
     * @return
     */
    int v(String tag, String msg);

    /**
     * Logs given message and throwable with verbose level of logging.
     *
     * @param tag
     * @param msg
     * @param tr
     * @return
     */
    int v(String tag, String msg, Throwable tr);

    /**
     * Logs given throwable with warning level of logging.
     *
     * @param tag
     * @param tr
     * @return
     */
    int w(String tag, Throwable tr);

    /**
     * Logs given message and throwable with warning level of logging.
     *
     * @param tag
     * @param msg
     * @param tr
     * @return
     */
    int w(String tag, String msg, Throwable tr);

    /**
     * Logs given message with warning level of logging.
     *
     * @param tag
     * @param msg
     * @return
     */
    int w(String tag, String msg);

}
