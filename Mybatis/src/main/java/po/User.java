package po;/*
 *@author 10068921(LgyTT@alog.com)
 *@date 2018/8/15 17:51
 *@description:

 */

public class User {
    private Integer userId;
    private String userName;
    private String password;
    private String phone;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User(Integer userId, String userName, String password, String phone) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
    }
    public String toString(){
        return "User [id=" + userId + ", username=" + userName+ ", password=" + password
                + ", phone=" + phone+ "]";

    }

}
