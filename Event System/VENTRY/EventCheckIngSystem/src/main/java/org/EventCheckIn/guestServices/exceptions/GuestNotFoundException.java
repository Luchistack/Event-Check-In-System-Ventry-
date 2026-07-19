package org.EventCheckIn.guestServices.exceptions;

public class GuestNotFoundException extends RuntimeException {
    public GuestNotFoundException(String guestId) {
        super("Guest not found for id: " + guestId);
    }

    public GuestNotFoundException(String field, String value) {
        super("Guest not found for " + field + ": " + value);
    }
}
