package exceptions;

import network.Admin;

/**
 * Can't setNetwork to an Admin, Admin can only create a Network
 * */
public class CantSetNetworkAdmin extends Exception {
    private Admin admin; // Member who threw Exception

    public CantSetNetworkAdmin(String message, Admin admin) {
        super(message);
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }
}
