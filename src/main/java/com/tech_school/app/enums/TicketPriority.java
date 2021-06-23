package com.tech_school.app.enums;

public enum TicketPriority {

        LOW(100, "low"),
        MEDIUM(200, "medium"),
        HIGH(300, "high"),
        HIGHEST(400, "highest");

        public final int priorityLevel;
        public final String name;
        private TicketPriority(int priorityLevel,String name) {
            this.priorityLevel = priorityLevel;
            this.name = name;
        }

        public static int i(String text) {
                for (TicketPriority b : TicketPriority.values()) {
                        if (String.valueOf(b.name).equals(text)) {
                                return b.priorityLevel;
                        }
                }
                return 0;
        }

        public static String name(int level) {
                for (TicketPriority b : TicketPriority.values()) {
                        if (level == b.priorityLevel) {
                                return b.name;
                        }
                }
                return null;
        }

}

