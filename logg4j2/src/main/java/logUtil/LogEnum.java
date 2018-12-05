package logUtil;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/11/26 9:32
 */
public enum LogEnum {
    BUSSINESS("bussiness"),
    PLATFORM("platform"),
    DB("Connection_sql"),
    EXCEPTION("exception");
    private String category;

    LogEnum(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
