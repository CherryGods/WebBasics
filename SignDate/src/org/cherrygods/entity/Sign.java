package org.cherrygods.entity;

import java.util.Date;

public class Sign {
    int id;
    int userID;
    Date signDate;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Sign(int id, int userID, String userName, Date signDate) {
        this.id = id;
        this.userID = userID;
        this.signDate = signDate;
    }
}
