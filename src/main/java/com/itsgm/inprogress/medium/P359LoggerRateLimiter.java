package com.itsgm.inprogress.medium;

import java.util.HashMap;
import java.util.Map;

public class P359LoggerRateLimiter {

    static class Logger {

        private Map<String, Integer> messageTimestamps = new HashMap<>();

        public Logger() {

        }

        public boolean shouldPrintMessage(int timestamp, String message) {

            Integer previousTimestamp = messageTimestamps.get(message);

            if (previousTimestamp == null) {
                messageTimestamps.put(message, timestamp);
                return true;
            } else {
                if (timestamp - previousTimestamp >= 10) {
                    messageTimestamps.put(message, timestamp);
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
}
