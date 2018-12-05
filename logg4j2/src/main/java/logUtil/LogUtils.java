package logUtil;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/11/26 9:30
 */
public class LogUtils {
    /**
     *@description
     * 获取业务日志logger
     *@param
     *@return
     *@anthor  10068921(lgyTT)
     *@date  2018/11/26
     *@other
     */
    public static Logger getBussinessLogger(){
        return LogManager.getLogger(LogEnum.BUSSINESS.getCategory());
    }
    /**
     *@description
     * 获取平台日志logger
     *@param
     *@return
     *@anthor  10068921(lgyTT)
     *@date  2018/11/26
     *@other
     */
    public  static Logger getPaltformLogger(){
        return LogManager.getLogger(LogEnum.PLATFORM.getCategory());
    }
    /**
     *@description
     * 获取数据库日志logger
     *@param
     *@return
     *@anthor  10068921(lgyTT)
     *@date  2018/11/26
     *@other
     */
    public static Logger getDBLogger(){
        String name=LogEnum.DB.getCategory();
        return LogManager.getLogger(name);
    }
    /**
     *@description
     * 获取异常日志logger
     *@param
     *@return
     *@anthor  10068921(lgyTT)
     *@date  2018/11/26
     *@other
     */
    public static Logger getExceptionLogger(){
        return LogManager.getLogger(LogEnum.EXCEPTION.getCategory());
    }
}
